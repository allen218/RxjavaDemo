package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/22.
 */
interface Action1<T> {
    fun subscribe(t: T)
}