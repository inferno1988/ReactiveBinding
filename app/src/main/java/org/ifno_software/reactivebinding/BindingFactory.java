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

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.ifno_software.reactivebinding.annotations.RxGetProperty;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsLexer;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsListenerImpl;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Observable;

/**
 * Created by atom on 2/2/16.
 */
public class BindingFactory implements LayoutInflater.Factory2 {

    private final LayoutInflater.Factory2 factory2;
    private final LayoutInflater layoutInflater;
    private final LayoutInflater.Filter filter;
    private final NotifyPropertyChanged viewModel;

    private HashMap<String, Boolean> mFilterMap = null;
    private final Object[] mConstructorArgs = new Object[2];

    public BindingFactory(LayoutInflater layoutInflater, NotifyPropertyChanged viewModel) {
        this.viewModel = viewModel;
        this.factory2 = layoutInflater.getFactory2();
        this.layoutInflater = layoutInflater;
        this.filter = layoutInflater.getFilter();
    }

    private final HashMap<String, Constructor<? extends View>> sConstructorMap =
            new HashMap<>();
    final Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        mConstructorArgs[0] = context;
        Constructor<? extends View> constructor = sConstructorMap.get(name);

        final boolean isAndroidView = !name.contains(".");
        String viewPrefix = isAndroidView ? "android.view." : null;
        String widgetPrefix = isAndroidView ? "android.widget." : null;

        View view = factory2.onCreateView(parent, name, context, attrs);
        if (view == null) {

            try {
                if (constructor == null) {
                    Class<? extends View> clazz = tryGetClassForNameWithPrefix(name, context, viewPrefix);
                    if (clazz == null)
                        clazz = tryGetClassForNameWithPrefix(name, context, widgetPrefix);
                    if (clazz == null)
                        clazz = tryGetClassForNameWithPrefix(name, context, null);

                    if (filter != null && clazz != null) {
                        boolean allowed = filter.onLoadClass(clazz);
                        if (!allowed) {
                            failNotAllowed(name, viewPrefix, attrs);
                        }
                    }

                    if (clazz == null)
                        return null;

                    constructor = clazz.getConstructor(mConstructorSignature);
                    constructor.setAccessible(true);
                    sConstructorMap.put(name, constructor);
                } else {
                    if (filter != null) {
                        // Have we seen this name before?
                        Boolean allowedState = mFilterMap.get(name);
                        if (allowedState == null) {
                            Class<? extends View> clazz = tryGetClassForNameWithPrefix(name, context, viewPrefix);
                            if (clazz == null)
                                clazz = tryGetClassForNameWithPrefix(name, context, widgetPrefix);
                            if (clazz == null)
                                clazz = tryGetClassForNameWithPrefix(name, context, null);

                            boolean allowed = clazz != null && filter.onLoadClass(clazz);
                            mFilterMap.put(name, allowed);
                            if (!allowed) {
                                failNotAllowed(name, viewPrefix, attrs);
                            }
                        } else if (allowedState.equals(Boolean.FALSE)) {
                            failNotAllowed(name, viewPrefix, attrs);
                        }
                    }
                }

                Object[] args = mConstructorArgs;
                args[1] = attrs;

                view = constructor.newInstance(args);
                if (view instanceof ViewStub) {
                    // Use the same context when inflating ViewStub later.
                    final ViewStub viewStub = (ViewStub) view;
                    viewStub.setLayoutInflater(layoutInflater.cloneInContext((Context) args[0]));
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        bindView(view, attrs, viewModel);

        return view;
    }

    private void bindView(View view, AttributeSet attrs, NotifyPropertyChanged viewModel) {
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            final String attributeValue = attrs.getAttributeValue(i);
            final String attributeName = attrs.getAttributeName(i);
            if (attributeValue.startsWith("{") && attributeValue.endsWith("}")) {

                final ANTLRInputStream antlrInputStream = new ANTLRInputStream(attributeValue);
                ReactiveExpressionsLexer lexer = new ReactiveExpressionsLexer(antlrInputStream);
                final CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                ReactiveExpressionsParser parser = new ReactiveExpressionsParser(commonTokenStream);
                ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
                parseTreeWalker.walk(new ReactiveExpressionsListenerImpl(viewModel, view, attributeName), parser.evaluationSequence());
            }
        }
    }

    private Class<? extends View> tryGetClassForNameWithPrefix(String name, Context context, String viewPrefix) {
        try {
             return context.getClassLoader().loadClass(
                    viewPrefix != null ? (viewPrefix + name) : name).asSubclass(View.class);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        final View view = factory2.onCreateView(name, context, attrs);
        if (view != null)
            view.setBackgroundColor(Color.parseColor("#00FF00"));
        return view;
    }

    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        throw new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
    }
}
