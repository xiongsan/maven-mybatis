package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/22.
 */
@Repository
public interface UserMapper {
    List<User> getUserList(User user);
    User getUser(@Param("id") String id);
}
