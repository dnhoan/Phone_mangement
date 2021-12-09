/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Services;

import DAL.Models.NhanVienModel;

/**
 *
 * @author ADMIN
 */
public class AuthService {
     public static NhanVienModel user =  null;
    public static void clear(){
        AuthService.user = null;
    }
    public static boolean isLogin(){
        return AuthService.user != null;
    }
    public static boolean isManager(){
        return AuthService.isLogin()&&user.isVaiTro();
    }
}
