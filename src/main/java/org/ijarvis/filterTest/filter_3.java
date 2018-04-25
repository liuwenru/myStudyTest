package org.ijarvis.filterTest;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class filter_3 implements Filter {
    private static  final Logger logger=Logger.getLogger(filter_3.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Filter3_init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Filter3_dofilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
