package Home;

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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DBConnection.SqlServerConnection;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	public ArrayList<String> timeSlots= new ArrayList<String>();
	List<String> timeSlotList = Arrays.asList( "08.30 - 09.30", "09.30 - 10.30", "10.30 - 11.30","11.30 - 12.30", "12.30 - 13.30", "13.30 - 14.30",  "14.30 - 15.30", "15.30 - 16.30", "16.30 - 17.30", "17.30 - 18.30", "18.30 - 19.30");
	private JButton GenBtn_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				for(int i=0; i< table_lec.getRowCount(); i++)
				{
					for(int j=1; j<table_lec.getColumnCount(); j++)
					{
						table_lec.setValueAt(null, i, j);
				       
					}
				}
				
			}
		});
		contentPane.add(LecturerButton);
		
		StudentButton = new JButton("Student");
		StudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				swichpannels(Student);
				
				for(int i=0; i< table_1.getRowCount(); i++)
				{
					for(int j=1; j<table_1.getColumnCount(); j++)
					{
						table_1.setValueAt(null, i, j);
				       
					}
				}
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
				for(int i=0; i< table_2.getRowCount(); i++)
				{
					for(int j=1; j<table_2.getColumnCount(); j++)
					{
						table_2.setValueAt(null, i, j);
				       
					}
				}
				
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
		scrol.setBounds(10, 102, 1278, 384);
		Lecturer.add(scrol);
		
		table_lec = new JTable();
		scrol.setViewportView(table_lec);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Time slots");
		model.addColumn("Monday");
		model.addColumn("Tuesday");
		model.addColumn("Wednesday");
		model.addColumn("Thursday");		
		model.addColumn("Friday");
		
		table_lec.setModel(model);
		table_lec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_lec.setSelectionBackground(new Color(107, 185, 240));
		table_lec.setRowHeight(30);
		table_lec.getTableHeader().setForeground(Color.WHITE);
		table_lec.getTableHeader().setBackground(new Color(34, 167, 240));
		table_lec.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		table_lec.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		timeSlots.addAll(timeSlotList);
		
			for(int i=0; i<11 ; i++) {
			model.addRow(new Object[]{
				" "+timeSlots.get(i),
			});;
		}
		
		LecturerNameCombo = new JComboBox();
		LecturerNameCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i< table_lec.getRowCount(); i++)
				{
					for(int j=1; j<table_lec.getColumnCount(); j++)
					{
						table_lec.setValueAt(null, i, j);
				       
					}
				}
			}
		});
		
		LecturerNameCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LecturerNameCombo.setBackground(Color.WHITE);
		LecturerNameCombo.setBounds(130, 27, 332, 28);
		Lecturer.add(LecturerNameCombo);
		
		JLabel lblNewLabel = new JLabel("Lecturer :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 23, 95, 28);
		Lecturer.add(lblNewLabel);
		
		JButton GenBtn = new JButton("Generate Timetable");
		GenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						
					Connection conn = SqlServerConnection.dbConnecter();
					
					DefaultTableModel tblModel = (DefaultTableModel)table_lec.getModel();
					String lecName = LecturerNameCombo.getSelectedItem().toString();
					
					Statement stat = conn.createStatement();
			        ResultSet rs3 = stat.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'M%' and LecturerNameSession='"+lecName+"' ");
			        ArrayList<String> array = new ArrayList<String>();
			        
			        while(rs3.next())
			        {
						
			        	String sessionID = rs3.getString("SessionId");
			        	array.add(sessionID);
			        }
			        int x =0;
			        for(String s : array) {
			        	tblModel.setValueAt(s, x, 1);
			        	x++;
			        	
			        }
			        
			        
			        //===========================================
			        Statement stat1 = conn.createStatement();
			        ResultSet rs4 = stat1.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'T%' and LecturerNameSession='"+lecName+"' ");
			        ArrayList<String> array1 = new ArrayList<String>();
			        
			        while(rs4.next())
			        {
			        	
			        	String sessionID = rs4.getString("SessionId");
			        	array1.add(sessionID);
			        }
			        int y =0;
			        for(String s : array1) {
			        	tblModel.setValueAt(s, y, 2);
			        	y++;
			        	
			        }
			        
			        //=============================================
			        Statement stat2 = conn.createStatement();
			        ResultSet rs5 = stat2.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'W%' and LecturerNameSession='"+lecName+"' ");
			        ArrayList<String> array2 = new ArrayList<String>();
			        
			        while(rs5.next())
			        {
			        	
			        	String sessionID = rs5.getString("SessionId");
			        	array2.add(sessionID);
			        }
			        int z =0;
			        for(String s : array2) {
			        	tblModel.setValueAt(s, z, 3);
			        	z++;
			        	
			        }
			        
			        //===========================================
			        Statement stat3 = conn.createStatement();
			        ResultSet rs6 = stat3.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'Th%' and LecturerNameSession='"+lecName+"' ");
			        ArrayList<String> array3 = new ArrayList<String>();
			        
			        while(rs6.next())
			        {
			        	
			        	String sessionID = rs6.getString("SessionId");
			        	array3.add(sessionID);
			        }
			        int a =0;
			        for(String s : array3) {
			        	tblModel.setValueAt(s, a, 4);
			        	a++;
			        	
			        }
			        
			        //==============================================
			        Statement stat4 = conn.createStatement();
			        ResultSet rs7 = stat4.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'F%' and LecturerNameSession='"+lecName+"' ");
			        ArrayList<String> array4 = new ArrayList<String>();
			        
			        while(rs7.next())
			        {
			        	
			        	String sessionID = rs7.getString("SessionId");
			        	array4.add(sessionID);
			        }
			        int b =0;
			        for(String s : array4) {
			        	tblModel.setValueAt(s, b, 5);
			        	b++;
			        	
			        }
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			
			}

		});
		GenBtn.setForeground(Color.WHITE);
		GenBtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn.setBackground(new Color(27, 163, 156));
		GenBtn.setBounds(488, 20, 180, 38);
		Lecturer.add(GenBtn);
		
		load_2 = new JButton("Print Timetable");
		load_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat("Time Table");
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
		scrol_1.setBounds(10, 108, 1276, 351);
		Student.add(scrol_1);
		
		table_1 = new JTable();
		table_1.setModel(model);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setSelectionBackground(new Color(107, 185, 240));
		table_1.setRowHeight(30);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol_1.setViewportView(table_1);
		
		StudentGroupIDCombo_1 = new JComboBox();
		StudentGroupIDCombo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i=0; i< table_1.getRowCount(); i++)
				{
					for(int j=1; j<table_1.getColumnCount(); j++)
					{
						table_1.setValueAt(null, i, j);
				       
					}
				}
			}
		});
		StudentGroupIDCombo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		StudentGroupIDCombo_1.setBackground(Color.WHITE);
		StudentGroupIDCombo_1.setBounds(148, 33, 336, 28);
		Student.add(StudentGroupIDCombo_1);
		
		lblNewLabel_2 = new JLabel("Session Group ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(25, 36, 126, 17);
		Student.add(lblNewLabel_2);
		
		GenBtn_1 = new JButton("Generate Timetable");
		GenBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
					DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
					
					String GroupID =  StudentGroupIDCombo_1.getSelectedItem().toString();
					
					
					Statement stat = conn.createStatement();
			        ResultSet rs3 = stat.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'M%' and GroupIDSession='"+GroupID+"' ");
			        ArrayList<String> array = new ArrayList<String>();
			        
			        
			        while(rs3.next())
			        {
			        	String sessionID = rs3.getString("SessionId");
			        	array.add(sessionID);
			        	
			        }
			        int x=0;
			        for(String s : array) {
			        	tblModel.setValueAt(s, x, 1);
			        	x++;
			        	
			        }
			        
			        
			        
			        //========================================
			        Statement stat1 = conn.createStatement();
			        ResultSet rs4 = stat1.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'T%' and GroupIDSession='"+GroupID+"' ");
			        ArrayList<String> array1 = new ArrayList<String>();
			        
			        while(rs4.next())
			        {
			        	String sessionID = rs4.getString("SessionId");
			        	array1.add(sessionID);
			        }
			        int y=0;
			        for(String s : array1) {
			        	tblModel.setValueAt(s, y, 2);
			        	y++;
			        	
			        }
			        
			        
			        //=========================================
			        Statement stat2 = conn.createStatement();
			        ResultSet rs5 = stat2.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'W%' and GroupIDSession='"+GroupID+"' ");
					
			        ArrayList<String> array2 = new ArrayList<String>();
			        
			        while(rs5.next())
			        {
			        	String sessionID = rs5.getString("SessionId");
			        	array1.add(sessionID);
			        }
			        int z=0;
			        for(String s : array2) {
			        	tblModel.setValueAt(s, z, 3);
			        	z++;
			        	
			        }
			        
			        
			        //============================================
			        Statement stat3 = conn.createStatement();
			        ResultSet rs6 = stat3.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'Th%' and GroupIDSession='"+GroupID+"' ");
			        ArrayList<String> array3 = new ArrayList<String>();
			        
			        while(rs6.next())
			        {
			        	String sessionID = rs6.getString("SessionId");
			        	array3.add(sessionID);
			        }
			        int a=0;
			        for(String s : array3) {
			        	tblModel.setValueAt(s, a, 4);
			        	a++;
			        	
			        }
			        
			        
			        //===================================================
			        Statement stat4 = conn.createStatement();
			        ResultSet rs7 = stat4.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'F%' and GroupIDSession='"+GroupID+"' ");
			        ArrayList<String> array4 = new ArrayList<String>();
			        
			        while(rs7.next())
			        {
			        	
			        	String sessionID = rs7.getString("SessionId");
			        	array4.add(sessionID);
			        
			        }
			        int b=0;
			        for(String s : array4) {
			        	tblModel.setValueAt(s, b, 5);
			        	b++;
			        	
			        }
					
					
					
					 
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		GenBtn_1.setForeground(Color.WHITE);
		GenBtn_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn_1.setBackground(new Color(27, 163, 156));
		GenBtn_1.setBounds(507, 23, 201, 38);
		Student.add(GenBtn_1);
		
		load = new JButton("Print Timetable");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageFormat header = new MessageFormat("Time Table");
				MessageFormat footer = new MessageFormat("I am the footer of the printer page");
				
				try {
					
					table_1.print(JTable.PrintMode.NORMAL, header , footer);
				}catch(Exception e1){
					
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
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
		scrol_2.setBounds(10, 115, 1276, 317);
		Location.add(scrol_2);
		
		table_2 = new JTable();
		table_2.setModel(model);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setSelectionBackground(new Color(107, 185, 240));
		table_2.setRowHeight(30);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrol_2.setViewportView(table_2);
		
		RoomIDCombo_1 = new JComboBox();
		RoomIDCombo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i< table_2.getRowCount(); i++)
				{
					for(int j=1; j<table_2.getColumnCount(); j++)
					{
						table_2.setValueAt(null, i, j);
				       
					}
				}
				
			}
		});
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
		GenBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection conn = SqlServerConnection.dbConnecter();
					
					DefaultTableModel tblModel = (DefaultTableModel)table_2.getModel();
									
					String room = RoomIDCombo_1.getSelectedItem().toString();
		
					Statement stat = conn.createStatement();
			        ResultSet rs3 = stat.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'M%' and room='"+room+"'");
			        ArrayList<String> array = new ArrayList<String>();
			        
			        while(rs3.next())
			        {
			        	String sessionID = rs3.getString("SessionId");
			        	array.add(sessionID);
			        }
			        int x =0;
			        for(String s : array) {
			        	tblModel.setValueAt(s, x, 1);
			        	x++;
			        	
			        }
			        
			        
			        
			        //========================
			        Statement stat1 = conn.createStatement();
			        ResultSet rs4 = stat1.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'T%' and room='"+room+"' ");
			        ArrayList<String> array1 = new ArrayList<String>();
			        
			        while(rs4.next())
			        {
			        	
			        	String sessionID = rs4.getString("SessionId");
			        	array1.add(sessionID);
			        }
			        int y =0;
			        for(String s : array1) {
			        	tblModel.setValueAt(s, y, 2);
			        	y++;
			        	
			        }
			        
			        //==========================
			        Statement stat2 = conn.createStatement();
			        ResultSet rs5 = stat2.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'W%' and room='"+room+"' ");
			        ArrayList<String> array2 = new ArrayList<String>();
			        
			        while(rs5.next())
			        {
			        	
			        	String sessionID = rs5.getString("SessionId");
			        	array2.add(sessionID);
			        }
			        
			        int z =0;
			        for(String s : array2) {
			        	tblModel.setValueAt(s, z, 3);
			        	z++;
			        	
			        }
			        
			        //========================================
			        Statement stat3 = conn.createStatement();
			        ResultSet rs6 = stat3.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'Th%' and room='"+room+"' ");
			        ArrayList<String> array3 = new ArrayList<String>();
			        
			        while(rs6.next())
			        {
			        	
			        	String sessionID = rs6.getString("SessionId");
			        	array3.add(sessionID);
			        }
			        int a =0;
			        for(String s : array3) {
			        	tblModel.setValueAt(s, a, 4);
			        	a++;
			        	
			        }
					
			        
			        //=======================================
			        Statement stat4 = conn.createStatement();
			        ResultSet rs7 = stat4.executeQuery("SELECT SessionId FROM session WHERE date LIKE 'F%' and room='"+room+"' ");
			        ArrayList<String> array4 = new ArrayList<String>();
			        
			        while(rs7.next())
			        {
			        	
			        	String sessionID = rs7.getString("SessionId");
			        	array4.add(sessionID);
			        }
			        int b =0;
			        for(String s : array4) {
			        	tblModel.setValueAt(s, b, 5);
			        	b++;
			        	
			        }
					
					
					//test.setModel(DbUtils.resultSetToTableModel(rs));
					 
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GenBtn_2.setForeground(Color.WHITE);
		GenBtn_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		GenBtn_2.setBackground(new Color(27, 163, 156));
		GenBtn_2.setBounds(435, 26, 184, 38);
		Location.add(GenBtn_2);
		
		load_1 = new JButton("Print Timetable");
		load_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageFormat header = new MessageFormat("Time Table");
				MessageFormat footer = new MessageFormat("I am the footer of the printer page");
				
				try {
					
					table_2.print(JTable.PrintMode.NORMAL, header , footer);
				}catch(Exception e1){
					
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
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
