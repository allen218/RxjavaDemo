package com.allen.rxjavademo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.allen.rxjavademo.rxjava.Function
import com.allen.rxjavademo.rxjava.Observable
import com.allen.rxjavademo.rxjava.ObservableOnSubscribe
import com.allen.rxjavademo.rxjava.Observer

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "allen"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(observer: Observer<in String>) {
                observer.onNext("test")
                observer.onCompleted()
            }

        })
            .subscirbeIO()
            .subscirbeMain()
            .map(object : Function<String, Int> {
                override fun apply(t: String): Int {
                    return 1
                }

            }).subscribe(object : Observer<Int>() {
                override fun onNext(t: Int) {
                    Log.i(TAG, "current thread: ${Thread.currentThread().name}")
                    Log.i(TAG, "current value: $t")
                }

                override fun onError(t: Throwable) {
                }

                override fun onCompleted() {
                    Log.i(TAG, "onCompleted()")
                }
            })
    }
}
