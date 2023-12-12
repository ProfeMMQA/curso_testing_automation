package clase03;

import java.util.*;

public class Colecciones {
    public static void main(String[] args) {

        int[] arreglito;
        arreglito = new int[]{1, 2, 3, 4, 5};
        //System.out.println(arreglito[0]);
        arreglito[0] = arreglito[0] + 20;
        //Aca imprimo la posicion 0 del arreglo
        System.out.println(arreglito[0]);

        ArrayList<Integer> listaDeEnteros;
        listaDeEnteros = new ArrayList<>();
        listaDeEnteros.add(1);
        listaDeEnteros.add(2);
        listaDeEnteros.add(3);
        System.out.println(listaDeEnteros.get(0));
        listaDeEnteros.remove(0);
        System.out.println(listaDeEnteros.get(0));

        int num = 10;
        num = num * 3;

        int cantIngresos = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una clave: ");
        String clave = sc.nextLine();
        int valor;
        HashMap<String, Integer> datosIngresados = new HashMap<>();
        while(!clave.equals("Parar")) {
            System.out.println("Ingresa un valor para asociar a la clave: ");
            valor = sc.nextInt();
            datosIngresados.put(clave, valor);
            System.out.println("Ingresa una clave: ");
            clave = sc.nextLine();
        }

        //Por cada clave definida en el map
        for (String k:datosIngresados.keySet()){
            System.out.println(datosIngresados.get(k));
        }

        sc.close();
    }
}
