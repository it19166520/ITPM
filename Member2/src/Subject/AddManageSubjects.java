package Subject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class AddManageSubjects extends JFrame {

	private JPanel contentPane;
	private JPanel ManageSubPanel;
	private JPanel AddSubPanel;
	private JLayeredPane SublayeredPane;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtSubName;
	private JTextField txtSubCode;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnLoadTable;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageSubjects frame = new AddManageSubjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanel(JPanel panel) {
		
		SublayeredPane.removeAll();
		SublayeredPane.add(panel);
		SublayeredPane.repaint();
		SublayeredPane.revalidate();
	}
	
	//Connection connection=null;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtSubID;
	private JTextField txtSubName2;
	private JTextField txtSubCode2;
	private JLabel lblNewLabel_18;
	private JComboBox SubjectComboBox;
	private JComboBox txtSubOffYear;
	private JComboBox txtSubOffSem;
	
	
	
	//Connection connection=null;
	Connection conn = SqlServerConnection.dbConnecter();
	private JComboBox NumOfLecHours;
	private JComboBox NumOfEvaltionHours;
	private JComboBox NumOfTuteHours;
	private JComboBox NumOfLabHours;
	private JComboBox txtSubOffYear2;
	private JComboBox txtSubOffSem2;
	private JComboBox txtNumOfLecH2;
	private JComboBox txtNumOfTuteH2;
	private JComboBox txtNumOfLabH2;
	private JComboBox txtNumOfEvaH2;
	private JPanel panel_1;
	private JButton btnNewButton_6;
	private JPanel panel_5;
	private JPanel panel_6;
	
	
	public void refreshSubjectTable()
	{
		try {
			
			String query="select * from subjects";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void fillSubjectCobmoBox() {
		

		try {
			
			String query="select * from subjects";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				SubjectComboBox.addItem(rs.getString("SubjectName"));
			}
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public AddManageSubjects() {
		
		Connection conn = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1384, 789);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SublayeredPane = new JLayeredPane();
		SublayeredPane.setBounds(22, 145, 1343, 597);
		contentPane.add(SublayeredPane);
		SublayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSubPanel = new JPanel();
		AddSubPanel.setBackground(new Color(255, 255, 255));
		SublayeredPane.add(AddSubPanel, "name_127330680826200");
		AddSubPanel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(312, 49, 663, 501);
		AddSubPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Add Subjects :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBackground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(42, 40, 103, 13);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_2 = new JLabel("Offered Semester  :");
		lblNewLabel_2.setBounds(97, 125, 194, 13);
		panel_1.add(lblNewLabel_2);
		
		//create form to get subject details from user :
		lblNewLabel = new JLabel("Offered Year  :");
		lblNewLabel.setBounds(97, 89, 238, 13);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("Subject Name  :");
		lblNewLabel_3.setBounds(97, 159, 194, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Subject Code  :");
		lblNewLabel_4.setBounds(97, 195, 194, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Number Of Lecturer Hours  :");
		lblNewLabel_5.setBounds(97, 233, 194, 13);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Number Of Tutorial Hours  :");
		lblNewLabel_6.setBounds(97, 272, 194, 13);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Number of Lab Hours  :");
		lblNewLabel_7.setBounds(97, 306, 194, 13);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Number of Evalution hours  :");
		lblNewLabel_8.setBounds(97, 346, 194, 13);
		panel_1.add(lblNewLabel_8);
		
		txtSubOffYear = new JComboBox();
		txtSubOffYear.setBackground(new Color(255, 255, 255));
		txtSubOffYear.setBounds(303, 85, 238, 21);
		panel_1.add(txtSubOffYear);
		txtSubOffYear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		txtSubOffSem = new JComboBox();
		txtSubOffSem.setBounds(301, 121, 240, 21);
		panel_1.add(txtSubOffSem);
		txtSubOffSem.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		
		txtSubName = new JTextField();
		txtSubName.setBounds(301, 156, 240, 19);
		panel_1.add(txtSubName);
		txtSubName.setColumns(10);
		
		txtSubCode = new JTextField();
		txtSubCode.setBounds(301, 192, 240, 19);
		panel_1.add(txtSubCode);
		txtSubCode.setColumns(10);
		
		NumOfLecHours = new JComboBox();
		NumOfLecHours.setBounds(301, 229, 240, 21);
		panel_1.add(NumOfLecHours);
		NumOfLecHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		NumOfTuteHours = new JComboBox();
		NumOfTuteHours.setBounds(301, 268, 240, 21);
		panel_1.add(NumOfTuteHours);
		NumOfTuteHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		NumOfLabHours = new JComboBox();
		NumOfLabHours.setBounds(301, 302, 240, 21);
		panel_1.add(NumOfLabHours);
		NumOfLabHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		NumOfEvaltionHours = new JComboBox();
		NumOfEvaltionHours.setBounds(301, 342, 240, 21);
		panel_1.add(NumOfEvaltionHours);
		NumOfEvaltionHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		btnNewButton_2 = new JButton("SAVE");
		btnNewButton_2.setBounds(97, 416, 193, 41);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		
		btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(357, 416, 185, 41);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setBackground(new Color(30, 144, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  //Get Subject Details from the user and store the details in the database:
				
				 try {
						
						String query="insert into subjects (OfferedYear,OfferedSem,SubjectName,SublectCode,NumOfLecHours,NumOfTuteHours,NumOfLabHours,NumOfEvaltionHours) values (?,?,?,?,?,?,?,?)";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						//get year details from the user by using  JComboBox :
						String OffYear=txtSubOffYear.getSelectedItem().toString();
						pst.setString(1, OffYear);
						
						//get semester details from user by using JComboBox:
						String OffSem=txtSubOffSem.getSelectedItem().toString();
						pst.setString(2, OffSem);
						
						//get Subject name and subject code from text fields:
						pst.setString(3, txtSubName.getText());
						pst.setString(4, txtSubCode.getText());
						
						//get Number of lecturer hours from user by using JComboBox:
						String LecHours=txtSubOffSem.getSelectedItem().toString();
						pst.setString(5, LecHours);
						
						//get Number of Tutorial hours from user by using JComboBox:
						String TuteHours=txtSubOffSem.getSelectedItem().toString();
						pst.setString(6, TuteHours);
						
						//get Number of lab hours from user by using JComboBox:
						String LabHours=txtSubOffSem.getSelectedItem().toString();
						pst.setString(7, LabHours);
						
						//get Number of Evalution Hours from by using JComboBox:
						String EvaHours=txtSubOffSem.getSelectedItem().toString();
						pst.setString(8, EvaHours);
						
						
						//Display successful massage when data was inserted to the database successfully:
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data inserted successfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
				//call "refreshSubjectTable" method to refresh the table after doing any changes:
				 refreshSubjectTable();
				 
			}
		});
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_5.setBackground(new Color(135, 206, 250));
		panel_5.setBounds(109, 10, 1094, 577);
		AddSubPanel.add(panel_5);
		panel_5.setLayout(null);
		
		ManageSubPanel = new JPanel();
		ManageSubPanel.setBackground(new Color(255, 255, 255));
		SublayeredPane.add(ManageSubPanel, "name_127354460414000");
		ManageSubPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(586, 99, 691, 346);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		ManageSubPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//To pass the relevant details to the form after selecting the raw of the table:
				  try {
						int row = table.getSelectedRow();
						String ID_=(table.getModel().getValueAt(row, 0)).toString();
						
					   
						String query="select * from subjects where ID='"+ID_+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
					
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							txtSubID.setText(rs.getString("ID"));
							txtSubOffYear2.setSelectedItem(rs.getString("OfferedYear"));
							txtSubOffSem2.setSelectedItem(rs.getString("OfferedSem"));
							txtSubName2.setText(rs.getString("SubjectName"));
							txtSubCode2.setText(rs.getString("SublectCode"));
							txtNumOfLecH2.setSelectedItem(rs.getString("NumOfLecHours"));
							txtNumOfTuteH2.setSelectedItem(rs.getString("NumOfTuteHours"));
							txtNumOfLabH2.setSelectedItem(rs.getString("NumOfLabHours"));
							txtNumOfEvaH2.setSelectedItem(rs.getString("NumOfEvaltionHours"));
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(39, 33, 485, 446);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		ManageSubPanel.add(panel_2);
		panel_2.setLayout(null);
		
		txtSubID = new JTextField();
		txtSubID.setBounds(192, 70, 252, 19);
		panel_2.add(txtSubID);
		txtSubID.setColumns(10);
		
		txtSubOffYear2 = new JComboBox();
		txtSubOffYear2.setBounds(192, 99, 252, 21);
		panel_2.add(txtSubOffYear2);
		txtSubOffYear2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		txtSubOffSem2 = new JComboBox();
		txtSubOffSem2.setBounds(192, 130, 252, 21);
		panel_2.add(txtSubOffSem2);
		txtSubOffSem2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		
		lblNewLabel_1 = new JLabel("ID  :");
		lblNewLabel_1.setBounds(31, 73, 65, 13);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_10 = new JLabel("Offered Year  :");
		lblNewLabel_10.setBounds(31, 103, 106, 13);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Offered Semester  :");
		lblNewLabel_11.setBounds(31, 134, 106, 13);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name  :");
		lblNewLabel_12.setBounds(31, 167, 106, 13);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Subject Code  :");
		lblNewLabel_13.setBounds(31, 200, 106, 13);
		panel_2.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Number Of Lecture Hours  :");
		lblNewLabel_14.setBounds(31, 238, 151, 13);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_15.setBounds(31, 274, 151, 13);
		panel_2.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Number Of Lab Hours  :");
		lblNewLabel_16.setBounds(31, 319, 133, 13);
		panel_2.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Number Of Evalution Hours  :");
		lblNewLabel_17.setBounds(31, 360, 151, 13);
		panel_2.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("ManageDetails  :");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_18.setBounds(31, 28, 120, 17);
		panel_2.add(lblNewLabel_18);
		
		txtSubName2 = new JTextField();
		txtSubName2.setBounds(192, 164, 252, 19);
		panel_2.add(txtSubName2);
		txtSubName2.setColumns(10);
		
		txtSubCode2 = new JTextField();
		txtSubCode2.setBounds(192, 197, 252, 19);
		panel_2.add(txtSubCode2);
		txtSubCode2.setColumns(10);
		
		txtNumOfLecH2 = new JComboBox();
		txtNumOfLecH2.setBounds(192, 230, 252, 21);
		panel_2.add(txtNumOfLecH2);
		txtNumOfLecH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		txtNumOfTuteH2 = new JComboBox();
		txtNumOfTuteH2.setBounds(192, 270, 252, 21);
		panel_2.add(txtNumOfTuteH2);
		txtNumOfTuteH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		txtNumOfLabH2 = new JComboBox();
		txtNumOfLabH2.setBounds(192, 315, 252, 21);
		panel_2.add(txtNumOfLabH2);
		txtNumOfLabH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		txtNumOfEvaH2 = new JComboBox();
		txtNumOfEvaH2.setBounds(193, 356, 251, 21);
		panel_2.add(txtNumOfEvaH2);
		txtNumOfEvaH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(556, 37, 750, 440);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		ManageSubPanel.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		
		
		SubjectComboBox = new JComboBox();
		SubjectComboBox.setBounds(26, 23, 233, 21);
		panel_3.add(SubjectComboBox);
		
		JLabel lblNewLabel_19 = new JLabel("Select Your Name In Here :");
		lblNewLabel_19.setBounds(26, 10, 163, 13);
		panel_3.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnLoadTable = new JButton("Load Details");
		btnLoadTable.setBounds(579, 31, 139, 21);
		panel_3.add(btnLoadTable);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(26, 59, 700, 353);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 1323, 577);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_4.setBackground(new Color(135, 206, 235));
		ManageSubPanel.add(panel_4);
		panel_4.setLayout(null);
		
		btnNewButton_6 = new JButton("Clear All ");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6.setBackground(new Color(30, 144, 255));
		btnNewButton_6.setBounds(212, 500, 145, 29);
		panel_4.add(btnNewButton_6);
		
		btnNewButton_4 = new JButton("Update Details");
		btnNewButton_4.setBounds(501, 498, 191, 32);
		panel_4.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBackground(new Color(50, 205, 50));
		
		btnNewButton_5 = new JButton("Delete Details");
		btnNewButton_5.setBounds(880, 498, 205, 32);
		panel_4.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBackground(new Color(255, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Delete
				try {
					
					String query="delete from subjects where ID='"+txtSubID.getText()+"'";                      
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			
				//To refresh the table after deleting details :
				refreshSubjectTable();	
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update details :

				  try {
						
						String query="update subjects set  OfferedYear='"+txtSubOffYear2.getSelectedItem()+"' , OfferedSem='"+txtSubOffSem2.getSelectedItem()+"' ,SubjectName='"+txtSubName2.getText()+"' ,SublectCode='"+txtSubCode2.getText()+"', NumOfLecHours='"+txtNumOfLecH2.getSelectedItem()+"',  NumOfTuteHours='"+txtNumOfTuteH2.getSelectedItem()+"' , NumOfLabHours='"+txtNumOfLabH2.getSelectedItem()+"' , NumOfEvaltionHours='"+txtNumOfEvaH2.getSelectedItem()+"' where ID='"+txtSubID.getText()+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Details Updated Sucsessfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				  
				//To refresh the table after updating details :
				  refreshSubjectTable();
				
			}
		});
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//To refresh the table after doing any changes:
				try {
					
						String query="select * from subjects";
						PreparedStatement pst=conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
			}
		});
		SubjectComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//To get the details to the form  according to the Subject name which user selected from the comboBox :
	                try {
						
						String query="select * from subjects where SubjectName=?";                      
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setString(1, (String)SubjectComboBox.getSelectedItem());
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							txtSubID.setText(rs.getString("ID"));
							txtSubOffYear2.setSelectedItem(rs.getString("OfferedYear"));
							txtSubOffSem2.setSelectedItem(rs.getString("OfferedSem"));
							txtSubName2.setText(rs.getString("SubjectName"));
							txtSubCode2.setText(rs.getString("SublectCode"));
							txtNumOfLecH2.setSelectedItem(rs.getString("NumOfLecHours"));
							txtNumOfTuteH2.setSelectedItem(rs.getString("NumOfTuteHours"));
							txtNumOfLabH2.setSelectedItem(rs.getString("NumOfLabHours"));
							txtNumOfEvaH2.setSelectedItem(rs.getString("NumOfEvaltionHours"));
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				
			}
		});
		
		JButton btnNewButton = new JButton("Add Subjects");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(AddSubPanel);
				
			}
		});
		btnNewButton.setBounds(128, 103, 243, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View All & Manage");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(ManageSubPanel);
			}
		});
		btnNewButton_1.setBounds(395, 103, 289, 32);
		contentPane.add(btnNewButton_1);
		
		//Header :
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 99, 71));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 1365, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBounds(487, 21, 385, 44);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		txtrTimeTableManagement.setForeground(Color.BLACK);
		//txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtrTimeTableManagement.setText("Timetable Management System");
		panel.add(txtrTimeTableManagement);
		
		refreshSubjectTable();
		fillSubjectCobmoBox();
		
		
	}
}
