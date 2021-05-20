package Home;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.SqlServerConnection;
import Member1.Consec_sessions;
import Member2.AddManageLecturer;
import Member2.Sessions;
import Member3.AddSessionWithDay;
import Member3.ManageSessionWithDay;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SessionMain extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextArea txtrTimeTableManagement;
	private JButton AddSessionsBtn;
	private JButton AddCPOSessions;

	private JButton btnBack;
	private JLabel lblNewLabel;
	private JButton btnManageSessionDays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionMain frame = new SessionMain();
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
	public SessionMain() {
		connection = SqlServerConnection.dbConnecter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//header
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1365, 75);
		panel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(75, 119, 190));
		contentPane.add(panel_1);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setText("Timetable Management System");
		panel_1.add(txtrTimeTableManagement);
		
		AddSessionsBtn = new JButton("Add and Manage Sessions");
		AddSessionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame addManageSessions = new Sessions();
				addManageSessions.show();
				
				dispose();
			}
		});
		AddSessionsBtn.setForeground(Color.WHITE);
		AddSessionsBtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		AddSessionsBtn.setBackground(new Color(0, 0, 139));
		AddSessionsBtn.setBounds(772, 208, 435, 66);
		contentPane.add(AddSessionsBtn);
		
		AddCPOSessions = new JButton("Add Consecutive, Parallel, NonOverlapping Sessions");
		AddCPOSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Consec_sessionspage = new Consec_sessions();
				Consec_sessionspage.show();

				dispose();
				
				try {
					connection = SqlServerConnection.dbConnecter();
					
					//retrieve data to a table
					String query = "select SessionIndex,LecturerNameSession,SubjectCodeSession,SubjectNameSession,TagSession,GroupIDSession,StudentCountSession,SessionDuration,SessionId,startingTime,endTime from session";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					
					Consec_sessions.sessionListTable.setModel(DbUtils.resultSetToTableModel(rs));
					
					String query3 = "select * from ConsecutiveSession";
					PreparedStatement psat3 = connection.prepareStatement(query3);
					ResultSet rs3= psat3.executeQuery();
					
					Consec_sessions.ViewConSessions.setModel(DbUtils.resultSetToTableModel(rs3));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				
				
				
			}
		});
		AddCPOSessions.setForeground(Color.WHITE);
		AddCPOSessions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		AddCPOSessions.setBackground(new Color(0, 0, 139));
		AddCPOSessions.setBounds(772, 342, 435, 66);
		contentPane.add(AddCPOSessions);
		
		btnBack = new JButton("Back");
		btnBack.setBorder(new LineBorder(new Color(64, 64, 64)));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*StudentGroupManagement myhome = new StudentGroupManagement();
				myhome.Show();*/
				
				HomePage home = new HomePage();
				home.Show();
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1146, 86, 177, 38);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SessionMain.class.getResource("/Images/How-to-make-an-effective-timetable-for-CAT-preparation.png")));
		lblNewLabel.setBounds(22, 98, 906, 563);
		contentPane.add(lblNewLabel);
		
		btnManageSessionDays = new JButton("Manage Session Days And Time");
		btnManageSessionDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame AddSessionWithDay = new AddSessionWithDay();
				AddSessionWithDay.show();
				
				dispose();
			}
		});
		btnManageSessionDays.setForeground(Color.WHITE);
		btnManageSessionDays.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnManageSessionDays.setBackground(new Color(0, 0, 139));
		btnManageSessionDays.setBounds(772, 479, 435, 66);
		contentPane.add(btnManageSessionDays);
	}
}
