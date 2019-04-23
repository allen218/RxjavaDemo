package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/23.
 */
class OperatorMap<T, R>(val function: Function<in T, out R>) : Operator<R, T> {
    override fun apply(observer: Observer<in R>): Observer<in T> {
        return MapSubscribe(observer, function)
    }

    inner class MapSubscribe<T, R>(val actual: Observer<R>, val transform: Function<in T, out R>) : Observer<T>() {
        override fun onNext(t: T) {
            val result: R = transform.apply(t)
            actual.onNext(result)
        }

        override fun onError(t: Throwable) {
            actual.onError(t)
        }

        override fun onCompleted() {
            actual.onCompleted()
        }

    }
}