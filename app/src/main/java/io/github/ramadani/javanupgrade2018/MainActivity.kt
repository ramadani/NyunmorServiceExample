package io.github.ramadani.javanupgrade2018

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var nyunReceiver: NyunmorResultReceiver? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupServiceReceiver()
        btnStart.setOnClickListener { onStartNyunmorService() }
    }

    private fun onStartNyunmorService() {
        val nyunService = Intent(this, NyunmorService::class.java)
        nyunService.putExtra("nyun", "nyunmor biar kuat")
        startService(nyunService)
    }

    private fun setupServiceReceiver() {
        nyunReceiver = NyunmorResultReceiver(Handler())
        nyunReceiver?.setReceiver(object : NyunmorResultReceiver.Receiver {
            override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
                if (resultCode == Activity.RESULT_OK) {
                    val resultValue = resultData?.getString("nyunValue")
                    toast(resultValue)
                }
            }
        })
    }
}
