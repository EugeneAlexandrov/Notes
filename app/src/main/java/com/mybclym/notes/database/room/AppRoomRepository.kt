package com.mybclym.notes.database.room

import androidx.lifecycle.LiveData
import com.mybclym.notes.database.DataBaseRepository
import com.mybclym.notes.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DataBaseRepository {
    //реализация репозитория для ROOM
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }
}