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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddManageLecturer extends JFrame {

	
	Connection conn = SqlServerConnection.dbConnecter();
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

	
	//Connection conn = SqlServerConnection.dbConnecter();
	private JTable LecDetailstable;
	private JTable ActiveHoursDetailstable;
	private JTextField txtLecturerRegistrationNumber;
	private JComboBox ActiveHoursComboBox;
	private JComboBox LecturerDetailsComboBox;
	private JButton btnGenerateID;
	private JLabel lblLecturerName;
	private JLabel lblFaculty;
	private JLabel lblDepartment;
	private JLabel lblCampus;
	private JLabel lblBuilding;
	private JLabel lblLecturerID;
	private JLabel lblLevel;
	private JLabel onlyIndexLabel;
	
	
	public void refreshLecturerDetailsTable()
	{	
			try {
				
				String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer";
				PreparedStatement pst=conn.prepareStatement(query);
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
			PreparedStatement pst=conn.prepareStatement(query);
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
			PreparedStatement pst=conn.prepareStatement(query);
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
			PreparedStatement pst=conn.prepareStatement(query);
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
		conn = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1380,846);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LeclayeredPane = new JLayeredPane();
		LeclayeredPane.setBounds(46, 145, 1269, 641);
		contentPane.add(LeclayeredPane);
		LeclayeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(135, 206, 250));
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		LeclayeredPane.add(panel1, "name_74284114373600");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(61, 56, 507, 512);
		panel1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setBounds(83, 120, 91, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(83, 163, 91, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setBounds(83, 255, 58, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setBounds(83, 302, 91, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setBounds(83, 342, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setBounds(83, 434, 45, 13);
		panel.add(lblNewLabel_9);
		
		JComboBox txtFaculty = new JComboBox();
		txtFaculty.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering", "Management", "Medicine", "Science", "Architeccher"}));
		txtFaculty.setBounds(213, 116, 205, 21);
		panel.add(txtFaculty);
		
		JComboBox txtDepartment = new JComboBox();
		txtDepartment.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "DS", "SC", "IS"}));
		txtDepartment.setBounds(213, 159, 205, 21);
		panel.add(txtDepartment);
		
		JComboBox txtBuilding = new JComboBox();
		txtBuilding.setModel(new DefaultComboBoxModel(new String[] {"501", "502", "301", "302", "401", "408"}));
		txtBuilding.setBounds(213, 251, 205, 21);
		panel.add(txtBuilding);
		
		JComboBox txtLevel = new JComboBox();
		txtLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		txtLevel.setBounds(213, 338, 205, 21);
		panel.add(txtLevel);
		
		txtLecturerID = new JTextField();
		txtLecturerID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//validate LecturerID for only accept numbers :
				
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					
					//canit able to enter in text field if entered char is not a number
					txtLecturerID.setEditable(false);
					//set error massage :
					onlyIndexLabel.setText("*Please Enter Numarical value!");
					
				}else {
					
					txtLecturerID.setEditable(true);
					
				}
				
				
			}
		});
		txtLecturerID.setBounds(213, 299, 205, 19);
		panel.add(txtLecturerID);
		txtLecturerID.setColumns(10);
		
		txtRank = new JTextField();
		txtRank.setEditable(false);
		txtRank.setBounds(202, 431, 216, 19);
		panel.add(txtRank);
		txtRank.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(new Color(255, 255, 255));
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lecturer Details :", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_8.setBounds(35, 27, 440, 455);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		btnGenerateID = new JButton("Generate ID");
		btnGenerateID.setBounds(126, 351, 165, 36);
		panel_8.add(btnGenerateID);
		btnGenerateID.setBackground(new Color(135, 206, 250));
		
		JLabel lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setBounds(46, 49, 91, 13);
		panel_8.add(lblNewLabel);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setBounds(179, 46, 205, 19);
		panel_8.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		JComboBox txtCampus = new JComboBox();
		txtCampus.setBounds(179, 177, 205, 21);
		panel_8.add(txtCampus);
		txtCampus.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Kandy", "Kagalle", "Jaffna"}));
		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setBounds(46, 181, 91, 13);
		panel_8.add(lblNewLabel_5);
		
		lblLecturerName = new JLabel("");
		lblLecturerName.setForeground(Color.RED);
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLecturerName.setBounds(317, 64, 67, 13);
		panel_8.add(lblLecturerName);
		
		lblFaculty = new JLabel("");
		lblFaculty.setForeground(Color.RED);
		lblFaculty.setBounds(317, 110, 67, 13);
		panel_8.add(lblFaculty);
		
		lblDepartment = new JLabel("");
		lblDepartment.setForeground(Color.RED);
		lblDepartment.setBounds(317, 152, 66, 13);
		panel_8.add(lblDepartment);
		
		lblCampus = new JLabel("");
		lblCampus.setForeground(Color.RED);
		lblCampus.setBounds(317, 196, 67, 13);
		panel_8.add(lblCampus);
		
		lblBuilding = new JLabel("");
		lblBuilding.setForeground(Color.RED);
		lblBuilding.setBounds(317, 245, 67, 13);
		panel_8.add(lblBuilding);
		
		lblLecturerID = new JLabel("");
		lblLecturerID.setForeground(Color.RED);
		lblLecturerID.setBounds(341, 295, 60, 13);
		panel_8.add(lblLecturerID);
		
		lblLevel = new JLabel("");
		lblLevel.setForeground(Color.RED);
		lblLevel.setBounds(317, 334, 67, 13);
		panel_8.add(lblLevel);
		
		onlyIndexLabel = new JLabel("");
		onlyIndexLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		onlyIndexLabel.setForeground(Color.RED);
		onlyIndexLabel.setBounds(178, 295, 184, 13);
		panel_8.add(onlyIndexLabel);
		btnGenerateID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Generete Rank using Lecturer ID and level :
				try {
					
				String lecId = txtLecturerID.getText();
				String leclevel = (String)txtLevel.getSelectedItem();
				String lecrank = (String)txtLevel.getSelectedItem() +"."+ txtLecturerID.getText();
				txtRank.setText(lecrank);
				
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}

			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(626, 56, 565, 414);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setBounds(72, 89, 92, 13);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setBounds(72, 133, 92, 13);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Wednessday  :");
		lblNewLabel_12.setBounds(72, 176, 92, 13);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setBounds(72, 215, 92, 13);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setBounds(72, 256, 92, 13);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setBounds(72, 300, 92, 13);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setBounds(72, 345, 92, 13);
		panel_1.add(lblNewLabel_16);
		
		txtMonday = new JTextField();
		txtMonday.setBounds(225, 86, 277, 19);
		panel_1.add(txtMonday);
		txtMonday.setColumns(10);
		
		txtTuesday = new JTextField();
		txtTuesday.setBounds(225, 130, 277, 19);
		panel_1.add(txtTuesday);
		txtTuesday.setColumns(10);
		
		txtWednesday = new JTextField();
		txtWednesday.setBounds(225, 173, 277, 19);
		panel_1.add(txtWednesday);
		txtWednesday.setColumns(10);
		
		txtThursday = new JTextField();
		txtThursday.setBounds(225, 212, 277, 19);
		panel_1.add(txtThursday);
		txtThursday.setColumns(10);
		
		txtFriday = new JTextField();
		txtFriday.setBounds(225, 253, 277, 19);
		panel_1.add(txtFriday);
		txtFriday.setColumns(10);
		
		txtSatarday = new JTextField();
		txtSatarday.setBounds(225, 297, 277, 19);
		panel_1.add(txtSatarday);
		txtSatarday.setColumns(10);
		
		txtSunday = new JTextField();
		txtSunday.setBounds(225, 342, 277, 19);
		panel_1.add(txtSunday);
		txtSunday.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Active days and Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_9.setBounds(30, 33, 504, 354);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Save Details  ");
		btnNewButton_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(127, 255, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//To check weather the feilds are required or not:
				
				if(txtLecturerName.getText().trim().isEmpty() && ((String) txtFaculty.getSelectedItem()).trim().isEmpty() && ((String) txtDepartment.getSelectedItem()).trim().isEmpty() && ((String) txtCampus.getSelectedItem()).trim().isEmpty() && ((String) txtBuilding.getSelectedItem()).trim().isEmpty() && txtLecturerID.getText().trim().isEmpty() && ((String) txtLevel.getSelectedItem()).trim().isEmpty())
				{
					
					lblLecturerName.setText("*required");
					lblFaculty.setText("*required");
					lblDepartment.setText("*required");
					lblCampus.setText("*required");
					lblBuilding.setText("*required");
					lblLecturerID.setText("*required");
					lblLevel.setText("*required");
					
				}
				else if(txtLecturerName.getText().trim().isEmpty())
				{
					lblLecturerName.setText("*required");
				}
				else if(((String) txtFaculty.getSelectedItem()).trim().isEmpty()) {
					
					lblFaculty.setText("*required");
				}
				else if(((String) txtDepartment.getSelectedItem()).trim().isEmpty()) {
					
					lblDepartment.setText("*required");
				}
				else if(((String) txtCampus.getSelectedItem()).trim().isEmpty())
				{
					lblCampus.setText("*required");
				}
				else if(((String) txtBuilding.getSelectedItem()).trim().isEmpty())
				{
					lblBuilding.setText("*required");
				}
				else if(txtLecturerID.getText().trim().isEmpty()) 
				{
					lblLecturerID.setText("*required");
				}
				else if(((String) txtLevel.getSelectedItem()).trim().isEmpty()) {
					
					lblLevel.setText("*required");
				}
				else
				
				
				
				
			try {	
				String query="insert into Lecturer (LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";                      
				PreparedStatement pst=conn.prepareStatement(query);
				
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
		btnNewButton_4.setBounds(696, 520, 181, 48);
		panel1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear  ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtLecturerName.setText("  ");
				txtFaculty.setSelectedIndex(-1);
				txtDepartment.setSelectedIndex(-1);
				txtCampus.setSelectedIndex(-1);
				txtBuilding.setSelectedIndex(-1);
				txtLecturerID.setText("  ");
				txtLevel.setSelectedIndex(-1);
				txtRank.setText("  ");
				
				txtMonday.setText("  ");
				txtTuesday.setText("  ");
				txtWednesday.setText("  ");
				txtThursday.setText("  ");
				txtFriday.setText("  ");
				txtSatarday.setText("  ");
				txtSunday.setText("  ");
			}
		});
		btnNewButton_5.setBackground(new Color(255, 127, 80));
		btnNewButton_5.setBounds(970, 520, 161, 48);
		panel1.add(btnNewButton_5);
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(135, 206, 250));
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		LeclayeredPane.add(panel2, "name_74288783095000");
		panel2.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(42, 45, 430, 499);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name :");
		lblNewLabel_1.setBounds(71, 89, 109, 13);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_18 = new JLabel("Faculty  :");
		lblNewLabel_18.setBounds(71, 129, 109, 13);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Department  :");
		lblNewLabel_19.setBounds(71, 170, 109, 13);
		panel_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Campus  :");
		lblNewLabel_20.setBounds(71, 214, 109, 13);
		panel_2.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Building  :");
		lblNewLabel_21.setBounds(71, 255, 109, 13);
		panel_2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Lecturer ID  :");
		lblNewLabel_22.setBounds(71, 295, 109, 13);
		panel_2.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Level  :");
		lblNewLabel_23.setBounds(71, 338, 109, 13);
		panel_2.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Rank  :");
		lblNewLabel_24.setBounds(71, 428, 109, 13);
		panel_2.add(lblNewLabel_24);
		
		txtLecturerName2 = new JTextField();
		txtLecturerName2.setBounds(222, 86, 164, 19);
		panel_2.add(txtLecturerName2);
		txtLecturerName2.setColumns(10);
		
		txtLecturerID2 = new JTextField();
		txtLecturerID2.setBounds(216, 292, 164, 19);
		panel_2.add(txtLecturerID2);
		txtLecturerID2.setColumns(10);
		
		txtRank2 = new JTextField();
		txtRank2.setEditable(false);
		txtRank2.setBounds(216, 425, 164, 19);
		panel_2.add(txtRank2);
		txtRank2.setColumns(10);
		

		
		JComboBox txtFaculty2 = new JComboBox();
		txtFaculty2.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering", "Management", "Medicine", "Archtecture"}));
		txtFaculty2.setBounds(219, 125, 167, 21);
		panel_2.add(txtFaculty2);
		
		JComboBox txtDepartment2 = new JComboBox();
		txtDepartment2.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "SC", "DS", "IS"}));
		txtDepartment2.setBounds(216, 166, 167, 21);
		panel_2.add(txtDepartment2);
		
		JComboBox txtCampus2 = new JComboBox();
		txtCampus2.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Kandy", "Kagalle", "Jaffna"}));
		txtCampus2.setBounds(216, 210, 167, 21);
		panel_2.add(txtCampus2);
		
		JComboBox txtBuilding2 = new JComboBox();
		txtBuilding2.setModel(new DefaultComboBoxModel(new String[] {"501", "502", "301", "302", "402", "402"}));
		txtBuilding2.setBounds(216, 251, 167, 21);
		panel_2.add(txtBuilding2);
		
		JComboBox txtLevel2 = new JComboBox();
		txtLevel2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		txtLevel2.setBounds(216, 334, 164, 21);
		panel_2.add(txtLevel2);
		
		JLabel lblNewLabel_33 = new JLabel("Registration Number  :");
		lblNewLabel_33.setBounds(71, 53, 109, 13);
		panel_2.add(lblNewLabel_33);
		
		txtLecturerRegistrationNumber = new JTextField();
		txtLecturerRegistrationNumber.setBounds(219, 50, 167, 19);
		panel_2.add(txtLecturerRegistrationNumber);
		txtLecturerRegistrationNumber.setColumns(10);
		
		JButton btnNewButton_9 = new JButton("Generate ID");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Genarete rank using lecturerId and level
				try {
					
					String UpdatedLecId = txtLecturerID2.getText();
			    	String UpdatedLevel = (String)txtLevel2.getSelectedItem();
					String lecrank2 = (String)txtLevel2.getSelectedItem() +"."+ txtLecturerID2.getText();
					txtRank2.setText(lecrank2);
					
					
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}	
			}
		});
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_9.setBounds(149, 379, 133, 21);
		panel_2.add(btnNewButton_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(493, 49, 590, 495);
		panel2.add(panel_3);
		panel_3.setLayout(null);
		
		
		JButton btnLoadLecturerDetails = new JButton("Load Table");
		btnLoadLecturerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer";
					PreparedStatement pst=conn.prepareStatement(query);
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
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(25, 111, 544, 315);
		panel_3.add(scrollPane);
		
		LecDetailstable = new JTable();
		LecDetailstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					int row = LecDetailstable.getSelectedRow();
					String LecturerRegistrationNumber_=(LecDetailstable.getModel().getValueAt(row, 0)).toString();
					
					String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer where LecturerRegistrationNumber = '"+LecturerRegistrationNumber_+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					
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
		scrollPane.setViewportView(LecDetailstable);
		
		LecturerDetailsComboBox = new JComboBox();
		LecturerDetailsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Faculty,Department,Campus,Building,LecturerID,Level,Rank from Lecturer where LecturerName=? ";
					PreparedStatement pst=conn.prepareStatement(query);
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
		
		JLabel lblNewLabel_35 = new JLabel("Select Your Name In Here :");
		lblNewLabel_35.setBounds(25, 13, 151, 13);
		panel_3.add(lblNewLabel_35);
		
		JButton btnNewButton_6 = new JButton("Update");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Inserted data into the table :
				
				  try {
						
						String query="update Lecturer set  LecturerName='"+txtLecturerName2.getText()+"' , Faculty='"+txtFaculty2.getSelectedItem()+"' ,Department='"+txtDepartment2.getSelectedItem()+"' ,Campus='"+txtCampus2.getSelectedItem()+"', Building='"+txtBuilding2.getSelectedItem()+"',  LecturerID='"+txtLecturerID2.getText()+"' , Level='"+txtLevel2.getSelectedItem()+"' , Rank='"+txtRank2.getText()+"' where LecturerRegistrationNumber='"+txtLecturerRegistrationNumber.getText()+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
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
		btnNewButton_6.setBounds(1111, 196, 109, 39);
		panel2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete lecturer details  :
				
				try {
					
					String query="delete from Lecturer where LecturerRegistrationNumber='"+txtLecturerRegistrationNumber.getText()+"'";                      
					PreparedStatement pst=conn.prepareStatement(query);
					
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
		btnNewButton_7.setBounds(1111, 261, 109, 39);
		panel2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Clear");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtLecturerRegistrationNumber.setText("  ");
				txtLecturerName2.setText("  ");
				txtFaculty2.setSelectedIndex(-1);
				txtDepartment2.setSelectedIndex(-1);
				txtCampus2.setSelectedIndex(-1);
				txtBuilding2.setSelectedIndex(-1);
				txtLecturerID2.setText("  ");
				txtLevel2.setSelectedIndex(-1);
				txtRank2.setText("  ");
				
				
			}
		});
		btnNewButton_8.setBounds(1111, 323, 109, 39);
		panel2.add(btnNewButton_8);
		
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setForeground(Color.BLACK);
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		txtLecturerName3.setEditable(false);
		txtLecturerName3.setBounds(208, 78, 96, 19);
		panel_4.add(txtLecturerName3);
		txtLecturerName3.setColumns(10);
		
		txtLecturerID3 = new JTextField();
		txtLecturerID3.setEditable(false);
		txtLecturerID3.setBounds(208, 126, 96, 19);
		panel_4.add(txtLecturerID3);
		txtLecturerID3.setColumns(10);
		
		JLabel lblNewLabel_36 = new JLabel("You can't change Lecturer Name and Lecturer ID in here !");
		lblNewLabel_36.setForeground(new Color(255, 0, 0));
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_36.setBounds(63, 173, 301, 13);
		panel_4.add(lblNewLabel_36);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(245, 304, 692, 310);
		panel3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 68, 672, 232);
		panel_6.add(scrollPane_1);
		
		ActiveHoursDetailstable = new JTable();
		ActiveHoursDetailstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					int row = ActiveHoursDetailstable.getSelectedRow();
					String LecturerRegistrationNumber_=(ActiveHoursDetailstable.getModel().getValueAt(row, 0)).toString();
					
					String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer where LecturerRegistrationNumber = '"+LecturerRegistrationNumber_+"' ";
					PreparedStatement pst=conn.prepareStatement(query);
					 
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
		scrollPane_1.setViewportView(ActiveHoursDetailstable);
		
		JButton btnLoadActiveHoursDetails = new JButton("Load Details");
		btnLoadActiveHoursDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					ActiveHoursDetailstable.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}			
				
				
				
			}
		});
		btnLoadActiveHoursDetails.setBounds(516, 37, 166, 21);
		panel_6.add(btnLoadActiveHoursDetails);
		
		ActiveHoursComboBox = new JComboBox();
		ActiveHoursComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Get selected comobox value to the form :
				
				try {
					
					String query="select LecturerRegistrationNumber,LecturerName,Monday,Tuesday,Wednesday,Thursday,Friday,Satarday,Sunday from Lecturer where LecturerName=? ";
					PreparedStatement pst=conn.prepareStatement(query);
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
		ActiveHoursComboBox.setBounds(10, 37, 149, 21);
		panel_6.add(ActiveHoursComboBox);
		
		JLabel lblNewLabel_17 = new JLabel("Enter Your Name In Here :");
		lblNewLabel_17.setBounds(10, 14, 149, 13);
		panel_6.add(lblNewLabel_17);
		
		JButton btnNewButton_10 = new JButton("Update");
		btnNewButton_10.setBackground(Color.GREEN);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Active hours details :
				
				  try {
						
						String query="Update Lecturer set Monday='"+txtMonday3.getText()+"' , Tuesday='"+txtTuesday3.getText()+"' , Wednesday='"+txtWednesday3.getText()+"' , Thursday='"+txtThursday3.getText()+"', Friday='"+txtFriday3.getText()+"', Satarday='"+txtSatarday3.getText()+"' , Sunday='"+txtSunday3.getText()+"'  where LecturerRegistrationNumber='"+txtLecturerID3.getText()+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
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
		btnNewButton_10.setBounds(1073, 237, 138, 36);
		panel3.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("Clear All");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtLecturerName3.setText("  ");
				txtLecturerID3.setText("  ");
				txtMonday3.setText("  ");
				txtTuesday3.setText("  ");
				txtWednesday3.setText("  ");
				txtThursday3.setText("  ");
				txtFriday3.setText("  ");
				txtSatarday3.setText("  ");
				txtSunday3.setText("  ");
				
				
			}
		});
		btnNewButton_12.setBackground(Color.ORANGE);
		btnNewButton_12.setBounds(1073, 283, 138, 36);
		panel3.add(btnNewButton_12);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_10.setBackground(new Color(135, 206, 250));
		panel_10.setBounds(29, 23, 1034, 608);
		panel3.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel1);
			}
		});
		btnNewButton.setBounds(46, 104, 166, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Lecturer Details");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel2);
			}
		});
		btnNewButton_1.setBounds(222, 104, 204, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Manage Active Hours");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel3);
			}
		});
		btnNewButton_2.setBounds(436, 104, 189, 31);
		contentPane.add(btnNewButton_2);
		
		//Header 
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(255, 99, 71));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_7.setBounds(10, 10, 1346, 75);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_34 = new JLabel("Timetable Management System");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_34.setBounds(489, 21, 609, 29);
		panel_7.add(lblNewLabel_34);
		
		refreshLecturerDetailsTable();
		refreshActiveHoursTable();
		
		fillLecturerComboBox();
		fillActiveHoursComboBox();
	}
}
