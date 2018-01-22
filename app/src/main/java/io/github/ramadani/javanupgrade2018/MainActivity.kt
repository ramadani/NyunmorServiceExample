package io.github.ramadani.javanupgrade2018

import android.app.Activity
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
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
        btnNotify.setOnClickListener { notifyMe() }
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

    private fun notifyMe() {
        val noticeBuilder = notificationBuilder().setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("My Nyun Notification")
                .setContentText("Lorem Ipsum is simply dummy text of the printing and typesetting industry")

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, noticeBuilder.build())
    }

    private fun notificationBuilder(): NotificationCompat.Builder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder(this, "javan-upgrade-2018")
        } else {
            NotificationCompat.Builder(this)
        }
    }

    private fun onStartNyunmorService() {
        val nyunService = Intent(this, NyunmorService::class.java)
        nyunService.putExtra("nyun", "nyunmor biar kuat")
        startService(nyunService)
    }
}
