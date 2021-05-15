package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 * @author Daniel
 *
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
		, urlPatterns = { "/jsp/candidatePortal.jsp", "/jsp/adminPortal.jsp", "/jsp/profileform.jsp","/jsp/profiletoupdateform.jsp",
				"/jsp/adminUpdateCandidates.jsp","/jsp/newquestionform.jsp", "/jsp/newquestiontoupdateform.jsp","/jsp/candidatetodeleteform.jsp",		
				"/jsp/candidatetoupdateform.jsp","/jsp/employeeform.jsp","/jsp/employeetoupdateform.jsp"})
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Will block unwanted page access for users
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		Getting session and identifying user role
		HttpSession session = ((HttpServletRequest)request).getSession(true);		
		System.out.println("User filter for role: " + session.getAttribute("role"));
		
		if (session.getAttribute("role") == null) {
			((HttpServletResponse) response).sendRedirect("/jsp/index.jsp");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
