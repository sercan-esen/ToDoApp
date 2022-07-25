package com.example.myapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var krepo:YapilacaklarDaoRepository) : ViewModel() {
    fun kayit(yapilacak_is_tanim:String){
        krepo.yapilacakIsKayit(yapilacak_is_tanim)

    }
}