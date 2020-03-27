package lan.internal.misc;

import lan.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Used to set the Windows error mode at VM initialization time.
 * <p>
 * The error mode decides whether the system will handle specific types of serious errors
 * or whether the process will handle them.
 *
 * @since 1.6
 */
public class Win32ErrorMode {

    // The system does not display the critical-error-handler message box. Instead,
    // the system sends the error to the calling process.
    private static final long SEM_FAILCRITICALERRORS     = 0x0001;

    // The system does not display the general-protection-fault message box. This flag should
    // only be set by debugging applications that handle general protection (GP) faults themselves
    // with an exception handler.
    private static final long SEM_NOGPFAULTERRORBOX      = 0x0002;

    // The system automatically fixes memory alignment faults and makes them invisible
    // to the application. It does this for the calling process and any descendant processes.
    private static final long SEM_NOALIGNMENTFAULTEXCEPT = 0x0004;

    // The system does not display a message box when it fails to find a file. Instead,
    // the error is returned to the calling process.
    private static final long SEM_NOOPENFILEERRORBOX     = 0x8000;

    private Win32ErrorMode() {
    }

    /**
     * Invoke at VM initialization time to disable the critical error message box.
     * <p>
     * The critial error message box is disabled unless the system property
     * {@code sun.io.allowCriticalErrorMessageBox} is set to something other than
     * {@code false}. This includes the empty string.
     * <p>
     * This method does nothing if invoked after VM and class library initialization
     * has completed.
     */
    public static void initialize() {
        if (!lan.internal.misc.VM.isBooted()) {
            String s = System.getProperty("sun.io.allowCriticalErrorMessageBox");
            if (s == null || s.equals(Boolean.FALSE.toString())) {
                long mode = setErrorMode(0);
                mode |= SEM_FAILCRITICALERRORS;
                setErrorMode(mode);
            }
        }
    }

    /**
     * 这个类本来在这里的 https://github.com/openjdk/jdk14u/blob/master/src/java.base/windows/classes/sun/io/Win32ErrorMode.java
     * 复制过来后native方法对不上了，所以需要重新mapping一下。
     * @param mode
     * @return
     */
    // Win32 SetErrorMode
    //private static native long setErrorMode(long mode);
    private static long setErrorMode(long mode) {
        throw new NotImplementedException();
    }
}
