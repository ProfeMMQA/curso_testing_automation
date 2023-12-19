package ar.org.icaro.automatizacion.clase08;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PruebaSoldado {

    private int puntosIniciales = 100;
    private String puntosDeVidaDifierenErrorMessage = "Los puntos de vida no coinciden";

    @Test
    public void unNuevoSoldadoEstaVivo() {
        Soldado s = new Soldado();

        Assert.assertFalse(s.estaMuerto());
    }

    @Test
    public void laVidaInicialDeUnSoldadoEs100() {
        Soldado s = new Soldado();

        Assert.assertEquals(s.puntosVidas(), puntosIniciales, puntosDeVidaDifierenErrorMessage);
    }

    @Test
    public void siUnNuevoSoldadoPeleaEntoncesSusPuntosDeVidaSeReducenEnLaMitadDelValorRecibido() {
        Soldado s = new Soldado();

        int danioRecibido = 30;
        s.pelear(danioRecibido);

        int danioFinal = danioRecibido/2;

        Assert.assertEquals(s.puntosVidas(), puntosIniciales-danioFinal, puntosDeVidaDifierenErrorMessage);
    }

    @Test
    public void siUnNuevoSoldadoPeleaVariasVecesEntoncesSusPuntosDeVidaSeReducenEnLaMitadDeLaSumaDelDanioRecibido() {
        Soldado s = new Soldado();

        int danioRecibido = 30;
        s.pelear(danioRecibido);
        s.pelear(danioRecibido);

        int cantidadDeAtaquesRecibidos = 2;
        int danioFinal = danioRecibido*cantidadDeAtaquesRecibidos/2;

        Assert.assertEquals(s.puntosVidas(), puntosIniciales-danioFinal, puntosDeVidaDifierenErrorMessage);
    }

    @Test
    public void siUnNuevoSoldadoRecibeUnDanioMayorQueSusPuntosDeVidaEntoncesEstaMuerto() {
        Soldado s = new Soldado();

        int danioRecibido = 200;

        s.pelear(danioRecibido);

        int cantidadDeAtaquesRecibidos = 1;
        int danioFinal = danioRecibido*cantidadDeAtaquesRecibidos/2;

        Assert.assertTrue(s.estaMuerto(), "El soldado debería estar muerto");
        Assert.assertEquals(s.puntosVidas(), puntosIniciales-danioFinal, puntosDeVidaDifierenErrorMessage);
    }

    @Test
    public void siUnNuevoSoldadoRecibeDanioMayorAlQueRecuperaDescansandoYLuegoDescansaEntoncesSusPuntosDeVidaSonElResultadoDeRestarleLoQueSufrePorElAtaqueMasLoQueRestauraDescansando() {
        Soldado s = new Soldado();

        int danioRecibido = 30;

        s.pelear(danioRecibido);

        int cantidadDeAtaquesRecibidos = 1;
        int danioFinal = danioRecibido*cantidadDeAtaquesRecibidos/2;

        int puntosDeVidaRecuperados = 10;

        s.descansar();

        Assert.assertEquals(s.puntosVidas(), puntosIniciales-danioFinal+puntosDeVidaRecuperados, puntosDeVidaDifierenErrorMessage);
    }

    @Test
    public void siUnNuevoSoldadoRecibeDanioMenorAlQueRecuperaDescansandoYLuegoDescansaEntoncesSusPuntosDeVidaSonElResultadoElValorInicial() {
        Soldado s = new Soldado();

        int danioRecibido = 10;

        s.pelear(danioRecibido);
        s.descansar();

        Assert.assertEquals(s.puntosVidas(), puntosIniciales, puntosDeVidaDifierenErrorMessage);
    }

    @Test(expectedExceptions = {Exception.class})
    public void unSoldadoMuertoNoPuedePelear() {
        Soldado s = new Soldado();

        int danioRecibido = 200;

        s.pelear(danioRecibido);
        s.pelear(danioRecibido);
    }

    @Test(expectedExceptions = {Exception.class})
    public void unSoldadoMuertoNoPuedeDescansar() {
        Soldado s = new Soldado();

        int danioRecibido = 200;

        s.pelear(danioRecibido);
        s.descansar();
    }

}
