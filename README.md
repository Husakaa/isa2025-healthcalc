
## Casos de Prueba para HealthCalc

 Los siguientes casos de prueba cubren tres posibles situaciones: situaciones normales, valores fuera de rango y entradas invalidas.

---

### **1. Calculo del Peso Ideal** (`idealBodyWeight(int height, char gender): float`)

**Definicion:** La funcion calcula correctamente el peso ideal segun la altura y el genero.

**Formula utilizada:** *Lorentz*  
**Hombres:** Peso ideal = (altura - 100) - ((altura - 150) / 4)  
**Mujeres:** Peso ideal = (altura - 100) - ((altura - 150) / 2.5)  

**Restriccion:** Solo valido para alturas mayores a 100 cm y menores a 250 cm. Fuera del rango, se muestra una advertencia.

#### **Casos de Prueba Normales**
**Caso 1:** Altura = **170 cm**, Genero = **masculino** -> Se espera un peso ideal en el rango estandar.  
**Caso 2:** Altura = **160 cm**, Genero = **femenino** -> Se espera un peso ideal en el rango estandar.  

#### **Casos de Prueba Fuera de Rango**
**Caso 3:** Altura minima = **100 cm** -> Se espera un error con mensaje de advertencia.  
**Caso 4:** Altura maxima = **250 cm** -> Se espera un error con mensaje de advertencia.  

#### **Casos de Prueba Invalidos**
**Caso 5:** Se introduce una altura **negativa** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 6:** Se introduce un genero desconocido o erroneo (ej. **X**) -> Se espera un error o uso de un valor por defecto.  

---

### **2. Calculo de la Tasa Metabolica Basal (TMB)** (`basalMetabolicRate(float weight, int height, int age, char gender): float`)

**Definicion** La funcion calcula correctamente la tasa metabolica basal segun el peso, altura, edad y genero.

**Formula utilizada:** *Harris-Benedict*  
**Hombres:** 88.36 + (13.4 x peso) + (4.8 x altura) - (5.7 x edad)  
**Mujeres:** 447.6 + (9.2 x peso) + (3.1 x altura) - (4.3 x edad)  

**Restriccion:** Solo valido para alturas mayores a 100 cm y menores a 250 cm, pesos mayores a 3 kg y menores a 300 kg, edades mayores a 1 año y menores a 120 años.

#### **Casos de Prueba Normales**
**Caso 1:** Peso = **70 kg**, Altura = **175 cm**, Edad = **30 años**, Genero = **masculino** -> Se espera un calculo correcto estandar.  
**Caso 2:** Peso = **55 kg**, Altura = **160 cm**, Edad = **25 años**, Genero = **femenino** -> Se espera un calculo correcto estandar.  

#### **Casos de Prueba Fuera de Rango**
**Caso 3:** Altura minima = **100 cm** -> Se espera un mensaje de advertencia.  
**Caso 4:** Altura maxima = **250 cm** -> Se espera un mensaje de advertencia.
**Caso 5:** Peso minimo = **3 kg** -> Se espera un error con mensaje de advertencia.  
**Caso 6:** Peso maximo = **300 kg** -> Se espera un error con mensaje de advertencia.  
**Caso 7:** Edad minima = **1 año** -> Se espera un error con mensaje de advertencia.  
**Caso 8:** Edad maxima = **120 años** -> Se espera un error con mensaje de advertencia. 

#### **Casos de Prueba Invalidos**
**Caso 9:** Se introduce un peso **negativo** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 10:** Se introduce una altura **negativa** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 11:** Se introuce una edad **negativa** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 12:** Se introduce un genero desconocido o erroneo (ej. **X**) -> Se espera un error o uso de un valor por defecto.  

---

## Resultados Maven
A continuacion se muestra una captura de pantalla de informe surefire generado al ejecutar los tests con Maven:
![Captura cmd](project-healthcalc\target\surefire-reports\captura_tests_xml.png)