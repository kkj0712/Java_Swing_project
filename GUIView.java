package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;

public class GUIView extends JFrame {
	ArrayList<Word> arr; //단어 저장할 ArrayList 전역으로 선언
	ArrayList<Member> mArr;
	WordDAOImpl dao=new WordDAOImpl(); //Word DB와 연결 dao
	MemberDAOImpl mdao=new MemberDAOImpl(); //Member DB와 연결 mdao
	
	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel pn_study;
	static private JTabbedPane tabbedPane; 
	private JPanel tabList;
	private JPanel tabTest;
	private JPanel panel_Edit;
	private JPanel pn_login;
	private JLabel lbl_ID;
	private JLabel lbl_ID_1;
	private JTextField tfID;
	private JButton btnLogin;
	private JButton btnSignup;
	private JTextField tfEng1;
	private JTextField tfEng2;
	private JTextField tfEng3;
	private JTextField tfEng4;
	private JTextField tfEng5;
	private JTextField tfEng6;
	private JTextField tfEng7;
	private JTextField tfEng8;
	private JTextField tfEng9;
	private JTextField tfKor1;
	private JTextField tfKor2;
	private JTextField tfKor3;
	private JTextField tfKor4;
	private JTextField tfKor5;
	private JTextField tfKor6;
	private JTextField tfKor7;
	private JTextField tfKor8;
	private JTextField tfKor9;
	private JLabel lblEngword;
	private JLabel lblKormean;
	private JButton btnInsert;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField tfEng10;
	private JTextField tfKor10;
	private JPanel panel_Search;
	private JComboBox jcb;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JPanel panel_Test;
	private JLabel lblEngword_1;
	private JTextField tfEngT1;
	private JTextField tfEngT2;
	private JTextField tfEngT3;
	private JTextField tfEngT4;
	private JTextField tfEngT5;
	private JTextField tfEngT6;
	private JTextField tfEngT7;
	private JTextField tfEngT8;
	private JTextField tfEngT9;
	private JTextField tfEngT10;
	private JTextField tfKorT10;
	private JTextField tfKorT9;
	private JTextField tfKorT8;
	private JTextField tfKorT7;
	private JTextField tfKorT6;
	private JTextField tfKorT5;
	private JTextField tfKorT4;
	private JTextField tfKorT3;
	private JTextField tfKorT2;
	private JTextField tfKorT1;
	private JLabel lblKormean_1;
	private JSeparator separator;
	private JButton btnFinish;
	private JButton btnClose;
	private JTextField tfOX1;
	private JLabel lblOX;
	private JTextField tfOX2;
	private JTextField tfOX3;
	private JTextField tfOX4;
	private JTextField tfOX5;
	private JTextField tfOX6;
	private JTextField tfOX7;
	private JTextField tfOX8;
	private JTextField tfOX9;
	private JTextField tfOX10;
	private JLabel lblCorrect;
	private JTextField tfAns1;
	private JTextField tfAns2;
	private JTextField tfAns3;
	private JTextField tfAns4;
	private JTextField tfAns5;
	private JTextField tfAns6;
	private JTextField tfAns7;
	private JTextField tfAns8;
	private JTextField tfAns9;
	private JTextField tfAns10;
	private JPasswordField tfPW;
	private JButton btnBack;
	private JButton btnStart;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIView frame = new GUIView();
					frame.setVisible(true);
					tabbedPane.setEnabledAt(1, false); //문제풀기 탭 비활성화 (로그인 시 가능)
					tabbedPane.setEnabledAt(2, false); //단어추가 탭 비활성화
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIView() {
		setTitle("영단어 암기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSplitPane());
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBounds(5, 5, 418, 504);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setRightComponent(getPn_study());
			splitPane.setLeftComponent(getPn_login());
			splitPane.setDividerLocation(80);
		}
		return splitPane;
	}
	private JPanel getPn_study() {
		if (pn_study == null) {
			pn_study = new JPanel();
			pn_study.setLayout(new BorderLayout(0, 0));
			pn_study.add(getTabbedPane(), BorderLayout.CENTER);
		}
		return pn_study;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("단어목록", null, getTabList(), null);
			tabbedPane.addTab("문제풀기", null, getTabTest(), null);
			tabbedPane.addTab("단어추가", null, getPanel_Edit(), null);
		}
		return tabbedPane;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JPanel getTabList() {
		if (tabList == null) {
			tabList = new JPanel();
			tabList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
			tabList.setBackground(SystemColor.window);
			tabList.setLayout(new BorderLayout(0, 0));
			tabList.add(getScrollPane(), BorderLayout.CENTER);
			tabList.add(getPanel_Search(), BorderLayout.NORTH);
		}
		return tabList;
	}
	private JPanel getTabTest() {
		if (tabTest == null) {
			tabTest = new JPanel();
			tabTest.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
			tabTest.setLayout(new BorderLayout(0, 0));
			tabTest.add(getPanel_Test(), BorderLayout.CENTER);
		}
		return tabTest;
	}
	private JPanel getPanel_Edit() {
		if (panel_Edit == null) {
			panel_Edit = new JPanel();
			panel_Edit.setLayout(null);
			panel_Edit.add(getTfEng1());
			panel_Edit.add(getTfEng2());
			panel_Edit.add(getTfEng3());
			panel_Edit.add(getTfEng4());
			panel_Edit.add(getTfEng5());
			panel_Edit.add(getTfEng6());
			panel_Edit.add(getTfEng7());
			panel_Edit.add(getTfEng8());
			panel_Edit.add(getTfEng9());
			panel_Edit.add(getTextField_1_1());
			panel_Edit.add(getTfKor1());
			panel_Edit.add(getTfKor2());
			panel_Edit.add(getTfKor3());
			panel_Edit.add(getTfKor4());
			panel_Edit.add(getTfKor5());
			panel_Edit.add(getTfKor6());
			panel_Edit.add(getTfKor7());
			panel_Edit.add(getTfKor8());
			panel_Edit.add(getTfKor9());
			panel_Edit.add(getTextField_2_1());
			panel_Edit.add(getLblEngword());
			panel_Edit.add(getLblKormean());
			panel_Edit.add(getBtnInsert());
		}
		return panel_Edit;
	}
	private JPanel getPn_login() {
		if (pn_login == null) {
			pn_login = new JPanel();
			pn_login.setLayout(null);
			pn_login.add(getLbl_ID());
			pn_login.add(getLbl_ID_1());
			pn_login.add(getTfID());
			pn_login.add(getBtnLogin());
			pn_login.add(getBtnSignup());
			pn_login.add(getTfPW());
			pn_login.add(getBtnLogout());
			pn_login.add(getBtnManager());
		}
		return pn_login;
	}
	private JLabel getLbl_ID() {
		if (lbl_ID == null) {
			lbl_ID = new JLabel("아이디");
			lbl_ID.setFont(new Font("돋움", Font.BOLD, 14));
			lbl_ID.setBounds(8, 12, 79, 23);
			lbl_ID.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lbl_ID;
	}
	private JLabel getLbl_ID_1() {
		if (lbl_ID_1 == null) {
			lbl_ID_1 = new JLabel("패스워드");
			lbl_ID_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_ID_1.setFont(new Font("돋움", Font.BOLD, 14));
			lbl_ID_1.setBounds(8, 45, 79, 23);
		}
		return lbl_ID_1;
	}
	
	JTextField[]engTArr=new JTextField[10]; //영어문제 텍스트 필드를 배열로
	JTextField[]korTArr=new JTextField[10]; //한글 뜻 텍스트 필드를 배열로
	
	JTextField[]oxArr=new JTextField[10]; //OX 텍스트 필드를 배열로
	JTextField[]ansArr=new JTextField[10]; //정답 텍스트 필드를 배열로
	
	JTextField[]engArr=new JTextField[10]; //영어단어 텍스트 필드를 배열로
	JTextField[]korArr=new JTextField[10]; //한글뜻 텍스트 필드를 배열로
	private JButton btnLogout;
	private JButton btnManager;
	
//	<문제풀기 패널>
	private JPanel getPanel_Test() {
		if (panel_Test == null) {
			panel_Test = new JPanel();
			panel_Test.setLayout(null);
			panel_Test.add(getLblEngword_1());
			panel_Test.add(getTfEngT1());
			panel_Test.add(getTfEngT2());
			panel_Test.add(getTfEngT3());
			panel_Test.add(getTfEngT4());
			panel_Test.add(getTfEngT5());
			panel_Test.add(getTfEngT6());
			panel_Test.add(getTfEngT7());
			panel_Test.add(getTfEngT8());
			panel_Test.add(getTfEngT9());
			panel_Test.add(getTfEngT10());
			panel_Test.add(getTfKorT1());
			panel_Test.add(getTfKorT2());
			panel_Test.add(getTfKorT3());
			panel_Test.add(getTfKorT4());
			panel_Test.add(getTfKorT5());
			panel_Test.add(getTfKorT6());
			panel_Test.add(getTfKorT7());
			panel_Test.add(getTfKorT8());
			panel_Test.add(getTfKorT9());
			panel_Test.add(getTfKorT10());
			panel_Test.add(getLblKormean_1());
			panel_Test.add(getSeparator());
			panel_Test.add(getBtnFinish());
			panel_Test.add(getBtnClose());
			panel_Test.add(getTfOX1());
			panel_Test.add(getLblOX());
			panel_Test.add(getTfOX2());
			panel_Test.add(getTfOX3());
			panel_Test.add(getTfOX4());
			panel_Test.add(getTfOX5());
			panel_Test.add(getTfOX6());
			panel_Test.add(getTfOX7());
			panel_Test.add(getTfOX8());
			panel_Test.add(getTfOX9());
			panel_Test.add(getTfOX10());
			panel_Test.add(getLblCorrect());
			panel_Test.add(getTfAns1());
			panel_Test.add(getTfAns2());
			panel_Test.add(getTfAns3());
			panel_Test.add(getTfAns4());
			panel_Test.add(getTfAns5());
			panel_Test.add(getTfAns6());
			panel_Test.add(getTfAns7());
			panel_Test.add(getTfAns8());
			panel_Test.add(getTfAns9());
			panel_Test.add(getTfAns10());
			panel_Test.add(getBtnStart());
		}
		return panel_Test;
	}
//	<문제풀기 패널>-영어문제 engTArr[i]=tfEngT1;
	private JLabel getLblEngword_1() {
		if (lblEngword_1 == null) {
			lblEngword_1 = new JLabel("영어단어");
			lblEngword_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblEngword_1.setBounds(44, 10, 57, 15);
		}
		return lblEngword_1;
	}
	private JTextField getTfEngT1() {
		if (tfEngT1 == null) {
			tfEngT1 = new JTextField();
			tfEngT1.setEditable(false);
			tfEngT1.setColumns(10);
			tfEngT1.setBounds(4, 33, 116, 21);
			engTArr[0]=tfEngT1;
		}
		return tfEngT1;
	}
	private JTextField getTfEngT2() {
		if (tfEngT2 == null) {
			tfEngT2 = new JTextField();
			tfEngT2.setEditable(false);
			tfEngT2.setColumns(10);
			tfEngT2.setBounds(4, 64, 116, 21);
			engTArr[1]=tfEngT2;
		}
		return tfEngT2;
	}
	private JTextField getTfEngT3() {
		if (tfEngT3 == null) {
			tfEngT3 = new JTextField();
			tfEngT3.setEditable(false);
			tfEngT3.setColumns(10);
			tfEngT3.setBounds(4, 95, 116, 21);
			engTArr[2]=tfEngT3;
		}
		return tfEngT3;
	}
	private JTextField getTfEngT4() {
		if (tfEngT4 == null) {
			tfEngT4 = new JTextField();
			tfEngT4.setEditable(false);
			tfEngT4.setColumns(10);
			tfEngT4.setBounds(4, 126, 116, 21);
			engTArr[3]=tfEngT4;
		}
		return tfEngT4;
	}
	private JTextField getTfEngT5() {
		if (tfEngT5 == null) {
			tfEngT5 = new JTextField();
			tfEngT5.setEditable(false);
			tfEngT5.setColumns(10);
			tfEngT5.setBounds(4, 157, 116, 21);
			engTArr[4]=tfEngT5;
		}
		return tfEngT5;
	}
	private JTextField getTfEngT6() {
		if (tfEngT6 == null) {
			tfEngT6 = new JTextField();
			tfEngT6.setEditable(false);
			tfEngT6.setColumns(10);
			tfEngT6.setBounds(4, 188, 116, 21);
			engTArr[5]=tfEngT6;
		}
		return tfEngT6;
	}
	private JTextField getTfEngT7() {
		if (tfEngT7 == null) {
			tfEngT7 = new JTextField();
			tfEngT7.setEditable(false);
			tfEngT7.setColumns(10);
			tfEngT7.setBounds(4, 219, 116, 21);
			engTArr[6]=tfEngT7;
		}
		return tfEngT7;
	}
	private JTextField getTfEngT8() {
		if (tfEngT8 == null) {
			tfEngT8 = new JTextField();
			tfEngT8.setEditable(false);
			tfEngT8.setColumns(10);
			tfEngT8.setBounds(4, 251, 116, 21);
			engTArr[7]=tfEngT8;
		}
		return tfEngT8;
	}
	private JTextField getTfEngT9() {
		if (tfEngT9 == null) {
			tfEngT9 = new JTextField();
			tfEngT9.setEditable(false);
			tfEngT9.setColumns(10);
			tfEngT9.setBounds(4, 282, 116, 21);
			engTArr[8]=tfEngT9;
		}
		return tfEngT9;
	}
	private JTextField getTfEngT10() {
		if (tfEngT10 == null) {
			tfEngT10 = new JTextField();
			tfEngT10.setEditable(false);
			tfEngT10.setColumns(10);
			tfEngT10.setBounds(4, 313, 116, 21);
			engTArr[9]=tfEngT10;
		}
		return tfEngT10;
	}
//	<문제풀기 패널>-한글 뜻 korTArr[i]=tfKorT1;
	private JLabel getLblKormean_1() {
		if (lblKormean_1 == null) {
			lblKormean_1 = new JLabel("한글 뜻");
			lblKormean_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblKormean_1.setBounds(153, 10, 57, 15);
		}
		return lblKormean_1;
	}
	private JTextField getTfKorT10() {
		if (tfKorT10 == null) {
			tfKorT10 = new JTextField();
			tfKorT10.setColumns(10);
			tfKorT10.setBounds(123, 313, 116, 21);
			korTArr[9]=tfKorT10;
		}
		return tfKorT10;
	}
	private JTextField getTfKorT9() {
		if (tfKorT9 == null) {
			tfKorT9 = new JTextField();
			tfKorT9.setColumns(10);
			tfKorT9.setBounds(123, 282, 116, 21);
			korTArr[8]=tfKorT9;
		}
		return tfKorT9;
	}
	private JTextField getTfKorT8() {
		if (tfKorT8 == null) {
			tfKorT8 = new JTextField();
			tfKorT8.setColumns(10);
			tfKorT8.setBounds(123, 251, 116, 21);
			korTArr[7]=tfKorT8;
		}
		return tfKorT8;
	}
	private JTextField getTfKorT7() {
		if (tfKorT7 == null) {
			tfKorT7 = new JTextField();
			tfKorT7.setColumns(10);
			tfKorT7.setBounds(123, 219, 116, 21);
			korTArr[6]=tfKorT7;
		}
		return tfKorT7;
	}
	private JTextField getTfKorT6() {
		if (tfKorT6 == null) {
			tfKorT6 = new JTextField();
			tfKorT6.setColumns(10);
			tfKorT6.setBounds(123, 188, 116, 21);
			korTArr[5]=tfKorT6;
		}
		return tfKorT6;
	}
	private JTextField getTfKorT5() {
		if (tfKorT5 == null) {
			tfKorT5 = new JTextField();
			tfKorT5.setColumns(10);
			tfKorT5.setBounds(123, 157, 116, 21);
			korTArr[4]=tfKorT5;
		}
		return tfKorT5;
	}
	private JTextField getTfKorT4() {
		if (tfKorT4 == null) {
			tfKorT4 = new JTextField();
			tfKorT4.setColumns(10);
			tfKorT4.setBounds(123, 126, 116, 21);
			korTArr[3]=tfKorT4;
		}
		return tfKorT4;
	}
	private JTextField getTfKorT3() {
		if (tfKorT3 == null) {
			tfKorT3 = new JTextField();
			tfKorT3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			tfKorT3.setColumns(10);
			tfKorT3.setBounds(123, 95, 116, 21);
			korTArr[2]=tfKorT3;
		}
		return tfKorT3;
	}
	private JTextField getTfKorT2() {
		if (tfKorT2 == null) {
			tfKorT2 = new JTextField();
			tfKorT2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			tfKorT2.setColumns(10);
			tfKorT2.setBounds(123, 64, 116, 21);
			korTArr[1]=tfKorT2;
		}
		return tfKorT2;
	}
	private JTextField getTfKorT1() {
		if (tfKorT1 == null) {
			tfKorT1 = new JTextField();
			tfKorT1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			tfKorT1.setColumns(10);
			tfKorT1.setBounds(123, 33, 116, 21);
			korTArr[0]=tfKorT1;
		}
		return tfKorT1;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 348, 424, 2);
		}
		return separator;
	}
//	<문제풀기 패널>-OX 텍스트필드들 oxArr[i]=tfOX1;
	private JLabel getLblOX() {
		if (lblOX == null) {
			lblOX = new JLabel("O/X");
			lblOX.setHorizontalAlignment(SwingConstants.CENTER);
			lblOX.setBounds(239, 10, 57, 15);
		}
		return lblOX;
	}	
	private JTextField getTfOX1() {
		if (tfOX1 == null) {
			tfOX1 = new JTextField();
			tfOX1.setEditable(false);
			tfOX1.setBounds(247, 33, 41, 21);
			tfOX1.setColumns(10);
			oxArr[0]=tfOX1;
		}
		return tfOX1;
	}
	private JTextField getTfOX2() {
		if (tfOX2 == null) {
			tfOX2 = new JTextField();
			tfOX2.setEditable(false);
			tfOX2.setColumns(10);
			tfOX2.setBounds(247, 64, 41, 21);
			oxArr[1]=tfOX2;
		}
		return tfOX2;
	}
	private JTextField getTfOX3() {
		if (tfOX3 == null) {
			tfOX3 = new JTextField();
			tfOX3.setEditable(false);
			tfOX3.setColumns(10);
			tfOX3.setBounds(247, 95, 41, 21);
			oxArr[2]=tfOX3;
		}
		return tfOX3;
	}
	private JTextField getTfOX4() {
		if (tfOX4 == null) {
			tfOX4 = new JTextField();
			tfOX4.setEditable(false);
			tfOX4.setColumns(10);
			tfOX4.setBounds(247, 126, 41, 21);
			oxArr[3]=tfOX4;
		}
		return tfOX4;
	}
	private JTextField getTfOX5() {
		if (tfOX5 == null) {
			tfOX5 = new JTextField();
			tfOX5.setEditable(false);
			tfOX5.setColumns(10);
			tfOX5.setBounds(247, 157, 41, 21);
			oxArr[4]=tfOX5;
		}
		return tfOX5;
	}
	private JTextField getTfOX6() {
		if (tfOX6 == null) {
			tfOX6 = new JTextField();
			tfOX6.setEditable(false);
			tfOX6.setColumns(10);
			tfOX6.setBounds(247, 188, 41, 21);
			oxArr[5]=tfOX6;
		}
		return tfOX6;
	}
	private JTextField getTfOX7() {
		if (tfOX7 == null) {
			tfOX7 = new JTextField();
			tfOX7.setEditable(false);
			tfOX7.setColumns(10);
			tfOX7.setBounds(247, 219, 41, 21);
			oxArr[6]=tfOX7;
		}
		return tfOX7;
	}
	private JTextField getTfOX8() {
		if (tfOX8 == null) {
			tfOX8 = new JTextField();
			tfOX8.setEditable(false);
			tfOX8.setColumns(10);
			tfOX8.setBounds(247, 251, 41, 21);
			oxArr[7]=tfOX8;
		}
		return tfOX8;
	}
	private JTextField getTfOX9() {
		if (tfOX9 == null) {
			tfOX9 = new JTextField();
			tfOX9.setEditable(false);
			tfOX9.setColumns(10);
			tfOX9.setBounds(247, 282, 41, 21);
			oxArr[8]=tfOX9;
		}
		return tfOX9;
	}
	private JTextField getTfOX10() {
		if (tfOX10 == null) {
			tfOX10 = new JTextField();
			tfOX10.setEditable(false);
			tfOX10.setColumns(10);
			tfOX10.setBounds(247, 313, 41, 21);
			oxArr[9]=tfOX10;
		}
		return tfOX10;
	}
//	<문제풀기 패널>-정답 텍스트필드들 ansArr[i]=tfAns1;
	private JLabel getLblCorrect() {
		if (lblCorrect == null) {
			lblCorrect = new JLabel("정답");
			lblCorrect.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorrect.setBounds(318, 10, 57, 15);
		}
		return lblCorrect;
	}
	private JTextField getTfAns1() {
		if (tfAns1 == null) {
			tfAns1 = new JTextField();
			tfAns1.setEditable(false);
			tfAns1.setColumns(10);
			tfAns1.setBounds(292, 33, 118, 21);
			ansArr[0]=tfAns1;
		}
		return tfAns1;
	}
	private JTextField getTfAns2() {
		if (tfAns2 == null) {
			tfAns2 = new JTextField();
			tfAns2.setEditable(false);
			tfAns2.setColumns(10);
			tfAns2.setBounds(292, 64, 118, 21);
			ansArr[1]=tfAns2;
		}
		return tfAns2;
	}
	private JTextField getTfAns3() {
		if (tfAns3 == null) {
			tfAns3 = new JTextField();
			tfAns3.setEditable(false);
			tfAns3.setColumns(10);
			tfAns3.setBounds(292, 95, 118, 21);
			ansArr[2]=tfAns3;
		}
		return tfAns3;
	}
	private JTextField getTfAns4() {
		if (tfAns4 == null) {
			tfAns4 = new JTextField();
			tfAns4.setEditable(false);
			tfAns4.setColumns(10);
			tfAns4.setBounds(292, 126, 118, 21);
			ansArr[3]=tfAns4;
		}
		return tfAns4;
	}
	private JTextField getTfAns5() {
		if (tfAns5 == null) {
			tfAns5 = new JTextField();
			tfAns5.setEditable(false);
			tfAns5.setColumns(10);
			tfAns5.setBounds(292, 157, 118, 21);
			ansArr[4]=tfAns5;
		}
		return tfAns5;
	}
	private JTextField getTfAns6() {
		if (tfAns6 == null) {
			tfAns6 = new JTextField();
			tfAns6.setEditable(false);
			tfAns6.setColumns(10);
			tfAns6.setBounds(292, 188, 118, 21);
			ansArr[5]=tfAns6;
		}
		return tfAns6;
	}
	private JTextField getTfAns7() {
		if (tfAns7 == null) {
			tfAns7 = new JTextField();
			tfAns7.setEditable(false);
			tfAns7.setColumns(10);
			tfAns7.setBounds(292, 219, 118, 21);
			ansArr[6]=tfAns7;
		}
		return tfAns7;
	}
	private JTextField getTfAns8() {
		if (tfAns8 == null) {
			tfAns8 = new JTextField();
			tfAns8.setEditable(false);
			tfAns8.setColumns(10);
			tfAns8.setBounds(292, 251, 118, 21);
			ansArr[7]=tfAns8;
		}
		return tfAns8;
	}
	private JTextField getTfAns9() {
		if (tfAns9 == null) {
			tfAns9 = new JTextField();
			tfAns9.setEditable(false);
			tfAns9.setColumns(10);
			tfAns9.setBounds(292, 282, 118, 21);
			ansArr[8]=tfAns9;
		}
		return tfAns9;
	}
	private JTextField getTfAns10() {
		if (tfAns10 == null) {
			tfAns10 = new JTextField();
			tfAns10.setEditable(false);
			tfAns10.setColumns(10);
			tfAns10.setBounds(292, 313, 118, 21);
			ansArr[9]=tfAns10;
		}
		return tfAns10;
	}
//	<단어추가 패널>-영어단어 텍스트필드 engArr[i]=tfEng1;
	private JLabel getLblEngword() {
		if (lblEngword == null) {
			lblEngword = new JLabel("영어단어");
			lblEngword.setHorizontalAlignment(SwingConstants.CENTER);
			lblEngword.setBounds(91, 10, 57, 15);
		}
		return lblEngword;
	}
	private JTextField getTfEng1() {
		if (tfEng1 == null) {
			tfEng1 = new JTextField();
			tfEng1.setBounds(61, 33, 116, 21);
			tfEng1.setColumns(10);
			engArr[0]=tfEng1;
		}
		return tfEng1;
	}
	private JTextField getTfEng2() {
		if (tfEng2 == null) {
			tfEng2 = new JTextField();
			tfEng2.setColumns(10);
			tfEng2.setBounds(61, 64, 116, 21);
			engArr[1]=tfEng2;
		}
		return tfEng2;
	}
	private JTextField getTfEng3() {
		if (tfEng3 == null) {
			tfEng3 = new JTextField();
			tfEng3.setColumns(10);
			tfEng3.setBounds(61, 95, 116, 21);
			engArr[2]=tfEng3;
		}
		return tfEng3;
	}
	private JTextField getTfEng4() {
		if (tfEng4 == null) {
			tfEng4 = new JTextField();
			tfEng4.setColumns(10);
			tfEng4.setBounds(61, 126, 116, 21);
			engArr[3]=tfEng4;
		}
		return tfEng4;
	}
	private JTextField getTfEng5() {
		if (tfEng5 == null) {
			tfEng5 = new JTextField();
			tfEng5.setColumns(10);
			tfEng5.setBounds(61, 157, 116, 21);
			engArr[4]=tfEng5;
		}
		return tfEng5;
	}
	private JTextField getTfEng6() {
		if (tfEng6 == null) {
			tfEng6 = new JTextField();
			tfEng6.setColumns(10);
			tfEng6.setBounds(61, 188, 116, 21);
			engArr[5]=tfEng6;
		}
		return tfEng6;
	}
	private JTextField getTfEng7() {
		if (tfEng7 == null) {
			tfEng7 = new JTextField();
			tfEng7.setColumns(10);
			tfEng7.setBounds(61, 219, 116, 21);
			engArr[6]=tfEng7;
		}
		return tfEng7;
	}
	private JTextField getTfEng8() {
		if (tfEng8 == null) {
			tfEng8 = new JTextField();
			tfEng8.setColumns(10);
			tfEng8.setBounds(61, 255, 116, 21);
			engArr[7]=tfEng8;
		}
		return tfEng8;
	}
	private JTextField getTfEng9() {
		if (tfEng9 == null) {
			tfEng9 = new JTextField();
			tfEng9.setColumns(10);
			tfEng9.setBounds(61, 286, 116, 21);
			engArr[8]=tfEng9;
		}
		return tfEng9;
	}
	private JTextField getTextField_1_1() {
		if (tfEng10 == null) {
			tfEng10 = new JTextField();
			tfEng10.setColumns(10);
			tfEng10.setBounds(61, 317, 116, 21);
			engArr[9]=tfEng10;
		}
		return tfEng10;
	}
//	<단어추가 패널>-한글뜻 텍스트필드 korArr[i]=tfKor1;
	private JLabel getLblKormean() {
		if (lblKormean == null) {
			lblKormean = new JLabel("한글 뜻");
			lblKormean.setHorizontalAlignment(SwingConstants.CENTER);
			lblKormean.setBounds(273, 10, 57, 15);
		}
		return lblKormean;
	}	
	private JTextField getTfKor1() {
		if (tfKor1 == null) {
			tfKor1 = new JTextField();
			tfKor1.setColumns(10);
			tfKor1.setBounds(238, 33, 116, 21);
			korArr[0]=tfKor1;
		}
		return tfKor1;
	}
	private JTextField getTfKor2() {
		if (tfKor2 == null) {
			tfKor2 = new JTextField();
			tfKor2.setColumns(10);
			tfKor2.setBounds(237, 64, 116, 21);
			korArr[1]=tfKor2;
		}
		return tfKor2;
	}
	private JTextField getTfKor3() {
		if (tfKor3 == null) {
			tfKor3 = new JTextField();
			tfKor3.setColumns(10);
			tfKor3.setBounds(237, 95, 116, 21);
			korArr[2]=tfKor3;
		}
		return tfKor3;
	}
	private JTextField getTfKor4() {
		if (tfKor4 == null) {
			tfKor4 = new JTextField();
			tfKor4.setColumns(10);
			tfKor4.setBounds(237, 126, 116, 21);
			korArr[3]=tfKor4;
		}
		return tfKor4;
	}
	private JTextField getTfKor5() {
		if (tfKor5 == null) {
			tfKor5 = new JTextField();
			tfKor5.setColumns(10);
			tfKor5.setBounds(237, 157, 116, 21);
			korArr[4]=tfKor5;
		}
		return tfKor5;
	}
	private JTextField getTfKor6() {
		if (tfKor6 == null) {
			tfKor6 = new JTextField();
			tfKor6.setColumns(10);
			tfKor6.setBounds(237, 188, 116, 21);
			korArr[5]=tfKor6;
		}
		return tfKor6;
	}
	private JTextField getTfKor7() {
		if (tfKor7 == null) {
			tfKor7 = new JTextField();
			tfKor7.setColumns(10);
			tfKor7.setBounds(237, 219, 116, 21);
			korArr[6]=tfKor7;
		}
		return tfKor7;
	}
	private JTextField getTfKor8() {
		if (tfKor8 == null) {
			tfKor8 = new JTextField();
			tfKor8.setColumns(10);
			tfKor8.setBounds(237, 255, 116, 21);
			korArr[7]=tfKor8;
		}
		return tfKor8;
	}
	private JTextField getTfKor9() {
		if (tfKor9 == null) {
			tfKor9 = new JTextField();
			tfKor9.setColumns(10);
			tfKor9.setBounds(237, 286, 116, 21);
			korArr[8]=tfKor9;
		}
		return tfKor9;
	}
	private JTextField getTextField_2_1() {
		if (tfKor10 == null) {
			tfKor10 = new JTextField();
			tfKor10.setColumns(10);
			tfKor10.setBounds(237, 317, 116, 21);
			korArr[9]=tfKor10;
		}
		return tfKor10;
	}
	
//	<로그인 패널>-아이디 텍스트필드 tfID 
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setBounds(103, 15, 112, 20);
			tfID.setColumns(10);
		}
		return tfID;
	}
//	<로그인 패널>-패스워드필드 tfPW 
	private JPasswordField getTfPW() {
		if (tfPW == null) {
			tfPW = new JPasswordField();
			tfPW.setBounds(103, 47, 112, 22);
		}
		return tfPW;
	}
//	<로그인 패널>-로그인버튼 btnLogin-아이디 패스워드 일치여부 확인(경고창)+어떻게 로그인을 할것인가? 어떻게 유저별로 성적을 저장하게 할 것인가?
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String id=tfID.getText().trim();//아이디 저장
					//패스워드 저장
					char[]secret_pw=tfPW.getPassword(); 
					String pw="";
					for(char cha:secret_pw) {
						Character.toString(cha);
						pw+=cha; 
					}
					int result=3;
					result=mdao.loginCheck(id,pw);
					if(result==0) { //일반 회원 로그인
						JOptionPane.showMessageDialog(null, "로그인성공");
						btnLogin.setVisible(false); //로그인버튼 비활성화
						btnSignup.setVisible(true); //가입버튼 활성화
						btnLogout.setVisible(true); //로그아웃버튼 활성화
						btnManager.setVisible(false); //관리버튼 비활성화
						tfID.setEnabled(false);
						tfPW.setEnabled(false);
						tabbedPane.setEnabledAt(1, true);
					}else {
						JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호 오류");
					}
					//관리자 로그인
					if(id.equals("admin")&&pw.equals("admin")) {
						JOptionPane.showMessageDialog(null, "관리자로 로그인 되었습니다.");
						btnLogin.setVisible(false); //로그인버튼 비활성화
						btnSignup.setVisible(false); //가입버튼 비활성화
						btnLogout.setVisible(true); //로그아웃버튼 활성화
						btnManager.setVisible(true); //관리버튼 활성화
						tabbedPane.setEnabledAt(2, true); //단어추가 탭 활성화
					}
				}
			});
			btnLogin.setBounds(230, 14, 82, 54);
		}
		return btnLogin;
	}
//	<로그인 패널>-가입버튼 btnSignup
	private JButton getBtnSignup() {
		if (btnSignup == null) {
			btnSignup = new JButton("가입");
			btnSignup.setActionCommand("가입");
			btnSignup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignupView frame = new SignupView(); //객체 생성. 버튼과 연결하면 창이 뜸.
					frame.setVisible(true);
//					dispose(); //다른 창을 띄었을때 뒤에 있는 창을 닫음
				}
			});
			btnSignup.setBounds(328, 14, 82, 54);
		}
		return btnSignup;
	}
//	<로그인 패널>-로그아웃버튼 btnLogout
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnLogin.setVisible(true);
					btnLogout.setVisible(false);
					btnSignup.setVisible(true);
					btnManager.setVisible(false);
					tfID.setEnabled(true);
					tfPW.setEnabled(true);
					tfID.setText("");
					tfPW.setText("");
					tabbedPane.setSelectedIndex(0); //단어목록 탭으로 이동
					tabbedPane.setEnabledAt(1, false); //문제풀기 탭 비활성화
					tabbedPane.setEnabledAt(2, false); //단어추가 탭 비활성화
				}
			});
			btnLogout.setBounds(230, 14, 82, 54);
			btnLogout.setVisible(false);
		}
		return btnLogout;
	}
//	<로그인 패널>-관리버튼 btnManager
	private JButton getBtnManager() {
		if (btnManager == null) {
			btnManager = new JButton("관리");
			btnManager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminView frame = new AdminView(); //AdminView 프레임 창이 뜬다.
					frame.setVisible(true);
				}
			});
			btnManager.setBounds(328, 14, 82, 54);
			btnManager.setVisible(false);
		}
		return btnManager;
	}
	
//	<단어검색 패널>
	private JPanel getPanel_Search() {
		if (panel_Search == null) {
			panel_Search = new JPanel();
			panel_Search.setPreferredSize(new Dimension(10, 40));
			panel_Search.setLayout(null);
			panel_Search.add(getJcb());
			panel_Search.add(getTfSearch());
			panel_Search.add(getBtnSearch());
			panel_Search.add(getBtnBack());
		}
		return panel_Search;
	}
//	<단어검색 패널>-검색 콤보박스 jcb
	private JComboBox getJcb() {
		if (jcb == null) {
			jcb = new JComboBox();
			jcb.setModel(new DefaultComboBoxModel(new String[] {"선택..", "영어", "한글"}));
			jcb.setBounds(12, 10, 63, 21);
		}
		return jcb;
	}
//	<단어검색 패널>-검색창 텍스트필드에 검색어 입력후 엔터키+검색결과 테이블 조회
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfSearch.addActionListener(this);
					int idx=jcb.getSelectedIndex();
					String key="";
					if(idx==1) {
						key="eng";
					}else if(idx==2) {
						key="kor";
					}else {
						JOptionPane.showMessageDialog(null, "카테고리를 선택하세요!");
					}
					WordDAOImpl dao=new WordDAOImpl();
					arr=dao.wordSearch(key, tfSearch.getText()); //검색하는 메소드를 활용
					String []cols= {"번호","영어","한글"};
					DefaultTableModel dt=new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i=0;i<arr.size();i++) {
						dt.setValueAt(arr.get(i).getNum(), i, 0);
						dt.setValueAt(arr.get(i).getEng(), i, 1);
						dt.setValueAt(arr.get(i).getKor(), i, 2);
					}
					table.getColumn("번호").setPreferredWidth(10);
					table.getColumn("영어").setPreferredWidth(150);
					table.getColumn("한글").setPreferredWidth(150);
				}
			});
			tfSearch.setBounds(83, 10, 142, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
//	<단어검색 패널>-검색버튼 btnSearch
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int idx=jcb.getSelectedIndex();
					String key="";
					if(idx==1) {
						key="eng";
					}else if(idx==2) {
						key="kor";
					}else {
						JOptionPane.showMessageDialog(null, "카테고리를 선택하세요!");
					}
					WordDAOImpl dao=new WordDAOImpl();
					arr=dao.wordSearch(key, tfSearch.getText());
					String []cols= {"번호","영어","한글"};
					DefaultTableModel dt=new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i=0;i<arr.size();i++) {
						dt.setValueAt(arr.get(i).getNum(), i, 0);
						dt.setValueAt(arr.get(i).getEng(), i, 1);
						dt.setValueAt(arr.get(i).getKor(), i, 2);
					}
					table.getColumn("번호").setPreferredWidth(10);
					table.getColumn("영어").setPreferredWidth(150);
					table.getColumn("한글").setPreferredWidth(150);
				}
			});
			btnSearch.setBounds(237, 9, 71, 23);
		}
		return btnSearch;
	}
//	<단어검색 패널>-전체보기 버튼+전체 테이블 조회
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("전체보기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfSearch.setText("");
					tabbedPane.setSelectedIndex(0);
					arr=dao.wordView();
					String []cols= {"번호","영어","한글"};
					DefaultTableModel dt=new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i=0;i<arr.size();i++) {
						dt.setValueAt(arr.get(i).getNum(), i, 0);
						dt.setValueAt(arr.get(i).getEng(), i, 1);
						dt.setValueAt(arr.get(i).getKor(), i, 2);
					}
					table.getColumn("번호").setPreferredWidth(10);
					table.getColumn("영어").setPreferredWidth(150);
					table.getColumn("한글").setPreferredWidth(150);
				}
			});
			btnBack.setBounds(317, 9, 88, 23);
		}
		return btnBack;
	}
//	<단어목록 패널>-단어 테이블 table
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			WordDAOImpl dao=new WordDAOImpl();
			arr=dao.wordView(); //wordView()로 전체보기 sql문을 활용
			String []cols= {"번호","영어","한글"};
			DefaultTableModel dt=new DefaultTableModel(cols,arr.size());
			table.setModel(dt);
			for(int i=0;i<arr.size();i++) {
				dt.setValueAt(arr.get(i).getNum(), i, 0);
				dt.setValueAt(arr.get(i).getEng(), i, 1);
				dt.setValueAt(arr.get(i).getKor(), i, 2);
			}
			table.getColumn("번호").setPreferredWidth(10);
			table.getColumn("영어").setPreferredWidth(150);
			table.getColumn("한글").setPreferredWidth(150);
		}
		return table;
	}

//	<문제풀기 패널>-Start버튼-arr.get(i)에서 i에 난수 발생시키기
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//문제는 단어 중에서 랜덤으로 고른다. 중복X. 
					//난수(arr의 순서)를 저장할 해쉬맵 선언 
					HashMap<Integer,Integer>hm=new HashMap<Integer, Integer>();
					for(int i=0;i<10;i++) {
						oxArr[i].setVisible(false); //ox칸 안보이게
						ansArr[i].setVisible(false); //정답칸 안보이게
						korTArr[i].setText(""); //답지 칸 비우기
						btnStart.setEnabled(false); //Start버튼 비활성화
						tabbedPane.setEnabledAt(0, false); //단어목록 탭 비활성화
						tabbedPane.setEnabledAt(2, false); //단어추가 탭 비활성화
						while(true) {
							int j=(int)(Math.random()*arr.size()); //arr인덱스를 난수로 고른다
							if(!hm.containsValue(j)) { //해쉬맵의 밸류 값에 없다면
								hm.put(i,j); //0부터 9까지 키 값으로 저장, 난수를 밸류 값으로 저장
								engTArr[i].setText(arr.get(j).getEng());
								ansArr[i].setText(arr.get(j).getKor());
								break;
							}
						}
					}
				}
			});
			btnStart.setBounds(31, 364, 97, 23);
		}
		return btnStart;
	}
//	<문제풀기 패널>-점수확인버튼-"O"의 개수를 Member DB에 저장  
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("제출하기");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnStart.setEnabled(false); //Start버튼 비활성화 (시험이 시작되면 문제 재발생 방지)
					tabbedPane.setEnabledAt(0, true); //단어목록 탭 비활성화
					int result=JOptionPane.showConfirmDialog //점수확인 시 경고창 띄우기
							(null, "제출하면 답을 수정할 수 없습니다. 제출하시겠습니까?","Confirm",
									+ JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.CLOSED_OPTION) { //닫으면 되돌아감
						btnStart.setEnabled(false); //Start버튼 비활성화
						for(int i=0;i<10;i++) {
							oxArr[i].setVisible(false); //OX칸 비활성화
							ansArr[i].setVisible(false); //정답칸 비활성화
						}
					} 
					else if(result==JOptionPane.YES_OPTION) { //제출하면 점수가 뜨도록 하기
						btnStart.setEnabled(false); //Start버튼 비활성화
						int score=0; //성적변수
						for(int i=0;i<10;i++) {
							korTArr[i].setEnabled(false); //한글 뜻 텍스트 필드 비활성화 (정답수정 방지)
							oxArr[i].setVisible(true); //OX칸 활성화
							ansArr[i].setVisible(true); //정답칸 활성화
							if(korTArr[i].getText().equals(ansArr[i].getText())) {
								oxArr[i].setText("O");
								ansArr[i].setText("");
								score++; //성적
							}else {
								oxArr[i].setText("X");
							}
						}
						Member m=new Member();
						m.setId(tfID.getText());
						m.setScore(score*5);
						mdao.scoreUpdate(m);
						JOptionPane.showMessageDialog(null, score+"개 맞았습니다.("+score*5+"점)");
					}else {}
				}
			});
			btnFinish.setBounds(159, 364, 97, 23);
		}
		return btnFinish;
	}
//	<문제풀기 패널>-닫기버튼
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result=JOptionPane.showConfirmDialog
							(null, "문제와 답이 사라집니다. 닫으시겠습니까?","Confirm",
									+ JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.CLOSED_OPTION) {
					}
					else if(result==JOptionPane.YES_OPTION) {
						btnStart.setEnabled(true);
						for(int i=0;i<10;i++) {
							engTArr[i].setText("");
							korTArr[i].setText("");
							oxArr[i].setText("");
							ansArr[i].setText("");
							korTArr[i].setEnabled(true);
						}
					}else {
					}
				}
			});
			btnClose.setBounds(287, 364, 97, 23);
		}
		return btnClose;
	}

//	<단어추가 패널>-단어추가버튼 btnInsert-DB에 단어추가+단어목록 탭으로 이동
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("단어 추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0;i<10;i++) {
						boolean e=engArr[i].getText().isEmpty();
						boolean k=korArr[i].getText().isEmpty();
						if(e==true) break; //공백은 입력되지 않음
						if(k==true) break; //공백은 입력되지 않음
						//단어추가시 기존의 단어는 넣을 수 없음-dao에서 단어 대조하는 메소드를 만들기
						if(dao.searchEngword(engArr[i].getText())==0){
							JOptionPane.showMessageDialog(null, engArr[i].getText()+" 단어가 이미 있습니다.");
							break;
						}
//						//단어추가시 똑같은 단어는 넣을 수 없음
//						else if(engArr[i].getText().equals(engArr[i+1].getText())) {
//							JOptionPane.showMessageDialog(null, "중복된 단어는 넣을 수 없습니다.");
//							break;
//						}
						else {
							Word w=new Word();
							w.setEng(engArr[i].getText());
							w.setKor(korArr[i].getText());
							dao.wordInsert(w);
							tabbedPane.setSelectedIndex(0);
							AdminView frame = new AdminView(); //객체 생성. 버튼과 연결하면 창이 뜸.
						}
					}
					arr=dao.wordView();
					String []cols= {"번호","영어","한글"};
					DefaultTableModel dt=new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int j=0;j<arr.size();j++) {
						dt.setValueAt(arr.get(j).getNum(), j, 0);
						dt.setValueAt(arr.get(j).getEng(), j, 1);
						dt.setValueAt(arr.get(j).getKor(), j, 2);
					}
					table.getColumn("번호").setPreferredWidth(10);
					table.getColumn("영어").setPreferredWidth(150);
					table.getColumn("한글").setPreferredWidth(150);
				}
			});
			btnInsert.setBounds(156, 350, 97, 23);
		}
		return btnInsert;
	}
}