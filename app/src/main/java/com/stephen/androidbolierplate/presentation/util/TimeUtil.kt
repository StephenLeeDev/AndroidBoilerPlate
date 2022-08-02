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
    val YYYY_MM_DD_KR = "yyyy년 MM월 dd일"
    val YYYY_MM_DD = "yyyyMMdd"
    val MM_DD = "MM월 dd일"

    fun getLongToHHmm(milliseconds: Long): String {

        val hours = TimeUnit.MILLISECONDS.toMinutes(milliseconds) / 60
        val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60

        return String.format("%02d:%02d", hours, minutes)
    }

    fun getTodayDateStringByFormat(format: String = YYYY_MM_DD_KR): String =
        LocalDateTime.now().toString(format)

    fun getDateStringByFormat(dateString: String, format: String = YYYY_MM_DD_KR): String =
        LocalDateTime.parse(dateString).toString(format)

    fun getIntervalDateStringByFormat(dateString: String, format: String = YYYY_MM_DD_KR, interval: Int): String =
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

    // 시작일과 종료일이 몇일 간격인지 리턴
    fun getIntervalFromBothDates(beginDate: LocalDateTime, endDate: LocalDateTime): Int {
        return Days.daysBetween(beginDate, endDate).days
    }

    /**
     * 1분 미만 == 방금 전,
     * 1시간 미만 == 00분 전,
     * 1일 미만 == 어제,
     * else == YYYY_MM_DD
     */
    fun getIntervalByString(dateString: String): String {
        val now = LocalDateTime.now().toDate().time
        val target = LocalDateTime.parse(dateString).toDate().time
        val intervalDate = now - target

        // 며칠전 메시지인지 일일 단위로 반환
        // 3일 전 == return 3
        val intervalByDays =
            getIntervalFromBothDates(LocalDateTime.now(), LocalDateTime.parse(dateString))

        return when {
            (intervalDate < 1000 * 60) -> "방금 전"
            (intervalDate < 1000 * 60 * 60) -> "${intervalDate / (1000 * 60)}분 전"
            (intervalDate < 1000 * 60 * 60 * 24) -> "${intervalDate / (1000 * 60 * 60)}시간 전"
            (intervalDate < 1000 * 60 * 60 * 24 * 2) -> "어제"
            intervalByDays < 7 -> "${intervalDate / (1000 * 60 * 60 * 24)}일 전"
            intervalByDays < 365 -> getDateStringByFormat(format = MM_DD, dateString = dateString)
            else -> getDateStringByFormat(format = YYYY_MM_DD_KR, dateString = dateString)
        }
    }

}