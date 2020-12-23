/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.mdi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import locamobil.global.util.Mensagens;
import locamobil.view.chid.CategoriaView;
import locamobil.view.chid.ClienteView;
import locamobil.view.chid.MontadoraView;
import locamobil.view.chid.ModeloView;
import locamobil.view.chid.CombustivelView;
import locamobil.view.chid.UsuarioView;
import locamobil.view.chid.VeiculoView;
import locamobil.view.util.PrincipalDimensao;
import locamobil.view.util.StatusBar;
import locamobil.view.util.UsuarioLogado;

/**
 *
 * @author Marcos
 */
public class LocaMobilPrincipal extends JFrame implements ActionListener {

    private final JDesktopPane jDesktopPane;
    private final StatusBar statusBar;
    private final JMenuBar menuBarPrincipal;
    
    private final JMenu menuCadastro;
    private final JMenu subMenuVeiculo;
    private final JMenu menuOperacao;
    private final JMenu menuConsulta;
    private final JMenu menuSistema;
    private final JMenu menuAjuda;
    
    private final JMenuItem menuItemMontadora;
    private final JMenuItem menuItemModelo;
    private final JMenuItem menuItemCategoria;
    private final JMenuItem menuItemCombustivel;
    private final JMenuItem menuItemVeiculo;
    
    private final JMenuItem menuItemCliente;
    private final JMenuItem menuItemUsuario;
    
    private final JMenuItem menuItemLocacao;
    private final JMenuItem menuItemDevolucao;
    private final JMenuItem menuItemBaixa;
    
    private final JMenuItem menuItemLocacaoCon;
    
    private final JMenuItem menuItemInformacoes;
    private final JMenuItem menuItemReiniciar;
    private final JMenuItem menuItemSair;
    
    private final JMenuItem menuItemAjuda;
    private final JMenuItem menuItemSobre;

    public JMenuBar getMenuBarPrincipal() {
        return menuBarPrincipal;
    }

    public LocaMobilPrincipal(){
        
        this.jDesktopPane = new JDesktopPane();
        this.menuBarPrincipal = new JMenuBar();
        this.statusBar = new StatusBar();
        
        menuCadastro = new JMenu("Cadastro");
        subMenuVeiculo = new JMenu("Veículo");
        menuOperacao = new JMenu("Operação");
        menuConsulta = new JMenu("Consulta");
        menuSistema = new JMenu("Sistema");
        menuAjuda = new JMenu("Ajuda");
        
        menuItemMontadora  = new JMenuItem("Montadora");
        menuItemModelo  = new JMenuItem("Modelo");
        menuItemCategoria  = new JMenuItem("Categoria");
        menuItemCombustivel  = new JMenuItem("Combustivel");
        menuItemVeiculo = new JMenuItem("Veículo");
        menuItemCliente = new JMenuItem("Cliente");
        menuItemUsuario = new JMenuItem("Usuário");
        
        menuItemLocacao = new JMenuItem("Locação");
        menuItemDevolucao = new JMenuItem("Devolução");
        menuItemBaixa = new JMenuItem("Baixa");
        
        menuItemLocacaoCon = new JMenuItem("Locação");
        
        menuItemInformacoes = new JMenuItem("Informações");
        menuItemReiniciar = new JMenuItem("Reiniciar");
        menuItemSair = new JMenuItem("Sair");
        
        menuItemAjuda = new JMenuItem("Ajuda");
        menuItemSobre = new JMenuItem("Sobre");
        
        /* Cadastro */
        subMenuVeiculo.add(menuItemMontadora);
        subMenuVeiculo.add(menuItemModelo);
        subMenuVeiculo.add(menuItemCategoria);
        subMenuVeiculo.add(menuItemCombustivel);
        subMenuVeiculo.addSeparator();
        subMenuVeiculo.add(menuItemVeiculo);
        menuCadastro.add(subMenuVeiculo);
        menuCadastro.add(menuItemCliente);
        menuCadastro.addSeparator();
        menuCadastro.add(menuItemUsuario);
        
        /* Operação */
        menuOperacao.add(menuItemLocacao);
        menuOperacao.add(menuItemDevolucao);
        menuOperacao.add(menuItemBaixa);
        
        /* Consulta */
        menuConsulta.add(menuItemLocacaoCon);
        
        /* Sistema */
        menuSistema.add(menuItemInformacoes);
        menuSistema.add(menuItemReiniciar);
        menuSistema.addSeparator();
        menuSistema.add(menuItemSair);
        
        /* Ajuda */
        menuAjuda.add(menuItemAjuda);
        menuAjuda.add(menuItemSobre);
        
        menuBarPrincipal.add(menuCadastro);
        menuBarPrincipal.add(menuOperacao);
        menuBarPrincipal.add(menuConsulta);
        menuBarPrincipal.add(menuSistema);
        menuBarPrincipal.add(menuAjuda);
         
    }
    
    public void inicializa(){
        
        menuItemMontadora.addActionListener(this);
        menuItemModelo.addActionListener(this);
        menuItemCategoria.addActionListener(this);
        menuItemCombustivel.addActionListener(this);
        menuItemVeiculo.addActionListener(this);
        menuItemCliente.addActionListener(this);
        menuItemUsuario.addActionListener(this);
        menuItemLocacao.addActionListener(this);
        menuItemDevolucao.addActionListener(this);
        menuItemBaixa.addActionListener(this);
        menuItemLocacaoCon.addActionListener(this);
        menuItemInformacoes.addActionListener(this);
        menuItemReiniciar.addActionListener(this);
        menuItemSair.addActionListener(this);
        menuItemAjuda.addActionListener(this);
        menuItemSobre.addActionListener(this);
        
        this.setTitle("LocaMobil");
        this.setJMenuBar(this.getMenuBarPrincipal());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(jDesktopPane, BorderLayout.CENTER);
        this.getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        Dimension dimension = this.getSize();
        PrincipalDimensao.setHeight(dimension.getHeight());
        PrincipalDimensao.setWidth(dimension.getWidth()); 
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource().equals(menuItemMontadora)){
            MontadoraView montadoraView = new MontadoraView();
            montadoraView.inicializa();
            jDesktopPane.add(montadoraView.getFrame());
        }
        else if(evento.getSource().equals(menuItemModelo)){
            ModeloView modeloView = new ModeloView();
            modeloView.inicializa();
            jDesktopPane.add(modeloView.getFrame()); 
        }
        else if(evento.getSource().equals(menuItemCategoria)){
            CategoriaView categoriaView = new CategoriaView();
            categoriaView.inicializa();
            jDesktopPane.add(categoriaView.getFrame());
        }
        else if(evento.getSource().equals(menuItemCombustivel)){
            CombustivelView combustivelView = new CombustivelView();
            combustivelView.inicializa();
            jDesktopPane.add(combustivelView.getFrame());
        }
        else if(evento.getSource().equals(menuItemVeiculo)){
            VeiculoView veiculoView = new VeiculoView();
            veiculoView.inicializa();
            jDesktopPane.add(veiculoView.getFrame());
        }
        else if(evento.getSource().equals(menuItemCliente)){
            ClienteView clienteView = new ClienteView();
            clienteView.inicializa();
            jDesktopPane.add(clienteView.getFrame());
        }
        else if(evento.getSource().equals(menuItemUsuario)){
            if(UsuarioLogado.isAdminstrador()){
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.inicializa();
                jDesktopPane.add(usuarioView.getFrame());
            }
            else{
                Mensagens.mensagemAviso("Voce não tem permissão para acessar esta funcionalidade!", "Acesso Negado");
            }
        }
        else if(evento.getSource().equals(menuItemLocacao)){
            
        }
        else if(evento.getSource().equals(menuItemDevolucao)){
            
        }
        else if(evento.getSource().equals(menuItemBaixa)){
            
        }
        else if(evento.getSource().equals(menuItemLocacaoCon)){
            
        }
        else if(evento.getSource().equals(menuItemInformacoes)){
            
        }
        else if(evento.getSource().equals(menuItemReiniciar)){   
            LoginView loginView = new LoginView();
            loginView.inicializa();
            UsuarioLogado.setLoginUsuario("");
            UsuarioLogado.setNomeUsuario("");
            UsuarioLogado.setAdminstrador(false);
            this.dispose();  
        }
        else if(evento.getSource().equals(menuItemSair)){
            
            System.exit(0);
            
        }
        else if(evento.getSource().equals(menuItemAjuda)){
        
        }
        else if(evento.getSource().equals(menuItemSobre)){
        
        }
        
        
    }
    
}
