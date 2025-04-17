/*package be.unamur.aspects;

import java.util.logging.Logger;

import be.unamur.Compte;

public aspect LoggingAspect{

    private static int compteur = 1;

    Logger log = Logger.getLogger(this.getClass().getName());

    private static String transactionType(String methodName) {
        String numeroTransaction = "";
         if(methodName == "deposer") 
            numeroTransaction = String.format("TR%d ==>", compteur);
         else if (methodName == "retirer") 
            numeroTransaction = String.format("TR%d <==", compteur);
         return numeroTransaction;
    }

    pointcut transactionLog(Float montant): 
    (
        xxx
    );

    after(Float montant): transactionLog(montant){

        // récupérer le compte sur lequel s'opère la transaction

        // récupérer le nom de la méthode

        String transaction = transactionType(methodName);

        String trace = String.format("[%s %s(%s); Montant = %.2f; Solde = %.2f]\n", transaction, compte.getRib(), compte.getClient().getIdentite(), montant, compte.getSolde());
        log.info(trace);
        compteur++;

    }

}
*/