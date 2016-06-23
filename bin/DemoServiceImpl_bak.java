package hotel.swap.demo.service;

import hotel.swap.demo.dao.DemoDao;
import hotel.swap.demo.util.SpringContextHolder;
import hotel.swap.demo.vo.Demo;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello() {
        DemoDao dao = SpringContextHolder.getBean(DemoDao.class);
        Demo demo = dao.findAll().get(0);
        return demo.toString();
    }
}
