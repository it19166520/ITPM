package Lecturer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import java.awt.SystemColor;

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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_8;
	private JPanel panel_7;
	private JLabel lblNewLabel_34;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_10;
	private JPanel panel_9;
	private JLabel lblNewLabel_33;
	private JButton btnNewButton_5;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnLoadLecturerDetails;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_24;
	private JComboBox txtLevel2;
	private JComboBox txtBuilding2;
	private JComboBox txtCampus2;
	private JComboBox txtDepartment2;
	private JComboBox txtFaculty2;
	private JComboBox txtFaculty;
	private JComboBox txtDepartment;
	private JComboBox txtCampus;
	private JComboBox txtBuilding;
	private JComboBox txtLevel;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_17;
	private JPanel panel_6;
	private JButton btnLoadActiveHoursDetails;
	private JScrollPane scrollPane;
	
	
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
		setBounds(0,0,1600,825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] faculty= {"Computing", "Engineering", "Management", "Medicine", "Archtecture"};
		String[] department = {"IT", "SE", "SC", "DS", "IS"};
		String[] campus= {"Malabe", "Kandy", "Kagalle", "Jaffna"};
		String[] buildingNumber = {"501", "502", "301", "302", "402", "402"};
		String[] level= {"1", "2", "3", "4", "5", "6"};
		
		
		LeclayeredPane = new JLayeredPane();
		LeclayeredPane.setBounds(46, 145, 1269, 641);
		contentPane.add(LeclayeredPane);
		LeclayeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		LeclayeredPane.add(panel1, "name_74284114373600");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(228,241,254));
		panel.setBorder(null);
		panel.setBounds(36, 24, 548, 607);
		panel1.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(83, 120, 91, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(83, 163, 91, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(83, 255, 58, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(83, 302, 91, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(83, 342, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(83, 434, 45, 13);
		panel.add(lblNewLabel_9);
		
		txtFaculty = new JComboBox(faculty);
		txtFaculty.setBackground(Color.WHITE);
		txtFaculty.setSelectedIndex(-1);
		txtFaculty.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtFaculty.setBounds(213, 116, 205, 21);
		panel.add(txtFaculty);
		
		txtDepartment = new JComboBox(department);
		txtDepartment.setBackground(Color.WHITE);
		txtDepartment.setSelectedIndex(-1);
		txtDepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtDepartment.setBounds(213, 159, 205, 21);
		panel.add(txtDepartment);
		
		txtBuilding = new JComboBox(buildingNumber);
		txtBuilding.setSelectedIndex(-1);
		txtBuilding.setBackground(Color.WHITE);
		txtBuilding.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtBuilding.setBounds(213, 251, 205, 21);
		panel.add(txtBuilding);
		
		txtLevel = new JComboBox(level);
		txtLevel.setSelectedIndex(-1);
		txtLevel.setBackground(Color.WHITE);
		txtLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
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
		
		panel_8 = new JPanel();
		panel_8.setForeground(new Color(255, 255, 255));
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lecturer Details :", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_8.setBounds(35, 10, 491, 571);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		btnGenerateID = new JButton("Generate ID");
		btnGenerateID.setFocusTraversalKeysEnabled(false);
		btnGenerateID.setFocusPainted(false);
		btnGenerateID.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenerateID.setForeground(Color.WHITE);
		btnGenerateID.setBounds(130, 366, 165, 36);
		panel_8.add(btnGenerateID);
		btnGenerateID.setBackground(new Color(58, 83, 155));
		
		lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(46, 49, 91, 13);
		panel_8.add(lblNewLabel);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setBounds(179, 46, 205, 19);
		panel_8.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		txtCampus = new JComboBox(campus);
		txtCampus.setBackground(Color.WHITE);
		txtCampus.setSelectedIndex(-1);
		txtCampus.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCampus.setBounds(179, 192, 205, 21);
		panel_8.add(txtCampus);

		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(46, 196, 104, 13);
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
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBounds(694, 24, 565, 537);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(72, 89, 92, 13);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(72, 133, 92, 13);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Wednessday  :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(72, 176, 92, 13);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setBounds(72, 215, 92, 13);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_14.setBounds(72, 256, 92, 13);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_15.setBounds(72, 300, 92, 13);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(228, 241, 254));
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Active days and Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_9.setBounds(34, 0, 504, 527);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		btnNewButton_3 = new JButton("Save Details  ");
		btnNewButton_3.setFocusTraversalKeysEnabled(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(27,163,156));
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBounds(743, 571, 181, 48);
		panel1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Clear  ");
		btnNewButton_4.setFocusTraversalKeysEnabled(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setBackground(new Color(58,83,155));
		btnNewButton_4.setBounds(1072, 571, 161, 48);
		panel1.add(btnNewButton_4);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(null);
		LeclayeredPane.add(panel2, "name_74288783095000");
		panel2.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(228,241,254));
		panel_2.setBorder(null);
		panel_2.setBounds(42, 27, 430, 589);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Lecturer Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(50, 89, 109, 23);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_18 = new JLabel("Faculty  :");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_18.setBounds(50, 122, 109, 26);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Department  :");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_19.setBounds(50, 170, 109, 26);
		panel_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Campus  :");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_20.setBounds(50, 212, 109, 17);
		panel_2.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Building  :");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_21.setBounds(50, 248, 109, 26);
		panel_2.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Lecturer ID  :");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_22.setBounds(50, 301, 109, 26);
		panel_2.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("Level  :");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_23.setBounds(50, 351, 109, 26);
		panel_2.add(lblNewLabel_23);
		
		lblNewLabel_24 = new JLabel("Rank  :");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_24.setBounds(50, 493, 109, 26);
		panel_2.add(lblNewLabel_24);
		
		txtLecturerName2 = new JTextField();
		txtLecturerName2.setBounds(222, 86, 164, 19);
		panel_2.add(txtLecturerName2);
		txtLecturerName2.setColumns(10);
		
		txtLecturerID2 = new JTextField();
		txtLecturerID2.setBounds(222, 305, 164, 19);
		panel_2.add(txtLecturerID2);
		txtLecturerID2.setColumns(10);
		
		txtRank2 = new JTextField();
		txtRank2.setEditable(false);
		txtRank2.setBounds(216, 500, 164, 19);
		panel_2.add(txtRank2);
		txtRank2.setColumns(10);
		
 
		txtFaculty2 = new JComboBox(faculty);
		txtFaculty2.setBackground(Color.WHITE);
		txtFaculty2.setSelectedIndex(-1);
		txtFaculty2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFaculty2.setBounds(219, 125, 167, 21);
		panel_2.add(txtFaculty2);
		
		txtDepartment2 = new JComboBox(department);
		txtDepartment2.setSelectedIndex(-1);
		txtDepartment2.setBackground(Color.WHITE);
		txtDepartment2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDepartment2.setBounds(216, 166, 167, 21);
		panel_2.add(txtDepartment2);
		
		txtCampus2 = new JComboBox(campus);
		txtCampus2.setSelectedIndex(-1);
		txtCampus2.setBackground(Color.WHITE);
		txtCampus2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCampus2.setBounds(216, 210, 167, 21);
		panel_2.add(txtCampus2);
		
		
		txtBuilding2 = new JComboBox(buildingNumber);
		txtBuilding2.setSelectedIndex(-1);
		txtBuilding2.setBackground(Color.WHITE);
		txtBuilding2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBuilding2.setBounds(216, 251, 167, 21);
		panel_2.add(txtBuilding2);
		
		
		txtLevel2 = new JComboBox(level);
		txtLevel2.setBackground(Color.WHITE);
		txtLevel2.setSelectedIndex(-1);
		txtLevel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLevel2.setBounds(222, 355, 164, 21);
		panel_2.add(txtLevel2);
		
		lblNewLabel_33 = new JLabel("Registration Number  :");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_33.setBounds(50, 46, 149, 26);
		panel_2.add(lblNewLabel_33);
		
		txtLecturerRegistrationNumber = new JTextField();
		txtLecturerRegistrationNumber.setBounds(219, 50, 167, 19);
		panel_2.add(txtLecturerRegistrationNumber);
		txtLecturerRegistrationNumber.setColumns(10);
		
		btnNewButton_5 = new JButton("Generate ID");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(58,83,155));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
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
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setBounds(128, 415, 159, 39);
		panel_2.add(btnNewButton_5);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(228,241,254));
		panel_3.setBorder(null);
		panel_3.setBounds(519, 27, 590, 589);
		panel2.add(panel_3);
		panel_3.setLayout(null);
		
		
		btnLoadLecturerDetails = new JButton("Load Table");
		btnLoadLecturerDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoadLecturerDetails.setForeground(Color.WHITE);
		btnLoadLecturerDetails.setBackground(new Color(58,83,155));
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
		btnLoadLecturerDetails.setBounds(399, 36, 170, 42);
		panel_3.add(btnLoadLecturerDetails);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(25, 111, 544, 423);
		panel_3.add(scrollPane);
		
		LecDetailstable = new JTable();
		LecDetailstable.setFont(new Font("Tahoma", Font.BOLD, 13));
		LecDetailstable.setShowHorizontalLines(false);
		LecDetailstable.setRowHeight(20);
		LecDetailstable.setBackground(Color.WHITE);
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
		LecturerDetailsComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		LecturerDetailsComboBox.setBounds(25, 36, 170, 22);
		panel_3.add(LecturerDetailsComboBox);
		
		JLabel lblNewLabel_35 = new JLabel("Select Your Name In Here :");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_35.setBounds(25, 13, 170, 13);
		panel_3.add(lblNewLabel_35);
		
		btnNewButton_6 = new JButton("Update");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(27,163,156));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		btnNewButton_6.setBounds(1134, 196, 135, 39);
		panel2.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Delete");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(new Color(210,77,87));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnNewButton_7.setBounds(1134, 260, 135, 39);
		panel2.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("Clear");
		btnNewButton_8.setBackground(new Color(58,83,155));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_8.setForeground(Color.WHITE);
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
		btnNewButton_8.setBounds(1134, 323, 135, 39);
		panel2.add(btnNewButton_8);
		
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setForeground(Color.BLACK);
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(228,241,254));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_4.setBounds(35, 10, 479, 284);
		panel3.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Lecturer Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(49, 54, 132, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_25 = new JLabel("Lecturer ID :");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_25.setBounds(49, 124, 116, 13);
		panel_4.add(lblNewLabel_25);
		
		txtLecturerName3 = new JTextField();
		txtLecturerName3.setEditable(false);
		txtLecturerName3.setBounds(208, 51, 156, 26);
		panel_4.add(txtLecturerName3);
		txtLecturerName3.setColumns(10);
		
		txtLecturerID3 = new JTextField();
		txtLecturerID3.setEditable(false);
		txtLecturerID3.setBounds(208, 119, 156, 26);
		panel_4.add(txtLecturerID3);
		txtLecturerID3.setColumns(10);
		
		JLabel lblNewLabel_36 = new JLabel("You can't change Lecturer Name and Lecturer ID in here !");
		lblNewLabel_36.setForeground(new Color(255, 0, 0));
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_36.setBounds(63, 173, 318, 13);
		panel_4.add(lblNewLabel_36);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(228,241,254));
		panel_5.setBorder(null);
		panel_5.setBounds(550, 10, 503, 284);
		panel3.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_26 = new JLabel("Monday  :");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_26.setBounds(30, 13, 110, 20);
		panel_5.add(lblNewLabel_26);
		
		lblNewLabel_27 = new JLabel("Tuesday  :");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_27.setBounds(30, 57, 110, 20);
		panel_5.add(lblNewLabel_27);
		
		lblNewLabel_28 = new JLabel("Wednesday  :");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_28.setBounds(30, 100, 110, 20);
		panel_5.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("Thursday  :");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_29.setBounds(30, 134, 110, 29);
		panel_5.add(lblNewLabel_29);
		
		lblNewLabel_30 = new JLabel("Friday  :");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_30.setBounds(30, 173, 110, 19);
		panel_5.add(lblNewLabel_30);
		
		lblNewLabel_31 = new JLabel("Satarday  :");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_31.setBounds(30, 209, 110, 20);
		panel_5.add(lblNewLabel_31);
		
		lblNewLabel_32 = new JLabel("Sunday  :");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_32.setBounds(30, 247, 110, 20);
		panel_5.add(lblNewLabel_32);
		
		txtMonday3 = new JTextField();
		txtMonday3.setBounds(177, 10, 185, 27);
		panel_5.add(txtMonday3);
		txtMonday3.setColumns(10);
		
		txtTuesday3 = new JTextField();
		txtTuesday3.setBounds(177, 54, 185, 27);
		panel_5.add(txtTuesday3);
		txtTuesday3.setColumns(10);
		
		txtWednesday3 = new JTextField();
		txtWednesday3.setBounds(177, 100, 185, 27);
		panel_5.add(txtWednesday3);
		txtWednesday3.setColumns(10);
		
		txtThursday3 = new JTextField();
		txtThursday3.setBounds(177, 134, 185, 32);
		panel_5.add(txtThursday3);
		txtThursday3.setColumns(10);
		
		txtFriday3 = new JTextField();
		txtFriday3.setBounds(177, 173, 185, 26);
		panel_5.add(txtFriday3);
		txtFriday3.setColumns(10);
		
		txtSatarday3 = new JTextField();
		txtSatarday3.setBounds(177, 209, 185, 28);
		panel_5.add(txtSatarday3);
		txtSatarday3.setColumns(10);
		
		txtSunday3 = new JTextField();
		txtSunday3.setBounds(177, 247, 185, 27);
		panel_5.add(txtSunday3);
		txtSunday3.setColumns(10);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(228,241,254));
		panel_6.setBorder(null);
		panel_6.setBounds(245, 304, 709, 327);
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
		
		btnLoadActiveHoursDetails = new JButton("Load Details");
		btnLoadActiveHoursDetails.setForeground(Color.WHITE);
		btnLoadActiveHoursDetails.setBackground(new Color(58,83,155));
		btnLoadActiveHoursDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnLoadActiveHoursDetails.setBounds(516, 14, 166, 35);
		panel_6.add(btnLoadActiveHoursDetails);
		
		ActiveHoursComboBox = new JComboBox();
		ActiveHoursComboBox.setBackground(Color.WHITE);
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
		
		lblNewLabel_17 = new JLabel("Enter Your Name In Here :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_17.setBounds(10, 14, 176, 13);
		panel_6.add(lblNewLabel_17);
		
		btnNewButton_10 = new JButton("Update");
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_10.setBackground(new Color(27,163,156));
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
		btnNewButton_10.setBounds(1111, 236, 158, 45);
		panel3.add(btnNewButton_10);
		
		btnNewButton_9 = new JButton("Clear All");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.addActionListener(new ActionListener() {
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
		btnNewButton_9.setBackground(new Color(58,83,155));
		btnNewButton_9.setBounds(1113, 305, 156, 45);
		panel3.add(btnNewButton_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(0, 10, 1091, 621);
		panel3.add(panel_10);
		panel_10.setLayout(null);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(58, 83, 155));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel1);
			}
		});
		btnNewButton.setBounds(46, 97, 207, 44);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Manage Lecturer Details");
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(58, 83, 155));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel2);
			}
		});
		btnNewButton_1.setBounds(273, 97, 233, 44);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Manage Active Hours");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFocusTraversalKeysEnabled(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(58, 83, 155));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel3);
			}
		});
		btnNewButton_2.setBounds(524, 97, 218, 44);
		contentPane.add(btnNewButton_2);
		
		//Header 
		
		panel_7 = new JPanel();
		panel_7.setForeground(Color.WHITE);
		panel_7.setBackground(new Color(75, 119, 190));
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel_7.setBounds(10, 10, 1520, 75);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_34 = new JLabel("Timetable Management System");
		lblNewLabel_34.setForeground(Color.WHITE);
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_34.setBounds(516, 21, 660, 44);
		panel_7.add(lblNewLabel_34);
		
		refreshLecturerDetailsTable();
		refreshActiveHoursTable();
		
		fillLecturerComboBox();
		fillActiveHoursComboBox();
	}
}
