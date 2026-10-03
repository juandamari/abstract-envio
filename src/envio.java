public abstract class envio{
    protected String codigo;
    protected String ciudad;
    protected int peso;
    protected int distancia;

    public envio() {
    }

    public envio(String codigo, String ciudad, int peso, int distancia) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.peso = peso;
        this.distancia = distancia;
    }
    public void mostrarDatos(){
        System.out.println("codigo:" + codigo);
        System.out.println("cuidad:" + ciudad);
        System.out.println("peso:" + peso);
        System.out.println("distancia:" + distancia);
        System.out.println("calcular costo" + calcularCosto());
        System.out.println("calcular envio" + calcularTiempoEntrega());
    }

    public abstract double calcularCosto();
    public abstract double calcularTiempoEntrega();
}
