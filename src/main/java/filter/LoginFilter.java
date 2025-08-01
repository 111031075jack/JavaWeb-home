package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 有登入才放行的過濾器
//@WebFilter(urlPatterns = {"/user", "/user/delete", "/user/change/password"})
@WebFilter(urlPatterns = {"/user/*", "/japanese/class/level", "/beverage"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 判斷是否有登入 ?
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("username") == null) {
			// 記住 requestURI
			String requestURI = request.getRequestURI();
			session = request.getSession();
			session.setAttribute("requestURI", requestURI);
			
			request.setAttribute("message", requestURI +  "網址需要登入, 請先登入");
			request.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(request, response);
			return;
		}
		// 放行
		chain.doFilter(request, response);
		
		
	}
	
}
