package clase05.excepciones.calculadora.metodoArrojaError;

import clase05.excepciones.calculadora.metodoArrojaError.CalculadoraSencilla;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Calculadora Sencilla");
        int numero1;
        int numero2;
        char operacion;

        try {
            System.out.print("Ingresa el primer número: ");
            numero1 = input.nextInt();

            System.out.print("Ingresa el segundo número: ");
            numero2 = input.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException("Numeros ingresados invalidos");
        }

        System.out.print("Selecciona una operación (+, -, *, /): ");
        operacion = input.next().charAt(0);

        CalculadoraSencilla calculadora = new CalculadoraSencilla();

        double resultado;

        try {
            resultado = calculadora.realizarOperacion(numero1, numero2, operacion);
        } catch(ArithmeticException e) {
            throw new RuntimeException("Se produjo un error al hacer el calculo");
        }

        System.out.println("El resultado es: " + resultado);

    }

}