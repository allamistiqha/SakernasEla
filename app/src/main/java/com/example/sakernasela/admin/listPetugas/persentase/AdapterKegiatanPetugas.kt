package com.example.sakernasela.admin.listKegiatan.persentase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.databinding.ItemLisiKegiatanBinding
import com.example.sakernasela.entity.StatisticKerja

class AdapterKegiatanPetugas (val listKegiatan : List<StatisticKerja>,
                              val onClick : (StatisticKerja) -> Unit)
    : RecyclerView.Adapter<AdapterKegiatanPetugas.PetugasHolder>() {

    inner class PetugasHolder(val itemPetugas : ItemLisiKegiatanBinding) : RecyclerView.ViewHolder(itemPetugas.root){
        fun bindPetugas(kegiatan : StatisticKerja, onClick: (StatisticKerja) -> Unit){

            itemPetugas.kegiatan.text = kegiatan.messageKerjaan
            itemPetugas.kepala.text = kegiatan.namaKeluarga
            itemPetugas.anggota.text = kegiatan.namaAnggotaKeluarga
            itemPetugas.waktu.text = kegiatan.waktu

            itemPetugas.lyParent.setOnClickListener {
                onClick(kegiatan)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetugasHolder {
        val bind = ItemLisiKegiatanBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent, false)
        return PetugasHolder(bind)
    }

    override fun onBindViewHolder(holder: PetugasHolder, position: Int) {
        holder.bindPetugas(listKegiatan[position], onClick)
    }

    override fun getItemCount(): Int = listKegiatan.size
}