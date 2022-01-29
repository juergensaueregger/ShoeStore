package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import timber.log.Timber
import com.udacity.shoestore.ActivityViewModel as ActivityViewModel

class ShoeDetailFragment  : Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<ShoeDetailFragmentBinding>(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        binding.activityViewModel = viewModel
        binding.detailSaveBt.setOnClickListener {
            viewModel.addShoe()
            findNavController().navigateUp()
        }

        return binding.root
    }
}