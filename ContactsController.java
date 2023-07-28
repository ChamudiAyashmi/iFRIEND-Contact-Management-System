import java.time.*;
public class ContactsController{
	public static boolean addContacts(Contacts contacts){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.add(contacts);
		return true;
	}
	public static boolean remove(int index){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.remove(index);
		return true;
	}
	public static Contacts[] getAllContacts(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		return contactList.toArray();
	}
	public static Contacts[] ListBySalary(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Contacts[] contactArray=contactList.toArray();
		for (int i = 1; i < contactArray.length; i++){
			for (int j = 0; j < contactArray.length-j; j++){
				if(contactArray[j].getSalary()>contactArray[j+1].getSalary()){
					Contacts temp=contactArray[j];
					contactArray[j]=contactArray[j+1];
					contactArray[j+1]=temp;
				}
			}
			
		}
		return contactArray;
		
	}
	public static Contacts[] ListByName(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Contacts[] contactArray=contactList.toArray();
		for (int i = 1; i < contactArray.length; i++){
			for (int j = 0; j < contactArray.length-j; j++){
				if(contactArray[j].getName().compareTo(contactArray[j+1].getName())>0){
					Contacts temp=contactArray[j];
					contactArray[j]=contactArray[j+1];
					contactArray[j+1]=temp;
				}
			}
			
		}
		return contactArray;
		
	}
	public static Contacts[] ListByBirthday(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Contacts[] contactArray=contactList.toArray();
		for (int i = 1; i < contactArray.length; i++){
			for (int j = 0; j < contactArray.length-j; j++){
				if(contactArray[j].getBirthday().compareTo(contactArray[j+1].getBirthday())>0){
					Contacts temp=contactArray[j];
					contactArray[j]=contactArray[j+1];
					contactArray[j+1]=temp;
				}
			}
			
		}
		return contactArray;
		
	}
	public static boolean isValidPhoneNumber(String phoneNumber){
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
			for (int i = 1; i < phoneNumber.length(); i++){
				if(!Character.isDigit(phoneNumber.charAt(i))){
					return false;
				}
				return true;
			}
		}
		return false;
	}
	public static boolean isValidSalary(double salary){
		if(salary<=0){
			return false;
		}
		return true;
	}
	public static boolean isValidBirthday(String birthday){
		String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;
									
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
	}
	
	public static int count=1;
	public static String generateId(){
		String id=String.format("C%04d",count);
		count++;
		return id;
	}
	
	public static boolean updateContacts(String id,String name,String phoneNumber,String companyName,double salary,String birthday,int index){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.get(index).setName(name);
		contactList.get(index).setPhoneNumber(phoneNumber);
		contactList.get(index).setSalary(salary);
		contactList.get(index).setCompanyName(companyName);
		contactList.get(index).setBirthday(birthday);
		return true;
	}
	
	public static int searchContacts(String nameOrPhone){
		ContactList contactList=DBConnection.getInstance().getContactList();
		return contactList.searchByNameOrPhone(nameOrPhone);
	}
	
	public static void count(){
		count--;
	}
}
