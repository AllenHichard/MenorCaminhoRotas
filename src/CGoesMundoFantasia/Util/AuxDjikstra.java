/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Util;

/**
 * A classe AuxDjikstra, auxilia o método de Djikstra na classe grafo, cada
 * auxDjikstra representa um vértice.
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class AuxDjikstra {

    private int pertenceId;
    private boolean foiVisitado;
    private double pesos;
    private int antecessor = -5;

    /**
     * Retorna se a vertice ja foi visitada.
     *
     * @return True or False
     */
    public boolean isfoiVisitado() {
        return foiVisitado;
    }

    /**
     * Altera para verdadeiro quando for selecionada pelo djikstra.
     *
     * @param fixo true or false
     */
    public void setFoiVisitado(boolean fixo) {
        this.foiVisitado = fixo;
    }

    /**
     * retorna o acumulo dos pesos feito pelo djikstra.
     *
     * @return distancia.
     */
    public double getPesos() {
        return pesos;
    }

    /**
     * Altera o peso atual, pelo novo pelo acumulado.
     *
     * @param pesos distância.
     */
    public void setPesos(double pesos) {
        this.pesos = pesos;
    }

    /**
     * retorna o Id da vertice
     *
     * @return
     */
    public int getPertenceId() {
        return pertenceId;
    }

    /**
     * atribue um Id a uma vértice.
     *
     * @param pertenceId id da vértice
     */
    public void setPertenceId(int pertenceId) {
        this.pertenceId = pertenceId;
    }

    /**
     * para saber o caminho anterior.
     *
     * @return
     */
    public int getAntecessor() {
        return antecessor;
    }

    /**
     * O djikstra avança e muda seu caminho anterior.
     *
     * @param antecessor Id dos anteriores
     */
    public void setAntecessor(int antecessor) {
        this.antecessor = antecessor;
    }

}
