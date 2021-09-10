package com.example.sakernasela.utils

import com.google.firebase.database.FirebaseDatabase

object Constants {
    val DB = FirebaseDatabase.getInstance().reference
    val prefManager = PrefManager()
}