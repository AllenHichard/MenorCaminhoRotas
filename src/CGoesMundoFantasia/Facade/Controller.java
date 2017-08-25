/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Facade;

import CGoesMundoFantasia.Model.LeituraArquivo;
import CGoesMundoFantasia.Util.Grafo;
import CGoesMundoFantasia.Util.Vertice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * O controller é responsável por toda a finalidade do programa, que é fazer os
 * métodos das funcionalidade do programa.
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class Controller {

    private final Grafo terreno;
    private LeituraArquivo leitura;

    /**
     * O construtor apenas inicia o grafo para ter um novo mapa.
     */
    public Controller() {
        terreno = new Grafo();
    }

    /**
     * O método ImportarArquivoConfiguracao, ele recebe um arquivo, que conterá
     * as vértices e arestas para criar o grafo. Fazendo a leitura desse arquivo
     * com a classe LeituraArquivo, ela retorna, já todas as vertices que contém
     * suas arestas e copia para o mapa grafo do controller.
     *
     * @param file arquivo txt a ser importado.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void ImportarArquivoConfiguracao(File file) throws FileNotFoundException, IOException {
        leitura = new LeituraArquivo(file);
        Iterator it = leitura.ListarVertices();
        while (it.hasNext()) {
            Vertice vertice = (Vertice) it.next();
            terreno.inserirVertice(vertice);
        }
    }

    /**
     * Esse método calcula a distancia entre dois pontos, distância essa entre
     * qualquer dois pontos no mapa grafo, no caso uma distancia euclidiana
     * entre duas vertices de qualquer posição no grafo.
     *
     * @param v1 ponto de partida
     * @param v2 ponto de chegada
     * @return kilometragem do percurso euclidiano.
     */
    public double CalculaDistancia(String v1, String v2) {
        Vertice aux1 = null;
        Vertice aux2 = null;
        double calculo1;
        double calculo2;

        Iterator it = terreno.ListarVertices();
        while (it.hasNext()) {
            Vertice vertice = (Vertice) it.next();
            if (vertice.equals(v1)) {
                aux1 = vertice;
            } else if (vertice.equals(v2)) {
                aux2 = vertice;
            }
        }
        calculo1 = (aux1.getX() - aux2.getX());
        calculo2 = (aux1.getY() - aux2.getY());
        double resultado1 = Math.pow(calculo1, 2);
        double resultado2 = Math.pow(calculo2, 2);
        return Math.sqrt(resultado1 + resultado2);
    }

    /**
     * O método IdentificarMenorCaminho, retorna uma lista com o menor caminho
     * entre duas vertices no grafo.
     *
     * @param origem ponto de partida
     * @param destino ponto de chegada
     * @return lista com o menor caminho
     */
    public List IdentificarMenorCaminho(int origem, int destino) { 
        return terreno.listarMenorCaminho(origem, destino, false);
    }

    /**
     * Esse método retorna todas as rotas possíveis entre duas vertices,
     * considerando a saida e a chegada.
     *
     * @param origem ponto de partida
     * @param destino ponto de chegada
     * @return O iterator com todas as rotas.
     */
    public Iterator IdentificarPossiveisRotas(String origem, String destino) {
        return leitura.ordemMapa(origem, destino);

    }

    /**
     * Esse método adicinal, é para facilitar a capitura de todas as vértices do
     * grafo, ´para ser manipulada na Interface grafica.
     *
     * @return a Lista Adjacente do Grafo.
     */
    public List cidadesMapa() {
        return terreno.ListaGrafo();
    }

    public double distanciaMenorCaminho(int origem, int destino) {
        return terreno.CacularMenorTempo(origem, destino);
    }

}
