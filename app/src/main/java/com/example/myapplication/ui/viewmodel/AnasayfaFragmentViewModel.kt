package com.example.myapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.entity.Yapilacaklar
import com.example.myapplication.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor(var krepo:YapilacaklarDaoRepository) : ViewModel() {

    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklariYukle()
        yapilacaklarListesi = krepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi : String){
        krepo.yapilacakIsAra(aramaKelimesi)
    }

    fun sil(yapilacak_is_id: Int){
        krepo.yapilacakIsSil(yapilacak_is_id)
    }

    fun yapilacaklariYukle(){
        krepo.tumYapilacaklariAl()
    }
}