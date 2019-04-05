package com.mjaruijs.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener { onStartClick() }
        stop_button.setOnClickListener { onStopClick() }
    }

    private fun onStartClick() {
        Thread {
            val client = Client("192.168.178.11", 8080)
            client.write("START")
            client.close()
        }.start()
    }

    private fun onStopClick() {
        Thread {
            val client = Client("192.168.178.11", 8080)
            client.write("STOP")
            client.close()
        }.start()
    }
}
