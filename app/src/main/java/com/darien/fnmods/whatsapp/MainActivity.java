package com.darien.fnmods.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.darien.fnmods.whatsapp.Views.CircleImageView;
import com.darien.fnmods.whatsapp.fab.FloatingActionButton;
import com.darien.fnmods.whatsapp.tools.Word;

public class MainActivity extends Activity {
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout main = new LinearLayout(this);
        main.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        main.setOrientation(LinearLayout.VERTICAL);
            main.setGravity(Gravity.BOTTOM|Gravity.CENTER|Gravity.END);
        setContentView(main);


        LinearLayout.LayoutParams conetct= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        conetct.setMargins(16,16,16,16);


        final FloatingActionButton fab= new FloatingActionButton(this);
        fab.setLayoutParams(conetct);

        main.addView(fab);




    }

}