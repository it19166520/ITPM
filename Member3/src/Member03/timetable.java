package Member03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DBConnection.SqlServerConnection;

import javax.swing.JComboBox;

public class timetable extends JFrame {

	private JPanel contentPane;
	private JButton StudentButton;
	private JButton LocationTButton;
	private JButton LecturerButton;
	private JLayeredPane layeredPane;
	private JComboBox LecturerNameCombo;
	private JPanel Lecturer;
	private JPanel Student;
	private JPanel Location;
	private JTable table_lec;
	private JTable table_1;
	private JScrollPane scrol_2;
	private JTable table_2;
	private JComboBox StudentGroupIDCombo_1;
	private JComboBox RoomIDCombo_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton load;
	private JButton load_1;
	private JButton load_2;
	private JButton btnBackToHome;

	/**
	 * Launch the application.
	 */
	public static void genTimetable() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timetable frame = new timetable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void swichpannels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public void fillLecturerName() {



		try {

			Connection conn = SqlServerConnection.dbConnecter();
	
			String query="select * from Lecturer";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();

		while(rs.next()) {

			LecturerNameCombo.addItem(rs.getString("LecturerName"));
		}

		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	public void fillStudentGroupID() {



		try {

			Connection conn = SqlServerConnection.dbConnecter();
	
			String query="select * from StudentGroups";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();

		while(rs.next()) {

			StudentGroupIDCombo_1.addItem(rs.getString("GroupID"));
		}

		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	public void fillRoomID() {



		try {

			Connection conn = SqlServerConnection.dbConnecter();
	
			String query="select * from addLocation";
			PreparedStatement pst=conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();

		while(rs.next()) {

			RoomIDCombo_1.addItem(rs.getString("RoomName"));
		}

		}catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public timetable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 1356, 75);
		panel_7.setLayout(null);
		panel_7.setForeground(Color.WHITE);
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel_7.setBackground(new Color(75, 119, 190));
		contentPane.add(panel_7);
		
		JLabel lblNewLabel_23 = new JLabel("Timetable Management System");
		lblNewLabel_23.setForeground(Color.WHITE);
		lblNewLabel_23.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		lblNewLabel_23.setBounds(533, 10, 466, 55);
		panel_7.add(lblNewLabel_23);
		
		LecturerButton = new JButton("Lecturer");
		LecturerButton.setBounds(31, 111, 85, 31);
		LecturerButton.setBackground(new Color(0, 0, 205));
		LecturerButton.setForeground(Color.WHITE);
		LecturerButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		LecturerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				swichpannels(Lecturer);
				
			}
		});
		contentPane.add(LecturerButton);
		
		StudentButton = new JButton("Student");
		StudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				swichpannels(Student);
			}
		});
		StudentButton.setBounds(114, 111, 99, 31);
		StudentButton.setBackground(new Color(0, 0, 205));
		StudentButton.setForeground(Color.WHITE);
		StudentButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(StudentButton);
		
		LocationTButton = new JButton("Location");
		LocationTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				swichpannels(Location);
			}
		});
		LocationTButton.setBounds(212, 111, 105, 31);
		LocationTButton.setBackground(new Color(0, 0, 205));
		LocationTButton.setForeground(Color.WHITE);
		LocationTButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(LocationTButton);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane.setBounds(30, 143, 1316, 548);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Lecturer = new JPanel();
		Lecturer.setBackground(new Color(255, 255, 255));
		layeredPane.add(Lecturer, "name_44670068792100");
		Lecturer.setLayout(null);
		
		JScrollPane scrol = new JScrollPane();
		scrol.setBounds(10, 130, 1221, 268);
		Lecturer.add(scrol);
		
		table_lec = new JTable();
		scrol.setViewportView(table_lec);
		table_lec.setModel(new DefaultTableModel(
			new Object[][] {
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
				{"8:00-9:00", null, null, null, null, null, null, null},
			},
			new String[] {
				"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		));
		table_lec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_lec.setSelectionBackground(new Color(107, 185, 240));
		table_lec.setRowHeight(30);
		table_lec.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_lec.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		LecturerNameCombo = new JComboBox();
		LecturerNameCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LecturerNameCombo.setBackground(Color.WHITE);
		LecturerNameCombo.setBounds(130, 27, 332, 28);
		Lecturer.add(LecturerNameCombo);
		
		JLabel lblNewLabel = new JLabel("Lecturer :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 23, 95, 28);
		Lecturer.add(lblNewLabel);
		
		JButton GenBtn = new JButton("Generate Timetable");
		GenBtn.setForeground(Color.WHITE);
		GenBtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn.setBackground(new Color(27, 163, 156));
		GenBtn.setBounds(488, 20, 180, 38);
		Lecturer.add(GenBtn);
		
		load_2 = new JButton("Print Timetable");
		load_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat("I am the header of the printer page");
				MessageFormat footer = new MessageFormat("I am the footer of the printer page");
				
				try {
					
					table_lec.print(JTable.PrintMode.NORMAL, header , footer);
				}catch(Exception e1){
					
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		load_2.setForeground(Color.WHITE);
		load_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load_2.setBackground(new Color(0, 0, 139));
		load_2.setBounds(695, 20, 193, 38);
		Lecturer.add(load_2);
		
		fillLecturerName();
		Student = new JPanel();
		Student.setBackground(new Color(255, 255, 255));
		layeredPane.add(Student, "name_44720974333500");
		Student.setLayout(null);
		
		JScrollPane scrol_1 = new JScrollPane();
		scrol_1.setBounds(10, 129, 1221, 268);
		Student.add(scrol_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
				},
				new String[] {
					"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
				}
		));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setSelectionBackground(new Color(107, 185, 240));
		table_1.setRowHeight(30);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol_1.setViewportView(table_1);
		
		StudentGroupIDCombo_1 = new JComboBox();
		StudentGroupIDCombo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		StudentGroupIDCombo_1.setBackground(Color.WHITE);
		StudentGroupIDCombo_1.setBounds(148, 33, 336, 28);
		Student.add(StudentGroupIDCombo_1);
		
		lblNewLabel_2 = new JLabel("Session Group ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(25, 36, 126, 17);
		Student.add(lblNewLabel_2);
		
		JButton GenBtn_1 = new JButton("Generate Timetable");
		GenBtn_1.setForeground(Color.WHITE);
		GenBtn_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn_1.setBackground(new Color(27, 163, 156));
		GenBtn_1.setBounds(507, 23, 201, 38);
		Student.add(GenBtn_1);
		
		load = new JButton("Print Timetable");
		load.setForeground(Color.WHITE);
		load.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load.setBackground(new Color(0, 0, 139));
		load.setBounds(745, 23, 201, 38);
		Student.add(load);
		fillStudentGroupID();
		
		
		Location = new JPanel();
		Location.setBackground(new Color(255, 255, 255));
		layeredPane.add(Location, "name_44727007566100");
		Location.setLayout(null);
		
		scrol_2 = new JScrollPane();
		scrol_2.setBounds(10, 115, 1221, 268);
		Location.add(scrol_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
					{"8:00-9:00", null, null, null, null, null, null, null},
				},
				new String[] {
					"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
				}
		));
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setSelectionBackground(new Color(107, 185, 240));
		table_2.setRowHeight(30);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol_2.setViewportView(table_2);
		
		RoomIDCombo_1 = new JComboBox();
		RoomIDCombo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		RoomIDCombo_1.setBackground(Color.WHITE);
		RoomIDCombo_1.setBounds(106, 34, 319, 30);
		Location.add(RoomIDCombo_1);
		fillRoomID();
		
		
		lblNewLabel_1 = new JLabel("Room:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 33, 86, 20);
		Location.add(lblNewLabel_1);
		
		JButton GenBtn_2 = new JButton("Generate Timetable");
		GenBtn_2.setForeground(Color.WHITE);
		GenBtn_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn_2.setBackground(new Color(27, 163, 156));
		GenBtn_2.setBounds(435, 26, 184, 38);
		Location.add(GenBtn_2);
		
		load_1 = new JButton("Print Timetable");
		load_1.setForeground(Color.WHITE);
		load_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		load_1.setBackground(new Color(0, 0, 139));
		load_1.setBounds(639, 26, 201, 38);
		Location.add(load_1);
		
		btnBackToHome = new JButton("Back To Home");
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
		btnBackToHome.setBounds(1200, 83, 132, 49);
		contentPane.add(btnBackToHome);
	}
}