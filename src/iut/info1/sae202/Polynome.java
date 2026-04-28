/*
 * Polynome.java					17/04/2026
 * IUT de Rodez, BUT1 2025-2026, pas de copyright
 */
package iut.info1.sae202;

/**
 * Polynôme sous la forme Kx^n + Kx^n-1 + ... + Kx^0
 * avec K un réel quelconque
 * @author Noam LACOMBE
 */
public class Polynome {
	
	private final String ERREUR_COEFFICIENTS
						 = "Tableau de coefficients invalide";
	
	/**
	 * Polynôme du degré choisi sous la forme : 
	 * Kx^n + Kx^n-1 + ... + Kx^0
	 * avec K un réel quelconque choisi par l'utilisateur
	 * @param coefficients les différents coefficients du polynôme, donnés
	 * 		  dans l'ordre croissant du degré.
	 * 		  Exemple : le tableau [-2, 4, 3] donne le polynome 3x^2 + 4x - 2
	 * @throws IllegalArgumentException si polynôme invalide
	 */
	public Polynome(double[] coefficients) {
		if (isNotValide(coefficients)) {
			throw new IllegalArgumentException(ERREUR_COEFFICIENTS);
		}
		for (int indice = 0; indice < coefficients.length; indice++) {
			if (!Double.isFinite(coefficients[indice])) {
				throw new IllegalArgumentException(ERREUR_COEFFICIENTS);
			}
		}
	}
	
	/**
	 * Polynôme du degré choisi sous la forme : 
	 * Kx^n + Kx^n-1 + ... + Kx^0
	 * avec K un réel quelconque choisi par l'utilisateur
	 * @param racines différentes racines (réelles) du polynôme
	 * @param ordreMultiplicite ordre de multiplicité de chacune des racines
	 * @param coefficient coefficient du monôme de plus haut degré
	 * @throws IllegalArgumentException si polynôme invalide
	 */
	public Polynome(double[] racines, double[] ordreMultiplicite,
			        double coefficient) {
		/*TODO vérifier la validité des racines, de leur ordre de multiplicité
		  et du plus haut coefficient*/
	}
	
	/**
	 * Vérifie la validité du tableau de coefficients en vérifiant : 
	 * - un tableau null
	 * - un tableau vide
	 * - un tableau contenant des 0 inutiles
	 * @param coefficients les différents coefficients du polynôme, donnés
	 * 		  dans l'ordre croissant du degré.
	 * @return false si les valeurs du tableau sont valides, true sinon
	 */
	private static boolean isNotValide(double[] coefficients) {
		return     coefficients == null
				|| coefficients.length == 0
				|| coefficients.length > 1
				&& coefficients[coefficients.length - 1] == 0;
	}
	
	/**
	 * @return degré du polynome (degré du monôme de plus haut degré)
	 */
	public double getDegre() {
		return 0; //STUB
	}
	
	/**
	 * @return coefficients du polynôme
	 */
	public double[] getCoefficients() {
		return new double[] {0}; //STUB
	}
	
	/**
	 * @return limites du polynôme en -infini et +infini
	 */
	public double[] getLimites() {
		return new double[] {0}; //STUB
	}
	
	/**
	 * @return racines réelles du polynôme (si elles existent)
	 */
	public double[] getRacines() {
		return new double[] {0}; //STUB
	}
}
