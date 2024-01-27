package com.lwons.wiserbudget.log

import com.lwons.wiserbudget.log.LogLevel.DEBUG
import com.lwons.wiserbudget.log.LogLevel.ERROR
import com.lwons.wiserbudget.log.LogLevel.FATAL
import com.lwons.wiserbudget.log.LogLevel.INFO
import com.lwons.wiserbudget.log.LogLevel.WARN

object Logger {

    private val logImpl by lazy {
        LogcatLogImpl()
    }

    fun d(tag: String, msg: String) {
        logImpl.log(DEBUG, tag, msg)
    }

    fun i(tag: String, msg: String) {
        logImpl.log(INFO, tag, msg)
    }

    fun w(tag: String, msg: String) {
        logImpl.log(WARN, tag, msg)
    }

    fun e(tag: String, msg: String) {
        logImpl.log(ERROR, tag, msg)
    }

    fun fatal(tag: String, msg: String) {
        logImpl.log(FATAL, tag, msg)
    }

}



