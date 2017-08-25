/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CGoesMundoFantasia.Facade;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class FacadeTest {
    private final Facade f;
    private File file;
    
    public FacadeTest() {
        f = new Facade();
        
    }
    @Test
    public void abrirArquivo() throws IOException{
        file = new File("C:\\Users\\Hichard\\Documents\\NetBeansProjects\\PBL4\\Arquivo\\arquivo.txt");
        f.ImportarArquivoConfiguracao(file);
    }
    @Test
    public void testDistancia() throws IOException{
        abrirArquivo();
        assertEquals(26.40, f.CalculaDistancia("Reino de Thundera", "Castelo de Grayskull"), 0.01);
        assertEquals(09.05, f.CalculaDistancia("Reino de Thundera", "Castelo Ti Bum"), 0.01);
      
    }
    @Test
    public void testCaminho() throws IOException{
        abrirArquivo();
        List lista = f.IdentificarMenorCaminho(0, 6);
        Iterator it = lista.iterator();
        assertTrue(it.hasNext());
        assertEquals("Castelo de Grayskull", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Fenda do Biquini", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Reino de Eternia", it.next().toString());
        assertFalse(it.hasNext());
        lista = f.IdentificarMenorCaminho(1, 4);
        it = lista.iterator();
        assertTrue(it.hasNext());
        assertEquals("Forte Bittencourt", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Narnia", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Castelo Ti Bum", it.next().toString());
        assertFalse(it.hasNext());
        
    }
    
    
}
