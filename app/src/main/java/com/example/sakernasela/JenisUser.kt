package com.example.sakernasela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.databinding.ActivityMainBinding

class JenisUser : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}