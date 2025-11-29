package com.example.kick_up.ui.fragments.login

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.kick_up.R
import com.example.kick_up.databinding.FragmentLoginBinding
import com.example.kick_up.ui.fragments.HomeFragment
import com.example.kick_up.utils.AuthState
import com.example.kick_up.utils.BaseFragment
import com.example.kick_up.utils.Prefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private lateinit var viewModel: LoginViewModel
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.btnLog.setOnClickListener {
            val email = binding.edtLogEmail.text
            val password = binding.edtLogPassword.text
            viewModel.login(email = email.toString(), password = password.toString())
        }

    }

    override fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.authState.collect { state ->
                    when (state) {
                        is AuthState.Idle -> {
                        }

                        is AuthState.Loading -> Toast.makeText(
                            context,
                            "Loading",
                            Toast.LENGTH_SHORT
                        ).show()


                        is AuthState.Success -> {
                            openMainScreen()
                            Toast.makeText(context, "Успешный вход", Toast.LENGTH_SHORT).show()
                            context?.let { Prefs.setLoggedIn(it, true) }
                        }

                        is AuthState.Error -> {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                            Log.e("ololoLogin", state.message)
                        }
                    }
                }
            }
        }
    }
    private fun openMainScreen(){
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
    }
}