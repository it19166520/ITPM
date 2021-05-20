package Member4;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import DBConnection.SqlServerConnection;
import Home.HomePage;

import net.proteanit.sql.DbUtils;
//import room.MainAddRoom;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManageLocation extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JPanel panelHeader ;
	private JLabel txtrTimeTableManagement;
	private JLabel lblBuildingName;
	private JLabel lblRoomName;
	private JLabel lblRoomType;
	private JLabel lblCapacity;
	private JTextField textViewID;
	private JLabel lblID;
	private JTextField textViewBName;
	private JTextField textViewRName;
	private JRadioButton rdbtnLec;
	private JRadioButton rdbtnLab;
	private JTextField textViewCapacity;
	private JPanel TablePanel;
	private JButton btnClearViewPage;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblManage;
	JTable tableLocation;
	
	String roomtype;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton backbtn2;
	private JButton btnAddRooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocation frame = new ManageLocation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//clear fields
	public void CLearFieldsOftheForm()
	{
		textViewID.setText(null);
		textViewBName.setText(null);
		textViewRName.setText(null);
		
		textViewCapacity.setText(null);
		
	}
	
	public void RefreshTable()
	{
		try {
			
			String refreshque="select * from addLocation";
			PreparedStatement psat= connection.prepareStatement(refreshque);
			ResultSet rs=psat.executeQuery();
			
			tableLocation.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	
	

	/**
	 * Create the frame.
	 */
	public ManageLocation() {
		
		connection = SqlServerConnection.dbConnecter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		
		lblBuildingName = new JLabel("Building Name :");
		lblBuildingName.setForeground(Color.BLACK);
		lblBuildingName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBuildingName.setBounds(339, 480, 153, 43);
		contentPane.add(lblBuildingName);
		
		lblRoomName = new JLabel("Room Name:");
		lblRoomName.setForeground(Color.BLACK);
		lblRoomName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomName.setBounds(339, 534, 153, 43);
		contentPane.add(lblRoomName);
		
		lblRoomType = new JLabel("Room Type :");
		lblRoomType.setForeground(Color.BLACK);
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomType.setBounds(339, 577, 153, 43);
		contentPane.add(lblRoomType);
		
		lblCapacity = new JLabel("Capacity :");
		lblCapacity.setForeground(Color.BLACK);
		lblCapacity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCapacity.setBounds(339, 624, 153, 43);
		contentPane.add(lblCapacity);
		
		textViewID = new JTextField();
		textViewID.setEditable(false);
		textViewID.setColumns(10);
		textViewID.setBounds(526, 441, 285, 27);
		contentPane.add(textViewID);
		
		lblID = new JLabel("ID :");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblID.setBounds(339, 426, 153, 43);
		contentPane.add(lblID);
		
		textViewBName = new JTextField();
		textViewBName.setColumns(10);
		textViewBName.setBounds(526, 494, 285, 27);
		contentPane.add(textViewBName);
		
		textViewRName = new JTextField();
		textViewRName.setColumns(10);
		textViewRName.setBounds(526, 543, 285, 27);
		contentPane.add(textViewRName);
		
		rdbtnLec = new JRadioButton("Lectures");
		buttonGroup.add(rdbtnLec);
		rdbtnLec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomtype="Lecture";
			}
		});
		rdbtnLec.setForeground(Color.WHITE);
		rdbtnLec.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLec.setBackground(new Color(0, 0, 128));
		rdbtnLec.setBounds(526, 588, 109, 23);
		contentPane.add(rdbtnLec);
		
		rdbtnLab = new JRadioButton("Laboratories");
		buttonGroup.add(rdbtnLab);
		rdbtnLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomtype="Laboratories";
			}
		});
		rdbtnLab.setForeground(Color.WHITE);
		rdbtnLab.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLab.setBackground(new Color(0, 0, 128));
		rdbtnLab.setBounds(705, 588, 109, 23);
		contentPane.add(rdbtnLab);
		
		textViewCapacity = new JTextField();
		textViewCapacity.setColumns(10);
		textViewCapacity.setBounds(529, 633, 285, 27);
		contentPane.add(textViewCapacity);
		
		TablePanel = new JPanel();
		TablePanel.setBackground(new Color(240, 248, 255));
		TablePanel.setBounds(143, 122, 886, 292);
		contentPane.add(TablePanel);
		TablePanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(32, 11, 794, 270);
		TablePanel.add(scrollPane);
		
		tableLocation = new JTable();
		tableLocation.setRowHeight(18);
		tableLocation.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		tableLocation.setBackground(Color.WHITE);
		tableLocation.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		tableLocation.getTableHeader().setOpaque(false);
		tableLocation.getTableHeader().setBackground(new Color(32,136,203));
		tableLocation.getTableHeader().setForeground(new Color(255,255,255));
		tableLocation.setRowHeight(30);
		
		
		tableLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					connection = SqlServerConnection.dbConnecter();
					
					int row = tableLocation.getSelectedRow();
					String locationID = (tableLocation.getModel().getValueAt(row, 0)).toString();
					
				
					String query = "select * from addLocation where locationID= '"+locationID+"'";
					
					PreparedStatement psat=connection.prepareStatement(query);
					
					ResultSet rs=psat.executeQuery();
					
					while(rs.next())
					{
						textViewID.setText(rs.getString("locationID"));
						textViewBName.setText(rs.getString("BuildingName"));
						textViewRName.setText(rs.getString("RoomName"));
						
						
						int i = tableLocation.getSelectedRow();
						
						TableModel model =  tableLocation.getModel();
						
						String RType = model.getValueAt(i, 3).toString();
						
						if(RType.equals("Lecture"))
						{
							rdbtnLec.setSelected(true);
						}
						
						else {
							rdbtnLab.setSelected(true);
						}
						
						textViewCapacity.setText(rs.getString("Capacity"));
						
					}
					
					psat.close();
					
				}
				catch(Exception e2) {
					
					e2.printStackTrace();
				}
				
			}
			
		});
		
		
		scrollPane.setViewportView(tableLocation);
		
		btnClearViewPage = new JButton("Clear");
		btnClearViewPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CLearFieldsOftheForm();
			}
		});
		btnClearViewPage.setForeground(Color.WHITE);
		btnClearViewPage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClearViewPage.setBackground(new Color(0, 0, 128));
		btnClearViewPage.setBounds(1117, 195, 146, 36);
		contentPane.add(btnClearViewPage);
		
		
	//update data
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					connection = SqlServerConnection.dbConnecter();
					
					int row = tableLocation.getSelectedRow();
					String value = (tableLocation.getModel().getValueAt(row, 0).toString());
					String query = "update addLocation set BuildingName=?, RoomName=? , RoomType=? , Capacity=? where locationID="+value;
					PreparedStatement psat=connection.prepareStatement(query);
					
					psat.setString(1,textViewBName.getText());
					psat.setString(2,textViewRName.getText());
					
					if(rdbtnLec.isSelected())
					{
						roomtype="Lecture";
					}
					else
					{
						roomtype="Laboratory";
					}
					psat.setString(3, roomtype);
					
					psat.setString(4, textViewCapacity.getText());
					
					psat.executeUpdate();
					
					CLearFieldsOftheForm();
					
				}
				catch(Exception e5)
				{
					e5.printStackTrace();
				}
				
				
				//to refresh the table after updating
				RefreshTable();
				
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(27, 163, 156));
		btnUpdate.setBounds(1116, 255, 147, 36);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					connection = SqlServerConnection.dbConnecter();
					
					String deletequery="delete from addLocation where locationID='"+textViewID.getText()+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					psat.close();
					CLearFieldsOftheForm();
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshTable();
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBackground(new Color(210, 77, 87));
		btnDelete.setBounds(1115, 318, 148, 36);
		contentPane.add(btnDelete);
		
		lblManage = new JLabel("Manage Location");
		lblManage.setForeground(Color.BLACK);
		lblManage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblManage.setBounds(515, 86, 342, 40);
		contentPane.add(lblManage);
		
		backbtn2 = new JButton("Back");
		backbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ShankiHome home=new ShankiHome();
				home.Show();*/
				
				HomePage home1 = new HomePage();
				home1.Show();
				dispose();
				
			}
		});
		backbtn2.setForeground(Color.WHITE);
		backbtn2.setFont(new Font("Tahoma", Font.BOLD, 12));
		backbtn2.setFocusPainted(false);
		backbtn2.setBackground(Color.BLACK);
		backbtn2.setBounds(886, 627, 146, 36);
		contentPane.add(backbtn2);
		
		btnAddRooms = new JButton("Add Rooms");
		btnAddRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainAddRoom main1 = new MainAddRoom();
				main1.show();
				dispose();
			}
		});
		btnAddRooms.setForeground(Color.WHITE);
		btnAddRooms.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddRooms.setBackground(new Color(27, 163, 156));
		btnAddRooms.setBounds(1077, 624, 252, 40);
		contentPane.add(btnAddRooms);
		
		
		
		
	}
}
