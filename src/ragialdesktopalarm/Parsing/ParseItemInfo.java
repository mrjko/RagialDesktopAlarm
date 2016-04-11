/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragialdesktopalarm.Parsing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author jko
 */
public class ParseItemInfo {
    
    int acc = 99999999;
    public String lowestPrice = "None";
    
    public ParseItemInfo(String url){
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla, Chrome").timeout(300000).get();
            Elements dates = doc.select("#date");
            for (int i = 0; i < dates.size(); i ++ ){
                
                if (dates.get(i).text().equals("Vending Now")){
                    Elements pc = doc.select("#pc");
                    if (convertToInteger(pc.get(i).text()) < acc){
                        acc = convertToInteger(pc.get(i).text());
                        lowestPrice = pc.get(i).text();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParseItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int convertToInteger(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c != ',' && c != 'z'){
                result = result + c;
            }
        }
        return Integer.parseInt(result);
    }
    
}
