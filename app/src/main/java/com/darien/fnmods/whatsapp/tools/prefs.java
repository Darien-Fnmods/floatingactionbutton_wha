package com.darien.fnmods.whatsapp.tools;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class prefs {
    public prefs() {
    }

    public static void clear() {
        getEditor().clear().commit();
    }

    public static boolean getBoolean(String var0, boolean var1) {
        return getPreferences().getBoolean(var0, var1);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    public static float getFloat(String var0, float var1) {
        return getPreferences().getFloat(var0, var1);
    }

    public static int getInt(String var0, int var1) {
        return getPreferences().getInt(var0, var1);
    }

    public static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(Word.getContext());
    }

    public static String getString(String var0, String var1) {
        return getPreferences().getString(var0, var1);
    }

    public static void putBoolean(String var0, boolean var1) {
        getEditor().putBoolean(var0, var1).apply();
    }

    public static void putInt(String var0, int var1) {
        getEditor().putInt(var0, var1).apply();
    }

    public static void putString(String var0, String var1) {
        getEditor().putString(var0, var1).apply();
    }

    public static void remove(String var0) {
        getEditor().remove(var0).apply();
    }
}
