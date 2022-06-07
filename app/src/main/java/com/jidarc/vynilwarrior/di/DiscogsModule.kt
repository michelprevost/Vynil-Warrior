package com.jidarc.vynilwarrior.di

import com.jidarc.vynilwarrior.data.network.DiscogsApi
import com.jidarc.vynilwarrior.data.repositories.DiscogRepository
import com.jidarc.vynilwarrior.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiscogsModule {

    @Singleton
    @Provides
    fun provideDiscogsApi(): DiscogsApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.DISCOGS_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DiscogsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideBookRepository(api: DiscogsApi) = DiscogRepository(api)

}