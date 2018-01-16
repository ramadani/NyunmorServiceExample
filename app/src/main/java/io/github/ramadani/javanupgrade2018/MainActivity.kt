package io.github.ramadani.javanupgrade2018

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var nyunReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val resultCode = intent?.getIntExtra("resultCode", Activity.RESULT_CANCELED)
            if (resultCode == Activity.RESULT_OK) {
                val resultValue = intent.getStringExtra("resultValue")
                toast("BroadcastReceiver :: $resultValue")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener { onStartNyunmorService() }
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter(NyunmorService.ACTION)
        LocalBroadcastManager.getInstance(this).registerReceiver(nyunReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(nyunReceiver)
    }

    private fun onStartNyunmorService() {
        val nyunService = Intent(this, NyunmorService::class.java)
        nyunService.putExtra("nyun", "nyunmor biar kuat")
        startService(nyunService)
    }
}
