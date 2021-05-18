package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DBConnection.SqlServerConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSessionWithDay extends JFrame {
	Connection connection = SqlServerConnection.dbConnecter();
	private JPanel contentPane;
	private JTextField startTime;
	private JTextField enddTime;
	private JComboBox sessionIDcom;
	private JComboBox txtDaycom;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessionWithDay frame = new AddSessionWithDay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
				sessionIDcom.addItem(rs.getString("SessionId"));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	/**
	 * Create the frame.
	 */
	public AddSessionWithDay() {
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
		
		JButton btnViewAndManage_1 = new JButton("View And Manage Sessions Time & Date");
		btnViewAndManage_1.setForeground(Color.WHITE);
		btnViewAndManage_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnViewAndManage_1.setBackground(new Color(0, 0, 128));
		btnViewAndManage_1.setBounds(481, 110, 383, 49);
		contentPane.add(btnViewAndManage_1);
		
		JButton btnBackToHome = new JButton("Back To Home");
		btnBackToHome.setForeground(Color.WHITE);
		btnBackToHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnBackToHome.setBackground(new Color(25, 25, 112));
		btnBackToHome.setBounds(1076, 111, 124, 49);
		contentPane.add(btnBackToHome);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 110, 124, 50);
		contentPane.add(exitbtn);
		
		JLabel lblSessionId = new JLabel("Session ID  :");
		lblSessionId.setForeground(Color.BLACK);
		lblSessionId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSessionId.setBounds(346, 228, 164, 22);
		contentPane.add(lblSessionId);
		
		sessionIDcom = new JComboBox();
		sessionIDcom.setFont(new Font("Tahoma", Font.BOLD, 13));
		sessionIDcom.setBackground(Color.WHITE);
		sessionIDcom.setBounds(561, 224, 356, 33);
		contentPane.add(sessionIDcom);
		FillSessionIDComboBox(connection);
		
		JLabel lblSelectTheDay_1 = new JLabel("Select The Day  :");
		lblSelectTheDay_1.setForeground(Color.BLACK);
		lblSelectTheDay_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectTheDay_1.setBounds(346, 291, 164, 22);
		contentPane.add(lblSelectTheDay_1);
		
		txtDaycom = new JComboBox();
		txtDaycom.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDaycom.setModel(new DefaultComboBoxModel(new String[] {"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		txtDaycom.setBackground(Color.WHITE);
		txtDaycom.setBounds(561, 287, 356, 33);
		contentPane.add(txtDaycom);
		
		JLabel StartTime = new JLabel("Start Time    :");
		StartTime.setForeground(Color.BLACK);
		StartTime.setFont(new Font("Dialog", Font.BOLD, 14));
		StartTime.setBounds(346, 354, 125, 22);
		contentPane.add(StartTime);
		
		startTime = new JTextField();
		startTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		startTime.setColumns(10);
		startTime.setBackground(Color.WHITE);
		startTime.setBounds(561, 350, 356, 33);
		contentPane.add(startTime);
		
		JLabel lblNewLabel = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(561, 406, 495, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lbend = new JLabel("");
		lbend.setForeground(Color.RED);
		lbend.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbend.setBounds(918, 457, 138, 14);
		contentPane.add(lbend);
		
		JLabel lbday = new JLabel("");
		lbday.setForeground(Color.RED);
		lbday.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbday.setBounds(560, 325, 138, 14);
		contentPane.add(lbday);
		
		JLabel lbsesID = new JLabel("");
		lbsesID.setForeground(Color.RED);
		lbsesID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbsesID.setBounds(560, 262, 138, 14);
		contentPane.add(lbsesID);
		
		JLabel endTime = new JLabel("End Time    :");
		endTime.setForeground(Color.BLACK);
		endTime.setFont(new Font("Dialog", Font.BOLD, 14));
		endTime.setBounds(346, 451, 89, 22);
		contentPane.add(endTime);
		
		JLabel lbstart = new JLabel("");
		lbstart.setForeground(Color.RED);
		lbstart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbstart.setBounds(918, 360, 138, 14);
		contentPane.add(lbstart);
		
		enddTime = new JTextField();
		enddTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		enddTime.setColumns(10);
		enddTime.setBackground(Color.WHITE);
		enddTime.setBounds(561, 447, 356, 33);
		contentPane.add(enddTime);
		
		JLabel lblNewLabel_1 = new JLabel("Hint : The entering time should be 24 hour format - Ex : 12:30");
		lblNewLabel_1.setForeground(new Color(0, 0, 205));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(561, 506, 495, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel slabbb = new JLabel("");
		slabbb.setForeground(Color.RED);
		slabbb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		slabbb.setBounds(561, 477, 495, 30);
		contentPane.add(slabbb);
		
		JLabel newlabb = new JLabel("");
		newlabb.setForeground(Color.RED);
		newlabb.setFont(new Font("Tahoma", Font.ITALIC, 13));
		newlabb.setBounds(561, 382, 477, 30);
		contentPane.add(newlabb);
		
		JButton add = new JButton("Add Details");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(startTime.getText().trim().isEmpty() ) {
					lbstart.setText("*Required");
				}
				else
				{
					lbstart.setText(" ");
				}
				
				if(enddTime.getText().trim().isEmpty() ) {
					lbend.setText("*Required");
				}
				else
				{
					lbend.setText(" ");
				}
				
				if(((String) sessionIDcom.getSelectedItem()).trim().isEmpty() ) {
					lbsesID.setText("*Required");
				}
				else
				{
					lbsesID.setText(" ");
				}
			
				if(((String) txtDaycom.getSelectedItem()).trim().isEmpty() ) {
					lbday.setText("*Required");
				}
				else
				{
					lbday.setText(" ");
				}
				
			
				
				if(startTime.getText().equals("")||sessionIDcom.getSelectedItem().equals("")||txtDaycom.getSelectedItem().equals("")||enddTime.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Compleate Information");
				}
				
				else {
					
					String sessionid = sessionIDcom.getSelectedItem().toString();
					String day = txtDaycom.getSelectedItem().toString();
					String startT=startTime.getText();
					String endT= enddTime.getText();

				try {
					connection = SqlServerConnection.dbConnecter();

					PreparedStatement s1a1;
					s1a1 = connection.prepareStatement("update session set date= ?, startingTime= ?,endTime= ?  where SessionId=?");
					s1a1.setString(1,day );
					s1a1.setString(2,startT );
					s1a1.setString(3,endT );
					s1a1.setString(4,sessionid );
					
					s1a1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
					
					s1a1.close();
				}catch(Exception e) {
					e.printStackTrace();				}
				}
				
			}
		
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBackground(new Color(58, 83, 155));
		add.setBounds(346, 574, 262, 49);
		contentPane.add(add);
		
		JButton btnClear1 = new JButton("Clear Details");
		btnClear1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear1.setBackground(new Color(0, 206, 209));
		btnClear1.setBounds(737, 574, 262, 49);
		contentPane.add(btnClear1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2), "Add Session With Date & Time", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(273, 170, 759, 484);
		contentPane.add(panel_1);
	}
}
