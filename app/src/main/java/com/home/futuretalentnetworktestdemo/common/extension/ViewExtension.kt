package com.home.futuretalentnetworktestdemo.common.extension

import android.view.View
import com.home.futuretalentnetworktestdemo.R

/**
 * 點擊事件
 */
inline fun View.click(crossinline function: (view: View) -> Unit) {
    this.setOnClickListener {
        val tag = this.getTag(R.id.id_tag_click)
        val millisecond = 1000
        if (tag == null || System.currentTimeMillis() - tag.toString().toLong() > millisecond) {
            this.setTag(R.id.id_tag_click, System.currentTimeMillis())
            function.invoke(it)
        }
    }
}