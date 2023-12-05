package clase03;

import java.util.HashMap;
import java.util.Scanner;

public class EjercicioIntegral2 {

    public static void main(String[] args) {
        //Inicializo un scanner
        Scanner sc = new Scanner(System.in);

        //Recibir un numero mediante consola
        System.out.println("Ingrese un numero: ");
        int num = sc.nextInt();

        //Recibir un numero mediante consola
        System.out.println("Ingrese una palabra: ");
        String palabra = sc.next();

        HashMap<String, Integer> mapPalabraNumero = new HashMap<>();

        //Mientras la palabra sea distinta de "Parar"
        while (!palabra.equals("Parar")) {

            //Definir a la clave palabra el valor del numero
            mapPalabraNumero.put(palabra, num);

            //Recibir un nuevo numero
            System.out.println("Ingrese un nuevo numero: ");
            num = sc.nextInt();

            //Recibir una nueva palabra
            System.out.println("Ingrese una nueva palabra: ");
            palabra = sc.next();
        }

        //Mostrar los valores
        for (String clave:mapPalabraNumero.keySet()) {
            System.out.println("La clave es: " + clave + " y el valor es: "+ mapPalabraNumero.get(clave));
        }


        //Mostrar mensaje segun cantidad de ingresos
        System.out.println("Se ingresaron " + mapPalabraNumero.size() + " numeros");

        if (mapPalabraNumero.size() < 10) {
            System.out.println("Se ingresaron pocos valores");
        } else {
            System.out.println("Se excedio la cantidad de valores");
        }
    }

}
