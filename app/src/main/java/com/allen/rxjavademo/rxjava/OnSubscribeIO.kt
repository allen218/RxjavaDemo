package com.allen.rxjavademo.rxjava

import java.util.concurrent.Executors

/**
 * Created by allen on 19/4/25.
 */
class OnSubscribeIO<T>(val observable: Observable<T>) : ObservableOnSubscribe<T> {

    val threadPool = Executors.newCachedThreadPool()

    override fun subscribe(t: Observer<in T>) {
        threadPool.submit {
            observable.subscribe(t)
        }
    }
}