import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class PruebasCodigo {
    
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Sumar", "Restar", "Multiplicar", "Raíz Cuadrada", "Cuadrado", "Consultar Historial", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una operación", "Calculadora",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 6) {
                break; // Salir del bucle y terminar el programa
            }

            switch (choice) {
                case 0: // Sumar
                    realizarOperacion("sumar");
                    break;
                case 1: // Restar
                    realizarOperacion("restar");
                    break;
                case 2: // Multiplicar
                    realizarOperacion("multiplicar");
                    break;
                case 3: // Raíz Cuadrada
                    realizarOperacion("raizCuadrada");
                    break;
                case 4: // Cuadrado
                    realizarOperacion("cuadrado");
                    break;
                case 5: // Consultar Historial
                    consultarHistorial();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private static void realizarOperacion(String operacion) {
        double resultado = 0;
        double numero1 = obtenerNumero("Ingrese el primer número");
        double numero2 = 0;

        if (!operacion.equals("raizCuadrada") && !operacion.equals("cuadrado")) {
            numero2 = obtenerNumero("Ingrese el segundo número");
        }

        switch (operacion) {
            case "sumar":
                resultado = numero1 + numero2;
                break;
            case "restar":
                resultado = numero1 - numero2;
                break;
            case "multiplicar":
                resultado = numero1 * numero2;
                break;
            case "raizCuadrada":
                resultado = Math.sqrt(numero1);
                break;
            case "cuadrado":
                resultado = Math.pow(numero1, 2);
                break;
        }

        String mensajeResultado = "Resultado: " + resultado;
        JOptionPane.showMessageDialog(null, mensajeResultado);
        guardarEnHistorial(operacion, numero1, numero2, resultado);
    }

    private static double obtenerNumero(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        return Double.parseDouble(input);
    }

    private static void guardarEnHistorial(String operacion, double numero1, double numero2, double resultado) {
        try (FileWriter fw = new FileWriter("historial.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            if (operacion.equals("raizCuadrada")) {
                out.printf("Raíz Cuadrada de %.2f = %.2f%n", numero1, resultado);
            } else if (operacion.equals("cuadrado")) {
                out.printf("Cuadrado de %.2f = %.2f%n", numero1, resultado);
            } else {
                out.printf("%s de %.2f y %.2f = %.2f%n", operacion.substring(0, 1).toUpperCase() + operacion.substring(1), numero1, numero2, resultado);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el historial");
        }
    }

    private static void consultarHistorial() {
        StringBuilder historial = new StringBuilder();

        try (Scanner scanner = new Scanner(new File("historial.txt"))) {
            while (scanner.hasNextLine()) {
                historial.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            historial.append("No se encontró el archivo de historial.");
        }

        JOptionPane.showMessageDialog(null, historial.toString(), "Historial", JOptionPane.INFORMATION_MESSAGE);
    }
}