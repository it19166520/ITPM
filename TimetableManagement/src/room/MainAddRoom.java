package room;

import java.awt.BorderLayout;




import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Home.HomePage;
import net.proteanit.sql.DbUtils;
import room.addroomcon;
import room.addParallel;
import room.addrooms;
import room.addroomsNonOverLapping;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DBConnection.SqlServerConnection;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;


public class MainAddRoom extends JFrame {

	private JPanel contentPane;
	Connection connection;
	private JButton addconssessions;
	private JButton addnonoverlappingrooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAddRoom frame = new MainAddRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainAddRoom() {
		
		connection = SqlServerConnection.dbConnecter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		contentPane.add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(90, 157, 1139, 507);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton addsessionrooms = new JButton("Add Session Rooms");
		addsessionrooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addrooms add = new addrooms();
				add.show();
			}
		});
		addsessionrooms.setBounds(54, 60, 435, 66);
		panel_1.add(addsessionrooms);
		addsessionrooms.setForeground(Color.WHITE);
		addsessionrooms.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		addsessionrooms.setBackground(new Color(0, 0, 139));
		
		addconssessions = new JButton("Add Consecative Session Rooms");
		addconssessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addroomcon addcon = new addroomcon();
				addcon.show();
			}
		});
		addconssessions.setForeground(Color.WHITE);
		addconssessions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		addconssessions.setBackground(new Color(0, 0, 139));
		addconssessions.setBounds(553, 197, 435, 66);
		panel_1.add(addconssessions);
		
		JButton addparsession = new JButton("Add Parallel Session Rooms");
		addparsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addParallel addpa = new addParallel();
				addpa.show();
			}
		});
		addparsession.setForeground(Color.WHITE);
		addparsession.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		addparsession.setBackground(new Color(0, 0, 139));
		addparsession.setBounds(54, 197, 435, 66);
		panel_1.add(addparsession);
		
		addnonoverlappingrooms = new JButton("Add Non-Overlapping Session Rooms");
		addnonoverlappingrooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addroomsNonOverLapping non=new addroomsNonOverLapping();
				non.show();
				
			}
			
		});
		addnonoverlappingrooms.setForeground(Color.WHITE);
		addnonoverlappingrooms.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		addnonoverlappingrooms.setBackground(new Color(0, 0, 139));
		addnonoverlappingrooms.setBounds(553, 60, 435, 66);
		panel_1.add(addnonoverlappingrooms);
		
		JButton viewallbtn = new JButton("Dispaly Allocated Session and rooms");
		viewallbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DispalyRooms dis = new DispalyRooms();
				dis.show();
				
			}
		});
		viewallbtn.setForeground(Color.WHITE);
		viewallbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		viewallbtn.setBackground(new Color(0, 0, 139));
		viewallbtn.setBounds(293, 327, 435, 66);
		panel_1.add(viewallbtn);
				
				
	}

}
