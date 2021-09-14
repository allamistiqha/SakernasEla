package com.example.sakernasela.petugas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.sakernasela.R
import com.example.sakernasela.databinding.ActivityPengisianDataKeluargaBinding
import com.example.sakernasela.entity.DataChildKeluarga
import com.example.sakernasela.utils.Constants
import com.example.sakernasela.utils.Constants.DB
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

@SuppressLint("SetTextI18n")
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
                    Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun onClick() {
        b.edtA.setOnClickListener { bottomShetA() }
        b.edtB.setOnClickListener { bottomShetB() }
        b.edtC.setOnClickListener { bottomShetC() }
//        b.edtD.setOnClickListener { bottomShetD() }
        b.edtE.setOnClickListener { bottomShetE("E") }//ya atau tidak
        b.edtF.setOnClickListener { bottomShetE("F") }
        b.edtFak.setOnClickListener { bottomShetE("G") }
        b.edtG.setOnClickListener { bottomShetG() }
        b.edtH.setOnClickListener { bottomShetH("H") }
        b.edtI.setOnClickListener { bottomShetH("I") }
        b.edtJ.setOnClickListener { bottomShetH("J") }
        b.edtK.setOnClickListener { bottomShetH("K") }
        b.edtL.setOnClickListener { bottomShetH("L") }
        b.edtM.setOnClickListener { bottomShetH("M") }
        b.edtN.setOnClickListener { bottomShetE("N") }
        b.edtO.setOnClickListener { bottomShetE("O") }
        b.edtP.setOnClickListener { bottomShetE("P") }
        b.edtQ.setOnClickListener { bottomShetE("Q") }
        b.edtR.setOnClickListener { bottomShetR() }
        b.edtS.setOnClickListener { bottomShetE("S") }
        b.edtT.setOnClickListener { bottomShetT() }
//        b.edtU.setOnClickListener {  }
//        b.edtV.setOnClickListener { bottomShetV() }
//        b.edtW.setOnClickListener { bottomShetW() }
        b.edtX.setOnClickListener { bottomShetX() }
//        b.edtY.setOnClickListener { bottomShetY() }
        b.edtZ.setOnClickListener { bottomShetZ() }
        b.edtAa.setOnClickListener { bottomShetAa() }
        b.edtAaa.setOnClickListener { bottomShetAaa() }
        b.edtBb.setOnClickListener { bottomShetBb() }
        b.edtCc.setOnClickListener { bottomShetCc() }
        b.edtDd.setOnClickListener { bottomShetDd() }
        b.edtEe.setOnClickListener { bottomShetEe() }
        b.edtFf.setOnClickListener { bottomShetFf() }
        b.edtGg.setOnClickListener { bottomShetE("Gg") }
        b.edtHh.setOnClickListener { bottomShetE("Hh") }
        b.edtIi.setOnClickListener { bottomShetE("Ii") }
        b.edtJj.setOnClickListener { bottomShetE("Jj") }
        b.edtKk.setOnClickListener { bottomShetE("Kk") }
        b.edtLl.setOnClickListener { bottomShetLl() }
        b.edtMm.setOnClickListener { bottomShetMm() }
        b.edtNn.setOnClickListener { bottomShetNn() }
        b.edtOo.setOnClickListener { bottomShetE("Oo") }
        b.edtPp.setOnClickListener { bottomShetPp() }
        b.edtQq.setOnClickListener { bottomShetE("Qq") }
        b.edtRr.setOnClickListener { bottomShetRr() }
        b.edtSs.setOnClickListener { bottomShetSs() }
        b.edtTt.setOnClickListener { bottomShetTt() }
        b.edtUu.setOnClickListener { bottomShetE("Uu") }
        b.edtVv.setOnClickListener { bottomShetVv() }

        b.tambah.setOnClickListener {
            pushData()
        }
    }

    private fun bottomShetPp() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ppp)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.ppp)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.sls)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtPp.setText(satu?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetSs() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_tt)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.nna)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.nnb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.nnc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.nnd)
        val tanya = bottomSheetDialog.findViewById<TextView>(R.id.pertanyaan)

        bottomSheetDialog.show()

        tanya?.text = "Apakah anda melakukan perjalanan pulang dan pergi dari rumah ke tempat kerja secara rutin ?"
        satu?.text = "Ya, setiap hari"
        dua?.text = "Ya, setiap minggu"
        tiga?.text = "Ya, setiap bulan"
        empat?.text = "Tidak rutin"

        satu?.setOnClickListener {
            b.edtSs.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtSs.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtSs.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtSs.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetTt() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_tt)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.nna)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.nnb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.nnc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.nnd)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtTt.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtTt.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtTt.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtTt.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetRr() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_rr)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ha)
        val dua = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.Hb)
        val tiga = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.Hc)
        val sKab = bottomSheetDialog.findViewById<Button>(R.id.sK)
        val sNeg = bottomSheetDialog.findViewById<Button>(R.id.sN)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtRr.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }

        sKab?.setOnClickListener {
            b.edtRr.setText(dua?.text.toString())
            bottomSheetDialog.dismiss()
        }

        sNeg?.setOnClickListener {
            b.edtRr.setText(tiga?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }


    private fun bottomShetVv() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_bb)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.jumlah)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtVv.setText(satu?.text.toString() +" Jam")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetNn() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_nn)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.nna)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.nnb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.nnc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.nnd)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtNn.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtNn.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtNn.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtNn.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetMm() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_mm)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.mma)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.mmb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.mmc)
        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtMm.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtMm.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtMm.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetLl() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_lll)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.ccc)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtLl.setText(satu?.text.toString() +" Jam")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetFf() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ff)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ca)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Cb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Cc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Cd)
        val lima = bottomSheetDialog.findViewById<TextView>(R.id.Ce)
        val enam = bottomSheetDialog.findViewById<TextView>(R.id.Cf)
        val tujuh = bottomSheetDialog.findViewById<TextView>(R.id.Cg)
        val delapan = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.klj)

        val selesai = bottomSheetDialog.findViewById<Button>(R.id.seles)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtFf.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtFf.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtFf.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtFf.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
        lima?.setOnClickListener {
            b.edtFf.setText(lima.text.toString())
            bottomSheetDialog.dismiss()
        }
        enam?.setOnClickListener {
            b.edtFf.setText(enam.text.toString())
            bottomSheetDialog.dismiss()
        }
        tujuh?.setOnClickListener {
            b.edtFf.setText(tujuh.text.toString())
            bottomSheetDialog.dismiss()
        }

        selesai?.setOnClickListener {
            b.edtFf.setText(delapan?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetEe() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ccc)
        val jam =  bottomSheetDialog.findViewById<TextView>(R.id.jkl)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.ccc)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        jam?.text = "Sebelum Covid-19, berapakah jumlah jam kerja biasanya dalam seminggu ?"

        slesai?.setOnClickListener {
            b.edtEe.setText(satu?.text.toString() +" Jam")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetDd() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dd)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.dda)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.ddb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.ddc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.ddd)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtDd.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtDd.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtDd.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtDd.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetCc() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_ccc)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.ccc)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtCc.setText(satu?.text.toString() +" Jam")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetBb() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_bb)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.jumlah)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtBb.setText(satu?.text.toString() +" Jam")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetAaa() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_aaa)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.aaa)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtAaa.setText(satu?.text.toString() +" Bulan")
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetAa() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_aa)
        val satu = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.aaa)
        val dua = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.aab)
        val slesai = bottomSheetDialog.findViewById<Button>(R.id.bb)

        bottomSheetDialog.show()

        slesai?.setOnClickListener {
            b.edtAa.setText(satu?.text.toString() +" - "+ dua?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetZ() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_z)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Za)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Zb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Zc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Zd)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtZ.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }

        dua?.setOnClickListener {
            b.edtZ.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }

        tiga?.setOnClickListener {
            b.edtZ.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtZ.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetX() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_x)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Xa)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Yb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Yc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Yd)
        val lima = bottomSheetDialog.findViewById<TextView>(R.id.Ye)
        val enam = bottomSheetDialog.findViewById<TextView>(R.id.Yf)
        val tujuh = bottomSheetDialog.findViewById<TextView>(R.id.Yg)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtX.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtX.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtX.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtX.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
        lima?.setOnClickListener {
            b.edtX.setText(lima.text.toString())
            bottomSheetDialog.dismiss()
        }
        enam?.setOnClickListener {
            b.edtX.setText(enam.text.toString())
            bottomSheetDialog.dismiss()
        }
        tujuh?.setOnClickListener {
            b.edtX.setText(tujuh.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetT() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_u)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ua)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Ub)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Uc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Ud)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtT.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtT.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtT.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtT.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetR() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_s)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Sa)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Sb)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Sc)
        val empat = bottomSheetDialog.findViewById<TextView>(R.id.Sd)
        val lima = bottomSheetDialog.findViewById<TextView>(R.id.Se)
        val enam = bottomSheetDialog.findViewById<TextView>(R.id.Sf)
        val tujuh = bottomSheetDialog.findViewById<TextView>(R.id.Sg)
        val delapan = bottomSheetDialog.findViewById<TextView>(R.id.Sh)
        val sembilan = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.Si)

        val selesai = bottomSheetDialog.findViewById<Button>(R.id.seles)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtR.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }
        dua?.setOnClickListener {
            b.edtR.setText(dua.text.toString())
            bottomSheetDialog.dismiss()
        }
        tiga?.setOnClickListener {
            b.edtR.setText(tiga.text.toString())
            bottomSheetDialog.dismiss()
        }
        empat?.setOnClickListener {
            b.edtR.setText(empat.text.toString())
            bottomSheetDialog.dismiss()
        }
        lima?.setOnClickListener {
            b.edtR.setText(lima.text.toString())
            bottomSheetDialog.dismiss()
        }
        enam?.setOnClickListener {
            b.edtR.setText(enam.text.toString())
            bottomSheetDialog.dismiss()
        }
        tujuh?.setOnClickListener {
            b.edtR.setText(tujuh.text.toString())
            bottomSheetDialog.dismiss()
        }
        delapan?.setOnClickListener {
            b.edtR.setText(delapan.text.toString())
            bottomSheetDialog.dismiss()
        }

        selesai?.setOnClickListener {
            b.edtR.setText(sembilan?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetG() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_h)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ha)
        val dua = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.Hb)
        val tiga = bottomSheetDialog.findViewById<AppCompatEditText>(R.id.Hc)
        val sKab = bottomSheetDialog.findViewById<Button>(R.id.sK)
        val sNeg = bottomSheetDialog.findViewById<Button>(R.id.sN)

        bottomSheetDialog.show()

        satu?.setOnClickListener {
            b.edtG.setText(satu.text.toString())
            bottomSheetDialog.dismiss()
        }

        sKab?.setOnClickListener {
            b.edtG.setText(dua?.text.toString())
            bottomSheetDialog.dismiss()
        }

        sNeg?.setOnClickListener {
            b.edtG.setText(tiga?.text.toString())
            bottomSheetDialog.dismiss()
        }
    }

    private fun bottomShetH(s : String) {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_i)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ia)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Ib)
        val tiga = bottomSheetDialog.findViewById<TextView>(R.id.Ic)

        bottomSheetDialog.show()

        if (s == "H"){
            satu?.setOnClickListener {
                b.edtH.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtH.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
            tiga?.setOnClickListener {
                b.edtH.setText(tiga.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

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
    }

    @SuppressLint("SetTextI18n")
    private fun bottomShetE(s: String) {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_e)
        val satu = bottomSheetDialog.findViewById<TextView>(R.id.Ea)
        val dua = bottomSheetDialog.findViewById<TextView>(R.id.Eb)
        val pertanyaan = bottomSheetDialog.findViewById<TextView>(R.id.pertanyaan)

        bottomSheetDialog.show()

        if (s == "Uu"){
            pertanyaan?.text = "Dalam Seminggu terakhir, apakah Anda memiliki lebih dari satu pekerjaan ?"
            satu?.setOnClickListener {
                b.edtUu.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtUu.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Qq"){
            pertanyaan?.text = "Apakah seminggu terakhir Anda hanya bekerja dirumah sendiri sepenuhnya ?"
            satu?.setOnClickListener {
                b.edtQq.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtQq.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Oo"){
            pertanyaan?.text = "Apakah Anda bekerja ditempat keramian ?"
            satu?.setOnClickListener {
                b.edtOo.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtOo.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Ii"){
            pertanyaan?.text = "Apakah menggunakan internet untuk promosi ?"
            satu?.setOnClickListener {
                b.edtIi.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtIi.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Jj"){
            pertanyaan?.text = "Apakah menggunakan internet untuk komunikasi ?"
            satu?.setOnClickListener {
                b.edtJj.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtJj.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Kk"){
            pertanyaan?.text = "Apakah menggunakan internet untuk Transaksi/jual/beli ?"
            satu?.setOnClickListener {
                b.edtKk.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtKk.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Hh"){
            pertanyaan?.text = "Apakah menggunakan internet pada pekerjaan ?"
            satu?.setOnClickListener {
                b.edtHh.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtHh.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "Gg"){
            pertanyaan?.text = "Apakah alasan tersebut terkait dengan Corona/Covid-19 ?"
            satu?.setOnClickListener {
                b.edtGg.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtGg.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "S"){
            pertanyaan?.text = "Apakah alasan tersebut terkait dengan Corona/Covid-19 ?"
            satu?.setOnClickListener {
                b.edtS.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtS.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

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
                b.edtFak.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtFak.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }

        if (s == "O"){
            pertanyaan?.text = "Dalam seminggu terakhir, apakah anda membantu kegiatan usaha untuk memperoleh uang ?"
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
            pertanyaan?.text = "Dalam seminggu terakhir, apakah  Anda membantu pekerjaan keluarga/orang lain ?"
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
            pertanyaan?.text = "Apakah Anda sebenarnya memiliki pekerjaan, tetapi seminggu terakhir sedang tidak bekerja ?"
            satu?.setOnClickListener {
                b.edtQ.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtQ.setText(dua.text.toString())
                bottomSheetDialog.dismiss()
            }
        }
        if (s == "N"){
            pertanyaan?.text = "Dalam seminggu terakhir, apakah Anda bekerja ?"
            satu?.setOnClickListener {
                b.edtN.setText(satu.text.toString())
                bottomSheetDialog.dismiss()
            }
            dua?.setOnClickListener {
                b.edtN.setText(dua.text.toString())
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
        progress.show()
        val i = intent.extras

        val data  = DataChildKeluarga(
                    i?.getString("idParent").toString(),
                    i?.getString("id").toString(),
                    b.edtNik.text.toString(),
                    b.edtNama.text.toString(),
                    b.edtA.text.toString(),
                    b.edtB.text.toString(),
                    b.edtC.text.toString(),
                    b.edtD.text.toString(),
                    b.edtE.text.toString(),
                    b.edtF.text.toString(),
                    b.edtFak.text.toString(),
                    b.edtG.text.toString(),
                    b.edtH.text.toString(),
                    b.edtI.text.toString(),
                    b.edtJ.text.toString(),
                    b.edtK.text.toString(),
                    b.edtL.text.toString(),
                    b.edtM.text.toString(),
                    b.edtN.text.toString(),
                    b.edtO.text.toString(),
                    b.edtP.text.toString(),
                    b.edtQ.text.toString(),
                    b.edtR.text.toString(),
                    b.edtS.text.toString(),
                    b.edtT.text.toString(),
                    b.edtU.text.toString(),
                    b.edtV.text.toString(),
                    b.edtW.text.toString(),
                    b.edtX.text.toString(),
                    b.edtXxx.text.toString(),
                    b.edtY.text.toString(),
                    b.edtZ.text.toString(),
                    b.edtAa.text.toString(),
                    b.edtAaa.text.toString(),
                    b.edtBb.text.toString(),
                    b.edtCc.text.toString(),
                    b.edtDd.text.toString(),
                    b.edtEe.text.toString(),
                    b.edtFf.text.toString(),
                    b.edtGg.text.toString(),
                    b.edtHh.text.toString(),
                    b.edtIi.text.toString(),
                    b.edtJj.text.toString(),
                    b.edtKk.text.toString(),
                    b.edtLl.text.toString(),
                    b.edtMm.text.toString(),
                    b.edtNn.text.toString(),
                    b.edtOo.text.toString(),
                    b.edtPp.text.toString(),
                    b.edtQq.text.toString(),
                    b.edtRr.text.toString(),
                    b.edtSs.text.toString(),
                    b.edtTt.text.toString(),
                    b.edtUu.text.toString(),
                    b.edtVv.text.toString()
        )
        DB.child("ChildKeluarga").child(i?.getString("id").toString())
            .setValue(data)
            .addOnCompleteListener {
                progress.dismiss()
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
        val i = intent.extras
        val bundle = Bundle()
        val intent = Intent(this, ListKeluarga::class.java)
        bundle.putString("id", i?.getString("idParent").toString())
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }
}