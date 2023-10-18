package classe;

import java.util.ArrayList;

import java.util.List;

public class carte{
		
		public enum Couleur {
			COEUR("Coeur"), 
			PIQUE("Pique"), 
			TREFFLE("Treffle"),
			CARREAUX("Carreaux");
			
			private final String nom;
			
			private Couleur(String nom) {
				this.nom = nom;
			}
			
			public String getNom() {
				return nom;
			}
				
		}
		
		public enum Valeur{
			
			AS("As",1),
			DEUX("Deux",2),
			TROIS("Trois",3),
			QUATRES("Quatres",4),
			CINQ("Cinq",5),
			SIX("Six",6),
			SEPT("Sept",7),
			HUIT("Huit",8),
			NEUF("Neuf",9),
			DIX("Dix",10),
			VALLET("Vallet",11),
			DAME("Dame",12),
			ROI("Roi",13);
			
			private final String nom2;
			private final int valeur;
			
			private Valeur(String nom2, int valeur) {
				this.nom2 = nom2;
				this.valeur = valeur;
			}
			
			public String getNom2() {
				return nom2;
			}
			
			public int getValeur() {
				return valeur;
			}
		}	
		private Couleur couleur;
		private Valeur valeur;
		
		//constructeur
		public carte(Couleur couleur, Valeur valeur) {
			this.couleur = couleur;
			this.valeur = valeur;
		}
		
		//creation d'un paquet de carte
		public static List<carte> PaquetDeCartes() {
	        List<carte> paquet = new ArrayList<>();

	        for (Couleur couleur : Couleur.values()) {
	            for (Valeur valeur : Valeur.values()) {
	                carte nouvelleCarte = new carte(couleur, valeur);
	                paquet.add(nouvelleCarte);
	            }
	        }
	        return paquet;
	    }
		
		 // comparer les cartes pour savoir qui a la plus grande
	    public int comparerCarte(carte Cartej2) {
	        int valeurCartej1 = this.getValeur().getValeur();
	        int valeurCartej2 = Cartej2.getValeur().getValeur();

	        if (valeurCartej1 < valeurCartej2) {
	            return -1;
	        } else if (valeurCartej1 > valeurCartej2) {
	            return 1;
	        } else {
	            return 0; // s'il y a une égalité
	        }
	    }

		public Couleur getCouleur() {
			return couleur;
		}

		public Valeur getValeur() {
			return valeur;
		}

}
