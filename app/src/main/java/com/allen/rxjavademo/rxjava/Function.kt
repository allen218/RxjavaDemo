package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/23.
 */
interface Function<T, R> {
    fun apply(t: T): R
}