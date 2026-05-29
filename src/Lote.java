import java.time.LocalDate;

public class Lote {

    private int numeroLote;
    private int numeroPiezas;
    private LocalDate fechaFabricacion;
    private Prenda prenda;

    public Lote(int numeroLote,
                int numeroPiezas,
                LocalDate fechaFabricacion,
                Prenda prenda) {

        this.numeroLote = numeroLote;
        this.numeroPiezas = numeroPiezas;
        this.fechaFabricacion = fechaFabricacion;
        this.prenda = prenda;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public double calcularCostoProduccion() {

        return numeroPiezas *
                prenda.getCostoProduccion();
    }

    public double calcularMontoRecuperacion() {

        double precioVenta =
                prenda.calcularPrecioVenta();

        double precioLote =
                precioVenta * 1.05;

        return numeroPiezas * precioLote;
    }

    @Override
    public String toString() {

        return numeroLote + "," +
                numeroPiezas + "," +
                fechaFabricacion + "," +
                prenda.getModelo();
    }
}

