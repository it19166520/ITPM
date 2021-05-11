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
import Home.HomePage;
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
	private JLabel onlyIndexLabel1;
	private JPanel panel_16;
	private JPanel panel_17;
	private JLabel lblNewLabel_37;
	private JLabel InvalidMonday;
	private JLabel InvalidSatarday;
	private JLabel InvalidFriday;
	private JLabel InvalidSunday;
	private JLabel InvalidTuesday;
	private JLabel InvalidWednesday;
	private JLabel InvalidThursday;
	private JLabel InvalidWednesday2;
	private JLabel InvalidThursday2;
	private JLabel InvalidFriday2;
	private JLabel InvalidSatarday2;
	private JLabel InvalidSunday2;
	private JLabel InvalidTuesday2;
	private JLabel InvalidMonday2;
	private JLabel lblNewLabel_38;
	private JLabel SuccessLabel;
	private JLabel txtOnlyLetters;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	
	
	public void refreshLecturerDetailsTable()
	{	
			try {
				
				Connection conn = SqlServerConnection.dbConnecter();
				
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
			
			Connection conn = SqlServerConnection.dbConnecter();
			
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
			
			Connection conn = SqlServerConnection.dbConnecter();
			
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
			
			Connection conn = SqlServerConnection.dbConnecter();
			
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
		Connection conn = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
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
		LeclayeredPane.setBounds(31, 132, 1315, 559);
		contentPane.add(LeclayeredPane);
		LeclayeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		LeclayeredPane.add(panel1, "name_74284114373600");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(224, 255, 255));
		panel.setBackground(new Color(228,241,254));
		panel.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel.setBounds(28, 32, 647, 437);
		panel1.add(panel);
		panel.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setForeground(new Color(255, 255, 255));
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Lecturer Details :", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_8.setBounds(31, 21, 587, 402);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		btnGenerateID = new JButton("Generate Rank");
		btnGenerateID.setFocusTraversalKeysEnabled(false);
		btnGenerateID.setFocusPainted(false);
		btnGenerateID.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerateID.setForeground(new Color(255, 255, 255));
		btnGenerateID.setBounds(286, 318, 174, 30);
		panel_8.add(btnGenerateID);
		btnGenerateID.setBackground(new Color(30, 144, 255));
		
		lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(53, 29, 147, 13);
		panel_8.add(lblNewLabel);
		
		txtLecturerName = new JTextField();
		txtLecturerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					
			}
		});
		txtLecturerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtLecturerName.setBounds(210, 27, 332, 19);
		panel_8.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		txtCampus = new JComboBox(campus);
		txtCampus.setBackground(Color.WHITE);
		txtCampus.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Metro", "Matara", "Kandy", "Kurunagala", "Jaffna"}));
		txtCampus.setSelectedIndex(-1);
		txtCampus.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCampus.setBounds(210, 155, 332, 20);
		panel_8.add(txtCampus);

		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(53, 162, 118, 13);
		panel_8.add(lblNewLabel_5);
		
		lblLecturerName = new JLabel("");
		lblLecturerName.setForeground(Color.RED);
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLecturerName.setBounds(210, 49, 174, 13);
		panel_8.add(lblLecturerName);
		
		lblFaculty = new JLabel("");
		lblFaculty.setForeground(Color.RED);
		lblFaculty.setBounds(210, 87, 174, 13);
		panel_8.add(lblFaculty);
		
		lblDepartment = new JLabel("");
		lblDepartment.setForeground(Color.RED);
		lblDepartment.setBounds(211, 132, 173, 13);
		panel_8.add(lblDepartment);
		
		lblCampus = new JLabel("");
		lblCampus.setForeground(Color.RED);
		lblCampus.setBounds(210, 175, 174, 13);
		panel_8.add(lblCampus);
		
		lblBuilding = new JLabel("");
		lblBuilding.setForeground(Color.RED);
		lblBuilding.setBounds(210, 218, 174, 13);
		panel_8.add(lblBuilding);
		
		lblLecturerID = new JLabel("");
		lblLecturerID.setForeground(Color.RED);
		lblLecturerID.setBounds(451, 263, 91, 13);
		panel_8.add(lblLecturerID);
		
		lblLevel = new JLabel("");
		lblLevel.setForeground(Color.RED);
		lblLevel.setBounds(210, 305, 67, 13);
		panel_8.add(lblLevel);
		
		onlyIndexLabel = new JLabel("");
		onlyIndexLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		onlyIndexLabel.setForeground(Color.RED);
		onlyIndexLabel.setBounds(210, 257, 236, 19);
		panel_8.add(onlyIndexLabel);
		
		txtFaculty = new JComboBox(faculty);
		txtFaculty.setBounds(210, 65, 332, 21);
		panel_8.add(txtFaculty);
		txtFaculty.setBackground(Color.WHITE);
		txtFaculty.setModel(new DefaultComboBoxModel(new String[] {"Faculty of Computing", "Faculty of Engineering", "Faculty of Business", "Faculty of Medicine", "Faculty of Archtecture", "Faculty of Humanties & Sciences", "Faculty of Graduate Studies and Research"}));
		txtFaculty.setSelectedIndex(-1);
		txtFaculty.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtDepartment = new JComboBox(department);
		txtDepartment.setBounds(210, 110, 332, 18);
		panel_8.add(txtDepartment);
		txtDepartment.setBackground(Color.WHITE);
		txtDepartment.setModel(new DefaultComboBoxModel(new String[] {"Department of Information Technology", "Department of Computer Systems Engineering", "Department of Computer Science & Software Engineering", "Department of Business Management", "Department of Business Management", "Department of nursing", "Department of Archtecture"}));
		txtDepartment.setSelectedIndex(-1);
		txtDepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtBuilding = new JComboBox(buildingNumber);
		txtBuilding.setBounds(210, 198, 332, 21);
		panel_8.add(txtBuilding);
		txtBuilding.setModel(new DefaultComboBoxModel(new String[] {"New building", "D-block", "Engineering Building", "Business Management Building", "nursing Building", "Archtecture Building"}));
		txtBuilding.setSelectedIndex(-1);
		txtBuilding.setBackground(Color.WHITE);
		txtBuilding.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtLecturerID = new JTextField();
		txtLecturerID.setBounds(210, 241, 332, 19);
		panel_8.add(txtLecturerID);
		txtLecturerID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//validate to only add 6 numbers only
				
				if(txtLecturerID.getText().length()>=6)
				{
					//canit able to enter in text field if entered number length is greater than 6
					txtLecturerID.setEditable(false);
					//set error massage :
					onlyIndexLabel.setText("*Invalid ID! Hint:ID cannot have more than 6 digits!");
				}
				else if(txtLecturerID.getText().length()<5)
				{
					//canit able to enter in text field if entered number length is greater than 6
					txtLecturerID.setEditable(false);
					//set error massage :
					onlyIndexLabel.setText("*Invalid ID! Hint:ID must have 6 digits!");
				}
				
				
				
				
				else if(txtLecturerID.getText().length()==5)
				{
					
					txtLecturerID.setEditable(true);
					onlyIndexLabel.setText("*Valid ID!");
				}
				else {
					
					txtLecturerID.setEditable(true);
					onlyIndexLabel.setText("");
				}
				
				
				
				
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
		txtLecturerID.setColumns(10);
		
		txtLevel = new JComboBox(level);
		txtLevel.setBounds(210, 286, 332, 21);
		panel_8.add(txtLevel);
		txtLevel.setSelectedIndex(-1);
		txtLevel.setBackground(Color.WHITE);
		txtLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtRank = new JTextField();
		txtRank.setForeground(new Color(138, 43, 226));
		txtRank.setBounds(210, 358, 332, 26);
		panel_8.add(txtRank);
		txtRank.setEditable(false);
		txtRank.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setBounds(53, 73, 105, 13);
		panel_8.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(53, 117, 105, 13);
		panel_8.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setBounds(53, 206, 129, 13);
		panel_8.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setBounds(53, 253, 105, 13);
		panel_8.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setBounds(53, 295, 59, 13);
		panel_8.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setForeground(new Color(138, 43, 226));
		lblNewLabel_9.setBounds(53, 367, 118, 13);
		panel_8.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_40 = new JLabel("Click This Button To Get Rank    -->");
		lblNewLabel_40.setForeground(new Color(0, 128, 0));
		lblNewLabel_40.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_40.setBounds(53, 328, 237, 13);
		panel_8.add(lblNewLabel_40);
		
		txtOnlyLetters = new JLabel("");
		txtOnlyLetters.setBounds(394, 49, 148, 13);
		panel_8.add(txtOnlyLetters);
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
		
		JPanel panel_11 = new JPanel();
		panel_11.setForeground(new Color(224, 255, 255));
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(10, 0, 1279, 525);
		panel1.add(panel_11);
		panel_11.setLayout(null);
		
		btnNewButton_4 = new JButton("Clear  ");
		btnNewButton_4.setBounds(657, 476, 199, 39);
		panel_11.add(btnNewButton_4);
		btnNewButton_4.setFocusTraversalKeysEnabled(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SuccessLabel.setText("");
				
				lblLecturerName.setText("");
				lblFaculty.setText("");
				lblDepartment.setText("");
				lblCampus.setText("");
				lblBuilding.setText("");
				lblLecturerID.setText("");
				
				
				
				InvalidMonday.setText("");
				InvalidTuesday.setText("");
				InvalidWednesday.setText("");
				InvalidThursday.setText("");
				InvalidFriday.setText("");
				InvalidSatarday.setText("");
				InvalidSunday.setText("");
				
				
				onlyIndexLabel.setText("");
				
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
		
		btnNewButton_3 = new JButton("Save Details  ");
		btnNewButton_3.setBounds(439, 476, 208, 39);
		panel_11.add(btnNewButton_3);
		btnNewButton_3.setFocusTraversalKeysEnabled(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(27,163,156));
		
		JLabel lblNewLabel_39 = new JLabel("-   Add New Lecturer Details   -");
		lblNewLabel_39.setForeground(new Color(0, 0, 139));
		lblNewLabel_39.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_39.setBounds(556, 6, 247, 23);
		panel_11.add(lblNewLabel_39);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(675, 33, 582, 437);
		panel_11.add(panel_1);
		panel_1.setForeground(new Color(224, 255, 255));
		panel_1.setBackground(new Color(228,241,254));
		panel_1.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_1.setLayout(null);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Active days and Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_9.setBounds(25, 25, 529, 393);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setBounds(46, 327, 127, 13);
		panel_9.add(lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setBounds(46, 283, 127, 13);
		panel_9.add(lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setBounds(46, 242, 127, 13);
		panel_9.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setBounds(46, 201, 127, 13);
		panel_9.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_12 = new JLabel("Wednesday  :");
		lblNewLabel_12.setBounds(46, 158, 127, 13);
		panel_9.add(lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setBounds(46, 117, 127, 13);
		panel_9.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSunday = new JTextField();
		txtSunday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtSunday.getText());
				
				
				if(!match.matches())
				{
					InvalidSunday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidSunday.setText("Correct Format !");
					SuccessLabel.setText("*Click ' Save Details ' Button To ADD these details in to the system!");
				}
				
				else
				{
					InvalidSunday.setText("");
					
				}
				
				
				
				
			}
		});
		txtSunday.setBounds(183, 325, 305, 19);
		panel_9.add(txtSunday);
		txtSunday.setColumns(10);
		
		txtSatarday = new JTextField();
		txtSatarday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtSatarday.getText());
				
				
				if(!match.matches())
				{
					InvalidSatarday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidSatarday.setText("Correct Format !");
				}
				
				else
				{
					InvalidSatarday.setText(null);
					
				}
				
				
			}
		});
		txtSatarday.setBounds(183, 281, 305, 19);
		panel_9.add(txtSatarday);
		txtSatarday.setColumns(10);
		
		txtFriday = new JTextField();
		txtFriday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtFriday.getText());
				
				
				if(!match.matches())
				{
					InvalidFriday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidFriday.setText("Correct Format !");
				}
				
				else
				{
					InvalidFriday.setText("");
					
				}
				
			}
		});
		txtFriday.setBounds(183, 240, 305, 19);
		panel_9.add(txtFriday);
		txtFriday.setColumns(10);
		
		txtThursday = new JTextField();
		txtThursday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtThursday.getText());
				
				
				if(!match.matches())
				{
					InvalidThursday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidThursday.setText("Correct Format !");
				}
				
				else
				{
					InvalidThursday.setText(null);
					
				}
				
				
				
			
			}
		});
		txtThursday.setBounds(183, 199, 305, 19);
		panel_9.add(txtThursday);
		txtThursday.setColumns(10);
		
		txtWednesday = new JTextField();
		txtWednesday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtWednesday.getText());
				
				
				if(!match.matches())
				{
					InvalidWednesday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidWednesday.setText("Correct Format !");
				}
				
				else
				{
					InvalidWednesday.setText(null);
					
				}
				
				
				
			
				
				
			}
		});
		txtWednesday.setBounds(183, 156, 305, 19);
		panel_9.add(txtWednesday);
		txtWednesday.setColumns(10);
		
		txtTuesday = new JTextField();
		txtTuesday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtTuesday.getText());
				
				
				if(!match.matches())
				{
					InvalidTuesday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidTuesday.setText("Correct Format !");
				}
				
				else
				{
					InvalidTuesday.setText(null);
					
				}
			
			
			}
		});
		txtTuesday.setBounds(183, 115, 305, 19);
		panel_9.add(txtTuesday);
		txtTuesday.setColumns(10);
		
		txtMonday = new JTextField();
		txtMonday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtMonday.getText());
				
				
				if(!match.matches())
				{
					InvalidMonday.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidMonday.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidMonday.setText("");
					
				}
						
			}
		});
		txtMonday.setBounds(183, 74, 305, 19);
		panel_9.add(txtMonday);
		txtMonday.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setBounds(46, 76, 127, 13);
		panel_9.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_37 = new JLabel("Example :    11.00 - 16.00  (from 00:00 to 23:59)     OR     \" - \" mark for free days.");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_37.setForeground(new Color(0, 128, 0));
		lblNewLabel_37.setBounds(46, 36, 467, 13);
		panel_9.add(lblNewLabel_37);
		
		InvalidMonday = new JLabel("");
		InvalidMonday.setForeground(Color.RED);
		InvalidMonday.setBounds(383, 92, 105, 13);
		panel_9.add(InvalidMonday);
		
		InvalidTuesday = new JLabel("");
		InvalidTuesday.setForeground(Color.RED);
		InvalidTuesday.setBounds(383, 133, 105, 13);
		panel_9.add(InvalidTuesday);
		
		InvalidWednesday = new JLabel("");
		InvalidWednesday.setForeground(Color.RED);
		InvalidWednesday.setBounds(383, 176, 105, 13);
		panel_9.add(InvalidWednesday);
		
		InvalidThursday = new JLabel("");
		InvalidThursday.setForeground(Color.RED);
		InvalidThursday.setBounds(383, 217, 105, 13);
		panel_9.add(InvalidThursday);
		
		InvalidFriday = new JLabel("");
		InvalidFriday.setForeground(Color.RED);
		InvalidFriday.setBounds(383, 258, 105, 13);
		panel_9.add(InvalidFriday);
		
		InvalidSatarday = new JLabel("");
		InvalidSatarday.setForeground(Color.RED);
		InvalidSatarday.setBounds(383, 302, 105, 13);
		panel_9.add(InvalidSatarday);
		
		InvalidSunday = new JLabel("");
		InvalidSunday.setForeground(Color.RED);
		InvalidSunday.setBounds(383, 344, 105, 19);
		panel_9.add(InvalidSunday);
		
		SuccessLabel = new JLabel("");
		SuccessLabel.setForeground(new Color(0, 128, 0));
		SuccessLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		SuccessLabel.setBounds(41, 366, 447, 13);
		panel_9.add(SuccessLabel);
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
				
				Connection conn = SqlServerConnection.dbConnecter();
				
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
				JOptionPane.showMessageDialog(null, "Entered Lecturer ID is already in the system!" + '\n' + "  Check Your ID and try again!");
			}
				
			   refreshLecturerDetailsTable();
			}
		});
		
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(null);
		LeclayeredPane.add(panel2, "name_74288783095000");
		panel2.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(228,241,254));
		panel_2.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_2.setBounds(34, 34, 576, 445);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Manage Lecturer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setBounds(21, 10, 534, 425);
		panel_2.add(panel_13);
		panel_13.setLayout(null);
		
		lblNewLabel_33 = new JLabel("Registration Number  :");
		lblNewLabel_33.setBounds(31, 32, 142, 26);
		panel_13.add(lblNewLabel_33);
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton_5 = new JButton("Generate ID");
		btnNewButton_5.setBounds(228, 349, 171, 26);
		panel_13.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(30, 144, 255));
		
		txtRank2 = new JTextField();
		txtRank2.setForeground(new Color(138, 43, 226));
		txtRank2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRank2.setBounds(188, 385, 317, 19);
		panel_13.add(txtRank2);
		txtRank2.setEditable(false);
		txtRank2.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Rank  :");
		lblNewLabel_24.setForeground(new Color(138, 43, 226));
		lblNewLabel_24.setBounds(31, 380, 103, 26);
		panel_13.add(lblNewLabel_24);
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 14));
		
 
		txtFaculty2 = new JComboBox(faculty);
		txtFaculty2.setBounds(188, 117, 317, 21);
		panel_13.add(txtFaculty2);
		txtFaculty2.setBackground(Color.WHITE);
		txtFaculty2.setModel(new DefaultComboBoxModel(new String[] {"Faculty of Computing", "Faculty of Engineering", "Faculty of Business", "Faculty of Medicine", "Faculty of Archtecture", "Faculty of Humanties & Sciences", "Faculty of Graduate Studies and Research"}));
		txtFaculty2.setSelectedIndex(-1);
		txtFaculty2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNewLabel_1 = new JLabel("Lecturer Name :");
		lblNewLabel_1.setBounds(31, 74, 120, 23);
		panel_13.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_18 = new JLabel("Faculty  :");
		lblNewLabel_18.setBounds(31, 113, 122, 26);
		panel_13.add(lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_19 = new JLabel("Department  :");
		lblNewLabel_19.setBounds(29, 154, 122, 26);
		panel_13.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_20 = new JLabel("Campus  :");
		lblNewLabel_20.setBounds(31, 202, 122, 17);
		panel_13.add(lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_21 = new JLabel("Building  :");
		lblNewLabel_21.setBounds(29, 239, 122, 26);
		panel_13.add(lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_22 = new JLabel("Lecturer ID  :");
		lblNewLabel_22.setBounds(31, 278, 122, 26);
		panel_13.add(lblNewLabel_22);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_23 = new JLabel("Level  :");
		lblNewLabel_23.setBounds(31, 314, 103, 26);
		panel_13.add(lblNewLabel_23);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		txtLevel2 = new JComboBox(level);
		txtLevel2.setBounds(188, 318, 317, 21);
		panel_13.add(txtLevel2);
		txtLevel2.setBackground(Color.WHITE);
		txtLevel2.setSelectedIndex(-1);
		txtLevel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtLecturerID2 = new JTextField();
		txtLecturerID2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				//validate to only add 6 numbers only
				
				if(txtLecturerID2.getText().length()>5)
				{
					//canit able to enter in text field if entered number length is greater than 6
					txtLecturerID2.setEditable(true);
					//set error massage :
					onlyIndexLabel1.setText("*Invalid ID! Hint:ID cannot have more than 6 digits!");
				}
				else if(txtLecturerID2.getText().length()==5)
				{
					
					txtLecturerID2.setEditable(true);
					onlyIndexLabel1.setText("*Valid ID!");
				}
				else {
					
					txtLecturerID2.setEditable(true);
					onlyIndexLabel1.setText("");
				}
				
				
		
				
			}
		});
		txtLecturerID2.setBounds(188, 283, 317, 19);
		panel_13.add(txtLecturerID2);
		txtLecturerID2.setColumns(10);
		
		
		txtBuilding2 = new JComboBox(buildingNumber);
		txtBuilding2.setBounds(188, 243, 317, 21);
		panel_13.add(txtBuilding2);
		txtBuilding2.setModel(new DefaultComboBoxModel(new String[] {"New building", "D-block", "Engineering Building", "Business Management Building", "nursing Building", "Archtecture Building"}));
		txtBuilding2.setSelectedIndex(-1);
		txtBuilding2.setBackground(Color.WHITE);
		txtBuilding2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCampus2 = new JComboBox(campus);
		txtCampus2.setBounds(188, 201, 317, 21);
		panel_13.add(txtCampus2);
		txtCampus2.setModel(new DefaultComboBoxModel(new String[] {"Malabe", "Metro", "Matara", "Kandy", "Kurunagala", "Jaffna"}));
		txtCampus2.setSelectedIndex(-1);
		txtCampus2.setBackground(Color.WHITE);
		txtCampus2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtDepartment2 = new JComboBox(department);
		txtDepartment2.setBounds(188, 158, 317, 21);
		panel_13.add(txtDepartment2);
		txtDepartment2.setModel(new DefaultComboBoxModel(new String[] {"Department of Information Technology", "Department of Computer Systems Engineering", "Department of Computer Science & Software Engineering", "Department of Business Management", "Department of Business Management", "Department of nursing", "Department of Archtecture"}));
		txtDepartment2.setSelectedIndex(-1);
		txtDepartment2.setBackground(Color.WHITE);
		txtDepartment2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtLecturerName2 = new JTextField();
		txtLecturerName2.setBounds(188, 77, 317, 19);
		panel_13.add(txtLecturerName2);
		txtLecturerName2.setColumns(10);
		
		txtLecturerRegistrationNumber = new JTextField();
		txtLecturerRegistrationNumber.setEditable(false);
		txtLecturerRegistrationNumber.setBounds(188, 37, 317, 19);
		panel_13.add(txtLecturerRegistrationNumber);
		txtLecturerRegistrationNumber.setColumns(10);
		
		onlyIndexLabel1 = new JLabel("");
		onlyIndexLabel1.setBounds(188, 326, 328, 13);
		panel_13.add(onlyIndexLabel1);
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
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(228,241,254));
		panel_3.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_3.setBounds(614, 34, 654, 445);
		panel2.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setForeground(new Color(255, 255, 255));
		panel_14.setBackground(new Color(255, 255, 255));
		panel_14.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_14.setBounds(20, 10, 612, 424);
		panel_3.add(panel_14);
		panel_14.setLayout(null);
		
		LecturerDetailsComboBox = new JComboBox();
		LecturerDetailsComboBox.setBounds(20, 36, 235, 22);
		panel_14.add(LecturerDetailsComboBox);
		LecturerDetailsComboBox.setBackground(new Color(255, 255, 255));
		LecturerDetailsComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_35 = new JLabel("Select Your Name In Here :");
		lblNewLabel_35.setForeground(new Color(138, 43, 226));
		lblNewLabel_35.setBounds(20, 21, 181, 13);
		panel_14.add(lblNewLabel_35);
		lblNewLabel_35.setBackground(new Color(255, 255, 255));
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		btnLoadLecturerDetails = new JButton("Load Lecturer Details");
		btnLoadLecturerDetails.setBounds(410, 33, 179, 26);
		panel_14.add(btnLoadLecturerDetails);
		btnLoadLecturerDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoadLecturerDetails.setForeground(Color.WHITE);
		btnLoadLecturerDetails.setBackground(new Color(255, 140, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 76, 569, 327);
		panel_14.add(scrollPane);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		
		LecDetailstable = new JTable();
		LecDetailstable.setFont(new Font("Tahoma", Font.BOLD, 12));
		LecDetailstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		LecDetailstable.setSelectionBackground(new Color(107,185,240));
		LecDetailstable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		LecDetailstable.getTableHeader().setOpaque(false);
		LecDetailstable.getTableHeader().setBackground(new Color(32,136,203));
		LecDetailstable.getTableHeader().setForeground(new Color(255,255,255,255));
		LecDetailstable.setRowHeight(30);
		
		LecDetailstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		btnLoadLecturerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		LecturerDetailsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1185, 124, 5, 22);
		panel2.add(textArea);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(10, 0, 1281, 530);
		panel2.add(panel_12);
		panel_12.setLayout(null);
		
		btnNewButton_6 = new JButton("Update Details");
		btnNewButton_6.setBounds(341, 486, 208, 35);
		panel_12.add(btnNewButton_6);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(27,163,156));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_7 = new JButton("Delete Details");
		btnNewButton_7.setBounds(757, 487, 211, 35);
		panel_12.add(btnNewButton_7);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNewButton_8 = new JButton("Clear All");
		btnNewButton_8.setBounds(559, 487, 192, 35);
		panel_12.add(btnNewButton_8);
		btnNewButton_8.setBackground(new Color(58,83,155));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_8.setForeground(Color.WHITE);
		
		lblNewLabel_41 = new JLabel("-  Manage Lecturer Details  -");
		lblNewLabel_41.setForeground(new Color(0, 0, 139));
		lblNewLabel_41.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_41.setBounds(549, 0, 321, 35);
		panel_12.add(lblNewLabel_41);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				onlyIndexLabel1.setText("");
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
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete lecturer details  :
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Inserted data into the table :
				
				  try {
					  
					  Connection conn = SqlServerConnection.dbConnecter();
						
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
		
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setForeground(Color.BLACK);
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(228,241,254));
		panel_4.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_4.setBounds(29, 28, 520, 283);
		panel3.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_15.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lecture Details :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_15.setBounds(20, 10, 477, 266);
		panel_4.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_36 = new JLabel("You can't change Lecturer Name and Lecturer ID in here ! ! !");
		lblNewLabel_36.setBackground(new Color(0, 0, 0));
		lblNewLabel_36.setBounds(35, 44, 384, 13);
		panel_15.add(lblNewLabel_36);
		lblNewLabel_36.setForeground(new Color(255, 0, 0));
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_25 = new JLabel("Lecturer ID :");
		lblNewLabel_25.setBounds(35, 180, 116, 13);
		panel_15.add(lblNewLabel_25);
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLecturerID3 = new JTextField();
		txtLecturerID3.setBounds(177, 175, 263, 26);
		panel_15.add(txtLecturerID3);
		txtLecturerID3.setEditable(false);
		txtLecturerID3.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Lecturer Name:");
		lblNewLabel_2.setBounds(35, 100, 132, 16);
		panel_15.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLecturerName3 = new JTextField();
		txtLecturerName3.setBounds(177, 97, 263, 26);
		panel_15.add(txtLecturerName3);
		txtLecturerName3.setEditable(false);
		txtLecturerName3.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(228,241,254));
		panel_5.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_5.setBounds(559, 28, 555, 283);
		panel3.add(panel_5);
		panel_5.setLayout(null);
		
		panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Manage Active Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_16.setBounds(20, 10, 514, 266);
		panel_5.add(panel_16);
		panel_16.setLayout(null);
		
		lblNewLabel_27 = new JLabel("Tuesday  :");
		lblNewLabel_27.setBounds(43, 61, 94, 20);
		panel_16.add(lblNewLabel_27);
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_29 = new JLabel("Thursday  :");
		lblNewLabel_29.setBounds(43, 121, 94, 29);
		panel_16.add(lblNewLabel_29);
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_31 = new JLabel("Satarday  :");
		lblNewLabel_31.setBounds(43, 190, 124, 29);
		panel_16.add(lblNewLabel_31);
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_30 = new JLabel("Friday  :");
		lblNewLabel_30.setBounds(43, 160, 94, 20);
		panel_16.add(lblNewLabel_30);
		lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSunday3 = new JTextField();
		txtSunday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtSunday3.getText());
				
				
				if(!match.matches())
				{
					InvalidSunday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidSunday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidSunday2.setText("");
					
				}
				
				
			}
		});
		txtSunday3.setBounds(170, 226, 312, 20);
		panel_16.add(txtSunday3);
		txtSunday3.setColumns(10);
		
		txtFriday3 = new JTextField();
		txtFriday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtFriday3.getText());
				
				
				if(!match.matches())
				{
					InvalidFriday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidFriday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidFriday2.setText("");
					
				}
				
			}
		});
		txtFriday3.setBounds(170, 162, 312, 19);
		panel_16.add(txtFriday3);
		txtFriday3.setColumns(10);
		
		txtThursday3 = new JTextField();
		txtThursday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtThursday3.getText());
				
				
				if(!match.matches())
				{
					InvalidThursday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidThursday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidThursday2.setText("");
					
				}
				
				
			}
		});
		txtThursday3.setBounds(170, 127, 312, 20);
		panel_16.add(txtThursday3);
		txtThursday3.setColumns(10);
		
		lblNewLabel_28 = new JLabel("Wednesday  :");
		lblNewLabel_28.setBounds(43, 93, 94, 20);
		panel_16.add(lblNewLabel_28);
		lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtWednesday3 = new JTextField();
		txtWednesday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtWednesday3.getText());
				
				
				if(!match.matches())
				{
					InvalidWednesday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidWednesday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidWednesday2.setText("");
					
				}
				
				
				
			}
		});
		txtWednesday3.setBounds(170, 93, 312, 20);
		panel_16.add(txtWednesday3);
		txtWednesday3.setColumns(10);
		
		txtTuesday3 = new JTextField();
		txtTuesday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtTuesday3.getText());
				
				
				if(!match.matches())
				{
					InvalidTuesday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidTuesday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidTuesday2.setText("");
					
				}
				
				
				
			}
		});
		txtTuesday3.setBounds(170, 63, 312, 20);
		panel_16.add(txtTuesday3);
		txtTuesday3.setColumns(10);
		
		lblNewLabel_26 = new JLabel("Monday  :");
		lblNewLabel_26.setBounds(43, 31, 94, 20);
		panel_16.add(lblNewLabel_26);
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtMonday3 = new JTextField();
		txtMonday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtMonday3.getText());
				
				
				if(!match.matches())
				{
					InvalidMonday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidMonday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidMonday2.setText("");
					
				}
				
				
				
			}
		});
		txtMonday3.setBounds(170, 33, 312, 20);
		panel_16.add(txtMonday3);
		txtMonday3.setColumns(10);
		
		txtSatarday3 = new JTextField();
		txtSatarday3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String PATTERN ="([0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9] || [-])" ;
				
				
				Pattern patt = Pattern.compile(PATTERN);
				
				
				Matcher match = patt.matcher(txtSatarday3.getText());
				
				
				if(!match.matches())
				{
					InvalidSatarday2.setText("Incorrect Format !");
				}
				else if(match.matches()) {
					
					InvalidSatarday2.setText("Correct Format !");
					
				}
				
				else
				{
					InvalidSatarday2.setText("");
					
				}
				
			}
		});
		txtSatarday3.setBounds(170, 196, 312, 20);
		panel_16.add(txtSatarday3);
		txtSatarday3.setColumns(10);
		
		lblNewLabel_32 = new JLabel("Sunday  :");
		lblNewLabel_32.setBounds(43, 221, 117, 27);
		panel_16.add(lblNewLabel_32);
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		InvalidMonday2 = new JLabel("");
		InvalidMonday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidMonday2.setForeground(Color.RED);
		InvalidMonday2.setBounds(391, 48, 91, 20);
		panel_16.add(InvalidMonday2);
		
		InvalidTuesday2 = new JLabel("");
		InvalidTuesday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidTuesday2.setForeground(Color.RED);
		InvalidTuesday2.setBounds(391, 78, 91, 17);
		panel_16.add(InvalidTuesday2);
		
		InvalidWednesday2 = new JLabel("");
		InvalidWednesday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidWednesday2.setForeground(Color.RED);
		InvalidWednesday2.setBounds(391, 113, 91, 13);
		panel_16.add(InvalidWednesday2);
		
		InvalidThursday2 = new JLabel("");
		InvalidThursday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidThursday2.setForeground(Color.RED);
		InvalidThursday2.setBounds(391, 149, 91, 13);
		panel_16.add(InvalidThursday2);
		
		InvalidFriday2 = new JLabel("");
		InvalidFriday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidFriday2.setForeground(Color.RED);
		InvalidFriday2.setBounds(391, 172, 91, 29);
		panel_16.add(InvalidFriday2);
		
		InvalidSatarday2 = new JLabel("");
		InvalidSatarday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidSatarday2.setForeground(Color.RED);
		InvalidSatarday2.setBounds(391, 211, 91, 20);
		panel_16.add(InvalidSatarday2);
		
		InvalidSunday2 = new JLabel("");
		InvalidSunday2.setFont(new Font("Tahoma", Font.BOLD, 9));
		InvalidSunday2.setForeground(Color.RED);
		InvalidSunday2.setBounds(391, 241, 91, 17);
		panel_16.add(InvalidSunday2);
		
		lblNewLabel_38 = new JLabel("Example :  11.00 a.m - 1.00 p.m    OR    \" - \" mark for free days");
		lblNewLabel_38.setForeground(new Color(0, 128, 0));
		lblNewLabel_38.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_38.setBounds(153, 10, 329, 20);
		panel_16.add(lblNewLabel_38);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(228,241,254));
		panel_6.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_6.setBounds(29, 321, 1085, 217);
		panel3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(105, 41, 878, 151);
		panel_6.add(scrollPane_1);
		
		ActiveHoursDetailstable = new JTable();
		ActiveHoursDetailstable.setFont(new Font("Tahoma", Font.BOLD, 12));
		ActiveHoursDetailstable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ActiveHoursDetailstable.setSelectionBackground(new Color(107,185,240));
		ActiveHoursDetailstable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		ActiveHoursDetailstable.getTableHeader().setOpaque(false);
		ActiveHoursDetailstable.getTableHeader().setBackground(new Color(32,136,203));
		ActiveHoursDetailstable.getTableHeader().setForeground(new Color(255,255,255,255));
		ActiveHoursDetailstable.setRowHeight(30);
		
		ActiveHoursDetailstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		
		panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(112, 128, 144)));
		panel_17.setBackground(new Color(255, 255, 255));
		panel_17.setBounds(25, 10, 1033, 195);
		panel_6.add(panel_17);
		panel_17.setLayout(null);
		
		btnLoadActiveHoursDetails = new JButton("Load Details");
		btnLoadActiveHoursDetails.setBounds(820, 8, 140, 19);
		panel_17.add(btnLoadActiveHoursDetails);
		btnLoadActiveHoursDetails.setForeground(Color.WHITE);
		btnLoadActiveHoursDetails.setBackground(new Color(255, 127, 80));
		btnLoadActiveHoursDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_17 = new JLabel("Search Your  Name In Here :");
		lblNewLabel_17.setForeground(new Color(138, 43, 226));
		lblNewLabel_17.setBounds(83, 11, 210, 13);
		panel_17.add(lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ActiveHoursComboBox = new JComboBox();
		ActiveHoursComboBox.setBounds(262, 10, 196, 16);
		panel_17.add(ActiveHoursComboBox);
		ActiveHoursComboBox.setBackground(Color.WHITE);
		ActiveHoursComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Get selected comobox value to the form :
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		btnLoadActiveHoursDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
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
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(10, 0, 1295, 549);
		panel3.add(panel_10);
		panel_10.setLayout(null);
		
		btnNewButton_9 = new JButton("Clear All");
		btnNewButton_9.setBounds(1109, 284, 177, 34);
		panel_10.add(btnNewButton_9);
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvalidMonday2.setText("");
				InvalidTuesday2.setText("");
				InvalidWednesday2.setText("");
				InvalidThursday2.setText("");
				InvalidFriday2.setText("");
				InvalidSatarday2.setText("");
				InvalidSunday2.setText("");
				
				
				
				
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
		
		lblNewLabel_42 = new JLabel("-  Manage Active Hours  -");
		lblNewLabel_42.setForeground(new Color(0, 0, 139));
		lblNewLabel_42.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_42.setBounds(456, 10, 275, 13);
		panel_10.add(lblNewLabel_42);
		
		btnNewButton_10 = new JButton("Update Details");
		btnNewButton_10.setBounds(1109, 247, 177, 34);
		panel_10.add(btnNewButton_10);
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_10.setBackground(new Color(27,163,156));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update Active hours details :
				
				  try {
					  
					  Connection conn = SqlServerConnection.dbConnecter();
						
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
		
		btnNewButton = new JButton("ADD Details");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(58, 83, 155));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPannels(panel1);
			}
		});
		btnNewButton.setBounds(42, 95, 207, 33);
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
		btnNewButton_1.setBounds(259, 95, 233, 33);
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
		btnNewButton_2.setBounds(502, 95, 218, 33);
		contentPane.add(btnNewButton_2);
		
		//Header 
		
		panel_7 = new JPanel();
		panel_7.setForeground(Color.WHITE);
		panel_7.setBackground(new Color(75, 119, 190));
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel_7.setBounds(10, 10, 1336, 75);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_34 = new JLabel("Timetable Management System");
		lblNewLabel_34.setForeground(Color.WHITE);
		lblNewLabel_34.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_34.setBounds(516, 21, 660, 44);
		panel_7.add(lblNewLabel_34);
		
		JButton btnNewButton_11 = new JButton("Back To Home");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePage sub = new HomePage();
				sub.show();
				
			}
		});
		btnNewButton_11.setBackground(new Color(30, 144, 255));
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_11.setBounds(1188, 89, 158, 33);
		contentPane.add(btnNewButton_11);
		
		refreshLecturerDetailsTable();
		refreshActiveHoursTable();
		
		fillLecturerComboBox();
		fillActiveHoursComboBox();
	}
}
