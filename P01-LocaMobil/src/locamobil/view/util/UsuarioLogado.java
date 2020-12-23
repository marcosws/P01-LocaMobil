/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.view.util;

/**
 *
 * @author Marcos
 */
public class UsuarioLogado {
    
    private static String nomeUsuario;
    private static String loginUsuario;
    private static boolean adminstrador;

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nomeUsuario) {
        UsuarioLogado.nomeUsuario = nomeUsuario;
    }

    public static String getLoginUsuario() {
        return loginUsuario;
    }

    public static void setLoginUsuario(String loginUsuario) {
        UsuarioLogado.loginUsuario = loginUsuario;
    }

    public static boolean isAdminstrador() {
        return adminstrador;
    }

    public static void setAdminstrador(boolean adminstrador) {
        UsuarioLogado.adminstrador = adminstrador;
    }
    
    
    
}
