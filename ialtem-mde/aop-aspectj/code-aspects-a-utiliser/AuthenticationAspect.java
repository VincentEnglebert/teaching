package be.unamur.aspects;
import be.unamur.Client;
import be.unamur.Compte;
import be.unamur.Reader;
import be.unamur.exceptions.AlreadyClosedException;

public aspect AuthenticationAspect {
	
	// récupérer les paramètres de connexion de bob
	String myLogin = "bob";
	String myPass = "123";
	Client client = new Client(myLogin, myPass);
	
	pointcut login(): (
		xxx
	);
	
	Compte around(): login(){
		
		Compte compte = null;
		try {
			Reader scanner = Reader.getInstance();
			System.out.print("Votre identite: ");
			String identite = scanner.next();
			System.out.print("Votre password: ");
			String password = scanner.next();
			
			// Méchanisme de vérification des paramètres fournis
			if(myLogin.equals(identite) && myPass.equals(password)) {
				try {
					// Zapper
					// proceed();
					// Retourner le compte de bob depuis la base de données
					// Ici nous allons nous contenter d'initialiser un compte
					compte = new Compte(client);
					
					// Charger ses contacts
					chargerContacts(client);

				}catch(Throwable e) {
					e.printStackTrace();
				}
			}else {
				// Informer que la connexion n'est pas possible
				throw new RuntimeException("Identifiants incorrects");
			}
			
		}catch(AlreadyClosedException a) {
			
		}
		return compte;
	}

	private void chargerContacts(Client client) {
		System.out.printf("Chargement des contacts de: %s\n", client.getIdentite());
		// Chargement des comptes de ses contacts depuis la base de données
		// le chargement doit être dynamique pour tenir compte de chaque client
		client.addContact("aline", new Compte(new Client("aline")));
		client.addContact("peter", new Compte(new Client("peter")));
		client.addContact("zoe", new Compte(new Client("zoe")));
	}

}