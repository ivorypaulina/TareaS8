# PRACTICA INTEGRADORA - JAVA POO

## CRUD con Herencia, ArrayList y Validaciones

### Autor
Ivory Cando

---

# Descripcion del proyecto

Este proyecto consiste en una aplicacion de consola desarrollada en Java aplicando Programacion Orientada a Objetos (POO).

El sistema permite registrar, mostrar, actualizar y eliminar estudiantes y docentes utilizando herencia, ArrayList y manejo de excepciones.

---

# Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub

---

# Conceptos aplicados

## Herencia
Las clases Estudiante y Docente heredan de la clase Persona.

## Encapsulamiento
Los atributos fueron declarados como privados o protegidos utilizando getters y setters.

## Polimorfismo
Se sobrescribio el metodo mostrarDatos() usando @Override.

## ArrayList
Se utilizo ArrayList para almacenar dinamicamente los objetos Persona.

## CRUD
El sistema permite:
- Crear registros
- Leer registros
- Actualizar registros
- Eliminar registros

## Manejo de excepciones
Se utilizaron bloques try-catch para evitar errores y evitar que el programa se cierre.

---

# Funcionalidades del sistema

- Registrar estudiantes
- Registrar docentes
- Mostrar registros
- Actualizar registros
- Eliminar registros
- Buscar personas por cedula
- Contar estudiantes y docentes
- Validar campos vacios
- Validar errores numericos

---

# Estructura del proyecto

src/
│
├── Persona.java
├── Estudiante.java
├── Docente.java
└── Main.java

---

# Diagrama UML

              Persona
--------------------------------
- cedula : String
- nombreCompleto : String
- edad : int
--------------------------------
+ mostrarDatos()

          ▲
          │
 ┌────────┴────────┐
 │                 │

Estudiante       Docente
---------------- ----------------
- carrera        - asignatura
---------------- ----------------
+ mostrarDatos() + mostrarDatos()

---

