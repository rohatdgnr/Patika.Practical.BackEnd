package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout {
    private JPanel contanier;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_button;
    private JTextField fld_username;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private JLabel lbl_pass;
    private final UserManager userManager;

    public LoginView(){
        this.userManager= new UserManager();

        this.add(contanier);

        this.guiInitilaze(400,400);
        btn_login.addActionListener(e -> {
        if(Helper.isFielEmpty(this.fld_username)){
           Helper.showMsg("fill");
        } if(Helper.isFielEmpty(this.fld_pass)){
               Helper.showMsg("fill");
            }else{
            User loginUser = this.userManager.findByLogin(this.fld_username.getText(),this.fld_pass.getText());
            if (loginUser == null) {
                Helper.showMsg("notFound");
            }else{
                loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_pass.getText());
          if (loginUser== null){
              Helper.showMsg("notfound");
          }else{
              AdminVie adminVie = new AdminVie(loginUser);
              dispose();
          }
            }
            }

    });
}
}