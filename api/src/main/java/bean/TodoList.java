package bean;

/**
 * Created by Wanghairui on 2017/6/9.
 */
//@Data
public class TodoList {
    private String id;
    private String title;
    private int checked;
    private String sex;


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

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", sex='" + sex + '\'' +
                '}';
    }
}
