import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainWindow extends JFrame{
	
	private JLabel titleLabel;
	private JLabel lbl1;
	private JLabel lbl2;
	private JButton btnAddContacts;
	private JButton btnUpdateContacts;
	private JButton btnSearchContacts;
	private JButton btnDeleteContacts;
	private JButton btnViewContacts;
	private JButton btnExit;
	
	private AddContacts addContacts;
	private UpdateContacts updateContacts;
	private SearchContacts searchContacts;
	private DeleteContacts deleteContacts;
	private ViewContacts viewContacts;
	
	public MainWindow(){
		setSize(700,500);
		setTitle("iFriend Contact Organizer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(300,0,400,500);
		panel1.setBackground(new Color(71, 39, 71));
		
		titleLabel=new JLabel("HOME PAGE");
		titleLabel.setBounds(100,10,350,60);
		titleLabel.setFont(new Font("",1,30));
		titleLabel.setForeground(new Color(248, 205, 248));
		panel1.add(titleLabel);
		
		btnAddContacts=new JButton("Add New Contacts");
		btnAddContacts.setFont(new Font("",1,20));
		btnAddContacts.setBounds(70,90,250,35);
		btnAddContacts.setBackground(new Color(248, 205, 248));
		btnAddContacts.setForeground(new Color(71, 39, 71));
		btnAddContacts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContacts==null){
					addContacts=new AddContacts();
				}
				addContacts.setVisible(true);
			}
			
		});
		panel1.add(btnAddContacts);
		
		btnUpdateContacts=new JButton("Update Contacts");
		btnUpdateContacts.setFont(new Font("",1,20));
		btnUpdateContacts.setBounds(70,140,250,35);
		btnUpdateContacts.setBackground(new Color(248, 205, 248));
		btnUpdateContacts.setForeground(new Color(71, 39, 71));
		btnUpdateContacts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContacts==null){
					updateContacts=new UpdateContacts();
				}
				updateContacts.setVisible(true);
			}
			
		});
		panel1.add(btnUpdateContacts);
		
		btnSearchContacts=new JButton("Search Contacts");
		btnSearchContacts.setFont(new Font("",1,20));
		btnSearchContacts.setBounds(70,190,250,35);
		btnSearchContacts.setBackground(new Color(248, 205, 248));
		btnSearchContacts.setForeground(new Color(71, 39, 71));
		btnSearchContacts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchContacts==null){
					searchContacts=new SearchContacts();
				}
				searchContacts.setVisible(true);
			}
			
		});
		panel1.add(btnSearchContacts);
		
		btnDeleteContacts=new JButton("Delete Contacts");
		btnDeleteContacts.setFont(new Font("",1,20));
		btnDeleteContacts.setBounds(70,240,250,35);
		btnDeleteContacts.setBackground(new Color(248, 205, 248));
		btnDeleteContacts.setForeground(new Color(71, 39, 71));
		btnDeleteContacts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContacts==null){
					deleteContacts=new DeleteContacts();
				}
				deleteContacts.setVisible(true);
			}
			
		});
		panel1.add(btnDeleteContacts);
		
		btnViewContacts=new JButton("View Contacts");
		btnViewContacts.setFont(new Font("",1,20));
		btnViewContacts.setBounds(70,290,250,35);
		btnViewContacts.setBackground(new Color(248, 205, 248));
		btnViewContacts.setForeground(new Color(71, 39, 71));
		btnViewContacts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewContacts==null){
					viewContacts=new ViewContacts();
				}
				viewContacts.setVisible(true);
			}
			
		});
		panel1.add(btnViewContacts);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20));
		btnExit.setBounds(250,360,100,35);
		btnExit.setBackground(new Color(248, 205, 248));
		btnExit.setForeground(new Color(71, 39, 71));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
			
		});
		panel1.add(btnExit);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,0,300,500);
		panel2.setBackground(new Color(248, 205, 248));
		
		lbl1=new JLabel("iFRIEND");
		lbl1.setFont(new Font("",1,35));
		lbl1.setBounds(80,120,300,35);
		lbl1.setForeground(new Color(71, 39, 71));
		panel2.add(lbl1);
		
		lbl2=new JLabel("Contact Manager");
		lbl2.setFont(new Font("",1,30));
		lbl2.setBounds(20,180,300,35);
		lbl2.setForeground(new Color(71, 39, 71));
		panel2.add(lbl2);
		
		add(panel2);
		add(panel1);
		
	}
	public static void main(String args[]){
		new MainWindow().setVisible(true);
	}	

}
