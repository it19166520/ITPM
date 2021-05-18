package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnection.SqlServerConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AddNotAvailableTime extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JComboBox txtLec;
	private JComboBox txtGroup;
	private JComboBox txtSubGroup;
	private JComboBox txtSessionID;
	private JComboBox txtDay;
	private JLabel lb;
	
	/**
	 * Launch the application.
	 */
	public static void notavailable() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotAvailableTime frame = new AddNotAvailableTime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//Fill lecturers names combo box  :
	public void FillLecturerComboBox(Connection connection)
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
	public void FillMainGroupComboBox(Connection connection)
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
		public void FillSubGroupComboBox(Connection connection)
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
				public void FillSessionIDComboBox(Connection connection)
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
	 */public void clear()
		{
			txtStartTime.setText(null);
			txtEndTime.setText(null);
			txtLec.setSelectedIndex(-1);
			txtGroup.setSelectedIndex(-1);
			txtSubGroup.setSelectedIndex(-1);
			txtDay.setSelectedIndex(-1);
			txtSessionID.setSelectedIndex(-1);
		}
	public AddNotAvailableTime() {
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("ID    :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Dialog", Font.BOLD, 14));
		id.setBounds(371, 176, 39, 19);
		contentPane.add(id);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(613, 170, 359, 33);
		contentPane.add(txtID);
		
		JLabel lblSelectLecturer = new JLabel("Select Lecturer  :");
		lblSelectLecturer.setForeground(Color.BLACK);
		lblSelectLecturer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectLecturer.setBounds(370, 231, 143, 19);
		contentPane.add(lblSelectLecturer);
		
		JLabel leclb = new JLabel("");
		leclb.setForeground(Color.RED);
		leclb.setFont(new Font("Tahoma", Font.BOLD, 13));
		leclb.setBounds(613, 258, 138, 14);
		contentPane.add(leclb);
	
		
		txtLec = new JComboBox();
		txtLec.setBackground(Color.WHITE);
		txtLec.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtLec.setBounds(613, 226, 359, 33);
		contentPane.add(txtLec);
		FillLecturerComboBox(connection);
		
		
		JLabel lblSelectGroup = new JLabel("Select Group   :");
		lblSelectGroup.setForeground(Color.BLACK);
		lblSelectGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectGroup.setBounds(370, 283, 143, 19);
		contentPane.add(lblSelectGroup);
		
		txtGroup = new JComboBox();
		txtGroup.setBackground(Color.WHITE);
		txtGroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtGroup.setBounds(613, 278, 359, 33);
		contentPane.add(txtGroup);
		FillMainGroupComboBox(connection);
		
		
		JLabel grplb = new JLabel("");
		grplb.setForeground(Color.RED);
		grplb.setFont(new Font("Tahoma", Font.BOLD, 13));
		grplb.setBounds(613, 310, 138, 14);
		contentPane.add(grplb);
		
		JLabel lblSelectSubGroup = new JLabel("Select Sub Group   :");
		lblSelectSubGroup.setForeground(Color.BLACK);
		lblSelectSubGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSubGroup.setBounds(370, 333, 143, 19);
		contentPane.add(lblSelectSubGroup);
		
		txtSubGroup = new JComboBox();
		txtSubGroup.setBackground(Color.WHITE);
		txtSubGroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtSubGroup.setBounds(613, 333, 359, 33);
		contentPane.add(txtSubGroup);
		FillSubGroupComboBox(connection);
		
		JLabel grplb_1 = new JLabel("");
		grplb_1.setForeground(Color.RED);
		grplb_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		grplb_1.setBounds(613, 365, 138, 14);
		contentPane.add(grplb_1);
		
		JLabel lblSelectSessionId = new JLabel("Select Session ID  :");
		lblSelectSessionId.setForeground(Color.BLACK);
		lblSelectSessionId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSessionId.setBounds(370, 395, 143, 19);
		contentPane.add(lblSelectSessionId);
		
		JLabel idlb = new JLabel("");
		idlb.setForeground(Color.RED);
		idlb.setFont(new Font("Tahoma", Font.BOLD, 13));
		idlb.setBounds(613, 423, 138, 14);
		contentPane.add(idlb);
		
		txtSessionID = new JComboBox();
		txtSessionID.setBackground(Color.WHITE);
		txtSessionID.setModel(new DefaultComboBoxModel(new String[] {""}));
		txtSessionID.setBounds(613, 390, 359, 33);
		contentPane.add(txtSessionID);
		FillSessionIDComboBox(connection);
		
		JLabel labErr = new JLabel("");
		labErr.setForeground(Color.RED);
		labErr.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		labErr.setBounds(613, 527, 422, 26);
		contentPane.add(labErr);
		
		txtStartTime = new JTextField();
		txtStartTime.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		txtStartTime.setBounds(613, 500, 78, 26);
		
		contentPane.add(txtStartTime);
		
		JLabel to = new JLabel("To");
		to.setFont(new Font("Dialog", Font.BOLD, 14));
		to.setBounds(712, 500, 39, 14);
		contentPane.add(to);
		
		txtEndTime = new JTextField();
		txtEndTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEndTime.setColumns(10);
		txtEndTime.setBackground(Color.WHITE);
		txtEndTime.setBounds(761, 500, 78, 26);
		txtEndTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				
				char c =evt.getKeyChar();
				if(Character.isLetter(c)) {
				
				//can not able to enter in filed if enter char is not number
					txtEndTime.setEditable(false);
				labErr.setText("Please Enter Numbers Only!");
				}
				else {
					txtEndTime.setEditable(true);
					labErr.setText("---");
				}
			}
		});
		contentPane.add(txtEndTime);
		
	
		
		JLabel lblTimePeriod = new JLabel("Time Period :");
		lblTimePeriod.setForeground(Color.BLACK);
		lblTimePeriod.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTimePeriod.setBounds(370, 507, 143, 19);
		contentPane.add(lblTimePeriod);
		
		JLabel lblSelectDay = new JLabel("Select Day  :");
		lblSelectDay.setForeground(Color.BLACK);
		lblSelectDay.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectDay.setBounds(370, 453, 143, 19);
		contentPane.add(lblSelectDay);
		
		txtDay = new JComboBox();
		txtDay.setBackground(Color.WHITE);
		txtDay.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDay.setBounds(613, 448, 359, 33);
		contentPane.add(txtDay);
		
		JLabel daylb = new JLabel("");
		daylb.setForeground(Color.RED);
		daylb.setFont(new Font("Tahoma", Font.BOLD, 13));
		daylb.setBounds(613, 480, 138, 14);
		contentPane.add(daylb);
		
		lb = new JLabel("");
		lb.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb.setForeground(Color.RED);
		lb.setBounds(848, 507, 138, 14);
		contentPane.add(lb);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(612, 552, 495, 30);
		contentPane.add(lblNewLabel);
		
		JButton add = new JButton("Add Details");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent eve) {
				
				if(txtStartTime.getText().trim().isEmpty()|| txtEndTime.getText().trim().isEmpty() ) {
					lb.setText("*Required");
				}
				else
				{
					lb.setText(" ");
				}
				
				if(((String) txtLec.getSelectedItem()).trim().isEmpty() ) {
					leclb.setText("*Required");
				}
				else
				{
					leclb.setText(" ");
				}
			
				if(((String) txtGroup.getSelectedItem()).trim().isEmpty() ) {
					grplb.setText("*Required");
				}
				else
				{
					grplb.setText(" ");
				}
				
			
				if(((String) txtSubGroup.getSelectedItem()).trim().isEmpty() ) {
					grplb_1.setText("*Required");
				}
				else
				{
					grplb_1.setText(" ");
				}
				if(((String) txtSessionID.getSelectedItem()).trim().isEmpty() ) {
					idlb.setText("*Required");
				}
				else
				{
					idlb.setText(" ");
				}
				
				if(((String) txtDay.getSelectedItem()).trim().isEmpty() ) {
					daylb.setText("*Required");
				}
				else
				{
					daylb.setText(" ");
				}
				
				if(txtStartTime.getText().equals("")||txtLec.getSelectedItem().equals("")||txtSubGroup.getSelectedItem().equals("")||txtGroup.getSelectedItem().equals("")||txtDay.getSelectedItem().equals("")||txtSessionID.getSelectedItem().equals("")||txtEndTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				
				else {
				try {
					connection = SqlServerConnection.dbConnecter();

					String query="INSERT INTO `NotAvailableTimeAllocation` (`Lecturer`, `Group`, `SubGroup`, `SessionID`, `Day`, `StartTime`, `EndTime`) VALUES(?,?,?,?,?,?,?)";                      
					PreparedStatement pst=connection.prepareStatement(query);
					
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
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					pst.close();
				}catch(Exception e) {
					e.printStackTrace();				}
				}
				
			}
		
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBackground(new Color(58, 83, 155));
		add.setBounds(370, 604, 262, 49);
		contentPane.add(add);
		
		JButton btnClear = new JButton("Clear Details");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStartTime.setText(null);
				txtEndTime.setText(null);
				txtLec.setSelectedIndex(-1);
				txtGroup.setSelectedIndex(-1);
				txtSubGroup.setSelectedIndex(-1);
				txtSessionID.setSelectedIndex(-1);
				txtDay.setSelectedIndex(-1);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBackground(new Color(0, 206, 209));
		btnClear.setBounds(724, 604, 262, 49);
		contentPane.add(btnClear);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2), "Add Not Available Time", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(311, 150, 759, 528);
		contentPane.add(panel_1);
		
		JButton btnViewAndManage_1 = new JButton("View And Manage Not Available Time Allocations");
		btnViewAndManage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageNotAvailableTime hp = new ManageNotAvailableTime();
				hp.notavailable();
				dispose();
			}
		});
		btnViewAndManage_1.setForeground(Color.WHITE);
		btnViewAndManage_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnViewAndManage_1.setBackground(new Color(0, 0, 128));
		btnViewAndManage_1.setBounds(491, 90, 415, 49);
		contentPane.add(btnViewAndManage_1);
		
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
		exitbtn.setBounds(1220, 89, 124, 50);
		contentPane.add(exitbtn);
		
		JButton btnBackToHome = new JButton("Back To Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage p = new HomePage();
			    p.Homeframe.setVisible(true);
			    dispose();
			}
		});
		btnBackToHome.setForeground(Color.WHITE);
		btnBackToHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnBackToHome.setBackground(new Color(25, 25, 112));
		btnBackToHome.setBounds(1086, 90, 124, 49);
		contentPane.add(btnBackToHome);
		
	
	}
}
