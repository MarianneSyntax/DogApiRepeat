package com.example.dogapirepeat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogapirepeat.databinding.FragmentBreedBinding
import com.example.dogapirepeat.ui.main.MainViewModel
import com.example.dogapirepeat.adapter.DogAdapter


class BreedFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentBreedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dogAdapter = DogAdapter()
        binding.dogRecycler.adapter = dogAdapter
        binding.dogRecycler.layoutManager = GridLayoutManager(context,2)

        // rausfinden, auf welche Rasse geklickt wurde:
        val breedImages = requireArguments().getString("breedKey")
        viewModel.getDogImages(breedImages!!)

        viewModel.dogs.observe(viewLifecycleOwner){
            dogAdapter.submitList(it)
        }


        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}