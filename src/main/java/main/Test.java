package main;

import annotations.Log;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Test {

    @Log(message = "Someone just said something")
    public void saySomething(String word){
        System.out.println(String.format("I just said: %s", word));
    }

    public static void main(String[] args){
        Test test = new Test();
        ProxyFactory proxyFactory = new ProxyFactory(test);
        proxyFactory.addAdvice(
                new MethodInterceptor() {
                    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                        System.out.println(String.format("This method has %d annotations.",methodInvocation.getMethod().getAnnotations().length));
                        if (methodInvocation.getMethod().isAnnotationPresent(Log.class)){
                            Log log = methodInvocation.getMethod().getAnnotation(Log.class);
                            System.out.println(log.message());
                                
                        }
                        return null;
                    }
                }
        );

        Test proxyText = (Test) proxyFactory.getProxy();
        proxyText.saySomething("Hello!");
    }
}
