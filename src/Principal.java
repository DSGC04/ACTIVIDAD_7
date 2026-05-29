import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner input =
                new Scanner(System.in);

        Validacion validacion =
                new Validacion(input);

        Visualizacion visual =
                new Visualizacion();

        Gestion_Persistencia gp =
                new Gestion_Persistencia();

        ArrayList<Prenda> prendas =
                new ArrayList<>();

        ArrayList<Lote> lotes =
                new ArrayList<>();

        byte opcion;

        do {

            System.out.println("\nMENU");
            System.out.println("1. Agregar prenda");
            System.out.println("2. Agregar lote");
            System.out.println("3. Mostrar prendas");
            System.out.println("4. Mostrar lotes");
            System.out.println("5. Guardar prendas");
            System.out.println("6. Leer prendas");
            System.out.println("7. Salir");

            System.out.print("Selecciona opcion: ");

            opcion =
                    Byte.parseByte(
                            input.nextLine()
                    );

            switch(opcion) {

                case 1:

                    String modelo =
                            validacion.leerCadena(
                                    "Modelo: "
                            );

                    String tela =
                            validacion.leerCadena(
                                    "Tela: "
                            );

                    double costo =
                            validacion.leerDouble(
                                    "Costo produccion: "
                            );

                    String genero =
                            validacion.leerCadena(
                                    "Genero: "
                            );

                    String temporada =
                            validacion.leerCadena(
                                    "Temporada: "
                            );

                    Prenda prenda =
                            new Prenda(
                                    modelo,
                                    tela,
                                    costo,
                                    genero,
                                    temporada
                            );

                    prendas.add(prenda);

                    System.out.println(
                            "Prenda agregada correctamente"
                    );

                    break;

                case 2:

                    if(prendas.isEmpty()) {

                        System.out.println(
                                "Primero debes agregar prendas"
                        );

                        break;
                    }

                    System.out.println(
                            "\nPRENDAS DISPONIBLES"
                    );

                    for(int i = 0; i < prendas.size(); i++) {

                        System.out.println(
                                (i + 1) + ". " +
                                        prendas.get(i).getModelo()
                        );
                    }

                    int indice =
                            validacion.leerEntero(
                                    "Selecciona prenda: "
                            );

                    if(indice < 1 ||
                            indice > prendas.size()) {

                        System.out.println(
                                "Prenda invalida"
                        );

                        break;
                    }

                    int numeroLote =
                            validacion.leerEntero(
                                    "Numero lote: "
                            );

                    int numeroPiezas =
                            validacion.leerEntero(
                                    "Numero piezas: "
                            );

                    Lote lote =
                            new Lote(
                                    numeroLote,
                                    numeroPiezas,
                                    LocalDate.now(),
                                    prendas.get(indice - 1)
                            );

                    lotes.add(lote);

                    System.out.println(
                            "\nLOTE AGREGADO"
                    );

                    visual.mostrarLote(lote);

                    break;

                case 3:

                    if(prendas.isEmpty()) {

                        System.out.println(
                                "No hay prendas"
                        );

                    } else {

                        System.out.println(
                                "\nLISTA DE PRENDAS"
                        );

                        for(Prenda p : prendas) {

                            visual.mostrarPrenda(p);
                        }
                    }

                    break;

                case 4:

                    if(lotes.isEmpty()) {

                        System.out.println(
                                "No hay lotes"
                        );

                    } else {

                        System.out.println(
                                "\nLISTA DE LOTES"
                        );

                        for(Lote l : lotes) {

                            visual.mostrarLote(l);
                        }
                    }

                    break;

                case 5:

                    try {

                        gp.guardarPrendas(prendas);

                        System.out.println(
                                "Datos guardados correctamente"
                        );

                    } catch (
                            FileNotFoundException e
                    ) {

                        System.out.println(
                                "Error al guardar"
                        );
                    }

                    break;

                case 6:

                    try {

                        prendas =
                                gp.leerPrendas();

                        System.out.println(
                                "\nDATOS RECUPERADOS"
                        );

                        for(Prenda p : prendas) {

                            visual.mostrarPrenda(p);
                        }

                    } catch (
                            FileNotFoundException e
                    ) {

                        System.out.println(
                                "Archivo no encontrado"
                        );
                    }

                    break;

                case 7:

                    System.out.println(
                            "Fin del programa"
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida"
                    );
            }

        } while(opcion != 7);

        input.close();
    }
}