import business.UserManager;

import view.AdminVie;
import view.LoginView;

public class App {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        AdminVie adminVie = new AdminVie(userManager.findByLogin("admin","1234"));
       // LoginView loginView = new LoginView();
    }
}