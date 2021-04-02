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
		LeclayeredPane.setBounds(46, 145, 1484, 641);
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
		panel.setBounds(36, 24, 707, 523);
		panel1.add(panel);
		panel.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setForeground(new Color(255, 255, 255));
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Lecturer Details :", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_8.setBounds(31, 25, 631, 459);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		btnGenerateID = new JButton("Generate ID");
		btnGenerateID.setFocusTraversalKeysEnabled(false);
		btnGenerateID.setFocusPainted(false);
		btnGenerateID.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenerateID.setForeground(Color.WHITE);
		btnGenerateID.setBounds(312, 349, 171, 44);
		panel_8.add(btnGenerateID);
		btnGenerateID.setBackground(new Color(58, 83, 155));
		
		lblNewLabel = new JLabel("Lecturer Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(67, 49, 133, 13);
		panel_8.add(lblNewLabel);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setBounds(210, 46, 360, 19);
		panel_8.add(txtLecturerName);
		txtLecturerName.setColumns(10);
		
		txtCampus = new JComboBox(campus);
		txtCampus.setBackground(Color.WHITE);
		txtCampus.setSelectedIndex(-1);
		txtCampus.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCampus.setBounds(210, 175, 360, 21);
		panel_8.add(txtCampus);

		
		JLabel lblNewLabel_5 = new JLabel("Campus/Center  :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(67, 179, 104, 13);
		panel_8.add(lblNewLabel_5);
		
		lblLecturerName = new JLabel("");
		lblLecturerName.setForeground(Color.RED);
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLecturerName.setBounds(210, 64, 174, 13);
		panel_8.add(lblLecturerName);
		
		lblFaculty = new JLabel("");
		lblFaculty.setForeground(Color.RED);
		lblFaculty.setBounds(210, 110, 174, 13);
		panel_8.add(lblFaculty);
		
		lblDepartment = new JLabel("");
		lblDepartment.setForeground(Color.RED);
		lblDepartment.setBounds(210, 152, 173, 13);
		panel_8.add(lblDepartment);
		
		lblCampus = new JLabel("");
		lblCampus.setForeground(Color.RED);
		lblCampus.setBounds(210, 196, 174, 13);
		panel_8.add(lblCampus);
		
		lblBuilding = new JLabel("");
		lblBuilding.setForeground(Color.RED);
		lblBuilding.setBounds(210, 245, 174, 13);
		panel_8.add(lblBuilding);
		
		lblLecturerID = new JLabel("");
		lblLecturerID.setForeground(Color.RED);
		lblLecturerID.setBounds(210, 295, 91, 13);
		panel_8.add(lblLecturerID);
		
		lblLevel = new JLabel("");
		lblLevel.setForeground(Color.RED);
		lblLevel.setBounds(210, 349, 67, 13);
		panel_8.add(lblLevel);
		
		onlyIndexLabel = new JLabel("");
		onlyIndexLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		onlyIndexLabel.setForeground(Color.RED);
		onlyIndexLabel.setBounds(210, 295, 236, 13);
		panel_8.add(onlyIndexLabel);
		
		txtFaculty = new JComboBox(faculty);
		txtFaculty.setBounds(212, 87, 358, 21);
		panel_8.add(txtFaculty);
		txtFaculty.setBackground(Color.WHITE);
		txtFaculty.setSelectedIndex(-1);
		txtFaculty.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtDepartment = new JComboBox(department);
		txtDepartment.setBounds(210, 133, 360, 21);
		panel_8.add(txtDepartment);
		txtDepartment.setBackground(Color.WHITE);
		txtDepartment.setSelectedIndex(-1);
		txtDepartment.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtBuilding = new JComboBox(buildingNumber);
		txtBuilding.setBounds(210, 219, 360, 21);
		panel_8.add(txtBuilding);
		txtBuilding.setSelectedIndex(-1);
		txtBuilding.setBackground(Color.WHITE);
		txtBuilding.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtLecturerID = new JTextField();
		txtLecturerID.setBounds(210, 266, 360, 19);
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
		txtLevel.setBounds(210, 318, 360, 21);
		panel_8.add(txtLevel);
		txtLevel.setSelectedIndex(-1);
		txtLevel.setBackground(Color.WHITE);
		txtLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		txtRank = new JTextField();
		txtRank.setBounds(210, 403, 360, 26);
		panel_8.add(txtRank);
		txtRank.setEditable(false);
		txtRank.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Faculty  :");
		lblNewLabel_3.setBounds(67, 91, 91, 13);
		panel_8.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(67, 137, 91, 13);
		panel_8.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_6 = new JLabel("Building  :");
		lblNewLabel_6.setBounds(67, 223, 114, 13);
		panel_8.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer ID  :");
		lblNewLabel_7.setBounds(67, 269, 91, 13);
		panel_8.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_8 = new JLabel("Level  :");
		lblNewLabel_8.setBounds(67, 322, 45, 13);
		panel_8.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_9 = new JLabel("Rank  :");
		lblNewLabel_9.setBounds(67, 409, 104, 13);
		panel_8.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		panel_1.setForeground(new Color(224, 255, 255));
		panel_1.setBackground(new Color(228,241,254));
		panel_1.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_1.setBounds(753, 24, 639, 523);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Active days and Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_9.setBounds(43, 25, 554, 454);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Sunday  :");
		lblNewLabel_16.setBounds(81, 358, 92, 13);
		panel_9.add(lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_15 = new JLabel("Satarday  :");
		lblNewLabel_15.setBounds(81, 312, 92, 13);
		panel_9.add(lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_14 = new JLabel("Friday  :");
		lblNewLabel_14.setBounds(81, 265, 92, 13);
		panel_9.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_13 = new JLabel("Thursday  :");
		lblNewLabel_13.setBounds(81, 217, 92, 13);
		panel_9.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_12 = new JLabel("Wednesday  :");
		lblNewLabel_12.setBounds(81, 168, 92, 13);
		panel_9.add(lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_11 = new JLabel("Tuesday  :");
		lblNewLabel_11.setBounds(81, 116, 92, 13);
		panel_9.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSunday = new JTextField();
		txtSunday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				
			}
		});
		txtSunday.setBounds(212, 356, 300, 19);
		panel_9.add(txtSunday);
		txtSunday.setColumns(10);
		
		txtSatarday = new JTextField();
		txtSatarday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		txtSatarday.setBounds(212, 310, 300, 19);
		panel_9.add(txtSatarday);
		txtSatarday.setColumns(10);
		
		txtFriday = new JTextField();
		txtFriday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				
				
			}
		});
		txtFriday.setBounds(212, 263, 300, 19);
		panel_9.add(txtFriday);
		txtFriday.setColumns(10);
		
		txtThursday = new JTextField();
		txtThursday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			}
		});
		txtThursday.setBounds(212, 215, 300, 19);
		panel_9.add(txtThursday);
		txtThursday.setColumns(10);
		
		txtWednesday = new JTextField();
		txtWednesday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			
				
				
			}
		});
		txtWednesday.setBounds(212, 166, 300, 19);
		panel_9.add(txtWednesday);
		txtWednesday.setColumns(10);
		
		txtTuesday = new JTextField();
		txtTuesday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			
			}
		});
		txtTuesday.setBounds(212, 114, 300, 19);
		panel_9.add(txtTuesday);
		txtTuesday.setColumns(10);
		
		txtMonday = new JTextField();
		txtMonday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
		
				
			}
		});
		txtMonday.setBounds(215, 65, 297, 19);
		panel_9.add(txtMonday);
		txtMonday.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Monday  :");
		lblNewLabel_10.setBounds(81, 67, 92, 13);
		panel_9.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_37 = new JLabel("example : 11.00 a.m - 1.00 p.m");
		lblNewLabel_37.setBounds(215, 42, 297, 13);
		panel_9.add(lblNewLabel_37);
		
		InvalidMonday = new JLabel("");
		InvalidMonday.setForeground(Color.RED);
		InvalidMonday.setBounds(407, 91, 105, 13);
		panel_9.add(InvalidMonday);
		
		InvalidTuesday = new JLabel("");
		InvalidTuesday.setForeground(Color.RED);
		InvalidTuesday.setBounds(407, 137, 105, 19);
		panel_9.add(InvalidTuesday);
		
		InvalidWednesday = new JLabel("");
		InvalidWednesday.setForeground(Color.RED);
		InvalidWednesday.setBounds(407, 192, 105, 13);
		panel_9.add(InvalidWednesday);
		
		InvalidThursday = new JLabel("");
		InvalidThursday.setForeground(Color.RED);
		InvalidThursday.setBounds(407, 240, 105, 13);
		panel_9.add(InvalidThursday);
		
		InvalidFriday = new JLabel("");
		InvalidFriday.setForeground(Color.RED);
		InvalidFriday.setBounds(407, 287, 105, 13);
		panel_9.add(InvalidFriday);
		
		InvalidSatarday = new JLabel("");
		InvalidSatarday.setForeground(Color.RED);
		InvalidSatarday.setBounds(407, 333, 105, 13);
		panel_9.add(InvalidSatarday);
		
		InvalidSunday = new JLabel("");
		InvalidSunday.setForeground(Color.RED);
		InvalidSunday.setBounds(407, 385, 105, 13);
		panel_9.add(InvalidSunday);
		
		JPanel panel_11 = new JPanel();
		panel_11.setForeground(new Color(224, 255, 255));
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(10, 10, 1412, 621);
		panel1.add(panel_11);
		panel_11.setLayout(null);
		
		btnNewButton_4 = new JButton("Clear  ");
		btnNewButton_4.setBounds(744, 547, 199, 48);
		panel_11.add(btnNewButton_4);
		btnNewButton_4.setFocusTraversalKeysEnabled(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		btnNewButton_3.setBounds(528, 548, 208, 48);
		panel_11.add(btnNewButton_3);
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
		panel_2.setBounds(21, 27, 600, 518);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Manage Lecturer Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_13.setBackground(new Color(255, 255, 255));
		panel_13.setBounds(33, 24, 539, 470);
		panel_2.add(panel_13);
		panel_13.setLayout(null);
		
		lblNewLabel_33 = new JLabel("Registration Number  :");
		lblNewLabel_33.setBounds(31, 44, 142, 26);
		panel_13.add(lblNewLabel_33);
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton_5 = new JButton("Generate ID");
		btnNewButton_5.setBounds(266, 374, 167, 39);
		panel_13.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(58,83,155));
		
		txtRank2 = new JTextField();
		txtRank2.setBounds(188, 423, 326, 19);
		panel_13.add(txtRank2);
		txtRank2.setEditable(false);
		txtRank2.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Rank  :");
		lblNewLabel_24.setBounds(31, 418, 103, 26);
		panel_13.add(lblNewLabel_24);
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		
 
		txtFaculty2 = new JComboBox(faculty);
		txtFaculty2.setBounds(188, 134, 326, 21);
		panel_13.add(txtFaculty2);
		txtFaculty2.setBackground(Color.WHITE);
		txtFaculty2.setSelectedIndex(-1);
		txtFaculty2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNewLabel_1 = new JLabel("Lecturer Name :");
		lblNewLabel_1.setBounds(31, 87, 120, 23);
		panel_13.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_18 = new JLabel("Faculty  :");
		lblNewLabel_18.setBounds(31, 130, 122, 26);
		panel_13.add(lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_19 = new JLabel("Department  :");
		lblNewLabel_19.setBounds(31, 171, 122, 26);
		panel_13.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_20 = new JLabel("Campus  :");
		lblNewLabel_20.setBounds(31, 219, 122, 17);
		panel_13.add(lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_21 = new JLabel("Building  :");
		lblNewLabel_21.setBounds(31, 257, 122, 26);
		panel_13.add(lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_22 = new JLabel("Lecturer ID  :");
		lblNewLabel_22.setBounds(31, 299, 122, 26);
		panel_13.add(lblNewLabel_22);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel_23 = new JLabel("Level  :");
		lblNewLabel_23.setBounds(31, 349, 103, 26);
		panel_13.add(lblNewLabel_23);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		txtLevel2 = new JComboBox(level);
		txtLevel2.setBounds(188, 343, 326, 21);
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
		txtLecturerID2.setBounds(188, 304, 326, 19);
		panel_13.add(txtLecturerID2);
		txtLecturerID2.setColumns(10);
		
		
		txtBuilding2 = new JComboBox(buildingNumber);
		txtBuilding2.setBounds(188, 261, 326, 21);
		panel_13.add(txtBuilding2);
		txtBuilding2.setSelectedIndex(-1);
		txtBuilding2.setBackground(Color.WHITE);
		txtBuilding2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCampus2 = new JComboBox(campus);
		txtCampus2.setBounds(188, 218, 326, 21);
		panel_13.add(txtCampus2);
		txtCampus2.setSelectedIndex(-1);
		txtCampus2.setBackground(Color.WHITE);
		txtCampus2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtDepartment2 = new JComboBox(department);
		txtDepartment2.setBounds(188, 175, 326, 21);
		panel_13.add(txtDepartment2);
		txtDepartment2.setSelectedIndex(-1);
		txtDepartment2.setBackground(Color.WHITE);
		txtDepartment2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtLecturerName2 = new JTextField();
		txtLecturerName2.setBounds(188, 90, 326, 19);
		panel_13.add(txtLecturerName2);
		txtLecturerName2.setColumns(10);
		
		txtLecturerRegistrationNumber = new JTextField();
		txtLecturerRegistrationNumber.setBounds(188, 49, 326, 19);
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
		panel_3.setBounds(631, 27, 788, 518);
		panel2.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(58, 127, 673, 341);
		panel_3.add(scrollPane);
		
		LecDetailstable = new JTable();
		LecDetailstable.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		
		JPanel panel_14 = new JPanel();
		panel_14.setForeground(new Color(255, 255, 255));
		panel_14.setBackground(new Color(255, 255, 255));
		panel_14.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_14.setBounds(33, 24, 722, 466);
		panel_3.add(panel_14);
		panel_14.setLayout(null);
		
		LecturerDetailsComboBox = new JComboBox();
		LecturerDetailsComboBox.setBounds(25, 53, 235, 22);
		panel_14.add(LecturerDetailsComboBox);
		LecturerDetailsComboBox.setBackground(new Color(255, 255, 255));
		LecturerDetailsComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_35 = new JLabel("Select Your Name In Here :");
		lblNewLabel_35.setBounds(36, 30, 170, 13);
		panel_14.add(lblNewLabel_35);
		lblNewLabel_35.setBackground(new Color(255, 255, 255));
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		btnLoadLecturerDetails = new JButton("Load Table");
		btnLoadLecturerDetails.setBounds(517, 47, 179, 32);
		panel_14.add(btnLoadLecturerDetails);
		btnLoadLecturerDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1185, 124, 5, 22);
		panel2.add(textArea);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(10, 10, 1427, 621);
		panel2.add(panel_12);
		panel_12.setLayout(null);
		
		btnNewButton_6 = new JButton("Update Details");
		btnNewButton_6.setBounds(368, 545, 208, 48);
		panel_12.add(btnNewButton_6);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(27,163,156));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_7 = new JButton("Delete Details");
		btnNewButton_7.setBounds(788, 545, 211, 45);
		panel_12.add(btnNewButton_7);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(new Color(210,77,87));
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNewButton_8 = new JButton("Clear All");
		btnNewButton_8.setBounds(586, 543, 192, 48);
		panel_12.add(btnNewButton_8);
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
		
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setForeground(Color.BLACK);
		LeclayeredPane.add(panel3, "name_74339045343800");
		panel3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(228,241,254));
		panel_4.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_4.setBounds(107, 22, 545, 280);
		panel3.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_15.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lecture Details :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_15.setBounds(36, 10, 474, 260);
		panel_4.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_36 = new JLabel("You can't change Lecturer Name and Lecturer ID in here ! !");
		lblNewLabel_36.setBounds(25, 41, 384, 13);
		panel_15.add(lblNewLabel_36);
		lblNewLabel_36.setForeground(new Color(255, 0, 0));
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_25 = new JLabel("Lecturer ID :");
		lblNewLabel_25.setBounds(56, 180, 116, 13);
		panel_15.add(lblNewLabel_25);
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLecturerID3 = new JTextField();
		txtLecturerID3.setBounds(198, 175, 231, 26);
		panel_15.add(txtLecturerID3);
		txtLecturerID3.setEditable(false);
		txtLecturerID3.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Lecturer Name:");
		lblNewLabel_2.setBounds(56, 100, 132, 16);
		panel_15.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLecturerName3 = new JTextField();
		txtLecturerName3.setBounds(198, 97, 231, 26);
		panel_15.add(txtLecturerName3);
		txtLecturerName3.setEditable(false);
		txtLecturerName3.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(228,241,254));
		panel_5.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_5.setBounds(692, 22, 578, 280);
		panel3.add(panel_5);
		panel_5.setLayout(null);
		
		panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_16.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Manage Active Hours :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_16.setBounds(36, 12, 505, 258);
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
		txtSunday3.setBounds(170, 226, 292, 20);
		panel_16.add(txtSunday3);
		txtSunday3.setColumns(10);
		
		txtFriday3 = new JTextField();
		txtFriday3.setBounds(170, 162, 292, 19);
		panel_16.add(txtFriday3);
		txtFriday3.setColumns(10);
		
		txtThursday3 = new JTextField();
		txtThursday3.setBounds(170, 127, 292, 20);
		panel_16.add(txtThursday3);
		txtThursday3.setColumns(10);
		
		lblNewLabel_28 = new JLabel("Wednesday  :");
		lblNewLabel_28.setBounds(43, 93, 94, 20);
		panel_16.add(lblNewLabel_28);
		lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtWednesday3 = new JTextField();
		txtWednesday3.setBounds(170, 93, 292, 20);
		panel_16.add(txtWednesday3);
		txtWednesday3.setColumns(10);
		
		txtTuesday3 = new JTextField();
		txtTuesday3.setBounds(170, 63, 292, 20);
		panel_16.add(txtTuesday3);
		txtTuesday3.setColumns(10);
		
		lblNewLabel_26 = new JLabel("Monday  :");
		lblNewLabel_26.setBounds(43, 31, 94, 20);
		panel_16.add(lblNewLabel_26);
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtMonday3 = new JTextField();
		txtMonday3.setBounds(170, 33, 292, 20);
		panel_16.add(txtMonday3);
		txtMonday3.setColumns(10);
		
		txtSatarday3 = new JTextField();
		txtSatarday3.setBounds(170, 196, 292, 20);
		panel_16.add(txtSatarday3);
		txtSatarday3.setColumns(10);
		
		lblNewLabel_32 = new JLabel("Sunday  :");
		lblNewLabel_32.setBounds(43, 221, 117, 27);
		panel_16.add(lblNewLabel_32);
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(228,241,254));
		panel_6.setBorder(new LineBorder(new Color(135, 206, 250)));
		panel_6.setBounds(107, 312, 1163, 308);
		panel3.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(82, 68, 992, 218);
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
		
		panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(112, 128, 144)));
		panel_17.setBackground(new Color(255, 255, 255));
		panel_17.setBounds(38, 14, 1085, 284);
		panel_6.add(panel_17);
		panel_17.setLayout(null);
		
		btnLoadActiveHoursDetails = new JButton("Load Details");
		btnLoadActiveHoursDetails.setBounds(873, 10, 166, 35);
		panel_17.add(btnLoadActiveHoursDetails);
		btnLoadActiveHoursDetails.setForeground(Color.WHITE);
		btnLoadActiveHoursDetails.setBackground(new Color(58,83,155));
		btnLoadActiveHoursDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_17 = new JLabel("Search Your  Name In Here :");
		lblNewLabel_17.setBounds(51, 10, 204, 13);
		panel_17.add(lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ActiveHoursComboBox = new JComboBox();
		ActiveHoursComboBox.setBounds(51, 24, 190, 21);
		panel_17.add(ActiveHoursComboBox);
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
		btnNewButton_10.setBounds(1280, 281, 172, 45);
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
		btnNewButton_9.setBounds(1282, 347, 170, 45);
		panel3.add(btnNewButton_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(0, 10, 1462, 621);
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
		btnNewButton.setBounds(57, 102, 207, 44);
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
		btnNewButton_1.setBounds(287, 102, 233, 44);
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
		btnNewButton_2.setBounds(541, 102, 218, 44);
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
