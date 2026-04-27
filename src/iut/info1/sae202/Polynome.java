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
		if (coefficients.length == 0) {
			throw new IllegalArgumentException("Tableau de coefficients invalide");
		}
		//TODO vérifier la validité des coefficients
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
