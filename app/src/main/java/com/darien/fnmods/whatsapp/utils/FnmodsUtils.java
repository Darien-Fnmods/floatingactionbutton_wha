package com.darien.fnmods.whatsapp.utils;


import android.view.View;
import android.graphics.Color;

import com.darien.fnmods.whatsapp.tools.Tool;
import com.darien.fnmods.whatsapp.tools.Word;


public class FnmodsUtils {

    public static int intDrawable(String str) {
        return Tool.intDrawable(str);
    }

    public static int intId(String p0) {
        return Tool.intId(p0);
    }

    public static int intLayout(String p0) {
        return intLayout(p0);
    }


    public static int dpToPx(float p0) {
        return Tool.dpToPx(Word.getContext(), p0);
    }

    public static void rippleRoundStroke(final View _view) {
        android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
        GG.setColor(Color.parseColor("#FFFFFF"));
        GG.setCornerRadius((float) 100);

        android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#EFEFEF")}), GG, null);
        _view.setBackground(RE);
        _view.setElevation(4);
    }


}