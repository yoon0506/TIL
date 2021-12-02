package com.yoon.customviewtest.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import com.yoon.customviewtest.R

@SuppressLint("SetTextI18n")
class ReadBookInfoCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    @AttrRes private val defStyleAttr: Int = R.attr.bookTitle,
    @StyleRes private val defStyleRes: Int = R.style.ReadBookInfoCustomView,
) : ConstraintLayout(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private var bookCover: androidx.appcompat.widget.AppCompatImageView
    private var bookTitle: androidx.appcompat.widget.AppCompatTextView
    private var readTime: androidx.appcompat.widget.AppCompatTextView
    private var highLightCount: androidx.appcompat.widget.AppCompatTextView
    private var bookReport: androidx.appcompat.widget.AppCompatTextView
    private var moreHighlight: androidx.appcompat.widget.AppCompatTextView
    private var bookReportBox: ConstraintLayout

    init {
        var infService = Context.LAYOUT_INFLATER_SERVICE
        var li = context.getSystemService(infService) as LayoutInflater
        var view = li.inflate(R.layout.read_book_info_custom_view, this, false)
        addView(view)

        bookCover = findViewById(R.id.book_cover)
        bookTitle = findViewById(R.id.book_title)
        readTime = findViewById(R.id.read_time)
        highLightCount = findViewById(R.id.high_light_count)
        bookReport = findViewById(R.id.book_report)
        moreHighlight = findViewById(R.id.highlight_more_button)
        bookReportBox = findViewById(R.id.book_report_box)

        var typedArray = context.obtainStyledAttributes(attrs, R.styleable.ReadBookInfoCustomView)
        try {
            var typedBookCover =
                typedArray.getResourceId(
                    R.styleable.ReadBookInfoCustomView_bookCover,
                    R.drawable.book_cover
                )
            bookCover.setImageResource(typedBookCover)

            val typedBookTitle = typedArray.getString(R.styleable.ReadBookInfoCustomView_bookTitle)
            bookTitle.text = typedBookTitle

            val typedReadTime = typedArray.getString(R.styleable.ReadBookInfoCustomView_readTime)
            readTime.text = "독서 " + typedReadTime + "분"

            val typedBookReport =
                typedArray.getString(R.styleable.ReadBookInfoCustomView_bookReport)
            if (typedBookReport == null) {
                bookReportBox.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGray))
                bookReport.visibility = GONE
            } else {
                bookReport.text = typedBookReport
            }

            val typedHighLightCount =
                typedArray.getString(R.styleable.ReadBookInfoCustomView_highLightCount)
            highLightCount.text = "하이라이트 " + typedHighLightCount + "개"
            if (typedHighLightCount!!.toInt() == 0) {
                highLightCount.visibility = GONE
                moreHighlight.visibility = GONE
            }

        } finally {
            typedArray.recycle()
        }
    }


    //이미지 적용
    fun setBookCover(data: String) {
        Picasso.get().load(data).into(bookCover)
    }

    fun setBookTitle(data: String) {
        bookTitle.text = data
    }

    fun setReadTime(data: String) {
        readTime.text = "독서 $data"
    }

    fun setReadTime(data: Long) {
        readTime.text = "독서 $data"
    }

    fun setHighLightCount(data: String) {
        highLightCount.text = "하이라이트 $data 개"
    }

    fun setHighLightCount(data: Int) {
        if (data > 0) {
            highLightCount.text = "하이라이트 $data 개"
        } else {
            highLightCount.visibility = GONE
            moreHighlight.visibility = GONE
        }
    }

    fun setBookReport(data: String?) {
        if (data == "" || data == null) {
            bookReportBox.setBackgroundColor(ContextCompat.getColor(context, R.color.lightGray))
            bookReport.visibility = GONE
        } else {
            bookReport.text = data
        }
    }
}