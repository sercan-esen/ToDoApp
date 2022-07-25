package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.entity.Yapilacaklar
import com.example.myapplication.databinding.FragmentAnasayfaBinding
import com.example.myapplication.ui.adapter.YapilacaklarAdapter
import com.example.myapplication.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.myapplication.utils.gecisYap
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa) //elimizdeki toolbarın Action bar desteklemesi için

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

       viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
           val adapter = YapilacaklarAdapter(requireContext(),it,viewModel)
           tasarim.yapilacaklarAdapter = adapter
       }





        return tasarim.root
    }

    fun fabTikla(view : View){
        Navigation.gecisYap(view,R.id.kayitGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)//Activity de gereksiz fakat fragmentlerde gereklidir
        val tempViewModel:AnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }



    override fun onQueryTextSubmit(query: String): Boolean {// Arama iconu seçilirse çalışacak.
        viewModel.ara(query)
        return true

    }

    override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }


}