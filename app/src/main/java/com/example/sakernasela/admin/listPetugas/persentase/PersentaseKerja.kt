package com.example.sakernasela.admin.listPetugas.persentase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sakernasela.R
import com.example.sakernasela.admin.listPetugas.ListPetugas
import com.example.sakernasela.databinding.ActivityPersentaseKerjaBinding

class PersentaseKerja : AppCompatActivity() {
    lateinit var b : ActivityPersentaseKerjaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPersentaseKerjaBinding.inflate(layoutInflater)
        setContentView(b.root)
        val data = intent?.extras
//        data?.getString("id").toString()
        b.persen.text = data?.getString("persen").toString() + "%"
        b.namaPetugas.text = data?.getString("name").toString()

        onClick()
    }

    private fun onClick() {
        b.persen.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, ListPetugas::class.java))
        finish()
    }
}