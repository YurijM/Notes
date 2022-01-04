package com.example.notes.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notes.R
import com.example.notes.databinding.FragmentStartBinding
import com.example.notes.utilits.*

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)

        mBinding.btnRoom.setOnClickListener {
            mBinding.layoutLogin.visibility = View.INVISIBLE

            mViewModel.initDatabase(TYPE_ROOM) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }

        mBinding.apply {
            btnFirebase.setOnClickListener {
                layoutLogin.visibility = View.VISIBLE

                btnLogin.setOnClickListener {
                    val email = inputEmail.text.toString()
                    val password = inputPassword.text.toString()

                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        EMAIL = email
                        PASSWORD = password

                        mViewModel.initDatabase(TYPE_FIREBASE) {
                            APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                        }
                    } else {
                        showToast(getString(R.string.fields_should_be_filled))
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}