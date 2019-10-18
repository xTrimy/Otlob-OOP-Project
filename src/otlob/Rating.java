/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author AdhamHamzawy
 */
public class Rating {
  
    protected String rateid;
    protected int delevarytime; //inseconds
    protected double money;  
    protected int foodQuality;
    protected String msg;
   
    public Rating (String rateid,int delevarytime ,double money,int foodQuality,String msg )
    {
        this.rateid=" ";
        this.delevarytime=delevarytime;
        this.money=money;
        this.foodQuality=foodQuality;
        this.msg=msg;
    }
   public String getrateid()
   {
   return rateid;
   }
   public void setrateid(String rateid)
   {
    this.rateid=" ";
   }
   
   public int getdelevarytime()
   {
       return delevarytime;
   }
   public void setdelevarytime(int delevarytime){
   this.delevarytime=delevarytime;   
   }
   
   public double getmoney(){
   return money;
   }
   public void setmoney(double money)
   {
       this.money=money;
   }
   
   public int getfoodQuality()
   {
       return foodQuality;
   }
   public void setfoodQuality(int getfoodQuality)
   {
       this.foodQuality = foodQuality;
   }
   public String getmsg(){
       return msg;
   }
   public void setmsg(String msg)
   {
       this.msg=msg;
   }
   
   
}
