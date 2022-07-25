package com.example.myapplication.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entity.Yapilacaklar
import com.example.myapplication.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var ydao : YapilacaklarDao) {
    var yapilacaklarListesi : MutableLiveData<List<Yapilacaklar>>

    init {
        yapilacaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>> {
        return yapilacaklarListesi
    }

    fun yapilacakIsKayit(yapilacak_is_tanim:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniYapilacakIs = Yapilacaklar(0,yapilacak_is_tanim)
            ydao.yapilacakIsEkle(yeniYapilacakIs)
        }
    }

    fun yapilacakIsGuncelle(yapilacak_is_id:Int,yapilacak_is_tanim:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenYapilacakIs = Yapilacaklar(yapilacak_is_id,yapilacak_is_tanim)
            ydao.yapilacakIsGuncelle(guncellenenYapilacakIs)
        }
    }

    fun yapilacakIsAra(aramaKelimesi : String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = ydao.yapilacakAra(aramaKelimesi)
        }
    }

    fun yapilacakIsSil(yapilacak_is_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenYapilacakIs = Yapilacaklar(yapilacak_is_id,"")
            ydao.yapilacakIsSil(silinenYapilacakIs)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = ydao.tumYapilacaklar()
        }
    }
}