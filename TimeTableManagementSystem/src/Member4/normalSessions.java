package Member4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class normalSessions extends JFrame {
	
	Connection conn = SqlServerConnection.dbConnecter();

	private JPanel contentPane;

	private JScrollPane scrollPane;

	private JTable table;

	private JTextField SesstionIDtextField;

	private JComboBox RoomCombo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					normalSessions frame = new normalSessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshSessionTable()
	{
		try {
			
		
			
			String query="select * from session";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void fillSessionCobmoBox(Connection conn) {
		

		try {
			
			
			String query="select * from addLocation";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				RoomCombo.addItem(rs.getString("RoomName"));
			}
			
		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public normalSessions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setForeground(Color.WHITE);
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel_7.setBackground(new Color(75, 119, 190));
		panel_7.setBounds(0, 0, 1356, 75);
		contentPane.add(panel_7);
		
		JLabel lblNewLabel_23 = new JLabel("Timetable Management System");
		lblNewLabel_23.setForeground(Color.WHITE);
		lblNewLabel_23.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		lblNewLabel_23.setBounds(533, 10, 466, 55);
		panel_7.add(lblNewLabel_23);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 102, 1275, 267);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				  try {
					  
					   Connection conn = SqlServerConnection.dbConnecter();
					   
						int row = table.getSelectedRow();
						String SessionIndex_=(table.getModel().getValueAt(row, 0)).toString();
						
					   
						String query="select SessionId , room from session where SessionIndex='"+SessionIndex_+"' ";                      
						PreparedStatement pst=conn.prepareStatement(query);
					
						ResultSet rs=pst.executeQuery();
						
						while(rs.next())
						{
							
							SesstionIDtextField.setText(rs.getString("SessionId"));
							RoomCombo.setSelectedItem(rs.getString("room"));
							
						}
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}

				
			}
		});
		table.setBorder(new LineBorder(Color.BLUE));
		table.setUpdateSelectionOnSort(false);
		table.setSelectionForeground(Color.WHITE);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(176, 224, 230));
		table.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(34, 167, 240));
		table.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		SesstionIDtextField = new JTextField();
		SesstionIDtextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		SesstionIDtextField.setEditable(false);
		SesstionIDtextField.setBounds(269, 441, 286, 30);
		contentPane.add(SesstionIDtextField);
		SesstionIDtextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Session Id :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(80, 452, 179, 19);
		contentPane.add(lblNewLabel);
		
		RoomCombo = new JComboBox();
		RoomCombo.setFont(new Font("Tahoma", Font.BOLD, 13));
		RoomCombo.setBounds(269, 507, 286, 30);
		contentPane.add(RoomCombo);
		
		JLabel lblNewLabel_1 = new JLabel("Rooms");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(80, 511, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(31, 86, 211, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
					 //Insert Data into Session Table
				
				
					 Connection conn = SqlServerConnection.dbConnecter();
						
						String query="update session set room=? where SessionId=?";                      
						PreparedStatement pst=conn.prepareStatement(query);
						
						String SessionRomm=RoomCombo.getSelectedItem().toString();
						pst.setString(1, SessionRomm);
						
						String SessioIDRoom=SesstionIDtextField.getText().toString();
						pst.setString(2, SessioIDRoom);
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data inserted successfully!");
						
						pst.close();
						
						
					}catch(Exception e1)
					{
						e1.printStackTrace();
						 
					}
				 
				 refreshSessionTable();

			}
		});
		btnNewButton.setBounds(80, 590, 131, 30);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(31, 58, 147));
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
						 try {
							
	
							 Connection conn = SqlServerConnection.dbConnecter();
								
								String query="update session set room='' where SessionId=?";                      
								PreparedStatement pst=conn.prepareStatement(query);

								String SessioIDRoom=SesstionIDtextField.getText().toString();
								pst.setString(1, SessioIDRoom);
								
								pst.execute();
								JOptionPane.showMessageDialog(null, "Data Deleted successfully!");
								
								pst.close();
								
								
							}catch(Exception e1)
							{
								e1.printStackTrace();
								 
							}
						 
						 refreshSessionTable();

				
				
			}
		});
		btnNewButton_1.setBounds(254, 591, 123, 30);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(210, 77, 87));
		contentPane.add(btnNewButton_1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame MainAddRoom = new MainAddRoom();
				MainAddRoom.show();
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.setBorder(new LineBorder(new Color(64, 64, 64)));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1133, 586, 177, 38);
		contentPane.add(btnBack);
		refreshSessionTable();
		fillSessionCobmoBox(conn);
	}
}