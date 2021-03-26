package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.TimeSlot;
import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ManageTimeSlot extends JFrame {
	Connection connection=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	JPanel timeFrame;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTable jTable_Display;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	
	public static void manageTimeslot() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					ManageTimeSlot frame = new ManageTimeSlot();
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

	public ArrayList<Model.TimeSlot> getTimeSlotList()
	{
		ArrayList<Model.TimeSlot> timeSlotList = new ArrayList<Model.TimeSlot>();
		Connection connection = getConnection();
		
		String quary= "select* from TimeSlot";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			TimeSlot timeslot;
			while(rs.next())
			{
				timeslot = new TimeSlot(rs.getInt("ID"),rs.getString("startTime"),rs.getString("duration"),rs.getString("endTime"));
				timeSlotList.add(timeslot);
			}
		}catch(Exception ex) {
			
			
		}
		return timeSlotList;
		
	}
	//clear form fields after inserting data and after clicking clear button
			public void ClearFields()
			{
				txtID.setText(null);
				txtStartTime.setText(null);
				txtEndTime.setText(null);
			
				
			}
	//Display data in jtable
	
	public void Show_TimeSlot_In_JTable()
	{
		ArrayList<Model.TimeSlot> list = getTimeSlotList();
		DefaultTableModel model = (DefaultTableModel) jTable_Display.getModel();
		Object[] row = new Object[4];
		
		for(int i =0; i< list.size() ; i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getStartTime();
			row[2] = list.get(i).getDuration();
			row[3] = list.get(i).getEndTime();
			
			model.addRow(row);

			}
	}
	/**
	 * Create the frame.
	 */
	
	//Execute The SQL Quary
	public void executeSQLQuery(String query, String message) {
		
		Connection connection = getConnection();
		Statement st;
		
		try {
			st = connection.createStatement();
			
			if((st.executeUpdate(query)) == 1) {
				
				JOptionPane.showMessageDialog(null, "Data "+message+" successfully");
			}
			else {
				JOptionPane.showMessageDialog(null, "Data not"+message);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void fetch() {
		try {
			String q="select * from TimeSlot";
			pst=connection.prepareStatement(q);
			rs=pst.executeQuery();
			
			jTable_Display.setModel(DbUtils.resultSetToTableModel(rs));

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	//refresh table after doing update and delete
			public void RefreshTimeSlotTable()
			{
				try {
					
					String refresh="select * from TimeSlot";
					PreparedStatement psat= connection.prepareStatement(refresh);
					ResultSet rs=psat.executeQuery();
					
					jTable_Display.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception E2)
				{
					E2.printStackTrace();
				}
			}
			
	public ManageTimeSlot() {
	
		connection = DBConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		timeFrame = new JPanel();
		timeFrame.setBackground(new Color(255, 255, 255));
		timeFrame.setForeground(new Color(0, 0, 205));
		timeFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(timeFrame);
		timeFrame.setLayout(null);
		
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		StartTime.setForeground(Color.BLACK);
		StartTime.setBounds(60, 442, 125, 22);
		timeFrame.add(StartTime);
		
		JLabel newlab = new JLabel("");
		newlab.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlab.setForeground(Color.RED);
		newlab.setBounds(486, 442, 552, 30);
		timeFrame.add(newlab);

		txtStartTime = new JTextField();
		txtStartTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStartTime.setBackground(new Color(255, 255, 255));
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
				newlab.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				newlab.setText("---");
			}
			}
		});
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtID.setBackground(new Color(255, 255, 255));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(231, 370, 245, 33);
		timeFrame.add(txtID);
		txtStartTime.setColumns(10);
		txtStartTime.setBounds(231, 439, 245, 33);
		timeFrame.add(txtStartTime);
		
		JLabel slabb = new JLabel("");
		slabb.setForeground(Color.RED);
		slabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabb.setBounds(481, 597, 557, 30);
		timeFrame.add(slabb);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBounds(231, 483, 495, 14);
		timeFrame.add(lblNewLabel);
		
		JLabel duration = new JLabel("Time Slot Duration   :");
		duration.setFont(new Font("Tahoma", Font.BOLD, 13));
		duration.setForeground(Color.BLACK);
		duration.setBounds(60, 534, 164, 22);
		timeFrame.add(duration);
		
		JComboBox slot = new JComboBox();
		slot.setFont(new Font("Tahoma", Font.BOLD, 13));
		slot.setBackground(new Color(255, 255, 255));
		slot.setModel(new DefaultComboBoxModel(new String[] {"","1 Hour", "30 Minutes"}));
		slot.setBounds(231, 531, 245, 33);
		timeFrame.add(slot);
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		endTime.setForeground(Color.BLACK);
		endTime.setBounds(60, 597, 89, 22);
		timeFrame.add(endTime);
		
		txtEndTime = new JTextField();
		txtEndTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEndTime.setBackground(new Color(255, 255, 255));
		txtEndTime.addKeyListener(new KeyAdapter() {
			@Override
			//Validate The Field
			public void keyPressed(java.awt.event.KeyEvent evt) {
				// set a pattern
				String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
				Pattern patt= Pattern.compile(PATTERN);
;
				Matcher match = patt.matcher(txtEndTime.getText());
			if(!match.matches()) {
				slabb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				slabb.setText("---");
			}
			}
		});
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(231, 594, 245, 33);
		timeFrame.add(txtEndTime);
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setBounds(231, 638, 495, 14);
		timeFrame.add(lblNewLabel_1);
		
		JButton add = new JButton("Add Details");
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(0, 0, 128));
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtStartTime.getText().equals("")||txtEndTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				else {
				try {
					String query="insert into TimeSlot(startTime,Duration,endTime) values(?,?,?)";                      
					PreparedStatement pst=connection.prepareStatement(query);
					
					String start = txtStartTime.getText().toString();
					pst.setString(1, start);
					
					String durations = slot.getSelectedItem().toString();
					pst.setString(2, durations);
					
					String end = txtStartTime.getText().toString();
					pst.setString(3, end);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					pst.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				 fetch();
			}}
		});
		add.setBounds(1082, 405, 262, 49);
		timeFrame.add(add);
		
		JButton update = new JButton("Update Details");
		update.setForeground(new Color(255, 255, 255));
		update.setBackground(new Color(60, 179, 113));
		update.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
				int row = jTable_Display.getSelectedRow();
				
				String value= (jTable_Display.getModel().getValueAt(row,0).toString());
				String query="Update TimeSlot Set startTime=?, Duration=?,endTime=? where ID ="+value;
				PreparedStatement pst=connection.prepareStatement(query);
				
				String start = txtStartTime.getText().toString();
				pst.setString(1, start);
				
				String durations = slot.getSelectedItem().toString();
				pst.setString(2, durations);
				
				String end = txtEndTime.getText().toString();
				pst.setString(3, end);
				
				pst.executeUpdate();

				DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
				model.setRowCount(0);
				Show_TimeSlot_In_JTable();
				
				JOptionPane.showMessageDialog(null, "Data Updated successfully!");
				
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				 
				//to refresh the table after updating
				 RefreshTimeSlotTable();
				 fetch();
			}
			
				
				
			}
		});
		update.setBounds(1082, 476, 262, 49);
		timeFrame.add(update);
		
		JButton delete = new JButton("Delete Details");
		delete.setForeground(new Color(255, 255, 255));
		delete.setBackground(new Color(255, 0, 0));
		delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		delete.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				try {
				int row = jTable_Display.getSelectedRow();
				
				String value= (jTable_Display.getModel().getValueAt(row,0).toString());
				String query="DELETE FROM TimeSlot where ID="+value;
				
				PreparedStatement pst=connection.prepareStatement(query);
				
				pst.executeUpdate();
				
				DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
				model.setRowCount(0);
				Show_TimeSlot_In_JTable();
				
				JOptionPane.showMessageDialog(null, "Deleted Sucsessful!");
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				 fetch();
			}}
			
		});
		delete.setBounds(1082, 621, 262, 49);
		timeFrame.add(delete);
		
		JScrollPane scrol = new JScrollPane();
		
		scrol.setBounds(10, 90, 1062, 196);
		timeFrame.add(scrol);
		
		jTable_Display = new JTable();
		jTable_Display.addMouseListener(new MouseAdapter() {
			@Override
		
				public void mouseClicked(MouseEvent e) {
					
					try {
						int row = jTable_Display.getSelectedRow();
						String ID2 = (jTable_Display.getModel().getValueAt(row, 0)).toString();
						
						String query = "select * from TimeSlot where ID= '"+ID2+"'";
						
						PreparedStatement psat=connection.prepareStatement(query);
						
						ResultSet rs=psat.executeQuery();
						
						while(rs.next())
						{
							txtID.setText(rs.getString("ID"));
							txtStartTime.setText(rs.getString("startTime"));
							slot.setSelectedItem(rs.getString("duration"));
							txtEndTime.setText(rs.getString("endTime"));
							
							
						
						}
						
						psat.close();
						
					}
					catch(Exception e2) {
						
						e2.printStackTrace();
					}
					
				}
				
			});
			
	
		jTable_Display.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Start Time", "Time Slot Duration", "End Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrol.setViewportView(jTable_Display);
		
		JButton btnClear = new JButton("Clear Details");
		btnClear.setBackground(new Color(0, 206, 209));
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearFields();
			}
		});
		btnClear.setBounds(1082, 546, 262, 49);
		timeFrame.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1364, 79);
		timeFrame.add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.BLACK);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		panel.add(txtrTimeTableManagement);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(25, 25, 112));
		exitbtn.setBounds(1220, 90, 124, 49);
		timeFrame.add(exitbtn);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeFrame= new JPanel();
				if (JOptionPane.showConfirmDialog(timeFrame,"Conform if you want to exit !","System",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBounds(1082, 90, 124, 49);
		timeFrame.add(btnNewButton);
		JLabel id = new JLabel("ID    :");
		id.setBounds(60, 375, 39, 19);
		timeFrame.add(id);
		id.setFont(new Font("Tahoma", Font.BOLD, 13));
		id.setForeground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(null, "Add Time Slot", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 326, 1062, 352);
		timeFrame.add(panel_1);
		
		
		
			}
}
