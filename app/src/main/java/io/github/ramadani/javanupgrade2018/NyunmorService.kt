package io.github.ramadani.javanupgrade2018

import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

/**
 * Created by dani on 1/16/18.
 */
class NyunmorService(name: String? = "nyunmor-service") : IntentService(name) {
    companion object {
        val TAG = NyunmorService::class.java.simpleName
        val ACTION = "io.github.ramadani.javanupgrade2018.NyunmorService"
    }

    override fun onHandleIntent(intent: Intent?) {
        val nyunVal = intent?.getStringExtra("nyun")
        Log.d(TAG, "message from Nyunmor Planet")
        Log.d(TAG, "value from nyun extra: $nyunVal")

        val resultValue = "This is result from service = $nyunVal Great"
        val intent = Intent(ACTION)
        intent.putExtra("resultCode", Activity.RESULT_OK)
        intent.putExtra("resultValue", resultValue)

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}