package Member3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import DBConnection.SqlServerConnection;
import Home.HomePage;
import Home.HomePage2;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AddTimeSlot extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();

	JPanel addTimeSlotFrame;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JComboBox slot;
	/**
	 * Launch the application.
	 */
	public static void addtimeslott() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTimeSlot frame = new AddTimeSlot();
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
	public void clear() {
		txtID.setText(null);
		txtStartTime.setText(null);
		txtEndTime.setText(null);
		slot.setSelectedIndex(-1);
		
	}
	public AddTimeSlot() {
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		addTimeSlotFrame = new JPanel();
		addTimeSlotFrame.setBackground(new Color(255, 255, 255));
		addTimeSlotFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addTimeSlotFrame);
		addTimeSlotFrame.setLayout(null);
		
		JLabel id = new JLabel("ID    :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Dialog", Font.BOLD, 14));
		id.setBounds(405, 214, 39, 19);
		addTimeSlotFrame.add(id);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(576, 209, 245, 33);
		addTimeSlotFrame.add(txtID);
		
		JLabel newlabb = new JLabel("");
		newlabb.setForeground(Color.RED);
		newlabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlabb.setBounds(831, 281, 477, 30);
		addTimeSlotFrame.add(newlabb);
		
		txtStartTime = new JTextField();
		txtStartTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setBounds(576, 278, 245, 33);
		addTimeSlotFrame.add(txtStartTime);
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
		
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setForeground(Color.BLACK);
		StartTime.setFont(new Font("Dialog", Font.BOLD, 14));
		StartTime.setBounds(405, 281, 125, 22);
		addTimeSlotFrame.add(StartTime);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(576, 330, 495, 30);
		addTimeSlotFrame.add(lblNewLabel);
		
	
		JLabel duration = new JLabel("Time Slot Duration   :");
		duration.setForeground(Color.BLACK);
		duration.setFont(new Font("Dialog", Font.BOLD, 14));
		duration.setBounds(405, 389, 164, 22);
		addTimeSlotFrame.add(duration);
		
		JLabel slotlb = new JLabel("");
		slotlb.setForeground(Color.RED);
		slotlb.setFont(new Font("Tahoma", Font.BOLD, 13));
		slotlb.setBounds(576, 422, 138, 14);
		addTimeSlotFrame.add(slotlb);
		
		slot = new JComboBox();
		slot.setFont(new Font("Tahoma", Font.BOLD, 13));
		slot.setModel(new DefaultComboBoxModel(new String[] {"","1 Hour", "30 Minutes"}));
		slot.setBackground(Color.WHITE);
		slot.setBounds(576, 385, 245, 33);
		addTimeSlotFrame.add(slot);
	
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setForeground(Color.BLACK);
		endTime.setFont(new Font("Dialog", Font.BOLD, 14));
		endTime.setBounds(405, 457, 89, 22);
		addTimeSlotFrame.add(endTime);
		
		txtEndTime = new JTextField();
		txtEndTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEndTime.setColumns(10);
		txtEndTime.setBackground(Color.WHITE);
		txtEndTime.setBounds(576, 453, 245, 33);
		addTimeSlotFrame.add(txtEndTime);
		
		JLabel lbstart = new JLabel("");
		lbstart.setForeground(Color.RED);
		lbstart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbstart.setBounds(576, 316, 138, 14);
		addTimeSlotFrame.add(lbstart);
		
		JLabel lbend = new JLabel("");
		lbend.setForeground(Color.RED);
		lbend.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbend.setBounds(576, 491, 138, 14);
		addTimeSlotFrame.add(lbend);
		
		JLabel slabbb = new JLabel("");
		slabbb.setForeground(Color.RED);
		slabbb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabbb.setBounds(827, 457, 495, 30);
		addTimeSlotFrame.add(slabbb);
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(576, 503, 495, 30);
		addTimeSlotFrame.add(lblNewLabel_1);
		
		JButton add = new JButton("Add Details");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent eve) {
				
				if(txtStartTime.getText().trim().isEmpty() ) {
					lbstart.setText("*Required");
				}
				else
				{
					lbstart.setText(" ");
				}
				
				if(txtEndTime.getText().trim().isEmpty() ) {
					lbend.setText("*Required");
				}
				else
				{
					lbend.setText(" ");
				}
			
				if(((String) slot.getSelectedItem()).trim().isEmpty() ) {
					slotlb.setText("*Required");
				}
				else
				{
					slotlb.setText(" ");
				}
				
				if(txtStartTime.getText().equals("")||slot.getSelectedItem().equals("")||txtEndTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
			

				else {
				try {
					connection = SqlServerConnection.dbConnecter();

					String query="insert into TimeSlot(startTime,Duration,endTime) values(?,?,?)";                      
					PreparedStatement pst=connection.prepareStatement(query);
					
					String start = txtStartTime.getText().toString();
					pst.setString(1, start);
					
					String durations = slot.getSelectedItem().toString();
					pst.setString(2, durations);
					
					String end = txtEndTime.getText().toString();
					pst.setString(3, end);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					pst.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				}
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBackground(new Color(58,83,155));
		add.setBounds(363, 558, 262, 49);
		addTimeSlotFrame.add(add);
		
		JButton btnViewAndManage = new JButton("View And Manage Time Slot");
		btnViewAndManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageTimeSlot hp = new ManageTimeSlot();
				hp.manageTimeslot();
				dispose();
			}
		});
		btnViewAndManage.setForeground(Color.WHITE);
		btnViewAndManage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnViewAndManage.setBackground(new Color(0, 0, 128));
		btnViewAndManage.setBounds(526, 90, 262, 49);
		addTimeSlotFrame.add(btnViewAndManage);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		addTimeSlotFrame.add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTimeSlotFrame= new JPanel();
				if (JOptionPane.showConfirmDialog(addTimeSlotFrame,"Conform if you want to exit !","System",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 90, 124, 50);
		addTimeSlotFrame.add(exitbtn);
		
		JButton btnClear = new JButton("Clear Details");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
				txtStartTime.setText(null);
				txtEndTime.setText(null);
				slot.setSelectedIndex(-1);
			
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBackground(new Color(0, 206, 209));
		btnClear.setBounds(726, 558, 262, 49);
		addTimeSlotFrame.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2, true), "Add New Time Slot", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(282, 170, 792, 475);
		addTimeSlotFrame.add(panel_1);
		
		JButton btnBackToHome = new JButton("Back To Home");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage2 p = new HomePage2();
			    p.wokingDayHourframe.setVisible(true);
			    dispose();
			}
		});
		btnBackToHome.setForeground(Color.WHITE);
		btnBackToHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnBackToHome.setBackground(new Color(25, 25, 112));
		btnBackToHome.setBounds(1080, 90, 124, 49);
		addTimeSlotFrame.add(btnBackToHome);
	}
}