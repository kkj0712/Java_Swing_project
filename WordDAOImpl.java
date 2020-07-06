package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

//import com.model.Friend;

public class WordDAOImpl implements WordDAO{
	String url, user, pwd;
	
	//생성자->디비 연결
	public WordDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url="jdbc:oracle:thin:@localhost:1521:xe";
			user="scott";
			pwd="1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	//입력
	public void wordInsert(Word w) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection(url,user,pwd);
			String sql="INSERT INTO word VALUES (word_seq.nextval,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, w.getEng());
			ps.setString(2, w.getKor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,ps);
		}
		
	}
	//전체보기
	public ArrayList<Word> wordView() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Word> arr=new ArrayList<Word>();
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql="SELECT * FROM word ORDER BY num desc";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Word w=new Word();
				w.setNum(rs.getInt("num"));
				w.setEng(rs.getString("eng"));
				w.setKor(rs.getString("kor"));
				arr.add(w);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	//수정
	public void wordUpdate(Word w) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			String sql="UPDATE word SET eng=?, kor=? WHERE num=?";
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			ps.setString(1, w.getEng());
			ps.setString(2, w.getKor());
			ps.setInt(3, w.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	//삭제
	public void wordDelete(int num) {
		Connection con=null;
		Statement st=null;
		try {
			con=DriverManager.getConnection(url, user,pwd);
			String sql="DELETE FROM word WHERE num="+num;
			st=con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,null);
		}
		
	}
	//검색
	public ArrayList<Word> wordSearch(String key, String word) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<Word>arr=new ArrayList<Word>();
		try {
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			String sql="SELECT * FROM word WHERE "+key+" LIKE '%"+word+"%'";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Word w=new Word();
				w.setNum(rs.getInt("num"));
				w.setEng(rs.getString("eng"));
				w.setKor(rs.getString("kor"));
				arr.add(w);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		return arr;
	}
	//단어 추가시 DB 중복여부 조회
	public int searchEngword(String engword) {
		String str = "영어";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection(url,user,pwd);
			String sql="SELECT eng FROM word WHERE eng =?";
			ps=con.prepareStatement(sql);
			ps.setString(1, engword);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				str=rs.getString("eng");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (str.equals(engword) == false) {
			return 1;
		} else {
			return 0;
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
	//닫기 종료 메소드
	public void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}