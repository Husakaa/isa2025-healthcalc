# Ingeniería del Software Avanzada  

## Práctica 2: Calculadora Biomédica  

### Introducción  
En esta práctica se ha desarrollado una calculadora biomédica con diversas funciones diseñadas para evaluar algunos parámetros clave relacionados con la salud de una persona. El objetivo principal es proporcionar una herramienta que permita a los usuarios calcular métricas biomédicas de forma rápida, accesible y segura. 

Se ha diseñado un diagrama de casos de uso, representando las funcionalidades principales de la aplicación y los actores involucrados.  

### Diagrama de Casos de Uso  
A continuación se muestra el diagrama de casos de uso de la calculadora biomédica:  

![Diagrama de Casos de Uso](doc/useCaseDiagram.jpg)  

### Casos de uso implementados  
La aplicación permite calcular las siguientes métricas:  

- **Calcular Peso Ideal:** Estima el peso recomendado tomando la altura, edad y género del usuario.  
- **Calcular Tasa Metabólica Basal (TMB):** Determina el gasto energético del metabolismo en reposo.  
- **Calcular Índice de Masa Corporal (IMC):** Relaciona el peso y la altura para clasificar el estado de salud según valores de referencia. 
- **Calcular Porcentaje de Grasa Corporal:** Estima la cantidad de grasa corporal basándose en medidas antropométricas.  

---

## Especificación del Caso de Uso: **Calcular Índice de Masa Corporal (IMC)**  

### **1. Nombre**  
**Calcular Índice de Masa Corporal (IMC)**  

### **2. Actor Principal**  
Usuario (persona que desea conocer su IMC).  

### **3. Ámbito**  
Aplicación de la calculadora biomédica.  

### **4. Nivel**  
Caso de uso de usuario (interacción directa con la aplicación).  

### **5. Stakeholders e Intereses**  
- **Usuario**: Quiere conocer su estado de salud en función del IMC.  
- **Profesionales de la salud**: Pueden utilizar la aplicación como referencia rápida para evaluar pacientes.  
- **Desarrolladores**: Buscan garantizar que el cálculo se realice correctamente y la interfaz sea clara.  

### **6. Precondiciones**  
- El usuario debe ingresar su peso en kilogramos (kg) y su altura en metros (m).  
- Los valores ingresados deben ser positivos y realistas (ejemplo: altura entre 0.5m y 2.5m).  

### **7. Garantías Mínimas**  
- La aplicación no debe bloquearse ni generar errores si el usuario ingresa valores fuera del rango esperado.  
- Si los datos ingresados son inválidos, se debe mostrar un mensaje de error adecuado.  

### **8. Garantía de Éxito**  
- Se mostrará el resultado correctamente calculado usando la fórmula:  

  \[
  IMC = \frac{\text{masa (kg)}}{\text{altura}^2 (\text{m}^2)}
  \]

- Se proporcionará una clasificación basada en el IMC:  
  - **Menos de 18.5**: Bajo peso  
  - **18.5 - 24.9**: Peso normal  
  - **25 - 29.9**: Pre-obesidad o Sobrepeso  
  - **30 o más**: Obesidad

[Fuente:](https://www.enterat.com/salud/imc-indice-masa-corporal.php)

### **9. Escenario Principal**  
1. El usuario abre la aplicación.  
2. Selecciona la opción "Calcular Índice de Masa Corporal (IMC)".  
3. Ingresa su peso en kilogramos (kg).  
4. Ingresa su altura en metros (m).  
5. La aplicación valida los datos ingresados.  
6. Si los datos son correctos, se calcula el IMC usando la fórmula establecida.  
7. Se muestra el resultado junto con la clasificación correspondiente.  

### **10. Escenarios Alternativos**  
- **10a. El usuario ingresa un valor negativo o no numérico:** Se muestra un mensaje de error indicando que los valores deben ser positivos y numéricos.  
- **10b. El usuario deja un campo vacío:** La aplicación notifica que todos los campos son obligatorios.  

### **11. Extensiones**  
- **Opción de ingresar altura en centímetros:** El sistema permite que el usuario ingrese su altura en cm y la convierte automáticamente a metros.  
- **Gráfica con resultados históricos:** Se muestra una gráfica con los valores de IMC registrados en otras ocasiones.  

---

  

