package src;
import java.util.Scanner;
import java.util.Arrays;

public class Parcial2 {

    // Leer arreglo (usa el Scanner que le pasan desde main)
    public static int[] leerArreglo(int n, Scanner sc) {
        int[] a = new int[n];

        System.out.println("\nIngrese " + n + " números:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        return a;
    }

    // Saber si un número es primo
    public static boolean esPrimo(int x) {
        if (x <= 1) return false;

        int divisores = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) divisores++;
        }
        return divisores == 2;
    }

    // Contar primos dentro del arreglo
    public static int contarPrimos(int[] a) {
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            if (esPrimo(a[i])) contador++;
        }
        return contador;
    }

    // Sacar el máximo del arreglo
    public static int maximo(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    // Devolver posiciones donde aparece el máximo
    public static int[] indicesDeMaximo(int[] a) {
        int max = maximo(a);

        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) contador++;
        }

        int[] pos = new int[contador];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                pos[j] = i;
                j++;
            }
        }
        return pos;
    }

    // si es capicua
    public static boolean esCapicua(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] != a[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n;

        // validar N
        do {
            System.out.print("Ingrese N (5 a 50): ");
            n = sc.nextInt();
        } while (n < 5 || n > 50);

        int[] arreglo = leerArreglo(n, sc);

        System.out.println("\nArreglo ingresado: " + Arrays.toString(arreglo));

        System.out.println("Cantidad de primos: " + contarPrimos(arreglo));
        System.out.println("Máximo: " + maximo(arreglo));
        System.out.println("Índices del máximo: " + Arrays.toString(indicesDeMaximo(arreglo)));

        if (esCapicua(arreglo))
            System.out.println("Es capicúa.");
        else
            System.out.println("No es capicúa.");

        sc.close(); 
    }
}
