/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Util;

import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Esta classe testa o vertice e seus iteradores de lista de vizinhos e lista de 
 * aresta.
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class VerticeTest {

    Vertice vertice;
    Vertice vertice2;
    Vertice vertice3;

    public VerticeTest() {
        vertice = new Vertice("Konoha", 1, 2);
        vertice2 = new Vertice("uefs", 1, 2);
        vertice3 = new Vertice("terra", 1, 2);

    }

    @Test
    public void testVertice() {
        Aresta a1 = new Aresta(vertice, vertice2, 0);
        vertice.inserirAresta(a1);
        Aresta a2 = new Aresta(vertice, vertice3, 0);
        vertice.inserirAresta(a2);
        vertice2.inserirAresta(a1);
        Iterator it = vertice.ListarArestas();
        assertTrue(it.hasNext());
        assertSame(a1, it.next());
        assertTrue(it.hasNext());
        assertSame(a2, it.next());
        assertFalse(it.hasNext());
        it = vertice.ListarVerticeVizinho();
        assertTrue(it.hasNext());
        assertSame(vertice2, it.next());
        assertSame(vertice3, it.next());
        assertFalse(it.hasNext());
    }

}
