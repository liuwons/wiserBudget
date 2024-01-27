package com.lwons.wiserbudget.log

import android.util.Log

class LogcatLogImpl: ILogImpl {
    override fun log(level: LogLevel, tag: String, msg: String) {
        when (level) {
            LogLevel.DEBUG -> Log.d(tag, msg)
            LogLevel.INFO -> Log.i(tag, msg)
            LogLevel.WARN -> Log.w(tag, msg)
            LogLevel.ERROR -> Log.e(tag, msg)
            LogLevel.FATAL -> Log.wtf(tag, msg)
        }
    }
}