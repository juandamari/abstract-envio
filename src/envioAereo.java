public class envioAereo extends envio {

    public envioAereo(String codigo, String ciudad, int peso, int distancia) {
        super(codigo, ciudad, peso, distancia);
    }

    public envioAereo() {
        super();
    }

    @Override
    public double calcularCosto() {
        double coste_basee = 0;
        coste_basee = 20000 + (peso * 4000) + (distancia * 600);
        if(peso>10){
            coste_basee = (coste_basee * 0.2) + coste_basee;
            return  coste_basee;
        }
        if(distancia>1000){
            coste_basee = (coste_basee * 0.05) + coste_basee;
            return  coste_basee;
        }
        return 0;
    }

    @Override
    public double calcularTiempoEntrega() {
        if (distancia <= 200) {
            return 1; // Distancias de hasta 200 km: 1 día[cite: 3]
        } else if (distancia <= 500) {
            return 2; // Distancias entre 201 y 500 km: 2 días[cite: 3]
        } else if (distancia <= 1000) {
            return 3; // Distancias entre 501 y 1000 km: 3 días[cite: 3]
        } else {
            return 5; // Distancias superiores a 1000 km: 5 días[cite: 3]
        }
    }
}
