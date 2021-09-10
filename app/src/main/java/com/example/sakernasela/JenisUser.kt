package com.example.sakernasela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.admin.LoginAdmin
import com.example.sakernasela.databinding.ActivityMainBinding
import com.example.sakernasela.petugas.LoginPetugas

class JenisUser : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        onClick()
    }

    private fun onClick() {
        bind.btnAdmin.setOnClickListener {
            startActivity(Intent(this, LoginAdmin::class.java))
            finish()
        }

        bind.btnPetugas.setOnClickListener {
            startActivity(Intent(this, LoginPetugas::class.java))
            finish()
        }
    }
}