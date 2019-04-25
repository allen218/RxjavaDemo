package com.allen.rxjavademo.rxjava

/**
 * Created by allen on 19/4/22.
 */
class Observable<T>(val onSubscribe: ObservableOnSubscribe<T>) {

    companion object {
        fun <T> create(onSubscribe: ObservableOnSubscribe<T>): Observable<T> {
            return Observable(onSubscribe)
        }
    }

    fun subscribe(observer: Observer<in T>) {
        onSubscribe.subscribe(observer)
    }

    fun <R> map(function: Function<in T, out R>): Observable<R> {
        return Observable(OnSubscribeLift(onSubscribe, function))
    }

    fun subscirbeMain(): Observable<T> {
        return Observable(OnSubcribeMain(this))
    }

    fun subscirbeIO(): Observable<T> {
        return Observable(OnSubscribeIO(this))
    }
}