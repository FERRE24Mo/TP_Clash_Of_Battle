package com.example.tp_clash_of_battle.listPlayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tp_clash_of_battle.R
import com.example.tp_clash_of_battle.databinding.FragmentListPlayerBinding


class ListPlayerFragment : Fragment() {

    private var _binding: FragmentListPlayerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ListPlayerViewModel

    private val adapter = ListPlayerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListPlayerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        viewModel.listPlayer.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.getPlayers()   //Api used without db

        /*binding.addTripButton.setOnClickListener {
            findNavController().navigate(R.id.action_MyTripFragment_to_addTripFragment)
        }*/


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}