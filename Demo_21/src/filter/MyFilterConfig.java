package filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilterConfig implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //通过FilterConfig对象获取配置文件中初始化信息
        String encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
