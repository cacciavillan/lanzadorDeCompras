class Compra implements Comparable<Compra> {

    private String producto;
    private int precio;

    public Compra(String producto, int precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public String getProducto(){
        return producto;
    }

    public int getPrecio(){
        return precio;
    }

    @Override
    public int compareTo(Compra otra) {
        return this.producto.compareTo(otra.producto);
    }
}