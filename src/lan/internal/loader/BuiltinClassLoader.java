package lan.internal.loader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.SecureClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.Manifest;

import lan.internal.misc.VM;
import lan.reflect.generics.reflectiveObjects.NotImplementedException;

public class BuiltinClassLoader extends SecureClassLoader {

    private static Class<?> realClassLoader = null;
    private static Class<?> realURLClassPath = null;

    static {
        try {
            realClassLoader = Class.forName("jdk.internal.loader.BuiltinClassLoader");
            realURLClassPath = Class.forName("jdk.internal.loader.URLClassPath");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Object thisClassLoader = null;

    /**
     * 其实它的子类只有用到string 和 skipEmptyElements
     * @param name
     * @param parent
     * @param path
     * @param skipEmptyElements
     */
    BuiltinClassLoader(String name, BuiltinClassLoader parent, String path, boolean skipEmptyElements) {
        try {
            Constructor<?> clzLoaderCreator = realClassLoader.getConstructor(String.class, realClassLoader.getClass(), realURLClassPath.getClass());
            Object urlClzPath = null;
            if(path != null || path.length() > 0) {
                Constructor<?> urlClzPathCreator = realURLClassPath.getConstructor(String.class, boolean.class);
                urlClzPath = urlClzPathCreator.newInstance(path, skipEmptyElements);
            }
            thisClassLoader = clzLoaderCreator.newInstance(name, parent != null? parent.thisClassLoader : null, urlClzPath);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasClassPath() {
        try {
            Method method = realClassLoader.getMethod("hasClassPath");
            return (boolean)method.invoke(thisClassLoader);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadModule(ModuleReference mref) {
        try {
            Method method = realClassLoader.getMethod("loadModule", ModuleReference.class);
            method.invoke(thisClassLoader, mref);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Class<?> loadClassOrNull(String name) {
        try {
            Method method = realClassLoader.getMethod("loadClassOrNull", String.class);
            return (Class<?>)method.invoke(thisClassLoader, name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream findResourceAsStream(String mn, String name) throws IOException {
        try {
            Method method = realClassLoader.getMethod("findResourceAsStream", String.class, String.class);
            return (InputStream)method.invoke(thisClassLoader, mn, name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Package defineOrCheckPackage(String name, Manifest man, URL url) {
        try {
            Method method = realClassLoader.getMethod("defineOrCheckPackage", String.class, Manifest.class, URL.class);
            return (Package)method.invoke(thisClassLoader, name, man, url);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public URL findResource(String name) {
        try {
            Method method = realClassLoader.getMethod("findResource", String.class);
            return (URL)method.invoke(thisClassLoader, name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Class<?> loadClassOrNull(String cn, boolean resolve) {
        try {
            Method method = realClassLoader.getMethod("loadClassOrNull", String.class, boolean.class);
            method.setAccessible(true);
            return (Class<?>)method.invoke(thisClassLoader, cn, resolve);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public URL findResource(String moduleName, String name) throws IOException {
        try {
            Method method = realClassLoader.getMethod("findResource", String.class, String.class);
            return (URL)method.invoke(thisClassLoader, moduleName, name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Enumeration<URL> findResources(String name) throws IOException {
        try {
            Method method = realClassLoader.getMethod("findResources", String.class);
            return (Enumeration<URL>)method.invoke(thisClassLoader, name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
