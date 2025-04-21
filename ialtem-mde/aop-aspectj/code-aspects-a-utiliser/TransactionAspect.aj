package be.unamur.aspects;
import be.unamur.*;

public aspect TransactionAspect {

    // Permet de gérer le controle des données avant les transactions
    pointcut deposerControl(): call(public Compte deposer(Float));
    pointcut retirerControl(): call(public Compte retirer(Float));

    before(): deposerControl(){
        System.out.println("[Aspect] Control avant le dépot d'argent");
    }

    // TODO: A améliorer pour éviter les retraits négatifs
    before(): retirerControl(){
        System.out.println("[Aspect] Control avant le retrait d'argent");
    }

}