/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragialdesktopalarm.Parsing;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ragialdesktopalarm.ROItem;
import ragialdesktopalarm.ROItems;
/**
 *
 * @author jko
 */
public class ParseVendingItems  {
    
    public static StringBuffer sb = new StringBuffer();
    private ROItems itemList = new ROItems();

    public ParseVendingItems(){
        try {
            String url = ParseCharacterURL.sb.toString();
            if (url.equals("noshop")){
                JOptionPane.showMessageDialog(null, "Can not find a vending merchant with the given information.", "Alert!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Document doc = Jsoup.connect(url).userAgent("Mozilla, Chrome").timeout(300000).get();
            Elements prices = doc.getElementsByClass("price");
            Elements amounts = doc.getElementsByClass("amt");
            Elements names = doc.getElementsByClass("name");

            for (int i =0 ; i < names.size(); i++){
                // need to find a better way of getting ahref, NOT using substrings...
                Element link = names.get(i);
                String absHref= link.toString().substring(26, 73);    
         //       System.out.println(absHref);
                ROItem item = new ROItem(names.get(i).text(), prices.get(i).text(), amounts.get(i).text(), absHref);
                this.itemList.items.add(item);
            }
                           
        } catch (IOException ex) {
            Logger.getLogger(ParseVendingItems.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public ROItems getItemList(){
        return this.itemList;
    }
    
    
}
