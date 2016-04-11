/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragialdesktopalarm;

import java.util.*;

/**
 *
 * @author jko
 */
public class ROItems {
    
    public List<ROItem> items = new ArrayList<ROItem>();
    
    
    public ROItems(){
    }
    
    public List<ROItem> getVendingItems(){
        return this.items;
    }
    
    public int getTotalQuantity(){
        int counter = 0;
        for (int i = 0; i < this.items.size(); i++){
            counter += this.items.get(i).getQuantityInteger();
        }
        return counter;
    }
   public int getSize(){
       return items.size();
   }
   public ROItem get(int i ){
       return items.get(i);
   }
}
