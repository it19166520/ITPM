package locataion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.DBConnection;
import Home.HomePage;
import Home.ShankiHome;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import locataion.ManageLocation;

public class Location extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JTextPane txtpnAddLocation;
	private JLabel lblBuildingName;
	private JTextField textbuildingName;
	private JLabel lblRoomName;
	private JTextField textroom;
	private JLabel lblRoomType;
	private JRadioButton rdbtnLecRadioButton;
	private JRadioButton rdbtnLabRadioButton;
	private JLabel lblCapasity;
	private JTextField textCapacity;
	private JButton btnClear;
	private JButton btnSave;
	private JPanel panelHeader;
	private JLabel txtrTimeTableManagement;
	
	//JTable tableLocation;
	
	String roomtype;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnManageLoc;
	private JButton backbtn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Location frame = new Location();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//clear entered data
	public void ClearFields()
	{
		textroom.setText(null);
		textbuildingName.setText(null);
		textCapacity.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public Location() {
		
		connection = DBConnection.dbConnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpnAddLocation = new JTextPane();
		txtpnAddLocation.setBackground(Color.WHITE);
		txtpnAddLocation.setEditable(false);
		txtpnAddLocation.setText("Add Location");
		txtpnAddLocation.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnAddLocation.setBounds(556, 118, 198, 32);
		contentPane.add(txtpnAddLocation);
		
		lblBuildingName = new JLabel("Building Name:");
		lblBuildingName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuildingName.setBounds(302, 182, 158, 40);
		contentPane.add(lblBuildingName);
		
		textbuildingName = new JTextField();
		textbuildingName.setColumns(10);
		textbuildingName.setBounds(494, 185, 479, 40);
		contentPane.add(textbuildingName);
		
		lblRoomName = new JLabel("Room Name :");
		lblRoomName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomName.setBounds(302, 263, 158, 40);
		contentPane.add(lblRoomName);
		
		textroom = new JTextField();
		textroom.setColumns(10);
		textroom.setBounds(494, 266, 479, 40);
		contentPane.add(textroom);
		
		lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(302, 343, 135, 54);
		contentPane.add(lblRoomType);
		
		rdbtnLecRadioButton = new JRadioButton("Lectures");
		rdbtnLecRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomtype="Lecture";
			}
		});
		
		buttonGroup.add(rdbtnLecRadioButton);
		rdbtnLecRadioButton.setForeground(Color.WHITE);
		rdbtnLecRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLecRadioButton.setBackground(new Color(0, 0, 128));
		rdbtnLecRadioButton.setBounds(493, 353, 135, 40);
		contentPane.add(rdbtnLecRadioButton);
		
		rdbtnLabRadioButton = new JRadioButton("Laboratories");
		rdbtnLabRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomtype="Laboratories";
			}
		});
		
		buttonGroup.add(rdbtnLabRadioButton);
		rdbtnLabRadioButton.setForeground(Color.WHITE);
		rdbtnLabRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLabRadioButton.setBackground(new Color(0, 0, 128));
		rdbtnLabRadioButton.setBounds(768, 353, 158, 41);
		contentPane.add(rdbtnLabRadioButton);
		
		lblCapasity = new JLabel("Capacity :");
		lblCapasity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapasity.setBounds(302, 431, 135, 54);
		contentPane.add(lblCapasity);
		
		textCapacity = new JTextField();
		textCapacity.setColumns(10);
		textCapacity.setBounds(494, 431, 479, 40);
		contentPane.add(textCapacity);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearFields();
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBackground(new Color(0, 0, 139));
		btnClear.setBounds(545, 548, 169, 46);
		contentPane.add(btnClear);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				String 	query="insert into addLocation(BuildingName,RoomName,RoomType,Capacity) values(?,?,?,?)";
				PreparedStatement pstst=connection.prepareStatement(query);
				
				pstst.setString(1,textbuildingName.getText());
				pstst.setString(2,textroom.getText());
				
				pstst.setString(3,roomtype);
				pstst.setString(4,textCapacity.getText());
				
				//data insertion success message;
				pstst.execute();
				JOptionPane.showMessageDialog(null,"Data Insertion sucessfully!...");
				
				
				
				pstst.close();
				ClearFields();
				
			}catch(Exception e1){
				
				e1.printStackTrace();
				
				
			}
				

		
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBackground(new Color(27, 163, 156));
		btnSave.setBounds(785, 548, 169, 46);
		contentPane.add(btnSave);
		
	//header 
		panelHeader = new JPanel();
		panelHeader.setForeground(Color.WHITE);
		panelHeader.setBackground(new Color(75, 119, 190));
		panelHeader.setBounds(0, 0, 1365, 75);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		txtrTimeTableManagement = new JLabel("Time Table Management System");
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setBounds(401, 11, 510, 53);
		panelHeader.add(txtrTimeTableManagement);//end of header
		
		btnManageLoc = new JButton("Manage Location");
		btnManageLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageLocation ManageLocation = new ManageLocation();
				ManageLocation.show();
				
				try {
					
					//retrieve data to a table
					String query = "select * from addLocation";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					
					ManageLocation.tableLocation.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				
			}
		});
		btnManageLoc.setForeground(Color.WHITE);
		btnManageLoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageLoc.setBackground(new Color(27, 163, 156));
		btnManageLoc.setBounds(1067, 92, 252, 40);
		contentPane.add(btnManageLoc);
		
		backbtn = new JButton("Back");
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ShankiHome home=new ShankiHome();
				home.Show();*/
				
				HomePage home1 = new HomePage();
				home1.Show();
			
			
			}
			
		});
		backbtn.setBackground(Color.WHITE);
		backbtn.setFont(new Font("Leelawadee UI Semilight",Font.BOLD,16));
		backbtn.setFocusPainted(false);
		backbtn.setBackground(Color.black);
		backbtn.setBounds(1067,550,185,41);
		contentPane.add(backbtn);
		
		
		
	}
}
