package room;

import DBConnection.SqlServerConnection;

import Home.HomePage;
import net.proteanit.sql.DbUtils;
import room.MainAddRoom;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.sql.*;

public class DispalyRooms extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JButton conbtn;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel Con;
	private JPanel Para;
	private JPanel NonOver;
	private JPanel Sess;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private JTable table_3;
	private JScrollPane scrollPane_3;
	private JPanel panelHeader;
	private JLabel txtrTimeTableManagement;
	Connection conn;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DispalyRooms frame = new DispalyRooms();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void SwitchPannels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public void refreshConTable()
	{
		try {
			
			Connection conn = SqlServerConnection.dbConnecter();
			
			String query="select * from ConsecutiveSessionRoom";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	public void refreshParTable()
	{
		try {
			
			Connection conn = SqlServerConnection.dbConnecter();
			
			String query="select * from ParallelSessionRoom";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	public void refreshOverLappingTable()
	{
		try {
			
			Connection conn = SqlServerConnection.dbConnecter();
			
			String query="select * from OverlappingSessionRoom";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	//Retriew Details from Sesssion room table :
	public void refreshSessionRoomTable()
	{
		try {
			
			Connection conn = SqlServerConnection.dbConnecter();
			
			String query="select * from ParallelSessionRoom";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public DispalyRooms() {
		
		Connection conn = SqlServerConnection.dbConnecter();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(44, 132, 1010, 521);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Con = new JPanel();
		Con.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(Con, "name_601258487500200");
		Con.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 141, 867, 333);
		Con.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Para = new JPanel();
		layeredPane.add(Para, "name_601270967360400");
		Para.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 125, 835, 344);
		Para.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		NonOver = new JPanel();
		layeredPane.add(NonOver, "name_601274081553800");
		NonOver.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(80, 149, 831, 306);
		NonOver.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		Sess = new JPanel();
		layeredPane.add(Sess, "name_601277021759200");
		Sess.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(86, 119, 837, 327);
		Sess.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		conbtn = new JButton("Consecative Sessions");
		conbtn.setBackground(new Color(0, 0, 128));
		conbtn.setForeground(new Color(255, 255, 255));
		conbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		conbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(Con);
				
			}
		});
		
		conbtn.setBounds(55, 85, 219, 36);
		contentPane.add(conbtn);
		
		btnNewButton_1 = new JButton("Parallel Session");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(Para);
				
			}
		});
		btnNewButton_1.setBounds(373, 86, 165, 36);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Non-Overlapping Session");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchPannels(NonOver);
				
			}
		});
		btnNewButton_2.setBounds(684, 88, 245, 33);
		contentPane.add(btnNewButton_2);
		
		panelHeader = new JPanel();
		panelHeader.setLayout(null);
		panelHeader.setForeground(Color.WHITE);
		panelHeader.setBackground(new Color(75, 119, 190));
		panelHeader.setBounds(-335, 0, 1689, 78);
		contentPane.add(panelHeader);
		
		txtrTimeTableManagement = new JLabel("Time Table Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setBounds(741, 11, 510, 53);
		panelHeader.add(txtrTimeTableManagement);
		
		JButton backbtn = new JButton("Back ");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainAddRoom main1 = new MainAddRoom();
				main1.show();
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setForeground(new Color(255, 255, 255));
		backbtn.setBackground(new Color(0, 0, 0));
		backbtn.setBounds(1149, 612, 150, 36);
		contentPane.add(backbtn);
		
		
		refreshConTable();
		refreshParTable();
		refreshOverLappingTable();
		refreshSessionRoomTable();
	}

}