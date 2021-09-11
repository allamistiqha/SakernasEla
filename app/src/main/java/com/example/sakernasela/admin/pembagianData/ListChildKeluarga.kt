package com.example.sakernasela.admin.pembagianData

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityListChildKeluargaBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ListChildKeluarga : AppCompatActivity() {
    lateinit var b : ActivityListChildKeluargaBinding
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    private val dataChild = ArrayList<DataChildKeluarga>()
    lateinit var bottomSheetDialog : BottomSheetDialog

    private lateinit var adapterData: AdapterDataChildKeluarga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityListChildKeluargaBinding.inflate(layoutInflater)
        setContentView(b.root)

        bottomSheetDialog = BottomSheetDialog(this)
        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        val idParent = intent.extras

        b.tvBadKoneksi.visibility = View.GONE
        progress.show()

        val layoutManager = LinearLayoutManager(this)
        b.rvPetugas.layoutManager = layoutManager
        adapterData = AdapterDataChildKeluarga(dataChild) { petugas: DataChildKeluarga ->
            onClick(
                petugas
            )
        }
        b.rvPetugas.setHasFixedSize(true)

        setData(b.rvPetugas, idParent?.getString("id").toString())
    }

    private fun onClick(dataK: DataChildKeluarga) {
        bottomShets(dataK)
    }

    private fun bottomShets(dataK: DataChildKeluarga) {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_tambah_anggota)
        val noInduk = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.edtInduk)
        val nama = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.edtNama)
        val ubah = bottomSheetDialog.findViewById<AppCompatButton>(R.id.btnTambahK)
        val hapus = bottomSheetDialog.findViewById<AppCompatButton>(R.id.btnHapus)
        bottomSheetDialog.show()

        noInduk?.setText(dataK.nomerI)
        nama?.setText(dataK.nama)

        ubah?.setOnClickListener {
            progress.show()
            pushData(dataK,noInduk?.text.toString(), nama?.text.toString())
        }
        hapus?.setOnClickListener {
            progress.show()
            Constants.DB.child("ChildKeluarga").child(dataK.idChild)
                .removeValue()
                .addOnCompleteListener {
                    progress.dismiss()
                    bottomSheetDialog.dismiss()
                    Toast.makeText(applicationContext, "data berhasil dihapus", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun pushData(dataK: DataChildKeluarga, noInduk: String, nama: String) {
        val data  = DataChildKeluarga(
            dataK.idParent,
            dataK.idChild,
            noInduk,
            nama
        )

        Constants.DB.child("ChildKeluarga").child(dataK.idChild)
            .setValue(data)
            .addOnCompleteListener {
                progress.dismiss()
                bottomSheetDialog.dismiss()
                Toast.makeText(applicationContext, "data berhasil dimasukkan", Toast.LENGTH_SHORT).show()
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData(rvPetugas: RecyclerView, idParent: String) {
        adapterData.notifyDataSetChanged()
        Constants.DB.child("ChildKeluarga")
            .orderByChild("idParent")
            .equalTo(idParent)
            .addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    dataChild.clear()
                    b.tvBadKoneksi.visibility = View.GONE
                    rvPetugas.visibility = View.VISIBLE
                    progress.dismiss()
                    for (snap in snapshot.children){
                        val dataPetugas = snap.getValue(DataChildKeluarga::class.java)
                        dataChild.add(dataPetugas!!)
                        rvPetugas.adapter = adapterData
                    }
                }else{
                    progress.dismiss()
                    b.tvBadKoneksi.visibility = View.VISIBLE
                    b.tvBadKoneksi.text = "Belum ada data"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                b.tvBadKoneksi.visibility = View.VISIBLE
            }

        })
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