package com.example.roomrelationsonetomany

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserModel(
    @ColumnInfo("uId")
    @PrimaryKey(autoGenerate = true)
    val uid: Long = 0,
    var name : String,
    var lastName : String,
)