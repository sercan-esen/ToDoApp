package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetayBinding
import com.example.myapplication.databinding.FragmentKayitBinding
import com.example.myapplication.ui.viewmodel.KayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var tasarim:FragmentKayitBinding
    private lateinit var viewModel: KayitFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit,container,false)
        tasarim.kayitFragment = this

        tasarim.kayitToolbarBaslik = "Yapılacak İş Kayıt"




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonKaydet(yapilacak_is_tanim:String){
        viewModel.kayit(yapilacak_is_tanim)
    }
}