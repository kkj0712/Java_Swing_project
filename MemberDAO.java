package project;

import java.util.ArrayList;

public interface MemberDAO {
	//회원가입
	public void memberInsert(Member m);
	
	//회원점수 수정
	public void scoreUpdate(Member m);

	//아이디 중복확인
	public boolean idCheck(String id);
	
	//로그인
	public int loginCheck(String id, String pw);
	
	//관리자 창에서 성적 테이블 출력
	public ArrayList<Member> mArr=new ArrayList<Member>();
	
	//회원 수정
	public void memberUpdate(Member m);
	
	//회원 검색
	public ArrayList<Member> memberSearch(String key, String word);

	//회원삭제
	public void memberDelete(int num);
}