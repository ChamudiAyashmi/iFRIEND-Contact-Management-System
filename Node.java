class Node{
	private Contacts contacts;
	private Node next;
		
	public Node getNext(){
		return next;
	}
	public Contacts getContacts(){
		return contacts;
	}
	public void setContacts(Contacts contacts){
		this.contacts=contacts;
	}
	public void setNext(Node next){
		this.next=next;
	}
		
	Node(Contacts contacts){
		this.contacts=contacts;
	}
}

