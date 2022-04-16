package com.example.roomrelationsonetomany

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class UsersDao {

    @Insert
    abstract fun insertUser(userModel: UserModel) : Long

    @Insert
    abstract fun insertAccounts(accounts : List<AccountModel>)


    @Query("SELECT * FROM user")
    abstract fun getUsersWithAccounts(): LiveData<List<UserWithAccounts>>




}