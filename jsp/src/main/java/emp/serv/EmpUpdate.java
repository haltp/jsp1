package emp.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DeptDAO;
import emp.DeptVO;
import emp.EmpDAO;
import emp.EmpVO;
import emp.JobDAO;
import emp.JobVO;


public class EmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	//수정페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<JobVO> jobList = JobDAO.getInstance().selectList();
		List<DeptVO> deptList = DeptDAO.getinstance().selectList();
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		
		//수정할 사원정보를 단건조회
		String empid = request.getParameter("employee_id");
		EmpVO empVO = EmpDAO.getInstance().selectOne(empid);
		request.setAttribute("empVO", empVO);		
		request.getRequestDispatcher("/emp/empInsert.jsp").forward(request, response);
	}

	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
