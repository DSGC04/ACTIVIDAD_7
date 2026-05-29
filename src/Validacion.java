import java.util.Scanner;

public class Validacion {

    private Scanner input;

    public Validacion(Scanner input) {

        this.input = input;
    }

    public String leerCadena(String mensaje) {

        System.out.print(mensaje);

        return input.nextLine();
    }

    public int leerEntero(String mensaje) {

        System.out.print(mensaje);

        return Integer.parseInt(
                input.nextLine()
        );
    }

    public double leerDouble(String mensaje) {

        System.out.print(mensaje);

        return Double.parseDouble(
                input.nextLine()
        );
    }
}

