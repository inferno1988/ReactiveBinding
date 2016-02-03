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

package org.ifno_software.reactivebinding.parser;

import android.view.View;
import android.widget.TextView;

import org.ifno_software.reactivebinding.NotifyPropertyChanged;
import org.ifno_software.reactivebinding.PropertyChangedEvent;
import org.ifno_software.reactivebinding.annotations.RxGetProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import rx.Observable;

/**
 * Created by atom on 2/3/16.
 */
public class ReactiveExpressionsListenerImpl extends ReactiveExpressionsBaseListener {
    private NotifyPropertyChanged viewModel;
    private final View view;

    public ReactiveExpressionsListenerImpl(NotifyPropertyChanged viewModel, View view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    @Override
    public void exitEvaluatoinUnit(ReactiveExpressionsParser.EvaluatoinUnitContext ctx) {
        if (ctx.action().SUBSCRIBE() != null) {
            final String propertyName = ctx.Identifier().getText();
            getTextFromViewModelAndSetToView(viewModel, (TextView) view, propertyName);

            viewModel.toObservable()
                    .ofType(PropertyChangedEvent.class)
                    .filter(event -> event.getPropertyName().equals(propertyName))
                    .subscribe((event) -> {
                        getTextFromViewModelAndSetToView(viewModel, (TextView) view, propertyName);
                    });
        }
    }

    private static void getTextFromViewModelAndSetToView(Object viewModel, TextView textView, String propertyName) {
        Class<?> declaringClass = viewModel.getClass().getDeclaringClass();
        if (declaringClass == null)
            declaringClass = viewModel.getClass();

        final Method[] methods = declaringClass.getMethods();
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
