package com.exam.mercuriesdata_exam.module

import com.exam.mercuriesdata_exam.di.ServerGithub
import com.exam.mercuriesdata_exam.di.ServerMds
import com.slack.eithernet.ApiResultCallAdapterFactory
import com.slack.eithernet.ApiResultConverterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @ServerMds
    @Singleton
    @Provides
    fun provideRetrofitServerMds(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://cloud.mds.com.tw")
        .addCallAdapterFactory(ApiResultCallAdapterFactory)
        .addConverterFactory(ApiResultConverterFactory)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @ServerGithub
    @Singleton
    @Provides
    fun provideRetrofitServerRaw(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com")
        .addCallAdapterFactory(ApiResultCallAdapterFactory)
        .addConverterFactory(ApiResultConverterFactory)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}