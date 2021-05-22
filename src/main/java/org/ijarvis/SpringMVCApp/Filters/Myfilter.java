package org.ijarvis.SpringMVCApp.Filters;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        // Get init parameter
//        String testParam = filterConfig.getInitParameter("test-param");
//
//        //Print the init parameter
//        System.out.println("Test Param: " + testParam);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Thread.sleep(Integer.parseInt(servletRequest.getParameter("sleep")));
            throw new IOException();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // servletRequest.setAttribute("Error", e);
            //servletRequest.getRequestDispatcher("/spring/printmsg?sleeptime=10000&p=1111").forward(servletRequest,servletResponse);
            servletRequest.getRequestDispatcher("/spring/printmsg?sleeptime=10000&p=1111");
        } finally {
            servletRequest.getRequestDispatcher("/spring/printmsg?sleeptime=10000&p=1111").forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
