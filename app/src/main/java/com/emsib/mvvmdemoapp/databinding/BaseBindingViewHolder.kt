package com.emsib.mvvmdemoapp.databinding

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseBindingViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun onBind(item: Any) {
        Log.d("BASEBINDINGVIEWHOLDER", "======*****  we are at abstract classs basebindingviewholder  =====******")
    }
}