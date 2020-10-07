package com.mybclym.notes.database

import androidx.lifecycle.LiveData
import com.mybclym.notes.models.AppNote

interface DataBaseRepository {
    // репозиторий должен уметь отдать все Notes, вставить новый Note и удалить
    val allNotes: LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess: () -> Unit)
    suspend fun delete(note: AppNote, onSuccess: () -> Unit)
}