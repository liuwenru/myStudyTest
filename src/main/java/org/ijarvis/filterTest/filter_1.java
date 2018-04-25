package org.ijarvis.filterTest;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class filter_1 implements Filter {
    private static  final Logger logger=Logger.getLogger(filter_1.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Filter1_init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Filter1_dofilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        logger.debug("Filter1_destroy");

    }
}
