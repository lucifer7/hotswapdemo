package hotel.swap.demo.service;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
public interface ReloadService {
    //重新将资源加载到文件中
    void reload(byte[] data, String fileName);
}
