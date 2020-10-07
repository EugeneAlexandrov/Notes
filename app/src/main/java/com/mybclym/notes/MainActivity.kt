package com.mybclym.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mybclym.notes.databinding.ActivityMainBinding
import com.mybclym.notes.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        toolbar = mBinding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}