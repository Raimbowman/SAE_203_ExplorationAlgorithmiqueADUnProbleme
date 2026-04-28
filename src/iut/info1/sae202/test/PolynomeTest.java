package iut.info1.sae202.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import iut.info1.sae202.Polynome;

class PolynomeTest {

	@Test
	void testPolynomeCoefficientsValides() {
		assertDoesNotThrow(() -> new Polynome(new double[] {-2, 4, 3}));
		assertDoesNotThrow(() -> new Polynome(new double[] {5}));        //constante
		assertDoesNotThrow(() -> new Polynome(new double[] {0, 0, 1}));  //x^2
		assertDoesNotThrow(() -> new Polynome(new double[] {12.5, -7.345, 65.8}));
		assertDoesNotThrow(() -> new Polynome(new double[] {0})); //cas particulier polynome nul
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

}
