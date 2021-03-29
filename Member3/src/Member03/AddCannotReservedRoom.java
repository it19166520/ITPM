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
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class AddCannotReservedRoom extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCannotReservedRoom frame = new AddCannotReservedRoom();
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
	public AddCannotReservedRoom() {
		connection = SqlServerConnection.dbConnecter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("ID    :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Dialog", Font.BOLD, 14));
		id.setBounds(359, 203, 39, 19);
		contentPane.add(id);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(574, 197, 356, 33);
		contentPane.add(txtID);
		
		JLabel lblSelectTheRoom = new JLabel("Select The Room  :");
		lblSelectTheRoom.setForeground(Color.BLACK);
		lblSelectTheRoom.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheRoom.setBounds(359, 264, 164, 22);
		contentPane.add(lblSelectTheRoom);
		
		JComboBox txtRoom = new JComboBox();
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRoom.setBackground(Color.WHITE);
		txtRoom.setModel(new DefaultComboBoxModel(new String[] {"","A501","F501","B502","N3B-PcLab","A3B-PcLab","C3B-PcLab"}));
		txtRoom.setBounds(574, 260, 356, 33);
		contentPane.add(txtRoom);
		
		JLabel lblSelectTheDay = new JLabel("Select The Day  :");
		lblSelectTheDay.setForeground(Color.BLACK);
		lblSelectTheDay.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheDay.setBounds(359, 327, 164, 22);
		contentPane.add(lblSelectTheDay);
		
		JComboBox txtDay = new JComboBox();
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDay.setBackground(Color.WHITE);
		txtDay.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDay.setBounds(574, 323, 356, 33);
		contentPane.add(txtDay);
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setForeground(Color.BLACK);
		StartTime.setFont(new Font("Dialog", Font.BOLD, 14));
		StartTime.setBounds(359, 390, 125, 22);
		contentPane.add(StartTime);
		
		JLabel newlabb = new JLabel("");
		newlabb.setForeground(Color.RED);
		newlabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlabb.setBounds(574, 418, 477, 30);
		contentPane.add(newlabb);
		
		txtStartTime = new JTextField();
		txtStartTime.addKeyListener(new KeyAdapter() {
			@Override
		
				//Validate the field
				public void keyPressed(java.awt.event.KeyEvent evt) {
					// set a pattern
					String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
					Pattern patt= Pattern.compile(PATTERN);

					Matcher match = patt.matcher(txtStartTime.getText());
				if(!match.matches()) {
					newlabb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
				}
				else {
					newlabb.setText("---");
				}
				}
			});

		txtStartTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setBounds(574, 386, 356, 33);
		contentPane.add(txtStartTime);
		
	
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(574, 442, 495, 30);
		contentPane.add(lblNewLabel);
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setForeground(Color.BLACK);
		endTime.setFont(new Font("Dialog", Font.BOLD, 14));
		endTime.setBounds(359, 487, 89, 22);
		contentPane.add(endTime);
		
		JLabel slabbb = new JLabel("");
		slabbb.setForeground(Color.RED);
		slabbb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabbb.setBounds(574, 513, 495, 30);
		contentPane.add(slabbb);
		
		txtEnd = new JTextField();
		txtEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				// set a pattern
				String PATTERN = "([01]?[0-9]|2[0-4]):[0-5]";
				Pattern patt= Pattern.compile(PATTERN);

				Matcher match = patt.matcher(txtEnd.getText());
			if(!match.matches()) {
				slabbb.setText("Incorrect entered time pattern. Please fallow the given instruction!");
			}
			else {
				slabbb.setText("---");
			}
			}
		});

		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnd.setColumns(10);
		txtEnd.setBackground(Color.WHITE);
		txtEnd.setBounds(574, 483, 356, 33);
		contentPane.add(txtEnd);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(574, 542, 495, 30);
		contentPane.add(lblNewLabel_1);
			
			JButton btnClear = new JButton("Clear Details");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtStartTime.setText(null);
					txtEnd.setText(null);
					txtRoom.setSelectedIndex(-1);				
					txtDay.setSelectedIndex(-1);
				}
			});
		
		JButton btnClear1 = new JButton("Clear Details");
		btnClear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText(null);
				txtStartTime.setText(null);
				txtEnd.setText(null);
				txtRoom.setSelectedIndex(-1);
				txtDay.setSelectedIndex(-1);
			}
		});
		btnClear1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear1.setBackground(new Color(0, 206, 209));
		btnClear1.setBounds(735, 583, 262, 49);
		contentPane.add(btnClear1);
		
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
		
		JButton btnViewAndManage = new JButton("View And Manage Time Slot");
		btnViewAndManage.setForeground(Color.WHITE);
		btnViewAndManage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnViewAndManage.setBackground(new Color(0, 0, 128));
		btnViewAndManage.setBounds(543, 90, 262, 49);
		contentPane.add(btnViewAndManage);
		
		JButton add = new JButton("Add Details");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStartTime.getText().equals("")||txtEnd.getText().equals("")||txtRoom.getSelectedItem().equals("")||txtDay.getSelectedItem().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				else {
				try {
					String query="INSERT INTO `RoomCannotBeReserved` (`Room`, `Day`,`StartTime`, `EndTime`) VALUES(?,?,?,?)";                      
					PreparedStatement pst=connection.prepareStatement(query);
					
					String room = txtRoom.getSelectedItem().toString();
					pst.setString(1, room);
					
					String days = txtDay.getSelectedItem().toString();
					pst.setString(2, days);
					
					String st = txtStartTime.getText().toString();
					pst.setString(3, st);
					

					String et = txtEnd.getText().toString();
					pst.setString(4, et);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				}
				
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBackground(new Color(58, 83, 155));
		add.setBounds(359, 583, 262, 49);
		contentPane.add(add);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(278, 174, 792, 504);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("----------Add A Room Details Which Cannot Be Reserved---------");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(456, 150, 454, 21);
		contentPane.add(lblNewLabel_1_1);
	}
}
