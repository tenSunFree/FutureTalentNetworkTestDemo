package com.home.futuretalentnetworktestdemo.common.di.component

import android.app.Application
import com.home.futuretalentnetworktestdemo.common.FTNTDApplication
import com.home.futuretalentnetworktestdemo.common.di.module.ActivityBindModule
import com.home.futuretalentnetworktestdemo.common.network.module.NetworkModule
import com.home.futuretalentnetworktestdemo.common.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class,
        ActivityBindModule::class, NetworkModule::class]
)
interface ApplicationComponent {

    fun inject(tFDApplication: FTNTDApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
