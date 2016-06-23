package hotel.swap.demo.dao;

import hotel.swap.demo.vo.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 *
 * @author carl.yu
 * @since 2016/6/16
 */
@Repository
public interface DemoDao extends JpaRepository<Demo, Integer> {
}
