package com.example.sakernasela.petugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPetugasBinding
import com.example.sakernasela.utils.Constants.prefManager

class PetugasAct : AppCompatActivity() {
    lateinit var b : ActivityPetugasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPetugasBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.idTest.text = prefManager.getUserId(baseContext)
    }
}