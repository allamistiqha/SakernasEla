package com.example.sakernasela.petugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sakernasela.databinding.ActivityLoginPetugasBinding
import com.example.sakernasela.entity.LoginPetugasModel
import com.example.sakernasela.utils.Constants.DB
import com.example.sakernasela.utils.Constants.prefManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LoginPetugas : AppCompatActivity() {
    lateinit var bind : ActivityLoginPetugasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginPetugasBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnMasuk.setOnClickListener {
            if (bind.edtUsername.text.toString() == "" && bind.edtPass.text.toString() == ""){
                bind.edtUsername.error = "masukkan username"
                bind.edtPass.error = "masukkan password"
            }
            if (bind.edtUsername.text.toString() != "" && bind.edtPass.text.toString() == ""){
                bind.edtPass.error = "masukkan Password"
            }
            if (bind.edtUsername.text.toString() == "" && bind.edtPass.text.toString() != ""){
                bind.edtUsername.error = "masukkan Username"
            }
            if (bind.edtUsername.text.toString() != "" && bind.edtPass.text.toString() != ""){
                setLogin()
            }
        }
    }

    private fun setLogin() {
        DB.child("LoginUser").orderByChild("userName")
            .equalTo(bind.edtUsername.text.toString())
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        for (snap in snapshot.children){
                            val data = snap.getValue(LoginPetugasModel::class.java)
                            cekPassword(data?.pass, data?.idData, data?.userName)
                        }
                    }else{
                        Toast.makeText(applicationContext, "username tidak ditemukan", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext,error.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun cekPassword(pass: String?, idData: String?, userName: String?) {
        if (bind.edtPass.text.toString() == pass){
            prefManager.setUserId(baseContext, idData)
            prefManager.setUserName(baseContext, userName)
            Toast.makeText(applicationContext, "Login berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PetugasAct::class.java))
            finish()
        }else{
            Toast.makeText(applicationContext, "Password anda salah", Toast.LENGTH_SHORT).show()
            bind.edtPass.setText("")
        }
    }
}