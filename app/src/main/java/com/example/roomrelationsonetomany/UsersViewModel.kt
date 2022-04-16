package com.example.roomrelationsonetomany

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(var context : Context) : ViewModel() {

    private val usersRepository : UsersRepository
    val users : LiveData<List<UserWithAccounts>>

    init {
        usersRepository = Database
            .getDatabase(context, viewModelScope)
            .let { db ->
                UsersRepository.getInstance(db)
            }
        viewModelScope.launch(Dispatchers.IO){
            usersRepository.insertUserAndAccounts()
        }
        users = usersRepository.getUserAndAccounts()
    }
}