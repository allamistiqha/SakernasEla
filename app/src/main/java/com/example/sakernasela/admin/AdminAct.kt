package com.example.sakernasela.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.admin.listPetugas.ListPetugas
import com.example.sakernasela.admin.pembagianData.PembagianDataPetugas
import com.example.sakernasela.databinding.ActivityAdminBinding

class AdminAct : AppCompatActivity() {
    lateinit var bind : ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(bind.root)
        onClick()
    }

    private fun onClick() {
        bind.listPetugas.setOnClickListener {
            startActivity(Intent(this, ListPetugas::class.java))
            finish()
        }

        bind.pembagianData.setOnClickListener {
            startActivity(Intent(this, PembagianDataPetugas::class.java))
            finish()
        }
    }
}