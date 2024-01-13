import java.util.InputMismatchException;
import java.util.Scanner;

class Radio {
    private boolean estaEncendido;
    private String banda; // AM o FM
    private double frecuencia;
    private String[] emisorasGuardadas;
    private Scanner scanner; // Declare a Scanner field

    public Radio(Scanner scanner) {
        estaEncendido = false;
        banda = "AM";
        frecuencia = 530.0;
        emisorasGuardadas = new String[12];
        this.scanner = scanner; // Initialize the Scanner field
    }

    public void encender() {
        estaEncendido = true;
        System.out.println("La radio está encendida");
    }

    public void apagar() {
        estaEncendido = false;
        System.out.println("La radio está apagada");
    }

    public void cambiarBanda() {
        if (estaEncendido) {
            banda = (banda.equals("AM")) ? "FM" : "AM";
            System.out.println("Cambiado a banda " + banda);
        } else {
            System.out.println("Por favor, enciende la radio primero");
        }
    }

    public void sintonizarEmisora() {
        if (estaEncendido) {
            if (banda.equals("AM")) {
                frecuencia += 10;
                if (frecuencia > 1610) {
                    frecuencia = 530;
                }
            } else {
                frecuencia += 0.2;
                if (frecuencia > 107.9) {
                    frecuencia = 87.9;
                }
            }
            System.out.println("Sintonizado en " + banda + " " + frecuencia + " MHz");
        } else {
            System.out.println("Por favor, enciende la radio primero");
        }
    }

    public void guardarEmisora(int boton) {
        if (estaEncendido) {
            emisorasGuardadas[boton - 1] = String.format("%s %.1f MHz", banda, frecuencia);
            System.out.println("Guardada la emisora actual en el botón " + boton);
        } else {
            System.out.println("Por favor, enciende la radio primero");
        }
    }

    public void seleccionarEmisora(int boton) {
        if (estaEncendido) {
            String emisoraGuardada = emisorasGuardadas[boton - 1];
            if (emisoraGuardada != null) {
                System.out.println("Seleccionada la emisora del botón " + boton + ": " + emisoraGuardada);

                // Mostrar menú de emisoras guardadas y sus respectivos botones
                System.out.println("Emisoras guardadas:");
                for (int i = 0; i < emisorasGuardadas.length; i++) {
                    if (emisorasGuardadas[i] != null) {
                        System.out.println((i + 1) + ". " + emisorasGuardadas[i] + " (Botón " + (i + 1) + ")");
                    }
                }

                // Permitir al usuario seleccionar otro botón
                System.out.print("Seleccione un botón para más detalles: ");
                int nuevoBoton;
                try {
                    nuevoBoton = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Debe ingresar un número.");
                    scanner.nextLine(); // Clear the invalid input
                    return;
                }

                if (nuevoBoton >= 1 && nuevoBoton <= 12 && emisorasGuardadas[nuevoBoton - 1] != null) {
                    System.out.println("Emisora en el botón " + nuevoBoton + ": " + emisorasGuardadas[nuevoBoton - 1]);
                } else {
                    System.out.println("Botón inválido o no hay emisora guardada en ese botón.");
                }
            } else {
                System.out.println("No hay emisora guardada en el botón " + boton);
            }
        } else {
            System.out.println("Por favor, enciende la radio primero");
        }
    }
}