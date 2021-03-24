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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SublayeredPane = new JLayeredPane();
		SublayeredPane.setBounds(147, 183, 1132, 559);
		contentPane.add(SublayeredPane);
		SublayeredPane.setLayout(new CardLayout(0, 0));
		
		AddSubPanel = new JPanel();
		SublayeredPane.add(AddSubPanel, "name_127330680826200");
		AddSubPanel.setLayout(null);
		
		//create form to get subject details from user :
		lblNewLabel = new JLabel("Offered Year  :");
		lblNewLabel.setBounds(365, 137, 194, 13);
		AddSubPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Offered Semester  :");
		lblNewLabel_2.setBounds(365, 175, 194, 13);
		AddSubPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Subject Name  :");
		lblNewLabel_3.setBounds(365, 214, 194, 13);
		AddSubPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Subject Code  :");
		lblNewLabel_4.setBounds(365, 250, 194, 13);
		AddSubPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Number Of Lecturer Hours  :");
		lblNewLabel_5.setBounds(365, 288, 194, 13);
		AddSubPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Number Of Tutorial Hours  :");
		lblNewLabel_6.setBounds(365, 321, 194, 13);
		AddSubPanel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Number of Lab Hours  :");
		lblNewLabel_7.setBounds(365, 354, 194, 13);
		AddSubPanel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Number of Evalution hours  :");
		lblNewLabel_8.setBounds(365, 390, 194, 13);
		AddSubPanel.add(lblNewLabel_8);
		
		txtSubName = new JTextField();
		txtSubName.setBounds(532, 211, 186, 19);
		AddSubPanel.add(txtSubName);
		txtSubName.setColumns(10);
		
		txtSubCode = new JTextField();
		txtSubCode.setBounds(532, 247, 186, 19);
		AddSubPanel.add(txtSubCode);
		txtSubCode.setColumns(10);
		
		btnNewButton_2 = new JButton("ADD");
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
		btnNewButton_2.setBounds(365, 471, 150, 21);
		AddSubPanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(548, 471, 170, 21);
		AddSubPanel.add(btnNewButton_3);
		
		txtSubOffYear = new JComboBox();
		txtSubOffYear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		txtSubOffYear.setBounds(530, 133, 188, 21);
		AddSubPanel.add(txtSubOffYear);
		
		txtSubOffSem = new JComboBox();
		txtSubOffSem.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		txtSubOffSem.setBounds(532, 171, 186, 21);
		AddSubPanel.add(txtSubOffSem);
		
		NumOfLecHours = new JComboBox();
		NumOfLecHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		NumOfLecHours.setBounds(530, 284, 188, 21);
		AddSubPanel.add(NumOfLecHours);
		
		NumOfTuteHours = new JComboBox();
		NumOfTuteHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		NumOfTuteHours.setBounds(532, 317, 186, 21);
		AddSubPanel.add(NumOfTuteHours);
		
		NumOfLabHours = new JComboBox();
		NumOfLabHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		NumOfLabHours.setBounds(532, 350, 186, 21);
		AddSubPanel.add(NumOfLabHours);
		
		NumOfEvaltionHours = new JComboBox();
		NumOfEvaltionHours.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		NumOfEvaltionHours.setBounds(530, 386, 188, 21);
		AddSubPanel.add(NumOfEvaltionHours);
		
		panel_1 = new JPanel();
		panel_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(224, 23, 668, 507);
		AddSubPanel.add(panel_1);
		
		lblNewLabel_9 = new JLabel("Add Subjects :");
		panel_1.add(lblNewLabel_9);
		
		ManageSubPanel = new JPanel();
		SublayeredPane.add(ManageSubPanel, "name_127354460414000");
		ManageSubPanel.setLayout(null);
		
		btnLoadTable = new JButton("Load Details");
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
		btnLoadTable.setBounds(885, 52, 85, 21);
		ManageSubPanel.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(544, 104, 702, 380);
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
		
		btnNewButton_4 = new JButton("Update Details");
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
		btnNewButton_4.setBounds(689, 509, 191, 32);
		ManageSubPanel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Delete Details");
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
		
		//create form to update subject details which user added before :
		btnNewButton_5.setBounds(910, 509, 205, 32);
		ManageSubPanel.add(btnNewButton_5);
		
		lblNewLabel_1 = new JLabel("ID  :");
		lblNewLabel_1.setBounds(39, 106, 65, 13);
		ManageSubPanel.add(lblNewLabel_1);
		
		lblNewLabel_10 = new JLabel("Offered Year  :");
		lblNewLabel_10.setBounds(39, 144, 106, 13);
		ManageSubPanel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Offered Semester  :");
		lblNewLabel_11.setBounds(39, 178, 106, 13);
		ManageSubPanel.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Subject Name  :");
		lblNewLabel_12.setBounds(39, 222, 106, 13);
		ManageSubPanel.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Subject Code  :");
		lblNewLabel_13.setBounds(39, 261, 106, 13);
		ManageSubPanel.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Number Of Lecture Hours  :");
		lblNewLabel_14.setBounds(39, 303, 106, 13);
		ManageSubPanel.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_15.setBounds(39, 343, 106, 13);
		ManageSubPanel.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Number Of Lab Hours  :");
		lblNewLabel_16.setBounds(39, 383, 106, 13);
		ManageSubPanel.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Number Of Evalution Hours  :");
		lblNewLabel_17.setBounds(39, 428, 106, 13);
		ManageSubPanel.add(lblNewLabel_17);
		
		txtSubID = new JTextField();
		txtSubID.setBounds(189, 103, 176, 19);
		ManageSubPanel.add(txtSubID);
		txtSubID.setColumns(10);
		
		txtSubName2 = new JTextField();
		txtSubName2.setBounds(189, 219, 177, 19);
		ManageSubPanel.add(txtSubName2);
		txtSubName2.setColumns(10);
		
		txtSubCode2 = new JTextField();
		txtSubCode2.setBounds(189, 258, 177, 19);
		ManageSubPanel.add(txtSubCode2);
		txtSubCode2.setColumns(10);
		
		lblNewLabel_18 = new JLabel("ManageDetails  :");
		lblNewLabel_18.setBounds(39, 52, 120, 17);
		ManageSubPanel.add(lblNewLabel_18);
		
		
		
		
		
		SubjectComboBox = new JComboBox();
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
		SubjectComboBox.setBounds(544, 68, 85, 21);
		ManageSubPanel.add(SubjectComboBox);
		
		txtSubOffYear2 = new JComboBox();
		txtSubOffYear2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		txtSubOffYear2.setBounds(189, 140, 177, 21);
		ManageSubPanel.add(txtSubOffYear2);
		
		txtSubOffSem2 = new JComboBox();
		txtSubOffSem2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		txtSubOffSem2.setBounds(189, 174, 177, 21);
		ManageSubPanel.add(txtSubOffSem2);
		
		txtNumOfLecH2 = new JComboBox();
		txtNumOfLecH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		txtNumOfLecH2.setBounds(189, 299, 177, 21);
		ManageSubPanel.add(txtNumOfLecH2);
		
		txtNumOfTuteH2 = new JComboBox();
		txtNumOfTuteH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		txtNumOfTuteH2.setBounds(189, 339, 177, 21);
		ManageSubPanel.add(txtNumOfTuteH2);
		
		txtNumOfLabH2 = new JComboBox();
		txtNumOfLabH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		txtNumOfLabH2.setBounds(189, 379, 177, 21);
		ManageSubPanel.add(txtNumOfLabH2);
		
		txtNumOfEvaH2 = new JComboBox();
		txtNumOfEvaH2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		txtNumOfEvaH2.setBounds(190, 424, 176, 21);
		ManageSubPanel.add(txtNumOfEvaH2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(AddSubPanel);
				
			}
		});
		btnNewButton.setBounds(153, 141, 91, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View ALL & Manage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(ManageSubPanel);
			}
		});
		btnNewButton_1.setBounds(254, 141, 123, 32);
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
