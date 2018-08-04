package interceptor;

import testclass.Hello;
import testclass.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy{

    static Object bind(final Object target, final String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (interceptorClass == null){
                            return method.invoke(target,args);
                        }
                        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
                        Object result = null;
                        if (interceptor.before(proxy,target,method,args)){
                            result = method.invoke(target,args);
                        }else {
                            interceptor.around(proxy,target,method,args);
                        }
                        interceptor.after(proxy,target,method,args);
                        return result;
                    }
                });
    }


    public static void main(String[] args) {
        Hello proxy = (Hello) InterceptorJdkProxy.bind(new HelloImpl(),"interceptor.MyInterceptor");
        proxy.syaHello();
    }

}
