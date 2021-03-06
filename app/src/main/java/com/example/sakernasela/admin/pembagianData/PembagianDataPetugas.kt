package com.example.sakernasela.admin.pembagianData

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.R
import com.example.sakernasela.admin.AdminAct
import com.example.sakernasela.databinding.ActivityPembagianDataBinding
import com.example.sakernasela.entity.DataParentKeluarga
import com.example.sakernasela.utils.Constants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class PembagianDataPetugas : AppCompatActivity() {
    lateinit var b : ActivityPembagianDataBinding
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    private val dataParent = ArrayList<DataParentKeluarga>()
    private lateinit var adapterData: AdapterDataParentKeluarga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPembagianDataBinding.inflate(layoutInflater)
        setContentView(b.root)

        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        b.tvBadKoneksi.visibility = View.GONE
        progress.show()

        val layoutManager = LinearLayoutManager(this)
        b.rvPetugas.layoutManager = layoutManager
        adapterData = AdapterDataParentKeluarga(dataParent, this) { petugas: DataParentKeluarga ->
            onClick(
                petugas
            )
        }
        b.rvPetugas.setHasFixedSize(true)

        setData(b.rvPetugas)

        onItemClcik()
    }

    private fun onClick(dataK: DataParentKeluarga) {
        val i = Intent(this, ListChildKeluarga::class.java)
        val bundle = Bundle()
        bundle.putString("id", dataK.idKeluarga)
        i.putExtras(bundle)
        startActivity(i)
        finish()
    }

    private fun onItemClcik() {
        b.tambahData.setOnClickListener {
            startActivity(Intent(this, PengisianDataParent::class.java))
            finish()
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setData(rvPetugas: RecyclerView) {
        adapterData.notifyDataSetChanged()
        Constants.DB.child("ParentKeluarga").addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    dataParent.clear()
                    b.tvBadKoneksi.visibility = View.GONE
                    rvPetugas.visibility = View.VISIBLE
                    progress.dismiss()
                    for (snap in snapshot.children){
                        val dataPetugas = snap.getValue(DataParentKeluarga::class.java)
                        dataParent.add(dataPetugas!!)
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
        startActivity(Intent(this, AdminAct::class.java))
        finish()
    }
}