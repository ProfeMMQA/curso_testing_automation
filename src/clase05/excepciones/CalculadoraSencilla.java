package clase05.excepciones;


public class CalculadoraSencilla {
    public double realizarOperacion(double numero1, double numero2, char operacion) {

        double resultado = 0.0;

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
                resultado = numero1/numero2;
                break;
        }

        return resultado;
    }
}
