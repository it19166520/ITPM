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
import javax.swing.border.TitledBorder;

public class ManageWorkingDaysHours extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	
	JPanel addFramew;
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
	private JTextField txtworkigDaysNum;
	private JButton calculate;
	private JLabel labErr;
	
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
			  String url = "jdbc:mysql://151.106.114.2:3306/u271442347_itpm_db_H";
			  String userName = "u271442347_CTgiPK";
			  String password = "mzgdt9ezV";
			  connection = DriverManager.getConnection(url,userName, password);		
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
			connection = SqlServerConnection.dbConnecter();

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
		
		JLabel lblId = new JLabel("ID  :");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(46, 211, 219, 23);
		addFramew.add(lblId);
		
		JLabel l1 = new JLabel("Number of Working Days :");
		l1.setFont(new Font("Dialog", Font.BOLD, 14));
		l1.setBounds(45, 435, 237, 23);
		addFramew.add(l1);
		
		txtworkigDaysNum = new JTextField();
		txtworkigDaysNum.setFont(new Font("Dialog", Font.BOLD, 14));
		txtworkigDaysNum.setEditable(false);
		txtworkigDaysNum.setColumns(10);
		txtworkigDaysNum.setBackground(Color.WHITE);
		txtworkigDaysNum.setBounds(387, 435, 77, 29);
		addFramew.add(txtworkigDaysNum);
		JLabel workingTimePerDay = new JLabel("Working Time Per Day :");
		workingTimePerDay.setFont(new Font("Dialog", Font.BOLD, 14));
		workingTimePerDay.setBounds(46, 492, 219, 23);
		addFramew.add(workingTimePerDay);
		
		workingDays = new JLabel("Working Days :");
		workingDays.setFont(new Font("Dialog", Font.BOLD, 14));
		workingDays.setBounds(46, 265, 219, 23);
		addFramew.add(workingDays);
		
		monday = new JCheckBox("Monday");
		monday.setBackground(new Color(228, 241, 254));
		monday.setFont(new Font("Dialog", Font.BOLD, 12));
		monday.setBounds(387, 265, 108, 25);
		addFramew.add(monday);
		
		friday = new JCheckBox("Friday");
		friday.setBackground(new Color(228, 241, 254));
		friday.setFont(new Font("Dialog", Font.BOLD, 12));
		friday.setBounds(555, 264, 108, 26);
		addFramew.add(friday);
		
		tuesday = new JCheckBox("Tuesday");
		tuesday.setBackground(new Color(228, 241, 254));
		tuesday.setFont(new Font("Dialog", Font.BOLD, 12));
		tuesday.setBounds(387, 307, 108, 23);
		addFramew.add(tuesday);
		
		saturday = new JCheckBox("Saturday");
		saturday.setBackground(new Color(228, 241, 254));
		saturday.setFont(new Font("Dialog", Font.BOLD, 12));
		saturday.setBounds(555, 307, 108, 23);
		addFramew.add(saturday);
		
		wednesday = new JCheckBox("Wednesday");
		wednesday.setBackground(new Color(228, 241, 254));
		wednesday.setFont(new Font("Dialog", Font.BOLD, 12));
		wednesday.setBounds(387, 349, 108, 23);
		addFramew.add(wednesday);
		
		sunday = new JCheckBox("Sunday");
		sunday.setBackground(new Color(228, 241, 254));
		sunday.setFont(new Font("Dialog", Font.BOLD, 12));
		sunday.setBounds(554, 349, 109, 23);
		addFramew.add(sunday);
		
		thursday = new JCheckBox("Thursday");
		thursday.setBackground(new Color(228, 241, 254));
		thursday.setFont(new Font("Dialog", Font.BOLD, 12));
		thursday.setBounds(387, 388, 108, 22);
		addFramew.add(thursday);
		
	
		hour = new JTextField();
		hour.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				Connection connection = SqlServerConnection.dbConnecter();

				//validate the field
				String PATTERN = "[0-24]";
				Pattern patt= Pattern.compile(PATTERN);
;
				Matcher match = patt.matcher(hour.getText());
			if(!match.matches()) {
				labErr.setText("Incorrect entered value!");
			}
			else {
				labErr.setText("---");
			}
			
				char c =evt.getKeyChar();
				if(Character.isLetter(c)) {
				
				//can not able to enter in filed if enter char is not number
				hour.setEditable(false);
				labErr.setText("Please Enter Only Numbers For Hours!");
				}
				else {
					hour.setEditable(true);
					labErr.setText("---");
				}
			}
		});
		hour.setFont(new Font("Dialog", Font.BOLD, 14));
		hour.setColumns(10);
		hour.setBackground(Color.WHITE);
		hour.setBounds(387, 491, 77, 26);
		addFramew.add(hour);
		
		minutes = new JTextField();
		minutes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				//validate the field
				
				char c =evt.getKeyChar();
				if(Character.isLetter(c)) {
				
				//can not able to enter in filed if enter char is not number
				hour.setEditable(false);
				labErr.setText("Please Enter Only Numbers For Munites!");
				}
				else {
					hour.setEditable(true);
					labErr.setText("---");
				}
			}
		});
		minutes.setFont(new Font("Dialog", Font.BOLD, 14));
		minutes.setColumns(10);
		minutes.setBackground(Color.WHITE);
		minutes.setBounds(536, 491, 67, 26);
		addFramew.add(minutes);
		
		lblNewLabel = new JLabel("Hours");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(474, 496, 46, 14);
		addFramew.add(lblNewLabel);
		
		labErr = new JLabel("");
		labErr.setForeground(Color.RED);
		labErr.setFont(new Font("Dialog", Font.BOLD, 12));
		labErr.setBounds(387, 521, 280, 21);
		addFramew.add(labErr);
		
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMinutes.setBounds(613, 496, 87, 14);
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
					
					txtworkigDaysNum.setText(model.getValueAt(i, 1).toString());
					
					hour.setText(model.getValueAt(i, 3).toString());
					
					minutes.setText(model.getValueAt(i, 4).toString());
				
					String days=model.getValueAt(i, 2).toString();
						if(days == "monday")
						{
							monday.setSelected(true);
						}
						if(days == "tuesday")
						{
							tuesday.setSelected(true);
						}
						if(days == "wednesday")
						{
							wednesday.setSelected(true);
						}
						if(days == "thursday")
						{
							thursday.setSelected(true);
						}
						if(days == "friday")
						{
							friday.setSelected(true);
						}
						if(days == "saturday")
						{
							saturday.setSelected(true);
						}
						if(days == "sunday")
						{
							sunday.setSelected(true);
						}
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
					connection = SqlServerConnection.dbConnecter();

					int row = jtableShow.getSelectedRow();
			
						String value= (jtableShow.getModel().getValueAt(row,0).toString());
						String sql = "update WorkingDaysHours set NumberOfWorkingDays=?,WorkingDays=?,WorkingHours=?,WorkingMinutes=? where ID="+value;
						PreparedStatement pst=connection.prepareStatement(sql);
						
						String day = txtworkigDaysNum.getText().toString();
						pst.setString(1, day);
						
						String Days="";
						if(monday.isSelected()) {
							Days +=monday.getText()+" , ";
						}
						if(tuesday.isSelected()) {
							Days +=tuesday.getText()+" , ";
						}
						if(wednesday.isSelected()) {
							Days +=wednesday.getText()+" , ";
						}
						if(thursday.isSelected()) {
							Days +=thursday.getText()+" , ";
						}
						if(friday.isSelected()) {
							Days +=friday.getText()+" , ";
						}
						if(saturday.isSelected()) {
							Days +=saturday.getText()+" , ";
						}
					
						if(sunday.isSelected()) {
							Days +=sunday.getText()+" , ";
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
				connection = SqlServerConnection.dbConnecter();

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
				
					txtworkigDaysNum.setText(null);
					txtID.setText(null);
					hour.setText(null);
					minutes.setText(null);
					monday.setSelected(false);
					tuesday.setSelected(false);
					wednesday.setSelected(false);
					thursday.setSelected(false);
					friday.setSelected(false);
					saturday.setSelected(false);
					sunday.setSelected(false);
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(247, 614, 229, 50);
		addFramew.add(clearbtn);
		
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setFont(new Font("Dialog", Font.BOLD, 14));
		txtID.setEditable(false);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(387, 211, 276, 26);
		addFramew.add(txtID);
		txtID.setColumns(10);
		
		JButton exitbtn = new JButton("Back To Home\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 90, 124, 50);
		addFramew.add(exitbtn);
		
		JButton btnAddNewTime = new JButton("Add Time Slot Of The Timetable");
		btnAddNewTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTimeSlot working = new AddTimeSlot();
				working.addtimeslott();
				dispose();
			}
		});
	
		btnAddNewTime.setForeground(Color.WHITE);
		btnAddNewTime.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddNewTime.setBackground(new Color(25, 25, 112));
		btnAddNewTime.setBounds(915, 90, 279, 50);
		addFramew.add(btnAddNewTime);
		
		load = new JButton("Load Details Table");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int tot = 0;
				if(monday.isSelected()) {
					tot = tot+1;
				}
				if(tuesday.isSelected()) {
					tot = tot+1;
				}
				if(wednesday.isSelected()) {
					tot = tot+1;
				}
				if(thursday.isSelected()) {
					tot = tot+1;
				}
				if(friday.isSelected()) {
					tot = tot+1;
				}
				if(saturday.isSelected()) {
					tot = tot+1;
				}
				if(sunday.isSelected()) {
					tot = tot+1;
				}
				
				txtworkigDaysNum.setText(Integer.toString(tot));
				tot = Integer.parseInt(txtworkigDaysNum.getText());
			}
		});
		calculate.setForeground(Color.WHITE);
		calculate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		calculate.setBackground(new Color(58, 83, 155));
		calculate.setBounds(474, 427, 193, 39);
		addFramew.add(calculate);
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(676, 88, 229, 52);
		addFramew.add(load);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(228, 241, 254));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2, true), "Manage Working Days And Hours", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBounds(25, 176, 662, 502);
		addFramew.add(panel_2);		
	
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage2 hp = new HomePage2();
				hp.wokingDayHourframe.setVisible(true);
				dispose();
			}
		});
	}
}
