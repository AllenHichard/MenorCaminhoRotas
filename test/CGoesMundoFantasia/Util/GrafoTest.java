/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Util;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta classe testa o menor Caminho e seu tempo apartir das coordenadas do
 * grafo. Foi adicionado um listar Grafo, é como se estivesse mostrando todas as
 * suas ligações no caso as vértices.
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class GrafoTest {

    Vertice a1, a2, a3, a4, a5, a6, a7;
    Aresta b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Grafo g = new Grafo();

    public GrafoTest() {
        a1 = new Vertice("Reino de Eternia", 1, 5);
        a2 = new Vertice("Castelo Ti Bum", 4, 9);
        a3 = new Vertice("Fenda do Biquini", 4, 1);
        a4 = new Vertice("Narnia", 8, 9);
        a5 = new Vertice("Forte Bittencourt", 10, 6);
        a6 = new Vertice("Reino de Thundera", 3, 18);
        a7 = new Vertice("Castelo de Grayskull", 24, 2);
        b1 = new Aresta(a1, a3, 5);
        b2 = new Aresta(a1, a2, 5);
        b3 = new Aresta(a1, a6, 13.15);
        b4 = new Aresta(a2, a4, 4);
        b5 = new Aresta(a4, a5, 3.60);
        b6 = new Aresta(a4, a7, 17.46);
        b7 = new Aresta(a6, a7, 26.40);
        b8 = new Aresta(a3, a7, 20.02);
        b9 = new Aresta(a5, a3, 7.81);
        g.inserirVertice(a1);
        a1.inserirAresta(b1);
        a1.inserirAresta(b1);
        a1.inserirAresta(b1);
        g.inserirVertice(a2);
        a2.inserirAresta(b2);
        a2.inserirAresta(b4);
        g.inserirVertice(a3);
        a3.inserirAresta(b1);
        a3.inserirAresta(b8);
        a3.inserirAresta(b9);
        g.inserirVertice(a4);
        a4.inserirAresta(b4);
        a4.inserirAresta(b5);
        a4.inserirAresta(b6);
        g.inserirVertice(a5);
        a5.inserirAresta(b5);
        a4.inserirAresta(b9);
        g.inserirVertice(a6);
        a6.inserirAresta(b3);
        a6.inserirAresta(b7);
        g.inserirVertice(a7);
        a7.inserirAresta(b6);
        a7.inserirAresta(b7);
        a7.inserirAresta(b8);
    }

    @Test
    public void CalcularMenorTempo() {
        assertEquals(25.02, g.CacularMenorTempo(0, 6), 0.01);

    }

    @Test
    public void MenorCaminho() {
        List a = g.listarMenorCaminho(0, 6, false);
        Iterator it = a.iterator();
        assertTrue(it.hasNext());
        assertSame(a7, it.next());
        assertTrue(it.hasNext());
        assertSame(a3, it.next());
        assertTrue(it.hasNext());
        assertSame(a1, it.next());
        assertFalse(it.hasNext());

    }

    @Test
    public void ListarGrafo() {
        Iterator it = g.ListarVertices();
        assertTrue(it.hasNext());
        assertSame(a1, it.next());
        assertTrue(it.hasNext());
        assertSame(a2, it.next());
        assertTrue(it.hasNext());
        assertSame(a3, it.next());
        assertTrue(it.hasNext());
        assertSame(a4, it.next());
        assertTrue(it.hasNext());
        assertSame(a5, it.next());
        assertTrue(it.hasNext());
        assertSame(a6, it.next());
        assertTrue(it.hasNext());
        assertSame(a7, it.next());
        assertFalse(it.hasNext());
    }
}
