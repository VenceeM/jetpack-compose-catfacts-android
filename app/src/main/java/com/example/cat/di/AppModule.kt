package com.example.cat.di

import com.example.cat.feature_cat_facts.data.core.CatFactApi
import com.example.cat.feature_cat_facts.data.repository.CatFactRepositoryImpl
import com.example.cat.feature_cat_facts.domain.repository.CatFactRepository
import com.example.cat.feature_cat_facts.domain.usecase.GetCatFactUseCase
import com.example.cat.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatFactRepository(api:CatFactApi):CatFactRepository{
        return CatFactRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetFactUseCase(repository: CatFactRepository):GetCatFactUseCase{
        return GetCatFactUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCatFactApi():CatFactApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatFactApi::class.java)
    }

}