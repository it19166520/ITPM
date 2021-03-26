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
	Connection connection=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	
	JPanel addFramew;
	private JTextField textField;
	private JTable jtableShow;
	DefaultTableModel model;
	private JTextField txtID;
	private JTextField hour;
	/**
	 * Launch the application.
	 */
	
	public static void manageDays() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
	public void ClearFields()
	{
		txtID.setText(null);
		hour.setText(null);
		
	
		
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
		
		String quary= "select* from WorkingDaysHoursM";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			WorkingDaysAndTime workingday;
			while(rs.next())
			{
				workingday = new WorkingDaysAndTime(rs.getInt("ID"),rs.getString("NumberOfWorkingDays"),rs.getString("WorkingDays"),rs.getString("WorkingHours"));
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
			String q="select * from WorkingDaysHoursM";
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
			
			String refresh="select * from WorkingDaysHoursM";
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
		connection = DBConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		addFramew = new JPanel();
		addFramew.setBackground(new Color(255, 255, 255));
		addFramew.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addFramew);
		addFramew.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1364, 79);
		addFramew.add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.BLACK);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		panel.add(txtrTimeTableManagement);
		
		textField = new JTextField();
		textField.setText("--------------Add Working Days And Hours---------------");
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(257, 90, 362, 26);
		addFramew.add(textField);
		
		JLabel lblId = new JLabel("ID  :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(54, 127, 219, 23);
		addFramew.add(lblId);
		
		JLabel l1 = new JLabel("Number of Working Days :");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(54, 156, 237, 23);
		addFramew.add(l1);
		
		JComboBox workigDaysNum = new JComboBox();
		workigDaysNum.setBounds(395, 158, 261, 23);
		workigDaysNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6","7"}));
		addFramew.add(workigDaysNum);
		
		JLabel workingDays = new JLabel("Working Days :");
		workingDays.setFont(new Font("Tahoma", Font.BOLD, 14));
		workingDays.setBounds(54, 200, 219, 23);
		addFramew.add(workingDays);
		JRadioButton monday = new JRadioButton("Monday");
		monday.setFont(new Font("Tahoma", Font.BOLD, 12));
		monday.setBounds(395, 202, 109, 23);
		addFramew.add(monday);
		
		JRadioButton tuesday = new JRadioButton("Tuesday");
		tuesday.setFont(new Font("Tahoma", Font.BOLD, 12));
		tuesday.setBounds(395, 241, 109, 23);
		addFramew.add(tuesday);
		
		JRadioButton wednesday = new JRadioButton("Wednesday");
		wednesday.setFont(new Font("Tahoma", Font.BOLD, 12));
		wednesday.setBounds(395, 275, 109, 23);
		addFramew.add(wednesday);
		
		JRadioButton friday = new JRadioButton("Friday");
		friday.setFont(new Font("Tahoma", Font.BOLD, 12));
		friday.setBounds(547, 202, 109, 23);
		addFramew.add(friday);
		
		JRadioButton saturday = new JRadioButton("Saturday");
		saturday.setFont(new Font("Tahoma", Font.BOLD, 12));
		saturday.setBounds(547, 241, 109, 23);
		addFramew.add(saturday);
		
		JRadioButton sunday = new JRadioButton("Sunday");
		sunday.setFont(new Font("Tahoma", Font.BOLD, 12));
		sunday.setBounds(547, 275, 109, 23);
		addFramew.add(sunday);
		
		JRadioButton thursday = new JRadioButton("Thursday");
		thursday.setFont(new Font("Tahoma", Font.BOLD, 12));
		thursday.setBounds(395, 308, 109, 23);
		addFramew.add(thursday);
		
		JLabel workingTimePerDay = new JLabel("Working Time Per Day :");
		workingTimePerDay.setFont(new Font("Tahoma", Font.BOLD, 14));
		workingTimePerDay.setBounds(54, 367, 219, 23);
		addFramew.add(workingTimePerDay);
		
		JLabel newlab = new JLabel("");
		newlab.setForeground(Color.RED);
		newlab.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlab.setBounds(666, 367, 552, 30);
		addFramew.add(newlab);
		
		hour = new JTextField();
		hour.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
					// set a pattern
					String PATTERN = "([01]?[0-9]|2[0-4]).[0-5]";
					Pattern patt= Pattern.compile(PATTERN);
	;
					Matcher match = patt.matcher(hour.getText());
				if(!match.matches()) {
					newlab.setText("Incorrect entered time pattern. Please fallow the given instruction!");
				}
				else {
					newlab.setText("---");
				}
				
			
			}
		});
		hour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		hour.setColumns(10);
		hour.setBackground(Color.WHITE);
		hour.setBounds(395, 370, 261, 20);
		addFramew.add(hour);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 511, 1300, 164);
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
				"ID", "Number Of Working Days", "Working Days", "Working Hours", "New column"
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
					workigDaysNum.setSelectedItem(model.getValueAt(i, 1).toString());
					String day = model.getValueAt(i, 2).toString();
					
						if(day.equals("Monday")) {
							monday.setSelected(true);
						}
						else if(day.equals("Tuesday")) {
							tuesday.setSelected(true);
						}
						else if(day.equals("Wednesday")) {
							wednesday.setSelected(true);
						}
						else if(day.equals("Thursday")) {
							thursday.setSelected(true);
						}
						else if(day.equals("Friday")) {
							friday.setSelected(true);
						}
						else if(day.equals("Saturday")) {
							saturday.setSelected(true);
						}
						else {
							sunday.setSelected(true);
						}
						
					hour.setText(model.getValueAt(i, 3).toString());
				
				
			}
		});
		
		scrollPane.setViewportView(jtableShow);
		model=new DefaultTableModel();
		Object[] column= {"ID","Number Of Working Days","Working Days","Working Hours","Working Minutes"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		
		JButton addbtn = new JButton("Add Details");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {	
				
				
				//get working days and hours
				String query="insert into WorkingDaysHoursM(NumberOfWorkingDays,WorkingDays,WorkingHours) values(?,?,?)";                      
				PreparedStatement pst=connection.prepareStatement(query);
			
				
				//get number of working days and hours
				String workingDay=workigDaysNum.getSelectedItem().toString();
				pst.setString(1, workingDay);
				
				//get working days and hours
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
				
				//get working hours
				String WorkingTimeHoursss=hour.getText().toString();
				pst.setString(3, WorkingTimeHoursss);
				
				
				
				
				//Display successful massage when data was inserted to the database successfully:
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				
				pst.close();
				
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			  
			   fetch();
			}
		});
		addbtn.setForeground(Color.WHITE);
		addbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addbtn.setBackground(new Color(0, 0, 128));
		addbtn.setBounds(754, 173, 229, 40);
		addFramew.add(addbtn);
		
		JButton updatebtn = new JButton("Update Details");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
			
			if(opt ==0) {
				try {
					int row = jtableShow.getSelectedRow();
			
						String value= (jtableShow.getModel().getValueAt(row,0).toString());
						String sql = "update WorkingDaysHoursM set NumberOfWorkingDays=?,WorkingDays=?,WorkingHours=? where ID="+value;
						PreparedStatement pst=connection.prepareStatement(sql);
			
						String wdaysn = workigDaysNum.getSelectedItem().toString();
						pst.setString(1, wdaysn);
			
						
						String hours = hour.getText().toString();
						pst.setString(3, hours);
			
						pst.executeUpdate();

						DefaultTableModel model = (DefaultTableModel)jtableShow.getModel();
						model.setRowCount(0);
						Show_WorkingDays_In_JTable();
			
						JOptionPane.showMessageDialog(null, "Data Updated successfully!");
			
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
			}}
		});
		updatebtn.setForeground(Color.WHITE);
		updatebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		updatebtn.setBackground(new Color(34, 139, 34));
		updatebtn.setBounds(754, 224, 229, 40);
		addFramew.add(updatebtn);
		
		JButton deletebtn = new JButton("Delete Details");
		deletebtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
				int row = jtableShow.getSelectedRow();
				
				String value= (jtableShow.getModel().getValueAt(row,0).toString());
				String query="DELETE FROM WorkingDaysHoursM where ID="+value;
				
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
			
		});
		deletebtn.setForeground(Color.WHITE);
		deletebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		deletebtn.setBackground(Color.RED);
		deletebtn.setBounds(754, 275, 229, 40);
		addFramew.add(deletebtn);
		
		JButton clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearFields();
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(754, 350, 229, 40);
		addFramew.add(clearbtn);
		
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(395, 127, 261, 20);
		addFramew.add(txtID);
		txtID.setColumns(10);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1198, 90, 124, 50);
		addFramew.add(exitbtn);
		
		JButton btnAddNewTime = new JButton("Add New Time Slot");
		btnAddNewTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTimeSlot hp = new ManageTimeSlot();
				hp.manageTimeslot();
				
				
			}
		});
		btnAddNewTime.setForeground(Color.WHITE);
		btnAddNewTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnAddNewTime.setBackground(new Color(25, 25, 112));
		btnAddNewTime.setBounds(1052, 354, 280, 50);
		addFramew.add(btnAddNewTime);
		
		JLabel lblHintEx = new JLabel("Hint : Enter the Working Hours And Minutes ex: 9.30");
		lblHintEx.setForeground(new Color(0, 0, 205));
		lblHintEx.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHintEx.setBounds(395, 401, 400, 14);
		addFramew.add(lblHintEx);
		
		
		
		
	
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
