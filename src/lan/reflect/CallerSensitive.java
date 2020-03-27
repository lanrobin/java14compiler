package lan.reflect;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/*
 * A method annotated @CallerSensitive is sensitive to its calling class,
 * via {@link lan.internal.reflect.Reflection#getCallerClass Reflection.getCallerClass},
 * or via some equivalent.
 *
 * @author John R. Rose
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface CallerSensitive {
}
