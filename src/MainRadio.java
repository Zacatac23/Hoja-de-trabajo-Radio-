import java.util.Scanner;
public class MainRadio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Radio radio = new Radio(scanner);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Ingrese su elección: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    radio.encender();
                    break;
                case 2:
                    radio.cambiarBanda();
                    break;
                case 3:
                    radio.sintonizarEmisora();
                    break;
                case 4:
                    System.out.print("Ingrese el número de botón (1-12): ");
                    int botonGuardar = scanner.nextInt();
                    radio.guardarEmisora(botonGuardar);
                    break;
                case 5:
                    System.out.print("Ingrese el número de botón (1-12): ");
                    int botonSeleccionar = scanner.nextInt();
                    radio.seleccionarEmisora(botonSeleccionar);
                    break;
                case 6:
                    radio.apagar();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }

        } while (opcion != 6);

        scanner.close(); // close the scanner when done
    }

    private static void mostrarMenu() {
        System.out.println("Menú de la Radio:");
        System.out.println("1. Encender");
        System.out.println("2. Cambiar Banda");
        System.out.println("3. Sintonizar Emisora");
        System.out.println("4. Guardar Emisora en Botón");
        System.out.println("5. Seleccionar Emisora desde Botón");
        System.out.println("6. Apagar");
    }
}