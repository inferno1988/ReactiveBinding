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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsBaseListener;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsLexer;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsListenerImpl;
import org.ifno_software.reactivebinding.parser.ReactiveExpressionsParser;

import rx.Observable;
import rx.observables.ConnectableObservable;

/**
 * Created by atom on 2/2/16.
 */
public class ReactiveBinding {
    public static void bind(ViewGroup viewGroup, NotifyPropertyChanged viewModel) {
        final Observable<PropertyChangedEvent> connectableObservable = viewModel.toObservable();
        final int childCount = viewGroup.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = viewGroup.getChildAt(i);
            enrichView(child, viewModel);

            if (child instanceof ViewGroup)
                bind((ViewGroup) child, viewModel);
        }

    }

    private static void enrichView(View child, NotifyPropertyChanged viewModel) {
        final Class<? extends View> childClass = child.getClass();
        if (TextView.class.isAssignableFrom(childClass)) {
            final TextView textView = (TextView) child;
            final String text = textView.getText().toString();

            final ANTLRInputStream antlrInputStream = new ANTLRInputStream(text);
            ReactiveExpressionsLexer lexer = new ReactiveExpressionsLexer(antlrInputStream);
            final CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
            ReactiveExpressionsParser parser = new ReactiveExpressionsParser(commonTokenStream);
            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
            parseTreeWalker.walk(new ReactiveExpressionsListenerImpl(viewModel, textView), parser.evaluatoinUnit());
        }
    }


}
