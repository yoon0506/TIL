package com.yoon.customviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class SpinnerAdapter(context: Context, data: List<String>?) :
    BaseAdapter() {
    private var mContext: Context = context
    var Data: List<String>? = data
    var inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return if (Data != null) Data!!.size else 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? { //처음에 클릭전에 보여지는 레이아웃
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_custom, parent, false)
        }
        if (Data != null) {
            val text = Data!![position]
            (convertView!!.findViewById(R.id.spinnerText) as TextView).text = text
        }
        return convertView
    }

    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? { //클릭 후 보여지는 레이아웃
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_getview, parent, false)
        }
        val text = Data!![position]
        (convertView!!.findViewById(R.id.spinnerText) as TextView).text = text
        return convertView
    }

    override fun getItem(position: Int): Any {
        return Data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}