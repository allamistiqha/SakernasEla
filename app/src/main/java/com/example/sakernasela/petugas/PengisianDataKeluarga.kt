package com.example.sakernasela.petugas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPengisianDataKeluargaBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.utils.Constants.DB
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class PengisianDataKeluarga : AppCompatActivity() {
    lateinit var b : ActivityPengisianDataKeluargaBinding
    lateinit var progress : AlertDialog
    lateinit var inflate : LayoutInflater
    lateinit var builder : AlertDialog.Builder
    lateinit var bottomSheetDialog : BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityPengisianDataKeluargaBinding.inflate(layoutInflater)
        setContentView(b.root)

        inflate = layoutInflater
        builder = AlertDialog.Builder(this, R.style.CustomDialog)
        progress = showAlertTest().create()
        bottomSheetDialog = BottomSheetDialog(this)

        progress.show()
        setData()
        onClick()
    }

    private fun setData() {
        val i = intent.extras
        DB.child("ChildKeluarga").child(i?.getString("id").toString())
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        progress.dismiss()
                        val data = snapshot.getValue(DataChildKeluarga::class.java)
                        b.edtNama.setText(data?.nama)
                        b.edtNik.setText(data?.nomerI)
                        b.edtA.setText(data?.a)
                        b.edtB.setText(data?.b)
                        b.edtC.setText(data?.c)
                        b.edtD.setText(data?.d)
                        b.edtE.setText(data?.e)
                        b.edtF.setText(data?.f)
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
                        b.edtY.setText(data?.y)
                        b.edtZ.setText(data?.z)
                        b.edtAa.setText(data?.aA)
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
                    Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun onClick() {
        b.edtA.setOnClickListener { bottomShetA() }
        b.edtB.setOnClickListener { bottomShetB() }
        b.edtC.setOnClickListener { bottomShetC() }
//        b.edtD.setOnClickListener { bottomShetD() }
        b.edtE.setOnClickListener { bottomShetE("E") }
        b.edtF.setOnClickListener { bottomShetE("F") }
        b.edtG.setOnClickListener { bottomShetE("G") }
//        b.edtH.setOnClickListener { bottomShetH() }
        b.edtI.setOnClickListener { bottomShetI("I") }
        b.edtJ.setOnClickListener { bottomShetI("J") }
        b.edtK.setOnClickListener { bottomShetI("K") }
        b.edtL.setOnClickListener { bottomShetI("L") }
        b.edtM.setOnClickListener { bottomShetI("M") }
        b.edtN.setOnClickListener { bottomShetI("N") }
        b.edtO.setOnClickListener { bottomShetE("O") }
        b.edtP.setOnClickListener { bottomShetE("P") }
        b.edtQ.setOnClickListener { bottomShetE("Q") }
        b.edtR.setOnClickListener { bottomShetE("R") }
//        b.edtS.setOnClickListener { bottomShetS() }
//        b.edtT.setOnClickListener { bottomShetT() }
//        b.edtU.setOnClickListener { bottomShetU() }
//        b.edtV.setOnClickListener { bottomShetV() }
//        b.edtW.setOnClickListener { bottomShetW() }
//        b.edtX.setOnClickListener { bottomShetX() }
//        b.edtY.setOnClickListener { bottomShetY() }
//        b.edtZ.setOnClickListener { bottomShetZ() }
//        b.edtAa.setOnClickListener { bottomShetAa() }
//        b.edtBb.setOnClickListener { bottomShetBb() }
//        b.edtCc.setOnClickListener { bottomShetCc() }
//        b.edtDd.setOnClickListener { bottomShetDd() }
//        b.edtEe.setOnClickListener { bottomShetEe() }
//        b.edtFf.setOnClickListener { bottomShetFf() }
//        b.edtGg.setOnClickListener { bottomShetGg() }
//        b.edtHh.setOnClickListener { bottomShetHh() }
//        b.edtIi.setOnClickListener { bottomShetIi() }
//        b.edtJj.setOnClickListener { bottomShetJj() }
//        b.edtKk.setOnClickListener { bottomShetKk() }
//        b.edtLl.setOnClickListener { bottomShetLl() }
//        b.edtMm.setOnClickListener { bottomShetMm() }
//        b.edtNn.setOnClickListener { bottomShetNn() }
//        b.edtOo.setOnClickListener { bottomShetOo() }
//        b.edtPp.setOnClickListener { bottomShetPp() }
//        b.edtQq.setOnClickListener { bottomShetQq() }
//        b.edtRr.setOnClickListener { bottomShetRr() }
//        b.edtSs.setOnClickListener { bottomShetSs() }
//        b.edtTt.setOnClickListener { bottomShetTt() }
//        b.edtUu.setOnClickListener { bottomShetUu() }
//        b.edtVv.setOnClickListener { bottomShetVv() }

        b.tambah.setOnClickListener {
            pushData()
        }
    }

    private fun bottomShetI(s : String) {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_i)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ia)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Ib)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Ic)

        bottomSheetDialog.show()

        if (s == "I"){
            satu?.setOnClickListener {
                b.edtI.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtI.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtI.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "J"){
            satu?.setOnClickListener {
                b.edtJ.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtJ.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtJ.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "K"){
            satu?.setOnClickListener {
                b.edtK.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtK.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtK.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "L"){
            satu?.setOnClickListener {
                b.edtL.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtL.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtL.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "M"){
            satu?.setOnClickListener {
                b.edtM.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtM.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtM.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "N"){
            satu?.setOnClickListener {
                b.edtN.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtN.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtN.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bottomShetE(s: String) {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_e)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ea)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Eb)
        val pertanyaan = bottomSheetDialog.findViewById<TextView>(R.id.pertanyaan)

        bottomSheetDialog.show()

        if (s == "E"){
            pertanyaan?.text = "Apakah anda lulus sekolah ?"
            satu?.setOnClickListener {
                b.edtE.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtE.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "F"){
            pertanyaan?.text = "Apakah anda pernah mengikuti pelatihan  khusus dan mendapatkan sertifikat ?"
            satu?.setOnClickListener {
                b.edtF.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtF.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "G"){
            pertanyaan?.text = "Apakah saat ini anda sedang mengikuti pelatihan khusus ?"
            satu?.setOnClickListener {
                b.edtG.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtG.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "O"){
            pertanyaan?.text = "Dalam seminggu terakhir, apakah Anda bekerja ?"
            satu?.setOnClickListener {
                b.edtO.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtO.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "P"){
            pertanyaan?.text = "Dalam seminggu terakhir, apakah anda membantu kegiatan usaha untuk memperoleh uang ?"
            satu?.setOnClickListener {
                b.edtP.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtP.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "Q"){
            pertanyaan?.text = "Dalam seminggu terakhir, apakah  Anda membantu pekerjaan keluarga/orang lain ?"
            satu?.setOnClickListener {
                b.edtQ.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtQ.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "R"){
            pertanyaan?.text = "Apakah Anda sebenarnya memiliki pekerjaan, tetapi seminggu terakhir sedang tidak bekerja ?"
            satu?.setOnClickListener {
                b.edtR.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtR.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
    }

    private fun bottomShetC() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_c)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ca)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Cb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Cc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Cd)
        val lima = bottomSheetDialog.findViewById<TextView>(R.id.Ce)
        val enam = bottomSheetDialog.findViewById<TextView>(R.id.Cf)
        val tujuh = bottomSheetDialog.findViewById<TextView>(R.id.Cg)
        val delapan = bottomSheetDialog.findViewById<TextView>(R.id.Ch)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtC.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtC.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtC.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtC.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
        lima?.setOnClickListener {
            b.edtC.setText(lima.text.toString())
            bottomSheetDialog.dismiss()
        }
        enam?.setOnClickListener {
            b.edtC.setText(enam.text.toString())
            bottomSheetDialog.dismiss()
        }
        tujuh?.setOnClickListener {
            b.edtC.setText(tujuh.text.toString())
            bottomSheetDialog.dismiss()
        }
        delapan?.setOnClickListener {
            b.edtC.setText(delapan.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetB() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_b)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.As)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Bs)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Cs)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtB.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtB.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtB.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetA() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_a)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.bk)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.k)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.ch)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.cm)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtA.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtA.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtA.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtA.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun pushData() {
//        b.edtNama.text.toString()
//        b.edtInduk.text.toString()
//        progress.show()
//
//        val idData = Constants.DB.push().key.toString()
//
//        val data  = DataChildKeluarga(
//            idParent,
//            idData, b.edtInduk.text.toString(),
//            b.edtNama.text.toString()
//        )
//
//        Constants.DB.child("ChildKeluarga").child(idData)
//            .setValue(data)
//            .addOnCompleteListener {
//                progress.dismiss()
//                b.edtInduk.setText("")
//                b.edtNama.setText("")
//                Toast.makeText(applicationContext, "data berhasil dimasukkan", Toast.LENGTH_SHORT).show()
//            }
    }

    private fun showAlertTest() : AlertDialog.Builder {
        val view = inflate.inflate(R.layout.progress, null)
        builder.setView(view)
        builder.setCancelable(false)
        return builder
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = intent.extras
        val bundle = Bundle()
        val intent = Intent(this, ListKeluarga::class.java)
        bundle.putString("id", i?.getString("idParent").toString())
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }
}