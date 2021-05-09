package com.sinlov.kotlin.util

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

class DateUtil {
    companion object {
        /**
         * format as yyyy-MM-dd
         */
        fun nowDateStr(): String {
            return nowDateStr("yyyy-MM-dd")
        }

        fun nowDateStr(format: String): String {
            return SimpleDateFormat(format, Locale.getDefault()).format(Date())
        }
    }
}