package com.cqgg.core

import com.cqgg.core.exception.PullDataException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class DealByTime {

    fun deal(startTime: String, endTime: String, params: Any?) {
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
                try {
                    dealYourBiz(startDateTime, tempdate, params)
                } catch (e: PullDataException) {
                    // TODO("Not yet implemented")
                    if (e.isBreak) {
                        break
                    }
                }
                startDateTime = tempdate

            } else {
                try {
                    println("结束时间" + df.format(endDateTime))
                    dealYourBiz(startDateTime, endDateTime, params)
                } catch (e: PullDataException) {
                    // TODO("Not yet implemented")

                }
                break
            }

        }
    }

    abstract fun dealYourBiz(startDateTime: LocalDateTime, tempdate: LocalDateTime, params: Any?)

    //todo implement
    open fun changeTempDate(startDateTime: LocalDateTime): LocalDateTime {
        return startDateTime.plusHours(4)
    }
}
