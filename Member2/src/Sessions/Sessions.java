package Sessions;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

public class Sessions extends JFrame {

	//Connection connection=null;
	Connection conn = SqlServerConnection.dbConnecter();
	private JPanel contentPane;
	private JPanel AddSessionPanel;
	private JPanel manageSessionPanel;
	private Button btnAddSession;
	private Button btnManageSession;
	private JLayeredPane SessionlayeredPane;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtStudentCountSession;
	private JTextField txtSessionId;
	private JLabel lblNewLabel_9;
	private JComboBox txtLecturerNameSession;
	private JComboBox txtSubjectCodeSession;
	private JComboBox txtSubjectNameSession;
	private JComboBox txtTagSession;
	private JComboBox txtGroupIDSession;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_14;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_17;
	private JTextField txtLecturerSessionIndex;
	private JTextField txtStudentCountSession2;
	private JTextField txtSessionId2;
	private JLabel lblNewLabel_18;
	private JTable table;
	private JComboBox txtLecturerNameSession2;
	private JComboBox txtSubjectCodeSession2;
	private JComboBox txtSubjectNameSession2;
	private JComboBox txtTagSession2;
	private JComboBox txtGroupIDSession2;
	private JComboBox txtSessionDuration2;
	private JComboBox txtSessionDuration;
	private JButton btnNewButton_4;
	private JButton btnNewButton_3;
	private JComboBox SessioncomboBox;
	private JPanel panel_5;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sessions frame = new Sessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void SwitchPannels(JPanel panel)
	{
		SessionlayeredPane.removeAll();
		SessionlayeredPane.add(panel);
		SessionlayeredPane.repaint();
		SessionlayeredPane.revalidate();
	}
	
	public void refreshSessionTable()
	{
		try {
			
			String query="select * from session";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	public void fillSessionCobmoBox() {
		

		try {
			
			String query="select * from session";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				SessioncomboBox.addItem(rs.getString("SessionId"));
			}
			
		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Sessions() {
		//connection = SqlServerConnection.dbConnecter();
		Connection conn = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(75, 119, 190));
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel.setBounds(10, 10, 1321, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setForeground(Color.WHITE);
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_34.setBounds(0, 0, 1338, 75);
		panel.add(lblNewLabel_34);
		
		lblNewLabel_1 = new JLabel("Timetable Management System");
		lblNewLabel_1.setBounds(576, 30, 466, 35);
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		panel.add(lblNewLabel_1);
	
		
		btnAddSession = new Button("Add Session");
		btnAddSession.setBackground(new Color(65, 105, 225));
		btnAddSession.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(AddSessionPanel);
			}
		});
		btnAddSession.setBounds(37, 91, 186, 37);
		contentPane.add(btnAddSession);
		
		btnManageSession = new Button("Manage Sessions");
		btnManageSession.setBackground(new Color(65, 105, 225));
		btnManageSession.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(manageSessionPanel);
			}
		});
		btnManageSession.setBounds(230, 91, 223, 37);
		contentPane.add(btnManageSession);
		
		SessionlayeredPane = new JLayeredPane();
		SessionlayeredPane.setBounds(35, 134, 1267, 547);
		contentPane.add(SessionlayeredPane);
		SessionlayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSessionPanel = new JPanel();
		AddSessionPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		AddSessionPanel.setBackground(Color.WHITE);
		SessionlayeredPane.add(AddSessionPanel, "name_695816785373600");
		AddSessionPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(300, 10, 722, 507);
		AddSessionPanel.add(scrollPane_1);
		
		JPanel panel_4 = new JPanel();
		scrollPane_1.setViewportView(panel_4);
		panel_4.setBackground(new Color(228,241,254));
		panel_4.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_4.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(61, 32, 600, 451);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Lecturer Name   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(45, 31, 173, 13);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Subject Code   :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(45, 70, 122, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Subject Name   :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(45, 109, 122, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tag   :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(45, 142, 122, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Group ID   :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(45, 187, 122, 13);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Student Count   :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(45, 229, 122, 13);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Duration   :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(45, 262, 122, 13);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Session ID   :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(45, 334, 96, 13);
		panel_1.add(lblNewLabel_8);
		
		txtStudentCountSession = new JTextField();
		txtStudentCountSession.setBounds(209, 225, 331, 23);
		panel_1.add(txtStudentCountSession);
		txtStudentCountSession.setColumns(10);
		
		txtSessionId = new JTextField();
		txtSessionId.setBounds(140, 330, 400, 23);
		panel_1.add(txtSessionId);
		txtSessionId.setColumns(10);
		
		txtLecturerNameSession = new JComboBox();
		txtLecturerNameSession.setModel(new DefaultComboBoxModel(new String[] {"Mr.Kamal ", "Mr.Nimal ", "Mr.Namal ", "Mr.Thilak ", "Mr.karuna"}));
		txtLecturerNameSession.setBounds(209, 27, 331, 23);
		panel_1.add(txtLecturerNameSession);
		
		txtSubjectCodeSession = new JComboBox();
		txtSubjectCodeSession.setModel(new DefaultComboBoxModel(new String[] {"IT2090", "IT9089", "IT6798", "IT5080", "IT5090", "IT5040", "IT3020", "IT1080"}));
		txtSubjectCodeSession.setBounds(209, 66, 331, 23);
		panel_1.add(txtSubjectCodeSession);
		
		txtSubjectNameSession = new JComboBox();
		txtSubjectNameSession.setModel(new DefaultComboBoxModel(new String[] {"ITPM", "OOP", "IP", "CS", "DMS", "DS", "PFA", "ESD", "MADD"}));
		txtSubjectNameSession.setBounds(209, 105, 331, 23);
		panel_1.add(txtSubjectNameSession);
		
		txtTagSession = new JComboBox();
		txtTagSession.setModel(new DefaultComboBoxModel(new String[] {"Lecture", "Lab", "Tutorial"}));
		txtTagSession.setBounds(209, 138, 331, 23);
		panel_1.add(txtTagSession);
		
		txtGroupIDSession = new JComboBox();
		txtGroupIDSession.setModel(new DefaultComboBoxModel(new String[] {"Y1.Y2.1", "Y1.Y2.2", "Y1.Y2.3", "Y1.Y2.4", "Y1.Y2.5", "Y1.Y2.6", "Y1.Y2.7", "Y1.Y2.8"}));
		txtGroupIDSession.setBounds(209, 182, 331, 25);
		panel_1.add(txtGroupIDSession);
		
		JButton btnNewButton = new JButton("Generate ID");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
				String lecName2 = (String)txtLecturerNameSession.getSelectedItem();
				String SubCode2 = (String)txtSubjectCodeSession.getSelectedItem();
				String SubName2 = (String)txtSubjectNameSession.getSelectedItem();
				String SubTag2 = (String)txtTagSession.getSelectedItem();
				String GroupID2 = (String)txtGroupIDSession.getSelectedItem();
				String StudentCount2 = txtStudentCountSession.getText();
				String Duration2 = (String)txtSessionDuration.getSelectedItem();
				String SessionId2 = (String)txtLecturerNameSession.getSelectedItem() +"."+ txtSubjectCodeSession.getSelectedItem()+"."+ txtSubjectNameSession.getSelectedItem()+"."+txtTagSession.getSelectedItem()+"."+txtGroupIDSession.getSelectedItem()+"."+txtStudentCountSession.getText()+"."+txtSessionDuration.getSelectedItem();
				txtSessionId.setText(SessionId2);
				
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(192, 291, 203, 29);
		panel_1.add(btnNewButton);
		
		txtSessionDuration = new JComboBox();
		txtSessionDuration.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		txtSessionDuration.setBounds(209, 258, 329, 23);
		panel_1.add(txtSessionDuration);
		
		btnNewButton_3 = new JButton("save");
		btnNewButton_3.setBackground(new Color(60, 179, 113));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Insert data into Session table :
				
				 try {
						
						String query="insert into session (LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId) values (?,?,?,?,?,?,?,?)";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						//get LecturerName details from the user by using  JComboBox :
						String SessionLecturerName=txtLecturerNameSession.getSelectedItem().toString();
						pst.setString(1, SessionLecturerName);
						
						//get semester details from user by using JComboBox:
						String SessionSubjectCode=txtSubjectCodeSession.getSelectedItem().toString();
						pst.setString(2, SessionSubjectCode);
						
						//get Subject Name details from user by using JComboBox:
						String SessionSubjectName=txtSubjectNameSession.getSelectedItem().toString();
						pst.setString(3, SessionSubjectName);
						
						//get Number of Tutorial hours from user by using JComboBox:
						String SessionTag=txtTagSession.getSelectedItem().toString();
						pst.setString(4, SessionTag);
						
						//get group ID details from user by using JComboBox:
						String SessionGroupID=txtGroupIDSession.getSelectedItem().toString();
						pst.setString(5, SessionGroupID);
						
						//get Student Count from the user by using text fields:
						pst.setString(6, txtStudentCountSession.getText());
						
						//get Duration from by using JComboBox:
						String SessionDuration=txtSessionDuration.getSelectedItem().toString();
						pst.setString(7, SessionDuration);
						
						//get Session ID from text fields:
						pst.setString(8, txtSessionId.getText());
						
						
						//Display successful massage when data was inserted to the database successfully:
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data inserted successfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				 
				 refreshSessionTable();
				
			}
		});
		btnNewButton_3.setBounds(103, 400, 167, 29);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("Clear");
		btnNewButton_7.setBackground(new Color(30, 144, 255));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setBounds(328, 400, 167, 29);
		panel_1.add(btnNewButton_7);
		
		lblNewLabel_9 = new JLabel("- Add Sessions -");
		lblNewLabel_9.setBounds(270, 10, 203, 15);
		panel_4.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(30, 144, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		manageSessionPanel = new JPanel();
		manageSessionPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		manageSessionPanel.setBackground(new Color(255, 255, 255));
		SessionlayeredPane.add(manageSessionPanel, "name_695830111868700");
		manageSessionPanel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "Manage Session Details :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_2.setBounds(52, 21, 464, 472);
		manageSessionPanel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Lecturer Name   :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(39, 65, 158, 13);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Subject Code   :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(39, 109, 158, 13);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name   :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(39, 151, 158, 13);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Tag   :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(39, 192, 158, 13);
		panel_2.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Group Id   :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_14.setBounds(39, 237, 158, 13);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Student Count   :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setBounds(39, 278, 158, 13);
		panel_2.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Duration   :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_16.setBounds(39, 318, 158, 13);
		panel_2.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Session ID   :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_17.setBounds(23, 390, 98, 19);
		panel_2.add(lblNewLabel_17);
		
		txtLecturerSessionIndex = new JTextField();
		txtLecturerSessionIndex.setEditable(false);
		txtLecturerSessionIndex.setBounds(172, 26, 256, 19);
		panel_2.add(txtLecturerSessionIndex);
		txtLecturerSessionIndex.setColumns(10);
		
		txtStudentCountSession2 = new JTextField();
		txtStudentCountSession2.setBounds(172, 276, 256, 19);
		panel_2.add(txtStudentCountSession2);
		txtStudentCountSession2.setColumns(10);
		
		txtSessionId2 = new JTextField();
		txtSessionId2.setBounds(112, 387, 342, 28);
		panel_2.add(txtSessionId2);
		txtSessionId2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("GenerateID");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				//Generete Rank using Lecturer ID and level :
				try {
					
				String lecName = (String)txtLecturerNameSession2.getSelectedItem();
				String SubCode = (String)txtSubjectCodeSession2.getSelectedItem();
				String SubName = (String)txtSubjectNameSession2.getSelectedItem();
				String SubTag = (String)txtTagSession2.getSelectedItem();
				String GroupID = (String)txtGroupIDSession2.getSelectedItem();
				String StudentCount = txtStudentCountSession2.getText();
				String Duration = (String)txtSessionDuration2.getSelectedItem();
				String SessionId = (String)txtLecturerNameSession2.getSelectedItem() +"."+ txtSubjectCodeSession2.getSelectedItem()+"."+ txtSubjectNameSession2.getSelectedItem()+"."+txtTagSession2.getSelectedItem()+"."+txtGroupIDSession2.getSelectedItem()+"."+txtStudentCountSession2.getText()+"."+txtSessionDuration2.getSelectedItem();
				txtSessionId2.setText(SessionId);
				
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_1.setBounds(153, 349, 140, 28);
		panel_2.add(btnNewButton_1);
		
		lblNewLabel_18 = new JLabel("Session Index   :");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_18.setBounds(39, 28, 128, 13);
		panel_2.add(lblNewLabel_18);
		
		txtLecturerNameSession2 = new JComboBox();
		txtLecturerNameSession2.setModel(new DefaultComboBoxModel(new String[] {"Mr.Kamal", "Mr.Nimal", "Mr.Kalum", "Mr.Nayana", "Mr.Kasun", "Mr.Amal"}));
		txtLecturerNameSession2.setBounds(172, 62, 256, 21);
		panel_2.add(txtLecturerNameSession2);
		
		txtSubjectCodeSession2 = new JComboBox();
		txtSubjectCodeSession2.setModel(new DefaultComboBoxModel(new String[] {"IT6787", "IT9809", "IT4565", "IT9809", "IT3454", "IT8798"}));
		txtSubjectCodeSession2.setBounds(172, 106, 256, 21);
		panel_2.add(txtSubjectCodeSession2);
		
		txtSubjectNameSession2 = new JComboBox();
		txtSubjectNameSession2.setModel(new DefaultComboBoxModel(new String[] {"IP", "OOP", "DMS", "DS", "IWT", "OSSA", "CN"}));
		txtSubjectNameSession2.setBounds(172, 148, 256, 21);
		panel_2.add(txtSubjectNameSession2);
		
		txtTagSession2 = new JComboBox();
		txtTagSession2.setModel(new DefaultComboBoxModel(new String[] {"Lecturers", "Tutorials", "Labs"}));
		txtTagSession2.setBounds(172, 189, 256, 21);
		panel_2.add(txtTagSession2);
		
		txtGroupIDSession2 = new JComboBox();
		txtGroupIDSession2.setModel(new DefaultComboBoxModel(new String[] {"Y1.S1.1", "Y1.S1.2", "Y1.S1.3", "Y1.S1.4", "Y1.S1.5", "Y1.S1.6"}));
		txtGroupIDSession2.setBounds(172, 234, 256, 21);
		panel_2.add(txtGroupIDSession2);
		
		txtSessionDuration2 = new JComboBox();
		txtSessionDuration2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		txtSessionDuration2.setBounds(172, 315, 256, 21);
		panel_2.add(txtSessionDuration2);
		
		btnNewButton_4 = new JButton("Clear All");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(135, 206, 235));
		btnNewButton_4.setBounds(153, 425, 140, 28);
		panel_2.add(btnNewButton_4);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(228,241,254));
		//panel_6.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_3.setBounds(559, 10, 696, 492);
		manageSessionPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 95, 628, 331);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(107,185,240));
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255,255));
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//To pass the relevant details to the form after selecting the raw of the table:
				  try {
						int row = table.getSelectedRow();
						String SessionIndex_=(table.getModel().getValueAt(row, 0)).toString();
						
					   
						String query="select * from session where SessionIndex='"+SessionIndex_+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
					
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							txtLecturerSessionIndex.setText(rs.getString("SessionIndex"));
							txtLecturerNameSession2.setSelectedItem(rs.getString("LecturerNameSession"));
							txtSubjectCodeSession2.setSelectedItem(rs.getString("SubjectCodeSession"));
							txtSubjectNameSession2.setSelectedItem(rs.getString("SubjectNameSession"));
							txtTagSession2.setSelectedItem(rs.getString("TagSession"));
							txtGroupIDSession2.setSelectedItem(rs.getString("GroupIDSession"));
							txtStudentCountSession2.setText(rs.getString("StudentCountSession"));
							txtSessionDuration2.setSelectedItem(rs.getString("SessionDuration"));
							txtSessionId2.setText(rs.getString("SessionId"));
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 32, 672, 445);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		SessioncomboBox = new JComboBox();
		SessioncomboBox.setBounds(23, 36, 164, 21);
		panel_5.add(SessioncomboBox);
		
		JButton btnNewButton_2 = new JButton("Loard All Details   :");
		btnNewButton_2.setBackground(new Color(30, 144, 255));
		btnNewButton_2.setBounds(485, 32, 164, 28);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(220, 20, 60));
		btnNewButton_6.setBounds(107, 408, 186, 27);
		panel_5.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(46, 139, 87));
		btnNewButton_5.setBounds(379, 408, 191, 27);
		panel_5.add(btnNewButton_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(228,241,254));
		panel_6.setBounds(10, 10, 539, 492);
		manageSessionPanel.add(panel_6);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update details :

				  try {
						
						String query="update session set  LecturerNameSession='"+txtLecturerNameSession2.getSelectedItem()+"' , SubjectCodeSession='"+txtSubjectCodeSession2.getSelectedItem()+"' ,SubjectNameSession='"+txtSubjectNameSession2.getSelectedItem()+"' ,TagSession='"+txtTagSession2.getSelectedItem()+"', GroupIDSession='"+txtGroupIDSession2.getSelectedItem()+"',  StudentCountSession='"+txtStudentCountSession2.getText()+"' , SessionDuration='"+txtSessionDuration2.getSelectedItem()+"' , SessionId='"+txtSessionId2.getText()+"' where SessionIndex='"+txtLecturerSessionIndex.getText()+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Details Updated Sucsessfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
				  refreshSessionTable();
				
				
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Delete
				try {
					
					String query="delete from session where SessionIndex='"+txtLecturerSessionIndex.getText()+"'";                      
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			
				refreshSessionTable();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select * from sessions";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
				
			}
		});
		SessioncomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                try {
					
					String query="select * from session where SessionId=?";                      
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, (String)SessioncomboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtLecturerSessionIndex.setText(rs.getString("SessionIndex"));
						txtLecturerNameSession2.setSelectedItem(rs.getString("LecturerNameSession"));
						txtSubjectCodeSession2.setSelectedItem(rs.getString("SubjectCodeSession"));
						txtSubjectNameSession2.setSelectedItem(rs.getString("SubjectNameSession"));
						txtTagSession2.setSelectedItem(rs.getString("TagSession"));
						txtGroupIDSession2.setSelectedItem(rs.getString("GroupIDSession"));
						txtStudentCountSession2.setText(rs.getString("StudentCountSession"));
						txtSessionDuration2.setSelectedItem(rs.getString("SessionDuration"));
						txtSessionId2.setText(rs.getString("SessionId"));
					}
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		refreshSessionTable();
		fillSessionCobmoBox();
		
		
	}
}
