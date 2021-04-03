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

import Lecturer.AddManageLecturer;
import Subject.AddManageSubjects;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage {

	JFrame Homeframe;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		//To Get Rounded Button Format :
		
		
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
		Homeframe.setBounds(0,0,1600,825);
		Homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Homeframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(10, 10, 1520, 75);
		Homeframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setBounds(574, 22, 373, 32);
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(168, 145, 1199, 591);
		Homeframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton subMng_1 = new JButton("Subject Management");
		subMng_1.setBounds(113, 458, 435, 66);
		panel_1.add(subMng_1);
		subMng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddManageSubjects sub = new AddManageSubjects();
				sub.setVisible(true);
				
				
			}
		});
		subMng_1.setBackground(new Color(0, 0, 139));
		subMng_1.setForeground(new Color(255, 255, 255));
		subMng_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton sessionmng = new JButton("Session Management");
		sessionmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sessionmng.setBounds(113, 321, 435, 66);
		panel_1.add(sessionmng);
		sessionmng.setBackground(new Color(0, 0, 139));
		sessionmng.setForeground(new Color(255, 255, 255));
		sessionmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton lecDetail = new JButton("Lecturer Details Management");
		lecDetail.setBounds(113, 193, 435, 66);
		panel_1.add(lecDetail);
		lecDetail.setBackground(new Color(0, 0, 139));
		lecDetail.setForeground(new Color(255, 255, 255));
		lecDetail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton studentgroups = new JButton("Student Groups Management");
		studentgroups.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		studentgroups.setBounds(113, 62, 435, 66);
		panel_1.add(studentgroups);
		studentgroups.setBackground(new Color(0, 0, 139));
		studentgroups.setForeground(new Color(255, 255, 255));
		studentgroups.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton locationmng_1_1 = new JButton("Generate And View Timetables");
		locationmng_1_1.setBounds(650, 458, 435, 66);
		panel_1.add(locationmng_1_1);
		locationmng_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setForeground(new Color(0, 0, 0));
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton btnWorkingDaysHours = new JButton("Working Days Hours\r\n Management");
		btnWorkingDaysHours.setBounds(650, 321, 435, 66);
		panel_1.add(btnWorkingDaysHours);
		btnWorkingDaysHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			}
		});
		btnWorkingDaysHours.setBackground(new Color(0, 0, 139));
		btnWorkingDaysHours.setForeground(new Color(255, 255, 255));
		btnWorkingDaysHours.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton tagmng = new JButton("Tag Management");
		tagmng.setBounds(650, 193, 435, 66);
		panel_1.add(tagmng);
		tagmng.setBackground(new Color(0, 0, 139));
		tagmng.setForeground(new Color(255, 255, 255));
		tagmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tagmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JButton locationmng_1 = new JButton("Location Management");
		locationmng_1.setBounds(650, 62, 435, 66);
		panel_1.add(locationmng_1);
		locationmng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		locationmng_1.setBackground(new Color(0, 0, 139));
		locationmng_1.setForeground(new Color(255, 255, 255));
		locationmng_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		studentgroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		lecDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddManageLecturer sub = new AddManageLecturer();
				sub.setVisible(true);
				
				
				
			}
		});
	}
}