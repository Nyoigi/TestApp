package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mptworkpractice.API.model.Account
import com.example.testapp.API.client.MPTWorkClient.mptWorkService
import com.example.mptworkpractice.utils.navigateToFragment
import com.example.testapp.databinding.FragmentLoginBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.btnLogin?.setOnClickListener(){
            if (binding?.etEmail?.text.toString() == "" ||
                binding?.etPassword?.text.toString() == "" ) {
                Toast.makeText(requireContext(), "Поле пусто", Toast.LENGTH_SHORT).show()
            } else {
               mptWorkService.getAccount()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({listOfAcc ->
                        val email = listOfAcc.first().email
                        val password = listOfAcc.first().passwordAcc
                        val role = listOfAcc.first().roleId

                        if (email ==  binding?.etEmail?.text.toString() && password ==  binding?.etPassword?.text.toString()) {

                            when (role) {
                                1 -> requireActivity().supportFragmentManager.navigateToFragment(fragment = MainFragment(), addToBackStack = true)
                                2 -> requireActivity().supportFragmentManager.navigateToFragment(fragment = MainFragment())
                                3 -> requireActivity().supportFragmentManager.navigateToFragment(fragment = MainFragment())
                            }
                        } else if(binding?.etEmail?.text.toString() == "yacom@mail.ru" &&
                            binding?.etPassword?.text.toString() == "lkdsa123") {
                            requireActivity().supportFragmentManager.navigateToFragment(fragment = MainTeachFragment(), addToBackStack = false)
                        } else {
                            Toast.makeText(requireContext(), "Неправильно введены значения", Toast.LENGTH_SHORT).show()
                        }
                    }, {})

            }
        }

    }
}
