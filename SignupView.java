package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SignupView extends JFrame {
	MemberDAOImpl mdao=new MemberDAOImpl();
	boolean idflag;
	int idcheck;
	String idStr="";
	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblID;
	private JLabel lblPW;
	private JLabel lblEmail;
	private JLabel lbPWconfirm;
	private JTextField tfName;
	private JTextField tfID;
	private JTextField tfEmail;
	private JButton btnSignUp;
	private JButton btnCancel;
	private JPasswordField tfPW;
	private JPasswordField tfPWconfirm;
	private JLabel lblpwBad;
	private JButton btnIDconfirm;
	private JLabel lblNameBad;
	private JLabel lblpwNull;
	private JLabel lblpwGood;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupView frame = new SignupView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignupView() { //회원가입창을 닫았을때 GUIMain은 닫히지 않도록
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getLblID());
		contentPane.add(getLblPW());
		contentPane.add(getLbPWconfirm());
		contentPane.add(getLblEmail());
		contentPane.add(getTfName());
		contentPane.add(getTfID());
		contentPane.add(getTfPW());
		contentPane.add(getTfPWconfirm());
		contentPane.add(getTfEmail());
		contentPane.add(getBtnSignUp());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnIDconfirm());
		contentPane.add(getLblNameBad());
		contentPane.add(getLblpwNull());
		contentPane.add(getLblpwBad());
		contentPane.add(getLblpwGood());
	}
	private JLabel getLblName() { //이름
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setBounds(18, 23, 57, 15);
		}
		return lblName;
	}
	private JLabel getLblNameBad() { //이름을 입력하세요
		if (lblNameBad == null) {
			lblNameBad = new JLabel("이름을 입력하세요");
			lblNameBad.setForeground(Color.RED);
			lblNameBad.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNameBad.setBounds(130, 46, 133, 15);
			lblNameBad.setVisible(false);
		}
		return lblNameBad;
	}
	private JLabel getLblID() { //아이디
		if (lblID == null) {
			lblID = new JLabel("아이디");
			lblID.setBounds(18, 80, 57, 15);
		}
		return lblID;
	}
	private JLabel getLblPW() { //패스워드
		if (lblPW == null) {
			lblPW = new JLabel("패스워드");
			lblPW.setBounds(18, 154, 57, 15);
		}
		return lblPW;
	}
	private JLabel getLblpwNull() { //패스워드를 입력하세요
		if (lblpwNull == null) {
			lblpwNull = new JLabel("패스워드를 입력하세요");
			lblpwNull.setHorizontalAlignment(SwingConstants.RIGHT);
			lblpwNull.setForeground(Color.RED);
			lblpwNull.setBounds(130, 177, 133, 15);
			lblpwNull.setVisible(false);
		}
		return lblpwNull;
	}
	private JLabel getLbPWconfirm() { //패스워드 확인
		if (lbPWconfirm == null) {
			lbPWconfirm = new JLabel("패스워드 확인");
			lbPWconfirm.setBounds(18, 205, 100, 15);
		}
		return lbPWconfirm;
	}
	private JLabel getLblpwGood() { //암호 일치
		if (lblpwGood == null) {
			lblpwGood = new JLabel("암호 일치");
			lblpwGood.setForeground(Color.BLUE);
			lblpwGood.setHorizontalAlignment(SwingConstants.RIGHT);
			lblpwGood.setBounds(206, 229, 57, 15);
			lblpwGood.setVisible(false);
		}
		return lblpwGood;
	}
	private JLabel getLblpwBad() { //암호 불일치
		if (lblpwBad == null) {
			lblpwBad = new JLabel("암호 불일치");
			lblpwBad.setHorizontalAlignment(SwingConstants.RIGHT);
			lblpwBad.setForeground(Color.RED);
			lblpwBad.setBounds(156, 229, 107, 15);
			lblpwBad.setVisible(false);
		}
		return lblpwBad;
	}
	private JLabel getLblEmail() { //이메일
		if (lblEmail == null) {
			lblEmail = new JLabel("이메일");
			lblEmail.setBounds(19, 255, 57, 15);
		}
		return lblEmail;
	}

//	이름 텍스트필드 tfName
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tfName.getText().equals("")) {
						lblNameBad.setVisible(true);
					}else {
						lblNameBad.setVisible(false);
					}
				}
			});
			tfName.setBounds(109, 20, 155, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
//	아이디 텍스트필드 tfID
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tfID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디가 공백입니다.");
					}
				}
			});
			tfID.setBounds(109, 77, 155, 21);
			tfID.setColumns(10);
		}
		return tfID;
	}
//	아이디 중복확인 버튼-중복확인 안하고 가입버튼 누르면 중복확인하라는 메시지 띄우기
	private JButton getBtnIDconfirm() {
		if (btnIDconfirm == null) {
			btnIDconfirm = new JButton("아이디 중복확인");
			btnIDconfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idflag=mdao.idCheck(tfID.getText());
					idcheck=0; //ID 체크 안했을때 
					if(idflag==false) {
						JOptionPane.showMessageDialog(null, "중복된 아이디");
						idcheck=1; //ID 체크 했는데 중복일때
					}else if(idflag==true) {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디");
						idcheck=2; //ID 체크 했고 중복이 아닐때
					}
				}
			});
			btnIDconfirm.setActionCommand("아이디 중복확인");
			btnIDconfirm.setBounds(109, 107, 154, 23);
		}
		return btnIDconfirm;
	}
//	이메일 텍스트필드 tfEmail
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(108, 252, 155, 21);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
//	패스워드 텍스트필드 tfPW
	private JPasswordField getTfPW() {
		if (tfPW == null) {
			tfPW = new JPasswordField();
			tfPW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					char[]secret_pw=tfPW.getPassword();
					String pw="";
					for(char cha:secret_pw) {
						Character.toString(cha);
						pw+=cha;
					}
					if(pw.equals("")) {
						lblpwNull.setVisible(true);
						lblpwBad.setVisible(false);
						lblpwGood.setVisible(false);
					}else {
						lblpwNull.setVisible(false);
						lblpwBad.setVisible(false);
						lblpwGood.setVisible(false);
					}
				}
			});
			tfPW.setBounds(108, 151, 155, 21);
		}
		return tfPW;
	}
//	패스워드 확인 텍스트필드 tfPWconfirm
	private JPasswordField getTfPWconfirm() {
		if (tfPWconfirm == null) {
			tfPWconfirm = new JPasswordField();
			tfPWconfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					char[]secret_pw=tfPW.getPassword(); //패스워드 받아오기
					String pw="";
					for(char cha:secret_pw) {
						Character.toString(cha);
						pw+=cha;
					}
					char[]secret_pw_confirm=tfPWconfirm.getPassword(); //패스워드 확인 받아오기
					String pw_confirm="";
					for(char cha:secret_pw_confirm) {
						Character.toString(cha);
						pw_confirm+=cha;
					}
					if(pw_confirm.equals("")) { //암호가 빈칸일때
						lblpwNull.setVisible(true);
						lblpwBad.setVisible(false);
						lblpwGood.setVisible(false);
					}else if(pw.equals(pw_confirm)) { //암호가 일치할때
						lblpwGood.setVisible(true); //암호일치 메시지 on
						lblpwBad.setVisible(false); //암호불일치 메시지 off
						lblpwNull.setVisible(false); //암호 널 메시지 off
					}else { //암호가 일치하지 않을때
						lblpwGood.setVisible(false); //암호일치 메시지 off
						lblpwBad.setVisible(true); //암호불일치 메시지 on
						lblpwNull.setVisible(false); //암호 널 메시지 off
					}
				}
			});
			tfPWconfirm.setBounds(108, 202, 155, 21);
		}
		return tfPWconfirm;
	}
//	가입버튼 btnSignup-member DB에 회원정보 저장
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("가입");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int a=0;
					if(tfName.getText().equals("")) {}	else {a++;} //이름을 써야함 a==1
					if(idcheck==0) { //ID 체크 안했을때 
						JOptionPane.showMessageDialog(null, "아이디 중복확인");
					}else if(idcheck==2) { //ID 체크 했고 중복이 아닐때 a==2
						idStr=tfID.getText();
						a++;
					}
					//패스워드 저장
					char[]secret_pw=tfPW.getPassword(); 
					String pw="";
					for(char cha:secret_pw) {
						Character.toString(cha);
						pw+=cha; 
					}
					if(pw.equals("")) {//패스워드가 공백일때
						lblpwNull.setVisible(true);
						lblpwBad.setVisible(false);
						lblpwGood.setVisible(false);
					} 
					//패스워드 확인 저장
					char[]secret_pw_confirm=tfPWconfirm.getPassword(); 
					String pw_confirm="";
					for(char cha:secret_pw_confirm) {
						Character.toString(cha);
						pw_confirm+=cha; 
					}
					if(pw_confirm.equals("")) { //패스워드 확인이 공백일때
						lblpwNull.setVisible(true);
						lblpwBad.setVisible(false);
						lblpwGood.setVisible(false);
					}
					if(pw.equals(pw_confirm)) { //암호가 일치할때 a==3
						lblpwGood.setVisible(true); //암호일치 메시지 on
						lblpwBad.setVisible(false); //암호불일치 메시지 off
						lblpwNull.setVisible(false); //암호 널 메시지 off
						a++;
					}else { //암호가 일치하지 않을때
						lblpwGood.setVisible(false); //암호일치 메시지 off
						lblpwBad.setVisible(true); //암호불일치 메시지 on
						lblpwNull.setVisible(false); //암호 널 메시지 off
					}
					if(a==3) {
						Member m=new Member();
						m.setName(idStr);
						m.setId(tfID.getText());
						m.setPw(pw_confirm);
						m.setEmail(tfEmail.getText());
						m.setScore(0);
						mdao.memberInsert(m);
						JOptionPane.showMessageDialog(null, "가입되었습니다.");
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "가입양식 확인");
					}
				}
			});
			btnSignUp.setBounds(29, 313, 97, 23);
		}
		return btnSignUp;
	}
//	취소버튼 btnCancel
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setBounds(156, 313, 97, 23);
		}
		return btnCancel;
	}

}