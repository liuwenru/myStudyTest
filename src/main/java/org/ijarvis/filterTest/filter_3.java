package org.ijarvis.filterTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class filter_3 implements Filter {
    private static  final Logger logger= LoggerFactory.getLogger(filter_3.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Filter3_init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Filter3_dofilter");

        logger.debug("11111111");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
