package ar.org.icaro.automatizacion.clase08;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PruebaSuma {

    @BeforeClass
    public void ejecutarAntesDeCorrerLaClase() {
        System.out.println("Me ejecuté antes de correr los casos de prueba de esta clase");
    }

    @BeforeMethod
    public void ejecutarPrevioACadaMetodo() {
        System.out.println("Me ejecuté antes de cada método");
    }

    @Test
    public void validaSumaCero() {

        Matematica m = new Matematica();

        int resultado = m.suma(1, 0);
        int esperado = 1;

        System.out.println("Primer metodo");

        Assert.assertEquals(resultado, esperado, "La suma no fue la esperada");

    }

    @Test
    public void v() {

        Matematica m = new Matematica();

        int resultado = m.suma(1, 0);
        int esperado = 1;

        System.out.println("Segundo metodo");

        Assert.assertEquals(resultado, esperado, "La suma no fue la esperada");

    }

}
