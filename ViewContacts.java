import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ViewContacts extends JFrame{
	private JLabel titleLabel;

	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthday;
	private JButton btnCancel;
	
	private ListContactsByName listContactsByName;
	private ListContactsBySalary listContactsBySalary;
	private ListContactsByBirthday listContactsByBirthday;
	
	public ViewContacts(){
		setSize(700,500);
		setTitle("View Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,700,55);
		panel1.setBackground(new Color(71, 39, 71));
		
		titleLabel=new JLabel("CONTACTS LIST");
		titleLabel.setFont(new Font("",1,30));
		titleLabel.setBounds(220,10,700,35);
		titleLabel.setForeground(new Color(248, 205, 248));
		panel1.add(titleLabel);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,55,700,445);
		panel2.setBackground(new Color(248, 205, 248));
		
		btnListByName=new JButton("List By Name");
		btnListByName.setFont(new Font("",1,20));
		btnListByName.setBounds(210,40,280,35);
		btnListByName.setForeground(new Color(248, 205, 248));
		btnListByName.setBackground(new Color(71, 39, 71));
		btnListByName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(listContactsByName==null){
					listContactsByName=new ListContactsByName();
				}
				listContactsByName.setVisible(true);
			}
		});
		panel2.add(btnListByName);
		
		btnListBySalary=new JButton("List By Salary");
		btnListBySalary.setFont(new Font("",1,20));
		btnListBySalary.setBounds(210,100,280,35);
		btnListBySalary.setForeground(new Color(248, 205, 248));
		btnListBySalary.setBackground(new Color(71, 39, 71));
		btnListBySalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(listContactsBySalary==null){
					listContactsBySalary=new ListContactsBySalary();
				}
				listContactsBySalary.setVisible(true);
			}
			
		});
		panel2.add(btnListBySalary);
		
		btnListByBirthday=new JButton("List By Birthday");
		btnListByBirthday.setFont(new Font("",1,20));
		btnListByBirthday.setBounds(210,160,280,35);
		btnListByBirthday.setForeground(new Color(248, 205, 248));
		btnListByBirthday.setBackground(new Color(71, 39, 71));
		btnListByBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(listContactsByBirthday==null){
					listContactsByBirthday=new ListContactsByBirthday();
				}
				listContactsByBirthday.setVisible(true);
			}
			
		});
		panel2.add(btnListByBirthday);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.setBounds(520,320,100,28);
		btnCancel.setForeground(new Color(248, 205, 248));
		btnCancel.setBackground(new Color(71, 39, 71));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
			
		});
		panel2.add(btnCancel);
		
		add(panel1);
		add(panel2);
	}
}


