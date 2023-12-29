package com.example.islamyapp.ui.Splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.example.islamyapp.R
import com.example.islamyapp.ui.Home.HomeActivity
import com.example.islamyapp.ui.Home.Quran.Constants

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getModeFromSheredPrefrenced()==AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else  {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
           val intent= Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
        },2000)

    }
    fun getModeFromSheredPrefrenced():Int{
        val sheredPrefrenced=getSharedPreferences(Constants.islamySheredPrefrenses, Context.MODE_PRIVATE)
        return sheredPrefrenced.getInt(Constants.Islamy_Mode_Key,AppCompatDelegate.MODE_NIGHT_NO)
    }
}