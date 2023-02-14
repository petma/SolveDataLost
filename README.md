问题：mysql 通过更新时间增量同步时，翻页时，可能因前面返回数据的更新时间改变，导致数据丢失
解决方案：使用更新时间切片来解决，不使用翻页
如何使用：
 
   //不使用分页，不用order by 
    override fun dealYourBiz(startDateTime: LocalDateTime, tempdate: LocalDateTime) {
        val sql= "select * from orders where updated_time between '$startDateTime' and '$tempdate'  "
        println(sql)
    }

    //按需切片
    override fun changeTempDate(startDateTime: LocalDateTime): LocalDateTime {
        return startDateTime.plusHours(12)
    }


