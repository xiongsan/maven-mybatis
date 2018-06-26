package bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public class TodoList implements Serializable {
    String id;
    String title;
    String checked;
    String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
