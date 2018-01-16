package io.github.ramadani.javanupgrade2018

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        launchNyunmorService()
    }

    fun launchNyunmorService() {
        val nyunService = Intent(this, NyunmorService::class.java)
        nyunService.putExtra("nyun", "nyunmor biar kuat")
        startService(nyunService)
    }
}
