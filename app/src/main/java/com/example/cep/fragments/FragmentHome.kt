package com.example.cep.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.cep.MainActivity
import com.example.cep.R
import com.example.cep.databinding.FragmentHomeBinding
import com.example.cep.mask.Mask

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        setUp()
        return binding.root
    }

    private fun setUp(){
        setUpClicks()
        mask()
    }

    private fun setUpClicks(){
        binding.btSearch.setOnClickListener{
            val result = binding.etEditCep.text.toString()
            val bundle = Bundle()
            bundle.putString("KeyCep", result)

            val fragment = FragmentInformationCep()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.nav_container, fragment)?.commit()
        }
    }
    private fun mask(){
        binding.etEditCep.addTextChangedListener(Mask.mask("**.***-***", binding.etEditCep))
    }

}