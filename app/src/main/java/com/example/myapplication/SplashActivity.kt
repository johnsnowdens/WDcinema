package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.HandlerCompat.postDelayed

import java.util.logging.Handler as Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashtime:Long = 3000
        splash()



    }
    val splashtime:Long = 3000

    fun splash() {
        android.os.Handler().postDelayed(
                {

                    val intent = Intent(this,MainActivity::class.java )
                    startActivity(intent)
                    finish()
                },
                splashtime)


    }


}



