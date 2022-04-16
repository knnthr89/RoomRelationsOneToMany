package com.example.roomrelationsonetomany

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    val model by viewModels<UsersViewModel> { UsersViewModelFactory(context = this) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.users.observe(this) {
            it.forEach {
                Log.e("user", "${it.user} ${it.accounts}")
            }
        }

    }
}