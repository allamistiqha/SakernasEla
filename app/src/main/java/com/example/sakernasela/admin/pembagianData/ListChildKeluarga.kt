package com.example.sakernasela.admin.pembagianData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityListChildKeluargaBinding

class ListChildKeluarga : AppCompatActivity() {
    lateinit var b : ActivityListChildKeluargaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityListChildKeluargaBinding.inflate(layoutInflater)
        setContentView(b.root)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, PembagianDataPetugas::class.java))
        finish()
    }
}