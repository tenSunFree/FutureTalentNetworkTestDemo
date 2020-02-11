package com.home.futuretalentnetworktestdemo.common.di.module

import com.home.futuretalentnetworktestdemo.detail.view.activity.DetailActivity
import com.home.futuretalentnetworktestdemo.list.view.activity.ListActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {

    @ContributesAndroidInjector
    abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity
}
