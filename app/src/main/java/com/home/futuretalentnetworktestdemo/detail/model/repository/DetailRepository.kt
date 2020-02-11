package com.home.futuretalentnetworktestdemo.detail.model.repository

import com.home.futuretalentnetworktestdemo.common.network.Api
import com.home.futuretalentnetworktestdemo.detail.model.pojo.UserDetailPojo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject
constructor(private val api: Api) {

    suspend fun getUserDetail(userName: String): UserDetailPojo {
        return api.getUserDetail(userName)
    }
}

