package interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("prev");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("be replaced");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("post");
    }
}
