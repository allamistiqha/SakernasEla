package com.example.sakernasela.utils

import android.content.Context
import android.content.SharedPreferences

class PrefManager {

    private fun getSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences("Data", 0)
    }

    fun setStatusLog(context: Context, status: Boolean) {
        val editor = getSharedPreference(context).edit()
        editor.putBoolean("statusLog", status)
        editor.apply()
    }

    fun getStatusLog(context: Context): Boolean {
        return getSharedPreference(context).getBoolean("statusLog", false)
    }

    fun setUserId(context: Context, id: String?){
        val editor = getSharedPreference(context).edit()
        editor.putString("id", id)
        editor.apply()
    }

    fun getUserId(context: Context): String? {
        return getSharedPreference(context).getString("id", "")
    }

    fun setUserName(context: Context, id: String?){
        val editor = getSharedPreference(context).edit()
        editor.putString("name", id)
        editor.apply()
    }

    fun getUserName(context: Context): String? {
        return getSharedPreference(context).getString("name", "")
    }

    fun clear(context: Context) {
        val editor = getSharedPreference(context).edit()
//        editor.remove("Data")
//        editor.remove("nickName")
        editor.remove("statusLogin")
        editor.apply()
    }

}