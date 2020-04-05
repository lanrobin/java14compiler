package lan.internal.misc;

//import sun.io.Win32ErrorMode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OSEnvironmentUtil {
    /*
     * Initialize any miscellaneous operating system settings that need to be set
     * for the class libraries.
     * <p>
     * At this time only the process-wide error mode needs to be set.
     */
    private static Class<?> realOSEnvironment = null;
    static {
        try {
            realOSEnvironment= Class.forName("jdk.internal.misc.OSEnvironment");
        }catch (ClassNotFoundException e) {

        }
    }
    public static void initialize() {
        //OSEnvironment.initialize()
        try {
            Method methodInitial = realOSEnvironment.getMethod("initialize");
            if(methodInitial != null) {
                methodInitial.invoke(null);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
