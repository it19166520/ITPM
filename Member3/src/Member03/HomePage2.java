package Member03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage2 {

	JFrame wokingDayHourframe;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage2 window = new HomePage2();
					window.wokingDayHourframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		wokingDayHourframe = new JFrame();
		wokingDayHourframe.getContentPane().setBackground(SystemColor.window);
		wokingDayHourframe.setBounds(0, 0, 1370, 728);
		wokingDayHourframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wokingDayHourframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(SystemColor.window);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 1365, 79);
		wokingDayHourframe.getContentPane().add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.BLACK);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(txtrTimeTableManagement);
		
		JButton btnAddWorkingDays = new JButton("Add Working Days Hours");
		btnAddWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkingDaysAndHours hp = new WorkingDaysAndHours();
				hp.addWorkingDHframe.setVisible(true);
				wokingDayHourframe.dispose();
			}
		});
		btnAddWorkingDays.setForeground(Color.WHITE);
		btnAddWorkingDays.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAddWorkingDays.setBackground(new Color(0, 0, 139));
		btnAddWorkingDays.setBounds(431, 238, 435, 66);
		wokingDayHourframe.getContentPane().add(btnAddWorkingDays);
		
		JButton btnManageNotAvaillable = new JButton("Manage Not Availlable Time Allocation");
		btnManageNotAvaillable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnManageNotAvaillable.setForeground(Color.WHITE);
		btnManageNotAvaillable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnManageNotAvaillable.setBackground(new Color(0, 0, 139));
		btnManageNotAvaillable.setBounds(431, 365, 435, 66);
		wokingDayHourframe.getContentPane().add(btnManageNotAvaillable);
		
		JButton btnManageARoom = new JButton("Manage a Room Cannot Be Recerved");
		btnManageARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageARoom.setForeground(Color.WHITE);
		btnManageARoom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnManageARoom.setBackground(new Color(0, 0, 139));
		btnManageARoom.setBounds(431, 488, 435, 66);
		wokingDayHourframe.getContentPane().add(btnManageARoom);
		
		JButton btnNewButton = new JButton("Back To Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.Homeframe.setVisible(true);
				wokingDayHourframe.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(1168, 90, 154, 59);
		wokingDayHourframe.getContentPane().add(btnNewButton);
	}
}
