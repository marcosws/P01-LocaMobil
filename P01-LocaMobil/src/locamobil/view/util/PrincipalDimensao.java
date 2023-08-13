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
public class PrincipalDimensao {
    
    private static double width;
    private static double height;

    public static double getWidth() {
        return width;
    }
    public static void setWidth(double width) {
        PrincipalDimensao.width = Math.abs(width - 18);
    }
    public static double getHeight() {
        return height;
    }
    public static void setHeight(double height) {
        PrincipalDimensao.height = Math.abs(height - 82);
    }
    
}
