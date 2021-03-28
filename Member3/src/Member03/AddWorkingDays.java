package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddWorkingDays extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	private JPanel addwframe;
	private JTextField textField;
	private JTextField hour;
	private JTextField minutes;

	/**
	 * Launch the application.
	 */
	public static void addDays() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkingDays frame = new AddWorkingDays();
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
	public void clear()
	{
		
		hour.setText(null);
		minutes.setText(null);
		
	}
	public AddWorkingDays() {
		connection = SqlServerConnection.dbConnecter();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		addwframe = new JPanel();
		addwframe.setBackground(new Color(255, 255, 255));
		addwframe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addwframe);
		addwframe.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		addwframe.add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		JLabel lblId = new JLabel("ID  :");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(361, 244, 219, 23);
		addwframe.add(lblId);
		
		JLabel l1 = new JLabel("Number of Working Days :");
		l1.setFont(new Font("Dialog", Font.BOLD, 14));
		l1.setBounds(361, 290, 237, 23);
		addwframe.add(l1);
		
		JLabel workingDays = new JLabel("Working Days :");
		workingDays.setFont(new Font("Dialog", Font.BOLD, 14));
		workingDays.setBounds(361, 338, 219, 23);
		addwframe.add(workingDays);
		
		
		
		JCheckBox monday = new JCheckBox("Monday");
		monday.setFont(new Font("Dialog", Font.BOLD, 12));
		monday.setBounds(702, 338, 108, 25);
		addwframe.add(monday);
		
		JCheckBox tuesday = new JCheckBox("Tuesday");
		tuesday.setFont(new Font("Dialog", Font.BOLD, 12));
		tuesday.setBounds(702, 380, 108, 23);
		addwframe.add(tuesday);
		
		JCheckBox wednesday = new JCheckBox("Wednesday");
		wednesday.setFont(new Font("Dialog", Font.BOLD, 12));
		wednesday.setBounds(702, 422, 108, 23);
		addwframe.add(wednesday);
		
		JCheckBox thursday = new JCheckBox("Thursday");
		thursday.setFont(new Font("Dialog", Font.BOLD, 12));
		thursday.setBounds(702, 461, 108, 22);
		addwframe.add(thursday);
		
		JCheckBox saturday = new JCheckBox("Saturday");
		saturday.setFont(new Font("Dialog", Font.BOLD, 12));
		saturday.setBounds(870, 380, 108, 23);
		addwframe.add(saturday);
		
		JCheckBox sunday = new JCheckBox("Sunday");
		sunday.setFont(new Font("Dialog", Font.BOLD, 12));
		sunday.setBounds(869, 422, 109, 23);
		addwframe.add(sunday);
		
		JCheckBox friday = new JCheckBox("Friday");
		friday.setFont(new Font("Dialog", Font.BOLD, 12));
		friday.setBounds(870, 337, 108, 26);
		addwframe.add(friday);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(702, 244, 276, 25);
		addwframe.add(textField);
		
		JComboBox txtworkigDaysNum = new JComboBox();
		txtworkigDaysNum.setFont(new Font("Dialog", Font.BOLD, 12));
		txtworkigDaysNum.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "6","7"}));

		txtworkigDaysNum.setBounds(702, 290, 276, 25);
		addwframe.add(txtworkigDaysNum);
		
		JLabel workingTimePerDay = new JLabel("Working Time Per Day :");
		workingTimePerDay.setFont(new Font("Dialog", Font.BOLD, 14));
		workingTimePerDay.setBounds(361, 507, 219, 23);
		addwframe.add(workingTimePerDay);
		
		JLabel lblNewLabel = new JLabel("Hours");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(707, 511, 46, 14);
		addwframe.add(lblNewLabel);
		
		JLabel labErr = new JLabel("");
		labErr.setForeground(new Color(255, 0, 0));
		labErr.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		labErr.setBounds(707, 551, 271, 23);
		addwframe.add(labErr);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMinutes.setBounds(842, 511, 87, 14);
		addwframe.add(lblMinutes);
		JButton clearbtn = new JButton("Clear Details");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hour.setText(null);
				minutes.setText(null);
				txtworkigDaysNum.setSelectedIndex(-1);
				
			}
		});
		clearbtn.setForeground(Color.BLACK);
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		clearbtn.setBackground(Color.CYAN);
		clearbtn.setBounds(730, 605, 229, 51);
		addwframe.add(clearbtn);
		
		JButton addbtn = new JButton("Add Details");
		addbtn = new JButton("Add Details");
		addbtn.setBackground(new Color(58,83,155));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hour.getText().equals("")||txtworkigDaysNum.getSelectedItem().equals("")||minutes.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				else {
			try {	
				
				
				//get working days and hours
				String query="insert into WorkingDaysHours(NumberOfWorkingDays,WorkingDays,WorkingHours,WorkingMinutes) values(?,?,?,?)";                      
				PreparedStatement pst=connection.prepareStatement(query);
			
				
				//get number of working days and hours
				String workingDay=txtworkigDaysNum.getSelectedItem().toString();
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
				
				String WorkingTimeMinutes=minutes.getText().toString();
				pst.setString(4, WorkingTimeMinutes);
				
				
				
				//Display successful massage when data was inserted to the database successfully:
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				
				pst.close();
				
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			  clear();
			
			}
			}
		});
		addbtn.setForeground(Color.WHITE);
		addbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addbtn.setBackground(new Color(58,83,155));
		addbtn.setBounds(389, 604, 229, 52);
		addwframe.add(addbtn);
		
		hour = new JTextField();
		hour.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				//validate the field
				
				char c =evt.getKeyChar();
				if(Character.isLetter(c)) {
				
				//can not able to enter in filed if enter char is not number
				hour.setEditable(false);
				labErr.setText("Please Enter Number Only");
				}
				else {
					hour.setEditable(true);
					labErr.setText("---");
				}
			}
		});
		hour.setColumns(10);
		hour.setBackground(Color.WHITE);
		hour.setBounds(752, 507, 78, 26);
		addwframe.add(hour);
		
		minutes = new JTextField();
		minutes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				//validate the field
				
				char c =evt.getKeyChar();
				if(Character.isLetter(c)) {
				
				//can not able to enter in filed if enter char is not number
					minutes.setEditable(false);
				labErr.setText("Please Enter Number Only");
				}
				else {
					minutes.setEditable(true);
					labErr.setText("---");
				}
			}
		});
		minutes.setColumns(10);
		minutes.setBackground(Color.WHITE);
		minutes.setBounds(900, 507, 78, 26);
		addwframe.add(minutes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		panel_1.setBounds(275, 219, 848, 459);
		addwframe.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("----------Add Working Days And Hours---------");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(529, 187, 400, 21);
		addwframe.add(lblNewLabel_1);
		
		JButton btnViewAndManage_1 = new JButton("View And Manage Working Hours");
		btnViewAndManage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ManageWorkingDaysHours hp = new ManageWorkingDaysHours();
					hp.manageDays();
					dispose();
				
			}
		});
		btnViewAndManage_1.setForeground(Color.WHITE);
		btnViewAndManage_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnViewAndManage_1.setBackground(new Color(0, 0, 128));
		btnViewAndManage_1.setBounds(539, 110, 306, 49);
		addwframe.add(btnViewAndManage_1);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addwframe= new JPanel();
				if (JOptionPane.showConfirmDialog(addwframe,"Conform if you want to exit !","System",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 84, 124, 50);
		addwframe.add(exitbtn);
		
		
		

	}
}
