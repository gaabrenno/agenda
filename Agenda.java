//Utilizacao de componentes do Java (pacotes)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.LabelView;
import java.util.Vector;

// A classe Vector implementa um array redimensionável de objetos. Assim como um array, objetos da //classe Vector contém elementos que podem ser acessados via índices.
public class Agenda extends WindowAdapter implements ActionListener {
    //Declaracao WindowAdapter-manipulador de eventos de janela, junto com ActionListener ()
// windowOpened(),windowClosing(),windowClosed(), etc...
    private Frame janela;
    private Panel painelEndereco, painelBotoes;
    private Label lCodigo, lNome, lEndereco, lFone, lCelular, lSexo, lObservacao, lTitulo;
    private TextField tCodigo, tNome, tEndereco, tFone, tCelular;
    private TextArea tObs;
    private Button bNovo, bSalva, bExclui, bProximo, bAnterior;
    private CheckboxGroup cbgSexo;
    private Checkbox masculino, feminino;
    private Vector vContatos;
    private int posicao;

    // Codigo das cores https://celke.com.br/artigo/tabela-de-cores-html-nome-hexadecimal-rgb
    //Método Construtor Criacao de vetor, frame
    public Agenda() {
        vContatos = new Vector();
        janela = new Frame();
        janela.setTitle("Agenda");
        janela.setSize(370, 414);
        janela.setBackground(new Color(240, 255, 255)); //gb fundo Azure
        janela.setLayout(null);
        janela.addWindowListener(this);
//Método Construtor Criacao de Painel
        painelEndereco = new Panel();
        painelEndereco.setBackground(new Color(176, 224, 230)); // PowderBlue
        painelEndereco.setSize(350, 234);
        painelEndereco.setLocation(10, 80);
        painelEndereco.setLayout(null);
//Método Construtor Criacao de Painel
        painelBotoes = new Panel();
        painelBotoes.setBackground(new Color(176, 224, 230)); //  PowderBlue
        painelBotoes.setSize(350, 34);
        painelBotoes.setLocation(10, 344);
        painelBotoes.setLayout(new FlowLayout());
//Método Construtor Criacao de Labels
        lCodigo = new Label("Codigo:");
        lNome = new Label("Nome:");
        lEndereco = new Label("Endereço:");
        lFone = new Label("Fone:");
        lCelular = new Label("Celular:");
        lSexo = new Label("Sexo:");
        lObservacao = new Label("Obs.:");
       // lTitulo = new Label("Agenda");
//Método Construtor Criacao de TextFields
        tCodigo = new TextField(10);
        tNome = new TextField(45);
        tEndereco = new TextField(60);
        tFone = new TextField(8);
        tCelular = new TextField(9);
//Substituicao do item pelo compomente especificado, na posicao indicada
      //  lTitulo.setBounds(150, 10, 70, 20);
        lCodigo.setBounds(10, 15, 50, 13);
        tCodigo.setBounds(70, 12, 80, 19);
        lNome.setBounds(10, 37, 50, 13);
        tNome.setBounds(70, 34, 270, 19);
        lEndereco.setBounds(10, 59, 60, 13);
        tEndereco.setBounds(70, 56, 270, 19);
        lFone.setBounds(10, 83, 60, 13);
        tFone.setBounds(70, 80, 80, 19);
        lCelular.setBounds(180, 83, 50, 13);
        tCelular.setBounds(240, 80, 100, 19);
        lSexo.setBounds(10, 105, 30, 13);
//Método Construtor Criacao de CheckboxGroup
        cbgSexo = new CheckboxGroup();
        masculino = new Checkbox("Masculino", false, cbgSexo);
        feminino = new Checkbox("Feminino", false, cbgSexo);
        masculino.setBounds(70, 102, 90, 19);
        feminino.setBounds(160, 102, 90, 19);
//Método Construtor Criacao de de TextArea
        lObservacao.setBounds(10, 132, 50, 13);
        tObs = new TextArea("", 15, 90, TextArea.SCROLLBARS_VERTICAL_ONLY);
        tObs.setBounds(70, 132, 270, 90);
//Adiciona no frame painelEndereco os componentes criados
        //janela.add(lTitulo);
        painelEndereco.add(lCodigo);
        painelEndereco.add(tCodigo);
        painelEndereco.add(lNome);
        painelEndereco.add(tNome);
        painelEndereco.add(lEndereco);
        painelEndereco.add(tEndereco);
        painelEndereco.add(lFone);
        painelEndereco.add(tFone);
        painelEndereco.add(lCelular);
        painelEndereco.add(tCelular);
        painelEndereco.add(lSexo);
        painelEndereco.add(tObs);
        painelEndereco.add(lObservacao);
        painelEndereco.add(masculino);
        painelEndereco.add(feminino);
//Método Construtor Criacao de botoes e ativa o escutator(listener)
        bNovo = new Button("Novo");
        bNovo.addActionListener(this);
        bSalva = new Button("Salva");
        bSalva.addActionListener(this);
        bExclui = new Button("Exclui");
        bExclui.addActionListener(this);
        bProximo = new Button("Próximo");
        bProximo.addActionListener(this);
        bAnterior = new Button("Anterior");
        bAnterior.addActionListener(this);
//Adiciona no frame painelBotoes os botoes criados
        painelBotoes.add(bNovo);
        painelBotoes.add(bSalva);
        painelBotoes.add(bExclui);
        painelBotoes.add(bProximo);
        painelBotoes.add(bAnterior);
        //adiciona na Janela os frames
        janela.add(painelEndereco);
        janela.add(painelBotoes);
        //Desabilita os botoes quando inicia o programa
        bExclui.setEnabled(false);
        bAnterior.setEnabled(false);
        bProximo.setEnabled(false);
    }

    //Adiciona o conteudo no vetor(setText)
    public void setCodigo(String codigo) {
        tCodigo.setText(codigo);
    }

    public void setNome(String nome) {
        tNome.setText(nome);
    }

    public void setEndereco(String endereco) {
        tEndereco.setText(endereco);
    }

    public void setFone(String fone) {
        tFone.setText(fone);
    }

    public void setCelular(String celular) {
        tCelular.setText(celular);
    }

    public void setObs(String Obs) {
        tObs.setText(Obs);
    }

    public void setSexo(String sexo) {
        if (sexo != null) {
            if (sexo.equals("F")) feminino.setState(true);
            else if (sexo.equals("M")) masculino.setState(true);
        }
    }

    public void setMenuBar(MenuBar mb) {
        janela.setMenuBar(mb);
    }

    //Retorna o conteudo(=objeto) que esta no vetor
    public String getCodigo() {
        return tCodigo.getText();
    }

    public String getNome() {
        return tNome.getText();
    }

    public String getEndereco() {
        return tEndereco.getText();
    }

    public String getFone() {
        return tFone.getText();
    }

    public String getCelular() {
        return tCelular.getText();
    }

    public String getObs() {
        return tObs.getText();
    }

    public String getSexo() {
        if (masculino.getState() == true) return "M";
        else if (feminino.getState() == true) return "F";
        else return " ";
    }

    //Verificacao de qual dos botoes foi acionado para chamar os procedimentos devidos
    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b == bNovo) this.botaoNovo();
        else if (b == bSalva) this.botaoSalva();
        else if (b == bExclui) this.botaoExclui();
        else if (b == bAnterior) this.botaoAnterior();
        else if (b == bProximo) this.botaoProximo();
    }

    //Acao do botao Novo
    void botaoNovo() {
        this.limpaDados();
        bExclui.setEnabled(false);
        bAnterior.setEnabled(false);
        bProximo.setEnabled(false);
        tCodigo.requestFocus();
    }

    //Acao do botao salva
    public void botaoSalva() {
        vContatos.addElement(new Contato(getCodigo(), getNome(), getEndereco(), getFone(), getCelular(), getSexo(), getObs()));
        bExclui.setEnabled(true);
        bAnterior.setEnabled(true);
        bProximo.setEnabled(true);
    }

    //Acao do botao Exclui
    void botaoExclui() {
        if (!vContatos.isEmpty())
            vContatos.removeElementAt(posicao);
    }

    //Acao do botao Anterior
    void botaoAnterior() {
        if (!vContatos.isEmpty()) {
            bProximo.setEnabled(true);
            --posicao;
            if (posicao <= 0) {
                posicao = 0;
                bAnterior.setEnabled(false);
            }
            this.obterDadosContatos(posicao);
        }
    }

    //Acao do botao Proximo
    void botaoProximo() {
        if (!vContatos.isEmpty()) {
            bAnterior.setEnabled(true);
            ++posicao;
            if (posicao >= vContatos.size() - 1) {
                posicao = vContatos.size() - 1;
                bProximo.setEnabled(false);
            }
            this.obterDadosContatos(posicao);
        }
    }

    //Limpa Campos
    public void limpaDados() {
        this.setCodigo("");
        this.setNome("");
        this.setEndereco("");
        this.setFone("");
        this.setCelular("");
        this.setObs("");
    }

    //Obtem dados
    public void obterDadosContatos(int pos) {
        Contato contatoAtual = (Contato) vContatos.elementAt(pos);
        this.setCodigo(contatoAtual.getCodigo());
        this.setNome(contatoAtual.getNome());
        this.setEndereco(contatoAtual.getEndereco());
        this.setFone(contatoAtual.getFone());
        this.setCelular(contatoAtual.getCelular());
        this.setSexo(contatoAtual.getSexo());
        this.setObs(contatoAtual.getObs());
    }

    //fecha janela
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void mostraAgenda() {
        janela.setVisible(true);
    }

    public static void main(String[] args) {
//Criacao da Agenda
        Agenda agenda = new Agenda();
        agenda.mostraAgenda();
    }
}