package classe;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bataille {
	public static void main(String[] args) {
		List<carte> paquetDeCartes = carte.PaquetDeCartes();
		Collections.shuffle(paquetDeCartes);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Entrez le pseudonyme du Joueur 1 : ");
		String pseudonymeJoueur1 = scanner.nextLine();
		Joueur joueur1 = new Joueur(pseudonymeJoueur1);

		System.out.println("Entrez le pseudonyme du Joueur 2 : ");
		String pseudonymeJoueur2 = scanner.nextLine();
		Joueur joueur2 = new Joueur(pseudonymeJoueur2);

		int pointsJoueur1 = 0;
		int pointsJoueur2 = 0;
		
		//26 tours max s'il reste des cartes dans le paquet
		for (int tour = 1; tour <= 26; tour++) {
			System.out.println("Tour " + tour);
			if (paquetDeCartes.isEmpty()) {
				System.out.println("Le paquet de cartes est vide, c'est la fin de la partie !");
				break;
			}
			
			//on lance le systeme du jeu (piocher, comparer)
			
			joueur1.piocherCarte(paquetDeCartes);
			joueur2.piocherCarte(paquetDeCartes);

			System.out.println(
					joueur1.getPseudonyme() + " pioche : " + joueur1.getCarteDernierTour().getValeur().getNom2()
							+ " de " + joueur1.getCarteDernierTour().getCouleur().getNom());
			System.out.println(
					joueur2.getPseudonyme() + " pioche : " + joueur2.getCarteDernierTour().getValeur().getNom2()
							+ " de " + joueur2.getCarteDernierTour().getCouleur().getNom());

			int comparaison = joueur1.getCarteDernierTour().comparerCarte(joueur2.getCarteDernierTour());

			if (comparaison > 0) {
				pointsJoueur1++;
				System.out.println("Joueur " + joueur1.getPseudonyme() + " gagne le tour !");
			} else if (comparaison < 0) {
				pointsJoueur2++;
				System.out.println("Joueur " + joueur2.getPseudonyme() + " gagne le tour !");
			} else {
				System.out.println("Égalité ! ATTENTION BATAILLE !");

				// si égalité alors bataille et on rejoue un tour
				int comparaisonBataille = 0;
				while (comparaisonBataille == 0) {
					if (paquetDeCartes.isEmpty()) {
						System.out.println("Le paquet de cartes est vide. Fin de la partie.");
						break;
					}

					joueur1.piocherCarte(paquetDeCartes);
					joueur2.piocherCarte(paquetDeCartes);

					System.out.println(
							joueur1.getPseudonyme() + " pioche : " + joueur1.getCarteDernierTour().getValeur().getNom2()
									+ " de " + joueur1.getCarteDernierTour().getCouleur().getNom());
					System.out.println(
							joueur2.getPseudonyme() + " pioche : " + joueur2.getCarteDernierTour().getValeur().getNom2()
									+ " de " + joueur2.getCarteDernierTour().getCouleur().getNom());

					comparaisonBataille = joueur1.getCarteDernierTour().comparerCarte(joueur2.getCarteDernierTour());
				}

				if (comparaisonBataille > 0) {
					pointsJoueur1++;
					System.out.println("Joueur " + joueur1.getPseudonyme() + " gagne la Bataille !");
				} else {
					pointsJoueur2++;
					System.out.println("Joueur " + joueur2.getPseudonyme() + " gagne la Bataille !");
				}
			}

			// afficher les scores à chaque tour
			System.out.println("Points de " + joueur1.getPseudonyme() + " : " + pointsJoueur1);
			System.out.println("Points de " + joueur2.getPseudonyme() + " : " + pointsJoueur2);
		}

		//afficher le score final des joueurs
		joueur1.ajouterScore(pointsJoueur1);
		joueur2.ajouterScore(pointsJoueur2);
		
		System.out.println("Voici votre score final: ");
		System.out.println("Points de " + joueur1.getPseudonyme() + " : " + joueur1.getScore());
		System.out.println("Points de " + joueur2.getPseudonyme() + " : " + joueur2.getScore());
	}
}
