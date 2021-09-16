package com.example.sakernasela.admin.listPetugas.data

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sakernasela.R
import com.example.sakernasela.admin.listKegiatan.persentase.PersentaseKerja
import com.example.sakernasela.databinding.ActivityDetailDataBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.entity.StatisticKerja
import com.example.sakernasela.utils.Constants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DetailData : AppCompatActivity() {
    lateinit var b : ActivityDetailDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityDetailDataBinding.inflate(layoutInflater)
        setContentView(b.root)
        setData()
    }

    private fun setData() {
        val i = intent.extras
        Constants.DB.child("ChildKeluarga")
            .child(i?.getString("idChild").toString())
            .addValueEventListener(object : ValueEventListener {
                @SuppressLint("SetTextI18n")
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        val data = snapshot.getValue(DataChildKeluarga::class.java)
                        b.edtNama.setText(data?.nama)
                        b.edtNik.setText(data?.nomerI)
                        b.edtA.setText(data?.a)
                        b.edtB.setText(data?.b)
                        b.edtC.setText(data?.c)
                        b.edtD.setText(data?.d)
                        b.edtE.setText(data?.e)
                        b.edtF.setText(data?.f)
                        b.edtFak.setText(data?.fak)
                        b.edtG.setText(data?.g)
                        b.edtH.setText(data?.h)
                        b.edtI.setText(data?.i)
                        b.edtJ.setText(data?.j)
                        b.edtK.setText(data?.k)
                        b.edtL.setText(data?.l)
                        b.edtM.setText(data?.m)
                        b.edtN.setText(data?.n)
                        b.edtO.setText(data?.o)
                        b.edtP.setText(data?.p)
                        b.edtQ.setText(data?.q)
                        b.edtR.setText(data?.r)
                        b.edtS.setText(data?.s)
                        b.edtT.setText(data?.t)
                        b.edtU.setText(data?.u)
                        b.edtV.setText(data?.v)
                        b.edtW.setText(data?.w)
                        b.edtX.setText(data?.x)
                        b.edtXxx.setText(data?.xxx)
                        b.edtY.setText(data?.y)
                        b.edtZ.setText(data?.z)
                        b.edtAa.setText(data?.aA)
                        b.edtAaa.setText(data?.Aaa)
                        b.edtBb.setText(data?.aB)
                        b.edtCc.setText(data?.aC)
                        b.edtDd.setText(data?.aD)
                        b.edtEe.setText(data?.aE)
                        b.edtFf.setText(data?.aF)
                        b.edtGg.setText(data?.aG)
                        b.edtHh.setText(data?.aH)
                        b.edtIi.setText(data?.aI)
                        b.edtJj.setText(data?.aJ)
                        b.edtKk.setText(data?.aK)
                        b.edtLl.setText(data?.aL)
                        b.edtMm.setText(data?.aM)
                        b.edtNn.setText(data?.aN)
                        b.edtOo.setText(data?.aO)
                        b.edtPp.setText(data?.aP)
                        b.edtQq.setText(data?.aQ)
                        b.edtRr.setText(data?.aR)
                        b.edtSs.setText(data?.aS)
                        b.edtTt.setText(data?.aT)
                        b.edtUu.setText(data?.aU)
                        b.edtVv.setText(data?.aV)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "koneksi internet buruk", Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = intent.extras
        val intent = Intent(this, PersentaseKerja::class.java)
        val bundle = Bundle()
        bundle.putString("name", i?.getString("namaPetugas"))
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }
}