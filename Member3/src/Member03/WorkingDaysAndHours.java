package Member03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SingleSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class WorkingDaysAndHours {

	JFrame addWorkingDHframe;
	private JTextField timeslot1;
	private JTextField timeslot2;
	private JButton add;
	private JButton update;
	private JButton clear;
	private JButton delete;
	private JButton slot;
    DefaultTableModel model;
    private JTextField txtAddWorkingDays;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkingDaysAndHours window = new WorkingDaysAndHours();
					window.addWorkingDHframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorkingDaysAndHours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addWorkingDHframe = new JFrame();
		addWorkingDHframe.getContentPane().setBackground(new Color(255, 255, 255));
		addWorkingDHframe.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.setBounds(0, 0, 1370, 728);
		addWorkingDHframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWorkingDHframe.getContentPane().setLayout(null);
		
		JLabel l2 = new JLabel("Working Days :");
		l2.setBounds(115, 167, 219, 23);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(l2);
		
		JSpinner li1 = new JSpinner();
		li1.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		li1.setForeground(Color.BLACK);
		li1.setBounds(408, 127, 225, 22);
		li1.setBackground(new Color(216, 191, 216));
		li1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(li1);
		
		JLabel l1 = new JLabel("Number of Working Days :");
		l1.setBounds(115, 126, 518, 23);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(l1);
		
		JCheckBox daysck1 = new JCheckBox("Monday\r\n");
		daysck1.setBounds(408, 167, 120, 23);
		daysck1.setBackground(new Color(176, 224, 230));
		daysck1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck1);
		
		JCheckBox daysck2 = new JCheckBox("Tuesday\r\n");
		daysck2.setBounds(408, 205, 120, 23);
		daysck2.setBackground(new Color(176, 224, 230));
		daysck2.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck2);
		
		JCheckBox daysck3 = new JCheckBox("Wednesday");
		daysck3.setBounds(408, 247, 120, 23);
		daysck3.setBackground(new Color(176, 224, 230));
		daysck3.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck3);
		
		JCheckBox daysck5 = new JCheckBox("Friday");
		daysck5.setBounds(408, 329, 120, 23);
		daysck5.setBackground(new Color(176, 224, 230));
		daysck5.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck5);
		
		JCheckBox daysck6 = new JCheckBox("Saturday");
		daysck6.setBounds(408, 371, 120, 23);
		daysck6.setBackground(new Color(176, 224, 230));
		daysck6.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck6);
		
		JCheckBox daysck4 = new JCheckBox("Thursday");
		daysck4.setBounds(408, 290, 120, 23);
		daysck4.setBackground(new Color(176, 224, 230));
		daysck4.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck4);
		
		JCheckBox daysck7 = new JCheckBox("Sunday");
		daysck7.setBounds(408, 417, 120, 23);
		daysck7.setBackground(new Color(176, 224, 230));
		daysck7.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(daysck7);
		
		JLabel l2_1 = new JLabel("Working Time Per Day :");
		l2_1.setBounds(115, 467, 219, 23);
		l2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(l2_1);
		
		JSpinner hour = new JSpinner();
		hour.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(12), new Float(1)));
		hour.setBounds(451, 468, 63, 22);
		hour.setBackground(new Color(216, 191, 216));
		addWorkingDHframe.getContentPane().add(hour);
		
		JSpinner minutes = new JSpinner();
		minutes.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		minutes.setBounds(582, 469, 63, 22);
		minutes.setBackground(new Color(216, 191, 216));
		addWorkingDHframe.getContentPane().add(minutes);
		
		JLabel lblNewLabel = new JLabel("Hours");
		lblNewLabel.setBounds(408, 467, 225, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(lblNewLabel);
		
		JLabel lblMinutes = new JLabel("Minutes\r\n");
		lblMinutes.setBounds(519, 467, 114, 23);
		lblMinutes.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(lblMinutes);
		
		JLabel l2_1_1 = new JLabel("Time Slots :");
		l2_1_1.setBounds(115, 512, 219, 23);
		l2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(l2_1_1);
		
		timeslot1 = new JTextField();
		timeslot1.setBounds(408, 514, 63, 21);
		timeslot1.setBackground(new Color(176, 224, 230));
		addWorkingDHframe.getContentPane().add(timeslot1);
		timeslot1.setColumns(10);
		
		timeslot2 = new JTextField();
		timeslot2.setBounds(582, 515, 63, 20);
		timeslot2.setBackground(new Color(176, 224, 230));
		timeslot2.setColumns(10);
		addWorkingDHframe.getContentPane().add(timeslot2);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(519, 516, 114, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		addWorkingDHframe.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(775, 167, 569, 522);
		addWorkingDHframe.getContentPane().add(scrollPane);
		
		JTextArea list = new JTextArea();
		scrollPane.setRowHeaderView(list);
		
		JButton addbtn = new JButton("Add Details");
		addbtn.setForeground(new Color(255, 255, 255));
		addbtn.setBackground(new Color(0, 0, 128));
		addbtn.setBounds(78, 566, 269, 50);
		addbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.append("\t--- Working Days And Hours--- \n\n"+
				"\n===================================================\n"+
				"Number Of Working Days :\t" + li1.getValue()+"\n\n"+
				
				"Working Days :\t"+ daysck1.getText()+ "\n\n" + daysck2.getText()+"\n\n"+daysck3.getText()+"\n\n"+
				daysck4.getText()+"\n\n"+daysck5.getText()+"\n\n"+ daysck6.getText()+"\n\n"+ daysck7.getText()+"\n\n"+
				"Working Time Per Day :\t"+ "Hours"+ hour.getValue()+"\t" + "Minutes"+ minutes.getValue()+"\n\n"+
				"Time Slot :\t"+ timeslot1.getText() + " To "+timeslot2.getText()+"\n"+
				"=====================================================");
			}
		});
		addWorkingDHframe.getContentPane().add(addbtn);
		
		JButton updatebtn = new JButton("Update Details");
		updatebtn.setForeground(new Color(255, 255, 255));
		updatebtn.setBackground(new Color(34, 139, 34));
		updatebtn.setBounds(404, 567, 269, 50);
		updatebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addWorkingDHframe.getContentPane().add(updatebtn);
		
		JButton deletebtn = new JButton("Delete Details");
		deletebtn.setForeground(new Color(255, 255, 255));
		deletebtn.setBackground(new Color(255, 0, 0));
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					addWorkingDHframe= new JFrame();
					if (JOptionPane.showConfirmDialog(addWorkingDHframe,"Conform if you want to delete the record !","Delete the record",
							JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
						System.exit(0);
					}
				
			}
		});
		deletebtn.setBounds(78, 628, 269, 50);
		deletebtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addWorkingDHframe.getContentPane().add(deletebtn);
		
		JButton clearbtn = new JButton("Clear Details");
		clearbtn.setForeground(new Color(0, 0, 0));
		clearbtn.setBackground(new Color(0, 255, 255));
		clearbtn.setBounds(404, 628, 269, 50);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				li1.setToolTipText(null);
				daysck1.setText(null);
				daysck2.setText(null);
				daysck3.setText(null);
				daysck4.setText(null);
				daysck5.setText(null);
				daysck6.setText(null);
				daysck7.setText(null);
				hour.setToolTipText(null);
				minutes.setToolTipText(null);
				timeslot1.setText(null);
				timeslot2.setText(null);

			}
		});
		clearbtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		addWorkingDHframe.getContentPane().add(clearbtn);
		
		JButton exitbtn = new JButton("Exit\r\n");
		exitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		exitbtn.setForeground(new Color(255, 255, 255));
		exitbtn.setBackground(new Color(0, 0, 205));
		exitbtn.setBounds(1220, 90, 124, 59);
		addWorkingDHframe.getContentPane().add(exitbtn);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1364, 79);
		addWorkingDHframe.getContentPane().add(panel);
		
		JTextArea txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setText("Timetable Management System");
		txtrTimeTableManagement.setForeground(Color.BLACK);
		txtrTimeTableManagement.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtrTimeTableManagement.setBackground(Color.LIGHT_GRAY);
		panel.add(txtrTimeTableManagement);
		
		txtAddWorkingDays = new JTextField();
		txtAddWorkingDays.setBackground(new Color(255, 255, 255));
		txtAddWorkingDays.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtAddWorkingDays.setText("--------------Add Working Days And Hours---------------");
		txtAddWorkingDays.setBounds(180, 90, 362, 26);
		addWorkingDHframe.getContentPane().add(txtAddWorkingDays);
		txtAddWorkingDays.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage2 hp = new HomePage2();
				hp.wokingDayHourframe.setVisible(true);
				addWorkingDHframe.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(1078, 90, 124, 59);
		addWorkingDHframe.getContentPane().add(btnNewButton);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWorkingDHframe= new JFrame();
				if (JOptionPane.showConfirmDialog(addWorkingDHframe,"Conform if you want to exit !","System",
						JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		model=new DefaultTableModel();
		Object[] column= {"Num. Working Days", "Day","Time","Slot"};
		final Object[] row= new Object[4];
		model.setColumnIdentifiers(column);

	}
}
