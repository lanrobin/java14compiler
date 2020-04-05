package lan.internal.misc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Unsafe {

    private Unsafe(Object unsafe) {
    }

    private Object thisUnsafe = null;
    private static Class<?> realUnsafe = null;

    static {
        try {
            realUnsafe = Class.forName("jdk.internal.misc.Unsafe");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Unsafe getUnsafe() {
        try {
            Method method = realUnsafe.getMethod("getUnsafe");
            var thisObject = method.invoke(null);
            if (thisObject != null) {
                return new Unsafe(thisObject);
            }
            return null;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void ensureClassInitialized(Class<?> c) {
        try {
            Method method = realUnsafe.getMethod("ensureClassInitialized", Class.class);
            method.invoke(thisUnsafe, c);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public long objectFieldOffset(Class<?> c, String type) {
        try {
            Method method = realUnsafe.getMethod("objectFieldOffset", Class.class, String.class);
            return (long) method.invoke(thisUnsafe, c, type);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void putReference(Object o, long offset, Object x) {
        try {
            Method method = realUnsafe.getMethod("putReference", Object.class, Long.TYPE, Object.class);
            method.invoke(thisUnsafe, o, offset, x);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getReference(Object o, long offset) {
        try {
            Method method = realUnsafe.getMethod("getReference", Object.class, Long.TYPE);
            return method.invoke(thisUnsafe, o, offset);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public final void putReferenceRelease(Object o, long offset, Object x) {
        try {
            Method method = realUnsafe.getMethod("putReferenceRelease", Object.class, Long.TYPE, Object.class);
            method.invoke(thisUnsafe, o, offset, x);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
