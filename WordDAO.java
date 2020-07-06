package project;

import java.util.ArrayList;
import java.util.HashMap;

public interface WordDAO {
	//추가하기
	public void wordInsert(Word w);
	//전체보기
	public ArrayList<Word> wordView();
	//수정하기
	public void wordUpdate(Word w);
	//삭제하기
	public void wordDelete(int num);
	//검색하기
	public ArrayList<Word> wordSearch(String key, String word);
}