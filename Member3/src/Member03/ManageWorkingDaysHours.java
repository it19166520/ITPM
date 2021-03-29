package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.PreparableStatement;

import DBConnection.SqlServerConnection;
import Model.TimeSlot;
import Model.WorkingDaysAndTime;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageWorkingDaysHours extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	
	JPanel addFramew;
	private JTextField txtmanageWorkingDays;
	private JTable jtableShow;
	DefaultTableModel model;
	private JTextField txtID;
	private JPanel panel;
	private JTextArea txtrTimeTableManagement;
	private JButton updatebtn;
	private JButton deletebtn;
	private JButton clearbtn;
	private JLabel lblNewLabel;
	private JLabel lblMinutes;
	private JTextField hour;
	private JTextField minutes;
	private JButton load;
	private JLabel workingDays;
	private JCheckBox monday;
	private JCheckBox friday;
	private JCheckBox tuesday;
	private JCheckBox saturday;
	private JCheckBox wednesday;
	private JCheckBox sunday;
	private JCheckBox thursday;
	private JPanel panel_2;
	
	/**
	 * Launch the application.
	 */
	
	public static void manageDays() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWorkingDaysHours frame = new ManageWorkingDaysHours();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
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

	public ArrayList<Model.WorkingDaysAndTime> getWorkingDaysList()
	{
		ArrayList<Model.WorkingDaysAndTime> workingList = new ArrayList<Model.WorkingDaysAndTime>();
		Connection connection = getConnection();
		
		String quary= "select* from WorkingDaysHours";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			WorkingDaysAndTime workingday;
			while(rs.next())
			{
				workingday = new WorkingDaysAndTime(rs.getInt("ID"),rs.getString("NumberOfWorkingDays"),rs.getString("WorkingDays"),rs.getString("WorkingHours"),rs.getString("WorkingMinutes"));
				workingList.add(workingday);
			}
		}catch(Exception ex) {
			
			
		}
		return workingList;
		
	}
	
	//Display data in jtable
	
	public void Show_WorkingDays_In_JTable()
	{
		ArrayList<Model.WorkingDaysAndTime> list = getWorkingDaysList();
		DefaultTableModel model = (DefaultTableModel) jtableShow.getModel();
		Object[] row = new Object[4];
		
		for(int i =0; i< list.size() ; i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getNumberOfWorkingDays();
			row[2] = list.get(i).getWorkingDays();
			row[3] = list.get(i).getWorkingHours();
			
			
			model.addRow(row);

			}
	}
	public void fetch() {
		try {
			String q="select * from WorkingDaysHours";
			pst=connection.prepareStatement(q);
			rs=pst.executeQuery();
			
			jtableShow.setModel(DbUtils.resultSetToTableModel(rs));

			
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
			
			String refresh="select * from WorkingDaysHours";
			PreparedStatement psat= connection.prepareStatement(refresh);
			ResultSet rs=psat.executeQuery();
			
			jtableShow.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	public ManageWorkingDaysHours() {
		
		connection = SqlServerConnection.dbConnecter();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		addFramew = new JPanel();
		addFramew.setBackground(Color.WHITE);
		addFramew.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addFramew);
		addFramew.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75,119,190));
		panel.setBounds(0, 0, 1364, 79);
		addFramew.add(panel);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setBackground(new Color(75,119,190));
		panel.add(txtrTimeTableManagement);
		
		txtmanageWorkingDays = new JTextField();
		txtmanageWorkingDays.setBorder(null);
		txtmanageWorkingDays.setEditable(false);
		txtmanageWorkingDays.setText("--------------Manage Working Days And Hours---------------");
		txtmanageWorkingDays.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtmanageWorkingDays.setColumns(10);
		txtmanageWorkingDays.setBackground(Color.WHITE);
		txtmanageWorkingDays.setBounds(187, 152, 362, 26);
		addFramew.add(txtmanageWorkingDays);
		
		JLabel lblId = new JLabel("ID  :");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(46, 211, 219, 23);
		addFramew.add(lblId);
		
		JLabel l1 = new JLabel("Number of Working Days :");
		l1.setFont(new Font("Dialog", Font.BOLD, 14));
		l1.setBounds(46, 260, 237, 23);
		addFramew.add(l1);
		
		JComboBox txtworkigDaysNum = new JComboBox();
		txtworkigDaysNum.setFont(new Font("Dialog", Font.BOLD, 14));
		txtworkigDaysNum.setBounds(387, 258, 276, 26);
		txtworkigDaysNum.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "6","7"}));
		addFramew.add(txtworkigDaysNum);
		JLabel workingTimePerDay = new JLabel("Working Time Per Day :");
		workingTimePerDay.setFont(new Font("Dialog", Font.BOLD, 14));
		workingTimePerDay.setBounds(46, 492, 219, 23);
		addFramew.add(workingTimePerDay);
		
		workingDays = new JLabel("Working Days :");
		workingDays.setFont(new Font("Dialog", Font.BOLD, 14));
		workingDays.setBounds(46, 309, 219, 23);
		addFramew.add(workingDays);
		
		monday = new JCheckBox("Monday");
		monday.setBackground(new Color(228, 241, 254));
		monday.setFont(new Font("Dialog", Font.BOLD, 12));
		monday.setBounds(387, 309, 108, 25);
		addFramew.add(monday);
		
		friday = new JCheckBox("Friday");
		friday.setBackground(new Color(228, 241, 254));
		friday.setFont(new Font("Dialog", Font.BOLD, 12));
		friday.setBounds(555, 308, 108, 26);
		addFramew.add(friday);
		
		tuesday = new JCheckBox("Tuesday");
		tuesday.setBackground(new Color(228, 241, 254));
		tuesday.setFont(new Font("Dialog", Font.BOLD, 12));
		tuesday.setBounds(387, 351, 108, 23);
		addFramew.add(tuesday);
		
		saturday = new JCheckBox("Saturday");
		saturday.setBackground(new Color(228, 241, 254));
		saturday.setFont(new Font("Dialog", Font.BOLD, 12));
		saturday.setBounds(555, 351, 108, 23);
		addFramew.add(saturday);
		
		wednesday = new JCheckBox("Wednesday");
		wednesday.setBackground(new Color(228, 241, 254));
		wednesday.setFont(new Font("Dialog", Font.BOLD, 12));
		wednesday.setBounds(387, 393, 108, 23);
		addFramew.add(wednesday);
		
		sunday = new JCheckBox("Sunday");
		sunday.setBackground(new Color(228, 241, 254));
		sunday.setFont(new Font("Dialog", Font.BOLD, 12));
		sunday.setBounds(554, 393, 109, 23);
		addFramew.add(sunday);
		
		thursday = new JCheckBox("Thursday");
		thursday.setBackground(new Color(228, 241, 254));
		thursday.setFont(new Font("Dialog", Font.BOLD, 12));
		thursday.setBounds(387, 432, 108, 22);
		addFramew.add(thursday);
		
	
		hour = new JTextField();
		hour.setFont(new Font("Dialog", Font.BOLD, 14));
		hour.setColumns(10);
		hour.setBackground(Color.WHITE);
		hour.setBounds(453, 491, 67, 26);
		addFramew.add(hour);
		
		minutes = new JTextField();
		minutes.setFont(new Font("Dialog", Font.BOLD, 14));
		minutes.setColumns(10);
		minutes.setBackground(Color.WHITE);
		minutes.setBounds(596, 493, 67, 26);
		addFramew.add(minutes);
		
		lblNewLabel = new JLabel("Hours");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(387, 496, 46, 14);
		addFramew.add(lblNewLabel);
		
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMinutes.setBounds(530, 496, 87, 14);
		addFramew.add(lblMinutes);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(721, 183, 608, 495);
		addFramew.add(scrollPane);
		
		jtableShow = new JTable();
		jtableShow.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Number Of Working Days", "Working Days", "Working Hours", "Working Minutes"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		jtableShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					
					int i = jtableShow.getSelectedRow();
					TableModel model = jtableShow.getModel();
					
					txtID.setText(model.getValueAt(i,0).toString());
					
					txtworkigDaysNum.setSelectedItem(model.getValueAt(i, 1).toString());
					
					hour.setText(model.getValueAt(i, 3).toString());
					
					minutes.setText(model.getValueAt(i, 4).toString());
				
				
			}
		});
		jtableShow.setFont(new Font("Tahoma", Font.BOLD, 12));
		jtableShow.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jtableShow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableShow.setSelectionBackground(new Color(107,185,240));
		jtableShow.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		jtableShow.getTableHeader().setOpaque(false);
		jtableShow.getTableHeader().setBackground(new Color(32,136,203));
		jtableShow.getTableHeader().setForeground(new Color(255,255,255));
		jtableShow.setRowHeight(30);
		
		scrollPane.setViewportView(jtableShow);
		model=new DefaultTableModel();
		Object[] column= {"ID","Number Of Working Days","Working Days","Working Hours","Working Minutes"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		
		updatebtn = new JButton("Update Details");
		updatebtn.setBackground(new Color(27, 163, 156));
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(hour.getText().equals("")||minutes.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please select the row from the table which wants to edit!");
				}
				else {
			int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
			
			if(opt ==0) {
				try {
					int row = jtableShow.getSelectedRow();
			
						String value= (jtableShow.getModel().getValueAt(row,0).toString());
						String sql = "update WorkingDaysHours set NumberOfWorkingDays=?,WorkingDays=?,WorkingHours=?,WorkingMinutes=? where ID="+value;
						PreparedStatement pst=connection.prepareStatement(sql);
						
						String day = txtworkigDaysNum.getSelectedItem().toString();
						pst.setString(1, day);
						
						String Days="";
						if(monday.isSelected()) {
							Days +=monday.getText()+" ";
						}
						if(tuesday.isSelected()) {
							Days +=tuesday.getText()+" ";
						}
						if(wednesday.isSelected()) {
							Days +=wednesday.getText()+" ";
						}
						if(thursday.isSelected()) {
							Days +=thursday.getText()+" ";
						}
						if(friday.isSelected()) {
							Days +=friday.getText()+" ";
						}
						if(saturday.isSelected()) {
							Days +=saturday.getText()+" ";
						}
					
						if(sunday.isSelected()) {
							Days +=sunday.getText()+" ";
						}
						pst.setString(2, Days);
						
						String hours = hour.getText().toString();
						pst.setString(3, hours);
			
						String minute = minutes.getText().toString();
						pst.setString(4, minute);
						
						pst.executeUpdate();

						DefaultTableModel model = (DefaultTableModel)jtableShow.getModel();
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
		updatebtn.setBackground(new Color(27,163,156));
		updatebtn.setBounds(94, 551, 229, 52);
		addFramew.add(updatebtn);
		
		deletebtn = new JButton("Delete Details");
		deletebtn.setBackground(new Color(210,77,87));
		deletebtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				if(hour.getText().equals("")||minutes.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please select the row from the table which wants to Delete!");
				}
				else {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
				int row = jtableShow.getSelectedRow();
				
				String value= (jtableShow.getModel().getValueAt(row,0).toString());
				String query="DELETE FROM WorkingDaysHours where ID="+value;
				
				PreparedStatement pst=connection.prepareStatement(query);
				
				pst.executeUpdate();
				
				DefaultTableModel model = (DefaultTableModel)jtableShow.getModel();
				model.setRowCount(0);
				Show_WorkingDays_In_JTable();
				
				JOptionPane.showMessageDialog(null, "Deleted Sucsessful!");
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				 RefreshWorkingTable();
				 fetch();
			}}
			}
		});
		deletebtn.setForeground(Color.WHITE);
		deletebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		deletebtn.setBackground(new Color(210,77,87));
		deletebtn.setBounds(403, 552, 229, 50);
		addFramew.add(deletebtn);
		
		clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					txtworkigDaysNum.setSelectedIndex(-1);
					txtID.setText(null);
					hour.setText(null);
					minutes.setText(null);
					
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(247, 614, 229, 50);
		addFramew.add(clearbtn);
		
		
		txtID = new JTextField();
		txtID.setFont(new Font("Dialog", Font.BOLD, 14));
		txtID.setEditable(false);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(387, 211, 276, 26);
		addFramew.add(txtID);
		txtID.setColumns(10);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 90, 124, 50);
		addFramew.add(exitbtn);
		
		JButton btnAddNewTime = new JButton("Add New Working Days And Hours");
		btnAddNewTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddWorkingDays working = new AddWorkingDays();
				working.addworkingdays();
				dispose();
			}
		});
	
		btnAddNewTime.setForeground(Color.WHITE);
		btnAddNewTime.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddNewTime.setBackground(new Color(25, 25, 112));
		btnAddNewTime.setBounds(886, 90, 308, 50);
		addFramew.add(btnAddNewTime);
		
		load = new JButton("Load Details Table");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(638, 90, 229, 52);
		addFramew.add(load);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(228, 241, 254));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		panel_2.setBounds(25, 183, 662, 495);
		addFramew.add(panel_2);
		

	
		
	
		
		
		
		
	
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFramew= new JPanel();
				if (JOptionPane.showConfirmDialog(addFramew,"Conform if you want to exit !","System",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
	}
}
