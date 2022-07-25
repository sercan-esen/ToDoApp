package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.repo.YapilacaklarDaoRepository
import com.example.myapplication.room.Veritabani
import com.example.myapplication.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarDaoRepository(ydao : YapilacaklarDao) : YapilacaklarDaoRepository{
        return YapilacaklarDaoRepository(ydao)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context) : YapilacaklarDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"ornekIs.sqlite")
            .createFromAsset("ornekIs.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}