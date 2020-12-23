/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.chid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import locamobil.view.util.IExecutaOperacao;
import locamobil.view.util.Operacao;

/**
 *
 * @author Marcos
 */
public abstract class ControleChild implements ActionListener, IExecutaOperacao{
    
    protected JInternalFrame frame;
    protected JLabel lbTituloFrame;
    protected JLabel operacaoNome;
    protected JButton botaoIncluir;
    protected JButton botaoAlterar;
    protected JButton botaoExcluir;
    protected JButton botaoConsultar;
    protected JButton botaoCancelar;
    protected JButton botaoConfirmar;
    protected JButton botaoFechar;
    public JPanel panel;
    String operacao;
    
    public JInternalFrame getFrame() {
        return frame;
    }
    
    protected enum OperacaoNome{
        
        INCLUIR("Incluir"),
        ALTERAR("Alterar"),
        EXCLUIR("Excluir"),
        CONSULTAR("Consultar"),
        SELECIONE_A_OPERACAO("Selecione a operação");
            
        private final String nome;
        OperacaoNome(String nomeOp){
            nome = nomeOp;
        }

        public String getText(){
            return nome;
        }
    }
    
    public ControleChild(String nomeJanela ,String nomeFrame){
        
        panel = new JPanel();
        panel.setLayout(null);
        frame = new JInternalFrame(nomeJanela, true, true, true, true);
        
        lbTituloFrame = new JLabel(nomeFrame);
        lbTituloFrame.setFont(new Font("Arial",Font.BOLD,14));
        lbTituloFrame.setBounds(20, 20, 500, 20);
       
        botaoIncluir = new JButton("Incluir");
        botaoAlterar = new JButton("Alterar");
        botaoExcluir = new JButton("Excluir");
        botaoConsultar = new JButton("Consultar");
        botaoCancelar = new JButton("Cancelar");
        botaoConfirmar = new JButton("Confirmar");
        botaoFechar = new JButton("Fechar");
        
        botaoIncluir.setBounds(20, 60, 100, 20);
        botaoAlterar.setBounds(120, 60, 100, 20);
        botaoExcluir.setBounds(220, 60, 100, 20);
        botaoConsultar.setBounds(320, 60, 100, 20);
        botaoCancelar.setBounds(420, 60, 100, 20);
        botaoConfirmar.setBounds(520, 60, 100, 20);
        botaoFechar.setBounds(620, 60, 100, 20);
        botaoCancelar.setEnabled(false);
        botaoConfirmar.setEnabled(false);
        
        operacaoNome = new JLabel("Selecione a Operação");
        operacaoNome.setFont(new Font("Arial",Font.BOLD,14));
        operacaoNome.setBounds(20, 100, 500, 20);
        operacaoNome.setForeground(Color.blue);
        
        panel.add(lbTituloFrame);
        panel.add(botaoIncluir);
        panel.add(botaoAlterar);
        panel.add(botaoExcluir);
        panel.add(botaoConsultar);
        panel.add(botaoCancelar);
        panel.add(botaoConfirmar);
        panel.add(botaoFechar);
        panel.add(operacaoNome);
        
    }
    protected void operacaoBotoesHabilita(boolean habilita){
        
        botaoIncluir.setEnabled(habilita);
        botaoAlterar.setEnabled(habilita);
        botaoExcluir.setEnabled(habilita);
        botaoConsultar.setEnabled(habilita);
        botaoCancelar.setEnabled(!habilita);
        botaoConfirmar.setEnabled(!habilita);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
    
        if(evento.getSource().equals(botaoIncluir)){
            this.operacaoBotoesHabilita(false);
            operacao = Operacao.INCLUIR.getNomeOperacao();
            operacaoNome.setText(OperacaoNome.INCLUIR.getText());
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoAlterar)){
            this.operacaoBotoesHabilita(false);
            operacao = Operacao.ALTERAR.getNomeOperacao();
            operacaoNome.setText(OperacaoNome.ALTERAR.getText());
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoExcluir)){
            this.operacaoBotoesHabilita(false);
            operacao = Operacao.EXCLUIR.getNomeOperacao();
            operacaoNome.setText(OperacaoNome.EXCLUIR.getText());
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoConsultar)){
            this.operacaoBotoesHabilita(false);
            operacao = Operacao.CONSULTAR.getNomeOperacao();
            operacaoNome.setText(OperacaoNome.CONSULTAR.getText());
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoCancelar)){
            this.operacaoBotoesHabilita(true);
            operacaoNome.setText(OperacaoNome.SELECIONE_A_OPERACAO.getText());
            operacao = Operacao.CANCELAR.getNomeOperacao();
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoConfirmar)){
            this.operacaoBotoesHabilita(true);
            operacaoNome.setText(OperacaoNome.SELECIONE_A_OPERACAO.getText());
            if(operacao.equals(Operacao.INCLUIR.getNomeOperacao())){
               this.incluir();
            }
            else if(operacao.equals(Operacao.ALTERAR.getNomeOperacao())){
               this.alterar();
            }
            else if(operacao.equals(Operacao.EXCLUIR.getNomeOperacao())){
               this.excluir();
            }
            else if(operacao.equals(Operacao.CONSULTAR.getNomeOperacao())){
                this.consultar();
            }
            operacao = "";
            this.habilitaCampos();
        }
        else if(evento.getSource().equals(botaoFechar)){
            this.getFrame().dispose();
        }

        
    }
    
}
