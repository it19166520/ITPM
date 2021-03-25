package locataion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class table2 {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTable table=new JTable();
		Object[] columns = {"ID","Building name","Room Name","Room Type","Capacity"};
		DefaultTableModel model =new DefaultTableModel();
		
		JFrame frame=new JFrame("Manage Locations");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setBackground(SystemColor.text);
		frame.getContentPane().setForeground(new Color(255,255,255));
		frame.setBounds(0, 79, 1354, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.white);
		table.setFont(new Font("Tahoma",Font.PLAIN,17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane pane=new JScrollPane(table);
		pane.setForeground(Color.BLACK);
		pane.setBackground(Color.WHITE);
		pane.setBounds(25,126,964,268);
		frame.getContentPane().add(pane);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(1075, 143, 113, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 0, 128));
		btnUpdate.setBounds(1075, 229, 113, 36);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(0, 0, 128));
		btnClear.setBounds(1075, 311, 113, 36);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Building Name");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 405, 153, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setForeground(SystemColor.desktop);
		lblRoomName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomName.setBounds(35, 448, 153, 43);
		frame.getContentPane().add(lblRoomName);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setForeground(SystemColor.desktop);
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomType.setBounds(35, 487, 153, 43);
		frame.getContentPane().add(lblRoomType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lectures");
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 128));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(159, 498, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLaboratories = new JRadioButton("Laboratories");
		rdbtnLaboratories.setForeground(new Color(255, 255, 255));
		rdbtnLaboratories.setBackground(new Color(0, 0, 128));
		rdbtnLaboratories.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLaboratories.setBounds(335, 498, 109, 23);
		frame.getContentPane().add(rdbtnLaboratories);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setForeground(SystemColor.desktop);
		lblCapacity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCapacity.setBounds(35, 516, 153, 43);
		frame.getContentPane().add(lblCapacity);
		
		textField = new JTextField();
		textField.setBounds(159, 417, 285, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 460, 285, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 528, 285, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Location");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_1.setBounds(25, 75, 342, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtpnTimtableManagement = new JTextPane();
		txtpnTimtableManagement.setText("Timtable Management");
		txtpnTimtableManagement.setFont(new Font("Tahoma", Font.BOLD, 33));
		txtpnTimtableManagement.setBackground(Color.LIGHT_GRAY);
		txtpnTimtableManagement.setBounds(0, 0, 1354, 76);
		frame.getContentPane().add(txtpnTimtableManagement);
		
		
		Object[] row=new Object[4];
		

		
		
		frame.setVisible(true);
		
		;

	}
}
