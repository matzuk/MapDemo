package com.matsiuk.mapexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(
                Intent(this, MapsActivity::class.java)
            )
        }
    }
}