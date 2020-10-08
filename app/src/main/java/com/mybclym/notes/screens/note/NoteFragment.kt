package com.mybclym.notes.screens.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mybclym.notes.R
import com.mybclym.notes.databinding.FragmentMainBinding
import com.mybclym.notes.databinding.FragmentNoteBinding
import com.mybclym.notes.models.AppNote
import com.mybclym.notes.screens.main.MainAdapter
import com.mybclym.notes.screens.main.MainFragmentViewModel
import com.mybclym.notes.utilits.APP_ACTIVITY

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val mbinding
        get() = _binding!!
    private lateinit var viewmodel: NoteFragmentViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mbinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mbinding.noteTitle.text = mCurrentNote.title
        mbinding.noteText.text = mCurrentNote.text
        viewmodel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_note_btn ->
                viewmodel.delete(mCurrentNote) {
                    APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}