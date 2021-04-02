package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConnection.SqlServerConnection;
import Model.NotAvailableTimeAllocation;
import Model.RoomCannotBeReserved;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageRoomCannotBeReserved extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	ResultSet rs=null;
	PreparedStatement pst=null;
	private JPanel contentPane;
	private JTable jtable_show;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtEnd;
	private JTextField txtmanageRoomDetails;

	/**
	 * Launch the application.
	 */
	public static void mngRoom() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRoomCannotBeReserved frame = new ManageRoomCannotBeReserved();
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
	public Connection getConnection()
	{
		Connection connection;
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlserver://itpmserver.database.windows.net;databaseName=ITPM(New)");
			return connection;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Model.RoomCannotBeReserved> getWorkingDaysList()
	{
		ArrayList<Model.RoomCannotBeReserved> workingList = new ArrayList<Model.RoomCannotBeReserved>();
		Connection connection = getConnection();
		
		String quary= "select* from RoomCannotBeReserved";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			RoomCannotBeReserved workingday;
			while(rs.next())
			{
				workingday = new RoomCannotBeReserved(rs.getInt("ID"),rs.getString("Room"),rs.getString("Day"),rs.getString("StartTime"),rs.getString("EndTime"));
				workingList.add(workingday);
			}
		}catch(Exception ex) {
			
			
		}
		return workingList;
		
	}
	public void Show_WorkingDays_In_JTable()
	{
		ArrayList<RoomCannotBeReserved> list = getWorkingDaysList();
		DefaultTableModel model = (DefaultTableModel) jtable_show.getModel();
		Object[] row = new Object[8];
		
		for(int i =0; i< list.size() ; i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getRoom();
			row[2] = list.get(i).getDay();
			row[3] = list.get(i).getStartTime();
			row[4] = list.get(i).getEndTime();
			
			
			
			model.addRow(row);

			}
	}
	public void fetch() {
		try {
			String q="select * from RoomCannotBeReserved";
			pst=connection.prepareStatement(q);
			rs=pst.executeQuery();
			
			jtable_show.setModel(DbUtils.resultSetToTableModel(rs));

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	/**
	 * Create the frame.
	 */
	
	public void RefreshWorkingTable()
	{
		try {
			
			String refresh="select * from RoomCannotBeReserved";
			PreparedStatement psat= connection.prepareStatement(refresh);
			ResultSet rs=psat.executeQuery();
			
			jtable_show.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	public ManageRoomCannotBeReserved() {
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
		
		JLabel lblSelectTheRoom = new JLabel("Select The Room  :");
		lblSelectTheRoom.setForeground(Color.BLACK);
		lblSelectTheRoom.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheRoom.setBounds(115, 206, 164, 22);
		contentPane.add(lblSelectTheRoom);
		
		JComboBox txtRoom = new JComboBox();
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRoom.setModel(new DefaultComboBoxModel(new String[] {"","A501","F501","B502","N3B-PcLab","A3B-PcLab","C3B-PcLab"}));
		txtRoom.setBackground(Color.WHITE);
		txtRoom.setBounds(330, 202, 356, 33);
		contentPane.add(txtRoom);
		
		JLabel lblSelectTheDay = new JLabel("Select The Day  :");
		lblSelectTheDay.setForeground(Color.BLACK);
		lblSelectTheDay.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheDay.setBounds(115, 262, 164, 22);
		contentPane.add(lblSelectTheDay);
		
		JComboBox txtDay = new JComboBox();
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDay.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDay.setBackground(Color.WHITE);
		txtDay.setBounds(330, 258, 356, 33);
		contentPane.add(txtDay);
		
		JScrollPane scrol = new JScrollPane();
		scrol.setBounds(49, 499, 1276, 179);
		contentPane.add(scrol);
		
		jtable_show = new JTable();
		jtable_show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					
					int i = jtable_show.getSelectedRow();
					TableModel model = jtable_show.getModel();
					
					txtID.setText(model.getValueAt(i,0).toString());
					
					txtRoom.setSelectedItem(model.getValueAt(i, 1).toString());
					txtDay.setSelectedItem(model.getValueAt(i,2 ).toString());
					txtStartTime.setText(model.getValueAt(i, 3).toString());
					txtEnd.setText(model.getValueAt(i, 4).toString());
				
				
			}
		});
		
		jtable_show.setFont(new Font("Tahoma", Font.BOLD, 12));
		jtable_show.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jtable_show.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable_show.setSelectionBackground(new Color(107,185,240));
		jtable_show.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		jtable_show.getTableHeader().setOpaque(false);
		jtable_show.getTableHeader().setBackground(new Color(32,136,203));
		jtable_show.getTableHeader().setForeground(new Color(255,255,255));
		jtable_show.setRowHeight(30);

		jtable_show.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Room", "Day", "Start Time", "End Time"
			}
		));
		jtable_show.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable_show.setSelectionBackground(new Color(107, 185, 240));
		jtable_show.setRowHeight(30);
		jtable_show.setFont(new Font("Tahoma", Font.BOLD, 12));
		jtable_show.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol.setViewportView(jtable_show);
		
		JLabel id = new JLabel("ID    :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Dialog", Font.BOLD, 14));
		id.setBounds(119, 156, 39, 19);
		contentPane.add(id);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(330, 150, 356, 33);
		contentPane.add(txtID);
		
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setForeground(Color.BLACK);
		StartTime.setFont(new Font("Dialog", Font.BOLD, 14));
		StartTime.setBounds(115, 315, 125, 22);
		contentPane.add(StartTime);
		
		JLabel newlabb = new JLabel("");
		newlabb.setForeground(Color.RED);
		newlabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlabb.setBounds(330, 340, 477, 30);
		contentPane.add(newlabb);
		
		JLabel slabbb = new JLabel("");
		slabbb.setForeground(Color.RED);
		slabbb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabbb.setBounds(330, 428, 495, 30);
		contentPane.add(slabbb);
		
		txtStartTime = new JTextField();
		txtStartTime.addKeyListener(new KeyAdapter() {
			@Override
			//Validate the field
			public void keyPressed(java.awt.event.KeyEvent evt) {
				// set a pattern
				String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
				Pattern patt= Pattern.compile(PATTERN);
;
				Matcher match = patt.matcher(txtStartTime.getText());
			if(!match.matches()) {
				newlabb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				newlabb.setText("---");
			}
			}
		});
		txtStartTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setBounds(330, 311, 356, 33);
		contentPane.add(txtStartTime);
		
		
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(330, 362, 495, 30);
		contentPane.add(lblNewLabel);
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setForeground(Color.BLACK);
		endTime.setFont(new Font("Dialog", Font.BOLD, 14));
		endTime.setBounds(115, 407, 89, 22);
		contentPane.add(endTime);
		
		txtEnd = new JTextField();
		txtEnd.addKeyListener(new KeyAdapter() {
			@Override
			//Validate the field
			public void keyPressed(java.awt.event.KeyEvent evt) {
				// set a pattern
				String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
				Pattern patt= Pattern.compile(PATTERN);
;
				Matcher match = patt.matcher(txtStartTime.getText());
			if(!match.matches()) {
				slabbb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				slabbb.setText("---");
			}
			}
		});
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnd.setColumns(10);
		txtEnd.setBackground(Color.WHITE);
		txtEnd.setBounds(330, 403, 356, 33);
		contentPane.add(txtEnd);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(330, 447, 495, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton load = new JButton("Load Details Table");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(817, 130, 229, 52);
		contentPane.add(load);
		
		JButton updatebtn = new JButton("Update Details");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStartTime.getText().equals("")||txtRoom.getSelectedItem().equals("")||txtEnd.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please select the row from the table which wants to edit!");
				}
				else {
			int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
			
			if(opt ==0) {
				try {
					int row = jtable_show.getSelectedRow();
			
						String value= (jtable_show.getModel().getValueAt(row,0).toString());
						String sql = "UPDATE `RoomCannotBeReserved` SET `Room`=?,`Day`="
								+ "?,`StartTime`=?,`EndTime`=? WHERE ID="+value;
						PreparedStatement pst=connection.prepareStatement(sql);
						
						String rm = txtRoom.getSelectedItem().toString();
						pst.setString(1, rm);
						
						String da = txtDay.getSelectedItem().toString();
						pst.setString(2, da);
						
						String st = txtStartTime.getText().toString();
						pst.setString(3, st);
						

						String et = txtEnd.getText().toString();
						pst.setString(4, et);
						
						pst.executeUpdate();

						DefaultTableModel model = (DefaultTableModel)jtable_show.getModel();
						model.setRowCount(0);
						Show_WorkingDays_In_JTable();
			
						JOptionPane.showMessageDialog(null, "Data Updated successfully!");
			
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				fetch();
			}}
			}
		});
		
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		updatebtn.setBackground(new Color(27, 163, 156));
		updatebtn.setBounds(817, 216, 229, 52);
		contentPane.add(updatebtn);
		
		JButton deletebtn = new JButton("Delete Details");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
				int row = jtable_show.getSelectedRow();
				
				String value= (jtable_show.getModel().getValueAt(row,0).toString());
				String query="DELETE FROM RoomCannotBeReserved where ID="+value;
				
				PreparedStatement pst=connection.prepareStatement(query);
				
				pst.executeUpdate();
				
				DefaultTableModel model = (DefaultTableModel)jtable_show.getModel();
				model.setRowCount(0);
				Show_WorkingDays_In_JTable();
				
				JOptionPane.showMessageDialog(null, "Deleted Sucsessful!");
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
		
				 fetch();
			}}
			
		});
		deletebtn.setForeground(Color.WHITE);
		deletebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		deletebtn.setBackground(new Color(210, 77, 87));
		deletebtn.setBounds(817, 301, 229, 50);
		contentPane.add(deletebtn);
		
		JButton clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
				txtStartTime.setText(null);
				txtEnd.setText(null);
				txtRoom.setSelectedIndex(-1);
				txtDay.setSelectedIndex(-1);
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(817, 389, 229, 50);
		contentPane.add(clearbtn);
		
		JButton btnAddNewNot = new JButton("Add New Room Cannot Be Reserved");
		btnAddNewNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCannotReservedRoom rm= new AddCannotReservedRoom();
				rm.addRoom();
				dispose();
				
			}
		});
		btnAddNewNot.setForeground(Color.WHITE);
		btnAddNewNot.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddNewNot.setBackground(new Color(25, 25, 112));
		btnAddNewNot.setBounds(1046, 76, 308, 50);
		contentPane.add(btnAddNewNot);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			contentPane= new JPanel();
			if (JOptionPane.showConfirmDialog(contentPane,"Conform if you want to exit !","System",
					JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			}
		});
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1230, 132, 124, 50);
		contentPane.add(exitbtn);
		
		txtmanageRoomDetails = new JTextField();
		txtmanageRoomDetails.setText("--------------Manage Room Details cannot Be Reserved---------------");
		txtmanageRoomDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtmanageRoomDetails.setEditable(false);
		txtmanageRoomDetails.setColumns(10);
		txtmanageRoomDetails.setBorder(null);
		txtmanageRoomDetails.setBackground(Color.WHITE);
		txtmanageRoomDetails.setBounds(230, 89, 450, 26);
		contentPane.add(txtmanageRoomDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		panel_2.setBackground(new Color(228, 241, 254));
		panel_2.setBounds(49, 124, 738, 364);
		contentPane.add(panel_2);
	}
}
