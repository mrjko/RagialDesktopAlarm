/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragialdesktopalarm.Parsing;

import ragialdesktopalarm.Forms.AlarmForm;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jko
 */
public class ParseCharacterURL {
    
    public static StringBuffer sb = new StringBuffer();
    
    
    public ParseCharacterURL(){
        try {
         //   System.out.println(AlarmForm.getDatabaseURL());
            Document doc = Jsoup.connect(AlarmForm.getDatabaseURL()).userAgent("Mozilla, Chrome").timeout(30000).get();
      //      System.out.println(doc.body().text());
            Element link = doc.getElementsByClass("ragial").first();
            if (link == null){
                sb.delete(0, sb.length());
                sb.append("noshop");
            } else {
                String absHref = link.attr("abs:href");
                sb.delete(0, sb.length());
                sb.append(absHref);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ParseCharacterURL.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println("Character's url is " + sb);
    }
    
}
