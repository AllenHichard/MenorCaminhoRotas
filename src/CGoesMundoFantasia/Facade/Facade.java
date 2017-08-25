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

/**
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class Facade {

    private final Controller controller;

    public Facade() {
        controller = new Controller();
    }

    public void ImportarArquivoConfiguracao(File file) throws IOException {
        controller.ImportarArquivoConfiguracao(file);
    }

    public double CalculaDistancia(String v1, String V2) {
        return controller.CalculaDistancia(v1, V2);
    }

    public List IdentificarMenorCaminho(int origem, int destino) {
        return controller.IdentificarMenorCaminho(origem, destino);
    }

    public Iterator IdentificarPossiveisRotas(String origem, String destino) {
        return controller.IdentificarPossiveisRotas(origem, destino);
    }

    public List cidadesMapa() {
        return controller.cidadesMapa();
    }
    
    public double distanciaMenorCaminho(int origem, int destino){
        return controller.distanciaMenorCaminho(origem, destino);
    }

}
