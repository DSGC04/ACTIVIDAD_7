public class Visualizacion {

    public void mostrarPrenda(
            Prenda prenda) {

        System.out.println(
                "\nMODELO: " +
                        prenda.getModelo()
        );

        System.out.println(
                "TELA: " +
                        prenda.getTela()
        );

        System.out.println(
                "COSTO: " +
                        prenda.getCostoProduccion()
        );

        System.out.println(
                "GENERO: " +
                        prenda.getGenero()
        );

        System.out.println(
                "TEMPORADA: " +
                        prenda.getTemporada()
        );

        System.out.println(
                "PRECIO VENTA: " +
                        prenda.calcularPrecioVenta()
        );
    }

    public void mostrarLote(
            Lote lote) {

        System.out.println(
                "\nNUMERO LOTE: " +
                        lote.getNumeroLote()
        );

        System.out.println(
                "PIEZAS: " +
                        lote.getNumeroPiezas()
        );

        System.out.println(
                "FECHA: " +
                        lote.getFechaFabricacion()
        );

        System.out.println(
                "PRENDA: " +
                        lote.getPrenda()
                                .getModelo()
        );

        System.out.println(
                "COSTO PRODUCCION: " +
                        lote.calcularCostoProduccion()
        );

        System.out.println(
                "MONTO RECUPERACION: " +
                        lote.calcularMontoRecuperacion()
        );
    }
}
