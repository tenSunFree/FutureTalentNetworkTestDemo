package com.home.futuretalentnetworktestdemo.list.model.viewstate

import com.home.futuretalentnetworktestdemo.list.model.viewdata.ListViewData

sealed class ListViewState

object Loading : ListViewState()
data class Success(val data: ListViewData) : ListViewState()
data class NetworkError(val message: String?) : ListViewState()