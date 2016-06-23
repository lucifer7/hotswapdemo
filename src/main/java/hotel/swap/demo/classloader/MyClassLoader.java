package hotel.swap.demo.classloader;

import hotel.swap.demo.service.DemoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
public class MyClassLoader extends ClassLoader {

    private static final String CLASSPATH = "E:\\test\\";


    public MyClassLoader() {
        super();
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classLocalName = name.substring(name.lastIndexOf(".") + 1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            FileInputStream in = new FileInputStream(new File(CLASSPATH + classLocalName + ".class"));
            IOUtils.copy(in, out);
            byte[] bytes = out.toByteArray();
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            //可以在这里实现缓存，仿照jvm的实现方式
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //不需要这么严格的锁，这里实在偷懒
    private static final Object MIRROR = new Object();


    public static void reload(byte[] data, String fileName) {
        File file = new File(CLASSPATH + fileName);
        synchronized (MIRROR) {
            try {
                OutputStream out = new FileOutputStream(file);
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                IOUtils.copy(in, out);
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            //当成函数式，防止内存泄漏
            MyClassLoader classLoader = new MyClassLoader(Thread.currentThread().getContextClassLoader());
            Class<?> clz = classLoader.loadClass("hotel.swap.demo.service.DemoServiceImpl");
            Object obj = clz.newInstance();
            //必须不能出错
            DemoService service = (DemoService) obj;
            service.hello();
            classLoader = null;
            service = null;
        }
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }

}
