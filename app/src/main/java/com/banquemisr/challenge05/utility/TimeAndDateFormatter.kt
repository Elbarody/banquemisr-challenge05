package com.banquemisr.challenge05.utility

import com.banquemisr.challenge05.utility.TimeAndDateFormatterConstants.Companion.INPUT_DATE_FORMAT
import com.banquemisr.challenge05.utility.TimeAndDateFormatterConstants.Companion.OUTPUT_DATE_FORMAT
import com.banquemisr.challenge05.utility.TimeAndDateFormatterConstants.Companion.TIME_FORMAT_MINUTES
import com.banquemisr.challenge05.utility.TimeAndDateFormatterConstants.Companion.TIME_FORMAT_MINUTES_HOURS
import java.text.SimpleDateFormat
import java.util.Locale

fun formatToMinutesAndHours(runtime: Int): String {
    val hours = runtime / 60
    val minutes = runtime % 60
    return if (hours > 0) {
        String.format(Locale.US, TIME_FORMAT_MINUTES_HOURS, hours, minutes)
    } else {
        String.format(Locale.US, TIME_FORMAT_MINUTES, minutes)
    }
}

fun formatDateToMonthDayYear(inputDate: String): String {
    val inputFormat = SimpleDateFormat(INPUT_DATE_FORMAT, Locale.getDefault())
    val outputFormat =
        SimpleDateFormat(OUTPUT_DATE_FORMAT, Locale.getDefault())

    return try {
        val date = inputFormat.parse(inputDate)
        if (date != null) {
            outputFormat.format(date)
        } else {
            "Error: Invalid date format."
        }
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}

class TimeAndDateFormatterConstants {
    companion object {
        const val TIME_FORMAT_MINUTES_HOURS = "%d h %02d min"
        const val TIME_FORMAT_MINUTES = "%02d min"
        const val INPUT_DATE_FORMAT = "yyyy-MM-dd"
        const val OUTPUT_DATE_FORMAT = "MMM dd, yyyy"
    }

}