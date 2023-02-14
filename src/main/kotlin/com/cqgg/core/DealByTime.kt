package com.cqgg.core

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class DealByTime {

    fun deal(startTime: String, endTime: String) {
        val df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var startDateTime = try {
            LocalDateTime.parse(startTime, df)
        } catch (e: Exception) {
            LocalDateTime.parse(startTime + " 00:00:00", df)
        }

        val endDateTime = try {
            LocalDateTime.parse(endTime, df)
        } catch (e: Exception) {
            LocalDateTime.parse(endTime + " 00:00:00", df)
        }
        var tempdate: LocalDateTime
        while (true) {
            println("开始时间" + df.format(startDateTime))
            tempdate = changeTempDate(startDateTime)
            if (tempdate.isBefore(endDateTime)) {
                println("结束时间" + df.format(tempdate))
                dealYourBiz(startDateTime, tempdate)
                startDateTime = tempdate

            } else {

                println("结束时间" + df.format(endDateTime))
                dealYourBiz(startDateTime, endDateTime)
                break
            }

        }
    }

    abstract fun dealYourBiz(startDateTime: LocalDateTime, tempdate: LocalDateTime)
    //todo implement
    open fun changeTempDate(startDateTime: LocalDateTime): LocalDateTime {
        return startDateTime.plusHours(4)
    }
}
