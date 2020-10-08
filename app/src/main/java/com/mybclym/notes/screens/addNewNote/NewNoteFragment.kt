package com.mybclym.notes.screens.addNewNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mybclym.notes.R
import com.mybclym.notes.databinding.FragmentMainBinding
import com.mybclym.notes.databinding.FragmentNewNoteBinding
import com.mybclym.notes.models.AppNote
import com.mybclym.notes.utilits.APP_ACTIVITY

class NewNoteFragment : Fragment() {

    private var _binding: FragmentNewNoteBinding? = null
    private val mbinding
        get() = _binding!!
    private lateinit var viewmodel: AddNewNoteFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(layoutInflater, container, false)
        return mbinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewmodel = ViewModelProvider(this).get(AddNewNoteFragmentViewModel::class.java)
        mbinding.saveNewNoteBtn.setOnClickListener {
            val title = mbinding.newNoteTitleEdittext.text.toString()
            val text = mbinding.newNoteTextEdittext.text.toString()
            if (title.isEmpty() || text.isEmpty()) {
                Toast.makeText(
                    APP_ACTIVITY,
                    getString(R.string.empty_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewmodel.insert(AppNote(title = title, text = text)) {
                    APP_ACTIVITY.navController.navigate(R.id.action_newNoteFragment_to_mainFragment)
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
