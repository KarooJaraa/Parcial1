import java.util.Scanner;

public class InvZapatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[10];
        int[] cantOriginales = new int[10];
        int[] cantQueda = new int[10];
        int[] paresComprados = new int[10];
        double[] precios = new double[10];

        int totalProductos = 0;
        int opcion;

        do {
            System.out.println("\n**** Menú ****");
            System.out.println("1. Agregar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Duplicar inventario de un producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (totalProductos == 0 && opcion != 1 && opcion != 5) {
                System.out.println("Primero debes agregar un producto.");
                continue;
            }

            switch (opcion) {
                case 1:
                    if (totalProductos < 10) {
                        System.out.print("Nombre del producto: ");
                        nombres[totalProductos] = scanner.nextLine();
                        System.out.print("Cantidad original: ");
                        cantOriginales[totalProductos] = scanner.nextInt();
                        System.out.print("Precio unitario: ");
                        precios[totalProductos] = scanner.nextDouble();
                        cantQueda[totalProductos] = cantOriginales[totalProductos];
                        paresComprados[totalProductos] = 0;
                        totalProductos++;
                        System.out.println("Producto agregado con éxito.");
                    } else {
                        System.out.println("El maximo de productos es 10");
                    }
                    break;

                case 2:
                    System.out.println("Elige el producto que vas vender:");
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.println((i + 1) + ". " + nombres[i]);
                    }
                    int productoElegido = scanner.nextInt() - 1;
                    if (productoElegido >= 0 && productoElegido < totalProductos) {
                        System.out.print("Cuantos pares quieres vender: ");
                        int cantVenta = scanner.nextInt();
                        if (cantVenta <= cantQueda[productoElegido]) {
                            cantQueda[productoElegido] -= cantVenta;
                            paresComprados[productoElegido] += cantVenta;
                            System.out.println("La venta se realizó con éxito.");
                        } else {
                            System.out.println("No hay suficiente stock.");
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Elige el producto para duplicar en el inventario:");
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.println((i + 1) + ". " + nombres[i]);
                    }
                    int indiceDup = scanner.nextInt() - 1;
                    if (indiceDup >= 0 && indiceDup < totalProductos) {
                        if (cantQueda[indiceDup] == 0 && paresComprados[indiceDup] > 0) {
                            cantQueda[indiceDup] = cantOriginales[indiceDup] * 2;
                            System.out.println("El inventario se ha duplicado. Nuevo stock: " + cantQueda[indiceDup]);
                        } else {
                            System.out.println("No es necesario duplicar, el inventario no está agotado.");
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    for (int i = 0; i < totalProductos; i++) {
                        System.out.println("\nProducto: " + nombres[i]);
                        System.out.println("Precio: $" + precios[i]);
                        System.out.println("Cantidad original: " + cantOriginales[i]);
                        System.out.println("Pares vendidas: " + paresComprados[i]);
                        System.out.println("Cantidad disponible: " + cantQueda[i]);
                    }
                    break;

                case 5:
                    System.out.println("Cerrando el programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}