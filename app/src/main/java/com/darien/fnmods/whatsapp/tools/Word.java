package com.darien.fnmods.whatsapp.tools;


import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;




public final class Word {
    private static Application act;
    private static Context sContext;

    Word() {
    }

    public static Handler getBackgroundHandler() {
        return Word.BackgroundHandlerHolder.INSTANCE;
    }

    public static Context getContext() {
        if (sContext == null) {
            sContext = Word.CurrentApplicationHolder.INSTANCE;
        }

        return (Context) ObjectUtils.notNull(sContext);
    }

    public static Resources getResources() {
        return (Resources)ObjectUtils.notNull(getContext().getResources());
    }

    public static Handler getUiHandler() {
        return Word.UiHandlerHolder.INSTANCE;
    }

    public static void setContext(Context var0) {
        sContext = var0;
    }

    static class BackgroundHandlerHolder {
        static final Handler INSTANCE;

        static {
            Class var0;
            try {
                var0 = Class.forName("com.mod.bomfab.application.Global");
            } catch (ClassNotFoundException var1) {
                throw new NoClassDefFoundError(var1.getMessage());
            }

            INSTANCE = ThreadUtils.newThread(var0.getSimpleName(), (Handler.Callback)null);
        }

        public BackgroundHandlerHolder() {
        }
    }

    static class CurrentApplicationHolder {
        static final Application INSTANCE;

        static {
            try {
                INSTANCE = (Application)ObjectUtils.cast(ReflectUtils.invokeStaticMethod(ReflectUtils.getMethod(Class.forName("android.app.ActivityThread"), "currentApplication", new Class[0]), new Object[0]));
            } catch (Throwable var1) {
                throw new AssertionError(var1);
            }
        }

        public CurrentApplicationHolder() {
        }
    }

    static class UiHandlerHolder {
        static final Handler INSTANCE = new Handler(Looper.getMainLooper());

        public UiHandlerHolder() {
        }
    }
}
