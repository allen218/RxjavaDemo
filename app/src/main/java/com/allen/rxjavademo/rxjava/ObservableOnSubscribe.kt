package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/22.
 */
interface ObservableOnSubscribe<T> : Action1<Observer<in T>>