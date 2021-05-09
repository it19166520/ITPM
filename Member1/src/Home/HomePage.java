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

import Par_con_nonOSessions.Consec_sessions;
import StudentGroups.AddManageStGrps;
import Tags.AddManageTags;

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

public class HomePage {

	JFrame Homeframe;
	private JButton locationmng_1_1;
	private JButton btnWorkingDaysHours;
	private JButton tagmng;
	private JButton locationmng;
	private JButton studentgroups;
	private JButton lecDetail;
	private JButton subMng;
	private JButton sessionmng;
	private JPanel panel;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel_1;

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
				/*HomeTimetables p = new HomeTimetables();
			    p.timetableMenuframe.setVisible(true);
			    Homeframe.dispose();	*/
			}
		});
		locationmng_1_1.setBackground(new Color(30, 144, 255));
		locationmng_1_1.setForeground(new Color(0, 0, 0));
		locationmng_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		locationmng_1_1.setBounds(769, 517, 435, 66);
		Homeframe.getContentPane().add(locationmng_1_1);
		
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
		tagmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame AddManageTags = new AddManageTags();
				AddManageTags.show();
				
			}
		});
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
				
			}
		});
		locationmng.setBackground(new Color(0, 0, 139));
		locationmng.setForeground(new Color(255, 255, 255));
		locationmng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		studentgroups = new JButton("Student Groups Management");
		studentgroups.setBounds(146, 169, 435, 66);
		studentgroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame AddManageStGrps = new AddManageStGrps();
				AddManageStGrps.show();
			}
		});
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
		sessionmng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame Consec_sessions = new Consec_sessions();
				Consec_sessions.show();
				
			}
		});
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
		panel_1.setBounds(109, 129, 1157, 508);
		Homeframe.getContentPane().add(panel_1);
		lecDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
	
	public void Show() {
		
		JFrame ho = this.Homeframe;
		ho.show();
	}

	
}
