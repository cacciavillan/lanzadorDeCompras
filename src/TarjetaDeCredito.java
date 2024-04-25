import java.util.ArrayList;
import java.util.List;

class TarjetaDeCredito {
    private int limite;
    private int saldoRestante;
    private List<Compra> compras = new ArrayList<>();

    public TarjetaDeCredito(int limite) {
        this.limite = limite;
        this.saldoRestante = limite;
    }

    public boolean hacerCompra(String producto, int precio) {
        if (precio > saldoRestante) {
            return false;
        } else {
            compras.add(new Compra(producto, precio));
            saldoRestante -= precio;
            return true;
        }
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public int getSaldoRestante() {
        return saldoRestante;
    }
}