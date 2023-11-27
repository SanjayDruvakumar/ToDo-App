package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DataDao;
import services.UserService;
@WebServlet("/login")
public class Login extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String email=req.getParameter("email");
     String password=req.getParameter("pass");
     
     UserService service = new UserService();
		if (service.login(email,password)) {
			DataDao dao=new DataDao();
			req.getSession().setAttribute("user",dao.fingByEmail(email));
			resp.getWriter().print("<h1 align='center' style='color:green'>Login Successfully!!</h1>");
			req.getRequestDispatcher("Home.jsp").include(req, resp);
		} else {
           resp.getWriter().print("<h1 align='center' style='color:red'>Invaild Cradentials!</h1>");
           req.getRequestDispatcher("index.html").include(req, resp);
		}
}
}
