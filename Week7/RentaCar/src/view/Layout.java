package view;

import core.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Layout extends JFrame {
    public void guiInitilaze(int width , int height){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent a Car ");
        this.setSize(width,height);
        this.setLocation(Helper.getLocation("x", this.getSize()), Helper.getLocation("y", this.getSize()));
        this.setVisible(true);
    }

    public void creatTable (DefaultTableModel model , JTable table, Object[] colums, ArrayList<Object[]>rows){
        model.setColumnIdentifiers(colums);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        if (rows == null){
            rows = new ArrayList<>();
        }
        for (Object[] row : rows ){
            model.addRow(row);
        }

    }

        public int getTableSelectedRow(JTable table, int index){
            return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());
        }

}
