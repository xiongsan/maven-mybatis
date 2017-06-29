package bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouwei on 2017/3/30.
 */
@Data
public class User implements Serializable {
    private String id;
    private String name;
    private String account;
    private String password;
    private String email;
    private String telephone;
    private int status;
    private int deleteFlag;
    private String operationPermission;
    private List<String> operationPermissionList;
    //private String roleId;
    private String roles;
}
