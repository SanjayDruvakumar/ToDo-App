package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.UserDto;
import services.UserService;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		int age = LocalDate.now().getYear() - dob.getYear();
		UserDto dto = new UserDto();
		dto.setPass(req.getParameter("pass1"));
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("eamil1"));
		dto.setPNumber(Long.parseLong(req.getParameter("pnumber")));
		dto.setGender(req.getParameter("gender"));
		dto.setDob(dob);
		dto.setAge(age);

		UserService service = new UserService();
		if (service.saveUser(dto)) {
			resp.getWriter().print("<h1 align='center' style='color:green'>Account created Successfully</h1>");
			req.getRequestDispatcher("index.html").include(req, resp);
		} else {
              resp.getWriter().print("<h1 align='center' style='color:red'>Sorry! Account can't be created</h1>");
              req.getRequestDispatcher("SignUp.html").include(req, resp);
		}
		
	}
}
