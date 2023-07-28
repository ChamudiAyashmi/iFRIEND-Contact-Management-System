class ContactList{
	private Node first;
	
	public Node getFirst(){
		return first;
	}
	private boolean isEmpty(){
		return first==null;
	}
	public void add(Contacts contacts){
		Node n1=new Node(contacts);
		Node lastNode=first;
			if(isEmpty()){
				first=n1;
			}else{
				while(lastNode.getNext()!=null){
					lastNode=lastNode.getNext();
				}
				lastNode.setNext(n1);
			}
	}
	public Contacts[] toArray(){
		Contacts[] contactArray=new Contacts[getSize()];
		Node temp=first;
		for (int i = 0; temp!=null; i++){
			contactArray[i]=temp.getContacts();
			temp=temp.getNext();
		}
		return contactArray;
	}
	public Contacts get(int index){
		if(isValidIndex(index)){
			if(index==0){
				return first.getContacts();
			}else{
				Node temp=first;
				for(int i=0; i<index; i++){
					temp=temp.getNext();
				}
				return temp.getContacts();
			}
		}
		return null;
	}
	public boolean isValidIndex(int index){
		return index>=0 & index<=getSize();
	}
	public void updateName(int index, String name){
		get(index).setName(name);
	}
	public void updatePhoneNumber(int index, String phone){
		get(index).setPhoneNumber(phone);
	}
	public void updateCompanyName(int index, String company){
		get(index).setCompanyName(company);
	}
	public void updateSalary(int index, double salary){
		get(index).setSalary(salary);
	}
	public void remove(int index){
		if(isValidIndex(index)){
			if(index==0){
				first=first.getNext();
			}else{
				Node temp=first;
				for (int i = 0; i < index-1; i++){
					temp=temp.getNext();
				}
					temp.setNext(temp.getNext().getNext());
			}
		}
	}
	public int searchByNameOrPhone(String nameOrPhone){
		Node temp=first;
		int index=0;
		while(temp!=null){
			if(temp.getContacts().getName().equals(nameOrPhone) || temp.getContacts().getPhoneNumber().equals(nameOrPhone)){
				return index;
			}
			temp=temp.getNext();
			index++;
		}
		return -1;
	}
	public int getSize(){
		Node temp=first;
		int count=0;
		while(temp!=null){
			temp=temp.getNext();
			count++;
		}
		return count;
	}
}

