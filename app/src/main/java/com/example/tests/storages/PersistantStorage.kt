package com.example.tests.storages

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor



class PersistantStorage {
    val APP_PREFERENCES = "StorageName"

    private var settings: SharedPreferences? = null
    private var editor: Editor? = null
    private var context: Context? = null

}