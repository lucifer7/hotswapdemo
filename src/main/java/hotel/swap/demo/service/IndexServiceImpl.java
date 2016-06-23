package hotel.swap.demo.service;

import hotel.swap.demo.classloader.MyClassLoader;
import org.springframework.stereotype.Service;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public String hello() {
        //通过类加载器加载，可以配置到数据库中
        MyClassLoader classLoader = new MyClassLoader(this.getClass().getClassLoader());
        String result = "sbsb";
        try {
            Class<?> clz = classLoader.loadClass("hotel.swap.demo.service.DemoServiceImpl");
            Object obj = clz.newInstance();
            //必须不能出错
            DemoService service = (DemoService) obj;
            System.out.println("加载当前的加载器是:" + clz.getClassLoader());
            System.out.println("加载当前的父加载器是:" + clz.getClassLoader().getParent());
            result = service.hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
