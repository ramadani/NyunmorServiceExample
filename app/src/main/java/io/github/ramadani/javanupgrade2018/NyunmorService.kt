package io.github.ramadani.javanupgrade2018

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * Created by dani on 1/16/18.
 */
class NyunmorService(name: String? = "nyunmor-service") : IntentService(name) {
    companion object {
        val TAG = NyunmorService::class.java.simpleName
    }

    override fun onHandleIntent(intent: Intent?) {
        val nyunVal = intent?.getStringExtra("nyun")
        Log.d(TAG, "message from Nyunmor Planet")
        Log.d(TAG, "value from nyun extra: $nyunVal")
    }
}