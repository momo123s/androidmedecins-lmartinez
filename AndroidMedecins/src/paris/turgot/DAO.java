/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paris.turgot;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author lmartinez
 */
public class DAO {
        private static final String url = "http://gaemedecins.appspot.com/Controleur/medParDep/listeDep";
        private static final String url2 = "http://gaemedecins.appspot.com/Controleur/medParDep/listeMed/";
        
    public static List<String> getLesDeps(){
        List<String>lesDeps = new ArrayList<String>();
        try {
            
            URL myURL = new URL(url);
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(myURL.openStream());
            org.w3c.dom.Element racine = doc.getDocumentElement();
            NodeList listeDep = racine.getElementsByTagName("Departement");
            for (int i = 0; i < listeDep.getLength(); i++) {
                Node medecin = listeDep.item(i);
                NodeList lesProprietes = medecin.getChildNodes();
                for (int j = 0;j< lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("num")) {
                        lesDeps.add(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDeps;
    }    
    public static List<String> getLesMeds(String dep) {
        List<String> lesNoms = new ArrayList<String>();
        try {
            
            URL myURL = new URL(url2 + dep);
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(myURL.openStream());
            org.w3c.dom.Element racine = doc.getDocumentElement();
            NodeList listeMed = racine.getElementsByTagName("Medecin");
            for (int i = 0; i < listeMed.getLength(); i++) {
                Node medecin = listeMed.item(i);
                NodeList lesProprietes = medecin.getChildNodes();
                for (int j = 0;j< lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("nom")) {
                        lesNoms.add(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesNoms;

    }
    public static List<String> getLesNoms95() {
        List<String> lesNoms = new ArrayList<String>();
        try {
            
            URL myURL = new URL(url3);
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(myURL.openStream());
            org.w3c.dom.Element racine = doc.getDocumentElement();
            NodeList listeMed = racine.getElementsByTagName("Medecin");
            for (int i = 0; i < listeMed.getLength(); i++) {
                Node medecin = listeMed.item(i);
                NodeList lesProprietes = medecin.getChildNodes();
                for (int j = 0;j< lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("nom")) {
                        lesNoms.add(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesNoms;

    }
    
}
