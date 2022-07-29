package com.stephen.androidbolierplate.presentation.util

import org.joda.time.Days
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.util.concurrent.TimeUnit

/**
 * Written by StephenLeeDev on 2022/07/29.
 */

object TimeUtil {

    val YYYY_MM_DD_E = "yyyy년 MM월 dd일 (E)"
    val YYYY_MM_DD_E_DOT = "yyyy.MM.dd (E)"
    val YYYY_MM_DD = "yyyy-MM-dd"

    fun getLongToHHmm(milliseconds: Long): String {

        val hours = TimeUnit.MILLISECONDS.toMinutes(milliseconds) / 60
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60

        return String.format("%02d:%02d", hours, minutes)
    }

    fun getTodayDateStringByFormat(format: String = YYYY_MM_DD): String =
        LocalDateTime.now().toString(format)

    fun getDateStringByFormat(dateString: String, format: String = YYYY_MM_DD): String =
        LocalDateTime.parse(dateString).toString(format)

    fun getIntervalDateStringByFormat(dateString: String, format: String = YYYY_MM_DD, interval: Int): String =
        LocalDateTime.parse(dateString).plusDays(interval).toString(format)

    // 시작일이 종료일보다 이전 날짜인지 판별
    fun isValidDates(beginDate: String, endDate: String): Boolean =
        LocalDateTime.parse(beginDate).isBefore(LocalDateTime.parse(endDate))

    // 시작일과 종료일이 몇일 간격인지 리턴
    fun getIntervalFromBothDates(beginDate: String, endDate: String): Int {
        val dtf = DateTimeFormat.forPattern(YYYY_MM_DD)
        val begin = dtf.parseDateTime(beginDate)
        val end = dtf.parseDateTime(endDate)
        return Days.daysBetween(begin, end).days
    }

}