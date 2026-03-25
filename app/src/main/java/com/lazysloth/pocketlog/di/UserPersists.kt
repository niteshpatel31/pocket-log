package com.lazysloth.pocketlog.di

import android.content.Context
import androidx.compose.ui.autofill.ContentType
import androidx.core.content.edit


class UserPersists (
  context: Context
) {
    private val prefs =
        context.getSharedPreferences("session",Context.MODE_PRIVATE)
    private val prefs2=
        context.getSharedPreferences("id", Context.MODE_PRIVATE)
    var currentId: Int
        get() = prefs.getInt("user_id",-1)
        set(value) = prefs.edit { putInt("user_id", value) }

    var transactionId: Int
        get() = prefs2.getInt("transaction_id",-1)
            set(value) = prefs2.edit { putInt("transaction_id",value) }

    fun logout(){
        prefs.edit { clear() }
    }
}