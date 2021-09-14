package com.example.sakernasela.petugas

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.databinding.ItemDataParentBinding
import com.example.sakernasela.entity.DataParentKeluarga

class AdapterParent(val listDataParent : List<DataParentKeluarga>, val context: Activity,
                    val onClick : (DataParentKeluarga) -> Unit)
    : RecyclerView.Adapter<AdapterParent.DataHolder>() {

    inner class DataHolder(val itemData : ItemDataParentBinding) : RecyclerView.ViewHolder(itemData.root){
        fun bindPetugas(data : DataParentKeluarga, onClick: (DataParentKeluarga) -> Unit){
            itemData.tvKk.text = data.kartuKeluarga
            itemData.tvKepala.text = data.kepalaKeluarga
            itemData.tvAlamat.text = data.alamat

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
        holder.bindPetugas(listDataParent[position], onClick)
    }

    override fun getItemCount(): Int = listDataParent.size
}