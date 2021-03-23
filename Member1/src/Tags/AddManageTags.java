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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JSpinner;

import DBConnection.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddManageTags extends JFrame {

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
	private JTextField SearchField;
	private JButton BtnSearchTag;
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

	/**
	 * Create the frame.
	 */
	public AddManageTags() {
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
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight));
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
		txtTagName.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		txtTagName.setBounds(136, 98, 235, 23);
		AddTagFormPanel.add(txtTagName);
		txtTagName.setColumns(10);
		
		txtTagCode = new JTextField();
		txtTagCode.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		txtTagCode.setColumns(10);
		txtTagCode.setBounds(136, 174, 235, 23);
		AddTagFormPanel.add(txtTagCode);
		
		String[] RelatedTagList = {"Lecture" , "Tutorial", "Laboratory","Evaluation"};
		RelatedTagComboBox = new JComboBox(RelatedTagList);
		RelatedTagComboBox.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 13));
		RelatedTagComboBox.setSelectedIndex(-1);
		RelatedTagComboBox.setBounds(136, 248, 235, 23);
		AddTagFormPanel.add(RelatedTagComboBox);
		
		btnClearTag = new JButton("Clear");
		btnClearTag.setForeground(Color.WHITE);
		btnClearTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnClearTag.setFocusPainted(false);
		btnClearTag.setBackground(new Color(31, 58, 147));
		btnClearTag.setBounds(110, 325, 220, 38);
		AddTagFormPanel.add(btnClearTag);
		
		btnSaveTag = new JButton("Save");
		btnSaveTag.setBounds(110, 388, 89, 23);
		btnSaveTag.setForeground(Color.WHITE);
		btnSaveTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		btnSaveTag.setFocusPainted(false);
		btnSaveTag.setBackground(new Color(27, 163, 156));
		btnSaveTag.setBounds(110, 390, 220, 38);
		AddTagFormPanel.add(btnSaveTag);
	
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
		
		SearchField = new JTextField();
		SearchField.setFont(new Font("Leelawadee UI Semilight", Font.ITALIC, 14));
		SearchField.setBackground(new Color(255, 255, 255));
		SearchField.setText("search");
		SearchField.setColumns(10);
		SearchField.setBounds(356, 21, 185, 27);
		ViewTagsPanel.add(SearchField);
		
		BtnSearchTag = new JButton("Search");
		BtnSearchTag.setForeground(Color.WHITE);
		BtnSearchTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnSearchTag.setFocusPainted(false);
		BtnSearchTag.setBackground(new Color(31, 58, 147));
		BtnSearchTag.setBounds(557, 21, 123, 27);
		ViewTagsPanel.add(BtnSearchTag);
		
		GetTagsFormPanel = new JPanel();
		GetTagsFormPanel.setLayout(null);
		GetTagsFormPanel.setBorder(null);
		GetTagsFormPanel.setBackground(new Color(197, 239, 247));
		GetTagsFormPanel.setBounds(770, 0, 443, 494);
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
		textviewTagName.setColumns(10);
		textviewTagName.setBounds(220, 80, 185, 24);
		GetTagsFormPanel.add(textviewTagName);
		
		
		textViewTagCodeField = new JTextField();
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
		BtnClearTagView.setForeground(Color.WHITE);
		BtnClearTagView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnClearTagView.setFocusPainted(false);
		BtnClearTagView.setBackground(new Color(31, 58, 147));
		BtnClearTagView.setBounds(152, 305, 123, 30);
		GetTagsFormPanel.add(BtnClearTagView);
	
		
	//update button of view tag form
		BtnUpdateTag = new JButton("Update");
		BtnUpdateTag.setForeground(Color.WHITE);
		BtnUpdateTag.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnUpdateTag.setFocusPainted(false);
		BtnUpdateTag.setBackground(new Color(27, 163, 156));
		BtnUpdateTag.setBounds(152, 367, 123, 30);
		GetTagsFormPanel.add(BtnUpdateTag);
	
		
	//delete button of view tag form 
		BtnDeleteTagView = new JButton("Delete");
		BtnDeleteTagView.setBounds(152, 431, 123, 30);
		GetTagsFormPanel.add(BtnDeleteTagView);
		BtnDeleteTagView.setForeground(Color.WHITE);
		BtnDeleteTagView.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
		BtnDeleteTagView.setFocusPainted(false);
		BtnDeleteTagView.setBackground(new Color(210, 77, 87));
	
	//Button Add to switch panel to add form
		btnAddTags = new JButton("Add Tags");
		btnAddTags.setBounds(64, 114, 294, 38);
		btnAddTags.setFocusPainted(false);
		btnAddTags.setBackground(new Color(58, 83, 155));
		btnAddTags.setForeground(Color.WHITE);
		btnAddTags.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		contentPane.add(btnAddTags);
		
	//Button Manage Tags to switch panel to manage tags
		btnManageTags = new JButton("Manage Tags");
		btnManageTags.setBounds(453, 114, 294, 38);
		btnManageTags.setFocusPainted(false);
		btnManageTags.setBackground(new Color(58, 83, 155));
		btnManageTags.setForeground(Color.WHITE);
		btnManageTags.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
		contentPane.add(btnManageTags);
	
		
		
		
	}
}
