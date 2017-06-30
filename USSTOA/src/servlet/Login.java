package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.BaseDao;
import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		String message;
		HttpSession session = request.getSession();
		
		if (role.equals("user")) {
			if(new UserDao().selectUser(ID, password)){
				synchronized (session) {
					session.setAttribute("ID", ID);
				}
				response.sendRedirect("/USSTOA/user.jsp");
			}else{
				message="请输入正确的身份信息！";
				request.setAttribute("message", message);
				response.sendRedirect("/USSTOA/login.jsp");
			} 
		} else if (role.equals("admin")) {
			if (new AdminDao().selectAdmin(ID, password)) {
				synchronized (session) {
					session.setAttribute("ID", ID);
				}
				response.sendRedirect("/USSTOA/admin.jsp");
			}else{
				message="请输入正确的身份信息！";
				request.setAttribute("message", message);
				response.sendRedirect("/USSTOA/login.jsp");
			}
		}
	}

}