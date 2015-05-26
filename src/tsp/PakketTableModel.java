/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dion
 */
public class PakketTableModel extends AbstractTableModel {
    private List<String> data1;
    private List<String> data2;
    protected List<String> colNames;

    
    PakketTableModel(List data1, List data2, List colNames) {
       if(colNames.size() < 2) {
           throw new IllegalArgumentException("kolomnamen moet 3 zijn!");
       }
       this.data1 = data1;
       this.data2 = data2;
       this.colNames = colNames;
       
    }

    @Override
    public int getColumnCount() {
        return colNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if(columnIndex == 0 || columnIndex == 1){
                if(columnIndex == 0){
                    return data1.get(rowIndex);
                }else {
                    return data2.get(rowIndex);
                }
            }else{
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        
        return colNames.get(column);
    }

    @Override
    public int getRowCount() {
        return data1.size();
    }
}