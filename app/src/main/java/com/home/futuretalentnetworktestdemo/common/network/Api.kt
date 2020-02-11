package com.home.futuretalentnetworktestdemo.common.network

import com.home.futuretalentnetworktestdemo.detail.model.pojo.UserDetailPojo
import com.home.futuretalentnetworktestdemo.list.model.pojo.UserBriefPojo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun getUserBriefList(@Query("per_page") per_page: Int): List<UserBriefPojo>

    @GET("users/{userName}")
    suspend fun getUserDetail(@Path("userName") userId: String): UserDetailPojo
}
