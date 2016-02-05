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

package org.ifno_software.rxbinding.parser.parser;

import android.view.View;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.ifno_software.rxbinding.NotifyPropertyChanged;
import org.ifno_software.rxbinding.PropertyChangedEvent;
import org.ifno_software.rxbinding.annotations.RxGetProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by atom on 2/3/16.
 */
public class ReactiveExpressionsListenerImpl extends ReactiveExpressionsBaseListener {
    private NotifyPropertyChanged viewModel;
    private final View view;
    private final String attributeName;

    public ReactiveExpressionsListenerImpl(NotifyPropertyChanged viewModel, View view, String attributeName) {
        this.viewModel = viewModel;
        this.view = view;
        this.attributeName = attributeName;
    }

    @Override
    public void exitEvaluationUnit(ReactiveExpressionsParser.EvaluationUnitContext ctx) {
        if (ctx.action().SUBSCRIBE() != null) {

            final TerminalNode identifier = ctx.Identifier();
            if (identifier != null) {
                final String propertyName = identifier.getText();
                getValueFromViewModelAndSetToView(viewModel, view, propertyName, attributeName);

                viewModel.toObservable()
                        .ofType(PropertyChangedEvent.class)
                        .filter(event -> event.getPropertyName().equals(propertyName))
                        .subscribe((event) -> {
                            getValueFromViewModelAndSetToView(viewModel, view, propertyName, attributeName);
                        });
            }

            final ReactiveExpressionsParser.BindExpressionContext bindExpressionContext = ctx.bindExpression();
            if (bindExpressionContext != null) {
                final String attrName = bindExpressionContext.attrName().getText();
                final String propertyName = bindExpressionContext.propertyName().getText();
                getValueFromViewModelAndSetToView(viewModel, view, propertyName, attrName);

                viewModel.toObservable()
                        .ofType(PropertyChangedEvent.class)
                        .filter(event -> event.getPropertyName().equals(propertyName))
                        .subscribe((event) -> {
                            getValueFromViewModelAndSetToView(viewModel, view, propertyName, attrName);
                        });
            }
        }
    }

    private static void getValueFromViewModelAndSetToView(Object viewModel, View view, String propertyName, String attributeName) {
        Class<?> declaringClass = viewModel.getClass().getDeclaringClass();
        if (declaringClass == null)
            declaringClass = viewModel.getClass();

        final Method[] methods = declaringClass.getMethods();
        for (Method viewModelMethod : methods) {
            if (viewModelMethod.isAnnotationPresent(RxGetProperty.class)) {
                final RxGetProperty annotation = viewModelMethod.getAnnotation(RxGetProperty.class);
                if (annotation.value().equals(propertyName)) {
                    try {
                        final Object valueFromViewModel = viewModelMethod.invoke(viewModel);
                        for (Method viewMethod : view.getClass().getMethods()) {
                            final String setterName = "set" + capitalize(attributeName);
                            final Class<?>[] viewMethodParameterTypes = viewMethod.getParameterTypes();

                            if (setterName.equals(viewMethod.getName()) && viewMethodParameterTypes.length == 1) {
                                if (viewMethodParameterTypes[0].isAssignableFrom(viewModelMethod.getReturnType())) {
                                    viewMethod.invoke(view, valueFromViewModel);
                                } else if (viewMethodParameterTypes[0].isPrimitive()) {
                                    try {
                                        viewMethod.invoke(view, valueFromViewModel);
                                    } catch (IllegalArgumentException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
