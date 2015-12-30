package ro.acasa.annonLogging.main;

import ro.acasa.annonLogging.annotations.OnCall;

public class Test {

    @OnCall(message = "Someone just said something")
    public void saySomething(String word){
        System.out.println(String.format("I just said: %s", word));
    }

   /* public static void ro.acasa.annonLogging.main(String[] args){
        Test test = new Test();
        ProxyFactory proxyFactory = new ProxyFactory(test);
        proxyFactory.addAdvice(
                new MethodInterceptor() {
                    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                        System.out.println(String.format("This method has %d ro.acasa.annonLogging.annotations.",methodInvocation.getMethod().getAnnotations().length));
                        if (methodInvocation.getMethod().isAnnotationPresent(OnCall.class)){
                            OnCall log = methodInvocation.getMethod().getAnnotation(OnCall.class);
                            System.out.println(log.message());

                        }
                        return null;
                    }
                }
        );

        Test proxyText = (Test) proxyFactory.getProxy();
        proxyText.saySomething("Hello!");
    }*/
}
