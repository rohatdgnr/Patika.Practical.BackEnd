package view;

import business.BrandManager;
import business.ModelManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminVie extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brandMenu;
    public AdminVie(User user){
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user = user;
        if (user == null){
            dispose();
        }

        this.lbl_welcome.setText(" Hoşgeldiniz :" + this.user.getUsername());

        loadBrandTable();
        loadBrandComponent();

        loadModelTable();

        this.tbl_brand.setComponentPopupMenu(brandMenu);
    }

    private void loadModelTable() {

       Object[] col_model =  {"Model ID", "Model Adı", "Tipi", " Yıl","Yakıt Türü","Vites"};
        ArrayList<Object[]>modelList = modelManager.getForTable(col_model.length,this.modelManager.findAll());
        creatTable(this.tmdl_model,this.tbl_model,col_model,modelList);

    }

    public void loadBrandComponent(){
        this.tbl_brand.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected_row = tbl_brand.rowAtPoint(e.getPoint());
                tbl_brand.setRowSelectionInterval(selected_row,selected_row);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.brandMenu= new JPopupMenu();
        this.brandMenu.add("Yeni").addActionListener(e -> {
            Brandview brandview = new Brandview(null);
            brandview.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Güncelle").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
            Brandview brandview = new Brandview(this.brandManager.getById(selectBrandId));
            brandview.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Sil").addActionListener(e ->{
            if (Helper.confirm("sure")){
            int selectBrandId =this.getTableSelectedRow(tbl_brand,0);
                if (this.brandManager.delete(selectBrandId)){
                    Helper.showMsg("done");
                    loadBrandTable();
                }else{
                    Helper.showMsg("error");
                }

            }
        });
    }

    public void loadBrandTable(){
        Object [] col_brand = {" Marka ID ", " Marka Adı"};
        ArrayList<Object[]>brandList = brandManager.getForTable(col_brand.length);
        this.creatTable(this.tmdl_brand,this.tbl_brand,col_brand,brandList);
    }
}
