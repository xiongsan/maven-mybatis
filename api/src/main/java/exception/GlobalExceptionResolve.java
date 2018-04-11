package exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:spring 全局异常处理
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/2
 * Time :9:23
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class GlobalExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if(e instanceof UnauthorizedException){
            ModelAndView mv = new ModelAndView("error");
            return mv;
        }
        return null;
    }
}
