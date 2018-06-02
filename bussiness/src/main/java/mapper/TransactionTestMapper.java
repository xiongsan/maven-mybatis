package mapper;

import bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Wanghairui on 2017/5/24.
 */
@Repository
public interface TransactionTestMapper {
      void addIncorrectUser(User user);
      void addUser(User user);
}
