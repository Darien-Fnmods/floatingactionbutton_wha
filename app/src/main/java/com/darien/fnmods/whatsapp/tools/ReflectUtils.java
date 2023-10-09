package com.darien.fnmods.whatsapp.tools;


import android.content.Context;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ReflectUtils {
    private static final Map<String, SoftReference<Class>> sCache;
    private static final Set<Class<?>> sImmutable;
    private static final Set<Class<?>> sWrapper = new HashSet();

    static {
        Set var0 = sWrapper;

        Class var1;
        try {
            var1 = Class.forName("java.lang.Boolean");
        } catch (ClassNotFoundException var13) {
            throw new NoClassDefFoundError(var13.getMessage());
        }

        var0.add(var1);
        Set var15 = sWrapper;

        Class var14;
        try {
            var14 = Class.forName("java.lang.Character");
        } catch (ClassNotFoundException var12) {
            throw new NoClassDefFoundError(var12.getMessage());
        }

        var15.add(var14);
        var0 = sWrapper;

        try {
            var1 = Class.forName("java.lang.Byte");
        } catch (ClassNotFoundException var11) {
            throw new NoClassDefFoundError(var11.getMessage());
        }

        var0.add(var1);
        var0 = sWrapper;

        try {
            var1 = Class.forName("java.lang.Short");
        } catch (ClassNotFoundException var10) {
            throw new NoClassDefFoundError(var10.getMessage());
        }

        var0.add(var1);
        var0 = sWrapper;

        try {
            var1 = Class.forName("java.lang.Integer");
        } catch (ClassNotFoundException var9) {
            throw new NoClassDefFoundError(var9.getMessage());
        }

        var0.add(var1);
        var0 = sWrapper;

        try {
            var1 = Class.forName("java.lang.Long");
        } catch (ClassNotFoundException var8) {
            throw new NoClassDefFoundError(var8.getMessage());
        }

        var0.add(var1);
        var15 = sWrapper;

        try {
            var14 = Class.forName("java.lang.Float");
        } catch (ClassNotFoundException var7) {
            throw new NoClassDefFoundError(var7.getMessage());
        }

        var15.add(var14);
        var15 = sWrapper;

        try {
            var14 = Class.forName("java.lang.Double");
        } catch (ClassNotFoundException var6) {
            throw new NoClassDefFoundError(var6.getMessage());
        }

        var15.add(var14);
        var15 = sWrapper;

        try {
            var14 = Class.forName("java.lang.Void");
        } catch (ClassNotFoundException var5) {
            throw new NoClassDefFoundError(var5.getMessage());
        }

        var15.add(var14);
        sImmutable = new HashSet(sWrapper);
        var0 = sImmutable;

        try {
            var1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException var4) {
            throw new NoClassDefFoundError(var4.getMessage());
        }

        var0.add(var1);
        var0 = sImmutable;

        try {
            var1 = Class.forName("java.math.BigInteger");
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }

        var0.add(var1);
        var0 = sImmutable;

        try {
            var1 = Class.forName("java.math.BigDecimal");
        } catch (ClassNotFoundException var2) {
            throw new NoClassDefFoundError(var2.getMessage());
        }

        var0.add(var1);
        sCache = new HashMap();
    }

    ReflectUtils() {
    }

    public static String fullClassName(Context var0, String var1) {
        String var2 = var1;
        if (var1.charAt(0) == '.') {
            var2 = var0.getPackageName() + var1;
        }

        return var2;
    }

    public static Object getEnclosingInstance(Object param0) {
        // $FF: Couldn't be decompiled
        return param0;
    }

    public static String getEnclosingInstanceName(Object var0) {
        Class var2 = var0.getClass().getEnclosingClass();

        int var1;
        for(var1 = -1; var2 != null; var2 = var2.getEnclosingClass()) {
            ++var1;
        }

        String var3;
        if (var1 == -1) {
            var3 = (String)null;
        } else {
            var3 = "this$" + var1;
        }

        return var3;
    }

    public static Field getField(Class<?> var0, String var1) {
        while(true) {
            Field var4;
            if (var0 == null) {
                var4 = (Field)null;
            } else {
                Field var2;
                try {
                    var2 = var0.getDeclaredField(var1);
                } catch (NoSuchFieldException var3) {
                    var0 = var0.getSuperclass();
                    continue;
                }

                var4 = var2;
            }

            return var4;
        }
    }

    public static Object getFieldValue(Class<?> var0, String var1) {
        Object var3;
        try {
            Field var4 = getField(var0, var1);
            var4.setAccessible(true);
            var3 = var4.get((Object)null);
        } catch (Throwable var2) {
            var3 = (Object)null;
        }

        return var3;
    }

    public static Object getFieldValue(Object var0, String var1) {
        if (var0 == null) {
            var0 = (Object)null;
        } else if (var1 == null) {
            var0 = (Object)null;
        } else {
            label32: {
                boolean var10001;
                Field var4;
                try {
                    var4 = getField(var0.getClass(), var1);
                } catch (Throwable var3) {
                    var10001 = false;
                    break label32;
                }

                if (var4 == null) {
                    var0 = (Object)null;
                    return var0;
                }

                try {
                    var4.setAccessible(true);
                    var0 = var4.get(var0);
                    return var0;
                } catch (Throwable var2) {
                    var10001 = false;
                }
            }

            var0 = (Object)null;
        }

        return var0;
    }

    public static Object getFieldValue(Object var0, String... var1) {
        if (var1 == null) {
            var0 = (Object)null;
        } else {
            for(int var2 = 0; var2 < var1.length; ++var2) {
                var0 = getFieldValue(var0, var1[var2]);
            }
        }

        return var0;
    }

    public static Method getMethod(Class<?> var0, String var1, Class<?>... var2) {
        while(true) {
            Method var5;
            if (var0 == null) {
                var5 = (Method)null;
            } else {
                Method var3;
                try {
                    var3 = var0.getDeclaredMethod(var1, var2);
                } catch (NoSuchMethodException var4) {
                    var0 = var0.getSuperclass();
                    continue;
                }

                var5 = var3;
            }

            return var5;
        }
    }

    public static <T> T invokeConstructor(Class<T> var0) {
        return (T)invokeConstructor(var0, new Class[0], new Object[0]);
    }

    public static <T> T invokeConstructor(Class<T> var0, Class<?>[] var1, Object[] var2) {
        Object var5;
        if (var0 == null) {
            var5 = (Object)null;
        } else if (var1 == null) {
            var5 = (Object)null;
        } else if (var2 == null) {
            var5 = (Object)null;
        } else {
            label35: {
                boolean var10001;
                Constructor var6;
                try {
                    var6 = var0.getDeclaredConstructor(var1);
                } catch (Throwable var4) {
                    var10001 = false;
                    break label35;
                }

                if (var6 == null) {
                    var5 = (Object)null;
                    return (T) var5;
                }

                try {
                    var6.setAccessible(true);
                    var5 = (Object)var6.newInstance(var2);
                    return (T) var5;
                } catch (Throwable var3) {
                    var10001 = false;
                }
            }

            var5 = (Object)null;
        }

        return (T) var5;
    }

    public static Object invokeMethod(Object var0, String var1) {
        return invokeMethod(var0, var1, new Class[0], new Object[0]);
    }

    public static Object invokeMethod(Object var0, String var1, Class<?>[] var2, Object[] var3) {
        if (var0 == null) {
            var0 = (Object)null;
        } else if (var1 == null) {
            var0 = (Object)null;
        } else if (var2 == null) {
            var0 = (Object)null;
        } else if (var3 == null) {
            var0 = (Object)null;
        } else {
            label38: {
                boolean var10001;
                Method var6;
                try {
                    var6 = getMethod(var0.getClass(), var1, var2);
                } catch (Throwable var5) {
                    var10001 = false;
                    break label38;
                }

                if (var6 == null) {
                    var0 = (Object)null;
                    return var0;
                }

                try {
                    var0 = invokeMethod(var6, var0, var3);
                    return var0;
                } catch (Throwable var4) {
                    var10001 = false;
                }
            }

            var0 = (Object)null;
        }

        return var0;
    }

    public static Object invokeMethod(Method var0, Object var1, Object... var2) {
        Object var4;
        try {
            var0.setAccessible(true);
            var4 = var0.invoke(var1, var2);
        } catch (Throwable var3) {
            var4 = (Object)null;
        }

        return var4;
    }

    public static Object invokeStaticMethod(Method var0, Object... var1) {
        return invokeMethod(var0, (Object)null, var1);
    }

    public static boolean isImmutable(Class<?> var0) {
        return sImmutable.contains(var0);
    }

    public static boolean isWrapper(Class<?> var0) {
        return sWrapper.contains(var0);
    }

    public static <T> T newInstance(Class<T> var0) {
        try {
            Constructor var2 = var0.getDeclaredConstructor();
            var2.setAccessible(true);
            Object var3 = (Object)var2.newInstance();
            return (T) var3;
        } catch (Throwable var1) {
            throw new IllegalStateException(var1);
        }
    }

    public static <T> T newInstance(Class<T> var0, Class<?>[] var1, Object[] var2) {
        try {
            Constructor var4 = var0.getDeclaredConstructor(var1);
            var4.setAccessible(true);
            Object var5 = (Object)var4.newInstance(var2);
            return (T) var5;
        } catch (Throwable var3) {
            throw new IllegalStateException(var3);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstanceByClassName(String var0) {
        Class var1 = (Class)null;
        SoftReference var2 = (SoftReference)sCache.get(var0);
        if (var2 != null) {
            var1 = (Class)var2.get();
        }

        Class var8 = var1;
        if (var1 == null) {
            try {
                var8 = Class.forName(var0);
                Map var7 = sCache;
                SoftReference var3 = new SoftReference(var8);
                var7.put(var0, var3);
            } catch (Throwable var5) {
                throw new IllegalStateException(var5);
            }
        }

        try {
            Object var6 = (Object)var8.newInstance();
            return (T) var6;
        } catch (Throwable var4) {
            throw new IllegalStateException(var4);
        }
    }

    @SuppressWarnings("UnnecessaryBoxing")
    public static Object newReturnInstance(Method var0) throws InstantiationException, IllegalAccessException {
        Class var3 = var0.getReturnType();
        Object var4;
        if (var3 == Boolean.TYPE) {
            var4 = false;
        } else if (var3 == Byte.TYPE) {
            var4 = 0;
        } else if (var3 == Character.TYPE) {
            var4 = '\u0000';
        } else if (var3 == Short.TYPE) {
            var4 = Short.valueOf((short)0);
        } else if (var3 == Integer.TYPE) {
            var4 = 0;
        } else if (var3 == Long.TYPE) {
            var4 = 0L;
        } else if (var3 == Float.TYPE) {
            var4 = 0.0F;
        } else if (var3 == Double.TYPE) {
            var4 = 0.0;
        } else {
            if (var3 != Void.TYPE) {
                Class var1;
                try {
                    var1 = Class.forName("java.lang.Void");
                } catch (ClassNotFoundException var2) {
                    throw new NoClassDefFoundError(var2.getMessage());
                }

                if (var3 != var1) {
                    var4 = var3.newInstance();
                    return var4;
                }
            }

            var4 = (Object)null;
        }

        return var4;
    }

    public static boolean setFieldValue(Object var0, String var1, Object var2) {
        boolean var3 = false;
        boolean var4;
        if (var0 == null) {
            var4 = var3;
        } else {
            var4 = var3;
            if (var1 != null) {
                label38: {
                    label32: {
                        boolean var10001;
                        Field var7;
                        try {
                            var7 = getField(var0.getClass(), var1);
                        } catch (Throwable var6) {
                            var10001 = false;
                            break label32;
                        }

                        var4 = var3;
                        if (var7 == null) {
                            return var4;
                        }

                        try {
                            var7.setAccessible(true);
                            var7.set(var0, var2);
                            break label38;
                        } catch (Throwable var5) {
                            var10001 = false;
                        }
                    }

                    var4 = var3;
                    return var4;
                }

                var4 = true;
            }
        }

        return var4;
    }
}
