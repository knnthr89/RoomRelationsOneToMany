package com.example.roomrelationsonetomany

import androidx.room.Embedded
import androidx.room.Relation


data class UserWithAccounts(
    @Embedded var user : UserModel,
    @Relation(
        parentColumn = "uId",
        entityColumn = "aId",
        entity = AccountModel::class
    )
    var accounts : List<AccountModel>
)
