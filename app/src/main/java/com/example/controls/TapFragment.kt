package com.example.controls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.controls.databinding.FragmentTabBinding


class TapFragment : Fragment() {
    private lateinit var binding: FragmentTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        initializeView()
        setListener()
        return binding.root
    }


    fun initializeView() {
        binding.tvTapTitle.text =
            "${getString(R.string.tab)} ${arguments?.getString("position", "")}"

    }


    fun setListener() {


    }


}