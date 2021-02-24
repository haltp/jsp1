package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Vo : Value Object == EmpDTO EmoDO, Emp DAO : Date Access Object
 * 
 */
public class EmpDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// singletone
	private static EmpDAO instance;

	public static EmpDAO getInstace() {
		if (instance == null) {
			instance = new EmpDAO();
		}
		return instance;
	}

	// 전체조회 select * from employees <=뒤에 물음표가 없어서 selectList() ()안에 값없어도 된다
	public ArrayList<EmpVO> selectList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID, " + "FIRST_NAME, " + "LAST_NAME, " + "EMAIL, " + "PHONE_NUMBER, "
					//+ "to_char(HIRE_DATE, 'yyyy-MM') hire_date, "
					+ "HIRE_DATE, "
					+ "JOB_ID, " + "SALARY, " + "COMMISSION_PCT, " + "MANAGER_ID, "
					+ "DEPARTMENT_ID FROM EMPLOYEES ORDER BY EMPLOYEE_ID";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("PHONE_NUMBER"));
				vo.setHire_date(rs.getDate("HIRE_DATE"));
				vo.setJob_id(rs.getString("JOB_ID"));
				vo.setSalary(rs.getString("SALARY"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}

	// 단건조회 select * from employees where employee_id=?
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID, " + "FIRST_NAME, " + "LAST_NAME, " + "EMAIL, " + "PHONE_NUMBER, "
					+ "HIRE_DATE, " + "JOB_ID, " + "SALARY, " + "COMMISSION_PCT, " + "MANAGER_ID, "
					+ "DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				//vo.setEmployee_id(1);
				vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone_number(rs.getString("PHONE_NUMBER"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	//이메일 조회
	public EmpVO selectOneByEmail(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, "
					+ "FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
				vo.setFirst_name(rs.getString("FIRST_NAME"));
				vo.setLast_name(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone_number(rs.getString("PHONE_NUMBER"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}

	public void insert(EmpVO vo) {
		try {
			// 1. connect(연결)
			conn = JdbcUtil.connect();
			// 2. statement (구문)
			String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, " + " LAST_NAME, " + " EMAIL, " + " HIRE_DATE, "
					+ " JOB_ID) " + " VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 3. execute(실행)
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setDate(4, vo.getHire_date());
			pstmt.setString(5, vo.getJob_id());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 등록됨");

			// 4. resultset(select라면 조회결과처리)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}

	public void update(EmpVO vo) {
		try {
			// 1. connect(연결)
			JdbcUtil.connect();
			// 2. statement (구문)

			// 3. execute(실행)

			// 4. resultset(select라면 조회결과처리)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. close(연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
}
