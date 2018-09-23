package filter;

import org.apache.shiro.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
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
//        if(verify(httpRequest)){
//                try {
//                    if(isAjaxRequest(httpRequest)){
//                        httpResponse.addHeader("xxsClean", "1");
//                        return;
//                    }
//                    httpRequest.getRequestDispatcher("/error").forward(httpRequest, httpResponse);
//                }  catch (Exception e) {
//                    e.printStackTrace();
//                }
//            return;
//        }
// 登陆url
       boolean boolea= SecurityUtils.getSubject().isAuthenticated();
        System.out.println(boolea);
        String uri= httpRequest.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        //首页和登陆请求无需判断
        //SecurityUtils.getSubject().getSession().getAttribute("user") == null
        if(path.contains("login.jsp")){//shiro默认登录页走到这session肯定为空了
            if (isAjaxRequest(httpRequest)) {
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
            chain.doFilter(httpRequest, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断字符串中是否含有注入攻击字符
     * @param
     * @return
     */
    private boolean verify(HttpServletRequest httpRequest){

        String referer=httpRequest.getHeader("Referer");
        String contextPath = httpRequest.getContextPath();//容器名
        String map = httpRequest.getRequestURI().replace(contextPath, "");
        boolean step0=map.equals(loginUrl);
        String total = httpRequest.getRequestURL().toString();
        String requestRoot = total.substring(0, total.indexOf(contextPath)) + contextPath;
        boolean step1 = !((referer != null) && (referer.trim().startsWith(requestRoot)));
        boolean step2 = injectInput(httpRequest);
        return !step0 && (step1 || step2);
    }

    public boolean injectInput(ServletRequest request) {

        Enumeration e = request.getParameterNames();
        Map map=request.getParameterMap();
        if(map.size()==0){
            return false;
        }

        String attributeName;
        String attributeValues[];
        String inj = "";
        while (e.hasMoreElements()) {
            attributeName = (String)e.nextElement();
            //不对密码信息进行过滤，一般密码中可以包含特殊字符
            if(attributeName.equals("userPassword")||attributeName.equals("confirmPassword")||attributeName.equals("PASSWORD")
                    ||attributeName.equals("password")||attributeName.equals("PASSWORD2")||attributeName.equals("validPassword")){
                continue;
            }

            attributeValues = request.getParameterValues(attributeName);
            for (int i = 0; i < attributeValues.length; i++) {

                if(attributeValues[i]==null||attributeValues[i].equals(""))
                    continue;
                inj = injectChar(attributeValues[i]);

                if (!inj.equals(""))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private String injectChar(String str) {

        String inj_str = "\" ) \' * % < > &";
        String inj_stra[] = inj_str.split(" ");

        for (int i = 0 ; i < inj_stra.length ; i++ )
        {
            if (str.contains(inj_stra[i]))
            {
                return inj_stra[i];
            }
        }
        return "";
    }

    private boolean isAjaxRequest( HttpServletRequest httpRequest){
        return httpRequest.getHeader("x-requested-with") != null
                && httpRequest.getHeader("x-requested-with")
                .equalsIgnoreCase("XMLHttpRequest");
    }
}
