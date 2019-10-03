package com.emsib.mvvmdemoapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomFragmentStateAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: List<Fragment>
): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getFragment(position: Int): Fragment {
        return fragments[position]
    }

}