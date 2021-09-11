package com.example.sakernasela.admin.pembagianData

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.databinding.ItemDataParentBinding
import com.example.sakernasela.entity.DataChildKeluarga

class AdapterDataChildKeluarga (val listDataChild : List<DataChildKeluarga>,
                                val onClick : (DataChildKeluarga) -> Unit)
    : RecyclerView.Adapter<AdapterDataChildKeluarga.DataHolder>() {

    inner class DataHolder(val itemData : ItemDataParentBinding) : RecyclerView.ViewHolder(itemData.root){
        @SuppressLint("SetTextI18n")
        fun bindPetugas(data : DataChildKeluarga, onClick: (DataChildKeluarga) -> Unit){
            itemData.tvKk.text = data.nomerI
            itemData.tvKepala.text = data.nama
            itemData.al.visibility = View.GONE
            itemData.nama.text = "Nama : "
            itemData.kk.text = "No.Induk : "
            itemData.tvAlamat.visibility = View.GONE

            itemData.lyParent.setOnClickListener {
                onClick(data)
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
        holder.bindPetugas(listDataChild[position], onClick)
    }

    override fun getItemCount(): Int = listDataChild.size
}