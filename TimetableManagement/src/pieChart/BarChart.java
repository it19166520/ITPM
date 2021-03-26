package pieChart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConnection.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class BarChart extends JFrame {
	
	Connection connection=null;
	
	private JPanel panelHeader;
	private JLabel txtrTimeTableManagement;

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblRegLecs;
	private JLabel lblRegisteredStudents;
	private JLabel lblRegisteredSubjects;
	private JLabel lblRegisteredRooms;
	public static JTextField textRegStudents;
	public static JTextField textRegSubjs;
	public static  JTextField textRegRooms;
	private JPanel panelChart;
	public static JTextField textRegLecs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarChart frame = new BarChart();
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
	public BarChart() {
		
		connection = DBConnection.dbConnect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//header
				panelHeader = new JPanel();
				panelHeader.setForeground(Color.WHITE);
				panelHeader.setBackground(new Color(75, 119, 190));
				panelHeader.setBounds(0, 0, 1365, 75);
				contentPane.add(panelHeader);
				panelHeader.setLayout(null);
				
				txtrTimeTableManagement = new JLabel("Time Table Management System");
				txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
				txtrTimeTableManagement.setForeground(Color.WHITE);
				txtrTimeTableManagement.setBounds(401, 11, 510, 53);
				panelHeader.add(txtrTimeTableManagement); //end of header
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(76, 72, 1238, 606);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblRegLecs = new JLabel("Registered Lectures");
		lblRegLecs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegLecs.setBounds(51, 164, 205, 65);
		panel.add(lblRegLecs);
		
		lblRegisteredStudents = new JLabel("Registered Students");
		lblRegisteredStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisteredStudents.setBounds(368, 164, 205, 65);
		panel.add(lblRegisteredStudents);
		
		lblRegisteredSubjects = new JLabel("Registered Subjects");
		lblRegisteredSubjects.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisteredSubjects.setBounds(702, 164, 205, 65);
		panel.add(lblRegisteredSubjects);
		
		lblRegisteredRooms = new JLabel("Registered Rooms");
		lblRegisteredRooms.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegisteredRooms.setBounds(1033, 164, 205, 65);
		panel.add(lblRegisteredRooms);
		
		textRegLecs = new JTextField();
		textRegLecs.setHorizontalAlignment(SwingConstants.CENTER);
		textRegLecs.setFont(new Font("Tahoma", Font.BOLD, 31));
		textRegLecs.setEditable(false);
		textRegLecs.setBounds(44, 79, 172, 102);
		panel.add(textRegLecs);
		textRegLecs.setColumns(10);
		
		textRegStudents = new JTextField();
		textRegStudents.setHorizontalAlignment(SwingConstants.CENTER);
		textRegStudents.setFont(new Font("Tahoma", Font.BOLD, 30));
		textRegStudents.setEditable(false);
		textRegStudents.setColumns(10);
		textRegStudents.setBounds(366, 79, 172, 102);
		panel.add(textRegStudents);
		
		textRegSubjs = new JTextField();
		textRegSubjs.setHorizontalAlignment(SwingConstants.CENTER);
		textRegSubjs.setFont(new Font("Tahoma", Font.BOLD, 30));
		textRegSubjs.setEditable(false);
		textRegSubjs.setColumns(10);
		textRegSubjs.setBounds(710, 79, 172, 102);
		panel.add(textRegSubjs);
		
		textRegRooms = new JTextField();
		textRegRooms.setHorizontalAlignment(SwingConstants.CENTER);
		textRegRooms.setFont(new Font("Tahoma", Font.BOLD, 30));
		textRegRooms.setEditable(false);
		textRegRooms.setColumns(10);
		textRegRooms.setBounds(1023, 79, 172, 102);
		panel.add(textRegRooms);
		
		panelChart = new JPanel();
		panelChart.setBounds(330, 221, 631, 392);
		panel.add(panelChart);
		panelChart.setLayout(null);
		
	}

}
