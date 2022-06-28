package com.example.cep.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cep.R
import com.example.cep.databinding.FragmentInformationCepBinding
import org.json.JSONObject
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

class FragmentInformationCep : Fragment() {

    private lateinit var binding: FragmentInformationCepBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInformationCepBinding.inflate(inflater,container,false)
        setUp()
        return binding.root
    }
    private fun setUp(){
        setUpClicks()
        setUpBundle()
    }

    private fun setUpClicks(){
        binding.btBack.setOnClickListener{
            val fragment = FragmentHome()
            fragmentManager?.beginTransaction()?.replace(R.id.nav_container, fragment)?.commit()
        }
    }

    private fun setUpBundle(){
        val args = this.arguments
        val input = args?.get("KeyCep")
        binding.tvTitle.text = String.format("$input")

        val url = "https://viacep.com.br/ws/$input/json"

//        val url = URL(url)
//        val urlConnection = url.openConnection() as HttpURLConnection
//        urlConnection.connectTimeout = 7000
//        val content = urlConnection.inputStream.bufferedReader().use(BufferedReader::readText)
//        var json = JSONObject(content)
//
    }
}
