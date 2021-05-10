package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConnection.SqlServerConnection;
import Model.NotAvailableTimeAllocation;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ManageNotAvailableTime extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	ResultSet rs=null;
	PreparedStatement pst=null;


	private JPanel contentPane;
	private JTable jtable_show;
	private JPanel panel;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel_1;
	private JTextArea txtrTimeTableManagement_1;
	private JLabel lblTimePeriod;
	private JTextField txtStartTime;
	private JLabel to;
	private JTextField txtEndTime;
	private JComboBox txtDay;
	private JComboBox txtSessionID;
	private JComboBox txtSubGroup;
	private JComboBox txtGroup;
	private JComboBox txtLec;
	private JTextField txtID;
	private JLabel labErr;
	private JLabel lblNewLabel;
	private JLabel lblSelectDay;
	private JLabel lblSelectSessionId;
	private JLabel lblSelectSubGroup;
	private JLabel lblSelectGroup;
	private JLabel lblSelectLecturer;
	private JLabel id;
	private JPanel panel_2;
	private JButton updatebtn;
	private JButton deletebtn;
	private JButton clearbtn;
	private JButton exitbtn;
	private JButton btnAddNewNot;

	/**
	 * Launch the application.
	 */
	public static void notavailable() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageNotAvailableTime frame = new ManageNotAvailableTime();
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

	public ArrayList<Model.NotAvailableTimeAllocation> getWorkingDaysList()
	{
		ArrayList<Model.NotAvailableTimeAllocation> workingList = new ArrayList<Model.NotAvailableTimeAllocation>();
		Connection connection = getConnection();
		
		String quary= "select* from NotAvailableTimeAllocation";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			NotAvailableTimeAllocation workingday;
			while(rs.next())
			{
				workingday = new NotAvailableTimeAllocation(rs.getInt("ID"),rs.getString("Lecturer"),rs.getString("Group"),rs.getString("SubGroup"),rs.getString("SessionID"),rs.getString("Day"),rs.getString("StartTime"),rs.getString("EndTime"));
				workingList.add(workingday);
			}
		}catch(Exception ex) {
			
			
		}
		return workingList;
		
	}
	
	//Display data in jtable
	
	public void Show_WorkingDays_In_JTable()
	{
		ArrayList<Model.NotAvailableTimeAllocation> list = getWorkingDaysList();
		DefaultTableModel model = (DefaultTableModel) jtable_show.getModel();
		Object[] row = new Object[8];
		
		for(int i =0; i< list.size() ; i++) {
			row[0] = list.get(i).getID();
			row[1] = list.get(i).getLecturer();
			row[2] = list.get(i).getGroup();
			row[3] = list.get(i).getSubGroup();
			row[4] = list.get(i).getSessionID();
			row[5] = list.get(i).getDay();
			row[6] = list.get(i).getStartTime();
			row[7] = list.get(i).getEndTime();
			
			
			
			model.addRow(row);

			}
	}
	public void fetch() {
		try {
			String q="select * from NotAvailableTimeAllocation";
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
			
			String refresh="select * from NotAvailableTimeAllocation";
			PreparedStatement psat= connection.prepareStatement(refresh);
			ResultSet rs=psat.executeQuery();
			
			jtable_show.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}

	
	//Fill lecturers names combo box  :
		public void FillLecturerComboBox()
		{
		
			try {
				
				String sql="select * from Lecturer";
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
			
					txtLec.addItem(rs.getString("LecturerName"));
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
		//Fill Main Group names combo box  :
		public void FillMainGroupComboBox()
		{
		
			try {
				
				String sql="select * from StudentGroups";
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
			
					txtGroup.addItem(rs.getString("GroupID"));
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
		//Fill  Sub groups names combo box  :
			public void FillSubGroupComboBox()
			{
			
				try {
					
					String sql="select * from StudentGroups";
					PreparedStatement pst=connection.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
				
						txtSubGroup.addItem(rs.getString("SubGroupID"));
						
					}
					
				}catch(Exception e){
					e.printStackTrace();
					
				}
			}

			//Fill Session ID combo box  :
					public void FillSessionIDComboBox()
					{
					
						try {
							
							String sql="select * from session";
							PreparedStatement pst=connection.prepareStatement(sql);
							ResultSet rs=pst.executeQuery();
							
							while(rs.next())
							{
						
								txtSessionID.addItem(rs.getString("SessionId"));
								
							}
							
						}catch(Exception e){
							e.printStackTrace();
							
						}
					}
	/**
	 * Create the frame.
	 */
	public ManageNotAvailableTime() {
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		contentPane.add(panel);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setBackground(new Color(75, 119, 190));
		panel_1.setBounds(-245, -79, 1364, 79);
		contentPane.add(panel_1);
		
		txtrTimeTableManagement_1 = new JTextArea();
		txtrTimeTableManagement_1.setText("Timetable Management System");
		txtrTimeTableManagement_1.setForeground(Color.WHITE);
		txtrTimeTableManagement_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement_1.setEditable(false);
		txtrTimeTableManagement_1.setBackground(new Color(75, 119, 190));
		panel_1.add(txtrTimeTableManagement_1);
		
		lblTimePeriod = new JLabel("Time Period :");
		lblTimePeriod.setForeground(Color.BLACK);
		lblTimePeriod.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTimePeriod.setBounds(123, 382, 143, 19);
		contentPane.add(lblTimePeriod);
		
		txtStartTime = new JTextField();
		txtStartTime.setFont(new Font("Dialog", Font.BOLD, 11));
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
				labErr.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				labErr.setText("---");
			}
			}
		});
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setBounds(366, 380, 78, 26);
		contentPane.add(txtStartTime);
		
		to = new JLabel("To");
		to.setFont(new Font("Dialog", Font.BOLD, 14));
		to.setBounds(454, 384, 39, 14);
		contentPane.add(to);
		
		txtEndTime = new JTextField();
		txtEndTime.setFont(new Font("Dialog", Font.BOLD, 11));
		txtEndTime.addKeyListener(new KeyAdapter() {
			@Override

				//Validate the field
				public void keyPressed(java.awt.event.KeyEvent evt) {
					// set a pattern
					String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
					Pattern patt= Pattern.compile(PATTERN);
	;
					Matcher match = patt.matcher(txtStartTime.getText());
				if(!match.matches()) {
					labErr.setText("Incorrect entered time pattern. Please fallow the given instruction!");
				}
				else {
					labErr.setText("---");
				}
				}
			});
		
		txtEndTime.setColumns(10);
		txtEndTime.setBackground(Color.WHITE);
		txtEndTime.setBounds(503, 380, 78, 26);
		contentPane.add(txtEndTime);
		
		txtDay = new JComboBox();
		txtDay.setBackground(Color.WHITE);
		txtDay.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDay.setBounds(366, 336, 359, 33);
		contentPane.add(txtDay);
		
		
		txtSessionID = new JComboBox();
		txtSessionID.setBackground(Color.WHITE);
		txtSessionID.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtSessionID.setBounds(366, 292, 359, 33);
		contentPane.add(txtSessionID);
		FillSessionIDComboBox();
		
		txtSubGroup = new JComboBox();
		txtSubGroup.setBackground(Color.WHITE);
		txtSubGroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtSubGroup.setBounds(366, 248, 359, 33);	
		contentPane.add(txtSubGroup);
		FillSubGroupComboBox();
		
		txtGroup = new JComboBox();
		txtGroup.setBackground(Color.WHITE);
		txtGroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtGroup.setBounds(366, 204, 359, 33);
		contentPane.add(txtGroup);
		FillMainGroupComboBox();
		
		txtLec = new JComboBox();
		txtLec.setBackground(Color.WHITE);
		txtLec.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtLec.setBounds(366, 160, 359, 33);
		contentPane.add(txtLec);
		FillLecturerComboBox();
		
		txtID = new JTextField();
		txtID.setFont(new Font("Dialog", Font.BOLD, 11));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(366, 116, 359, 33);
		contentPane.add(txtID);
		
		labErr = new JLabel("");
		labErr.setForeground(Color.RED);
		labErr.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		labErr.setBounds(366, 409, 422, 26);
		contentPane.add(labErr);
		
		lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(366, 432, 495, 30);
		contentPane.add(lblNewLabel);
		
		lblSelectDay = new JLabel("Select Day  :");
		lblSelectDay.setForeground(Color.BLACK);
		lblSelectDay.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectDay.setBounds(123, 341, 143, 19);
		contentPane.add(lblSelectDay);
		
		lblSelectSessionId = new JLabel("Select Session ID  :");
		lblSelectSessionId.setForeground(Color.BLACK);
		lblSelectSessionId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSessionId.setBounds(123, 297, 143, 19);
		contentPane.add(lblSelectSessionId);
		
		lblSelectSubGroup = new JLabel("Select Sub Group   :");
		lblSelectSubGroup.setForeground(Color.BLACK);
		lblSelectSubGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSubGroup.setBounds(123, 253, 143, 19);
		contentPane.add(lblSelectSubGroup);
		
		lblSelectGroup = new JLabel("Select Group   :");
		lblSelectGroup.setForeground(Color.BLACK);
		lblSelectGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectGroup.setBounds(123, 209, 143, 19);
		contentPane.add(lblSelectGroup);
		
		lblSelectLecturer = new JLabel("Select Lecturer  :");
		lblSelectLecturer.setForeground(Color.BLACK);
		lblSelectLecturer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectLecturer.setBounds(123, 167, 143, 19);
		contentPane.add(lblSelectLecturer);
		
		id = new JLabel("ID    :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Dialog", Font.BOLD, 14));
		id.setBounds(123, 122, 39, 19);
		contentPane.add(id);
		
		JScrollPane scrol = new JScrollPane();
		scrol.setBounds(67, 499, 1242, 179);
		contentPane.add(scrol);
		
		jtable_show = new JTable();
		jtable_show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					
					int i = jtable_show.getSelectedRow();
					TableModel model = jtable_show.getModel();
					
					txtID.setText(model.getValueAt(i,0).toString());
					
					txtLec.setSelectedItem(model.getValueAt(i, 1).toString());
					txtGroup.setSelectedItem(model.getValueAt(i, 2).toString());
					txtSubGroup.setSelectedItem(model.getValueAt(i, 3).toString());
					txtSessionID.setSelectedItem(model.getValueAt(i, 4).toString());
					txtDay.setSelectedItem(model.getValueAt(i,5 ).toString());
					txtStartTime.setText(model.getValueAt(i, 6).toString());
					txtEndTime.setText(model.getValueAt(i, 7).toString());
				
				
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
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Lecturer", "Group", "Sub Group", "Session ID", "Day", "Start Time", "End Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jtable_show.getColumnModel().getColumn(4).setResizable(false);
		jtable_show.getColumnModel().getColumn(4).setPreferredWidth(197);
		jtable_show.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable_show.setSelectionBackground(new Color(107, 185, 240));
		jtable_show.setRowHeight(30);
		jtable_show.setFont(new Font("Tahoma", Font.BOLD, 12));
		jtable_show.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol.setViewportView(jtable_show);
		
		updatebtn = new JButton("Update Details");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStartTime.getText().equals("")||txtLec.getSelectedItem().equals("")||txtSubGroup.getSelectedItem().equals("")||txtGroup.getSelectedItem().equals("")||txtDay.getSelectedItem().equals("")||txtSessionID.getSelectedItem().equals("")||txtEndTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please select the row from the table which wants to edit!");
				}
				else {
			int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
			
			if(opt ==0) {
				try {
					int row = jtable_show.getSelectedRow();
			
						String value= (jtable_show.getModel().getValueAt(row,0).toString());
						String sql = "UPDATE `NotAvailableTimeAllocation` SET `Lecturer`=?,`Group`="
								+ "?,`SubGroup`=?,`SessionID`=?,`Day`=?,`StartTime`=?,`EndTime`=? WHERE ID="+value;
						PreparedStatement pst=connection.prepareStatement(sql);
						
						String lec = txtLec.getSelectedItem().toString();
						pst.setString(1, lec);
						
						String gr = txtGroup.getSelectedItem().toString();
						pst.setString(2, gr);
						
						String grs = txtSubGroup.getSelectedItem().toString();
						pst.setString(3, grs);
						
						String ss= txtSessionID.getSelectedItem().toString();
						pst.setString(4, ss);
						
						String da = txtDay.getSelectedItem().toString();
						pst.setString(5, da);
						
						String st = txtStartTime.getText().toString();
						pst.setString(6, st);
						

						String et = txtEndTime.getText().toString();
						pst.setString(7, et);
						
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
		updatebtn.setBounds(814, 246, 229, 52);
		contentPane.add(updatebtn);
		
		deletebtn = new JButton("Delete Details");
		deletebtn.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent arg0) {
					int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
					
					if(opt ==0) {
					try {
					int row = jtable_show.getSelectedRow();
					
					String value= (jtable_show.getModel().getValueAt(row,0).toString());
					String query="DELETE FROM NotAvailableTimeAllocation where ID="+value;
					
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
		deletebtn.setBounds(814, 331, 229, 50);
		contentPane.add(deletebtn);
		
		clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
				txtStartTime.setText(null);
				txtEndTime.setText(null);
				txtLec.setSelectedIndex(-1);
				txtGroup.setSelectedIndex(-1);
				txtSubGroup.setSelectedIndex(-1);
				txtSessionID.setSelectedIndex(-1);
				txtDay.setSelectedIndex(-1);
			}
			
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(814, 419, 229, 50);
		contentPane.add(clearbtn);
		
		JButton load = new JButton("Load Details Table");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetch();
			}
		});
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(814, 160, 229, 52);
		contentPane.add(load);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2, true), "Manage Not Available Time Allocation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBackground(new Color(228, 241, 254));
		panel_2.setBounds(62, 90, 732, 389);
		contentPane.add(panel_2);
		
		exitbtn = new JButton("Exit\r\n");
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
		exitbtn.setBounds(1224, 129, 124, 50);
		contentPane.add(exitbtn);
		
		btnAddNewNot = new JButton("Add New Not Available Time Allocation");
		btnAddNewNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddNotAvailableTime hp = new AddNotAvailableTime();
				hp.notavailable();
				dispose();
			}
		});
		btnAddNewNot.setForeground(Color.WHITE);
		btnAddNewNot.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddNewNot.setBackground(new Color(25, 25, 112));
		btnAddNewNot.setBounds(1040, 79, 308, 50);
		contentPane.add(btnAddNewNot);
	}
}
