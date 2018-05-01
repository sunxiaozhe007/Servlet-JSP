package filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter  implements Filter {

    public MyFilter(){
        System.out.println("实例化Filter");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter拦截开始");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        //System.out.println("拦截结束");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter销毁");
    }
}
