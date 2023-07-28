import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddContacts extends JFrame{
	private JLabel titleLabel;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthday;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBackToHome;
	
	public AddContacts(){
		setSize(700,500);
		setTitle("Add Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(71, 39, 71));
		
		titleLabel=new JLabel("ADD CONTACTS");
		titleLabel.setFont(new Font("",1,30));
		titleLabel.setBounds(220,10,700,35);
		titleLabel.setForeground(new Color(248, 205, 248));
		panel1.add(titleLabel);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(248, 205, 248));
		
		lblId=new JLabel("Contact ID");
		lblId.setFont(new Font("",1,20));
		lblId.setBounds(70,20,700,20);
		lblId.setForeground(new Color(71, 39, 71));
		panel2.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		lblName.setBounds(70,65,700,20);
		lblName.setForeground(new Color(71, 39, 71));
		panel2.add(lblName);
		
		lblPhone=new JLabel("Contact Number");
		lblPhone.setFont(new Font("",1,20));
		lblPhone.setBounds(70,110,700,20);
		lblPhone.setForeground(new Color(71, 39, 71));
		panel2.add(lblPhone);
		
		lblCompany=new JLabel("Company Name");
		lblCompany.setFont(new Font("",1,20));
		lblCompany.setBounds(70,155,700,25);
		lblCompany.setForeground(new Color(71, 39, 71));
		panel2.add(lblCompany);
		
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		lblSalary.setBounds(70,200,700,25);
		lblSalary.setForeground(new Color(71, 39, 71));
		panel2.add(lblSalary);
		
		lblBirthday=new JLabel("Birthday");
		lblBirthday.setFont(new Font("",1,20));
		lblBirthday.setBounds(70,245,700,25);
		lblBirthday.setForeground(new Color(71, 39, 71));
		panel2.add(lblBirthday);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,20));
		txtId.setBounds(280,20,200,28);
		txtId.setEditable(false);
		txtId.setText(ContactsController.generateId());
		panel2.add(txtId);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		txtName.setBounds(280,65,200,28);
		panel2.add(txtName);
		
		txtPhone=new JTextField(15);
		txtPhone.setFont(new Font("",1,20));
		txtPhone.setBounds(280,110,200,28);
		txtPhone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String phoneNumber=txtPhone.getText();
				boolean isValidPhoneNumber=ContactsController.isValidPhoneNumber(phoneNumber);
				if(!isValidPhoneNumber){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input number again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtPhone.setText("");
						txtPhone.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtPhone.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		panel2.add(txtPhone);
		
		txtCompany=new JTextField(15);
		txtCompany.setFont(new Font("",1,20));
		txtCompany.setBounds(280,155,200,28);
		panel2.add(txtCompany);
		
		txtSalary=new JTextField(15);
		txtSalary.setFont(new Font("",1,20));
		txtSalary.setBounds(280,200,200,28);
		txtSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				double salary=Double.parseDouble(txtSalary.getText());
				boolean isValidSalary=ContactsController.isValidSalary(salary);
				if(!isValidSalary){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input salary again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtSalary.setText("");
						txtSalary.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtPhone.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		panel2.add(txtSalary);
		
		txtBirthday=new JTextField(15);
		txtBirthday.setFont(new Font("",1,20));
		txtBirthday.setBounds(280,245,200,28);
		txtBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String birthday=txtBirthday.getText();
				boolean isValidBirthday=ContactsController.isValidBirthday(birthday);
				if(!isValidBirthday){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input birthday again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtBirthday.setText("");
						txtBirthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtPhone.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		panel2.add(txtBirthday);
		
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.setBounds(400,300,100,28);
		btnAdd.setForeground(new Color(248, 205, 248));
		btnAdd.setBackground(new Color(71, 39, 71));
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					String id=txtId.getText();
					String name=txtName.getText();
					String phoneNumber=txtPhone.getText();
					String companyName=txtCompany.getText();
					double salary=Double.parseDouble(txtSalary.getText());
					String birthday=txtBirthday.getText();
					Contacts contacts=new Contacts(id,name,phoneNumber,companyName,salary,birthday);
					
					boolean isValidPhoneNumber=ContactsController.isValidPhoneNumber(phoneNumber);
					boolean isValidSalary=ContactsController.isValidSalary(salary);
					boolean isValidBirthday=ContactsController.isValidBirthday(birthday);
					
					
					if(!isValidPhoneNumber){
						int option=JOptionPane.showConfirmDialog(null,"Invalid phone number...Do you want to enter phone number again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtPhone.setText("");
							txtPhone.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactsController.count();
							txtId.setText(ContactsController.generateId());
							txtName.setText("");
							txtPhone.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else if(!isValidSalary){
						int option=JOptionPane.showConfirmDialog(null,"Invalid salary...Do you want to enter salary again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtSalary.setText("");
							txtSalary.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactsController.count();
							txtId.setText(ContactsController.generateId());
							txtName.setText("");
							txtPhone.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else if(!isValidBirthday){
						int option=JOptionPane.showConfirmDialog(null,"Invalid birthday...Do you want to enter birthday again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtBirthday.setText("");
							txtBirthday.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactsController.count();
							txtId.setText(ContactsController.generateId());
							txtName.setText("");
							txtPhone.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else{
						ContactsController.addContacts(contacts);
						int option=JOptionPane.showConfirmDialog(null,"Added Successfull..Do you want to add another contact ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtId.setText(ContactsController.generateId());
							txtName.setText("");
							txtPhone.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							txtName.requestFocus();
							
						}else if(option==JOptionPane.NO_OPTION){
							txtId.setText(ContactsController.generateId());
							txtName.setText("");
							txtPhone.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}
						
						
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"No Contact added...");
				}
				
			}
		
		});
		panel2.add(btnAdd);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.setBounds(520,300,100,28);
		btnCancel.setForeground(new Color(248, 205, 248));
		btnCancel.setBackground(new Color(71, 39, 71));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhone.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
			}
		});
		panel2.add(btnCancel);
		
		btnBackToHome=new JButton("Back To Homepage");
		btnBackToHome.setFont(new Font("",1,20));
		btnBackToHome.setBounds(400,340,220,28);
		btnBackToHome.setForeground(new Color(248, 205, 248));
		btnBackToHome.setBackground(new Color(71, 39, 71));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhone.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
				dispose();
			}
		});
		panel2.add(btnBackToHome);
		
		add(panel1);
		add(panel2);
		
	}
}
