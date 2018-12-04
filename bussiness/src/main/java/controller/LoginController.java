package controller;

import com.fable.enclosure.bussiness.interfaces.BaseResponse;
import com.fable.enclosure.bussiness.util.ResultKit;
import entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.todolist.ITodoListService;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/24
 * Time :15:06
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
@RestController
public class LoginController {

    @Autowired
    ITodoListService todoListService;

    @RequestMapping("/toLogin")
    public BaseResponse toLogin(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            return ResultKit.fail("password error!");
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            return ResultKit.fail("username error!");
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            return ResultKit.fail("fail times a lot error !");
        } catch (LockedAccountException lae) {
            return ResultKit.fail("account was locked !");
        }
        subject.getSession().setAttribute("user", user);
        subject.getSession().setTimeout(0);
        return ResultKit.success();
    }

}
