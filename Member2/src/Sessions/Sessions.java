package Sessions;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
	private JLabel lblNewLabel_1;
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
		setBounds(0,0,1385,728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1365, 75);
		panel.setForeground(new Color(255, 99, 71));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_34 = new JLabel("Timetable Management System");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_34.setBounds(489, 22, 380, 29);
		panel.add(lblNewLabel_34);
		
		btnAddSession = new Button("Add Session");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(AddSessionPanel);
			}
		});
		btnAddSession.setBounds(43, 113, 132, 21);
		contentPane.add(btnAddSession);
		
		btnManageSession = new Button("Manage Session");
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(manageSessionPanel);
			}
		});
		btnManageSession.setBounds(201, 113, 165, 21);
		contentPane.add(btnManageSession);
		
		SessionlayeredPane = new JLayeredPane();
		SessionlayeredPane.setBounds(10, 173, 1339, 518);
		contentPane.add(SessionlayeredPane);
		SessionlayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSessionPanel = new JPanel();
		SessionlayeredPane.add(AddSessionPanel, "name_695816785373600");
		AddSessionPanel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(233, 21, 857, 472);
		AddSessionPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Lecturer Name   :");
		lblNewLabel.setBounds(95, 96, 122, 13);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Subject Code   :");
		lblNewLabel_2.setBounds(95, 140, 122, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Subject Name   :");
		lblNewLabel_3.setBounds(95, 179, 122, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tag   :");
		lblNewLabel_4.setBounds(95, 219, 122, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Group ID   :");
		lblNewLabel_5.setBounds(95, 258, 122, 13);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Student Count   :");
		lblNewLabel_6.setBounds(95, 299, 122, 13);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Duration   :");
		lblNewLabel_7.setBounds(95, 332, 122, 13);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Session ID   :");
		lblNewLabel_8.setBounds(95, 413, 122, 13);
		panel_1.add(lblNewLabel_8);
		
		txtStudentCountSession = new JTextField();
		txtStudentCountSession.setBounds(244, 296, 231, 19);
		panel_1.add(txtStudentCountSession);
		txtStudentCountSession.setColumns(10);
		
		txtSessionId = new JTextField();
		txtSessionId.setBounds(244, 410, 328, 19);
		panel_1.add(txtSessionId);
		txtSessionId.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Add Sessions :");
		lblNewLabel_9.setBounds(54, 47, 140, 13);
		panel_1.add(lblNewLabel_9);
		
		txtLecturerNameSession = new JComboBox();
		txtLecturerNameSession.setModel(new DefaultComboBoxModel(new String[] {"Mr.Kamal ", "Mr.Nimal ", "Mr.Namal ", "Mr.Thilak ", "Mr.karuna"}));
		txtLecturerNameSession.setBounds(244, 92, 231, 21);
		panel_1.add(txtLecturerNameSession);
		
		txtSubjectCodeSession = new JComboBox();
		txtSubjectCodeSession.setModel(new DefaultComboBoxModel(new String[] {"IT2090", "IT9089", "IT6798", "IT5080", "IT5090", "IT5040", "IT3020", "IT1080"}));
		txtSubjectCodeSession.setBounds(244, 136, 231, 21);
		panel_1.add(txtSubjectCodeSession);
		
		txtSubjectNameSession = new JComboBox();
		txtSubjectNameSession.setModel(new DefaultComboBoxModel(new String[] {"ITPM", "OOP", "IP", "CS", "DMS", "DS", "PFA", "ESD", "MADD"}));
		txtSubjectNameSession.setBounds(244, 179, 231, 21);
		panel_1.add(txtSubjectNameSession);
		
		txtTagSession = new JComboBox();
		txtTagSession.setModel(new DefaultComboBoxModel(new String[] {"Lecture", "Lab", "Tutorial"}));
		txtTagSession.setBounds(244, 215, 231, 21);
		panel_1.add(txtTagSession);
		
		txtGroupIDSession = new JComboBox();
		txtGroupIDSession.setModel(new DefaultComboBoxModel(new String[] {"Y1.Y2.1", "Y1.Y2.2", "Y1.Y2.3", "Y1.Y2.4", "Y1.Y2.5", "Y1.Y2.6", "Y1.Y2.7", "Y1.Y2.8"}));
		txtGroupIDSession.setBounds(244, 254, 231, 21);
		panel_1.add(txtGroupIDSession);
		
		JButton btnNewButton = new JButton("Generate ID");
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
		btnNewButton.setBounds(190, 367, 85, 21);
		panel_1.add(btnNewButton);
		
		txtSessionDuration = new JComboBox();
		txtSessionDuration.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		txtSessionDuration.setBounds(246, 328, 229, 21);
		panel_1.add(txtSessionDuration);
		
		btnNewButton_3 = new JButton("save");
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
		btnNewButton_3.setBounds(271, 439, 85, 21);
		panel_1.add(btnNewButton_3);
		
		manageSessionPanel = new JPanel();
		SessionlayeredPane.add(manageSessionPanel, "name_695830111868700");
		manageSessionPanel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(31, 34, 509, 474);
		manageSessionPanel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Manage Session Details   :");
		lblNewLabel_1.setBounds(39, 22, 158, 13);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_10 = new JLabel("Lecturer Name   :");
		lblNewLabel_10.setBounds(39, 100, 158, 13);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Subject Code   :");
		lblNewLabel_11.setBounds(39, 140, 158, 13);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name   :");
		lblNewLabel_12.setBounds(39, 178, 158, 13);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Tag   :");
		lblNewLabel_13.setBounds(39, 212, 158, 13);
		panel_2.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Group Id   :");
		lblNewLabel_14.setBounds(39, 254, 158, 13);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Student Count   :");
		lblNewLabel_15.setBounds(39, 295, 158, 13);
		panel_2.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Duration   :");
		lblNewLabel_16.setBounds(39, 340, 158, 13);
		panel_2.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Session ID   :");
		lblNewLabel_17.setBounds(39, 408, 158, 13);
		panel_2.add(lblNewLabel_17);
		
		txtLecturerSessionIndex = new JTextField();
		txtLecturerSessionIndex.setBounds(215, 59, 192, 19);
		panel_2.add(txtLecturerSessionIndex);
		txtLecturerSessionIndex.setColumns(10);
		
		txtStudentCountSession2 = new JTextField();
		txtStudentCountSession2.setBounds(215, 292, 192, 19);
		panel_2.add(txtStudentCountSession2);
		txtStudentCountSession2.setColumns(10);
		
		txtSessionId2 = new JTextField();
		txtSessionId2.setBounds(109, 405, 390, 19);
		panel_2.add(txtSessionId2);
		txtSessionId2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("GenerateID");
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
		btnNewButton_1.setBounds(138, 374, 85, 21);
		panel_2.add(btnNewButton_1);
		
		lblNewLabel_18 = new JLabel("Session Index   :");
		lblNewLabel_18.setBounds(36, 62, 161, 13);
		panel_2.add(lblNewLabel_18);
		
		txtLecturerNameSession2 = new JComboBox();
		txtLecturerNameSession2.setModel(new DefaultComboBoxModel(new String[] {"Mr.Kamal", "Mr.Nimal", "Mr.Kalum", "Mr.Nayana", "Mr.Kasun", "Mr.Amal"}));
		txtLecturerNameSession2.setBounds(214, 96, 193, 21);
		panel_2.add(txtLecturerNameSession2);
		
		txtSubjectCodeSession2 = new JComboBox();
		txtSubjectCodeSession2.setModel(new DefaultComboBoxModel(new String[] {"IT6787", "IT9809", "IT4565", "IT9809", "IT3454", "IT8798"}));
		txtSubjectCodeSession2.setBounds(214, 136, 193, 21);
		panel_2.add(txtSubjectCodeSession2);
		
		txtSubjectNameSession2 = new JComboBox();
		txtSubjectNameSession2.setModel(new DefaultComboBoxModel(new String[] {"IP", "OOP", "DMS", "DS", "IWT", "OSSA", "CN"}));
		txtSubjectNameSession2.setBounds(214, 174, 193, 21);
		panel_2.add(txtSubjectNameSession2);
		
		txtTagSession2 = new JComboBox();
		txtTagSession2.setModel(new DefaultComboBoxModel(new String[] {"Lecturers", "Tutorials", "Labs"}));
		txtTagSession2.setBounds(217, 208, 190, 21);
		panel_2.add(txtTagSession2);
		
		txtGroupIDSession2 = new JComboBox();
		txtGroupIDSession2.setModel(new DefaultComboBoxModel(new String[] {"Y1.S1.1", "Y1.S1.2", "Y1.S1.3", "Y1.S1.4", "Y1.S1.5", "Y1.S1.6"}));
		txtGroupIDSession2.setBounds(215, 250, 192, 21);
		panel_2.add(txtGroupIDSession2);
		
		txtSessionDuration2 = new JComboBox();
		txtSessionDuration2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		txtSessionDuration2.setBounds(220, 336, 187, 21);
		panel_2.add(txtSessionDuration2);
		
		btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.setBounds(236, 443, 85, 21);
		panel_2.add(btnNewButton_4);
		
		panel_3 = new JPanel();
		panel_3.setBounds(568, 31, 761, 477);
		manageSessionPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 71, 589, 358);
		panel_3.add(scrollPane);
		
		table = new JTable();
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
		
		JButton btnNewButton_2 = new JButton("Loard All Details   :");
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
		btnNewButton_2.setBounds(378, 26, 164, 21);
		panel_3.add(btnNewButton_2);
		
		SessioncomboBox = new JComboBox();
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
		SessioncomboBox.setBounds(28, 26, 164, 21);
		panel_3.add(SessioncomboBox);
		
		JButton btnNewButton_5 = new JButton("Update");
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
		btnNewButton_5.setBounds(645, 174, 85, 21);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete");
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
		btnNewButton_6.setBounds(645, 220, 85, 21);
		panel_3.add(btnNewButton_6);
		
		refreshSessionTable();
		fillSessionCobmoBox();
		
		
	}
}
