package com.lwons.wiserbudget.log

interface ILogImpl {
    fun log(level: LogLevel, tag: String, msg: String)
}

enum class LogLevel(lvl: Int) {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5)
}