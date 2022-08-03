package com.stephen.androidbolierplate

import com.stephen.androidbolierplate.presentation.util.TimeUtil
import org.joda.time.LocalDateTime
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    /**
     * 두 날짜의 일일 단위 간격 반환 테스트
     */
    @Test
    fun getIntervalFromBothDates() {
        val now = LocalDateTime.now()
        val target = LocalDateTime.parse("2022-07-29")

        val interval = TimeUtil.getIntervalFromBothDates(target, now)

        assertEquals(interval, 4)
    }

    /**
     * 채팅방 마지막 메시지 생성일 기준으로 String 포맷의 날짜 반환 테스트
     */
    @Test
    fun getIntervalByString() {
        val interval = TimeUtil.getIntervalByString("2022-08-02T14:58:18.073")
        assertEquals(interval, "2022년 07월 29일")
    }

}