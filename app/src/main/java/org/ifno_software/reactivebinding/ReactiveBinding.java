/*
 * Copyright 2016 Maksym Palamarchuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifno_software.reactivebinding;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ifno_software.reactivebinding.annotations.RxGetProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import rx.Observable;

/**
 * Created by atom on 2/2/16.
 */
public class ReactiveBinding {
    public static void bind(ViewGroup viewGroup, Observable.OnSubscribe<PropertyChangedEvent> viewModel) {
        final int childCount = viewGroup.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = viewGroup.getChildAt(i);
            enrichView(child, viewModel);

            if (child instanceof ViewGroup)
                bind((ViewGroup) child, viewModel);
        }

    }

    private static void enrichView(View child, Observable.OnSubscribe<PropertyChangedEvent> viewModel) {
        final Class<? extends View> childClass = child.getClass();
        if (TextView.class.isAssignableFrom(childClass)) {
            final TextView textView = (TextView) child;
            final String text = textView.getText().toString();
            if (text.startsWith("{") && text.endsWith("}")) {
                final String[] split = text.replaceAll("\\{|\\}", "").split("\\s");
                getTextFromViewModelAndSetToView(viewModel, textView, split[1]);

                Observable.create(viewModel)
                        .ofType(PropertyChangedEvent.class)
                        .filter(event -> event.getPropertyName().equals(split[1]))
                        .subscribe((event) -> {
                            getTextFromViewModelAndSetToView(viewModel, textView, split[1]);
                        });
            }

        }
    }

    private static void getTextFromViewModelAndSetToView(Object viewModel, TextView textView, String propertyName) {
        final Method[] methods = viewModel.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RxGetProperty.class)) {
                final RxGetProperty annotation = method.getAnnotation(RxGetProperty.class);
                if (annotation.value().equals(propertyName)) {
                    try {
                        textView.setText(method.invoke(viewModel).toString());
                    } catch (IllegalAccessException e) {
                        textView.setText(e.getMessage());
                    } catch (InvocationTargetException e) {
                        textView.setText(e.getMessage());
                    }
                }
            }
        }
    }
}
