package clase05.excepciones.calculadora.errorManejadoEnMetodo;


public class CalculadoraSencilla {
    public int realizarOperacion(int numero1, int numero2, char operacion) throws ArithmeticException {

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
                try {
                    resultado = numero1 / numero2;
                    break;
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("La division por cero no esta definida");
                }
            default:
                throw new RuntimeException("No ingresaste una operación válida. " +
                        "Las operaciones válidas son +, -, *, /");
        }

        return resultado;
    }
}
