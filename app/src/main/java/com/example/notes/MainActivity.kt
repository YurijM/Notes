package com.example.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {
    lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this

        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.note)

        navController = Navigation.findNavController(this, R.id.fragmentNavHost)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}