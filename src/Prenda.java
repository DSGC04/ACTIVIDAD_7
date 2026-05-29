public class Prenda {

    private String modelo;
    private String tela;
    private double costoProduccion;
    private String genero;
    private String temporada;

    public Prenda(String modelo, String tela,
                  double costoProduccion,
                  String genero,
                  String temporada) {

        this.modelo = modelo;
        this.tela = tela;
        this.costoProduccion = costoProduccion;
        this.genero = genero;
        this.temporada = temporada;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTela() {
        return tela;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getTemporada() {
        return temporada;
    }

    public double calcularPrecioVenta() {

        return costoProduccion * 1.15;
    }

    @Override
    public String toString() {

        return modelo + "," +
                tela + "," +
                costoProduccion + "," +
                genero + "," +
                temporada;
    }
}

