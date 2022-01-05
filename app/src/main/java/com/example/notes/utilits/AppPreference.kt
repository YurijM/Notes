package com.example.notes.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreference {
    private const val AUTH_USER = "authUser"
    private const val TYPE_DB = "typeDB"
    private const val NAME_PREF = "preference"

    private lateinit var mPreferences: SharedPreferences

    fun getPreferences(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setAuthUser(auth: Boolean) {
        mPreferences.edit()
            .putBoolean(AUTH_USER, auth)
            .apply()
    }

    fun setTypeDB(type: String) {
        mPreferences.edit()
            .putString(TYPE_DB, type)
            .apply()
    }

    fun getAuthUser(): Boolean {
        return mPreferences.getBoolean(AUTH_USER, false)
    }

    fun getTypeDB(): String {
        return mPreferences.getString(TYPE_DB, TYPE_ROOM).toString()
    }
}