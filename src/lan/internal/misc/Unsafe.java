package lan.internal.misc;

import lan.reflect.generics.reflectiveObjects.NotImplementedException;

public class Unsafe {
    public static Unsafe getUnsafe() {
        throw new NotImplementedException();
    }

    public void ensureClassInitialized(Class<?> c) {
        throw new NotImplementedException();
    }

    public long objectFieldOffset(Class<?> c, String type) {
        throw new NotImplementedException();
    }
    public void putReference(Object o, long offset, Object x) {
        throw new NotImplementedException();
    }
    public Object getReference(Object o, long offset) {
        throw new NotImplementedException();
    }

    public final void putReferenceRelease(Object o, long offset, Object x) {
        throw new NotImplementedException();
    }
}
