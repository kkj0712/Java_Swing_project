package project;

public class Word {
	private int num;
	private String eng;
	private String kor;
	
	public Word() {
		
	}
	
	public Word(String eng, String kor) {
		this.eng=eng;
		this.kor=kor;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
}
