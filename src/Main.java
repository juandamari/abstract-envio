import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner envio = new Scanner(System.in);
        ArrayList<envio> listaEnviados = new ArrayList<>();
        int opcion;

        do {
            System.out.println("=== SISTEMA DE GESTIÓN DE ENVÍOS ===");
            System.out.println("1. Registrar envío terrestre");
            System.out.println("2. Registrar envío aéreo");
            System.out.println("3. Mostrar todos los envíos");
            System.out.println("4. Buscar envío por código");
            System.out.println("5. Mostrar el envío más costoso");
            System.out.println("6. Calcular total recaudado");
            System.out.println("7. Mostrar cantidad de envíos por tipo");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = envio.nextInt();
            envio.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("--- Registrar Envío Terrestre ---");
                    System.out.print("Ingrese código: ");
                    String codigo = envio.nextLine();
                    System.out.print("Ingrese destino: ");
                    String cuidad = envio.nextLine();
                    System.out.print("Ingrese peso (kg): ");
                    int peso = envio.nextInt();
                    System.out.print("Ingrese distancia (km): ");
                    int distancia = envio.nextInt();

                    envioTerrestre envioT = new envioTerrestre(codigo, cuidad, peso, distancia);
                    listaEnviados.add(envioT);
                    System.out.println("¡Envío terrestre registrado con éxito!");
                    break;

                case 2:
                    System.out.println("--- Registrar Envío Aéreo ---");
                    System.out.print("Ingrese código: ");
                    String codigo1 = envio.nextLine();
                    System.out.print("Ingrese destino: ");
                    String cuidad1 = envio.nextLine();
                    System.out.print("Ingrese peso (kg): ");
                    int peso1 = envio.nextInt();
                    System.out.print("Ingrese distancia (km): ");
                    int distancia1 = envio.nextInt();
                    envioAereo envioA = new envioAereo(codigo1, cuidad1, peso1, distancia1);
                    listaEnviados.add(envioA);
                    System.out.println("¡Envío aéreo registrado con éxito!");
                    break;

                case 3:
                    System.out.println("--- Lista de Todos los Envíos ---");
                    if (listaEnviados.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        for (envio e : listaEnviados) {
                            e.mostrarDatos();
                        }
                    }
                    break;

                case 4:
                    System.out.println("--- Buscar Envío por Código ---");
                    System.out.print("Ingrese el código a buscar: ");
                    String codigo2 = envio.nextLine();
                    boolean encontrado = false;

                    for (envio e : listaEnviados) {
                        if (e.codigo.equalsIgnoreCase(codigo2 )) {
                            e.mostrarDatos();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún envío con el código: " + codigo2);
                    }
                    break;

                case 5:
                    System.out.println("--- Envío Más Costoso ---");
                    if (listaEnviados.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        envio masCostoso = listaEnviados.getFirst();
                        for (envio e : listaEnviados) {
                            if (e.calcularCosto() > masCostoso.calcularCosto()) {
                                masCostoso = e;
                            }
                        }
                        System.out.println("El envío con mayor costo es:");
                        masCostoso.mostrarDatos();
                    }
                    break;

                case 6:
                    System.out.println("--- Total Recaudado ---");
                    double totalRecaudado = 0;
                    for (envio e : listaEnviados) {
                        totalRecaudado += e.calcularCosto();
                    }
                    System.out.println("El total recaudado por todos los envíos es: $" + totalRecaudado);
                    break;

                case 7:
                    System.out.println("--- Cantidad de Envíos por Tipo ---");
                    int contadorTerrestre = 0;
                    int contadorAereo = 0;

                    for (envio e : listaEnviados) {
                        if (e instanceof envioTerrestre) {
                            contadorTerrestre++;
                        } else if (e instanceof envioAereo) {
                            contadorAereo++;
                        }
                    }
                    System.out.println("Cantidad de envíos terrestres: " + contadorTerrestre);
                    System.out.println("Cantidad de envíos aéreos: " + contadorAereo);
                    System.out.println("Total de envíos: " + listaEnviados.size());
                    break;

                case 8:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 8);

        envio.close();
    }
}