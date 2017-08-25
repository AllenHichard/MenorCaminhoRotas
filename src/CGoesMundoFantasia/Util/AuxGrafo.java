package CGoesMundoFantasia.Util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A classe AuxGrafo foi implementada principalmente para mostrar todos os
 * caminhos possíveis de uma vértice a outra através de suas ligações.
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class AuxGrafo {

    private final Map<String, LinkedHashSet<String>> mapa = new HashMap();
    private LinkedList<String> visitado;
    private String start;
    private String ultimo;
    private List<String> lista = new LinkedList();

    /**
     * O método adicionar, insere em uma tabela hash os dois nomes que nesse
     * caso é considerado duas vertices. Só um detalhe a classe tem um
     * comportamento igual a um grafo, mas com finalidade apenas de mostrar
     * todos os caminhos possíveis.
     *
     * @param nome1 primeira vertice
     * @param nome2 segunda vertice
     */
    public void adicionar(String nome1, String nome2) {
        LinkedHashSet<String> adjacente = mapa.get(nome1);
        if (adjacente == null) {
            adjacente = new LinkedHashSet();
            mapa.put(nome1, adjacente);
        }
        adjacente.add(nome2);
    }

    /**
     * Liga as duas vértices em virse-versa. Por exemplo A liga B e B liga A.
     *
     * @param nome1
     * @param nome2
     */
    public void adicionarDuplo(String nome1, String nome2) {
        adicionar(nome1, nome2);
        adicionar(nome2, nome1);
    }

    /**
     * Não permite dois lugares com o mesmo nome, método não utilizado no
     * problema já que pode haver duas cidades com o mesmo nome."Talves possa
     * não ficou nada restrito quando a isso"
     *
     * @param nome1
     * @param nome2
     * @return
     */
    public boolean estaConectado(String nome1, String nome2) {
        Set adjacente = mapa.get(nome1);
        if (adjacente == null) {
            return false;
        }
        return adjacente.contains(nome2);
    }

    /**
     * O método retorna uma lista que contem uma hash.
     *
     * @param last ultimo da atual hash.
     * @return
     */

    public LinkedList<String> nosAdjacente(String last) {
        LinkedHashSet<String> adjacente = mapa.get(last);
        if (adjacente == null) {
            return new LinkedList();
        }
        return new LinkedList(adjacente);

    }

    /**
     * Método que permite a busca de todos caminhos possíveis do um ponto a
     * outro. Por ser recursivo ele pega todos os caminhos e vao salvando em uma
     * lista no método printarNaLista, que guarda cada caminho em uma posição.
     *
     * @param ultimo o ponto dois.
     * @return a listas com todos os caminhos.
     */
    public List primeiraBorda(String ultimo) {
        LinkedList<String> nodes = nosAdjacente(visitado.getLast());
        // examine adjacente nodes
        for (String node : nodes) {
            if (visitado.contains(node)) {
                continue;
            }
            if (node.equals(ultimo)) {
                visitado.add(node);
                printarNaLista(visitado);
                visitado.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visitado.contains(node) || node.equals(ultimo)) {
                continue;
            }
            visitado.addLast(node);
            primeiraBorda(ultimo);
            visitado.removeLast();
        }

        return lista;
    }
    
    public void limpar(){
        lista = new LinkedList<>();
    }

    /**
     * O método concatena caminho por caminho salvando em uma lista, para depois
     * ser retornado pelo método primeiraBorda.
     *
     * @param visitado listas de visitados do caminho atual.
     */
    private void printarNaLista(LinkedList<String> visitado) {
        String nova = " ";
        for (String node : visitado) {
            nova = nova + " -> " + node;
        }
        nova = nova + "\n \n";
        lista.add(nova);
    }

    /**
     * retorna o ponto inicial.
     *
     * @return
     */
    public String getInicio() {
        return start;
    }

    /**
     * recebe um ponto inicial.
     *
     * @param start inicio
     */
    public void setInicio(String start) {
        visitado = new LinkedList();
        this.start = start;
        visitado.add(start);
    }

    /**
     * retorna o ponto final.
     *
     * @return
     */
    public String getFinal() {
        return ultimo;
    }

    /**
     * recebe um ponto final.
     *
     * @param ultimo final
     */
    public void setFinal(String ultimo) {
        this.ultimo = ultimo;
    }

}
