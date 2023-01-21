package com.example.projemanag

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.example.projemanag.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        )

        val typeface: Typeface =
            Typeface.createFromAsset(assets, "carbon bl.ttf")
        val appName = findViewById(R.id.tv_app_name) as TextView
        appName.typeface = typeface

        Handler().postDelayed({

            var currrentUserID = FirestoreClass().getCurrentUserID()
            if(currrentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }

            else
            startActivity(Intent(this , IntroActivity::class.java))
            finish()

        },2500)
    }
}