package by.atmm.javaspringtestproject.aop.aspects;

import com.sun.jdi.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-14
 * https://mvnrepository.com/artifact/org.aspectj/aspectjweaver/1.9.9.1 jar
 */

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* by.atmm.javaspringtestproject.aop.SchoolLibrary.return*())")
    private void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* *Book(..))")
    private void allBookMethods() {
    }


    @Before("execution(public void *Book(..))")
    public void beforeGetBookAdvice(JoinPoint joinPoint) {
        System.out.println("beforeGetBookAdvice: Trying to get a book or magazine");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        String fullName = joinPoint.toLongString();
        System.out.println("JoinPoint method long Name: " + fullName);

        Object[] arguments = joinPoint.getArgs();
        Arrays.stream(arguments)
                .forEach(a -> System.out.println("JoinPoint method Argument: " + a));

    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: Trying to get a book or magazine");
    }

    @AfterReturning(pointcut = "execution(* returnBook(..)) || allReturnMethodsFromUniLibrary()", returning = "bookName")
    public void afterReturningBookAdvice(String bookName) {
        System.out.println("afterReturnBookAdvice: Trying to return a book or magazine");
        bookName = "Peace and Peace";
    }

}
