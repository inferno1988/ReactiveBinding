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

import org.ifno_software.rxbinding.NotifyPropertyChanged;
import org.ifno_software.rxbinding.PropertyChangedEvent;
import org.ifno_software.rxbinding.annotations.RxGetProperty;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * Created by atom on 2/2/16.
 */
public class HelloWorldViewModel implements NotifyPropertyChanged {
    private String greeting = "Hello world";
    private Subscriber<? super PropertyChangedEvent> subscriber;
    private ConnectableObservable<PropertyChangedEvent> observable;
    private Integer progress = 30;

    @RxGetProperty("helloWorld")
    public String getGreeting() {
        return greeting;
    }

    @RxGetProperty("progress")
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
        onPropertyChanged("progress");
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
        onPropertyChanged("helloWorld");
    }

    @Override
    public void onPropertyChanged(String name) {
        if (subscriber != null) {
            subscriber.onNext(new PropertyChangedEvent(name));
        }
    }

    @Override
    public Observable<PropertyChangedEvent> toObservable() {
        if (observable == null) {
            observable = Observable.<PropertyChangedEvent>create(subscriber1 -> this.subscriber = subscriber1)
                    .publish();
            observable.connect();
        }

        return observable;
    }
}
