package com.example.myapplication.room

import androidx.room.*
import com.example.myapplication.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacakIsEkle(yapilacakIs:Yapilacaklar)

    @Update
    suspend fun yapilacakIsGuncelle(yapilacakIs:Yapilacaklar)

    @Delete
    suspend fun yapilacakIsSil(yapilacakIs:Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE  yapilacak_is_tanim like '%' || :aramaKelimesi || '%' ")
    suspend fun yapilacakAra(aramaKelimesi : String) : List<Yapilacaklar>


}