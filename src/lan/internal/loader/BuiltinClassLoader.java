package lan.internal.loader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.ref.SoftReference;
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

    BuiltinClassLoader(String name, BuiltinClassLoader parent, URLClassPath ucp) {

    }
    public boolean hasClassPath() {
        throw new NotImplementedException();
    }

    public void loadModule(ModuleReference mref) {
        throw new NotImplementedException();
    }

    public Class<?> loadClassOrNull(String name) {
        throw new NotImplementedException();
    }

    public InputStream findResourceAsStream(String mn, String name) throws IOException {
        throw new NotImplementedException();
    }

    public Package defineOrCheckPackage(String name, Manifest man, URL url) {
        throw new NotImplementedException();
    }
    public URL findResource(String name) {
        throw new NotImplementedException();
    }
    protected Class<?> loadClassOrNull(String cn, boolean resolve) {
        throw new NotImplementedException();
    }
    public URL findResource(String moduleName, String name) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Enumeration<URL> findResources(String name) throws IOException {
        return super.findResources(name);
    }
}
