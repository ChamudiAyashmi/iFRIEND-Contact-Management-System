import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DeleteContacts extends JFrame{
	private JLabel titleLabel;
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthday;
	
	private JTextField txtSearch;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	private JButton btnSearch;
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnBackToHome;
	
	public DeleteContacts(){
		setSize(700,500);
		setTitle("Delete Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(71, 39, 71));
		
		titleLabel=new JLabel("DELETE CONTACTS");
		titleLabel.setFont(new Font("",1,30));
		titleLabel.setBounds(210,10,700,35);
		titleLabel.setForeground(new Color(248, 205, 248));
		panel1.add(titleLabel);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(248, 205, 248));
		
		lblId=new JLabel("Contact ID");
		lblId.setFont(new Font("",1,20));
		lblId.setBounds(70,50,700,20);
		lblId.setForeground(new Color(71, 39, 71));
		panel2.add(lblId);
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		lblName.setBounds(70,95,700,20);
		lblName.setForeground(new Color(71, 39, 71));
		panel2.add(lblName);
		
		lblPhone=new JLabel("Contact Number");
		lblPhone.setFont(new Font("",1,20));
		lblPhone.setBounds(70,140,700,20);
		lblPhone.setForeground(new Color(71, 39, 71));
		panel2.add(lblPhone);
		
		lblCompany=new JLabel("Company Name");
		lblCompany.setFont(new Font("",1,20));
		lblCompany.setBounds(70,185,700,25);
		lblCompany.setForeground(new Color(71, 39, 71));
		panel2.add(lblCompany);
		
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		lblSalary.setBounds(70,230,700,25);
		lblSalary.setForeground(new Color(71, 39, 71));
		panel2.add(lblSalary);
		
		lblBirthday=new JLabel("Birthday");
		lblBirthday.setFont(new Font("",1,20));
		lblBirthday.setBounds(70,275,700,25);
		lblBirthday.setForeground(new Color(71, 39, 71));
		panel2.add(lblBirthday);
		
		txtSearch=new JTextField(25);
		txtSearch.setFont(new Font("",1,20));
		txtSearch.setBounds(50,10,300,28);
		panel2.add(txtSearch);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,20));
		txtId.setBounds(280,50,200,28);
		panel2.add(txtId);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20));
		txtName.setBounds(280,95,200,28);
		panel2.add(txtName);
		
		txtPhone=new JTextField(15);
		txtPhone.setFont(new Font("",1,20));
		txtPhone.setBounds(280,140,200,28);
		panel2.add(txtPhone);
		
		txtCompany=new JTextField(15);
		txtCompany.setFont(new Font("",1,20));
		txtCompany.setBounds(280,185,200,28);
		panel2.add(txtCompany);
		
		txtSalary=new JTextField(15);
		txtSalary.setFont(new Font("",1,20));
		txtSalary.setBounds(280,230,200,28);
		panel2.add(txtSalary);
		
		txtBirthday=new JTextField(15);
		txtBirthday.setFont(new Font("",1,20));
		txtBirthday.setBounds(280,275,200,28);
		panel2.add(txtBirthday);
		
		btnSearch=new JButton("Search");
		btnSearch.setFont(new Font("",1,20));
		btnSearch.setBounds(520,10,110,28);
		btnSearch.setForeground(new Color(248, 205, 248));
		btnSearch.setBackground(new Color(71, 39, 71));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactList contactList=DBConnection.getInstance().getContactList();
				String nameOrPhone=txtSearch.getText();
				int index=ContactsController.searchContacts(nameOrPhone);
				if(txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text field is Empty... Search Contact again");
					txtSearch.requestFocus();
				}else if(index!=-1){
					txtId.setText(contactList.get(index).getId());
					txtName.setText(contactList.get(index).getName());
					txtPhone.setText(contactList.get(index).getPhoneNumber());
					txtCompany.setText(contactList.get(index).getCompanyName());
					txtSalary.setText(""+contactList.get(index).getSalary());
					txtBirthday.setText(contactList.get(index).getBirthday());
				}else{
					JOptionPane.showMessageDialog(null,"No contact found for "+nameOrPhone);
					txtSearch.setText("");
					txtSearch.requestFocus();
				}
			}
		});
		panel2.add(btnSearch);
		
		btnDelete=new JButton("Delete");
		btnDelete.setFont(new Font("",1,20));
		btnDelete.setBounds(400,320,110,28);
		btnDelete.setForeground(new Color(248, 205, 248));
		btnDelete.setBackground(new Color(71, 39, 71));
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrPhone=txtSearch.getText();
				int index=ContactsController.searchContacts(nameOrPhone);
				ContactsController.remove(index);
				if(txtSearch.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text Field is empty...");
				}else if(index==-1){
					JOptionPane.showMessageDialog(null,"Deleted Fail...");
				}else{
					JOptionPane.showMessageDialog(null,"Deleted Successfull...");
				}
				int option=JOptionPane.showConfirmDialog(null,"Do you want to delete contact again ?","Comfirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option==JOptionPane.YES_OPTION){
					txtSearch.setText("");
					txtSearch.requestFocus();
					txtId.setText("");
					txtName.setText("");
					txtPhone.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
				}else if(option==JOptionPane.NO_OPTION){
					txtSearch.setText("");
					txtId.setText("");
					txtName.setText("");
					txtPhone.setText("");
					txtCompany.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
					dispose();
				}
			}
		});
		panel2.add(btnDelete);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.setBounds(520,320,100,28);
		btnCancel.setForeground(new Color(248, 205, 248));
		btnCancel.setBackground(new Color(71, 39, 71));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtSearch.setText("");
				txtId.setText("");
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
		btnBackToHome.setBounds(400,360,220,28);
		btnBackToHome.setForeground(new Color(248, 205, 248));
		btnBackToHome.setBackground(new Color(71, 39, 71));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtSearch.setText("");
				txtId.setText("");
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


