package clase03;

import java.util.ArrayList;
import java.util.List;

public class IfElseSwitch<E> {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        /*
        if (a > b) {
            System.out.println("a es mayor a b");
        } else if (a == b){
            System.out.println("a igual a b");
        } else {
            System.out.println("a es menor a b");
        }
         */

        switch (a) {
            case 1:
                System.out.println("a es 1");
                break;
            case 2:
                System.out.println("a es 2");
                break;
            default:
                System.out.println("a no es ni 1 ni 2");
        }

        ArrayList<Integer> l = new ArrayList<Integer>();



        if (a == 1) {
            System.out.println("a es 1");
        } else if (a == 2) {
            System.out.println("a es 2");
        } else {
            System.out.println("a no es ni 1 ni 2");
        }

    }

    public void dsa() {
        ArrayList<Integer> al = new ArrayList<>();
        asd(al);
    }

    public void asd(List<Integer> l) {
        l.add(1);
        l.add(2);
        l.add(3);
    }
}
