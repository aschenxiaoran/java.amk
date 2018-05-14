package hx.amk.admin.intercepts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // FOR AOP
@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class TestAspect {

    @Before("@annotation(test)")// 拦截被TestAnnotation注解的方法；如果你需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)，具体百度一下资料一大堆
    public void beforeTest(JoinPoint point, Test test) throws Throwable {
        System.out.println("beforeTest:" + test.name());
    }

    @Around("@annotation(test)")
    public void around(JoinPoint point,Test test){
            
    }

    @After("@annotation(test)")
    public void afterTest(JoinPoint point, Test test) {
        System.out.println("afterTest:" + test.name());
    }

}
