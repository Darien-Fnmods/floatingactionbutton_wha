package com.darien.fnmods.whatsapp.fab;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.darien.fnmods.whatsapp.tools.Tool;
import com.darien.fnmods.whatsapp.utils.FnmodsUtils;



public class FloatingImageView extends LinearLayout {
    ImageView mIcon;

    public FloatingImageView(Context context) {
        super(context);
        init(context);
    }

    public FloatingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FloatingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mIcon = (ImageView) LayoutInflater.from(context).inflate(Tool.intLayout("delta_image_icon"), this).findViewById(Tool.intId("mImageIcon"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layoutParams.height = Tool.dpToPx(context, 22.0f);
        layoutParams.width = Tool.dpToPx(context, 22.0f);
        int dpToPx = Tool.dpToPx(context, 10.0f);
        layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
        layoutParams.gravity = Gravity.CENTER;
        this.mIcon.setLayoutParams(layoutParams);
    }

    public void setIcon(String str) {
        if (this.mIcon != null) {
            this.mIcon.setImageResource(FnmodsUtils.intDrawable(str));

        }
        invalidate();
    }

    public void setIconResource(int i) {
        ImageView imageView = this.mIcon;
        if (imageView != null) {
            imageView.setImageResource(i);
            invalidate();
        }
    }

    public void setIconRotation(float f) {
        this.mIcon.animate().rotation(f);
        invalidate();
    }
}