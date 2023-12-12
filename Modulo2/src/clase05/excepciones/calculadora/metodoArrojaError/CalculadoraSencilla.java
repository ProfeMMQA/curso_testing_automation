package clase05.excepciones.calculadora.metodoArrojaError;


public class CalculadoraSencilla {
    public double realizarOperacion(int numero1, int numero2, char operacion) throws ArithmeticException {

        int resultado = 0;

        switch (operacion) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                resultado =numero1 / numero2 ;
        }

        return resultado;
    }
}
