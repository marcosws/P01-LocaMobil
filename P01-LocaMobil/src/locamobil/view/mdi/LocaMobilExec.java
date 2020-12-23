/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.mdi;


/**
 *
 * @author Marcos
 */
public class LocaMobilExec {
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.inicializa();
        });
    
   //     UsuarioLogado.setAdminstrador(true);
   //     UsuarioService usuarioService = new UsuarioService();
   //     System.out.println("Valor: " + usuarioService.executaMensagemUsuario(Operacao.ALTERAR));
     
    // UsuarioDao usuarioDao = new UsuarioDao();
   //  Usuario usuario = new Usuario();
   //  usuario = usuarioDao.consultar("admin");
    // System.out.println("Ativo: " + usuario.isAtivo());
     
     
     // Montadora montadora = new Montadora();
     // montadora.setNomeMontadora("AUDI");
     // MontadoraDao montadoraDao = new MontadoraDao();
     // montadoraDao.incluir(montadora);
      
        
    }
    
}
