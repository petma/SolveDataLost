package com.cqgg.sample

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val startTime = "2023-01-30 11:00:01"
        val endTime = "2023-01-31 11:10:01"
        val mybiz= Mybiz()
        mybiz.deal(startTime,endTime)


    }
}
