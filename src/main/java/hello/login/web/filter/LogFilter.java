package hello.login.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("log filter init");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("log filter doFilter");

		HttpServletRequest httpReqeuset = (HttpServletRequest)request;
		String requestURI = httpReqeuset.getRequestURI();

		String uuid = UUID.randomUUID().toString();

		try {
			log.info("REQUEST [{}][{}]", uuid, requestURI);
			chain.doFilter(request,response);
		} catch (Exception e) {
			throw e;
		} finally {
			log.info("RESPONSE  [{}][{}]", uuid, requestURI);
		}

	}

	public void destroy(FilterConfig filterConfig) throws ServletException {
		log.info("log filter destroy");
	}
}
