package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Data
public class TodoList {
    String id;
    String title;
    String checked;
}
