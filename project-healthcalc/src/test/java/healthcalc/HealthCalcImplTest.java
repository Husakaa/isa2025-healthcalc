package healthcalc;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcImplTest {

	private final HealthCalc healthCalc = HealthCalcImpl.getInstance(); // HealthCalcImpl implementa HealthCalc

    // Casos de prueba para Calculo del Peso Ideal - Formula de Lorentz (valido para 100cm <= alturas >= 250 cm)
    @Test
    void testIdealWeight_NormalMale() throws Exception {
        assertEquals(68.75, healthCalc.idealWeight(175, 'M'), 1);
    }

    @Test
    void testIdealWeight_NormalFemale() throws Exception {
        assertEquals(56, healthCalc.idealWeight(160, 'F'), 1);
    }

    @Test
    void testIdealWeight_MinHeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.idealWeight(100, 'F'));
        assertEquals("La altura debe estar entre 100 cm y 250 cm.", exception.getMessage());
    }

    @Test
    void testIdealWeight_MaxHeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        healthCalc.idealWeight(250, 'M'));
    assertEquals("La altura debe estar entre 100 cm y 250 cm.", exception.getMessage());
    }

    @Test
    void testIdealWeight_NegativeHeight() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.idealWeight(-170, 'M'));
    }

    @Test
    void testIdealWeight_InvalidGender() throws Exception {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> 
		healthCalc.idealWeight(170, 'X'));
        assertEquals("Genero no valido. Use 'M' para masculino o 'F' para femenino.", exception.getMessage()); 
    }

    // Casos de prueba para Calculo de la Tasa Metabolica Basal - Formula de Harris-Benedict (valido para 3kg < pesos > 300kg, 100cm < alturas > 250cm, 1 año < edades > 120 años)
    @Test
    void testBasalMetabolicRate_NormalMale() throws Exception {
        assertEquals(1695.36, healthCalc.basalMetabolicRate(70, 175, 30, 'M'), 1);
    }

    @Test
    void testBasalMetabolicRate_NormalFemale() throws Exception {
        assertEquals(1342.1, healthCalc.basalMetabolicRate(55, 160, 25, 'F'), 1);
    }

    @Test
    void testBasalMetabolicRate_MinWeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(3, 120, 5, 'F'));
        assertEquals("El peso debe estar entre 3 kg y 300 kg.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxWeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(300, 175, 30, 'M'));
        assertEquals("El peso debe estar entre 3 kg y 300 kg.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MinHeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(20, 100, 4, 'F'));
        assertEquals("La altura debe estar entre 100 cm y 250 cm.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxHeight() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(90, 250, 50, 'M'));
        assertEquals("La altura debe estar entre 100 cm y 250 cm.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MinAge() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(15, 120, 1, 'M'));
        assertEquals("La edad debe estar entre 1 y 120 años.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_MaxAge() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(60, 170, 120, 'M'));
        assertEquals("La edad debe estar entre 1 y 120 años.", exception.getMessage());
    }

    @Test
    void testBasalMetabolicRate_NegativeWeight() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(-50, 160, 25, 'F'));
    }

    @Test
    void testBasalMetabolicRate_NegativeHeight() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(70, -175, 30, 'M'));
    }

    @Test
    void testBasalMetabolicRate_NegativeAge() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> healthCalc.basalMetabolicRate(40, 130, -5, 'M'));
    }

    @Test
    void testBasalMetabolicRate_InvalidGender() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            healthCalc.basalMetabolicRate(85, 190, 40, 'X'));
        assertEquals("Genero no valido. Use 'M' para masculino o 'F' para femenino.", exception.getMessage());
    }
}
