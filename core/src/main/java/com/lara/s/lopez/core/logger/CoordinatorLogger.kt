package com.lara.s.lopez.core.logger

import javax.inject.Inject

class CoordinatorLogger @Inject constructor(
    androidLogger: AndroidLogger
) : Logger {
    private val loggers = listOf(androidLogger)

    override fun debug(TAG: String, message: String) {
        loggers.map { logger -> logger.debug(TAG, message) }
    }

    override fun error(TAG: String, message: String) {
        loggers.map { logger -> logger.error(TAG, message) }
    }

    override fun warning(TAG: String, message: String) {
        loggers.map { logger ->
            logger.warning(TAG, message)
        }
    }
}