package fr.apside.directory.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.apside.directory.model.Employee;
import fr.apside.directory.utils.Constants;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)sresponse;
		HttpServletRequest request = (HttpServletRequest)srequest;
        Employee user = (Employee) request.getSession().getAttribute(
                Constants.SESSION_USER);
        String uri = request.getRequestURI();
        String base = request.getContextPath();
        uri = uri.substring(base.length());
        if (user == null && !uri.startsWith("/api/login")) {
            request.getSession().invalidate();
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"SESSION-EXPIRED\"}");
        }else{
        	filterChain.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
