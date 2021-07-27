package com.example.bennybrown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.bennybrown.databinding.ActivityMainBinding
import com.example.bennybrown.ui.ItemAdapter
import com.example.bennybrown.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recyclerviewId.adapter = itemAdapter

        viewModel.getItems()
        viewModel.itemsLiveData.observe(this,{
            items ->
            itemAdapter.items = items
            itemAdapter.notifyDataSetChanged()
        })
    }
}