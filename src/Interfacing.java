import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Interfacing {


    public static Object create(Class<?>[] interfaces) {
        return Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, getInvocationHandler());
    }

    private static InvocationHandler getInvocationHandler() {

        return new InvocationHandler() {
            final Map<String, Object> map = new HashMap<>();


            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                final String name = method.getName();
                if (name.startsWith("set")) {
                    map.put(name.substring(3), objects[0]);
                    return null;
                } else if (name.startsWith("get")) {
                    return map.get(name.substring(3));
                } else {
                    throw new UnsupportedOperationException();
                }

            }
        };
    }

}
