package ar.org.icaro.automatizacion.clase08;

public class Soldado {

    private int puntosDeVida;
    private int puntosDeVidaRestaurados = 10;

    public Soldado() {
        this.puntosDeVida = 100;
    }

    public boolean estaMuerto() {
        return puntosDeVida <= 0;
    }

    public int puntosVidas() {
        return puntosDeVida;
    }

    public void pelear(int danioRecibido) {
        verificarQueNoEsteMuerto();
        this.puntosDeVida = puntosDeVida - danioRecibido/2;
    }

    public void descansar() {
        verificarQueNoEsteMuerto();
        if (puntosDeVida+puntosDeVidaRestaurados > 100) {
            puntosDeVida = 100;
        } else {
            puntosDeVida = puntosDeVida + puntosDeVidaRestaurados;
        }
    }

    private void verificarQueNoEsteMuerto() {
        if (estaMuerto()) {
            throw new RuntimeException("Un soldado muerto no puede realizar acciones");
        }
    }
}
