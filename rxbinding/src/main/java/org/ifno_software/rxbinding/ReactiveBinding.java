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

package org.ifno_software.rxbinding;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by atom on 2/2/16.
 */
public class ReactiveBinding {

    public static View bind(Context context, ViewGroup rootView, @LayoutRes int layoutId, NotifyPropertyChanged viewModel) {
        final LayoutInflater baseInflater = LayoutInflater.from(context);
        final LayoutInflater inflater = baseInflater.cloneInContext(context);

        final BindingFactory factory2 = new BindingFactory(baseInflater, viewModel);

        inflater.setFactory2(factory2);

        return inflater.inflate(layoutId, rootView, false);
    }
}
