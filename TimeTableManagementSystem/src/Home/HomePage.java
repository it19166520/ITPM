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

import DBConnection.SqlServerConnection;
import Member1.AddManageStGrps;
import Member1.AddManageTags;
import Member2.AddManageLecturer;
import Member2.AddManageSubjects;
import Member4.BarChart;
import Member4.Location;

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

public class HomePage {
	
	Connection connection=null;

	public JFrame Homeframe;
	private JButton locationmng_1_1;
	private JButton btnWorkingDaysHours;
	private JButton tagmng;
	private JButton locationmng_1;
	private JButton studentgroups;
	private JButton lecDetail;
	private JButton sessionmng;
	private JButton subMng_1;
	private JButton btnStatistics;
	private JPanel panel;
	private JTextArea txtrTimeTableManagement;
	private JLabel lblNewLabel;

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
		Homeframe = new JFrame();
		Homeframe.getContentPane().setForeground(new Color(255, 255, 255));
		Homeframe.getContentPane().setBackground(new Color(255, 255, 255));
		Homeframe.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		Homeframe.setBounds(0, 0, 1370, 728);
		Homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Homeframe.getContentPane().setLayout(null);
		
		locationmng_1_1 = new JButton("Generate And View Timetables");
		locationmng_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame timetable = new timetable();
				timetable.show();
				Homeframe.dispose();
			}
		});
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setForeground(new Color(0, 0, 0));
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		locationmng_1_1.setBounds(803, 573, 322, 58);
		Homeframe.getContentPane().add(locationmng_1_1);
		
		btnWorkingDaysHours = new JButton("Working Days Hours\r\n Management");
		btnWorkingDaysHours.setBounds(996, 361, 322, 58);
		Homeframe.getContentPane().add(btnWorkingDaysHours);
		btnWorkingDaysHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage2 hp = new HomePage2();
				hp.wokingDayHourframe.setVisible(true);;
				Homeframe.dispose();
			}
		});
		btnWorkingDaysHours.setBackground(new Color(0, 0, 139));
		btnWorkingDaysHours.setForeground(new Color(255, 255, 255));
		btnWorkingDaysHours.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		tagmng = new JButton("Tag Management");
		tagmng.setBounds(996, 253, 322, 58);
		Homeframe.getContentPane().add(tagmng);
		tagmng.setBackground(new Color(0, 0, 139));
		tagmng.setForeground(new Color(255, 255, 255));
		tagmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame AddManageTags = new AddManageTags();
				AddManageTags.show();
				Homeframe.dispose();
			}
		});
		tagmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		locationmng_1 = new JButton("Location Management");
		locationmng_1.setBounds(996, 149, 322, 58);
		Homeframe.getContentPane().add(locationmng_1);
		locationmng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame Location = new Location();
				Location.show();
				Homeframe.dispose();
				
				
			}
		});
		locationmng_1.setBackground(new Color(0, 0, 139));
		locationmng_1.setForeground(new Color(255, 255, 255));
		locationmng_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		studentgroups = new JButton("Student Groups Management");
		studentgroups.setBounds(589, 149, 322, 58);
		Homeframe.getContentPane().add(studentgroups);
		studentgroups.setBackground(new Color(0, 0, 139));
		studentgroups.setForeground(new Color(255, 255, 255));
		studentgroups.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		lecDetail = new JButton("Lecturer Details Management");
		lecDetail.setBounds(589, 253, 322, 58);
		Homeframe.getContentPane().add(lecDetail);
		lecDetail.setBackground(new Color(0, 0, 139));
		lecDetail.setForeground(new Color(255, 255, 255));
		lecDetail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		sessionmng = new JButton("Session Management");
		sessionmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame SessionMain = new SessionMain();
				SessionMain.show();
				Homeframe.dispose();
			}
		});
		sessionmng.setBounds(589, 361, 322, 58);
		Homeframe.getContentPane().add(sessionmng);
		sessionmng.setBackground(new Color(0, 0, 139));
		sessionmng.setForeground(new Color(255, 255, 255));
		sessionmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		subMng_1 = new JButton("Subject Management");
		subMng_1.setBounds(589, 464, 322, 58);
		Homeframe.getContentPane().add(subMng_1);
		subMng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame Subjects = new AddManageSubjects();
				Subjects.show();
				Homeframe.dispose();
			}
		});
		subMng_1.setBackground(new Color(0, 0, 139));
		subMng_1.setForeground(new Color(255, 255, 255));
		subMng_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame barChart = new BarChart();
				barChart.show();
				Homeframe.dispose();
				
				try {	
					
					connection = SqlServerConnection.dbConnecter();
					
					//retrieve student group count :
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
		btnStatistics.setForeground(Color.WHITE);
		btnStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnStatistics.setBackground(new Color(0, 0, 139));
		btnStatistics.setBounds(996, 464, 322, 58);
		Homeframe.getContentPane().add(btnStatistics);
		
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/Images/exe.png")));
		lblNewLabel.setBounds(0, 78, 1305, 611);
		Homeframe.getContentPane().add(lblNewLabel);
		lecDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame AddManageLecturer = new AddManageLecturer();
				AddManageLecturer.show();
				Homeframe.dispose();
			}
		});
		studentgroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame AddManageStGrps = new AddManageStGrps();
				AddManageStGrps.show();
				Homeframe.dispose();
			}
		});
	}
	
	
	
	public void Show() {
		
		JFrame ho = this.Homeframe;
		ho.show();
	}
	
	
}
