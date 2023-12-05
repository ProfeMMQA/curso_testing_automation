package clase03;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioIntegral1 {
    public static void main(String[] args) {
        //Inicializo un scanner
        Scanner sc = new Scanner(System.in);

        //Recibir un numero mediante consola
        System.out.println("Ingrese un numero: ");
        int num = sc.nextInt();

        ArrayList<Integer> listaDeNumeros = new ArrayList<>();

        //Mientras ese numero sea menor o igual a 500
        while (num <= 500) {
            //Ingresar numero en lista
            listaDeNumeros.add(num);

            //Recibir un nuevo numero
            System.out.println("Ingrese un nuevo numero: ");
            num = sc.nextInt();
        }

        //Mostrar los valores
        int i = 0;
        while (i < listaDeNumeros.size()) {
            System.out.println(listaDeNumeros.get(i));
            i = i + 1;
        }

        //Mostrar mensaje segun cantidad de ingresos
        System.out.println("Se ingresaron " + listaDeNumeros.size() + " numeros");

        if (listaDeNumeros.size() < 10) {
            System.out.println("Se ingresaron pocos numeros");
        } else {
            System.out.println("Se excedio la cantidad de ingresos");
        }
    }
}