package Home;

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
	private JButton btnAddWorkingDays;
	private JButton btnManageNotAvaillable;
	private JButton btnManageARoom;
	private JButton btnNewButton;
	private JButton btnManageTimeSlot;
	private JPanel panel_1;
	private JPanel panel;
	private JTextArea txtrTimeTableManagement;

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
		wokingDayHourframe.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		wokingDayHourframe.getContentPane().setBackground(SystemColor.window);
		wokingDayHourframe.setBounds(0, 0, 1370, 728);
		wokingDayHourframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wokingDayHourframe.getContentPane().setLayout(null);
		
		btnAddWorkingDays = new JButton("Add Working Days Hours");
		btnAddWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AddWorkingDays hp = new AddWorkingDays();
				hp.addworkingdays();
				wokingDayHourframe.dispose();*/
			}
		});
		btnAddWorkingDays.setForeground(Color.WHITE);
		btnAddWorkingDays.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnAddWorkingDays.setBackground(new Color(0, 0, 139));
		btnAddWorkingDays.setBounds(431, 200, 435, 66);
		wokingDayHourframe.getContentPane().add(btnAddWorkingDays);
		
		btnManageNotAvaillable = new JButton("Manage Not Availlable Time Allocation");
		btnManageNotAvaillable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AddNotAvailableTime hp = new AddNotAvailableTime();
				hp.notavailable();
				wokingDayHourframe.dispose();*/
			}
		});
		btnManageNotAvaillable.setForeground(Color.WHITE);
		btnManageNotAvaillable.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnManageNotAvaillable.setBackground(new Color(0, 0, 139));
		btnManageNotAvaillable.setBounds(431, 427, 435, 66);
		wokingDayHourframe.getContentPane().add(btnManageNotAvaillable);
		
		btnManageARoom = new JButton("Manage a Room Cannot Be Recerved");
		btnManageARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*AddCannotReservedRoom mn = new AddCannotReservedRoom();
				mn.addRoom();
				wokingDayHourframe.dispose();*/
			}
		});
		btnManageARoom.setForeground(Color.WHITE);
		btnManageARoom.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnManageARoom.setBackground(new Color(0, 0, 139));
		btnManageARoom.setBounds(431, 542, 435, 66);
		wokingDayHourframe.getContentPane().add(btnManageARoom);
		
		btnNewButton = new JButton("Back To Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.Homeframe.setVisible(true);
				wokingDayHourframe.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(1168, 90, 154, 59);
		wokingDayHourframe.getContentPane().add(btnNewButton);
		
		btnManageTimeSlot = new JButton("Add And Manage Time Slot");
		btnManageTimeSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*AddTimeSlot working = new AddTimeSlot();
				working.addtimeslott();
				wokingDayHourframe.dispose();*/
			}
		});
		btnManageTimeSlot.setForeground(Color.WHITE);
		btnManageTimeSlot.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnManageTimeSlot.setBackground(new Color(0, 0, 139));
		btnManageTimeSlot.setBounds(431, 310, 435, 66);
		wokingDayHourframe.getContentPane().add(btnManageTimeSlot);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(228, 241, 254));
		panel_1.setBounds(230, 141, 843, 522);
		wokingDayHourframe.getContentPane().add(panel_1);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLUE, 2));
		panel.setBackground(new Color(75, 119, 190));
		panel.setBounds(0, 0, 1364, 79);
		wokingDayHourframe.getContentPane().add(panel);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		panel.add(txtrTimeTableManagement);
	}

}
