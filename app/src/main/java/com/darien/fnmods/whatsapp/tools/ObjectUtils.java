package com.darien.fnmods.whatsapp.tools;


import java.util.Arrays;

public final class ObjectUtils {
    ObjectUtils() {
    }

    public static byte[] asArray(byte... var0) {
        return var0;
    }

    public static char[] asArray(char... var0) {
        return var0;
    }

    public static double[] asArray(double... var0) {
        return var0;
    }

    public static float[] asArray(float... var0) {
        return var0;
    }

    public static int[] asArray(int... var0) {
        return var0;
    }

    public static long[] asArray(long... var0) {
        return var0;
    }

    public static short[] asArray(short... var0) {
        return var0;
    }

    public static boolean[] asArray(boolean... var0) {
        return var0;
    }

    @SafeVarargs
    public static <T> T[] asArrayOf(T... var0) {
        return var0;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object var0) {
        return (T) var0;
    }

    public static boolean isEmpty(String var0) {
        boolean var1;
        if (var0 != null && var0.trim().length() != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(byte[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(char[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(double[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(float[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(int[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(long[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static <T> boolean isEmpty(T[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(short[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isEmpty(boolean[] var0) {
        boolean var1;
        if (var0 != null && var0.length != 0) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static boolean isNotEmpty(String var0) {
        boolean var1;
        if (isEmpty(var0)) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }

    public static String notEmpty(String var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException();
        } else {
            return var0.trim();
        }
    }

    public static byte[] notEmpty(byte[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static char[] notEmpty(char[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static double[] notEmpty(double[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static float[] notEmpty(float[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static int[] notEmpty(int[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static long[] notEmpty(long[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static <T> T[] notEmpty(T[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static short[] notEmpty(short[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static boolean[] notEmpty(boolean[] var0) {
        if (isEmpty(var0)) {
            throw new IllegalArgumentException(Arrays.toString(var0));
        } else {
            return var0;
        }
    }

    public static <T> T notNull(T var0) {
        if (var0 == null) {
            throw new NullPointerException();
        } else {
            return var0;
        }
    }
}
