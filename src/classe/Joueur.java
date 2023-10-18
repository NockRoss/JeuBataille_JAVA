package classe;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String pseudonyme;
    private List<carte> jeuDeCartes;
    private int score;
    private carte carteDernierTour;
    
    //constructeur
    public Joueur(String pseudonyme) {
        this.pseudonyme = pseudonyme;
        jeuDeCartes = new ArrayList<>();
        score = 0;
    }
    
    //piocher al�atoirement une carte dans le paquet
    public void piocherCarte(List<carte> paquetDeCartes) {
        if (paquetDeCartes.isEmpty()) {
            System.out.println("Le paquet de cartes est vide.");
            return;
        }
        int indexCarteAleatoire = (int) (Math.random() * paquetDeCartes.size());
        carte cartePiochee = paquetDeCartes.remove(indexCarteAleatoire);

        jeuDeCartes.add(cartePiochee);
        carteDernierTour = cartePiochee;
    }

    public void afficherJeu() {
        System.out.println("Joueur : " + pseudonyme);
        for (carte carte : jeuDeCartes) {
            System.out.println(carte);
        }
    }

    public int getScore() {
        return score;
    }

    public void ajouterScore(int points) {
        score += points;
    }

    public carte getCarteDernierTour() {
        return carteDernierTour;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    // afficher les cartes tir�es par joueur�
    public void afficherCartesTirees() {
        System.out.println("Cartes tir�es par " + pseudonyme + ":");
        for (carte carte : jeuDeCartes) {
            System.out.println(carte.getValeur().getNom2() + " de " + carte.getCouleur().getNom());
        }
    }
}
