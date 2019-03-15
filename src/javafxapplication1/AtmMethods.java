package javafxapplication1;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Maaak 035564224
 */



    /**
     *
     * @author Maaak 035564224
     */
    public class AtmMethods {

      
        private int  moneyinbalance=0;
        public int amountadded ;
        int i=0 ;
        public AtmMethods atmLogic ;
        public JavaFXApplication1 gui ;
      // String[]  history =new String[i] ; 
       //int k = 5 ;
      
  
        public double  withdrawl(int amountofwithdrawl) {
     
        /*  for(i=0;i<4;i++)
            {history[i]=history[i+1] ; 
             i++ ;
                    }
        
           history[4]="withdraw:"+ amountofwithdrawl ;
           k=5; */
         
             if(amountofwithdrawl>moneyinbalance)  
             {  System.out.println(" insufficient fund");}
            else 
             {   moneyinbalance=(moneyinbalance-amountofwithdrawl); }
          
           return(moneyinbalance-amountofwithdrawl); 
      
            }
   public double deposit(int amountadded) {       
             /*   for(i=0;i<4;i++)
                 {  history[i]=history[i+1];
                     i++;}
       
                 
                    history[4] = "deposit: " + amountadded ;   
                    k=5; */
   
              moneyinbalance = amountadded + moneyinbalance ; 
                  return(moneyinbalance);
        }

       float Balanceinquiery() {
           
                /* for(i=0;i<4;i++)    
                 { history[i] = history[i+1];
                   i++ ;
                 }
                   history[4]= "Balanceinquiery: " ; 
                   k=5 ;*/

       return moneyinbalance ;
               
           }
  /* public String previous (){
         k-- ; 
     if(i>0)
         return (history[k]) ;
     else 
         return null ;
     
     }
     public String next () {
         k++ ;
     if(i<4)
         return (history[k]);
     else
         return null ;
     
     }*/
   
    }

