package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalc healthCalc = new HealthCalcImpl(); // HealthCalcImpl implementa HealthCalc

    // Casos de prueba para Calculo del Peso Ideal - Formula de Lorentz (valido para 100cm <= alturas >= 250 cm)
    @Test
    void testIdealBodyWeight_NormalMale() {
        assertEquals(75, healthCalc.idealBodyWeight(175, 'M'), 0.1);
    }

    @Test
    void testIdealBodyWeight_NormalFemale() {
        assertEquals(60, healthCalc.idealBodyWeight(160, 'F'), 0.1);
    }

    @Test
    void testIdealBodyWeight_MinHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.idealBodyWeight(100, 'F'));
        assertEquals("Altura por debajo del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testIdealBodyWeight_MaxHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        healthCalc.idealBodyWeight(250, 'M'));
    assertEquals("Altura por encima del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testIdealBodyWeight_NegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.idealBodyWeight(-170, 'M'));
    }

    @Test
    void testIdealBodyWeight_InvalidGender() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.idealBodyWeight(170, 'X'));
    }

    // Casos de prueba para Calculo de la Tasa Metabolica Basal - Formula de Harris-Benedict (valido para 3kg < pesos > 300kg, 100cm < alturas > 250cm, 1 año < edades > 120 años)
    @Test
    void testBasalMetabolicRate_NormalMale() {
        assertEquals(1700.0, healthCalc.basalMetabolicRate(70, 175, 30, 'M'), 0.1);
    }

    @Test
    void testBasalMetabolicRate_NormalFemale() {
        assertEquals(1400.0, healthCalc.basalMetabolicRate(55, 160, 25, 'F'), 0.1);
    }

    @Test
    void testBasalMetabolicRate_MinWeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(3, 120, 5, 'F'));
        assertEquals("Peso por debajo del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxWeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(300, 175, 30, 'M'));
        assertEquals("Peso por encima del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MinHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(20, 100, 4, 'F'));
        assertEquals("Altura por debajo del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(90, 250, 50, 'M'));
        assertEquals("Altura por encima del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MinAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(15, 120, 1, 'M'));
        assertEquals("Edad por debajo del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(60, 170, 120, 'M'));
        assertEquals("Edad por encima del rango valido para esta formula", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_NegativeWeight() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(-50, 160, 25, 'F'));
    }

    @Test
    void testBasalMetabolicRate_NegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(70, -175, 30, 'M'));
    }

    @Test
    void testBasalMetabolicRate_NegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(40, 130, -5, 'M'));
    }

    @Test
    void testBasalMetabolicRate_InvalidGender() {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(85, 190, 40, 'X'));
    }
}
