package com.example.sakernasela.admin.listKegiatan.persentase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.R
import com.example.sakernasela.admin.listPetugas.ListPetugas
import com.example.sakernasela.admin.listPetugas.data.DetailData
import com.example.sakernasela.admin.pembagianData.PembagianDataPetugas
import com.example.sakernasela.databinding.ActivityPersentaseKerjaBinding
import com.example.sakernasela.entity.DataParentKeluarga
import com.example.sakernasela.entity.StatisticKerja
import com.example.sakernasela.utils.Constants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

@SuppressLint("SetTextI18n")
class PersentaseKerja : AppCompatActivity() {
    lateinit var b : ActivityPersentaseKerjaBinding
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    private val listKegiatan = ArrayList<StatisticKerja>()
    private lateinit var adapterPetugas: AdapterKegiatanPetugas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPersentaseKerjaBinding.inflate(layoutInflater)
        setContentView(b.root)
        val data = intent?.extras
        b.persen.text = "List Aktivitas Petugas : " + data?.getString("name").toString()

        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()

        b.tvBadKoneksi.visibility = View.GONE
        progress.show()

        val layoutManager = LinearLayoutManager(this)
        b.rvPetugas.layoutManager = layoutManager
        adapterPetugas = AdapterKegiatanPetugas(listKegiatan) { kegiatan: StatisticKerja ->
            onClick(
                kegiatan
            )
        }
        b.rvPetugas.setHasFixedSize(true)

        setData(b.rvPetugas)

    }

    private fun onClick(kegiatan: StatisticKerja) {
        val data = intent?.extras
        val bundle = Bundle()
        val i = Intent(this, DetailData::class.java)
        bundle.putString("namaPetugas",data?.getString("name").toString())
        bundle.putString("idChild",kegiatan.idChildKeluarga)
        i.putExtras(bundle)
        startActivity(i)
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData(rvPetugas: RecyclerView) {
        val data = intent?.extras
        adapterPetugas.notifyDataSetChanged()
        Constants.DB.child("StatisticKerjaan")
            .orderByChild("namaPetugas")
            .equalTo(data?.getString("name").toString())
            .addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    listKegiatan.clear()
                    b.tvBadKoneksi.visibility = View.GONE
                    rvPetugas.visibility = View.VISIBLE
                    progress.dismiss()
                    for (snap in snapshot.children){
                        val dataPetugas = snap.getValue(StatisticKerja::class.java)
                        listKegiatan.add(dataPetugas!!)
                        rvPetugas.adapter = adapterPetugas
                    }
                }else{
                    b.tvBadKoneksi.visibility = View.VISIBLE
                    progress.dismiss()
                    b.tvBadKoneksi.text = "Belum ada aktivitas"
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
        startActivity(Intent(this, ListPetugas::class.java))
        finish()
    }
}