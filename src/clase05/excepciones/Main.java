package clase05.excepciones;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Calculadora Sencilla");
        double numero1;
        double numero2;
        char operacion;

        try {
            System.out.print("Ingresa el primer número: ");
            numero1 = input.nextDouble();

            System.out.print("Ingresa el segundo número: ");
            numero2 = input.nextDouble();
        } catch (InputMismatchException e) {
            throw new RuntimeException("Numeros ingresados invalidos");
        }

        System.out.print("Selecciona una operación (+, -, *, /): ");
        operacion = input.next().charAt(0);

        CalculadoraSencilla calculadora = new CalculadoraSencilla();

        double resultado = calculadora.realizarOperacion(numero1, numero2, operacion);

        System.out.println("El resultado es: " + resultado);

    }

}