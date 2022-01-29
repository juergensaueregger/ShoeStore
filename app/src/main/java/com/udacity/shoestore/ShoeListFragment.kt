package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ShoeListFragmentBinding>(
            inflater,
            R.layout.shoe_list_fragment,
            container,
            false
        )

        viewModel.shoes.observe(viewLifecycleOwner, Observer {

            it.forEach { shoe ->
                binding.shoesListLayout.addView(createListElement(shoe))
            }

        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }




        return binding.root
    }

    fun createListElement(shoe: Shoe): View {
        val shoeView: ConstraintLayout = View.inflate(context,R.layout.shoe_item,null) as ConstraintLayout
        shoeView.findViewById<TextView>(R.id.shoe_name_tv).text =  shoe.name
        shoeView.findViewById<TextView>(R.id.shoe_description_tv).text =  shoe.description
        shoeView.findViewById<TextView>(R.id.shoe_size_tv).text =  (shoe.size).toString()
        shoeView.findViewById<TextView>(R.id.shoe_company_tv).text =  shoe.company
        return shoeView
    }

}