package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/22.
 */
abstract class Observer<T> {
    abstract fun onNext(t: T)
    abstract fun onError(t: Throwable)
    abstract fun onCompleted()
}