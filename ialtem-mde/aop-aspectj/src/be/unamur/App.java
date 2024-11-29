package be.unamur;

import be.unamur.exceptions.AlreadyClosedException;

public class App {

	public static void main(String[] args) throws AlreadyClosedException {
		// TODO Auto-generated method stub
		Reader scanner = Reader.getInstance();
		new App().ioc();
		scanner.close();
	}
	
	public void ioc() throws AlreadyClosedException {
		// Initialisation d'un compte
		Compte compte = initilization();
		
		welcome(compte);
		
		// Transactions sur le compte
		transactions(compte);
	}
	
	private Compte initilization() {
		
		Client client = new Client();
		Compte compte = new Compte(client);
		
		return compte;
	}
	
	private void welcome(Compte compte) {
		System.out.println("\n");
		System.out.println(
				"██████  ███████ ██████   █████  ███    ██ ██   ██ \r\n"
				+ "██   ██ ██      ██   ██ ██   ██ ████   ██ ██  ██  \r\n"
				+ "██████  █████   ██████  ███████ ██ ██  ██ █████   \r\n"
				+ "██   ██ ██      ██   ██ ██   ██ ██  ██ ██ ██  ██  \r\n"
				+ "██████  ███████ ██████  ██   ██ ██   ████ ██   ██ \r\n"
				+ "\r\n"
				+ "");
		System.out.printf("Welcome %s!\n",compte.getClient().getIdentite());
		System.out.println("=============================================");
	}
	
	private void transactions(Compte compte) throws AlreadyClosedException {
		Boolean loop = true;
		
		while(loop) {
			System.out.println("Quelle transaction voulez-vous effectuer ?\n1- Depôt\n2- Retrait\n3- Transfert");

			Reader scanner = Reader.getInstance();
			
			Integer choice = scanner.nextInt();
			
			Float montant = 0f;
			
			switch(choice) {
				case 1:
					// Depôt
					System.out.print("Montant du dépôt: ");
					montant = scanner.nextFloat();
					compte.deposer(montant);
					System.out.print("\n");
					break;
				case 2:
					// Retrait
					System.out.print("Montant du retrait: ");
					montant = scanner.nextFloat();
					compte.retirer(montant);
					System.out.print("\n");
					break;
	
				case 3:
					// Virement d'argent vers un autre compte
					System.out.print("Le nom du destinataire: ");
					String destName = scanner.next();
					System.out.print("Montant du transfert: ");
					montant = scanner.nextFloat();
					compte.transferer(destName, montant);
					System.out.print("\n");
					break;
				default:
					// Arrêter
					loop = false;
					break;
			}
		}
	}
}
