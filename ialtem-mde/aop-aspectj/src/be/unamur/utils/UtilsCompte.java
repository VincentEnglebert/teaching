package be.unamur.utils;

import java.text.DecimalFormat;

public class UtilsCompte {
	private static int compteur = 1; // Compteur initialisé à 0
	
	public static String genererNumeroCompte(String format) {
        // Formatter le numéro de compte avec des zéros non significatifs
        DecimalFormat formatter = new DecimalFormat(format);
        String compteFormate = formatter.format(compteur);

        // Préfixe (facultatif)
        String prefixe = "BE"; // Vous pouvez personnaliser le préfixe ici

        // Générer le numéro de compte complet
        String numeroCompte = prefixe + compteFormate;

        // Incrémenter le compteur
        compteur++;

        return numeroCompte;
    }
}
