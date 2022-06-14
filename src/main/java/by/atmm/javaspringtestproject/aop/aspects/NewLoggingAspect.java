package by.atmm.javaspringtestproject.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object arroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("arroundReturnLoggingAdvice: trying to return the book to the library");

        long begin = System.currentTimeMillis();

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("arroundReturnLoggingAdvice: exception was logged: " + e);
            targetMethodResult = "Unknown book";
            throw e;
        }

        long end = System.currentTimeMillis();
        System.out.println("Time of the method's work: " + (end - begin) + " milliseconds");

        // change target result
        // targetMethodResult = "Peace and Peace";

        System.out.println("arroundReturnLoggingAdvice: book was returned to the library");

        return targetMethodResult;

    }

}
