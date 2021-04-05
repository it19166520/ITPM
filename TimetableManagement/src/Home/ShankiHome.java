package Home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import locataion.Location;
import pieChart.BarChart;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import DBConnection.DBConnection;

public class ShankiHome {
	
	Connection connection=null;

	private JFrame frame;
	private JPanel panelHeader;
	private JLabel txtrTimeTableManagement;
	private JButton btnLocatio;
	private JButton btnStatistic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShankiHome window = new ShankiHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShankiHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		connection = DBConnection.dbConnect();
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 728);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	//header
		panelHeader = new JPanel();
		panelHeader.setForeground(Color.WHITE);
		panelHeader.setBackground(new Color(75, 119, 190));
		panelHeader.setBounds(0, 0, 1365, 75);
		frame.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		txtrTimeTableManagement = new JLabel("Time Table Management System");
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setBounds(401, 11, 510, 53);
		panelHeader.add(txtrTimeTableManagement); //end of header
		
		btnLocatio = new JButton("Location");
		btnLocatio.setFocusTraversalKeysEnabled(false);
		btnLocatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Location = new Location();
				Location.show();
				
			}
		});
		btnLocatio.setForeground(Color.WHITE);
		btnLocatio.setFont(new Font("Segoe UI Semilight", Font.BOLD, 19));
		btnLocatio.setBackground(new Color(0, 0, 139));
		btnLocatio.setBounds(422, 251, 385, 46);
		frame.getContentPane().add(btnLocatio);
		
		btnStatistic = new JButton("Statistic");
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame barChart = new BarChart();
				barChart.show();
				
				try {	
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
					 String query2 = "select count(*) AS SubjectCount from Subjects";
					 PreparedStatement psat2 = connection.prepareStatement(query2);
					ResultSet rs2 = psat2.executeQuery();
					 while(rs2.next())
					 {
						 int count2 = rs2.getInt("SubjectCount");
						 
						 BarChart.textRegSubjs.setText(String.valueOf(count2));
						 dataset.setValue( rs2.getInt("SubjectCount") , "count","Subjects");
						 
					 }
					 
					 //retreiw number of Rooms:
					 String query3 = "select count(*) AS LocationCount from addLocation";
					 PreparedStatement psat3 = connection.prepareStatement(query3);
					ResultSet rs3 = psat3.executeQuery();
					 while(rs3.next())
					 {
						 int count3 = rs3.getInt("LocationCount");
						 
						 BarChart.textRegRooms.setText(String.valueOf(count3));
						 dataset.setValue( rs3.getInt("LocationCount") , "count","Rooms");
						 
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
		btnStatistic.setFocusTraversalKeysEnabled(false);
		btnStatistic.setForeground(Color.WHITE);
		btnStatistic.setFont(new Font("Segoe UI Semilight", Font.BOLD, 19));
		btnStatistic.setBackground(new Color(0, 0, 139));
		btnStatistic.setBounds(422, 342, 385, 46);
		frame.getContentPane().add(btnStatistic);
	}

	public void Show() {
		
		JFrame ho=this.frame;
		ho.show();
		
	}
	
	
}
