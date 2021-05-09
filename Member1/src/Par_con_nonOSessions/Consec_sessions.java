package Par_con_nonOSessions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Home.HomePage;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consec_sessions extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel_1;
	private JLayeredPane SessionslayeredPane;
	private JPanel Consecutive;
	private JPanel Parallel;
	private JPanel NonOverlapping;
	private JButton btnConsec;
	private JButton btnParallel;
	private JButton btnNonOverlapping;
	private JTextField txtCon;
	private JTextField txtPar;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consec_sessions frame = new Consec_sessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//swith panels
	public void SwitchPanels(JPanel panel)
	{
		SessionslayeredPane.removeAll();
		SessionslayeredPane.add(panel);
		SessionslayeredPane.repaint();
		SessionslayeredPane.revalidate();
	}
	

	/**
	 * Create the frame.
	 */
	public Consec_sessions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//header
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1365, 75);
		panel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(75, 119, 190));
		contentPane.add(panel_1);
		
		txtrTimeTableManagement = new JTextArea();
		txtrTimeTableManagement.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		txtrTimeTableManagement.setEditable(false);
		txtrTimeTableManagement.setBackground(new Color(75, 119, 190));
		txtrTimeTableManagement.setForeground(Color.WHITE);
		txtrTimeTableManagement.setText("Timetable Management System");
		panel_1.add(txtrTimeTableManagement);
	//end of heder
		
		
		SessionslayeredPane = new JLayeredPane();
		SessionslayeredPane.setBounds(31, 145, 1282, 533);
		contentPane.add(SessionslayeredPane);
		SessionslayeredPane.setLayout(null);
		
		Consecutive = new JPanel();
		Consecutive.setBounds(49, 11, 1204, 552);
		Consecutive.setBackground(Color.WHITE);
		SessionslayeredPane.add(Consecutive);
		Consecutive.setLayout(null);
		
		txtCon = new JTextField();
		txtCon.setText("con");
		txtCon.setBounds(759, 203, 86, 20);
		Consecutive.add(txtCon);
		txtCon.setColumns(10);
		
		Parallel = new JPanel();
		Parallel.setBounds(49, 11, 1204, 552);
		Parallel.setBackground(Color.white);
		SessionslayeredPane.add(Parallel);
		
		txtPar = new JTextField();
		txtPar.setText("par");
		Parallel.add(txtPar);
		txtPar.setColumns(10);
		
		NonOverlapping= new JPanel();
		NonOverlapping.setBounds(49, 11, 1204, 552);
		NonOverlapping.setBackground(Color.WHITE);
		SessionslayeredPane.add(NonOverlapping);
		
		btnConsec = new JButton("Consecutive");
		btnConsec.setBounds(79, 96, 211, 38);
		contentPane.add(btnConsec);
		btnConsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(Consecutive);
			}
		});
		btnConsec.setForeground(Color.WHITE);
		btnConsec.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnConsec.setFocusPainted(false);
		btnConsec.setBackground(new Color(58, 83, 155));
		
		
		btnParallel = new JButton("Parallel");
		btnParallel.setBounds(300, 96, 211, 38);
		contentPane.add(btnParallel);
		btnParallel.setForeground(Color.WHITE);
		btnParallel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnParallel.setFocusPainted(false);
		btnParallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(Parallel);
			}
		});
		btnParallel.setBackground(new Color(58, 83, 155));
		
		
		btnNonOverlapping = new JButton("Non Overlapping");
		btnNonOverlapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(NonOverlapping);
			}
		});
		btnNonOverlapping.setBounds(521, 96, 211, 38);
		contentPane.add(btnNonOverlapping);
		btnNonOverlapping.setForeground(Color.WHITE);
		btnNonOverlapping.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnNonOverlapping.setFocusPainted(false);
		btnNonOverlapping.setBackground(new Color(58, 83, 155));
		
		
		btnBack = new JButton("Back");
		btnBack.setBorder(new LineBorder(new Color(64, 64, 64)));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*StudentGroupManagement myhome = new StudentGroupManagement();
				myhome.Show();*/
				
				HomePage home = new HomePage();
				home.Show();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnBack.setFocusPainted(false);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(1146, 86, 177, 38);
		contentPane.add(btnBack);
		
		
	
	}
}
