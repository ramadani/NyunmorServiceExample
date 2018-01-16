package io.github.ramadani.javanupgrade2018

import android.os.Bundle
import android.os.Handler
import android.support.v4.os.ResultReceiver

/**
 * Created by dani on 1/16/18.
 */
class NyunmorResultReceiver(handler: Handler?) : ResultReceiver(handler) {
    private var receiver: Receiver? = null

    fun setReceiver(receiver: Receiver) {
        this.receiver = receiver
    }

    interface Receiver {
        fun onReceiveResult(resultCode: Int, resultData: Bundle?)
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        receiver?.onReceiveResult(resultCode, resultData)
    }
}