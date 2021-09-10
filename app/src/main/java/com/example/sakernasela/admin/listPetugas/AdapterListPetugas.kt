package com.example.sakernasela.admin.listPetugas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sakernasela.databinding.ItemListPetugasBinding
import com.example.sakernasela.entity.LoginPetugasModel

class AdapterListPetugas(val listPetugas : List<LoginPetugasModel>,
                          val onClick : (LoginPetugasModel) -> Unit)
: RecyclerView.Adapter<AdapterListPetugas.PetugasHolder>() {

    inner class PetugasHolder(val itemPetugas : ItemListPetugasBinding) : RecyclerView.ViewHolder(itemPetugas.root){
        fun bindPetugas(petugas : LoginPetugasModel, onClick: (LoginPetugasModel) -> Unit){
            itemPetugas.btnNamePetugas.text = petugas.userName
            itemPetugas.btnNamePetugas.setOnClickListener {
                onClick(petugas)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetugasHolder {
            val bind = ItemListPetugasBinding.inflate(
                LayoutInflater.from(parent.context)
                    , parent, false)
           return PetugasHolder(bind)
    }

    override fun onBindViewHolder(holder: PetugasHolder, position: Int) {
        holder.bindPetugas(listPetugas[position], onClick)
    }

    override fun getItemCount(): Int = listPetugas.size
}