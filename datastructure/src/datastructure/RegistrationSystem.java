package datastructure;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Label;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationSystem {

	public JFrame frame;
	JList listunsorted = new JList();
	JList listsorted = new JList();
	JTextArea textArea = new JTextArea();
	JTextArea textArea_Sorted = new JTextArea();
	
	File elec = new File("electrical.dat");
	File chem = new File("chemical.dat");
	File mini = new File("mining.dat");
	File comp = new File("computer.dat");
	File math = new File("mathematical.dat");
	File soft = new File("software.dat");
	File mech = new File("mechanical.dat");
	File civ = new File("civil.dat");
	
	public RegistrationSystem() {	

		DefaultListModel<String> dfl = new DefaultListModel<>();
		DefaultListModel<String> dflSorted = new DefaultListModel<>();
		DefaultListModel<String> dflFinal = new DefaultListModel<>();
		
		File f = new File("LikedDatabase.dat"); 
		FileInputStream fis;
		ObjectInputStream ois;
		LinkedList linked = new LinkedList();
		
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			linked = (LinkedList) ois.readObject();
			fis.close();
			ois.close();
			Node n = linked.first;
			while(n!=null) {
				System.out.println(n.toString());
				dfl.addElement(n.toString());
				n=n.getLink();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		listunsorted.setModel(dfl); 
		
		listsorted.setModel(dflSorted);
		
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("REGISTRATION FORM");
		frame.setResizable(false);
		frame.setForeground(new Color(0, 0, 0));
		frame.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 932, 606);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(20, 260, 873, 8);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(408, 24, 2, 225);
		frame.getContentPane().add(separator_1);
		
		
		//*********************************
		listunsorted.setBounds(22, 23, 360, 174);
		frame.getContentPane().add(listunsorted);
		
		
		JLabel lblRegistered = new JLabel("Application List");
		lblRegistered.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRegistered.setBounds(26, 11, 168, 14);
		frame.getContentPane().add(lblRegistered);
		
		JButton btnsortList = new JButton("SORT THE LIST ACCORDING TO DEPARTMENT");
		
		btnsortList.setFont(new Font("Dialog", Font.BOLD, 12));
		btnsortList.setBounds(20, 216, 362, 29);
		frame.getContentPane().add(btnsortList);
		
		JLabel lblNewLabel_3 = new JLabel("Department List");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_3.setBounds(433, 11, 153, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBoxdepartment = new JComboBox();
		comboBoxdepartment.setBounds(495, 220, 172, 29);
		comboBoxdepartment.setModel(new DefaultComboBoxModel(new String[] {"<select department>", 
				"Electrical engineering", "Civil engineering", "Chemical engineering", "Computer engineering", 
				"Software engineering", "Mathematical engineering", "Mining engineering", "Mechanical engineering"}));

		frame.getContentPane().add(comboBoxdepartment);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.setFont(new Font("Dialog", Font.BOLD, 12));
		btnApprove.setBounds(761, 220, 90, 29);
		frame.getContentPane().add(btnApprove);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(687, 220, 40, 29);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_4 = new JLabel("Approve from department:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_4.setBounds(501, 206, 161, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FINAL LIST OF SUCCESFULL CANDIDATES");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_5.setBounds(20, 273, 235, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnSAVE = new JButton("SAVE");
		btnSAVE.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSAVE.setBounds(692, 523, 102, 34);
		frame.getContentPane().add(btnSAVE);
		
		JButton btnNewButton_2 = new JButton("PRINT");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(547, 524, 102, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EMAIL");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(384, 524, 102, 33);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(692, 207, 46, 14);
		frame.getContentPane().add(lblNumber);
		
		
		textArea.setBounds(20, 309, 873, 203);
		frame.getContentPane().add(textArea);
		textArea.setEditable(false);
		
		
		textArea_Sorted.setText("");
		textArea_Sorted.setEditable(false);
		textArea_Sorted.setBounds(433, 24, 460, 173);
		frame.getContentPane().add(textArea_Sorted);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(876, 309, 17, 69);
		frame.getContentPane().add(scrollBar);
		
		btnsortList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File("LikedDatabase.dat"); 
				
				FileInputStream fis;
				ObjectInputStream ois;
				LinkedList linked = new LinkedList();
				
				MaxHeap electrical = new MaxHeap();
				MaxHeap softwaree = new MaxHeap();
				MaxHeap chemical = new MaxHeap();
				MaxHeap mining = new MaxHeap();
				MaxHeap computer = new MaxHeap();
				MaxHeap mathematical = new MaxHeap();
				MaxHeap software = new MaxHeap();
				MaxHeap mechanical = new MaxHeap();
				MaxHeap civil = new MaxHeap(); 
				
				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					linked = (LinkedList) ois.readObject();
					fis.close();
					ois.close();
					Node n = linked.first;
					while(n!=null) {
						if(n.getDepartmentSelection().equals("Electrical engineering") && Double.parseDouble(n.getGPA())>2.0) {
							electrical.add(n);
							
						}
						else if(n.getDepartmentSelection().equals("Civil engineering") && Double.parseDouble(n.getGPA())>2.0) {
							civil.add(n);
						}
						else if(n.getDepartmentSelection().equals("Chemical engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							chemical.add(n);
						}
						else if(n.getDepartmentSelection().equals("Mining engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							mining.add(n);
						}
						else if(n.getDepartmentSelection().equals("Computer engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							computer.add(n);
						}
						else if(n.getDepartmentSelection().equals("Software engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							software.add(n);
						}
						else if(n.getDepartmentSelection().equals("Mathematical engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							mathematical.add(n);

						}
						else if(n.getDepartmentSelection().equals("Mechanical engineering")&& Double.parseDouble(n.getGPA())>2.0) {
							mechanical.add(n);
						}
						
						Node m =n.getLink();
						linked.removeFirst();
						n = m ;
					}
				
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				writeToFile(elec, electrical);
				writeToFile(chem, chemical);
				writeToFile(math, mathematical);
				writeToFile(soft, software);
				writeToFile(mech, mechanical);
				writeToFile(civ, civil);
				writeToFile(comp, computer);
				writeToFile(mini, mining);
				
				
				textArea_Sorted.setText(readFromFile(elec) +readFromFile(chem)
				+readFromFile(math)
				+readFromFile(soft)
				+readFromFile(mech)
				+readFromFile(civ)
				+readFromFile(comp)
				+readFromFile(mini));
				
				
			}
		});
		
		btnApprove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String toList= textArea.getText();
				boolean b = true;
				while(b) {
				if(comboBoxdepartment.getSelectedIndex() == 0) {
					
				}	
				else if(comboBoxdepartment.getSelectedIndex() == 1)
				{
					toList= toList + readFromFile2(elec,(int)spinner.getValue());
				}
				else if(comboBoxdepartment.getSelectedIndex() == 2) {
					toList= toList +readFromFile2(civ,(int)spinner.getValue());	
				}
				else if(comboBoxdepartment.getSelectedIndex() == 3) {
					toList= toList + readFromFile2(chem,(int)spinner.getValue());
				}
				else if(comboBoxdepartment.getSelectedIndex() == 4) {
					toList= toList + readFromFile2(comp,(int)spinner.getValue());		
				}
				else if(comboBoxdepartment.getSelectedIndex() == 5){
					toList= toList + readFromFile2(soft,(int)spinner.getValue());
								}
				else if(comboBoxdepartment.getSelectedIndex() == 6) {
					toList= toList + readFromFile2(math,(int)spinner.getValue());
									}
				else if(comboBoxdepartment.getSelectedIndex() == 7) {
					toList= toList + readFromFile2(mini,(int)spinner.getValue());
				}
				else if(comboBoxdepartment.getSelectedIndex() == 8) {
					toList= toList + readFromFile2(mech,(int)spinner.getValue());
				}
				else
					break;
					b= false;
				}
			
				textArea.setText(toList);
						
			}
		});
		
		
		btnSAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("FinalList.txt");

				try {
					FileWriter fileWriter = new FileWriter(file, true);
					fileWriter.write(textArea.getText()+"\n");
					fileWriter.close();
					JOptionPane.showMessageDialog(null,"Candidates saved successfully.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public void writeToFile(File f, MaxHeap mh) {
		if(mh.isEmpty()==false){
			try {
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(mh);
				fos.flush();
				fos.close();
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String readFromFile(File f) {
		String s="";
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MaxHeap heapi = (MaxHeap) ois.readObject();
			s =heapi.Print();
			fis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
		
	}
	
	public String readFromFile2(File filename, int number) {
		String y="";
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MaxHeap heapi = (MaxHeap) ois.readObject();
			fis.close();
			ois.close();
			MaxHeap heapout = heapi; 
			for (int i = 0; i < number; i++) {
				y +=heapi.removeMax().toString();
				heapi.removeMax();
			}
			
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(heapout);
			fos.flush();
			fos.close();
			oos.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null,"No more Candidates");
		}
		return y;
		
	}
}
