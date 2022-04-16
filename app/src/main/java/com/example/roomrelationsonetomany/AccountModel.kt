package com.example.roomrelationsonetomany

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "accounts", foreignKeys =
[ForeignKey(entity = UserModel::class,
    parentColumns = ["uId"],
    childColumns = ["aId"])]

)
data class AccountModel (

    @ColumnInfo("aId")
    @PrimaryKey(autoGenerate = true)
    val aid: Long = 0,
    var number : String,
    var type : String,
    var userfkId : Long = 0
)