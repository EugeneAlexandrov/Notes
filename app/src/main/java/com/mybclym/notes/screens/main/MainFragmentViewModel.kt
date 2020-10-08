package com.mybclym.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mybclym.notes.utilits.REPOSITORY

class MainFragmentViewModel(app:Application):AndroidViewModel(app) {

val allNotes= REPOSITORY.allNotes

}