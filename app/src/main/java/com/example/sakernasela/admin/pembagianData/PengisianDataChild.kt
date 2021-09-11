package com.example.sakernasela.admin.pembagianData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPengisianDataChilldBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.entity.DataParentKeluarga
import com.example.sakernasela.utils.Constants

class PengisianDataChild : AppCompatActivity() {
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    lateinit var b : ActivityPengisianDataChilldBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPengisianDataChilldBinding.inflate(layoutInflater)
        setContentView(b.root)

        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        val i = intent.extras
        val id = i?.getString("id").toString()
        onClick(id)
    }

    private fun onClick(idParent: String) {
        b.btnTambahK.setOnClickListener {
            tambahAnggotaKeluarga(idParent)
        }

        b.btnSelesai.setOnClickListener {
            startActivity(Intent(this, PembagianDataPetugas::class.java))
            finish()
        }
    }

    private fun tambahAnggotaKeluarga(idParent: String) {
        b.edtNama.text.toString()
        b.edtInduk.text.toString()
        progress.show()

        val idData = Constants.DB.push().key.toString()

        val data  = DataChildKeluarga(
            idParent,
            idData, b.edtInduk.text.toString(),
            b.edtNama.text.toString()
        )

        Constants.DB.child("ChildKeluarga").child(idData)
            .setValue(data)
            .addOnCompleteListener {
                progress.dismiss()
                b.edtInduk.setText("")
                b.edtNama.setText("")
                Toast.makeText(applicationContext, "data berhasil dimasukkan", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showAlertTest() : AlertDialog.Builder {
        val view = inflate.inflate(R.layout.progress, null)
        builder.setView(view)
        builder.setCancelable(false)
        return builder
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, PembagianDataPetugas::class.java))
        finish()
    }
}