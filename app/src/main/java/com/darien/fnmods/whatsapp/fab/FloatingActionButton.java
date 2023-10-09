package com.darien.fnmods.whatsapp.fab;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;

import com.darien.fnmods.whatsapp.Views.InsLoadingView;
import com.darien.fnmods.whatsapp.tools.Tool;
import com.darien.fnmods.whatsapp.tools.Word;
import com.darien.fnmods.whatsapp.utils.FnmodsUtils;


public class FloatingActionButton extends FrameLayout implements OnClickListener, OnLongClickListener {
    Context fnmods;
    public boolean isFABOpen = false;
    InsLoadingView mFabAdd;
    View mFabChat;
    View mFabSettings;
    View mFabTop;

    public FloatingActionButton(Context context) {
        super(context);
        init();
        this.fnmods = context;
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        this.fnmods = context;
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        this.fnmods = context;
    }

    private void init() {

        View inflate = LayoutInflater.from(getContext()).inflate(Tool.intLayout("delta_home_fab"), this);
        this.mFabChat = inflate.findViewById(Tool.intId("mFloatingChat"));
        this.mFabAdd = inflate.findViewById(Tool.intId("mFloatingAdd"));
        this.mFabSettings = inflate.findViewById(Tool.intId("mFloatingSettings"));
        this.mFabTop = inflate.findViewById(Tool.intId("mFloatingTop"));
        setChatIcon("delta_fab_chat");
        setSettingsIcon("delta_fab_settings");
        setTopIcon("delta_fab_emoji");
        setMenuIcon("fnmods");

        this.mFabChat.setOnClickListener(this);
        this.mFabAdd.setOnClickListener(this);
        this.mFabSettings.setOnClickListener(this);
        this.mFabTop.setOnClickListener(this);
        this.mFabAdd.setOnLongClickListener(this);
        this.mFabChat.setOnLongClickListener(this);


    }

    public void closeFABMenu() {
        this.isFABOpen = false;
        View view = this.mFabAdd;
        view = this.mFabAdd;
        if (view instanceof FloatingImageView) {
            ((FloatingImageView) view).setIconRotation(0.0f);
        }
        this.mFabSettings.animate().translationY(0.0f);
        this.mFabChat.animate().translationY(0.0f);
        this.mFabTop.animate().translationY(0.0f);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                FloatingActionButton.this.mFabChat.setVisibility(View.GONE);
                FloatingActionButton.this.mFabSettings.setVisibility(View.GONE);
                FloatingActionButton.this.mFabTop.setVisibility(View.GONE);
            }
        }, 200);
    }

    public void getIconResource(String str, View view) {
        FnmodsUtils.rippleRoundStroke(view);
        if (view instanceof FloatingImageView) {
            ((FloatingImageView) view).setIcon(str);
            if (view == this.mFabAdd) {

            }
        }
    }

    public void onClick(View view) {
        try {
            if (view.getId() == Tool.intId("mFloatingAdd")) {
                if (this.isFABOpen) {
                    closeFABMenu();
                } else {
                    showFABMenu();
                }
            }
            if (view.getId() == Tool.intId("mFloatingChat")) {
                getContext().startActivity(new Intent(getContext(), Class.forName("com.njlabs.showjava.activities.apps.AppsActivity")));
                if (this.isFABOpen) {
                    closeFABMenu();
                }
            }
            if (view.getId() == Tool.intId("mFloatingSettings") ){//&& (getContext() instanceof LandingActivity)) {
                // ((LandingActivity) getContext()).fn_show();
                if (this.isFABOpen) {
                    closeFABMenu();
                }
            }
            if (view.getId() == Tool.intId("mFloatingTop")) {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/FNMODSOFICIAL")));
                Tool.showToast("PayPal");
                if (this.isFABOpen) {
                    closeFABMenu();
                }
            }
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public boolean onLongClick(View view) {
      /*  if ((getContext() instanceof LandingActivity) && view.getId() == tool.intId("mFloatingAdd")) {
            try {
                getContext().startActivity(new Intent(getContext(), Class.forName("com.njlabs.showjava.activities.settings.SettingsActivity")));
                if (this.isFABOpen) {
                    closeFABMenu();
                }
            } catch (Throwable e) {
                throw new NoClassDefFoundError(e.getMessage());
            }
        }
        if (view.getId() == tool.intId("mFloatingChat") && (getContext() instanceof LandingActivity)) {
            ((LandingActivity) getContext()).fn_drawer();
            if (this.isFABOpen) {
                closeFABMenu();
            }
        }*/
        return false;
    }

    public void setChatIcon(String str) {
        getIconResource(str, this.mFabChat);
    }

    public void setMenuIcon(String str) {
       mFabAdd.setImageResource(Tool.intDrawable(str));
       FnmodsUtils.rippleRoundStroke(mFabAdd);

    }

    public void setSettingsIcon(String str) {
        getIconResource(str, this.mFabSettings);
    }

    public void setTopIcon(String str) {
        getIconResource(str, this.mFabTop);
    }

    public void showFABMenu() {
        this.isFABOpen = true;
        Context context = Word.getContext();
        this.mFabTop.setVisibility(View.VISIBLE);
        this.mFabChat.setVisibility(View.VISIBLE);
        this.mFabSettings.setVisibility(View.VISIBLE);
        View view = this.mFabAdd;
        view = this.mFabAdd;
        if (view instanceof FloatingImageView) {
            ((FloatingImageView) view).setIconRotation(180.0f);
        }
        this.mFabTop.animate().translationY((float) (-Tool.dpToPx(context, 196.0f))).setDuration((long) 200);
        this.mFabChat.animate().translationY((float) (-Tool.dpToPx(context, 72.0f))).setDuration((long) 200);
        this.mFabSettings.animate().translationY((float) (-Tool.dpToPx(context, 134.0f))).setDuration((long) 200);
    }
}

