package Lecturer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Color;

public class AddManageLecturer extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JLayeredPane LeclayeredPane;
	private JPanel panel3;
	private JTextField txtLecturerName;
	private JTextField txtLecturerID;
	private JTextField txtRank;
	private JTextField txtMonday;
	private JTextField txtTuesday;
	private JTextField txtWednesday;
	private JTextField txtThursday;
	private JTextField txtFriday;
	private JTextField txtSatarday;
	private JTextField txtSunday;
	private JTextField txtLecturerID2;
	private JTextField txtRank2;
	private JTextField txtLecturerName2;
	private JTextField txtLecturerName3;
	private JTextField txtLecturerID3;
	private JTextField txtMonday3;
	private JTextField txtTuesday3;
	private JTextField txtWednesday3;
	private JTextField txtThursday3;
	private JTextField txtFriday3;
	private JTextField txtSatarday3;
	private JTextField txtSunday3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageLecturer frame = new AddManageLecturer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPannels(JPanel panel) {
		
		LeclayeredPane.removeAll();
		LeclayeredPane.add(panel);
		LeclayeredPane.repaint();
		LeclayeredPane.revalidate();
		
	}

	Connection connection=null;
	private JTable LecDetailstable;
	private JTable ActiveHoursDetailstable;
	private JTextField txtLecturerRegistrationNumber;
	private JComboBox ActiveHoursComboBox;
	private JComboBox LecturerDetailsComboBox;
	
	
	public void refreshLecturerDetailsTable()
	{	
			try {
				
				String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				LecDetailstable.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}				
	}
	
	public void refreshActiveHoursTable()
	{		
		try {
			
			String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			ActiveHoursDetailstable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}			
		
	}		
	
	public void fillLecturerComboBox()
	{
		try {
			
			String query="select * from Lecturer";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				LecturerDetailsComboBox.addItem(rs.getObject("LecturerName"));
			}
			
		}catch(Exception e1){
			
			e1.printStackTrace();
		}
		
	}
	
	public void fillActiveHoursComboBox()
	{
		try {
			
			String query="select * from Lecturer";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				ActiveHoursComboBox.addItem(rs.getObject("LecturerName"));
			}
			
		}catch(Exception e1){
			
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public AddManageLecturer() {
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1370,728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LeclayeredPane = new JLayeredPane();
		LeclayeredPane.setBounds(10, 72, 1243, 576);
		contentPane.add(LeclayeredPane);
		LeclayeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		LeclayeredPane.add(panel1, "name_74284114373600");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(61, 45, 507, 488);
		panel1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setBounds(46, 94, 91, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setBounds(46, 137, 91, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(46, 179, 91, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setBounds(46, 218, 91, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setBounds(46, 255, 58, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setBounds(46, 302, 91, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setBounds(46, 342, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setBounds(46, 434, 45, 13);
		panel.add(lblNewLabel_9);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setBounds(147, 91, 96, 19);
		panel.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		JComboBox txtFaculty = new JComboBox();
		txtFaculty.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering", "Management", "Medicine", "Science", "Architeccher"}));
		txtFaculty.setBounds(147, 133, 96, 21);
		panel.add(txtFaculty);
		
		JComboBox txtDepartment = new JComboBox();
		txtDepartment.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "DS", "SC", "IS"}));
		txtDepartment.setBounds(147, 175, 96, 21);
		panel.add(txtDepartment);
		
		JComboBox txtCampus = new JComboBox();
		txtCampus.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Kandy", "Kagalle", "Jaffna"}));
		txtCampus.setBounds(147, 214, 96, 21);
		panel.add(txtCampus);
		
		JComboBox txtBuilding = new JComboBox();
		txtBuilding.setModel(new DefaultComboBoxModel(new String[] {"501", "502", "301", "302", "401", "408"}));
		txtBuilding.setBounds(147, 251, 96, 21);
		panel.add(txtBuilding);
		
		JComboBox txtLevel = new JComboBox();
		txtLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		txtLevel.setBounds(147, 338, 96, 21);
		panel.add(txtLevel);
		
		txtLecturerID = new JTextField();
		txtLecturerID.setBounds(147, 299, 96, 19);
		panel.add(txtLecturerID);
		txtLecturerID.setColumns(10);
		
		txtRank = new JTextField();
		txtRank.setBounds(147, 431, 96, 19);
		panel.add(txtRank);
		txtRank.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(625, 45, 565, 406);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setBounds(41, 92, 92, 13);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setBounds(41, 133, 92, 13);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Wednessday  :");
		lblNewLabel_12.setBounds(41, 176, 92, 13);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setBounds(41, 215, 92, 13);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setBounds(41, 256, 92, 13);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setBounds(41, 300, 92, 13);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setBounds(41, 342, 92, 13);
		panel_1.add(lblNewLabel_16);
		
		txtMonday = new JTextField();
		txtMonday.setBounds(141, 89, 185, 19);
		panel_1.add(txtMonday);
		txtMonday.setColumns(10);
		
		txtTuesday = new JTextField();
		txtTuesday.setBounds(141, 130, 185, 19);
		panel_1.add(txtTuesday);
		txtTuesday.setColumns(10);
		
		txtWednesday = new JTextField();
		txtWednesday.setBounds(141, 173, 185, 19);
		panel_1.add(txtWednesday);
		txtWednesday.setColumns(10);
		
		txtThursday = new JTextField();
		txtThursday.setBounds(141, 212, 185, 19);
		panel_1.add(txtThursday);
		txtThursday.setColumns(10);
		
		txtFriday = new JTextField();
		txtFriday.setBounds(141, 253, 185, 19);
		panel_1.add(txtFriday);
		txtFriday.setColumns(10);
		
		txtSatarday = new JTextField();
		txtSatarday.setBounds(141, 297, 185, 19);
		panel_1.add(txtSatarday);
		txtSatarday.setColumns(10);
		
		txtSunday = new JTextField();
		txtSunday.setBounds(141, 342, 185, 19);
		panel_1.add(txtSunday);
		txtSunday.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Active days and Hours :");
		lblNewLabel_17.setBounds(24, 50, 194, 13);
		panel_1.add(lblNewLabel_17);
		
		JButton btnNewButton_4 = new JButton("Save Details  ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {	
				String query="insert into Lecturer (LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                      
				PreparedStatement pst=connection.prepareStatement(query);
				
				//get subject name from the user by using text fields :
				pst.setString(1,txtLecturerName.getText());
				
				//get semester details from user by using JComboBox:
				String fac=txtFaculty.getSelectedItem().toString();
				pst.setString(2, fac);
				
				//get Number of lecturer hours from user by using JComboBox:
				String Department=txtDepartment.getSelectedItem().toString();
				pst.setString(3, Department);
				
				//get Number of Tutorial hours from user by using JComboBox:
				String Campus=txtCampus.getSelectedItem().toString();
				pst.setString(4, Campus);
				
				//get Number of lab hours from user by using JComboBox:
				String Building=txtBuilding.getSelectedItem().toString();
				pst.setString(5, Building);
				
				//get Number of Evalution Hours from by using JComboBox:
				pst.setString(6,txtLecturerID.getText());
				
				//get Number of lab hours from user by using JComboBox:
				String level=txtLevel.getSelectedItem().toString();
				pst.setString(7, level);
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(8,txtRank.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(9,txtMonday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(10,txtTuesday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(11,txtWednesday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(12,txtThursday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(13,txtFriday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(14,txtSatarday.getText());
				
				//get Number of lab hours from user by using JComboBox:
				pst.setString(15,txtSunday.getText());
				
				//Display successful massage when data was inserted to the database successfully:
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				
				pst.close();
				
				
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
				
			   refreshLecturerDetailsTable();
			}
		});
		btnNewButton_4.setBounds(692, 494, 138, 21);
		panel1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear  ");
		btnNewButton_5.setBounds(912, 494, 85, 21);
		panel1.add(btnNewButton_5);
		
		panel2 = new JPanel();
		LeclayeredPane.add(panel2, "name_74288783095000");
		panel2.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 45, 463, 521);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name :");
		lblNewLabel_1.setBounds(36, 86, 109, 13);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_18 = new JLabel("Faculty  :");
		lblNewLabel_18.setBounds(36, 125, 109, 13);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Department  :");
		lblNewLabel_19.setBounds(36, 170, 109, 13);
		panel_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Campus  :");
		lblNewLabel_20.setBounds(36, 214, 109, 13);
		panel_2.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Building  :");
		lblNewLabel_21.setBounds(36, 255, 109, 13);
		panel_2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Lecturer ID  :");
		lblNewLabel_22.setBounds(36, 295, 109, 13);
		panel_2.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Level  :");
		lblNewLabel_23.setBounds(36, 338, 109, 13);
		panel_2.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Rank  :");
		lblNewLabel_24.setBounds(36, 428, 109, 13);
		panel_2.add(lblNewLabel_24);
		
		txtLecturerName2 = new JTextField();
		txtLecturerName2.setBounds(155, 83, 164, 19);
		panel_2.add(txtLecturerName2);
		txtLecturerName2.setColumns(10);
		
		txtLecturerID2 = new JTextField();
		txtLecturerID2.setBounds(155, 292, 164, 19);
		panel_2.add(txtLecturerID2);
		txtLecturerID2.setColumns(10);
		
		txtRank2 = new JTextField();
		txtRank2.setBounds(155, 425, 164, 19);
		panel_2.add(txtRank2);
		txtRank2.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Generate ID");
		btnNewButton_9.setBounds(115, 379, 133, 21);
		panel_2.add(btnNewButton_9);
		
		JComboBox txtFaculty2 = new JComboBox();
		txtFaculty2.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering", "Management", "Medicine", "Archtecture"}));
		txtFaculty2.setBounds(152, 121, 167, 21);
		panel_2.add(txtFaculty2);
		
		JComboBox txtDepartment2 = new JComboBox();
		txtDepartment2.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "SC", "DS", "IS"}));
		txtDepartment2.setBounds(152, 166, 167, 21);
		panel_2.add(txtDepartment2);
		
		JComboBox txtCampus2 = new JComboBox();
		txtCampus2.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Kandy", "Kagalle", "Jaffna"}));
		txtCampus2.setBounds(152, 210, 167, 21);
		panel_2.add(txtCampus2);
		
		JComboBox txtBuilding2 = new JComboBox();
		txtBuilding2.setModel(new DefaultComboBoxModel(new String[] {"501", "502", "301", "302", "402", "402"}));
		txtBuilding2.setBounds(152, 251, 167, 21);
		panel_2.add(txtBuilding2);
		
		JComboBox txtLevel2 = new JComboBox();
		txtLevel2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		txtLevel2.setBounds(155, 334, 164, 21);
		panel_2.add(txtLevel2);
		
		JLabel lblNewLabel_33 = new JLabel("Registration Number  :");
		lblNewLabel_33.setBounds(36, 53, 109, 13);
		panel_2.add(lblNewLabel_33);
		
		txtLecturerRegistrationNumber = new JTextField();
		txtLecturerRegistrationNumber.setBounds(152, 50, 167, 19);
		panel_2.add(txtLecturerRegistrationNumber);
		txtLecturerRegistrationNumber.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(493, 49, 590, 517);
		panel2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLoadLecturerDetails = new JButton("Load Table");
		btnLoadLecturerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					LecDetailstable.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}				
				
				
				
			}
		});
		btnLoadLecturerDetails.setBounds(418, 36, 151, 21);
		panel_3.add(btnLoadLecturerDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 122, 544, 304);
		panel_3.add(scrollPane);
		
		LecDetailstable = new JTable();
		scrollPane.setViewportView(LecDetailstable);
		
		LecturerDetailsComboBox = new JComboBox();
		LecturerDetailsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer where LecturerName=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, (String)LecturerDetailsComboBox.getSelectedItem() );
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtLecturerRegistrationNumber.setText(rs.getString("LecturerRegistrationNumber"));
						txtLecturerName2.setText(rs.getString("LecturerName"));
						txtFaculty2.setSelectedItem(rs.getString("Faculty"));
						txtDepartment2.setSelectedItem(rs.getString("Department"));
						txtCampus2.setSelectedItem(rs.getString("Campus"));
						txtBuilding2.setSelectedItem(rs.getString("Building"));
						txtLecturerID2.setText(rs.getString("LecturerID"));
						txtLevel2.setSelectedItem(rs.getString("Level"));
						txtRank2.setText(rs.getString("Rank"));
						
						
					}
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}		
				
				
			}
		});
		LecturerDetailsComboBox.setBounds(25, 36, 151, 21);
		panel_3.add(LecturerDetailsComboBox);
		
		JButton btnNewButton_6 = new JButton("Update");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Inserted data into the table :
				
				  try {
						
						String query="update Lecturer set  LecturerName='"+txtLecturerName2.getText()+"' , Faculty='"+txtFaculty2.getSelectedItem()+"' ,Department='"+txtDepartment2.getSelectedItem()+"' ,Campus='"+txtCampus2.getSelectedItem()+"', Building='"+txtBuilding2.getSelectedItem()+"',  LecturerID='"+txtLecturerID2.getText()+"' , Level='"+txtLevel2.getSelectedItem()+"' , Rank='"+txtRank2.getText()+"' where LecturerRegistrationNumber='"+txtLecturerRegistrationNumber.getText()+"' ";                      
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Details Updated Sucsessfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				  refreshLecturerDetailsTable();
			}
		});
		btnNewButton_6.setBounds(1111, 172, 109, 39);
		panel2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete lecturer details  :
				
				try {
					
					String query="delete from Lecturer where LecturerRegistrationNumber='"+txtLecturerRegistrationNumber.getText()+"'";                      
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				refreshLecturerDetailsTable();
				
			}
		});
		btnNewButton_7.setBounds(1111, 221, 109, 39);
		panel2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Clear");
		btnNewButton_8.setBounds(1111, 270, 109, 39);
		panel2.add(btnNewButton_8);
		
		panel3 = new JPanel();
		panel3.setForeground(Color.BLACK);
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(62, 42, 414, 252);
		panel3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer Name:");
		lblNewLabel_2.setBounds(63, 81, 116, 13);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_25 = new JLabel("Lecturer ID :");
		lblNewLabel_25.setBounds(63, 129, 116, 13);
		panel_4.add(lblNewLabel_25);
		
		txtLecturerName3 = new JTextField();
		txtLecturerName3.setBounds(208, 78, 96, 19);
		panel_4.add(txtLecturerName3);
		txtLecturerName3.setColumns(10);
		
		txtLecturerID3 = new JTextField();
		txtLecturerID3.setBounds(208, 126, 96, 19);
		panel_4.add(txtLecturerID3);
		txtLecturerID3.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(582, 42, 431, 252);
		panel3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_26 = new JLabel("Monday  :");
		lblNewLabel_26.setBounds(30, 61, 110, 13);
		panel_5.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Tuesday  :");
		lblNewLabel_27.setBounds(30, 84, 110, 13);
		panel_5.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Wednesday  :");
		lblNewLabel_28.setBounds(30, 107, 110, 13);
		panel_5.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Thursday  :");
		lblNewLabel_29.setBounds(30, 130, 110, 13);
		panel_5.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Friday  :");
		lblNewLabel_30.setBounds(30, 153, 110, 13);
		panel_5.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Satarday  :");
		lblNewLabel_31.setBounds(30, 176, 110, 13);
		panel_5.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Sunday  :");
		lblNewLabel_32.setBounds(30, 199, 110, 13);
		panel_5.add(lblNewLabel_32);
		
		txtMonday3 = new JTextField();
		txtMonday3.setBounds(126, 58, 185, 19);
		panel_5.add(txtMonday3);
		txtMonday3.setColumns(10);
		
		txtTuesday3 = new JTextField();
		txtTuesday3.setBounds(126, 84, 185, 19);
		panel_5.add(txtTuesday3);
		txtTuesday3.setColumns(10);
		
		txtWednesday3 = new JTextField();
		txtWednesday3.setBounds(126, 107, 185, 19);
		panel_5.add(txtWednesday3);
		txtWednesday3.setColumns(10);
		
		txtThursday3 = new JTextField();
		txtThursday3.setBounds(126, 130, 185, 19);
		panel_5.add(txtThursday3);
		txtThursday3.setColumns(10);
		
		txtFriday3 = new JTextField();
		txtFriday3.setBounds(126, 153, 185, 19);
		panel_5.add(txtFriday3);
		txtFriday3.setColumns(10);
		
		txtSatarday3 = new JTextField();
		txtSatarday3.setBounds(126, 176, 185, 19);
		panel_5.add(txtSatarday3);
		txtSatarday3.setColumns(10);
		
		txtSunday3 = new JTextField();
		txtSunday3.setBounds(126, 199, 185, 19);
		panel_5.add(txtSunday3);
		txtSunday3.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(245, 304, 692, 262);
		panel3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 41, 672, 211);
		panel_6.add(scrollPane_1);
		
		ActiveHoursDetailstable = new JTable();
		scrollPane_1.setViewportView(ActiveHoursDetailstable);
		
		JButton btnLoadActiveHoursDetails = new JButton("Load Details");
		btnLoadActiveHoursDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					ActiveHoursDetailstable.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}			
				
				
				
			}
		});
		btnLoadActiveHoursDetails.setBounds(436, 10, 166, 21);
		panel_6.add(btnLoadActiveHoursDetails);
		
		ActiveHoursComboBox = new JComboBox();
		ActiveHoursComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Get selected comobox value to the form :
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer where LecturerName=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, (String)ActiveHoursComboBox.getSelectedItem() );
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtLecturerID3.setText(rs.getString("LecturerRegistrationNumber"));
						txtLecturerName3.setText(rs.getString("LecturerName"));
						txtMonday3.setText(rs.getString("Monday"));
						txtTuesday3.setText(rs.getString("Tuesday"));
						txtWednesday3.setText(rs.getString("Wednesday"));
						txtThursday3.setText(rs.getString("Thursday"));
						txtFriday3.setText(rs.getString("Friday"));
						txtSatarday3.setText(rs.getString("Satarday"));
						txtSunday3.setText(rs.getString("Sunday"));
						
						
					}
					
					pst.close();
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}		
				
				
				
			}
		});
		ActiveHoursComboBox.setBounds(10, 10, 149, 21);
		panel_6.add(ActiveHoursComboBox);
		
		JButton btnNewButton_10 = new JButton("Update");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Active hours details :
				
				  try {
						
						String query="Update Lecturer set Monday='"+txtMonday3.getText()+"' , Tuesday='"+txtTuesday3.getText()+"' , Wednesday='"+txtWednesday3.getText()+"' , Thursday='"+txtThursday3.getText()+"', Friday='"+txtFriday3.getText()+"', Satarday='"+txtSatarday3.getText()+"' , Sunday='"+txtSunday3.getText()+"'  where LecturerRegistrationNumber='"+txtLecturerID3.getText()+"' ";                      
						PreparedStatement pst=connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Details Updated Sucsessfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}
				  
				  refreshActiveHoursTable();
	
			}
			
		});
		btnNewButton_10.setBounds(1073, 119, 85, 21);
		panel3.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("Clear");
		btnNewButton_12.setBounds(1073, 150, 85, 21);
		panel3.add(btnNewButton_12);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel1);
			}
		});
		btnNewButton.setBounds(10, 41, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Lecturer Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel2);
			}
		});
		btnNewButton_1.setBounds(105, 41, 143, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Active Hours");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel3);
			}
		});
		btnNewButton_2.setBounds(258, 41, 143, 21);
		contentPane.add(btnNewButton_2);
		
		refreshLecturerDetailsTable();
		refreshActiveHoursTable();
		
		fillLecturerComboBox();
		fillActiveHoursComboBox();
	}
}
