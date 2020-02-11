package com.home.futuretalentnetworktestdemo.detail.model.viewstate

import com.home.futuretalentnetworktestdemo.detail.model.viewdata.DetailViewData

sealed class DetailViewState

object Loading : DetailViewState()
data class Success(val data: DetailViewData) : DetailViewState()
data class NetworkError(val message: String?) : DetailViewState()