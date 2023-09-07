package com.example.m3g59l4h2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.m3g59l4h2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var countTen = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        increment()
    }

    private fun editText() {
        val bundle = Bundle()
        bundle.putString("key", binding.etText.text.toString())
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment).commit()
    }

    private fun increment() {
        var count = binding.number.text.toString().toInt().plus(1)
        binding.btn.setOnClickListener {
            when (countTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            binding.number.text = count++.toString()
                        }
                        true -> {
                            countTen = true
                            binding.number.text = count--.toString()
                            binding.btn.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            binding.number.text = count--.toString()
                        true -> editText()
                    }
                }
            }
        }
    }
}