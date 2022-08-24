package com.vmloft.develop.library.data.bean

import android.os.Parcelable

import com.google.gson.annotations.SerializedName

import kotlinx.parcelize.Parcelize

/**
 * Create by lzan13 on 2020/7/30 16:04
 * 描述：角色对象数据 Bean
 */
@Parcelize
data class Role(
    @SerializedName("_id")
    var id: String ="",
    var title: String = "",
    var desc: String = "",
    var identity: Int = 0, // 角色身份级别
) : Parcelable {
}