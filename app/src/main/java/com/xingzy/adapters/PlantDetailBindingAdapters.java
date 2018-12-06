package com.xingzy.adapters;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xingzy.R;
import com.xingzy.utilities.GlideApp;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

/**
 * @author roy.xing
 * @date 2018/12/6
 */
public class PlantDetailBindingAdapters {

    @BindingAdapter("imageFromUrl")
    public static void bindImageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl != null) {
            GlideApp.with(view.getContext()).load(imageUrl).into(view);
        }
    }

    @BindingAdapter("isGone")
    public static void bindIsGone(FloatingActionButton floatingActionButton, boolean isGone) {
        if (isGone) {
            floatingActionButton.hide();
        } else {
            floatingActionButton.show();
        }
    }

    @BindingAdapter("wateringText")
    public static void bindWateringText(TextView textView, int wateringInterval) {
        Resources resources = textView.getResources();
        String quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix,
                wateringInterval, wateringInterval);
        String string = resources.getString(R.string.watering_needs_prefix);
        SpannableStringBuilder builder = new SpannableStringBuilder();
//        builder.setSpan(new StyleSpan(Typeface.BOLD), 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(string);
        builder.append(" ");
        builder.append(quantityString);
//        builder.setSpan(new StyleSpan(Typeface.ITALIC), string.length() + 1, (string + " " + quantityString).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }
}
