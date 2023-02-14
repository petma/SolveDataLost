package com.cqgg.sample

import com.cqgg.core.DealByTime
import java.time.LocalDateTime

class Mybiz: DealByTime() {
    override fun dealYourBiz(startDateTime: LocalDateTime, tempdate: LocalDateTime) {
        val sql= "select * from orders where updated_time between '$startDateTime' and '$tempdate'  "
        println(sql)
    }


    override fun changeTempDate(startDateTime: LocalDateTime): LocalDateTime {
        return startDateTime.plusHours(12)
    }
}
