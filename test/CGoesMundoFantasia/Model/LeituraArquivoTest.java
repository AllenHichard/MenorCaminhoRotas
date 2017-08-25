/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CGoesMundoFantasia.Model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class LeituraArquivoTest {
    LeituraArquivo l;
    File file;
    
    public LeituraArquivoTest() throws IOException {
        file = new File("C:\\Users\\Hichard\\Documents\\NetBeansProjects\\PBL4\\Arquivo\\arquivo.txt");
        l = new LeituraArquivo(file);
        
    }
    @Test
    public void testVerticesArquivo() throws IOException{
        
        Iterator it = l.ListarVertices();
        assertTrue(it.hasNext());
        assertEquals("Reino de Eternia", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Castelo Ti Bum", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Fenda do Biquini", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Narnia", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Forte Bittencourt", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Reino de Thundera", it.next().toString());
        assertTrue(it.hasNext());
        assertEquals("Castelo de Grayskull", it.next().toString());
        assertFalse(it.hasNext());
    }
    
    
    

   
    
}
