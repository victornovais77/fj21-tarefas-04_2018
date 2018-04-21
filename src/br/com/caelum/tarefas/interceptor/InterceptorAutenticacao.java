package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorAutenticacao extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
		String url = request.getRequestURI();
		
		if(url.endsWith("/loginForm") ||
			url.endsWith("/efetuaLogin") ||
			url.contains("/resources")) {
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null)
			return true;
		
		response.sendRedirect("/loginForm");
		return false;
	}
}


