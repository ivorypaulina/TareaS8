import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Persona> listaPersonas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        do {

            try {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Registrar persona");
                System.out.println("2. Mostrar registros");
                System.out.println("3. Actualizar registro");
                System.out.println("4. Eliminar registro");
                System.out.println("5. Buscar por cedula");
                System.out.println("6. Contar estudiantes y docentes");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        registrarPersona();
                        break;

                    case 2:
                        mostrarRegistros();
                        break;

                    case 3:
                        actualizarRegistro();
                        break;

                    case 4:
                        eliminarRegistro();
                        break;

                    case 5:
                        buscarPorCedula();
                        break;

                    case 6:
                        contarPersonas();
                        break;

                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Error: opcion invalida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar solo numeros.");
            }

        } while (opcion != 7);
    }

    // REGISTRAR
    public static void registrarPersona() {

        try {

            System.out.println("\n1. Estudiante");
            System.out.println("2. Docente");
            System.out.print("Seleccione tipo: ");

            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Ingrese cedula: ");
            String cedula = sc.nextLine();

            if (cedula.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            // Validar cedula repetida
            for (Persona p : listaPersonas) {
                if (p.getCedula().equals(cedula)) {
                    System.out.println("Ya existe una persona con esa cedula.");
                    return;
                }
            }

            System.out.print("Ingrese nombre completo: ");
            String nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            System.out.print("Ingrese edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            if (tipo == 1) {

                System.out.print("Ingrese carrera: ");
                String carrera = sc.nextLine();

                if (carrera.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                Estudiante estudiante = new Estudiante(
                        cedula,
                        nombre,
                        edad,
                        carrera
                );

                listaPersonas.add(estudiante);

            } else if (tipo == 2) {

                System.out.print("Ingrese asignatura: ");
                String asignatura = sc.nextLine();

                if (asignatura.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                Docente docente = new Docente(
                        cedula,
                        nombre,
                        edad,
                        asignatura
                );

                listaPersonas.add(docente);

            } else {
                System.out.println("Tipo invalido.");
                return;
            }

            System.out.println("Registro agregado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }
    }

    // MOSTRAR
    public static void mostrarRegistros() {

        if (listaPersonas.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        for (int i = 0; i < listaPersonas.size(); i++) {

            System.out.println("\nPosicion: " + i);

            listaPersonas.get(i).mostrarDatos();
        }
    }

    // ACTUALIZAR
    public static void actualizarRegistro() {

        try {

            mostrarRegistros();

            System.out.print("\nIngrese posicion a actualizar: ");
            int posicion = Integer.parseInt(sc.nextLine());

            if (posicion < 0 || posicion >= listaPersonas.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            Persona persona = listaPersonas.get(posicion);

            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();

            if (nuevoNombre.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            System.out.print("Nueva edad: ");
            int nuevaEdad = Integer.parseInt(sc.nextLine());

            persona.setNombreCompleto(nuevoNombre);
            persona.setEdad(nuevaEdad);

            System.out.println("Registro actualizado.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }
    }

    // ELIMINAR
    public static void eliminarRegistro() {

        try {

            mostrarRegistros();

            System.out.print("\nIngrese posicion a eliminar: ");
            int posicion = Integer.parseInt(sc.nextLine());

            if (posicion < 0 || posicion >= listaPersonas.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            System.out.print("¿Seguro que desea eliminar? (s/n): ");
            String confirmacion = sc.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {

                listaPersonas.remove(posicion);

                System.out.println("Registro eliminado.");

            } else {
                System.out.println("Operacion cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }
    }

    // BUSCAR
    public static void buscarPorCedula() {

        System.out.print("Ingrese cedula a buscar: ");
        String cedula = sc.nextLine();

        boolean encontrado = false;

        for (Persona p : listaPersonas) {

            if (p.getCedula().equals(cedula)) {

                p.mostrarDatos();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Persona no encontrada.");
        }
    }

    // CONTAR
    public static void contarPersonas() {

        int estudiantes = 0;
        int docentes = 0;

        for (Persona p : listaPersonas) {

            if (p instanceof Estudiante) {
                estudiantes++;
            }

            if (p instanceof Docente) {
                docentes++;
            }
        }

        System.out.println("Total estudiantes: " + estudiantes);
        System.out.println("Total docentes: " + docentes);
    }
}