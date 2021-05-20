package Member3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConnection.SqlServerConnection;
import Model.RoomCannotBeReserved;
import Model.sessionDayTime;
import net.proteanit.sql.DbUtils;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageSessionWithDay extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	ResultSet rs=null;
	PreparedStatement pst=null;
	private JPanel contentPane;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTable table;
	private JComboBox txtDaycom;
	private JTextField sessionIDcom;
	/**
	 * Launch the application.
	 */
	public static void mngSession() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSessionWithDay frame = new ManageSessionWithDay();
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


	public ArrayList<Model.sessionDayTime> getSessionDayList()
	{
		ArrayList<Model.sessionDayTime> workingList = new ArrayList<Model.sessionDayTime>();
		Connection connection = getConnection();
		
		String quary= "select* from session";
		Statement st;
		ResultSet rs;
		
		try {
			st = connection.createStatement();
			rs= st.executeQuery(quary);
			
			sessionDayTime workingday;
			while(rs.next())
			{
				workingday = new sessionDayTime(rs.getString("SessionId"),rs.getString("startingTime"),rs.getString("endingTime"),rs.getString("date"));
				workingList.add(workingday);
			}
		}catch(Exception ex) {
			
			
		}
		return workingList;
		
	}
	public void Show_SessionDay_In_JTable()
	{
		ArrayList<sessionDayTime> list = getSessionDayList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[8];
		
		for(int i =0; i< list.size() ; i++) {
			row[0] = list.get(i).getSessionId();
			row[1] = list.get(i).getStartingTime();
			row[2] = list.get(i).getEnddingTime();
			row[3] = list.get(i).getDay();
			
			
			
			model.addRow(row);

			}
	}
	
	public void fetch() {
		try {
			connection = SqlServerConnection.dbConnecter();

			String q="select SessionId,date,startingTime,endTime from session";
			pst=connection.prepareStatement(q);
			rs=pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));

			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	public void refreshSessionTable()
	{
		try {
			
		
			
			String query="select SessionId,date,startingTime,endTime from session";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	public void RefreshSessionTable()
	{
		try {
			
			String refresh="select * from session";
			PreparedStatement psat= connection.prepareStatement(refresh);
			ResultSet rs=psat.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public ManageSessionWithDay() {
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
		
		JLabel lblSessionId = new JLabel("Session ID  :");
		lblSessionId.setForeground(Color.BLACK);
		lblSessionId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSessionId.setBounds(99, 127, 164, 22);
		contentPane.add(lblSessionId);
		
		JLabel lbsesID = new JLabel("");
		lbsesID.setForeground(Color.RED);
		lbsesID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbsesID.setBounds(313, 156, 138, 14);
		contentPane.add(lbsesID);
		
		JLabel lblSelectTheDay_1 = new JLabel("Select The Day  :");
		lblSelectTheDay_1.setForeground(Color.BLACK);
		lblSelectTheDay_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheDay_1.setBounds(99, 181, 164, 22);
		contentPane.add(lblSelectTheDay_1);
		
		JLabel newlabb = new JLabel("");
		newlabb.setForeground(Color.RED);
		newlabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlabb.setBounds(313, 275, 477, 30);
		contentPane.add(newlabb);
		
		JLabel slabbb = new JLabel("");
		slabbb.setForeground(Color.RED);
		slabbb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabbb.setBounds(313, 376, 495, 30);
		contentPane.add(slabbb);
		
		txtDaycom = new JComboBox();
		txtDaycom.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDaycom.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDaycom.setBackground(Color.WHITE);
		txtDaycom.setBounds(313, 181, 356, 33);
		contentPane.add(txtDaycom);
		
		JLabel lbday = new JLabel("");
		lbday.setForeground(Color.RED);
		lbday.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbday.setBounds(313, 215, 138, 14);
		contentPane.add(lbday);
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setForeground(Color.BLACK);
		StartTime.setFont(new Font("Dialog", Font.BOLD, 14));
		StartTime.setBounds(101, 240, 125, 22);
		contentPane.add(StartTime);
		
		txtStart = new JTextField();
		txtStart.addKeyListener(new KeyAdapter() {
			@Override
			//Validate the field
			public void keyPressed(java.awt.event.KeyEvent evt) {
				// set a pattern
				String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
				Pattern patt= Pattern.compile(PATTERN);
;
				Matcher match = patt.matcher(txtStart.getText());
			if(!match.matches()) {
				newlabb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				newlabb.setText("---");
			}
			}
		});
		
		sessionIDcom = new JTextField();
		sessionIDcom.setForeground(Color.BLUE);
		sessionIDcom.setEnabled(false);
		sessionIDcom.setEditable(false);
		sessionIDcom.setFont(new Font("Tahoma", Font.BOLD, 13));
		sessionIDcom.setColumns(10);
		sessionIDcom.setBackground(Color.WHITE);
		sessionIDcom.setBounds(313, 130, 356, 33);
		contentPane.add(sessionIDcom);
		
		
		txtStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStart.setColumns(10);
		txtStart.setBackground(Color.WHITE);
		txtStart.setBounds(313, 240, 356, 33);
		contentPane.add(txtStart);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(313, 301, 495, 30);
		contentPane.add(lblNewLabel);
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setForeground(Color.BLACK);
		endTime.setFont(new Font("Dialog", Font.BOLD, 14));
		endTime.setBounds(100, 346, 89, 22);
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
				Matcher match = patt.matcher(txtStart.getText());
			if(!match.matches()) {
				slabbb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				slabbb.setText("---");
			}
			}
		});
		txtEnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEnd.setColumns(10);
		txtEnd.setBackground(Color.WHITE);
		txtEnd.setBounds(313, 342, 356, 33);
		contentPane.add(txtEnd);
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(313, 406, 495, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbend = new JLabel("");
		lbend.setForeground(Color.RED);
		lbend.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbend.setBounds(671, 381, 138, 14);
		contentPane.add(lbend);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2), "Manage Session With Date & Time", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(26, 90, 759, 371);
		contentPane.add(panel_1);
		
		JButton btnClear1 = new JButton("Clear Details");
		btnClear1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear1.setBackground(new Color(0, 206, 209));
		btnClear1.setBounds(490, 498, 262, 49);
		
		JButton load = new JButton("Load Details Table");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fetch();

			}
		});
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(795, 170, 229, 52);
		contentPane.add(load);
		
		JButton updatebtn = new JButton("Update Details");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStart.getText().equals("")||txtDaycom.getSelectedItem().equals("")||txtEnd.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please select the row from the table which wants to edit!");
				}
				else {
			int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Update Details?","Update", JOptionPane.YES_NO_OPTION);
			
			if(opt ==0) {

				String sessionid = sessionIDcom.getText();
				String day = txtDaycom.getSelectedItem().toString();
				String startT=txtStart.getText();
				String endT= txtEnd.getText();
				
				try {
					
					connection = SqlServerConnection.dbConnecter();

					int row = table.getSelectedRow();
			
						String value= (table.getModel().getValueAt(row,0).toString());
				
						pst = connection.prepareStatement("update session set date= ?, startingTime= ?,endTime= ?  where SessionId=?");

						
						String st = txtDaycom.getSelectedItem().toString();
						pst.setString(1, st);
						
						String rm = txtStart.getText().toString();
						pst.setString(2, rm);
						
						String da = txtEnd.getText().toString();
						pst.setString(3, da);

						String daa = sessionIDcom.getText().toString();
						pst.setString(4, daa);
						
						pst.executeUpdate();

						DefaultTableModel model = (DefaultTableModel)table.getModel();
						model.setRowCount(0);
						Show_SessionDay_In_JTable();
			
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
		updatebtn.setBounds(795, 251, 229, 52);
		contentPane.add(updatebtn);
		
		JButton clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStart.setText(null);
				txtEnd.setText(null);
				sessionIDcom.setText(null);
				txtDaycom.setSelectedIndex(-1);
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(800, 411, 229, 50);
		contentPane.add(clearbtn);
		
		JButton btnAddNewSession = new JButton("Add New Session With Day & Times");
		btnAddNewSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddSessionWithDay rm= new AddSessionWithDay();
				dispose();
			}
		});
		btnAddNewSession.setForeground(Color.WHITE);
		btnAddNewSession.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddNewSession.setBackground(new Color(25, 25, 112));
		btnAddNewSession.setBounds(1036, 88, 308, 50);
		contentPane.add(btnAddNewSession);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 138, 124, 50);
		contentPane.add(exitbtn);
		
		JScrollPane scrol = new JScrollPane();
		scrol.setBounds(26, 499, 1242, 179);
		contentPane.add(scrol);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				sessionIDcom.setText(model.getValueAt(i, 0).toString());
				txtDaycom.setSelectedItem(model.getValueAt(i, 1).toString());
				txtStart.setText(model.getValueAt(i, 2).toString());
				txtEnd.setText(model.getValueAt(i, 3).toString());
			
				
				
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Session ID", "Day", "Start Time", "End Time"
				}
		));
		
		scrol.setViewportView(table);
		
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(107,185,240));
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(30);
		
		JButton deletebtn = new JButton("Delete Details");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					
					connection = SqlServerConnection.dbConnecter();

						String query="update session set date='', startingTime='', endTime= '' where SessionId=?";                      
						PreparedStatement pst=connection.prepareStatement(query);

				
						String ee=sessionIDcom.getText().toString();
						pst.setString(1, ee);
						
				
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted successfully!");
						
					
			
				}catch(Exception e5)
				{
					JOptionPane.showMessageDialog(null, e5);
				}
				fetch();
			}
		});
		deletebtn.setForeground(Color.WHITE);
		deletebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		deletebtn.setBackground(new Color(210, 77, 87));
		deletebtn.setBounds(795, 332, 229, 50);
		contentPane.add(deletebtn);
		
		JLabel lblNewLabel_2 = new JLabel("*Click \"Load Details Table\" button to fullfill the table with all details.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_2.setBounds(26, 474, 398, 14);
		contentPane.add(lblNewLabel_2);
	}
}