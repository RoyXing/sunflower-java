package com.xingzy.adapters;

import android.view.View;

import androidx.databinding.BindingAdapter;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class BindingAdapters {

    @BindingAdapter("isGone")
    public static void bindIsGone(View view, boolean isGone) {
        if (isGone){
            view.setVisibility(View.GONE);
        }else {
            view.setVisibility(View.VISIBLE);
        }
    }
}
