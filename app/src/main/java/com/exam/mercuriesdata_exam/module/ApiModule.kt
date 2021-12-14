package com.exam.mercuriesdata_exam.module

import com.exam.mercuriesdata_exam.api.NameApi
import com.exam.mercuriesdata_exam.api.ListDataApi
import com.exam.mercuriesdata_exam.di.ServerGithub
import com.exam.mercuriesdata_exam.di.ServerMds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Reusable
    @Provides
    fun provideApi(@ServerMds retrofit: Retrofit): NameApi =
        retrofit.create(NameApi::class.java)

    @Reusable
    @Provides
    fun provideListDataApi(@ServerGithub retrofit: Retrofit): ListDataApi =
        retrofit.create(ListDataApi::class.java)
}