package com.yoon.customviewtest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoon.customviewtest.databinding.FragmentWeekBinding
import org.joda.time.DateTime
import java.text.ParseException
import java.text.SimpleDateFormat


class WeekFragment : BaseFragment<FragmentWeekBinding>(){

    private var mBookDataList = ArrayList<Book>()
    private lateinit var mReadTimeList: ArrayList<Int>  // 임시로 만든 데이터리스트 추후 mBookList의 readTime으로 변경해야함.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTestCase()
        setSpinner()
        if (mBookDataList.size > 0) {

        } else {
            mBinding.scrollView.visibility = GONE
            mBinding.noReadDataContainer.visibility = VISIBLE
        }

//        setTestCase()

        mBinding.prev.setOnClickListener {
            val result = "prev"
//            setFragmentResult(Key.MOVE_PAGE, bundleOf(Key.BUNDLE_KEY to result))
            Toast.makeText(
                context,
                "result: $result",
                Toast.LENGTH_SHORT
            ).show()
        }
        mBinding.next.setOnClickListener {
            val result = "next"
//            setFragmentResult(Key.MOVE_PAGE, bundleOf(Key.BUNDLE_KEY to result))
            Toast.makeText(
                context,
                "result: $result",
                Toast.LENGTH_SHORT
            ).show()
        }

        mBinding.purchaseBooksRecyclerView.adapter = PurchaseBookAdapter(mBookDataList)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mBinding.purchaseBooksRecyclerView.layoutManager = layoutManager
    }

    private fun setSpinner() {

        val weeks: ArrayList<String> = ArrayList()
        for (i in 1..5) {
            weeks.add("12월 " + i.toString() + "주") //ArrayList에 내가 스피너에 보여주고싶은 값 셋팅
        }
        val adapter = SpinnerAdapter(context!!, weeks)
        mBinding.spinner.adapter = adapter
        mBinding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    context,
                    "Selected: ${mBinding.spinner.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
            }

        }
    }

    override fun getViewBinding(): FragmentWeekBinding {
        return FragmentWeekBinding.inflate(layoutInflater)
    }

    private fun setTestCase() {
        // temp
        // for book test
        val url1 = "https://image.aladin.co.kr/product/28294/2/cover/E902539891_1.jpg"  // 트렌드코리아
        val dtStart1 = "2021-12-22T20:57:21"
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            val date1 = sdf.parse(dtStart1).time

            val dt1 = DateTime(date1)
            var bookdata1_4 = Book("메롱ㅎ", url1, DateTime.now(), -3770000, false)
            var bookdata2 = Book("메롱222", url1, dt1, -3120000, false)

            mBookDataList.add(bookdata1_4)
            mBookDataList.add(bookdata2)

        } catch (ex: ParseException) {
            Log.v("Exception", ex.localizedMessage)
        }
    }
}