import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

    public class Gestion_Persistencia {

        private Formatter output;
        private Scanner input;

        public void guardarPrendas(
                ArrayList<Prenda> prendas)
                throws FileNotFoundException {

            output = new Formatter("prendas.txt");

            for(Prenda prenda : prendas) {

                output.format("%s\n", prenda);
            }

            output.close();
        }

        public ArrayList<Prenda> leerPrendas()
                throws FileNotFoundException {

            ArrayList<Prenda> prendas =
                    new ArrayList<>();

            File archivo =
                    new File("prendas.txt");

            input = new Scanner(archivo);

            while(input.hasNextLine()) {

                String linea =
                        input.nextLine();

                Scanner datos =
                        new Scanner(linea);

                datos.useDelimiter(",");

                String modelo =
                        datos.next();

                String tela =
                        datos.next();

                double costo =
                        datos.nextDouble();

                String genero =
                        datos.next();

                String temporada =
                        datos.next();

                prendas.add(
                        new Prenda(
                                modelo,
                                tela,
                                costo,
                                genero,
                                temporada
                        )
                );

                datos.close();
            }

            input.close();

            return prendas;
        }
    }

