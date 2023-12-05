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
