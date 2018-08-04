package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import testclass.HelloImpl;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    public Object getProxy(Class cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("prev");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.err.println("post");
        return obj;
    }

    static void test(){
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        HelloImpl obj = (HelloImpl) cglibProxyExample.getProxy(HelloImpl.class);
        obj.syaHello();
    }

    public static void main(String[] args) {
        test();
    }
}
