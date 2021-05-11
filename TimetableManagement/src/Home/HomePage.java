package Home;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.Canvas;
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import locataion.Location;
import pieChart.BarChart;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import DBConnection.SqlServerConnection;

public class HomePage extends JFrame {

	

	private JFrame frame;

	JFrame Homeframe;
	private JButton locationmng_1_1;
	private JButton btnWorkingDaysHours;
	private JButton tagmng;
	private JButton locationmng;
	private JButton studentgroups;
	private JButton lecDetail;
	private JButton sessionmng;
	private JButton subMng;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnStatistic;
	Connection connection;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.Homeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		connection = SqlServerConnection.dbConnecter();
		
		Homeframe = new JFrame();
		Homeframe.getContentPane().setForeground(new Color(255, 255, 255));
		Homeframe.getContentPane().setBackground(new Color(255, 255, 255));
		Homeframe.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		Homeframe.setBounds(0, 0, 1370, 728);
		Homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Homeframe.getContentPane().setLayout(null);
		
		btnWorkingDaysHours = new JButton("Working Days Hours\r\n Management");
		btnWorkingDaysHours.setBounds(769, 401, 435, 66);
		Homeframe.getContentPane().add(btnWorkingDaysHours);
		btnWorkingDaysHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage2 working = new HomePage2();
				working.wokingDayHourframe.setVisible(true);
				Homeframe.dispose();
			}
		});
		btnWorkingDaysHours.setBackground(new Color(0, 0, 139));
		btnWorkingDaysHours.setForeground(new Color(255, 255, 255));
		btnWorkingDaysHours.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		tagmng = new JButton("Tag Management");
		tagmng.setBounds(769, 280, 435, 66);
		Homeframe.getContentPane().add(tagmng);
		tagmng.setBackground(new Color(0, 0, 139));
		tagmng.setForeground(new Color(255, 255, 255));
		tagmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tagmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		locationmng = new JButton("Location Management");
		locationmng.setBounds(769, 169, 435, 66);
		Homeframe.getContentPane().add(locationmng);
		locationmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame Location = new Location();
				Location.show();
			}
		});
		locationmng.setBackground(new Color(0, 0, 139));
		locationmng.setForeground(new Color(255, 255, 255));
		locationmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		studentgroups = new JButton("Student Groups Management");
		studentgroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentgroups.setBounds(146, 169, 435, 66);
		Homeframe.getContentPane().add(studentgroups);
		studentgroups.setBackground(new Color(0, 0, 139));
		studentgroups.setForeground(new Color(255, 255, 255));
		studentgroups.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		lecDetail = new JButton("Lecturer Details Management");
		lecDetail.setBounds(146, 280, 435, 66);
		Homeframe.getContentPane().add(lecDetail);
		lecDetail.setBackground(new Color(0, 0, 139));
		lecDetail.setForeground(new Color(255, 255, 255));
		lecDetail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		sessionmng = new JButton("Session Management");
		sessionmng.setBounds(146, 401, 435, 66);
		Homeframe.getContentPane().add(sessionmng);
		sessionmng.setBackground(new Color(0, 0, 139));
		sessionmng.setForeground(new Color(255, 255, 255));
		sessionmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		subMng = new JButton("Subject Management");
		subMng.setBounds(146, 517, 435, 66);
		Homeframe.getContentPane().add(subMng);
		subMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		subMng.setBackground(new Color(0, 0, 139));
		subMng.setForeground(new Color(255, 255, 255));
		subMng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		Homeframe.getContentPane().add(panel);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(109, 143, 1157, 535);
		Homeframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		locationmng_1_1 = new JButton("Generate And View Timetables");
		locationmng_1_1.setBounds(368, 458, 435, 66);
		panel_1.add(locationmng_1_1);
		locationmng_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*HomeTimetables p = new HomeTimetables();
			    p.timetableMenuframe.setVisible(true);
			    Homeframe.dispose();	*/
			}
		});
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setForeground(new Color(0, 0, 0));
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnStatistic = new JButton("Statistics");
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame barChart = new BarChart();
				barChart.show();
				
				try {	
					
					connection = SqlServerConnection.dbConnecter();
					
					//retreiw student group count :
					 String query = "select count(*) AS studentGroupCount from StudentGroups";
					 PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs = psat.executeQuery();
					
					DefaultCategoryDataset dataset=new DefaultCategoryDataset();
					
					 while(rs.next())
					 {
						 int count = rs.getInt("studentGroupCount");
						 
						 BarChart.textRegStudents.setText(String.valueOf(count));
						 dataset.setValue( rs.getInt("studentGroupCount") , "count","StudentGroup");
						 
					 }
					 
					 //retreiw number of lecturers:
					 String query1 = "select count(*) AS LecturerCount from Lecturer";
					 PreparedStatement psat1 = connection.prepareStatement(query1);
					ResultSet rs1 = psat1.executeQuery();
					 while(rs1.next())
					 {
						 int count1 = rs1.getInt("LecturerCount");
						 
						 BarChart.textRegLecs.setText(String.valueOf(count1));
						 dataset.setValue( rs1.getInt("LecturerCount") , "count","Lecturer");
						 
					 }
					 
					 //retreiw number of Subjects:
					 String query2 = "select count(*) AS SubjectCount from subjects";
					 PreparedStatement psat2 = connection.prepareStatement(query2);
					ResultSet rs2 = psat2.executeQuery();
					 while(rs2.next())
					 {
						 int count2 = rs2.getInt("SubjectCount");
						 
						 BarChart.textRegSubjs.setText(String.valueOf(count2));
						 dataset.setValue( rs2.getInt("SubjectCount") , "count","subjects");
						 
					 }
					 
					 //retreiw number of Rooms:
					 String query3 = "select count(*) AS LocationCount from addLocation";
					 PreparedStatement psat3 = connection.prepareStatement(query3);
					 ResultSet rs3 = psat3.executeQuery();
					 while(rs3.next())
					 {
						 int count3 = rs3.getInt("LocationCount");
						 
						 BarChart.textRegRooms.setText(String.valueOf(count3));
						 dataset.setValue( rs3.getInt("LocationCount") , "count","RoomName");
						 
					 }
			            
			            JFreeChart chart = ChartFactory.createBarChart("Statistics", "System Details", "marks", dataset,PlotOrientation.VERTICAL,false,true,false);
			            CategoryPlot p = chart.getCategoryPlot();
			            p.setRangeGridlinePaint(Color.black);
			            ChartFrame frame=new ChartFrame("Bar Chart", chart);
			            frame.setVisible(true);
			            frame.setSize(450,350);
					
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				
				

				
				
			}
			
		});
		btnStatistic.setForeground(Color.WHITE);
		btnStatistic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnStatistic.setBackground(new Color(0, 0, 137));
		btnStatistic.setBounds(663, 368, 435, 66);
		panel_1.add(btnStatistic);
		
	}
	
	public void Show() {
		
		JFrame ho=this.Homeframe;
		ho.show();
		
	}
}
