package com.ipartek.formacion.biblioteca.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/perfil.jsp", "/usuarios/*"})
public class AutenticadoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 7965695012864194678L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		
		if(email == null) {
			// No está logueado
			// Le rebotamos a la página de login
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		// Continúa la petición como si no hubiera filtro
		chain.doFilter(request, response);
	}

}
