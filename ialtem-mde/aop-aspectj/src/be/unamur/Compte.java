package be.unamur;

import java.util.Hashtable;

import be.unamur.utils.UtilsCompte;

public class Compte {
	private Float solde = 0f;
	private String rib;
	private Client client;
 
	public Compte(Client client) {
		this.client = client;
		this.rib = UtilsCompte.genererNumeroCompte("000");
	}

	public Float getSolde() {
		return solde;
	}

	public Compte deposer(Float montant) {
		this.solde += montant;
		//System.out.printf("Dépôt de %.2f sur le compte de %s. Solde = %.2f\n", montant, this.client.getIdentite(), this.solde);
		return this;
	}
	
	public Compte retirer(Float montant) {
		this.solde -= montant;
		//System.out.printf("Retrait de %.2f sur le compte de %s. Solde = %.2f\n", montant, this.client.getIdentite(), this.solde);
		return this;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getRib() {
		return rib;
	}

	public Client getClient() {
		return client;
	}
	
	public Compte transferer(String destName, Float montant){
		Hashtable<String, Compte> contacts = this.getClient().getContacts();
		Boolean destExist = contacts.containsKey(destName.trim());
		if(destExist) {
			Compte destCompte = contacts.get(destName);
			return transferer(destCompte, montant);
		}
		System.out.printf("%s n'est pas dans votre liste de contacts.\n", destName);
		return this;
        
    }

	public Compte transferer(Compte dest, Float montant){

		this.retirer(montant);
        dest.deposer(montant);
        
        return this;
    }
	
}
