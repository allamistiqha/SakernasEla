package com.example.sakernasela.admin.pembagianData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPembagianDataBinding

class PembagianData : AppCompatActivity() {
    lateinit var b : ActivityPembagianDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPembagianDataBinding.inflate(layoutInflater)
        setContentView(b.root)

    }
}