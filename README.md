
## Casos de Prueba para HealthCalc

 Los siguientes casos de prueba cubren tres posibles situaciones: situaciones normales, valores limite y entradas invalidas.

---

### **1. Calculo del Peso Ideal** (`idealBodyWeight(int height, char gender): float`)

**Definicion:**  La funcion calcula correctamente el peso ideal segun la altura y el genero.

#### **Casos de Prueba Normales**
**Caso 1:** Altura = **170 cm**, Genero = **masculino** -> Se espera un peso ideal en el rango estandar.  
**Caso 2:** Altura = **160 cm**, Genero = **femenino** -> Se espera un peso ideal en el rango estandar.  

#### **Casos de Prueba en Limites**
**Caso 3:** Altura minima aceptable = **50 cm** -> Se espera un valor adecuado o un mensaje de advertencia.  
**Caso 4:** Altura maxima aceptable = **250 cm** -> Se espera un valor adecuado o un mensaje de advertencia.  

#### **Casos de Prueba Invalidos**
**Caso 5:** Se introduce una altura **negativa**, **cero** o **fuera de rango** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 6:** Se introduce un genero desconocido o erroneo (ej. **X**) -> Se espera un error o uso de un valor por defecto.  

---

### **2. Calculo de la Tasa Metabolica Basal (TMB)**  
(`basalMetabolicRate(float weight, int height, int age, char gender): float`)

**Definicion** La funcion calcula correctamente la tasa metabolica basal segun el peso, altura, edad y genero.

#### **Casos de Prueba Normales**
**Caso 1:** Peso = **70 kg**, Altura = **175 cm**, Edad = **30 años**, Genero = **masculino** -> Se espera un calculo correcto estandar.  
**Caso 2:** Peso = **55 kg**, Altura = **160 cm**, Edad = **25 años**, Genero = **femenino** -> Se espera un calculo correcto estandar.  

#### **Casos de Prueba en Limites**
**Caso 3:** Peso minimo aceptable = **1 kg** -> Se espera un resultado valido o una advertencia.  
**Caso 4:** Peso maximo aceptable = **300 kg** -> Se espera un resultado valido o una advertencia.  
**Caso 5:** Edad minima valida = **0 años** -> Se espera un resultado valido o una advertencia.  
**Caso 6:** Edad maxima valida = **120 años** -> Se espera un resultado valido o una advertencia.  

#### **Casos de Prueba Inválidos**
**Caso 7:** Se introduce un peso **negativo**, **cero** o **fuera de rango** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 8:** Se introduce una altura **negativa**, **cero** o **fuera de rango** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 9:** Se introuce una edad **negativa** o **fuera de rango** -> Se espera un error o manejo de excepcion con mensaje de error.  
**Caso 10:** Se introduce un genero desconocido o erroneo (ej. **X**) -> Se espera un error o uso de un valor por defecto.  

---
