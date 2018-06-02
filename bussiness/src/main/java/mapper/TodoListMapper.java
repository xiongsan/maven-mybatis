package mapper;

import bean.TodoList;
import bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/22.
 */
@Repository
public interface TodoListMapper {
    List<TodoList> getTodoList();
}
