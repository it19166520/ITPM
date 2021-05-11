package room;

import java.awt.BorderLayout;




import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.SqlServerConnection;

import room.MainAddRoom;
import room.DispalyRooms;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class addParallel extends JFrame {

	private JPanel contentPane;
	private JLabel txtrTimeTableManagement;
	Connection connection;
	private JComboBox comboxcon; 
	private JComboBox roomcombo2;
	private JComboBox comboParalle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addParallel frame = new addParallel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//dropdown list for consecative session
		public void fillComBox()
		{
			try {
				
				String sql="select * from ParallelSession";
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
			
				while(rs.next()){
				
					
					comboParalle.addItem(rs.getString("SessionId"));
					}
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
	
		//dropdown list for rooms
	
		public void fillComBox1()
		{
			try {
				
				connection = SqlServerConnection.dbConnecter();
				
				String sql="select * from addLocation";
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
			
				while(rs.next()){
				
					roomcombo2.addItem(rs.getString("RoomName"));
					}
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
	
	
	/**
	 * Create the frame.
	 */
	public addParallel() {
		
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
		
		JLabel lblNewLabel = new JLabel("Manage Session rooms Parallel Sessions");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(31, 30, 536, 79);
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
			
			//adding rooms parallel session(form suu)
			
				public void actionPerformed(ActionEvent e) {
					
					try {
					
					connection = SqlServerConnection.dbConnecter();
					
					String 	query="insert into ParallelSessionRoom(ParallelSessionID,ParallelSessionRoom) values(?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					String pasessionid =comboParalle.getSelectedItem().toString();
					pst.setString(1, pasessionid);
					
					String paroom=roomcombo2.getSelectedItem().toString();
					pst.setString(2, paroom);
					
					//data insertion success message;
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data Insertion sucessfully!...");
					
					
					
					pst.close();
				
				}catch(Exception e1){
					
					e1.printStackTrace();
					
					
				}
					
					
				}
			});
		
		addroombtn.setBounds(424, 388, 143, 45);
		panel.add(addroombtn);
	
		roomcombo2 = new JComboBox();
		roomcombo2.setBounds(322, 215, 489, 34);
		panel.add(roomcombo2);
		
		comboParalle = new JComboBox();
		comboParalle.setBounds(322, 149, 489, 34);
		panel.add(comboParalle);
		
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
		backbtn.setBounds(846, 387, 172, 45);
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
		viewbtn.setBounds(615, 387, 158, 45);
		panel.add(viewbtn);
		
		fillComBox();
		fillComBox1();
			
	}
		}


