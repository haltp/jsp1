package emp.serv;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DateUtil;
import emp.DeptDAO;
import emp.DeptVO;
import emp.EmpDAO;
import emp.EmpVO;
import emp.JobDAO;
import emp.JobVO;

/**
 * Servlet implementation class EmpInsert
 */
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //등록페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<JobVO> jobList = JobDAO.getInstance().selectList();
		List<DeptVO> deptList = DeptDAO.getinstance().selectList();
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		//http://localhost/jsp/
		request.getRequestDispatcher("/emp/empInsert.jsp")
				.forward(request, response); //request정보를 전달
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 VO담기
		String hire_date = request.getParameter("hire_date");	
		
		//builder 객체생성과 초기화
//		EmpVO empVO = EmpVO.builder()
//						.commission_pct(request.getParameter("commission_pct"))
//						.department_id(request.getParameter("department_id"))
//						.email(request.getParameter("email"))
//						.employee_id(request.getParameter("employee_id"))
//						.hire_date(DateUtil.toDate(hire_date))
//						.job_id(request.getParameter("job_id"))
//						.build();
//		
//		EmpDAO.getInstance().insert(empVO);
		response.sendRedirect("EmpList");
//		request.getRequestDispatcher("EmpList").forward(request, response);
	}
}
