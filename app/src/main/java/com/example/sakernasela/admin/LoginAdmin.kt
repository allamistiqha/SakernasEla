package com.example.sakernasela.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityLoginAdminBinding

class LoginAdmin : AppCompatActivity() {
    lateinit var bind : ActivityLoginAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginAdminBinding.inflate(layoutInflater)
        setContentView(bind.root)

        onClick()
    }

    private fun onClick() {
        bind.btnMasuk.setOnClickListener {
            if (bind.edtUsername.text.toString() == "" || bind.edtPass.text.toString() == "") {
                Toast.makeText(
                    applicationContext,
                    "anda belum memasukkan username atau pass",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (bind.edtUsername.text.toString() == "admin" && bind.edtPass.text.toString() == "admin") {
                    startActivity(Intent(this, AdminAct::class.java))
                    finish()
                }else{
                    Toast.makeText(applicationContext, "password anda salah", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}