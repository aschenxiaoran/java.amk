package hx.amk.admin.intercepts;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test {

    public String name();

    public enum Option{Add,Up,SEL,DEL}

    boolean isArray() default true;

    Class<?> clazz() default Object.class;

    String prefix() default "Redis_";

    int expireSeconds() default 8000;

    Option option() default Option.SEL;
}
