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
 */
/**
 * @author Daniel
 *
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
		, urlPatterns = { "/jsp/adminPortal.jsp","/jsp/adminUpdateCandidates.jsp","/jsp/adminNewQuestions.jsp"
				,"/jsp/newquestiontoupdateform.jsp","/jsp/candidatetodeleteform.jsp","/jsp/newquestionform.jsp"
				,"/jsp/candidatetoupdateform.jsp","/jsp/employeeform.jsp","/jsp/employeetoupdateform.jsp","/jsp/questionnaireResults.jsp"})
public class CandidateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CandidateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *
	 *Will block unwanted page access
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//		Getting session and identiyfing role
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		String role = "undefined";
		if (session.getAttribute("role") != null) {
			role = (String) session.getAttribute("role");
		}
		System.out.println("Candidate filter for role: " + role);
		if (role.equals("candidate")) {
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
