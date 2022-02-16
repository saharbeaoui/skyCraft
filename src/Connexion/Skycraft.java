/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Skycraft {
 static Connection cnx;
    static String url ="jdbc:mysql://localhost:3306/skycraft";
    static String user="root";
    static String pwd="";
    static Statement ste;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            try {
                cnx=DriverManager.getConnection(url, user, pwd);
                System.out.println("Connexion etablie");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
         //String sql="INSERT INTO `client`(`nom`, `prenom`, `num`, `adresse_mail`, `nationalite`) VALUES ('Ben foulen','foulen', '123', 'foulen@gmail.com', 'tunisienne')";
         ste=cnx.createStatement();
        //ste.executeUpdate(sql); // L'ajout d'un client
      //  System.out.println("Client ajouté");
      String sql="select * from client";
           ResultSet result=ste.executeQuery(sql);
           while(result.next()){
               int id =result.getInt("id_client");
               String nom=result.getString(2);
               String prenom= result.getString("prenom");
                int num=result.getInt(4);
               String adresse_mail= result.getString("adresse_mail");
               String nationalite= result.getString("nationalite");
               System.out.println("ID : "+id+"\nNom : "+nom+"\nPrenom : "+prenom+"\nNum : "+num+"\nAdresse_mail : "+adresse_mail+"\nNationnalite : "+nationalite);
               
           }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
