package com.mybclym.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mybclym.notes.database.room.AppRoomDatabase
import com.mybclym.notes.database.room.AppRoomRepository
import com.mybclym.notes.utilits.REPOSITORY
import com.mybclym.notes.utilits.TYPE_ROOM

class StartFragmentViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app

    fun initDataBase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getAppRoomDAO()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}