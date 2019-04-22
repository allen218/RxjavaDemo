package com.allen.rxjavademo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
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

        }).subscribe(object : Observer<String>() {
            override fun onNext(t: String) {
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
