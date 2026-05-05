package iut.info1.sae202.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import iut.info1.sae202.Polynome;

class PolynomeTest {

	@Test
	void testPolynomeCoefficientsValides() {
		assertDoesNotThrow(() -> new Polynome(new double[] {-2, 4, 3})); 		   //polynome classique (3 coefficients)
		assertDoesNotThrow(() -> new Polynome(new double[] {5}));        		   //constante
		assertDoesNotThrow(() -> new Polynome(new double[] {-8}));        		   //constante négative
		assertDoesNotThrow(() -> new Polynome(new double[] {0, 0, 1}));  		   //x^2
		assertDoesNotThrow(() -> new Polynome(new double[] {12.5, -7.345, 65.8})); //valeurs décimales
		assertDoesNotThrow(() -> new Polynome(new double[] {0})); 				   //cas particulier polynome nul
		assertDoesNotThrow(() -> new Polynome(new double[] {5, -3, 8, 12, -9, 7, 
				                                            6, 10, 54, -21}));     //polynome classique (10 coefficients)
		assertDoesNotThrow(() -> new Polynome(new double[] {-1, 0, 6.24, -8, 4.3, 
				                                            14.9, -7.21, 13, 0, 
				                                            -2.5, 11, -3.9, 10, 17, 
				                                            1.7}));                //polynome avec valeurs décimales (15 coefficients)
	}
	
	@Test
	void testPolynomeCoefficientsInvalides() {
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome((double[]) null),
					 "Tableau de coefficients NULL accepté");
		assertThrows(IllegalArgumentException.class,
				 () -> new Polynome(new double[] {}),
				 "Tableau de coefficients vide accepté");
		assertThrows(IllegalArgumentException.class,
				 () -> new Polynome(new double[] {-7, 4, 0, 0}),
				 "Coefficients nuls de plus haut degré accepté");
		assertThrows(IllegalArgumentException.class,
				 () -> new Polynome(new double[] {Double.NaN, 4, -7}),
				 "Coefficient NaN accepté");
		assertThrows(IllegalArgumentException.class,
				 () -> new Polynome(new double[] {Double.POSITIVE_INFINITY}),
				 "Coefficient +infini accepté");
		assertThrows(IllegalArgumentException.class,
				 () -> new Polynome(new double[] {Double.NEGATIVE_INFINITY}),
				 "Coefficient -infini accepté");
	}
	
	@Test
	void testPolynomeRacinesValides() {
		assertDoesNotThrow(() -> new Polynome(new double[] {3, -1},
											  new int[] {1, 1}, 2));		//Polynome simple
		assertDoesNotThrow(() -> new Polynome(new double[] {2},
											  new int[] {2}, 1));			//Racine double
		assertDoesNotThrow(() -> new Polynome(new double[] {-1, 0, 5},
											  new int[] {1, 1, 1}, -3));	//Trois racines distinctes
		assertDoesNotThrow(() -> new Polynome(new double[] {1},
											  new int[] {3}, 1));			//Racine triple
		assertDoesNotThrow(() -> new Polynome(new double[] {-2, 4},
											  new int[] {2, 1}, 2));		//Multiplicités mixtes
	}
	
	@Test
	void testPolynomeRacinesInvalides() {
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome(null, new int[] {1}, 2),
					 "Tableau de racines null accepté"); 								//tableau de racines null
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome(new double[] {Double.NaN}, new int[] {1}, 2),
					 "Racine NaN acceptée");											//tableau de racines contenant uniquement un NaN
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome(new double[] {Double.POSITIVE_INFINITY},
							 			new int[] {1}, 2),
					 "Racine +infini acceptée");										//tableau de racines contenant +infini
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {Double.NEGATIVE_INFINITY},
						 			new int[] {1}, 2),
				 	 "Racine +infini acceptée");										//tableau de racines contenant -infini
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome(new double[] {3, Double.NaN},
							 			new int[] {1, 1}, 2),
					 "Racine NaN acceptée");											//tableau de racines contenant un NaN
		assertThrows(IllegalArgumentException.class,
					 () -> new Polynome(new double[] {1}, null, 2),
					 "Ordre de multiplicité null accepté");								//tableau d'ordre de multiplicité null
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1}, new int[] {0}, 2),
				 	 "Ordre de multiplicité unique nul accepté");						//tableau d'ordre de multiplicité contenant uniquement un 0
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1}, new int[] {-1}, 2),
				 	 "Ordre de multiplicité unique négatif accepté");					//tableau d'ordre de multiplicité contenant uniquement une valeur négative
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1, 2}, new int[] {1,0}, 2),
				 	 "Ordre de multiplicité nul accepté");								//tableau d'ordre de multiplicité contenant un 0
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1, 2}, new int[] {1, -2}, 2),
				 	 "Ordre de multiplicité négatif accepté");							//tableau d'ordre de multiplicité contenant une valeur négative
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1, 2, 3}, new int[] {1, 1}, 2),
				 	 "Nombre de racines et d'ordres de multiplicités différent accepté");	//tableaux de racines et d'ordre de multiplicité de longueur différente
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1}, new int[] {1, 1}, 2),
				 	 "Nombre de racines et d'ordres de multiplicités différent accepté");
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1}, new int[] {1}, 0),
				 	 "Coefficient nul du plus haut monôme accepté");					//Coefficient du plus haut monôme nul
		assertThrows(IllegalArgumentException.class,
				 	 () -> new Polynome(new double[] {1}, new int[] {1}, Double.NaN),
				 	 "Coefficient NaN du plus haut monôme accepté");					//Coefficient du plus haut monôme NaN
		assertThrows(IllegalArgumentException.class,
			 	 	 () -> new Polynome(new double[] {1}, new int[] {1}, Double.POSITIVE_INFINITY),
			 	 	 "Coefficient +infini du plus haut monôme accepté");					//Coefficient du plus haut monôme +infini
		assertThrows(IllegalArgumentException.class,
		 	 	 	 () -> new Polynome(new double[] {1}, new int[] {1}, Double.NEGATIVE_INFINITY),
		 	 	 	 "Coefficient -infini du plus haut monôme accepté");					//Coefficient du plus haut monôme -infini
	}
	
	@Test
	void testGetDegre() {
		assertEquals(0, new Polynome(new double[] {5}).getDegre(),
					 "Echec des coefficients sur un degré nul");			//Constructeur coefficients degré 0
		assertEquals(1, new Polynome(new double[] {-2, 3}).getDegre(),
					 "Echec des coefficients sur un degré 1");				//Constructeur coefficients degré 1
		assertEquals(2, new Polynome(new double[] {1, 0, 1}).getDegre(),
				 	 "Echec des coefficients sur un degré 2");					//Constructeur coefficients degré 2
		assertEquals(2, new Polynome(new double[] {5, -3},
									 new int[] {1, 1}, 4).getDegre(),
				 	 "Echec des racines sur un degré 2");						//Constructeur racines degré 2
		assertEquals(3, new Polynome(new double[] {-1, 4},
									 new int[] {2, 1}, 8).getDegre(),
				 	 "Echec des racines sur un degré 3");						//Constructeur racines degré 3
	}
	
	@Test
	void testGetCoefficients() {
		assertArrayEquals(new double[] {5},
						  new Polynome(new double[] {5}).getCoefficients(),
						  "Echec des coefficients sur une constante");
		assertArrayEquals(new double[] {-2, 4, 3},
						  new Polynome(new double[] {-2, 4, 3}).getCoefficients(),
						  "Echec des coefficients sur un polynôme de degré 2");
		assertArrayEquals(new double[] {0, 0, -1},
						  new Polynome(new double[] {0, 0, -1}).getCoefficients(),
						  "Echec des coefficients sur un polynôme de degré 2 sans autre coefficient");
		assertArrayEquals(new double[] {-2, 1},
						  new Polynome(new double[] {2}, new int[] {1}, 1).getCoefficients(),
						  1e-9,
						  "Echec des racines sur un polynôme de degré 1");
		assertArrayEquals(new double[] {4, -4, 1},
						  new Polynome(new double[] {2}, new int[] {2}, 1).getCoefficients(),
						  1e-9,
						  "Echec des racines sur un polynôme de degré 2 avec une racine double");
		assertArrayEquals(new double[] {3, -4, 1},
						  new Polynome(new double[] {1, 3}, new int[] {1, 1}, 1).getCoefficients(),
						  1e-9,
						  "Echec des racines sur un polynôme de degré 2 avec"
						  + "deux racines simples et un coefficient = 1");
		assertArrayEquals(new double[] {6, -8, 2},
						  new Polynome(new double[] {1, 3}, new int[] {1, 1}, 2).getCoefficients(),
						  1e-9,
						  "Echec des racines sur un polynôme de degré 2 avec"
						  + "deux racines simples et un coefficient = 2");
	}
	
	@Test
	void testGetLimites() {
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
					 	  new Polynome(new double[] {2, -1, 3}).getLimites(),
					 	  "Echec des coefficients sur un coef positif de degré pair");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
				 		  new Polynome(new double[] {2, -1, -3}).getLimites(),
				 		  "Echec des coefficients sur un coef négatif de degré pair");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
						  new Polynome(new double[] {2, -1, 3, 6}).getLimites(),
				 		  "Echec des coefficients sur un coef positif de degré impair");
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY},
				 		  new Polynome(new double[] {2, -1, 3, -6}).getLimites(),
				 		  "Echec des coefficients sur un coef négatif de degré impair");
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
				 		  new Polynome(new double[] {2, 3}, new int[] {1, 1}, 2).getLimites(),
				 		  "Echec des racines sur un coef positif de degré pair");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
				 	 	  new Polynome(new double[] {2, 3}, new int[] {1, 1}, -2).getLimites(),
				 		  "Echec des racines sur un coef négatif de degré pair");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
				 		  new Polynome(new double[] {2, 3}, new int[] {1, 2}, 2).getLimites(),
				 		  "Echec des racines sur un coef positif de degré impair");
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY},
				 		  new Polynome(new double[] {2, 3}, new int[] {2, 1}, -2).getLimites(),
				 		  "Echec des racines sur un coef négatif de degré impair");
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
						  new Polynome(new double[] {3}).getLimites(),
						  "Echec des coefficients sur une constante positive");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
						  new Polynome(new double[] {-3}).getLimites(),
						  "Echec des coefficients sur une constante négative");
		assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
						  new Polynome(new double[] {}, new int[] {}, 2).getLimites(),
						  "Echec des racines sur une constante positive");
		assertArrayEquals(new double[] {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
						  new Polynome(new double[] {}, new int[] {}, -3).getLimites(),
						  "Echec des racines sur une constante négative");
	}
	
	@Test
	void testGetRacines() {
		assertArrayEquals(new double[] {2},
				          new Polynome(new double[] {2}, new int[] {5}, 1).getRacines(),
						  "Echec des racines sur une unique constante double");
		assertArrayEquals(new double[] {},
						  new Polynome(new double[] {}, new int[] {}, 1).getRacines(),
						  "Echec");
		
	}
}
