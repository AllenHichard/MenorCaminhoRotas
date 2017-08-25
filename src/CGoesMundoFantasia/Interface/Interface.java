/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CGoesMundoFantasia.Interface;
//Image Icon
//Image
import CGoesMundoFantasia.Facade.Facade;
import CGoesMundoFantasia.Util.Vertice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Allen Hichard Marques dos Santos, Alisson Vilas Verde
 */
public class Interface {

    private final Facade f = new Facade();
    private JFrame frame;
    private final JButton botaoCarregar = new JButton("Carregar arquivo");
    private final JButton botaoSair = new JButton("Sair");
    private final Container primeiro = new JPanel();
    private final Container segundo = new JPanel();
    private final Container terceiro = new JPanel();
    private final Container quarto = new JPanel();
    private final Container quinto = new JPanel();
    private final Container sexto = new JPanel();
    private final JComboBox combo = new JComboBox();
    private final JComboBox combo2 = new JComboBox();
    private final JTextArea rotas = new JTextArea("", 20, 30);
    private final JTextArea melhorCaminho = new JTextArea("", 20, 30);
    private final JTextArea distancia = new JTextArea("", 20, 30);
    private final JButton partida = new JButton("Confirmar ponto de partida");
    private final JButton chegada = new JButton("Confirmar ponto de chegada");
    private final JButton possivelRota = new JButton("Possíveis Rotas");
    private final JButton MenorCaminho = new JButton("Menor Caminho");
    private int posicionFirst = -1;
    private int posicionLast = -1;
    private String hokage;
    private String p;
    private String u;
    private final ImageIcon icon = new ImageIcon("C:\\Users\\Hichard\\Documents\\NetBeansProjects\\PBL4\\the-last-naruto-the-movie.jpg"); 
    private final JLabel label = new JLabel(icon); 
    private final JButton euclidiana = new JButton("Diatância entre Pontos");
    private final JButton imagem = new JButton("dedicatória");
    private final JButton limpa = new JButton("limpar a tela");

    public static void main(String[] args) throws IOException {
        new Interface().Programa();
    }
    
    public void Programa() {
        
        frame = new JFrame("Fantasia");
        rotas.setLineWrap(true);
        rotas.setWrapStyleWord(true);
        rotas.setEditable(false); 
        //rotas.setFont(new Font("Arial", Font.PLAIN, 11));
        melhorCaminho.setLineWrap(true);
        melhorCaminho.setWrapStyleWord(true);
        melhorCaminho.setEditable(false);
        //melhorCaminho.setFont(new Font("Arial", Font.PLAIN, 11));
        distancia.setLineWrap(true);
        distancia.setWrapStyleWord(true);
        distancia.setEditable(false);
        //distancia.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2, 3);
        
        Container c = new JPanel(layout);
        
        JScrollPane rolagem1 = new JScrollPane(rotas);
        
        frame.setContentPane(c);
        
        c.add(primeiro);
        c.add(segundo);
        c.add(terceiro);
        c.add(quarto);
        c.add(quinto);
        c.add(sexto);
        
        combo.addItem("Nenhuma Opção");
        combo2.addItem("Nenhuma Opção");
        primeiro.add(botaoCarregar);
        
        
        segundo.add(combo);
        segundo.add(partida);
        segundo.add(combo2);
        segundo.add(chegada);
        terceiro.add(botaoSair);
        terceiro.add(limpa);
        rotas.setBorder(new LineBorder(Color.BLACK));
        
        quarto.add(possivelRota);
        quarto.add(rolagem1);
        melhorCaminho.setBorder(new LineBorder(Color.BLACK));
        quinto.add(MenorCaminho);
        quinto.add(melhorCaminho);
        frame.pack();
        frame.setSize(1100, 700);
        distancia.setBorder(new LineBorder(Color.BLACK));
        sexto.add(euclidiana);
        sexto.add(distancia);
        frame.setVisible(true);
        carregar();
        sair();
        partida();
        chegada();
        Menor();
        TodasRotas();
        distanciaPontos();
        limpeza();

    }

    public void escolherArquivo() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Selecione um arquivo txt", "txt"));
        int retorno = fileChooser.showOpenDialog(null);
        fileChooser.setMultiSelectionEnabled(false);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            f.ImportarArquivoConfiguracao(file);
            JOptionPane.showMessageDialog(null, "Arquivo selecionado com sucesso");// mostra uma mensagem para o usuario
        } else {
            JOptionPane.showMessageDialog(null, "usuario não selecionou um arquivo");
        }
    }

    public void sair() {
        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void carregar() {
        botaoCarregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    escolherArquivo();
                    MostrarCidades();
                    frame.setVisible(true);
                } catch (IOException ex) {
                     
                }
            }
        });

    }

    public void MostrarCidades() {
        
        combo.removeAllItems();
        combo2.removeAllItems();
        for (int i = 0; i < f.cidadesMapa().size(); i++) {
            Vertice a = (Vertice) f.cidadesMapa().get(i);
            combo.addItem(a.getNome());
            combo2.addItem(a.getNome());
        }
    }

    public void partida() {
        partida.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) {
                //melhorCaminho.setText((String) combo.getSelectedItem());
                posicionFirst = combo.getSelectedIndex();
                p = (String) combo.getSelectedItem();
                JOptionPane.showMessageDialog(null, "primeiro caminho " + combo.getSelectedItem());// mostra uma mensagem para o usuario
            }
        });
    }

    public void chegada() {
        chegada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //rotas.setText((String) combo2.getSelectedItem());
                posicionLast = combo2.getSelectedIndex();
                u = (String) combo2.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Segundo caminho " + combo2.getSelectedItem());// mostra uma mensagem para o usuario
            }
        });
    }

    public void Menor() {
        
        MenorCaminho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nome = new String();
                List a = f.IdentificarMenorCaminho(posicionFirst, posicionLast);
                double valor = f.distanciaMenorCaminho(posicionFirst, posicionLast);
                DecimalFormat decimal = new DecimalFormat( "0.00" );  
                String b = String.valueOf(decimal.format(valor));
                
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    nome = " -> "+it.next().toString() + " " + nome;
                }
                nome = nome+ "\n" + "Com uma distancia de " + b + " Kilometros";
                melhorCaminho.setText(nome);
            }
        });
    }

    public void TodasRotas() {
        possivelRota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String a = new String();
                Iterator it;
                it = f.IdentificarPossiveisRotas(p, u);
                while(it.hasNext()){
                    a = a + " " +(String) it.next();
                }
                rotas.setText(a);
            }
        });
    }
    
    public void distanciaPontos() {
        euclidiana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double valor = f.CalculaDistancia(p, u);
                DecimalFormat decimal = new DecimalFormat( "0.00" );  
                String b = String.valueOf(decimal.format(valor));
                distancia.setText("A distância é de " +b+ " kilometros");
                
            }
        });
    }
    
    
    public void limpeza() {
        limpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               rotas.setText(" ");
               melhorCaminho.setText(" ");
               distancia.setText(" ");
            }
        });
    }
}
