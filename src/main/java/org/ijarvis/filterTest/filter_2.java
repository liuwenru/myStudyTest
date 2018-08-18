package org.ijarvis.filterTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class filter_2 implements Filter {
    private static  final Logger logger= LoggerFactory.getLogger(filter_2.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Filter2_init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Filter2_dofilter");
        
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}