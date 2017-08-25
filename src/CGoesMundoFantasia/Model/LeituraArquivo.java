/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Model;

import CGoesMundoFantasia.Util.Aresta;
import CGoesMundoFantasia.Util.AuxGrafo;
import CGoesMundoFantasia.Util.Vertice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * A classe Leitura de Arquivo, ler um arquivo txt, que contenha o numero de
 * vertices, os nome dos vertices, e suas ligações(as Arestas), e salva em um
 * mapa grafo.
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class LeituraArquivo {

    private final List vertices;
    private final AuxGrafo grafo;

    /**
     * O contrutor da classe ler um arquivo txt, e envia ao método leitura, que
     * faz a finalidade de salvar os dados no programa, no caso em um grafo,
     * Além de inicalizar um grafo e uma lista.
     *
     * @param file arquivo a ser aberto.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public LeituraArquivo(File file) throws FileNotFoundException, IOException {
        grafo = new AuxGrafo();
        vertices = new LinkedList();
        leitura(file);
    }

    /**
     * O método leitura, recebe um arquivo, faz o mapeamento do arquivo,
     * identificando os vertices, as coordenadas desses vértices, e as possíveis
     * formações de dois vértices formando uma aresta, a ser adicionada em cada
     * respectivo vertice, além de calcular os pesos de casa aresta. Salvando
     * todo o mapeamento do arquivo em um grafo, a ser passado para o controller
     * para a visualização na interface
     *
     * @param file arquivo a ser aberto.
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void leitura(File file) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String nome = reader.readLine();
        int total = Integer.parseInt(nome);
        for (int a = 0; a < total; a++) {
            nome = reader.readLine();
            int index = nome.indexOf(";");
            if (index != -1) {
                String cidade = nome.substring(0, index);
                int i = nome.indexOf("(");
                int j = nome.indexOf(",");
                int k = nome.indexOf(")");
                String coordenadaX = nome.substring(i + 1, j);
                int x = Integer.parseInt(coordenadaX);
                String coordenaday = nome.substring(j + 1, k);
                int y = Integer.parseInt(coordenaday);
                Vertice v = new Vertice(cidade, x, y);

                vertices.add(v);

            }
        }
        nome = reader.readLine();
        while (nome != null) {
            Vertice aux1 = null;
            Vertice aux2 = null;
            int index = nome.indexOf(";");

            String nova = nome.substring(0, index);
            String sucessora = nome.substring(index + 1, nome.length());
            Iterator it = vertices.iterator();
            while (it.hasNext()) {
                Vertice vertice = (Vertice) it.next();
                if (vertice.equals(nova)) {
                    aux1 = vertice;

                }
                if (vertice.equals(sucessora)) {
                    aux2 = vertice;

                }

            }
            double calculo1 = (aux1.getX() - aux2.getX());
            double calculo2 = (aux1.getY() - aux2.getY());
            double resultado1 = Math.pow(calculo1, 2);
            double resultado2 = Math.pow(calculo2, 2);
            double value = Math.sqrt(resultado1 + resultado2);

            Aresta aresta = new Aresta(aux1, aux2, value);
            aux1.inserirAresta(aresta);
            aux2.inserirAresta(aresta);
            grafo.adicionar(aux1.getNome(), aux2.getNome());
            grafo.adicionar(aux2.getNome(), aux1.getNome());
            nome = reader.readLine();
        }

    }

    /**
     * Retorna o grafo, para ser atribuido a um novo grafo no controller, no
     * caso uma cópia para que o sistema associe com as funcionalidades.
     *
     * @return Iterator
     */
    public Iterator ListarVertices() {
        return vertices.iterator();
    }

    /**
     * Esse método faz a função de mostrar todas as possíveis rotas formada pela
     * classe AuxGrafo e retorna o Iterador com todos os caminhos possíveis.
     *
     * @param start ponto de partida
     * @param end ponto de chegada
     * @return Iterator
     */
    public Iterator ordemMapa(String start, String end) {
        grafo.setInicio(start);
        List a = grafo.primeiraBorda(end);
        grafo.limpar();
        return a.iterator();
    }

}
