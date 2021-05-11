package room;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import room.MainAddRoom;
import room.DispalyRooms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class addrooms extends JFrame {

	private JPanel contentPane;
	private JLabel txtrTimeTableManagement;
	Connection connection =null;
	private JComboBox comboBoxSession;
	private JComboBox roomcombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addrooms frame = new addrooms();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//dropdown list for session
	public void fillComBox()
	{
		try {
			connection = SqlServerConnection.dbConnecter();
			
			String sql="select * from session";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()){
				comboBoxSession.addItem(rs.getString("SessionId"));
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	//dropdown list for rooms
	/*public void fillComBox1()
	{
		try {
			
			connection = SqlServerConnection.dbConnecter();
			
			String sql="select RoomName from addLocation";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
		
			while(rs.next()){
			
				roomcombo.addLocation(rs.getString("rooms"));
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}*/
	
	

	/**
	 * Create the frame.
	 */
	public addrooms() {
		
		connection = SqlServerConnection.dbConnecter();
		
		//creating the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//header 
		JPanel panelHeader = new JPanel();
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(79, 105, 1161, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Session rooms");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(31, 30, 333, 79);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Session");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(135, 138, 193, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Room");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(135, 202, 193, 54);
		panel.add(lblNewLabel_2);
		
		JButton addroombtn = new JButton("Add Room");
		addroombtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addroombtn.setBackground(new Color(0, 0, 128));
		addroombtn.setForeground(new Color(255, 255, 255));
		addroombtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {	
				
				/*try {
					
					
					//String 	query="insert into addLocationFinal(SessionID,RoomName) values(?,?)";
					//PreparedStatement pstst=connection.prepareStatement(query);
					
					/*pstst.setString(1,SessionId.getText());
					pstst.setString(2,RoomName.getText());
					
					//data insertion success message;
					pstst.execute();
					JOptionPane.showMessageDialog(null,"Data Insertion sucessfully!...");
					
					
					
					pstst.close();
				
				}catch(Exception e1){
					
					e1.printStackTrace();
					
					
				}*/
					
					
				}
			
		});
		addroombtn.setBounds(599, 388, 132, 45);
		panel.add(addroombtn);
		
		comboBoxSession = new JComboBox();
		comboBoxSession.setForeground(new Color(0, 0, 0));
		comboBoxSession.setToolTipText("");
		comboBoxSession.setBounds(322, 138, 489, 34);
		panel.add(comboBoxSession);
		
		roomcombo = new JComboBox();
		roomcombo.setForeground(new Color(0, 0, 0));
		roomcombo.setToolTipText("");
		roomcombo.setBounds(322, 215, 489, 34);
		panel.add(roomcombo);
		
		JButton backbtn = new JButton("Back ");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainAddRoom main1 = new MainAddRoom();
				main1.show();
			}
		});
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBackground(Color.BLACK);
		backbtn.setBounds(960, 389, 153, 41);
		panel.add(backbtn);
		
		JButton viewbtn = new JButton("View");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DispalyRooms dispalyRooms =new DispalyRooms();
				dispalyRooms.show();
			}
		});
		viewbtn.setForeground(Color.WHITE);
		viewbtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		viewbtn.setBackground(new Color(210, 77, 87));
		viewbtn.setBounds(767, 388, 153, 45);
		panel.add(viewbtn);
	
		fillComBox();
		//fillComBox1();
	}
	
}
