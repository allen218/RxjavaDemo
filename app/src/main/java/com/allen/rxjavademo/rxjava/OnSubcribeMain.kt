package com.allen.rxjavademo.rxjava

import android.os.Handler
import android.os.Looper


/**
 * Created by allen on 19/4/25.
 */
class OnSubcribeMain<T>(val observable: Observable<T>) : ObservableOnSubscribe<T> {

    val handler: Handler = Handler(Looper.getMainLooper())

    override fun subscribe(t: Observer<in T>) {
        handler.post {
            observable.subscribe(t)
        }
    }
}