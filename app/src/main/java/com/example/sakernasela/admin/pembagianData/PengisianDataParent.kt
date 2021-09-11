package com.example.sakernasela.admin.pembagianData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPengisianDataParentBinding
import com.example.sakernasela.entity.DataParentKeluarga
import com.example.sakernasela.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialog

class PengisianDataParent : AppCompatActivity() {
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    lateinit var b : ActivityPengisianDataParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPengisianDataParentBinding.inflate(layoutInflater)
        setContentView(b.root)

        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        onClick()
    }

    private fun onClick() {
        b.btnTambah.setOnClickListener {
            if (b.edtKk.text.toString() != "" && b.edtKplKeluarga.text.toString() != ""
                && b.edtAlamat.text.toString() != "" ){
                masukkanData()
            }else{
                Toast.makeText(applicationContext, "harap lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun masukkanData() {
        progress.show()
        val idData = Constants.DB.push().key.toString()

        val data  = DataParentKeluarga(
                idData, b.edtKk.text.toString(),
                b.edtKplKeluarga.text.toString(),
                b.edtAlamat.text.toString(),
            ""
            )

        Constants.DB.child("ParentKeluarga").child(idData)
            .setValue(data)
            .addOnCompleteListener {
                progress.dismiss()
                Toast.makeText(applicationContext, "data berhasil dimasukkan", Toast.LENGTH_SHORT).show()
                val i = Bundle()
                i.putString("id", idData)
                val intent = Intent(this, PengisianDataChild::class.java)
                intent.putExtras(i)
                startActivity(intent)
                finish()
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