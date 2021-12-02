package com.yoon.customviewtest

import org.joda.time.DateTime

data class Book(
    val title: String,
    val bookCoverUrl: String,
    val readDate: DateTime,
    val readTime: Long,
    val isFinished : Boolean
)