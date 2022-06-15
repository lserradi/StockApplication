package com.lara.s.lopez.core.logger

interface Logger {

    fun error(TAG: String, message: String)

    fun debug(TAG: String, message: String)

    fun warning(TAG: String, message: String)
}