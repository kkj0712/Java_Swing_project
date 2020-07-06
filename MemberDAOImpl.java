package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAOImpl implements MemberDAO{
	String url,user,pwd;
	
	//생성자->디비 연결
	public MemberDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url="jdbc:oracle:thin:@localhost:1521:xe";
			user="scott";
			pwd="1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//회원가입-점수는 0으로 우선 설정
	public void memberInsert(Member m) {
			Connection con=null;
			PreparedStatement ps=null;
			try {
				con=DriverManager.getConnection(url,user,pwd);
				String sql="INSERT INTO member VALUES (member_seq.nextval,?,?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setString(1, m.getName());
				ps.setString(2, m.getId());
				ps.setString(3, m.getPw());
				ps.setString(4, m.getEmail());
				ps.setInt(5, 0);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(con,ps);
			}
		}
	
	//회원점수 수정
	public void scoreUpdate(Member m) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			String sql="UPDATE member SET score=?"
					+ "WHERE id=?";
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setInt(1, m.getScore());
			ps.setString(2, m.getId());
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	//아이디 중복확인
	public boolean idCheck(String id) {
		boolean result=true;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection(url,user,pwd);
			String sql="SELECT * FROM member WHERE id =?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id.trim());
			rs=ps.executeQuery();
			if(rs.next()) {
				result=false; //레코드가 존재하면 false
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeConnection(con, ps);
		}
		return result;
	}
	
	//로그인-로그인 하면 id와 pw가 맞는지 체크
	public int loginCheck(String id, String pw) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int result=0;
		try {
			con=DriverManager.getConnection(url, user, pwd);
			st=con.createStatement();
			String sql="select * from member where id='" + id + "'";
            rs = st.executeQuery(sql); 
            if (rs.next()==false || (id.isEmpty())==true) { // id가 존재x
                result=1;
            } else { //id가 존재O
                sql="select * from member where id='" + pw + "'";
                rs=st.executeQuery(sql);
                while (rs.next()==true) {         // 다음값의
                    if (rs.getString(4).equals(pw)) { // member DB의 4째열 PW와 같은지 비교
                        result=0;         // 같으면 로그인 성공
                    }else {                // 아이디는같고 pw가 다른경우
                        result=1;
                    }
                }
            }
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return result;
	}
	
	//관리자 창에서 성적 테이블 출력
	public ArrayList<Member> memberView() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Member> mArr=new ArrayList<Member>();
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql="SELECT * FROM member ORDER BY score desc";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Member m=new Member();
				m.setNum(rs.getInt("num"));
				m.setName(rs.getString("name"));
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setEmail(rs.getString("email"));
				m.setScore(rs.getInt("score"));
				mArr.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mArr;
	}

	//회원 수정
	public void memberUpdate(Member m) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			String sql="UPDATE member SET name=?, id=?,"
					+ "pw=?,score=? WHERE num=?";
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getId());
			ps.setString(3, m.getPw());
			ps.setInt(4, m.getScore());
			ps.setInt(5, m.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	//회원 검색
	public ArrayList<Member> memberSearch(String key, String word){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Member>mArr=new ArrayList<Member>();
		try {
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String sql="SELECT * FROM member WHERE "+key+" LIKE '%"+word+"%'";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Member m=new Member();
				m.setNum(rs.getInt("num"));
				m.setName(rs.getString("name"));
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setScore(rs.getInt("score"));
				mArr.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return mArr;
	}
	
	//회원 삭제
	public void memberDelete(int num) {
		Connection con=null;
		Statement st=null;
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql="DELETE FROM member WHERE num="+num;
			st=con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, null);
		}
	}

	//닫기 종료 메소드
	public void closeConnection(Connection con, Statement st, ResultSet rs) {
			try {
				if(con!=null) con.close();
				if(st!=null) st.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}