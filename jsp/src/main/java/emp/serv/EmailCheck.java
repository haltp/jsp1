package emp.serv;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import emp.EmpDAO;
import emp.EmpVO;

public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// email 파라미터 받기
		String email = request.getParameter("email");
		EmpVO empVO = EmpDAO.getInstance().selectOneByEmail(email);
		
/*		//json
		response.setContentType("text/html; charset=UTF-8");
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (empVO == null) {
			map.put("email", true);
			response.getWriter().print(gson.toJson(map));
		} else {
			map.put("email", false);
			map.put("email", empVO);
			response.getWriter().print(gson.toJson(map));
		}*/
		
		//xml
		response.setContentType("text/xml; charset=UTF-8");
		if(empVO==null) {
			response.getWriter().append("<email>")
								.append("true")
								.append("</email>");
		} else {
			response.getWriter().append("<email>")
								.append("false")
								.append("</email>");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
