package hotel.swap.demo.service;

import hotel.swap.demo.classloader.MyClassLoader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

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
public class ReloadServiceImpl implements ReloadService {


    @Override
    public void reload(byte[] data, String fileName) {
        MyClassLoader.reload(data, fileName);
    }
}
