package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class AddNotAvailableTime extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JComboBox txtLec;
	private JComboBox txtGroup;
	private JComboBox txtSubGrpup;
	private JComboBox txtDay;
	
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

	/**
	 * Create the frame.
	 */public void clear()
		{
			txtStartTime.setText(null);
			txtEndTime.setText(null);
			txtLec.setSelectedIndex(-1);
			txtGroup.setSelectedIndex(-1);
			
			txtDay.setSelectedIndex(-1);
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
		id.setBounds(370, 219, 39, 19);
		contentPane.add(id);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(613, 213, 359, 33);
		contentPane.add(txtID);
		
		JLabel lblSelectLecturer = new JLabel("Select Lecturer  :");
		lblSelectLecturer.setForeground(Color.BLACK);
		lblSelectLecturer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectLecturer.setBounds(370, 266, 143, 19);
		contentPane.add(lblSelectLecturer);
		
		JComboBox txtLec = new JComboBox();
		txtLec.setModel(new DefaultComboBoxModel(new String[] {"","Mr. Senanayske", "Mrs. Gunathilake","Mr. jayarathne","Mrs. Athukorala","Ms. Susantha"}));
		txtLec.setBounds(613, 261, 359, 33);
		contentPane.add(txtLec);
		
		JLabel lblSelectGroup = new JLabel("Select Group   :");
		lblSelectGroup.setForeground(Color.BLACK);
		lblSelectGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectGroup.setBounds(370, 318, 143, 19);
		contentPane.add(lblSelectGroup);
		
		JComboBox txtGroup = new JComboBox();
		txtGroup.setModel(new DefaultComboBoxModel(new String[] {"","Y2.S2.1", "Y3.S2.2", "Y4.S1.3", "Y1.S2.4", "Y2.S1.5", "Y1.S2.6", "Y1.S2.7", "Y1.S2.8","Y1.S2.9"}));
		txtGroup.setBounds(613, 313, 359, 33);
		contentPane.add(txtGroup);
		
		JLabel lblSelectSubGroup = new JLabel("Select Sub Group   :");
		lblSelectSubGroup.setForeground(Color.BLACK);
		lblSelectSubGroup.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSubGroup.setBounds(370, 368, 143, 19);
		contentPane.add(lblSelectSubGroup);
		
		JComboBox txtSubGroup = new JComboBox();
		txtSubGroup.setModel(new DefaultComboBoxModel(new String[] {"","1","2","3","4","5"}));
		txtSubGroup.setBounds(613, 363, 359, 33);
		contentPane.add(txtSubGroup);
		
		JLabel lblSelectSessionId = new JLabel("Select Session ID  :");
		lblSelectSessionId.setForeground(Color.BLACK);
		lblSelectSessionId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSessionId.setBounds(370, 425, 143, 19);
		contentPane.add(lblSelectSessionId);
		
		JComboBox txtSessionID = new JComboBox();
		txtSessionID.setModel(new DefaultComboBoxModel(new String[] {"","IT2030-OOC–Lecture–Y1.S1.IT.01–120- 2","IT2015-PAF–Lecture–Y2.S1.IT.01–120- 2","IT1530-NDM–Lecture–Y3.S1.IT.01–120- 2"}));
		txtSessionID.setBounds(613, 420, 359, 33);
		contentPane.add(txtSessionID);
		
		JLabel labErr = new JLabel("");
		labErr.setForeground(Color.RED);
		labErr.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		labErr.setBounds(613, 562, 422, 26);
		contentPane.add(labErr);
		
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
				labErr.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				labErr.setText("---");
			}
			}
		});
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setBounds(613, 535, 78, 26);
		
		contentPane.add(txtStartTime);
		
		JLabel to = new JLabel("To");
		to.setFont(new Font("Dialog", Font.BOLD, 14));
		to.setBounds(712, 535, 39, 14);
		contentPane.add(to);
		
		txtEndTime = new JTextField();
		txtEndTime.setColumns(10);
		txtEndTime.setBackground(Color.WHITE);
		txtEndTime.setBounds(761, 535, 78, 26);
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
		lblTimePeriod.setBounds(370, 542, 143, 19);
		contentPane.add(lblTimePeriod);
		
		JLabel lblSelectDay = new JLabel("Select Day  :");
		lblSelectDay.setForeground(Color.BLACK);
		lblSelectDay.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectDay.setBounds(370, 488, 143, 19);
		contentPane.add(lblSelectDay);
		
		JComboBox txtDay = new JComboBox();
		txtDay.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDay.setBounds(613, 483, 359, 33);
		contentPane.add(txtDay);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(612, 587, 495, 30);
		contentPane.add(lblNewLabel);
		
		JButton add = new JButton("Add Details");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtStartTime.getText().equals("")||txtLec.getSelectedItem().equals("")||txtSubGroup.getSelectedItem().equals("")||txtGroup.getSelectedItem().equals("")||txtDay.getSelectedItem().equals("")||txtSessionID.getSelectedItem().equals("")||txtEndTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				else {
				try {
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
					JOptionPane.showMessageDialog(null, e);
				}
				}
				clear();
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBackground(new Color(58, 83, 155));
		add.setBounds(370, 615, 262, 49);
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
		btnClear.setBounds(726, 615, 262, 49);
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
		
		JLabel lblNewLabel_1 = new JLabel("----------Add Not Available Time---------");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(523, 150, 400, 21);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(311, 180, 749, 498);
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
		
	
	}
}
