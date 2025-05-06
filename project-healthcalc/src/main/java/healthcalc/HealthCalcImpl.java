package healthcalc;

public class HealthCalcImpl implements HealthCalc {
	
	// Aplicamos el patrón Singleton
    private static HealthCalcImpl instancia;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstance() {
        if (instancia == null) {
            instancia = new HealthCalcImpl();
        }
        return instancia;
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        // Validar altura
        if (height <= 100 || height >= 250) {
            throw new IllegalArgumentException("La altura debe estar entre 100 cm y 250 cm.");
        }

        // Validar genero
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Genero no valido. Use 'M' para masculino o 'F' para femenino.");
        }

        // Calcular peso ideal segun la formula de Lorentz
        if (gender == 'M') {
            return (height - 100) - ((height - 150) / 4.0f);
        } else {
            return (height - 100) - ((height - 150) / 2.5f);
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        // Validar peso
        if (weight <= 3 || weight >= 300) {
            throw new IllegalArgumentException("El peso debe estar entre 3 kg y 300 kg.");
        }

        // Validar altura
        if (height <= 100 || height >= 250) {
            throw new IllegalArgumentException("La altura debe estar entre 100 cm y 250 cm.");
        }

        // Validar edad
        if (age <= 1 || age >= 120) {
            throw new IllegalArgumentException("La edad debe estar entre 1 y 120 años.");
        }

        // Validar genero
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Genero no valido. Use 'M' para masculino o 'F' para femenino.");
        }

        // Calcular TMB segun la formula de Harris-Benedict
        if (gender == 'M') {
            return 88.36f + (13.4f * weight) + (4.8f * height) - (5.7f * age);
        } else {
            return 447.6f + (9.2f * weight) + (3.1f * height) - (4.3f * age);
        }
    }
}