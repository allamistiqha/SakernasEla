package com.example.sakernasela.entity

data class StatisticKerja (
        var idKerjaan : String = "",
        var idPetugas : String = "",
        var namaPetugas : String = "",
        var idParentKeluarga : String = "",
        var namaKeluarga : String = "",
        var idChildKeluarga : String = "",
        var namaAnggotaKeluarga : String = "",
        var messageKerjaan : String = "",
        var status : String = "",
        var waktu : String = ""
    )