package cn.moriaty.hothouse.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * @copyright ：神农大学生软件创新中心 版权所有 版权所有 © 2017
 * 
 * @author 16计算机弓耀
 * 
 * @version 1.0
 * 
 * @date 2017年10月16日 下午7:45:42
 * 
 * @Description TODO 处理全站编码过滤器
 */
public class MoCharacterEncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// 转化ServletRequest为HttpRequest
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		filterChain.doFilter(new MyRequest(req), resp);
	}

	/**
	 * 包装设计模式对request进行处理
	 */
	// request存在一个默认包装类（简化包装模式）
	class MyRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;

		public MyRequest(HttpServletRequest request) {
			// 用super传入一个被增强对象
			super(request);
			this.request = request;
		}

		// 覆盖实现方法
		@Override
		public String getParameter(String name) {
			String value = this.request.getParameter(name);
			if (!request.getMethod().equalsIgnoreCase("get")) {
				return value;
			}
			if (value == null) {
				return null;
			}
			try {
				return value = new String(value.getBytes("iso8859-1"), request.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

	}

	@Override
	public void destroy() {

	}
}
