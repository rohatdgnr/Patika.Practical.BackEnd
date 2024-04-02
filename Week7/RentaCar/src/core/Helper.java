package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void showMsg(String str ){
        optionPaneTR();
        String msg ;
        String title = switch (str) {
            case "fill" -> {
                msg = " Lütfen tüm Alanları Doldurunuz ";
                yield " HATA";
            }
            case "done" -> {
                msg = " işlem bas ";
                yield " sonuc";
            }
            case "notFound" -> {
                msg = " Kayıt Bulunamadı";
                yield " Bulunamadı";
            }
            case "error" -> {
                msg = " Hatalı İşlem Yaptınız";
                yield " HATA!!";
            }
            default -> {
                msg = str;
                yield "MESAJ";
            }
        };
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str){
        optionPaneTR();
        String msg;
        if (str.equals("sure")) {
            msg = " Bu İşlemi Yapmak İstediğine Emin misin ? ";
        }else {
            msg = str ;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Emin misin ?",JOptionPane.YES_NO_OPTION)==0;

    }

    public static boolean isFielEmpty(JTextField field){

        return field.getText().trim().isEmpty();
    }

   public static int getLocation(String type , Dimension size ){
        switch (type){
            case "x":
                return (Toolkit.getDefaultToolkit().getScreenSize().width-size.width)/2;
            case "y":
                return (Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2;
            default:
                return 0;
        }
    }

    public static void optionPaneTR(){
        UIManager.put(" OptionaPane.okButtonText", "Tamam");
        UIManager.put(" OptionaPane.noButtonText", "Hayır");
        UIManager.put(" OptionaPane.yesButtonText", "Evet");
    }
}
