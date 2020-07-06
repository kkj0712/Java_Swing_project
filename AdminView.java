package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminView extends JFrame {
	ArrayList<Word> arr;
	ArrayList<Member> mArr;
	MemberDAOImpl mdao=new MemberDAOImpl();
	WordDAOImpl dao=new WordDAOImpl();
	private JPanel contentPane;
	private JTextField tfSearch;
	private JTable table;
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfScore;
	private JTextField tfWordNum;
	private JTextField tfEng;
	private JTextField tfKor;
	private JTextField tfWordSearch;
	private JTable wordTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		setTitle("회원관리");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		mArr=mdao.memberView();
		String []cols= {"번호","이름","아이디","패스워드","이메일","점수"};
		DefaultTableModel dt=new DefaultTableModel(cols,mArr.size());
		for(int i=0;i<mArr.size();i++) {
			dt.setValueAt(mArr.get(i).getNum(), i, 0);
			dt.setValueAt(mArr.get(i).getName(), i, 1);
			dt.setValueAt(mArr.get(i).getId(), i, 2);
			dt.setValueAt(mArr.get(i).getPw(), i, 3);
			dt.setValueAt(mArr.get(i).getEmail(), i, 4);
			dt.setValueAt(mArr.get(i).getScore(), i, 5);
		}
		arr=dao.wordView(); //wordView()로 전체보기 sql문을 활용
		String []wordcols= {"번호","영어","한글"};
		DefaultTableModel worddt=new DefaultTableModel(wordcols,arr.size());
		for(int i=0;i<arr.size();i++) {
			worddt.setValueAt(arr.get(i).getNum(), i, 0);
			worddt.setValueAt(arr.get(i).getEng(), i, 1);
			worddt.setValueAt(arr.get(i).getKor(), i, 2);
		}
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panelWord = new JPanel();
		tabbedPane.addTab("단어관리", null, panelWord, null);
		panelWord.setLayout(null);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBounds(0, 0, 705, 456);
		panelWord.add(splitPane_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		splitPane_3.setLeftComponent(panel_5);
		
		JLabel lblWordNum = new JLabel("번호");
		lblWordNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWordNum.setBounds(17, 38, 60, 21);
		panel_5.add(lblWordNum);
		
		JLabel lblEng = new JLabel("영어");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEng.setBounds(17, 133, 60, 21);
		panel_5.add(lblEng);
		
		JLabel lblKor = new JLabel("한글");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKor.setBounds(17, 228, 60, 21);
		panel_5.add(lblKor);
		
		tfWordNum = new JTextField();
		tfWordNum.setHorizontalAlignment(SwingConstants.CENTER);
		tfWordNum.setColumns(10);
		tfWordNum.setBounds(98, 35, 173, 27);
		panel_5.add(tfWordNum);
		
		tfEng = new JTextField();
		tfEng.setHorizontalAlignment(SwingConstants.CENTER);
		tfEng.setColumns(10);
		tfEng.setBounds(98, 130, 173, 27);
		panel_5.add(tfEng);
		
		tfKor = new JTextField();
		tfKor.setHorizontalAlignment(SwingConstants.CENTER);
		tfKor.setColumns(10);
		tfKor.setBounds(98, 225, 173, 27);
		panel_5.add(tfKor);
		
//		전체 단어목록버튼
		JButton btnWordList = new JButton("전체 단어목록");
		btnWordList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfWordNum.setText("");
				tfEng.setText("");
				tfKor.setText("");
				arr=dao.wordView(); //wordView()로 전체보기 sql문을 활용
				String []wordcols= {"번호","영어","한글"};
				DefaultTableModel worddt=new DefaultTableModel(wordcols,arr.size());
				wordTable.setModel(worddt);
				for(int i=0;i<arr.size();i++) {
					worddt.setValueAt(arr.get(i).getNum(), i, 0);
					worddt.setValueAt(arr.get(i).getEng(), i, 1);
					worddt.setValueAt(arr.get(i).getKor(), i, 2);
			}
				wordTable.getColumn("번호").setPreferredWidth(10);
				wordTable.getColumn("영어").setPreferredWidth(150);
				wordTable.getColumn("한글").setPreferredWidth(150);
		  }
		});
//		단어 수정
		JButton btnWordUpdate = new JButton("단어 수정");
		btnWordUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Word w=new Word();
				w.setNum(Integer.parseInt(tfWordNum.getText()));
				w.setEng(tfEng.getText());
				w.setKor(tfKor.getText());
				dao.wordUpdate(w);
				btnWordList.doClick();
				tfWordNum.setText("");
				tfEng.setText("");
				tfKor.setText("");
				tfWordSearch.setText("");
			}
		});
		btnWordUpdate.setBounds(12, 311, 129, 29);
		panel_5.add(btnWordUpdate);
//		단어 삭제
		JButton btnWordDelete = new JButton("단어 삭제");
		btnWordDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog //점수확인 시 경고창 띄우기
						(null, "삭제한 단어는 되돌릴 수 없습니다. 계속하시겠습니까?","Confirm",
								+ JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {} //닫으면 되돌아감
				else if(result==JOptionPane.YES_OPTION) { 
					try {
						int num=Integer.parseInt(tfWordNum.getText());
						if(num==0) {
							JOptionPane.showMessageDialog(null, "단어를 검색하세요");
						}else {
							dao.wordDelete(num);
							btnWordList.doClick();
							tfWordNum.setText("");
							tfEng.setText("");
							tfKor.setText("");
						}
					}catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(null, "단어를 검색하세요");
					}
				}else {}
			}
		});
		btnWordDelete.setBounds(160, 311, 129, 29);
		panel_5.add(btnWordDelete);
		
		JSplitPane splitPane_1_1 = new JSplitPane();
		splitPane_1_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_3.setRightComponent(splitPane_1_1);
		
		JPanel panel_2_1 = new JPanel();
		splitPane_1_1.setLeftComponent(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_2_1 = new JSplitPane();
		splitPane_2_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_2_1.add(splitPane_2_1, BorderLayout.CENTER);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		splitPane_2_1.setLeftComponent(panel_3_1);
		
		btnWordList.setBounds(115, 5, 175, 29);
		panel_3_1.add(btnWordList);
		
		JPanel panel_4_1 = new JPanel();
		splitPane_2_1.setRightComponent(panel_4_1);
		panel_4_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4_1.add(scrollPane_1, BorderLayout.CENTER);
		
		wordTable = new JTable();
		wordTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				int row=wordTable.getSelectedRow();
				int column=wordTable.getSelectedColumn();
				tfWordNum.setText(wordTable.getValueAt(row, 0)+""); //번호
				tfEng.setText(wordTable.getValueAt(row, 1)+""); //영어
				tfKor.setText(wordTable.getValueAt(row, 2)+""); //한글
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		scrollPane_1.setViewportView(wordTable);
		splitPane_2_1.setDividerLocation(40);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		splitPane_1_1.setRightComponent(panel_1_1);
		
		JComboBox jcbWord = new JComboBox();
		jcbWord.setModel(new DefaultComboBoxModel(new String[] {"선택..", "번호", "영어", "한글"}));
		jcbWord.setBounds(17, 18, 99, 27);
		panel_1_1.add(jcbWord);
		
		tfWordSearch = new JTextField();
		tfWordSearch.setColumns(10);
		tfWordSearch.setBounds(123, 18, 158, 27);
		panel_1_1.add(tfWordSearch);
		
//		단어 검색
		JButton btnWordSearch = new JButton("검색");
		btnWordSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						int idx=jcbWord.getSelectedIndex();
						String key="";
						switch(idx) {
						case 1 : key="num"+""; break;
						case 2 : key="eng"; break;
						case 3 : key="kor"; break;
						default : 
							JOptionPane.showMessageDialog(null, "카테고리를 선택하세요!");
						}
						try {
							arr=dao.wordSearch(key, tfWordSearch.getText());
							for(Word w:arr) {
								tfWordNum.setText(w.getNum()+"");
								tfEng.setText(w.getEng());
								tfKor.setText(w.getKor());
							}
						}catch(NullPointerException n) {
							n.printStackTrace();
							JOptionPane.showMessageDialog(null, "해당 단어가 없습니다.");
						}
				  }
		});
		btnWordSearch.setBounds(288, 17, 105, 29);
		panel_1_1.add(btnWordSearch);
		splitPane_1_1.setDividerLocation(290);
		splitPane_3.setDividerLocation(300);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("회원관리", null, splitPane, null);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNum.setBounds(17, 30, 60, 21);
		panel.add(lblNum);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(17, 84, 60, 21);
		panel.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(17, 138, 60, 21);
		panel.add(lblId);
		
		JLabel lblPW = new JLabel("PW");
		lblPW.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPW.setBounds(17, 192, 60, 21);
		panel.add(lblPW);
		
		tfNum = new JTextField();
		tfNum.setHorizontalAlignment(SwingConstants.CENTER);
		tfNum.setBounds(98, 27, 173, 27);
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(10);
		tfName.setBounds(98, 81, 173, 27);
		panel.add(tfName);
		
		tfID = new JTextField();
		tfID.setHorizontalAlignment(SwingConstants.CENTER);
		tfID.setColumns(10);
		tfID.setBounds(98, 135, 173, 27);
		panel.add(tfID);
		
		tfPW = new JTextField();
		tfPW.setHorizontalAlignment(SwingConstants.CENTER);
		tfPW.setColumns(10);
		tfPW.setBounds(98, 189, 173, 27);
		panel.add(tfPW);
		
		JLabel lblScore = new JLabel("성적");
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScore.setBounds(17, 246, 60, 21);
		panel.add(lblScore);
		
		tfScore = new JTextField();
		tfScore.setHorizontalAlignment(SwingConstants.CENTER);
		tfScore.setColumns(10);
		tfScore.setBounds(98, 243, 173, 27);
		panel.add(tfScore);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JComboBox jcb = new JComboBox();
		jcb.setModel(new DefaultComboBoxModel(new String[] {"선택..", "번호", "이름", "ID"}));
		jcb.setBounds(17, 18, 99, 27);
		panel_1.add(jcb);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(123, 18, 158, 27);
		panel_1.add(tfSearch);
		tfSearch.setColumns(10);
//		회원 검색
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx=jcb.getSelectedIndex();
				String key="";
				switch(idx) {
				case 1 : key="num"+""; break;
				case 2 : key="name"; break;
				case 3 : key="id"; break;
				default : 
					JOptionPane.showMessageDialog(null, "카테고리를 선택하세요!");
				}
				try {
					mArr=mdao.memberSearch(key, tfSearch.getText());
					for(Member m:mArr) {
						tfNum.setText(m.getNum()+"");
						tfName.setText(m.getName());
						tfID.setText(m.getId());
						tfPW.setText(m.getPw());
						tfScore.setText(m.getScore()+"");
					}
				}catch (NullPointerException n) {
					n.printStackTrace();
					JOptionPane.showMessageDialog(null, "해당회원이 없습니다.");
				} 
		  }
		});
		btnSearch.setBounds(288, 17, 105, 29);
		panel_1.add(btnSearch);
		
		JPanel panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_2.add(splitPane_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(null);
//		전체 회원목록버튼
		JButton btnList = new JButton("전체 회원목록");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNum.setText("");
				tfName.setText("");
				tfID.setText("");
				tfPW.setText("");
				tfScore.setText("");
				mArr=mdao.memberView();
				String []cols= {"번호","이름","아이디","패스워드","이메일","점수"};
				DefaultTableModel dt=new DefaultTableModel(cols,mArr.size());
				table.setModel(dt);
				for(int i=0;i<mArr.size();i++) {
					dt.setValueAt(mArr.get(i).getNum(), i, 0);
					dt.setValueAt(mArr.get(i).getName(), i, 1);
					dt.setValueAt(mArr.get(i).getId(), i, 2);
					dt.setValueAt(mArr.get(i).getPw(), i, 3);
					dt.setValueAt(mArr.get(i).getEmail(), i, 4);
					dt.setValueAt(mArr.get(i).getScore(), i, 5);
				}
				table.getColumn("번호").setPreferredWidth(40);
				table.getColumn("이름").setPreferredWidth(100);
				table.getColumn("아이디").setPreferredWidth(100);
				table.getColumn("패스워드").setPreferredWidth(100);
				table.getColumn("이메일").setPreferredWidth(100);
				table.getColumn("점수").setPreferredWidth(100);
			}
		});
		btnList.setBounds(118, 5, 168, 29);
		panel_3.add(btnList);
//		회원수정
		JButton btnUpdate = new JButton("회원 수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member m=new Member();
				m.setNum(Integer.parseInt(tfNum.getText()));
				m.setName(tfName.getText());
				m.setId(tfID.getText());
				m.setPw(tfPW.getText());
				m.setScore(Integer.parseInt(tfScore.getText()));
				mdao.memberUpdate(m);
				btnList.doClick();
				tfNum.setText("");
				tfName.setText("");
				tfID.setText("");
				tfPW.setText("");
				tfScore.setText("");
				tfSearch.setText("");
			}
		});
		btnUpdate.setBounds(12, 311, 129, 29);
		panel.add(btnUpdate);
//		회원 삭제버튼
		JButton btnDelete = new JButton("회원 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog //점수확인 시 경고창 띄우기
						(null, "삭제하면 회원 정보를 되돌릴 수 없습니다. 계속하시겠습니까?","Confirm",
								+ JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {} //닫으면 되돌아감
				else if(result==JOptionPane.YES_OPTION) { 
					try {
						int num=Integer.parseInt(tfNum.getText());
						if(num==0) {
							JOptionPane.showMessageDialog(null, "회원정보를 검색하세요");
						}else {
							mdao.memberDelete(num);
							btnList.doClick();
							tfNum.setText("");
							tfName.setText("");
							tfID.setText("");
							tfPW.setText("");
							tfScore.setText("");
						}
					}catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(null, "회원정보를 검색하세요");
					}
					
				}else {}
			}
		});
		btnDelete.setBounds(160, 311, 129, 29);
		panel.add(btnDelete);
		JPanel panel_4 = new JPanel();
		splitPane_2.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				int row=table.getSelectedRow();
				int column=table.getSelectedColumn();
				tfNum.setText(table.getValueAt(row, 0)+""); //번호
				tfName.setText(table.getValueAt(row, 1)+""); //이름
				tfID.setText(table.getValueAt(row, 2)+""); //아이디
				tfPW.setText(table.getValueAt(row, 3)+""); //패스워드
				tfScore.setText(table.getValueAt(row, 5)+""); //성적
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		table.setModel(dt);
		wordTable.setModel(worddt);
		btnWordList.doClick();
		btnList.doClick();
		scrollPane.setViewportView(table);
		splitPane_2.setDividerLocation(40);
		splitPane_1.setDividerLocation(290);
		splitPane.setDividerLocation(300);
	}
}
