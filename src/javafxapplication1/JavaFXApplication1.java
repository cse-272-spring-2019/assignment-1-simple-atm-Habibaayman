/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label ;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 *
 * @author Maaak 035564224
 */
public class JavaFXApplication1  extends Application implements EventHandler <ActionEvent> {
 
public AtmMethods atmLogic ;

 public   int CardNumber;
 private  int moneyinbalance ;
 int amountofwithdrawl ;
 int amountadded ;
 int i ;
 String[]  history =new String[i] ; 
 int counter;

 
    @Override
    public void start(Stage primaryStage) {
     // layout 1
      atmLogic = new AtmMethods();
      primaryStage.setTitle("ATM");
      GridPane atm = new GridPane() ;
      GridPane atm2 = new GridPane() ;
      GridPane atm3 = new GridPane();
      GridPane atm4 = new GridPane();
      GridPane atm5 = new GridPane(); 
      Scene scene1 = new Scene (atm,700,700) ;
      Scene scene2 = new Scene(atm2,700,700); 
      Scene scene3 = new Scene(atm3,700,700); 
      Scene scene4 = new Scene(atm4,700,700);
      Scene scene5 = new Scene(atm5,700,700);
      atm.setAlignment(Pos.CENTER) ; 
      atm.setVgap(20);
      atm.setHgap(20);
      atm.setPadding(new Insets(5));
 
      
      Text welcometxt = new Text("Welcome!") ;
      atm.add(welcometxt,0,1);
      welcometxt.setFont(Font.font("tahoma",FontWeight.BOLD,40)) ;
      Label lblCard = new Label ( "Card number:") ;
      atm.add(lblCard,0,3);
      lblCard.setFont(Font.font("tahoma",FontWeight.LIGHT,25)) ;
      TextField txtCard = new TextField() ;
      txtCard.setPromptText("Card number ");
      txtCard.setOnAction(e->{
      if( txtCard.getText().equals("5942"))
      {  System.out.println(" valid card number ");
         primaryStage.setScene(scene2) ; 
      }
      else 
          System.out.println("invalid card number");
      } );
      atm.add(txtCard,1,3);
   
     Button v = new Button ("Next") ;
     v.setOnAction(e->{
          if(txtCard.getText().equals("5942"))
          {  primaryStage.setScene(scene2);
            System.out.println("valid card number");
          }
          else 
              primaryStage.setScene(scene1) ;  
                     });
     atm.add(v,2,6) ;     
     primaryStage.setScene(scene1) ;  
    //===================================================================================================================//
   //layout2
      GridPane layout2 = new  GridPane() ;
      layout2.setAlignment(Pos.CENTER_LEFT) ; 
      layout2.setVgap(90);
      layout2.setHgap(90);
      layout2.setPadding(new Insets(10));
 //===========================================================================   
       Text withdrawtxt =new Text("please enter the amount you want to withdrawl:");
       withdrawtxt.setFont(Font.font("tahoma",FontWeight.LIGHT,20)) ;
       atm3.add(withdrawtxt,1,1);
       javafx.scene.control.TextField txtamountofwithdrawl = new javafx.scene.control.TextField("Amount of withdrawl:") ;
       txtamountofwithdrawl.setText("Amount of withdrawl:") ;
       atm3.add(txtamountofwithdrawl,1,3);
       Button btn = new Button ("withdrawl") ;
       atm2.add(btn,0,0);
       btn.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
       btn.setOnAction( e ->{   primaryStage.setScene(scene3) ;});
       Button u = new Button("withdraw");
       atm3.add(u, 0, 0);
       u.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
       u.setOnAction(e->{
       double balance = atmLogic.withdrawl(amountofwithdrawl);
       String PrintBalance = String.valueOf(balance);
       //  txtamountofwithdrawl.setText(PrintBalance) ;
         System.out.println(atmLogic.withdrawl(Integer.parseInt(txtamountofwithdrawl.getText())));
       
        });
       
       Button previous = new Button (" Back ");
       previous.setOnAction(e->{
       primaryStage.setScene(scene2);
       });
       atm3.add(previous,3,80);
 //==================================================================================================  
       Text deposittxt =new Text("please enter the amount you want you will deposit:");
       deposittxt.setFont(Font.font("tahoma",FontWeight.LIGHT,20)) ;
       atm4.add(deposittxt,1,1);
       javafx.scene.control.TextField txtamountadded = new javafx.scene.control.TextField("Amount of deposit") ; 
       txtamountadded.setText("Amount of deposit :");
        atm4.add(txtamountadded,1,3);
        Button button = new Button ("deposit ") ;
        button.setOnAction ( e ->primaryStage.setScene(scene4) ) ;
        atm2.add(button,0,50);
        button.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
       Button m = new Button("deposit");
       atm4.add(m, 0, 0);
       m.setOnAction(e->{
       
       double balance = atmLogic.deposit(amountadded);
       String PrintBalance = String.valueOf(balance);
       System.out.println(atmLogic.deposit(Integer.parseInt(txtamountadded.getText())));
       
       });
       
    //   txtamountadded.setOnAction(e->  {System.out.println(atmLogic.deposit(Integer.parseInt(txtamountadded.getText())));});
      
       Button l = new Button ("Back");
       l.setOnAction(e->{ 
        primaryStage.setScene(scene2);
       });
       atm4.add(l,1,90);
      
  //======================================================================================   
      Label lblbalance = new Label("balance");
      Button bt = new Button ("balance inquiry:") ;
     
     bt.setOnAction(new EventHandler<ActionEvent>(){
         public void handle (ActionEvent event )
         {  
         
         double balance = atmLogic.Balanceinquiery();
         String PrintBalance = String.valueOf(balance);
         lblbalance.setText(PrintBalance) ;
         }
     });

     atm2.add(bt,0,100);
     atm2.add(lblbalance,2,100);
     Label lblyourbalance = new Label ("Aount's Balance: ");
    
     bt.setFont(Font.font("tahoma",FontWeight.MEDIUM,20)) ;
     Button x = new Button ("previous ") ;
     x.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
     x.setOnAction(e->primaryStage.setScene(scene1)) ; 
     atm2.add(x,0,200);
 //=================================================================================
   /*  Label lblprevious =new Label  ("previous");
     atm2.add(lblprevious,0,601);
  Button pre = new Button ("previous transaction") ; 
     pre.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
     pre.setOnAction(e->{
        String f = atmLogic.previous();
         if(!"null".equals(f))
       lblprevious.setText(f);
         else 
        lblprevious.setText("no more transactions");
   
     });
  
     atm2.add(pre ,0,600);
     Label lblnext = new Label ("next") ; 
     atm2.add(lblnext,0,605) ;
     Button op = new Button ("next transaction ");
     op.setFont(Font.font("tahoma",FontWeight.MEDIUM,20));
     op.setOnAction(e->{ 
         String f= atmLogic.next();
         if(!"null".equals(f))
         lblnext.setText(f) ; 
     });
     
     atm2.add(op,700,600);*/
    
     primaryStage.show();
    }
    //==========================================================================
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
