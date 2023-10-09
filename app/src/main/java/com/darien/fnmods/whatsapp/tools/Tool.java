package com.darien.fnmods.whatsapp.tools;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.io.File;

public class Tool {
    private static boolean internet;
    private static DisplayMetrics mDisplayMetrics = null;
    static Context vv;

    Tool(Context var1) {
        vv = var1;
    }

    public static void SetBoldToolBarText(Context var0, TextView var1) {
        if (!getBooleanFromkey("back_normal", var0)) {
            var1.setTypeface(var1.getTypeface(), Typeface.NORMAL);
        } else {
            var1.setTypeface(var1.getTypeface(), Typeface.BOLD);
        }

    }

    public static void SetToolBarText(Context var0, TextView var1) {
        var1.setTextSize((float)setToolBarTextSize(var0));
    }

    public static void checkInternet() {
        NetworkInfo var0 = ((ConnectivityManager) Word.getContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        boolean var1;
        if (var0 != null && var0.isConnected()) {
            var1 = true;
        } else {
            var1 = false;
        }

        internet = var1;
    }

    public static boolean checkInternetNow() {
        checkInternet();
        return isInternetActive();
    }

    public static Drawable colorDrawable(int var0, int var1, PorterDuff.Mode var2) {
        Drawable var3 = Word.getContext().getResources().getDrawable(var0);
        var3.setColorFilter(var1, var2);
        return var3;
    }

    public static Drawable colorDrawable(String var0, int var1, PorterDuff.Mode var2) {
        Drawable var3 = getDrawable(var0);
        var3.setColorFilter(var1, var2);
        return var3;
    }

    public static int dpToPx(Context var0, float var1) {
        return Math.round(var1 * var0.getResources().getDisplayMetrics().density);
    }

    public static Bitmap drawableToBitmap(Drawable var0) {
        if (var0 instanceof BitmapDrawable) {
            BitmapDrawable var1 = (BitmapDrawable)var0;
            if (var1.getBitmap() != null) {
                return var1.getBitmap();
            }
        }

        Bitmap var3;
        if (var0.getIntrinsicWidth() > 0 && var0.getIntrinsicHeight() > 0) {
            var3 = Bitmap.createBitmap(var0.getIntrinsicWidth(), var0.getIntrinsicHeight(), Config.ARGB_8888);
        } else {
            var3 = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        }

        Canvas var2 = new Canvas(var3);
        var0.setBounds(0, 0, var2.getWidth(), var2.getHeight());
        var0.draw(var2);
        return var3;
    }

    public static boolean getBooleanFromkey(String var0, Context var1) {
        return PreferenceManager.getDefaultSharedPreferences(var1).getBoolean(var0, true);
    }

    public static boolean getBooleanFromkeyy(String var0) {
        return PreferenceManager.getDefaultSharedPreferences(vv).getBoolean(var0, true);
    }

    public static Bitmap getCircleBitmap(Bitmap var0) {
        Bitmap var1 = Bitmap.createBitmap(var0.getWidth(), var0.getHeight(), Config.ARGB_8888);
        Canvas var2 = new Canvas(var1);
        Paint var3 = new Paint();
        Rect var4 = new Rect(0, 0, var0.getWidth(), var0.getHeight());
        RectF var5 = new RectF(var4);
        var3.setAntiAlias(true);
        var2.drawARGB(0, 0, 0, 0);
        var3.setColor(-65536);
        var2.drawOval(var5, var3);
        var3.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        var2.drawBitmap(var0, var4, var4, var3);
        var0.recycle();
        return var1;
    }

    public static int getColor(String var0) {
        return Word.getContext().getResources().getColor(intColor(var0));
    }

    private static DisplayMetrics getDisplayMetrics(Context var0) {
        if (mDisplayMetrics == null) {
            mDisplayMetrics = var0.getResources().getDisplayMetrics();
        }

        return mDisplayMetrics;
    }

    public static Drawable getDrawable(String var0) {
        return Word.getResources().getDrawable(intDrawable(var0));
    }

    public static int getID(Context var0, String var1, String var2) {
        return var0.getResources().getIdentifier(var1, var2, var0.getPackageName());
    }

    public static int getID(String var0, String var1) {
        return Word.getContext().getResources().getIdentifier(var0, var1, Word.getContext().getPackageName());
    }

    public static int getIntFromkey(Context var0, String var1) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt(var1, 0);
    }

    public static Point getScreenSize(Context var0) {
        Point var1 = new Point();
        ((WindowManager)var0.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(var1);
        return var1;
    }

    public static Drawable getSelectableItemBackground(Context var0) {
        TypedArray var1 = var0.obtainStyledAttributes(new int[]{16843534});
        Drawable var2 = var1.getDrawable(0);
        var1.recycle();
        return var2;
    }

    public static Drawable getSelectableItemBackgroundBorderless(Context var0) {
        TypedArray var1 = var0.obtainStyledAttributes(new int[]{16843868});
        Drawable var2 = var1.getDrawable(0);
        var1.recycle();
        return var2;
    }

    public static String getString(String var0) {
        return Word.getContext().getString(Word.getResources().getIdentifier(var0, "string", Word.getContext().getPackageName()));
    }

    public static boolean hasJellyBean() {
        boolean var0;
        if (VERSION.SDK_INT >= 16) {
            var0 = true;
        } else {
            var0 = false;
        }

        return var0;
    }

    public static boolean hasLollipop() {
        boolean var0;
        if (VERSION.SDK_INT >= 21) {
            var0 = true;
        } else {
            var0 = false;
        }

        return var0;
    }

    public static int intAnim(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "anim", Word.getContext().getPackageName());
    }

    public static int intArrays(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "array", Word.getContext().getPackageName());
    }

    public static int intAttr(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "attr", Word.getContext().getPackageName());
    }

    public static int intColor(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "color", Word.getContext().getPackageName());
    }

    public static int intDimen(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "dimen", Word.getContext().getPackageName());
    }

    public static int intDrawable(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "drawable", Word.getContext().getPackageName());
    }

    public static int intId(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "id", Word.getContext().getPackageName());
    }

    public static int intLayout(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "layout", Word.getContext().getPackageName());
    }

    public static int intString(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "string", Word.getContext().getPackageName());
    }

    public static int intStyle(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "style", Word.getContext().getPackageName());
    }

    public static int intStyleable(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "styleable", Word.getContext().getPackageName());
    }

    public static int intXml(String var0) {
        return Word.getContext().getResources().getIdentifier(var0, "xml", Word.getContext().getPackageName());
    }

    public static boolean isInternetActive() {
        return internet;
    }

    public static int px2dp(Context var0, float var1) {
        return (int)(var1 / var0.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static Bitmap resizeBitmap(Bitmap var0, int var1, int var2) {
        Bitmap var3 = Bitmap.createBitmap(var1, var2, Config.ARGB_8888);
        float var4 = (float)var1 / (float)var0.getWidth();
        float var5 = (float)var2 / (float)var0.getHeight();
        float var6 = (float)var1 / 2.0F;
        float var7 = (float)var2 / 2.0F;
        Matrix var8 = new Matrix();
        var8.setScale(var4, var5, var6, var7);
        Canvas var9 = new Canvas(var3);
        var9.setMatrix(var8);
        var9.drawBitmap(var0, var6 - (float)(var0.getWidth() / 2), var7 - (float)(var0.getHeight() / 2), new Paint(2));
        return var3;
    }

    public static int setBorderColor(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_border", -1);
    }

    public static int setColorIndicator(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_indikator", -1);
    }

    public static int setColorNormal(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_normal", -9079435);
    }

    public static int setColorSelected(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_ditekan", -65536);
    }

    public static int setColorTab(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_tab", -16359850);
    }

    public static void setProfileImage(Context var0, ImageView var1) {
        try {
            StringBuilder var3 = new StringBuilder();
            var3.append(var0.getFilesDir().getAbsolutePath());
            var3.append("/Avatars");
            File var2 = new File(var3.toString(), "me.j");
            if (var2.exists()) {
                var1.setImageBitmap(getCircleBitmap(BitmapFactory.decodeFile(var2.getAbsolutePath())));
            } else {
                var1.setImageResource(getID(var0, "avatar_contact", "drawable"));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static int setTabIconColor(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_icon_tab", -16359850);
    }

    public static int setTabSpaceButton(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_button_space", -1);
    }

    public static int setTabSpaceColor(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_tab_space", -16359850);
    }

    public static int setTabSpaceTextColor(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_text_space", -1);
    }

    public static int setTabTextSize(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("tab_text_size", 16);
    }

    public static int setToolBarTextSize(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("toolbar_text_size", 35);
    }

    public static int setWarnaBg(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_bg", -1);
    }

    public static int setWarnaHeader(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("warna_header", -16359850);
    }

    public static void showToast(String var0) {
        Toast.makeText(Word.getContext(), var0, Toast.LENGTH_SHORT).show();
    }

    public static int spToPx(Context var0, float var1) {
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, var1, getDisplayMetrics(var0));
    }

    public static void startActivity(Activity var0, Class var1) {
        var0.startActivity(new Intent(var0, var1));
    }

    public static void startService(Activity var0, Class var1) {
        var0.startService(new Intent(var0, var1));
    }

    public static int tabCorner(Context var0) {
        return PreferenceManager.getDefaultSharedPreferences(var0).getInt("tab_text_size", 16);
    }
}
