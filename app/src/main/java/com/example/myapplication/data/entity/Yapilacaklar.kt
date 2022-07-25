package com.example.myapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "yapilacak_is_id") @NotNull var yapilacak_is_id : Int,
                        @ColumnInfo(name = "yapilacak_is_tanim") @NotNull var yapilacak_is_tanim : String) : Serializable {
}