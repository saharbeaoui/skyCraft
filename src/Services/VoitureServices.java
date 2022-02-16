/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Voiture;
import Connexion.Skycraft;
import tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VoitureServices {
    Connection mc;
    PreparedStatement ste;

    public VoitureServices() {
        mc=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterClient(Voiture V){
        String sql ="insert into voiture(marque,matricule,couleur) Values(?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, V.getMarque());
            ste.setString(2, V.getMatricule());
            ste.setString(3, V.getCouoleur());
            
            ste.executeUpdate();
            System.out.println("voiture ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Voiture> afficherPersonne(){
        List<Voiture> voitures = new ArrayList<>();
        String sql="select * from voiture";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Voiture v = new Voiture();
                v.setId(rs.getInt("id"));
                v.setMarque(rs.getString("marque"));
                v.setMatricule(rs.getString("matricule"));
                v.setCouoleur(rs.getString("couleur"));

                voitures.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return voitures;
    }    
}
