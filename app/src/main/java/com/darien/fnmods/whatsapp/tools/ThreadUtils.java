package com.darien.fnmods.whatsapp.tools;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadUtils implements Runnable {
    private static AtomicInteger sCounter;
    private static Runnable sStopper;

    ThreadUtils() {
    }

    public static Handler newHandler(Handler var0, Handler.Callback var1) {
        return new Handler(var0.getLooper(), var1);
    }

    private static String newName() {
        AtomicInteger var0 = sCounter;
        AtomicInteger var1 = var0;
        if (var0 == null) {
            var1 = new AtomicInteger();
            sCounter = var1;
        }

        StringBuffer var5 = new StringBuffer();
        StringBuffer var2 = new StringBuffer();

        Class var3;
        try {
            var3 = Class.forName("com.mod.bomfab.application.ThreadUtils");
        } catch (ClassNotFoundException var4) {
            throw new NoClassDefFoundError(var4.getMessage());
        }

        return var5.append(var2.append(var3.getSimpleName()).append('-').toString()).append(var1.incrementAndGet()).toString();
    }

    public static Handler newThread(Handler.Callback var0) {
        return newThread((String)null, 19, var0);
    }

    public static Handler newThread(String var0, int var1, Handler.Callback var2) {
        if (var0 == null) {
            var0 = newName();
        }

        HandlerThread var3 = new HandlerThread(var0, var1);
        var3.start();
        return new Handler(var3.getLooper(), var2);
    }

    public static Handler newThread(String var0, Handler.Callback var1) {
        return newThread(var0, 19, var1);
    }

    public static void stopThread(Handler var0) {
        stopThread(var0, true);
    }

    public static void stopThread(Handler var0, boolean var1) {
        Runnable var2 = sStopper;
        Object var3 = var2;
        if (var2 == null) {
            var3 = new   com.darien.fnmods.whatsapp.tools.ThreadUtils();
            sStopper = (Runnable)var3;
        }

        if (var1) {
            var0.postAtFrontOfQueue((Runnable)var3);
        } else {
            var0.post((Runnable)var3);
        }

    }

    @Override
    public void run() {
        Looper var1 = Looper.myLooper();
        if (var1 != null) {
            var1.quit();
        }

    }

    public static class ObjAsRunnableCallback implements Handler.Callback {
        public static final   com.darien.fnmods.whatsapp.tools.ThreadUtils.ObjAsRunnableCallback INSTANCE = new   com.darien.fnmods.whatsapp.tools.ThreadUtils.ObjAsRunnableCallback();

        ObjAsRunnableCallback() {
        }

        @Override
        public boolean handleMessage(Message var1) {
            boolean var2;
            if (var1.obj instanceof Runnable) {
                ((Runnable)var1.obj).run();
                var2 = true;
            } else {
                var2 = false;
            }

            return var2;
        }
    }
}
