package com.example.myapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var krepo:YapilacaklarDaoRepository) : ViewModel() {
    fun guncelle(yapilacak_is_id:Int,yapilacak_is_tanim:String){
        krepo.yapilacakIsGuncelle(yapilacak_is_id,yapilacak_is_tanim)
    }
}