package datastructure;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.color.CMMException;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
public class RegistrationForm {
	static LinkedList myList;

	private JFrame frmRegistrationForm;
	private JTextField txtdob;
	private JTextField txtId;
	private JTextField txtlastname;
	private JTextField txtfisrtname;
	private JTextField txtcity;
	private JTextField txtstate;
	private JTextField txtzipcode;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtscore;
	private JTextField txtscore2;
	private JTextField txtscore3;
	private JTextField txtscore4;
	private JTextField txtscore5;
	private JTextField txtscore6;
	private JTextField txtGPA;
	private JTextField txtoptionalcourse;
	private JTextField txtscore7;
	private JTextField txtyear;
	private JComboBox<String>comboBoxfunds;
	private ButtonGroup group;
	public DefaultListModel<LinkedList> dfl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
					window.frmRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationForm() {
		initialize();
		 
	}
	RegistrationSystem reg;
	public void clean(){
		}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		reg=new RegistrationSystem();
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.setResizable(false);
		frmRegistrationForm.setForeground(UIManager.getColor("Button.focus"));
		frmRegistrationForm.setFont(new Font("Dialog", Font.BOLD, 12));
		frmRegistrationForm.setTitle("REGISTRATION FORM");
		frmRegistrationForm.setBackground(SystemColor.textHighlight);
		frmRegistrationForm.getContentPane().setBackground(new Color(230, 230, 250));
		frmRegistrationForm.setBounds(100, 100, 770, 555);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);
		
		JLabel lbName = new JLabel("FIRST NAME:");
		lbName.setBounds(10, 36, 80, 14);
		frmRegistrationForm.getContentPane().add(lbName);
		
		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setBounds(10, 74, 80, 14);
		frmRegistrationForm.getContentPane().add(lblLastName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 112, 46, 14);
		frmRegistrationForm.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("DATE OF BIRTH:");
		lblNewLabel.setBounds(10, 150, 100, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CITY:");
		lblNewLabel_1.setBounds(10, 239, 68, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GENDER:");
		lblNewLabel_2.setBounds(10, 191, 80, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_2);
		
		Panel panel = new Panel();
		panel.setBounds(130, 188, 155, 33);
		frmRegistrationForm.getContentPane().add(panel);
		
		JRadioButton rdbtnMale = new JRadioButton("MALE");
		rdbtnMale.setBackground(new Color(230, 230, 250));
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.setBackground(new Color(230, 230, 250));
		panel.add(rdbtnFemale);
		
		group =new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
		
		
		txtdob = new JTextField();
		txtdob.setBounds(130, 150, 218, 20);
		frmRegistrationForm.getContentPane().add(txtdob);
		txtdob.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(130, 112, 218, 20);
		frmRegistrationForm.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(130, 74, 218, 20);
		frmRegistrationForm.getContentPane().add(txtlastname);
		txtlastname.setColumns(10);
		
		txtfisrtname = new JTextField();
		txtfisrtname.setBounds(130, 36, 218, 20);
		frmRegistrationForm.getContentPane().add(txtfisrtname);
		txtfisrtname.setColumns(10);
		
		txtcity = new JTextField();
		txtcity.setBounds(130, 239, 218, 20);
		frmRegistrationForm.getContentPane().add(txtcity);
		txtcity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("STATE:");
		lblNewLabel_3.setBounds(10, 277, 80, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_3);
		
		txtstate = new JTextField();
		txtstate.setBounds(130, 277, 218, 20);
		frmRegistrationForm.getContentPane().add(txtstate);
		txtstate.setColumns(10);
		
		txtzipcode = new JTextField();
		txtzipcode.setBounds(130, 315, 218, 20);
		frmRegistrationForm.getContentPane().add(txtzipcode);
		txtzipcode.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ZIP CODE:");
		lblNewLabel_4.setBounds(10, 315, 100, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_4);
		
		txtemail = new JTextField();
		txtemail.setBounds(130, 353, 218, 20);
		frmRegistrationForm.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(10, 353, 80, 14);
		frmRegistrationForm.getContentPane().add(lblEmail);
		
		txtphone = new JTextField();
		txtphone.setBounds(130, 391, 218, 20);
		frmRegistrationForm.getContentPane().add(txtphone);
		txtphone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PHONE:");
		lblNewLabel_5.setBounds(10, 391, 80, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(358, 0, 396, 454);
		frmRegistrationForm.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEducationInformation = new JLabel("EDUCATION INFORMATION");
		lblEducationInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEducationInformation.setBounds(142, 11, 195, 14);
		panel_1.add(lblEducationInformation);
		
		JLabel lblMaths = new JLabel("Course Name");
		lblMaths.setBounds(40, 24, 83, 14);
		panel_1.add(lblMaths);
		
		JLabel lblNewLabel_6 = new JLabel("Score");
		lblNewLabel_6.setBounds(291, 24, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(24, 39, 350, 312);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEnglish = new JLabel("ENGLISH");
		lblEnglish.setBounds(10, 17, 100, 14);
		panel_2.add(lblEnglish);
		
		JLabel lblLifeOrientation = new JLabel("LIFE ORIENTATION");
		lblLifeOrientation.setBounds(10, 51, 94, 14);
		panel_2.add(lblLifeOrientation);
		
		JLabel lblNewLabel_10 = new JLabel("ACCOUNTING");
		lblNewLabel_10.setBounds(10, 85, 100, 14);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("PHYSICAL SCIENCE");
		lblNewLabel_8.setBounds(10, 119, 116, 14);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("LIFE SCIENCE");
		lblNewLabel_9.setBounds(10, 153, 101, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("MATHS");
		lblNewLabel_7.setBounds(10, 187, 69, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblGpa = new JLabel("GPA");
		lblGpa.setBounds(10, 261, 116, 14);
		panel_2.add(lblGpa);
		
		txtscore = new JTextField();
		txtscore.setBounds(268, 17, 72, 20);
		panel_2.add(txtscore);
		txtscore.setColumns(10);
		
		txtscore2 = new JTextField();
		txtscore2.setBounds(268, 51, 72, 20);
		panel_2.add(txtscore2);
		txtscore2.setColumns(10);
		
		txtscore3 = new JTextField();
		txtscore3.setBounds(268, 85, 72, 20);
		panel_2.add(txtscore3);
		txtscore3.setColumns(10);
		
		txtscore4 = new JTextField();
		txtscore4.setBounds(268, 119, 72, 20);
		panel_2.add(txtscore4);
		txtscore4.setColumns(10);
		
		txtscore5 = new JTextField();
		txtscore5.setBounds(268, 153, 72, 20);
		panel_2.add(txtscore5);
		txtscore5.setColumns(10);
		
		txtscore6 = new JTextField();
		txtscore6.setBounds(268, 187, 72, 20);
		panel_2.add(txtscore6);
		txtscore6.setColumns(10);
		
		txtGPA = new JTextField();
		txtGPA.setBounds(268, 258, 72, 20);
		panel_2.add(txtGPA);
		txtGPA.setColumns(10);
		
		JLabel lblOther = new JLabel("OTHER optional");
		lblOther.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOther.setBounds(10, 212, 81, 14);
		panel_2.add(lblOther);
		
		txtoptionalcourse = new JTextField();
		txtoptionalcourse.setBounds(10, 225, 152, 20);
		panel_2.add(txtoptionalcourse);
		txtoptionalcourse.setColumns(10);
		
		txtscore7 = new JTextField();
		txtscore7.setBounds(268, 225, 72, 20);
		panel_2.add(txtscore7);
		txtscore7.setColumns(10);
		
		JLabel lblYearCompleted = new JLabel("YEAR COMPLETED");
		lblYearCompleted.setBounds(10, 286, 116, 14);
		panel_2.add(lblYearCompleted);
		
		txtyear = new JTextField();
		txtyear.setBounds(268, 286, 72, 20);
		panel_2.add(txtyear);
		txtyear.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(158, 257, 100, 23);
		panel_2.add(btnCalculate);
		
		JLabel lblApplyingFor = new JLabel("PREFERED FIELD OF STUDY");
		lblApplyingFor.setBounds(24, 426, 154, 14);
		panel_1.add(lblApplyingFor);
		
		JComboBox cmbDepartment = new JComboBox();
		cmbDepartment.setModel(new DefaultComboBoxModel(new String[] {"<select field>", "Electrical engineering", "Civil engineering", "Chemical engineering", "Computer engineering", "Software engineering", "Mathematical engineering", "Mining engineering", "Mechanical engineering"}));
		cmbDepartment.setBounds(220, 423, 154, 20);
		panel_1.add(cmbDepartment);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBounds(266, 454, 488, 62);
		frmRegistrationForm.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
			}
		});
		btnClear.setBounds(129, 28, 81, 23);
		panel_3.add(btnClear);
		
		JButton btnClose = new JButton("CLOSE ");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegistrationForm.dispose();
			}
		});
		btnClose.setBounds(10, 28, 105, 23);
		panel_3.add(btnClose);
		
		JButton btnHidden = new JButton("View Reg Form");
		btnHidden.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHidden.setBounds(335, 28, 135, 23);
		panel_3.add(btnHidden);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBounds(220, 28, 105, 23);
		panel_3.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            //method that adds registered students to linkedlist.
				
				
				
				if(txtfisrtname.getText().equals("") || txtlastname.getText().equals("") || txtemail.getText().equals("") ||
				   txtGPA.getText().equals("")
				   ||txtscore6.getText().equals("")||rdbtnFemale.equals(false)&&rdbtnMale.equals(false) || cmbDepartment.getSelectedIndex()==0) { 
					JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE FILLED","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else {
				
				
				File linkedFile = new File("LikedDatabase.dat");
				LinkedList readList = new LinkedList();
				LinkedList writeList = new LinkedList();
				
				try {
					FileInputStream fis = new FileInputStream(linkedFile);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Object obj = ois.readObject();
					readList = (LinkedList) obj;
					
					fis.close();
					ois.close();	
					
					readList.insertFirst(txtGPA.getText(), txtfisrtname.getText(), txtlastname.getText(), cmbDepartment.getSelectedItem().toString(), txtemail.getText());
					writeList= readList;
					FileOutputStream fos = new FileOutputStream(linkedFile);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
				
					oos.writeObject(writeList);
					fos.flush();
					fos.close();
					oos.close();
				
					} catch (IOException e1) {
						e1.printStackTrace();
						} catch (ClassNotFoundException e) {
						e.printStackTrace();
						}
				clear();
				
				dfl = new DefaultListModel<>();
				dfl.addElement(readList);
				
				reg.frame.setVisible(true);
				}
			}
		});
		
		btnHidden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reg.frame.setVisible(true);
			}
		});
		
		JLabel lblPersonalInformation = new JLabel("PERSONAL INFORMATION");
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonalInformation.setBounds(113, 11, 195, 14);
		frmRegistrationForm.getContentPane().add(lblPersonalInformation);
		
		btnCalculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtGPA.setText(CalcGPA());
			}
		});
		
	
	}
	
	public void clear() {
		txtfisrtname.setText("");
		txtlastname.setText("");
		txtdob.setText("");
		txtcity.setText("");
		txtemail.setText("");
		txtGPA.setText("");
		txtId.setText("");
		txtphone.setText("");
		txtzipcode.setText("");
		txtstate.setText("");
		txtyear.setText("");
		txtoptionalcourse.setText("");
		txtscore.setText("");
		txtscore2.setText("");
		txtscore3.setText("");
		txtscore4.setText("");
		txtscore5.setText("");
		txtscore6.setText("");
		txtscore7.setText("");
		comboBoxfunds.setSelectedIndex(-1);
		group.clearSelection();
	}
	public String CalcGPA() {
		double y = Double.parseDouble(txtscore.getText()) + Double.parseDouble(txtscore2.getText())
					+ Double.parseDouble(txtscore3.getText())+Double.parseDouble(txtscore4.getText())+
					Double.parseDouble(txtscore5.getText())+Double.parseDouble(txtscore6.getText());
				double gpa =(4.0 * y)/600;
	DecimalFormat format =new DecimalFormat("#.00");
		return String.valueOf(format.format(gpa));
	}
	
	
}
