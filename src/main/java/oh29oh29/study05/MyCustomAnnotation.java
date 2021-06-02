package oh29oh29.study05;

import java.lang.annotation.Documented;

@Documented
public @interface MyCustomAnnotation {
    // Annotation body
    int value() default 10;
}
