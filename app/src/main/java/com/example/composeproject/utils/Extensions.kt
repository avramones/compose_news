package com.example.composeproject.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toCorrectDate(): String = try {
    val zonedFormat = SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val stringDateFormat = SimpleDateFormat(
        "MMMM dd, yyyy", Locale.getDefault())
    stringDateFormat.format(zonedFormat.parse(this))

} catch (e: Exception) {
    ""
}