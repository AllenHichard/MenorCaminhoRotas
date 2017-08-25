/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CGoesMundoFantasia.Util;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta classe testa apenas uma aresta, para ver se está ocorrendo o necessário
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class ArestaTest {
    
    Vertice a1;
    Vertice a2;
    Aresta nova;
    
    public ArestaTest() {
        a1 = new Vertice("Konoha", 10, 20);
        a2 = new Vertice("Uefs", 40, 7);
    }
    @Test
    public void testAresta(){
        nova =  new Aresta(a1, a2, 0);
        assertSame(a1, nova.getV1());
        assertSame(a2, nova.getV2());
    }
    
    
    
}
    
    