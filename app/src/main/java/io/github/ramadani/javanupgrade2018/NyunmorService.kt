package io.github.ramadani.javanupgrade2018

import android.annotation.SuppressLint
import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.support.v4.os.ResultReceiver
import android.util.Log

/**
 * Created by dani on 1/16/18.
 */
class NyunmorService(name: String? = "nyunmor-service") : IntentService(name) {
    companion object {
        val TAG = NyunmorService::class.java.simpleName
    }

    @SuppressLint("RestrictedApi")
    override fun onHandleIntent(intent: Intent?) {
        val nyunVal = intent?.getStringExtra("nyun")
        Log.d(TAG, "message from Nyunmor Planet")
        Log.d(TAG, "value from nyun extra: $nyunVal")

        val bundle = Bundle()
        val receiver = intent?.getParcelableExtra("receiver") as ResultReceiver
        val resultValue = "This is result from service = $nyunVal Great"
        bundle.putString("resultValue", resultValue)
        receiver.send(Activity.RESULT_OK, bundle)
    }
}