/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locamobil.global.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Marcos
 */
public class Criptografia {
    
    public String hashSHA512(String valor){
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.reset();
            messageDigest.update(valor.getBytes("utf8"));
            return String.format("%0128x", new BigInteger(1, messageDigest.digest()));
        } 
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Mensagens.mensagemErro("Erro: " + e.getMessage(), this.getClass().getSimpleName());
        }
        return "";
        
    }
    
}
