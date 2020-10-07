package com.mybclym.notes.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mybclym.notes.R
import com.mybclym.notes.databinding.FragmentMainBinding
import com.mybclym.notes.databinding.FragmentStartBinding
import com.mybclym.notes.screens.start.StartFragmentViewModel
import com.mybclym.notes.utilits.APP_ACTIVITY
import com.mybclym.notes.utilits.TYPE_ROOM
import kotlinx.android.synthetic.main.fragment_start.*


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mbinding
        get() = _binding!!
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initialization()
        Log.d("TEST","MainFragment start")
    }

    private fun initialization() {
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mbinding.addNoteFloatbtn.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_newNoteFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mbinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}