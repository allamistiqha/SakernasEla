package com.example.sakernasela.admin.pembagianData

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.admin.listPetugas.ListPetugas
import com.example.sakernasela.databinding.ItemDataParentBinding
import com.example.sakernasela.entity.DataParentKeluarga

class AdapterDataParentKeluarga(val listDataParent : List<DataParentKeluarga>,val context: Activity,
                                val onClick : (DataParentKeluarga) -> Unit)
    : RecyclerView.Adapter<AdapterDataParentKeluarga.DataHolder>() {

    inner class DataHolder(val itemData : ItemDataParentBinding) : RecyclerView.ViewHolder(itemData.root){
        fun bindPetugas(data : DataParentKeluarga, onClick: (DataParentKeluarga) -> Unit){
            itemData.tvKk.text = data.kartuKeluarga
            itemData.tvKepala.text = data.kepalaKeluarga
            itemData.tvAlamat.text = data.alamat

            itemData.lyParent.setOnClickListener {
                onClick(data)
            }

            itemData.edtPetugas.visibility = View.VISIBLE
            itemData.edtPetugas.setText(data.petugas)

            itemData.edtPetugas.setOnClickListener {
                val i = Bundle()
                val intent = Intent(context, ListPetugas::class.java)
                i.putString("p", "pilih")
                i.putString("id", data.idKeluarga)
                i.putString("kk", data.kartuKeluarga)
                i.putString("kepala", data.kepalaKeluarga)
                i.putString("alm", data.alamat)
                i.putString("petugas", data.petugas)

                intent.putExtras(i)
                context.startActivity(intent)
                context.finish()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind = ItemDataParentBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent, false)
        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bindPetugas(listDataParent[position], onClick)
    }

    override fun getItemCount(): Int = listDataParent.size
}