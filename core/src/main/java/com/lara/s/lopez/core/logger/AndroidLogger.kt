package com.lara.s.lopez.core.logger

import android.util.Log
import javax.inject.Inject

class AndroidLogger @Inject constructor(): Logger {

    override fun error(TAG: String, message: String) {
        Log.e(TAG, message)
    }

    override fun debug(TAG: String, message: String) {
        Log.d(TAG, message)
    }

    override fun warning(TAG: String, message: String) {
        Log.w(TAG, message)
    }
}