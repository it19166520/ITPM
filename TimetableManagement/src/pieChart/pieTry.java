package pieChart;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;

public class pieTry {

	private JFrame frmStatistics;
	private JTextField textRegLecs;
	private JTextField textRegStudents;
	private JTextField textRegSubjs;
	private JTextField textRegRooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pieTry window = new pieTry();
					window.frmStatistics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pieTry()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
		
			private void initialize() {
			frmStatistics = new JFrame();
			frmStatistics.setTitle("Statistics");
			frmStatistics.getContentPane().setForeground(new Color(0, 0, 128));
			frmStatistics.getContentPane().setBackground(Color.WHITE);
			frmStatistics.setBounds(0,0,1370,728);
			frmStatistics.getContentPane().setLayout(null);
			
			
			
			JTextPane txtpnTimtableManagement = new JTextPane();
			txtpnTimtableManagement.setBounds(0, 0, 1354, 76);
			txtpnTimtableManagement.setFont(new Font("Tahoma", Font.BOLD, 33));
			txtpnTimtableManagement.setText("Timtable Management");
			txtpnTimtableManagement.setBackground(Color.LIGHT_GRAY);
			frmStatistics.getContentPane().add(txtpnTimtableManagement);
			
			panel = new JPanel();
			panel.setBackground(new Color(240, 255, 240));
			panel.setBounds(76, 72, 1238, 606);
			frmStatistics.getContentPane().add(panel);
			panel.setLayout(null);
			
			lblRegLecs = new JLabel("Registered Lectures");
			lblRegLecs.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegLecs.setBounds(30, 147, 205, 65);
			panel.add(lblRegLecs);
			
			lblRegisteredStudents = new JLabel("Registered Students");
			lblRegisteredStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredStudents.setBounds(369, 147, 205, 65);
			panel.add(lblRegisteredStudents);
			
			lblRegisteredSubjects = new JLabel("Registered Subjects");
			lblRegisteredSubjects.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredSubjects.setBounds(725, 147, 205, 65);
			panel.add(lblRegisteredSubjects);
			
			lblRegisteredRooms = new JLabel("Registered Rooms");
			lblRegisteredRooms.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegisteredRooms.setBounds(1061, 147, 205, 65);
			panel.add(lblRegisteredRooms);
			
			textRegLecs = new JTextField();
			textRegLecs.setBounds(30, 50, 172, 102);
			panel.add(textRegLecs);
			textRegLecs.setColumns(10);
			
			textRegStudents = new JTextField();
			textRegStudents.setColumns(10);
			textRegStudents.setBounds(358, 50, 172, 102);
			panel.add(textRegStudents);
			
			textRegSubjs = new JTextField();
			textRegSubjs.setColumns(10);
			textRegSubjs.setBounds(721, 50, 172, 102);
			panel.add(textRegSubjs);
			
			textRegRooms = new JTextField();
			textRegRooms.setColumns(10);
			textRegRooms.setBounds(1039, 50, 172, 102);
			panel.add(textRegRooms);
			
			panelChart = new JPanel();
			panelChart.setBounds(252, 223, 606, 372);
			panel.add(panelChart);
			panelChart.setLayout(null);
			}
			
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			private JPanel panel;
			private JPanel panelChart;
			private JLabel lblRegLecs;
			private JLabel lblRegisteredStudents;
			private JLabel lblRegisteredSubjects;
			private JLabel lblRegisteredRooms;
			//dataset.setValue(80,"marks",")
			/*
			DefaultPieDataset pieDataset= new DefaultPieDataset()
			details.addAll(new PieChart.Data("test1", 25),		
			new pieDataset.setData("Bible study" ,25),
			new pieDataset. setData("Bible study",10),
			new pieDataset. setData("Bible study"));
			
			JFreeChart pieChart=ChartFactory.createPieChart3D("chursh",pieDataset,true,true,true); 
			
			PiePlot3D pie=(PiePlot3D)pieChart.getPlot();
			
		    ScrollPane sp = new ScrollPane();

		    /*details.addAll(new PieChart.Data("test1", 25),
		            new PieChart.Data("test 2", 25),
		            new PieChart.Data("test 3", 25),
		            new PieChart.Data("test 4", 25)
		        );
		    pieChart = new PieChart();
		    pieChart.setData(details);
		    pieChart.setTitle("test");
		    pieChart.setLegendSide(Side.BOTTOM);
		    pieChart.setLabelsVisible(true);
		    sp.setContent(pieChart);

		    Scene scene = new Scene(sp, 600, 500);
		    dataPaneel.setScene(scene);

		    add( new Catagorie1Paneel() );                add( new Catagorie3Paneel() );           add( new SamenvattingPaneel() );
		    add( new Catagorie2Paneel() );                add( new Catagorie4Paneel() );           add( dataPaneel);
		}
		}*/
			
}	

		

