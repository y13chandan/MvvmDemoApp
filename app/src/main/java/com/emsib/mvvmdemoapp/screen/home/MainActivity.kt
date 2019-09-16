package com.emsib.mvvmdemoapp.screen.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.emsib.mvvmdemoapp.R
import com.emsib.mvvmdemoapp.databinding.ActivityMainBinding
import com.emsib.mvvmdemoapp.models.DataWrapper
import com.emsib.mvvmdemoapp.models.Post
import com.emsib.mvvmdemoapp.util.checkItemsAre
import com.emsib.mvvmdemoapp.util.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: HomeViewModelFactory by instance()
    private lateinit var mViewModel: HomeViewModel
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        binding?.mViewModel = mViewModel
        mViewModel.getPosts()
        setObservers()
    }

    private fun setObservers() {
        mViewModel.posts.observe(this, Observer<DataWrapper> {t ->
            when(t?.error) {
                null ->  { t?.data?.checkItemsAre<Post>()?.let { rv_main.adapter = HomeAdapter(it) } }
                else -> toast(t.error)
            }
        })
    }

}
