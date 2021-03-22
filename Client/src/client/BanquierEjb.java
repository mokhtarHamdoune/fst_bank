package client;
   
import com.fstbank.entity.Client;
import com.fstbank.entity.ClientParticulier;
import com.fstbank.entity.Compte;
import com.fstbank.entity.ComptePartage;
import com.fstbank.entity.ComptePrive;
import com.fstbank.session.BanquierSessionRemote;
import fabrique.FabriqueClient;
import fabrique.FabriqueCompte;
import fabrique.FabriqueComptePrive;
import fabrique.FabriqueParticulier;
import fabrique.FabriqueProfessionnel;
import fabrique.FarbriqueComptePartage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;    
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Set;
public class BanquierEjb {
   ChercherStrategy strategy;
   BufferedReader brConsoleReader = null; 
   Properties props;
   
   InitialContext ctx;
   {
      props = new Properties();
      try {
         props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      try {
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   
   public static void main(String[] args) {

      BanquierEjb ejbTester = new BanquierEjb();

      ejbTester.testEntityEjb();
   }
   
   private void showGUI() {
      System.out.println("**********************");
      System.out.println("Welcome to FST Bank");
      System.out.println("**********************");
      System.out.print("Options \n1. Creer Un nouveau Client Particlulier\n");
      System.out.print("2. Creer Un nouveau Client Professionel\n");
      System.out.print("3. Creer Un nouveau Compte Prive\n");
      System.out.print("4. Creer Un nouveau Compte Partager\n");
      System.out.print("5. Consulter Un Compte prive\n");
      System.out.print("6. Consulter Un Compte partager\n");
      System.out.print("7. Chercher Un Compte Professionel \n");
      System.out.print("8. Exit \n");
      System.out.print("Entrer le choix:");
   }
   private void setStratety(ChercherStrategy strategy){
       this.strategy=strategy;
   }
   
   private void testEntityEjb() {

      try {
         int choice = 1; 

         BanquierSessionRemote Banquier =
         (BanquierSessionRemote)ctx.lookup("BanquierSession/remote");

         while (choice != 8) {
            FabriqueClient fc;
            FabriqueCompte fcp;
            Compte cp;
            Client c;
            showGUI();
            String strChoice = brConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);
            if (choice == 1) {
                fc = new FabriqueParticulier();
                c = fc.creeClient();
                Banquier.creeClien(c);
            }
            else if (choice == 2) {
                fc = new FabriqueProfessionnel();
                c = fc.creeClient();
                Banquier.creeClien(c);
            } 
            else if (choice == 3) {
               fcp = new FabriqueComptePrive();
               cp = fcp.creeCompte();
               Banquier.creeCompte(cp);
            } 
            else if (choice == 4) {
               fcp = new FarbriqueComptePartage();
               cp = fcp.creeCompte();
               Banquier.creeCompte(cp);
            }
            else if (choice ==5){
                System.out.print("Entrer l'id de Compte : ");
                int id = Integer.parseInt(brConsoleReader.readLine());
                ComptePrive cpri = Banquier.getComptePrive(id);
                System.out.println("Compte: id :"+cpri.getId()+" sold:"+cpri.getSolde());
            }
            else if (choice ==6){
                System.out.print("Entrer l'id de Compte : ");
                int id = Integer.parseInt(brConsoleReader.readLine());
                ComptePartage cpar = Banquier.getComptePartager(id);
                System.out.println("Compte: id :"+cpar.getId()+" sold:"+cpar.getSolde());
            }
            else if (choice == 7) {
                System.out.print("Options \n2.1. Chercher by id\n2.2. Chercher by coordonnées\nEntrer le choix: ");
                int searchChoice =Integer.parseInt(brConsoleReader.readLine());
                if(searchChoice == 1){
                    setStratety(new ChercherById());
                }else if(searchChoice == 2){
                    setStratety(new ChercherByCoord());
                }
                ClientParticulier cpar = strategy.chercherClien(Banquier);
                System.out.println("Client: id :"+cpar.getId()+" nom:"+cpar.getNom()+" prenom: "+cpar.getPrenom()+" date_nassiace: "+cpar.getDateNaissance());
            }else if(choice == 8){
                break;
            }
         }

         /*List<Book> booksList = libraryBean.getBooks();

         System.out.println("Book(s) entered so far: " + booksList.size());
         int i = 0;
         for (Book book:booksList) {
            System.out.println((i+1)+". " + book.getName());
            i++;
         }*/           
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }finally {
         try {
            if(brConsoleReader !=null) {
               brConsoleReader.close();
            }
         } catch (IOException ex) {
            System.out.println(ex.getMessage());
         }
      }
   }
}