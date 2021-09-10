package com.example.sakernasela.admin.listPetugas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.R
import com.example.sakernasela.admin.AdminAct
import com.example.sakernasela.admin.listPetugas.persentase.PersentaseKerja
import com.example.sakernasela.databinding.ActivityListPetugasBinding
import com.example.sakernasela.entity.LoginPetugasModel
import com.example.sakernasela.utils.Constants.DB
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ListPetugas : AppCompatActivity() {
    lateinit var b : ActivityListPetugasBinding
    lateinit var bottomSheetDialog : BottomSheetDialog
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    private val listPetugas = ArrayList<LoginPetugasModel>()
    private lateinit var adapterPetugas: AdapterListPetugas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityListPetugasBinding.inflate(layoutInflater)
        setContentView(b.root)

        bottomSheetDialog = BottomSheetDialog(this)
        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        b.tvBadKoneksi.visibility = View.GONE
        progress.show()

        val layoutManager = LinearLayoutManager(this)
        b.rvPetugas.layoutManager = layoutManager
        adapterPetugas = AdapterListPetugas(listPetugas) { petugas: LoginPetugasModel ->
            onClick(
                petugas
            )
        }
        b.rvPetugas.setHasFixedSize(true)

        setData(b.rvPetugas)

        onItemClcik()
    }

    private fun onClick(petugas: LoginPetugasModel) {
        val i = Intent(this, PersentaseKerja::class.java)
        val bundle = Bundle()
        bundle.putString("name", petugas.userName)
        bundle.putString("persen", petugas.persen)
        bundle.putString("id", petugas.persen)
        i.putExtras(bundle)
        startActivity(i)
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData(rvPetugas: RecyclerView) {
        adapterPetugas.notifyDataSetChanged()
        DB.child("LoginUser").addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    listPetugas.clear()
                    b.tvBadKoneksi.visibility = View.GONE
                    rvPetugas.visibility = View.VISIBLE
                    progress.dismiss()
                    for (snap in snapshot.children){
                        val dataPetugas = snap.getValue(LoginPetugasModel::class.java)
                        listPetugas.add(dataPetugas!!)
                        rvPetugas.adapter = adapterPetugas
                    }
                }else{
                    b.tvBadKoneksi.visibility = View.VISIBLE
                    b.tvBadKoneksi.text = "Belum ada data"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                b.tvBadKoneksi.visibility = View.VISIBLE
            }

        })
    }

    private fun onItemClcik() {
        b.tambahUser.setOnClickListener {
            bottomSheet()
        }
    }

    private fun bottomSheet() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_tambah_petugas)
        val namaPetugas = bottomSheetDialog.findViewById<EditText>(R.id.username) as EditText
        val passPetugas = bottomSheetDialog.findViewById<EditText>(R.id.pass) as EditText
        val tambah = bottomSheetDialog.findViewById<AppCompatButton>(R.id.btnTambah)
        bottomSheetDialog.show()

        tambah?.setOnClickListener {
            progress.show()
            pushData(namaPetugas.text.toString(), passPetugas.text.toString())
        }
    }

    private fun pushData(nama: String, pass: String) {
        val idData = DB.push().key.toString()

        val data  = LoginPetugasModel(
            nama, pass, idData
        )

        DB.child("LoginUser").child(idData)
            .setValue(data)
            .addOnCompleteListener {
                progress.dismiss()
                bottomSheetDialog.dismiss()
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
        startActivity(Intent(this, AdminAct::class.java))
        finish()
    }
}