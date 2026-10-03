public class envioTerrestre extends envio {
    public envioTerrestre() {
    }

    public envioTerrestre(String codigo, String ciudad, int peso, int distancia) {
        super(codigo, ciudad, peso, distancia);
    }

    @Override
    public double calcularCosto() {
        double coste_base = 0;
        coste_base = 8000 + (peso * 1500) + (distancia * 400);
        if(peso>20){
            coste_base = (coste_base * 0.1) + coste_base;
            return  coste_base;
        }
        if(distancia>500){
            coste_base = (coste_base * 0.15) + coste_base;
            return  coste_base;
        }
        return 0;
    }

    @Override
    public double calcularTiempoEntrega() {
        if (distancia <= 200) {
            return 1; // Distancias de hasta 200 km: 1 día
        } else if (distancia <= 500) {
            return 2; // Distancias entre 201 y 500 km: 2 días
        } else if (distancia <= 1000) {
            return 3; // Distancias entre 501 y 1000 km: 3 días
        } else {
            return 5; // Distancias superiores a 1000 km: 5 días
        }

    }

}
