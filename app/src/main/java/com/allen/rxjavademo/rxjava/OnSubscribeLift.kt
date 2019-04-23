package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/23.
 */
class OnSubscribeLift<T, R>(
    val parent: ObservableOnSubscribe<T>,
    function: Function<in T, out R>,
    val operator: Operator<out R, in T> = OperatorMap(function)
) : ObservableOnSubscribe<R> {


    override fun subscribe(observer: Observer<in R>) {
        val newObserver = operator.apply(observer)
        parent.subscribe(newObserver)

    }
}