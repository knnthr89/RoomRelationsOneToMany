package com.example.roomrelationsonetomany

import android.util.Log
import androidx.lifecycle.LiveData

class UsersRepository(
    private val database: Database
) {

    val usersDao = database.usersDao()
    fun insertUserAndAccounts(){

        var listAccounts : MutableList<AccountModel> = mutableListOf()

        val userModel = UserModel(
            name = "Kenneth",
            lastName = "Rizo"
        )

        val accountModel = AccountModel(
            number = "123412341234",
            type = "Premium"
        )

        listAccounts.add(accountModel)

        var userId = usersDao.insertUser(userModel)

        for (account in listAccounts){
            account.userfkId = userId
        }

        usersDao.insertAccounts(listAccounts)

    }

    fun getUserAndAccounts() : LiveData<List<UserWithAccounts>> {
        return usersDao.getUsersWithAccounts()
    }

    companion object {

        @Volatile
        private var instance: UsersRepository? = null

        fun getInstance(newsDatabase: Database) =
            this.instance ?: synchronized(this) {
                instance ?: UsersRepository(newsDatabase).also {
                    instance = it
                }
            }
    }
}