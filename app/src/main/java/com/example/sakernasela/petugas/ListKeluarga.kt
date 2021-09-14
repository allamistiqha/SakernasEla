package com.example.sakernasela.petugas

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
import com.example.sakernasela.admin.pembagianData.AdapterDataChildKeluarga
import com.example.sakernasela.admin.pembagianData.PembagianDataPetugas
import com.example.sakernasela.databinding.ActivityListChildKeluargaBinding
import com.example.sakernasela.databinding.ActivityListKeluargaBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.utils.Constants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ListKeluarga : AppCompatActivity() {
    lateinit var b : ActivityListKeluargaBinding
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    private val dataChild = ArrayList<DataChildKeluarga>()
    private lateinit var adapterData: AdapterDataChildKeluarga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityListKeluargaBinding.inflate(layoutInflater)
        setContentView(b.root)

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
        val bundle = Bundle()
        val intent = Intent(this, PengisianDataKeluarga::class.java)
        bundle.putString("id", dataK.idChild)
        bundle.putString("idParent", dataK.idParent)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
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
        startActivity(Intent(this, PetugasAct::class.java))
        finish()
    }
}