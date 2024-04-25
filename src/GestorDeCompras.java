import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GestorDeCompras {
    private TarjetaDeCredito tarjeta;

    public void iniciar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el limite de la tarjeta: ");
        int limite = scanner.nextInt();
        tarjeta = new TarjetaDeCredito(limite);

        while (true) {
            System.out.print("Ingrese el nombre del producto (o 'salir' para finalizar): ");
            String producto = scanner.next();
            if (producto.equals("salir")) {
                break;
            }
            System.out.print("Ingrese el precio del producto: ");
            int precio = scanner.nextInt();

            if (!tarjeta.hacerCompra(producto, precio)) {
                System.out.println("Error: La compra excede el saldo disponible");
            }
        }
        mostrarResumenDecompras();
    }

    private void mostrarResumenDecompras() {
        List<Compra> compras = tarjeta.getCompras();
        Collections.sort(compras);
        System.out.println("***************************");
        System.out.println("COMPRAS REALIZADAS");
        for (Compra compra : compras) {
            System.out.println(compra.getProducto() + ": " + compra.getPrecio());
        }
        System.out.println("");
        System.out.println("Saldo restante: " + tarjeta.getSaldoRestante());
        System.out.println("***************************");
        System.out.println("");
    }

    public static void main(String[] args) {
        new GestorDeCompras().iniciar();
    }
}


