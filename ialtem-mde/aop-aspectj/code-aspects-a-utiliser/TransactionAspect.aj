/*package be.unamur.aspects;

public aspect TransactionAspect {

    // Permet de gérer le controle des données avant les transactions
    pointcut deposerControl(): call(public be.unamur.Compte deposer(Float));
    pointcut retirerControl(): call(public be.unamur.Compte retirer(Float));

    before(): deposerControl(){
        System.out.println("[Aspect] Control avant le dépot d'argent");
    }

    before(): retirerControl(){
        System.out.println("[Aspect] Control avant le retrait d'argent");
    }

}
*/