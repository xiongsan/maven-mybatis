package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

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
 * Time :18:01
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class SessionFilter implements Filter {
    private String loginUrl;
    @Override
    public void init(FilterConfig filterConfig){
        loginUrl=ResourceBundle.getBundle("system").getString("loginUrl");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
// 登陆url
        String uri= httpRequest.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        //首页和登陆请求无需判断
        //SecurityUtils.getSubject().getSession().getAttribute("user") == null
        if(path.contains("login.jsp")){//shiro默认登录页走到这session肯定为空了
            if (httpRequest.getHeader("x-requested-with") != null
                    && httpRequest.getHeader("x-requested-with")
                    .equalsIgnoreCase("XMLHttpRequest")) {
                httpResponse.addHeader("sessionstatus", "timeOut");
                httpResponse.addHeader("loginPath", loginUrl);
                chain.doFilter(request, response);// 不可少，否则请求会出错
            } else {
                String contextPath = httpRequest.getContextPath();//容器名
                String total = httpRequest.getRequestURL().toString();
                String requestRoot = total.substring(0, total.indexOf(contextPath)) + contextPath;
                String str = "<script language='javascript'>"
                        + "window.top.location.href='"
                        + requestRoot+loginUrl
                        + "';</script>";
                response.setContentType("text/html;charset=UTF-8");
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return;
        }
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
