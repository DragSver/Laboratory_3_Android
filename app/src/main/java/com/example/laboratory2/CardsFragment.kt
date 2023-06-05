package com.example.laboratory2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratory2.api.ApiService
import com.example.laboratory2.dagger.DaggerAppComponent
import com.example.laboratory2.dagger.usecase.UseCase
import com.example.laboratory2.databinding.CardsFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class CardsFragment : Fragment() {

    val cardsLiveData = MutableLiveData<List<Card>>()
    var navController: NavController?=null

    lateinit var binding: CardsFragmentBinding
    lateinit var adapter: ListAdapter<Card, RecyclerView.ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = Adapter()
        binding = CardsFragmentBinding.inflate(layoutInflater)
        binding.rcView.layoutManager = LinearLayoutManager(context)
        binding.rcView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        navController = Navigation.findNavController(view)
        cardsLiveData.observe(viewLifecycleOwner, Observer { cards -> adapter.submitList(cards) })
        lifecycleScope.launch(Dispatchers.Main) {
            cardsLiveData.value = viewModel.getData()
        }
    }
}