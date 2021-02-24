package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private static JobDAO instance;

	public static JobDAO getInstance() {
		if (instance == null) {
			instance = new JobDAO();
		}
		return instance;
	}

	public List<JobVO> selectList() {
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new JobVO();
				vo.setJOB_ID(rs.getString("JOB_ID"));
				vo.setJOB_TITLE(rs.getString("JOB_TITLE"));
				vo.setMAX_SALARY(rs.getString("MIN_SALARY"));
				vo.setMIN_SALARY(rs.getString("MAX_SALARY"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
}
