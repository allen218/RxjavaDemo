package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/23.
 */
interface Operator<T, R> : Function<Observer<in T>, Observer<in R>>