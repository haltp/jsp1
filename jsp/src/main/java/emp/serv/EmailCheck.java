package emp.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.EmpDAO;
import emp.EmpVO;


public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EmailCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// email 파라미터 받기
		response.setContentType("text/html; charset=UTF-8");
		EmpVO empVO = EmpDAO.getInstace().selectOneByEmail("email");
		if (empVO == null) {
			response.getWriter().print("사용할 수 있는 이메일 입니다");
		} else {
			response.getWriter().print("사용할 수 없는 이메일 입니다");
		}
	}

}
