package com.example.myapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.entity.Yapilacaklar
import com.example.myapplication.databinding.CardTasarimBinding
import com.example.myapplication.databinding.FragmentAnasayfaBinding
import com.example.myapplication.ui.fragment.AnasayfaFragmentDirections
import com.example.myapplication.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.myapplication.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

//1.Parametre tanımladık
class YapilacaklarAdapter(var mContext : Context,
                          var yapilacaklarListesi : List<Yapilacaklar>,
                          var viewModel:AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>()  {//3. inner classı adapter a bağladık.
    //2.Card tasarımı sınıfı oluşturduk
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim //Shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim : CardTasarimBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)//5.Card tasarım için viewbinding kurulumu
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacakIsNesnesi = yapilacakIs

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacakIs =yapilacakIs)
            Navigation.gecisYap(it,gecis)

        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacakIs.yapilacak_is_tanim} silinsin mi",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacakIs.yapilacak_is_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size //4.Satır sayısını belirledik.
    }

}