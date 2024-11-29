package be.unamur;

import java.util.Hashtable;

public class Client {
	private String identite = "anonym";
	private String password = "";
	Hashtable<String, Compte> contacts = new Hashtable<>();
	
	public Client() {}
	
	public Client(String identite) {
		this.identite = identite;
	}

	public Client(String identite, String password) {
		this.identite = identite;
		this.password = password;
	}

	public String getIdentite() {
		return identite;
	}

	public String getPassword() {
		return password;
	}
	
	public Hashtable<String, Compte> getContacts() {
		return contacts;
	}
	
	public Hashtable<String, Compte> addContact(String ident, Compte c){
		contacts.put(ident, c);
		return contacts;
	}

}
