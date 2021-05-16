package Tags;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JSpinner;

import DBConnection.DBConnection;
import Home.HomePage;
import Home.StudentGroupManagement;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class AddManageTags extends JFrame {
	
	Connection connection=null;

	private JPanel contentPane;
	private JTextArea txtrTimeTableManagement;
	private JPanel panel_1;
	private JLayeredPane TagsLayeredPane;
	private JPanel AddTagsPanel;
	private JPanel AddTagFormPanel;
	private JLabel AddTagsLabel;
	private JLabel TagNameLabel;
	private JLabel TagCodeLabel;
	private JLabel TagRelatedLabel;
	private JTextField txtTagName;
	private JTextField txtTagCode;
	private JComboBox RelatedTagComboBox;
	private JButton btnClearTag;
	private JButton btnSaveTag;
	private JPanel ManageTagsPanel;
	private JPanel ViewTagsPanel;
	private JPanel GetTagsFormPanel;
	private JLabel lblTagIDeViewForm;
	private JTextField textTagID;
	private JLabel lblTagNameViewForm;
	private JLabel lblTagCodeViewForm;
	private JLabel lblRelatedTagViewForm;
	private JTextField textviewTagName;
	private JTextField textViewTagCodeField;
	private JComboBox RelatedTagListView;
	private JButton BtnClearTagView;
	private JButton BtnUpdateTag;
	private JButton BtnDeleteTagView;
	private JButton btnAddTags;
	private JButton btnManageTags;
	private JTable ViewTagsTable; //chnge later
	private JScrollPane scrollPane;
	private JLabel lbl_empTagName;
	private JLabel lbl_empTagCode;
	private JLabel lbl_empReTag;
	private JLabel lbl_empTagName_1;
	private JLabel lbl_empTagCode_1;
	private JButton btnBack;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManageTags frame = new AddManageTags();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	//switch panels
	public void SwitchTagPanels(JPanel panel)
	{
		TagsLayeredPane.removeAll();
		TagsLayeredPane.add(panel);
		TagsLayeredPane.repaint();
		TagsLayeredPane.revalidate();
	}
	
	
	//clear fields of forms
	public void ClearFields()
	{
		txtTagName.setText(null);
		txtTagCode.setText(null);
		RelatedTagComboBox.setSelectedIndex(-1);
		
		RelatedTagListView.setSelectedIndex(-1);
		textviewTagName.setText(null);
		textViewTagCodeField.setText(null);	
		
	}
	
	//refresh table after adding/updating a record
	public void RefreshTagsTable()
	{
		try {
			
			String refreshque="select * from Tag";
			PreparedStatement psat= connection.prepareStatement(refreshque);
			ResultSet rs=psat.executeQuery();
			
			ViewTagsTable.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception E2)
		{
			E2.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public AddManageTags() {
		
		connection = DBConnection.dbConnecter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 728);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//header
		panel_1 = new JPanel();
		panel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setBounds(0, 0, 1365, 75);
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
		
	//end of the header
		
		TagsLayeredPane = new JLayeredPane();
		TagsLayeredPane.setBackground(Color.WHITE);
		TagsLayeredPane.setBounds(64, 163, 1223, 494);
		contentPane.add(TagsLayeredPane);
		TagsLayeredPane.setLayout(new CardLayout(0, 0));
		
	//Add Tags panel
		AddTagsPanel = new JPanel();
		TagsLayeredPane.add(AddTagsPanel, "name_933544639281500");
		AddTagsPanel.setBackground(Color.WHITE);
		AddTagsPanel.setLayout(null);
		
		AddTagFormPanel = new JPanel();
		AddTagFormPanel.setBounds(360, 11, 460, 472);
		AddTagFormPanel.setBackground(new Color(228, 241, 254));
		AddTagsPanel.add(AddTagFormPanel);
		AddTagsPanel.add(AddTagFormPanel);
		AddTagFormPanel.setLayout(null);
		
		AddTagsLabel = new JLabel("Add New Tag");
		AddTagsLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
		AddTagsLabel.setBounds(105, 11, 266, 29);
		AddTagFormPanel.add(AddTagsLabel);
		
		TagNameLabel = new JLabel("Tag Name  :");
		TagNameLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		TagNameLabel.setBounds(26, 92, 169, 29);
		AddTagFormPanel.add(TagNameLabel);
		
		TagCodeLabel = new JLabel("Tag Code  :");
		TagCodeLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		TagCodeLabel.setBounds(26, 168, 169, 29);
		AddTagFormPanel.add(TagCodeLabel);
		
		TagRelatedLabel = new JLabel("Related Tag   :");
		TagRelatedLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		TagRelatedLabel.setBounds(26, 242, 169, 29);
		AddTagFormPanel.add(TagRelatedLabel);
		
		txtTagName = new JTextField();
		txtTagName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lbl_empTagName.setText("");
				
			}
		});
		txtTagName.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		txtTagName.setBounds(136, 98, 235, 23);
		AddTagFormPanel.add(txtTagName);
		txtTagName.setColumns(10);
		
	
		txtTagCode = new JTextField();
		txtTagCode.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		txtTagCode.setColumns(10);
		txtTagCode.setBounds(136, 174, 235, 23);
		AddTagFormPanel.add(txtTagCode);
		
		String[] RelatedTagList = {"Lecture" , "Tutorial", "Laboratory","Evaluation","Practicals"};
		RelatedTagComboBox = new JComboBox(RelatedTagList);
		RelatedTagComboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lbl_empReTag.setText("");
			}
		});
		RelatedTagComboBox.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		RelatedTagComboBox.setSelectedIndex(-1);
		RelatedTagComboBox.setBounds(136, 248, 235, 23);
		AddTagFormPanel.add(RelatedTagComboBox);
		
		btnClearTag = new JButton("Clear");
		btnClearTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFields();
			}
		});
		btnClearTag.setForeground(Color.WHITE);
		btnClearTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnClearTag.setFocusPainted(false);
		btnClearTag.setBackground(new Color(31, 58, 147));
		btnClearTag.setBounds(110, 325, 220, 38);
		AddTagFormPanel.add(btnClearTag);
		
		
	//save details	
		btnSaveTag = new JButton("Save");
		btnSaveTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//if(txtTagName.getText().trim().isEmpty() && txtTagCode.getText().trim().isEmpty() && ((String) RelatedTagComboBox.getSelectedItem()).trim().isEmpty())
				if(txtTagName.getText().trim().isEmpty() && txtTagCode.getText().trim().isEmpty())
				{
					lbl_empTagName.setText("Required");
					lbl_empTagCode.setText("Required");
					//lbl_empReTag.setText("Required");
				}
				
				else if(txtTagName.getText().trim().isEmpty())
				{
					lbl_empTagName.setText("Required!!");
				}
				
				else if(txtTagCode.getText().trim().isEmpty())
				{
					lbl_empTagCode.setText("Required");
				}
				//else if(((String) RelatedTagComboBox.getSelectedItem()).trim().isEmpty())
				//{
					//lbl_empReTag.setText("Required");
				//}
				
				
				else {
					 	
							try {
								
									lbl_empTagName.setText("");
									lbl_empTagCode.setText("");
									lbl_empReTag.setText("");
					
									String query="insert into Tag(TagName,TagCode,RelatedTag) values(?,?,?)";
									PreparedStatement pstat=connection.prepareStatement(query);
											
									pstat.setString(1, txtTagName.getText());
									pstat.setString(2, txtTagCode.getText());
						
									String RelatedT = RelatedTagComboBox.getSelectedItem().toString();
									pstat.setString(3, RelatedT);
											
									//data insertion success message
									pstat.execute();
									JOptionPane.showMessageDialog(null, "Data inserted successfully!");
											
									pstat.close();
									ClearFields();
								
									
							}
							catch(Exception ex)
							{
								//ex.printStackTrace();
								JOptionPane.showMessageDialog(null, "A tag with this code already exists!!");
							}
						}
				
					
						
			}
		});
		btnSaveTag.setBounds(110, 388, 89, 23);
		btnSaveTag.setForeground(Color.WHITE);
		btnSaveTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnSaveTag.setFocusPainted(false);
		btnSaveTag.setBackground(new Color(27, 163, 156));
		btnSaveTag.setBounds(110, 390, 220, 38);
		AddTagFormPanel.add(btnSaveTag);
		
		lbl_empTagName = new JLabel("");
		lbl_empTagName.setForeground(Color.RED);
		lbl_empTagName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_empTagName.setBounds(161, 132, 210, 25);
		AddTagFormPanel.add(lbl_empTagName);
		
		lbl_empTagCode = new JLabel("");
		lbl_empTagCode.setForeground(Color.RED);
		lbl_empTagCode.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_empTagCode.setBounds(161, 206, 220, 25);
		AddTagFormPanel.add(lbl_empTagCode);
		
		lbl_empReTag = new JLabel("");
		lbl_empReTag.setForeground(Color.RED);
		lbl_empReTag.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_empReTag.setBounds(161, 282, 210, 17);
		AddTagFormPanel.add(lbl_empReTag);
	
	//Manage Tag panel
		ManageTagsPanel = new JPanel();
		TagsLayeredPane.add(ManageTagsPanel, "name_934665841831500");
		ManageTagsPanel.setBackground(Color.WHITE);
		ManageTagsPanel.setLayout(null);
		
		ViewTagsPanel = new JPanel();
		ViewTagsPanel.setLayout(null);
		ViewTagsPanel.setBorder(null);
		ViewTagsPanel.setBackground(new Color(228, 241, 254));
		ViewTagsPanel.setBounds(0, 0, 726, 494);
		ManageTagsPanel.add(ViewTagsPanel);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		//scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(22, 11, 694, 472);
		ViewTagsPanel.add(scrollPane);
		
		ViewTagsTable = new JTable();
		ViewTagsTable.setRowHeight(30);
		//ViewTagsTable.setBorder(new LineBorder(new Color(0,0,0),2));
		//ViewTagsTable.setShowHorizontalLines(false);
		//ViewTagsTable.setBackground(Color.WHITE);
		ViewTagsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ViewTagsTable.setSelectionBackground(new Color(107,185,240));
		ViewTagsTable.getTableHeader().setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		ViewTagsTable.getTableHeader().setOpaque(false);
		ViewTagsTable.getTableHeader().setForeground(new Color(255,255,255));
		ViewTagsTable.getTableHeader().setBackground(new Color(34, 167, 240));
		ViewTagsTable.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		
	//fetch clicked data into a form
		ViewTagsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					int row = ViewTagsTable.getSelectedRow();
					String ID1=(ViewTagsTable.getModel().getValueAt(row, 0)).toString();
					
					String query ="select * from Tag where TagID='"+ID1+"'";
					PreparedStatement psat=connection.prepareStatement(query);
					
					ResultSet rs=psat.executeQuery();
					
					while(rs.next()) {
						
						textTagID.setText(rs.getString("TagID"));
						textviewTagName.setText(rs.getString("TagName"));
						textViewTagCodeField.setText(rs.getString("TagCode"));
						RelatedTagListView.setSelectedItem(rs.getString("RelatedTag"));
					}
					
					psat.close();
					
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
				
			}
		});
		
		scrollPane.setViewportView(ViewTagsTable);
		
		GetTagsFormPanel = new JPanel();
		GetTagsFormPanel.setLayout(null);
		GetTagsFormPanel.setBorder(null);
		GetTagsFormPanel.setBackground(new Color(228, 241, 254));
		GetTagsFormPanel.setBounds(750, 0, 443, 525);
		ManageTagsPanel.add(GetTagsFormPanel);
		
		lblTagIDeViewForm = new JLabel("Tag ID:");
		lblTagIDeViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblTagIDeViewForm.setBounds(26, 31, 209, 24);
		GetTagsFormPanel.add(lblTagIDeViewForm);
		
		textTagID = new JTextField();
		textTagID.setEditable(false);
		textTagID.setColumns(10);
		textTagID.setBounds(220, 31, 185, 24);
		GetTagsFormPanel.add(textTagID);
		
		lblTagNameViewForm = new JLabel("Tag Name :");
		lblTagNameViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblTagNameViewForm.setBounds(26, 80, 209, 24);
		GetTagsFormPanel.add(lblTagNameViewForm);
		
		lblTagCodeViewForm = new JLabel("Tag Code :");
		lblTagCodeViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblTagCodeViewForm.setBounds(26, 132, 209, 24);
		GetTagsFormPanel.add(lblTagCodeViewForm);
		
		lblRelatedTagViewForm = new JLabel("Reated Tag :");
		lblRelatedTagViewForm.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		lblRelatedTagViewForm.setBounds(26, 200, 209, 24);
		GetTagsFormPanel.add(lblRelatedTagViewForm);
		
		textviewTagName = new JTextField();
		textviewTagName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lbl_empTagName_1.setText("");
			}
		});
		textviewTagName.setColumns(10);
		textviewTagName.setBounds(220, 80, 185, 24);
		GetTagsFormPanel.add(textviewTagName);
		
		
		textViewTagCodeField = new JTextField();
		textViewTagCodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lbl_empTagCode_1.setText("");
			}
		});
		textViewTagCodeField.setColumns(10);
		textViewTagCodeField.setBounds(220, 134, 185, 24);
		GetTagsFormPanel.add(textViewTagCodeField);
		
		RelatedTagListView = new JComboBox(RelatedTagList);
		RelatedTagListView.setBackground(Color.WHITE);
		RelatedTagListView.setSelectedIndex(-1);
		RelatedTagListView.setBounds(220, 202, 185, 24);
		GetTagsFormPanel.add(RelatedTagListView);
		
	//clear button of view tag form
		BtnClearTagView = new JButton("Clear");
		BtnClearTagView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFields();
			}
		});
		BtnClearTagView.setForeground(Color.WHITE);
		BtnClearTagView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnClearTagView.setFocusPainted(false);
		BtnClearTagView.setBackground(new Color(31, 58, 147));
		BtnClearTagView.setBounds(152, 305, 123, 30);
		GetTagsFormPanel.add(BtnClearTagView);
	
		
	//update button of view tag form
		BtnUpdateTag = new JButton("Update");
		BtnUpdateTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textviewTagName.getText().trim().isEmpty() && textViewTagCodeField.getText().trim().isEmpty() &&  ((String) RelatedTagListView.getSelectedItem()).trim().isEmpty())
				{
					lbl_empTagName_1.setText("Tag Name is empty!!");
					lbl_empTagCode_1.setText("Tag code is empty!!");
				}
				
				else if(textviewTagName.getText().trim().isEmpty())
				{
					lbl_empTagName_1.setText("Tag Name is empty!!");
				}
				
				else if(textViewTagCodeField.getText().trim().isEmpty())
				{
					lbl_empTagCode_1.setText("Tag code is empty!!");
				}
				
				
				else {
				
					try {
						
						//update details
						String query="update Tag set  TagName='"+textviewTagName.getText()+"' , TagCode='"+textViewTagCodeField.getText()+"' ,RelatedTag='"+RelatedTagListView.getSelectedItem()+"' where TagID='"+textTagID.getText()+"' ";                    
						PreparedStatement psat=connection.prepareStatement(query);
						
						psat.execute();
						
						JOptionPane.showMessageDialog(null, "Update Sucsessful!");
						
						psat.close();
						ClearFields();
						
					}
					catch(Exception e5)
					{
						e5.printStackTrace();
					}
					
					
					//to refresh the table after updating
					RefreshTagsTable();
				}
			}
		});
		BtnUpdateTag.setForeground(Color.WHITE);
		BtnUpdateTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnUpdateTag.setFocusPainted(false);
		BtnUpdateTag.setBackground(new Color(27, 163, 156));
		BtnUpdateTag.setBounds(152, 367, 123, 30);
		GetTagsFormPanel.add(BtnUpdateTag);
	
		
	//delete button of view tag form 
		BtnDeleteTagView = new JButton("Delete");
		BtnDeleteTagView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opt = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete?","Delete", JOptionPane.YES_NO_OPTION);
				
				if(opt ==0) {
				
				try {
					
					String deletequery="delete from Tag where TagID='"+textTagID.getText()+"'";                      
					PreparedStatement psat=connection.prepareStatement(deletequery);
					
					psat.execute();
					
					JOptionPane.showMessageDialog(null, "Details Deleted Sucsessfully!");
					
					psat.close();
					ClearFields();
					
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				
				RefreshTagsTable();
				
			}}
		});
		BtnDeleteTagView.setBounds(152, 431, 123, 30);
		GetTagsFormPanel.add(BtnDeleteTagView);
		BtnDeleteTagView.setForeground(Color.WHITE);
		BtnDeleteTagView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnDeleteTagView.setFocusPainted(false);
		BtnDeleteTagView.setBackground(new Color(210, 77, 87));
		
		lbl_empTagName_1 = new JLabel("");
		lbl_empTagName_1.setForeground(Color.RED);
		lbl_empTagName_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_empTagName_1.setBounds(220, 103, 210, 18);
		GetTagsFormPanel.add(lbl_empTagName_1);
		
		lbl_empTagCode_1 = new JLabel("");
		lbl_empTagCode_1.setForeground(Color.RED);
		lbl_empTagCode_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_empTagCode_1.setBounds(220, 164, 210, 18);
		GetTagsFormPanel.add(lbl_empTagCode_1);
	
	//Button Add to switch panel to add form
		btnAddTags = new JButton("Add Tags");
		btnAddTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SwitchTagPanels(AddTagsPanel); //Switch to add tag panel
				
			}
		});
		btnAddTags.setBounds(64, 114, 294, 38);
		btnAddTags.setFocusPainted(false);
		btnAddTags.setBackground(new Color(58, 83, 155));
		btnAddTags.setForeground(Color.WHITE);
		btnAddTags.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		contentPane.add(btnAddTags);
		
	//Button Manage Tags to switch panel to manage tags
		btnManageTags = new JButton("Manage Tags");
		btnManageTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwitchTagPanels(ManageTagsPanel); //Switch to add tag panel
				
				try {
					
					//retrieve data to a table
					String query = "select * from Tag";
					PreparedStatement psat = connection.prepareStatement(query);
					ResultSet rs= psat.executeQuery();
					
					ViewTagsTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				
			}
		});
		btnManageTags.setBounds(453, 114, 294, 38);
		btnManageTags.setFocusPainted(false);
		btnManageTags.setBackground(new Color(58, 83, 155));
		btnManageTags.setForeground(Color.WHITE);
		btnManageTags.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		contentPane.add(btnManageTags);
		
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
