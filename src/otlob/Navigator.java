/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author PC
 */
public class Navigator {
    private int page;
    private String type;
    private int typeId;
    private NavigatorOption[] options = new NavigatorOption[10];
    private int optionsSize;
    private String Message = "-----Choose an option-----";
    public void Navigator(){
        this.page = 1;
        this.type = "2";
        this.typeId = 0;
    }
    public void getOptions(){
        if(type == "1" /*Home*/){
            if(true /*checkLogin*/){
                optionsSize = 4;
                options[0].setOption("Sign Out",-1);
                options[1].setOption("View Restaurants",6);
                options[2].setOption("View order history",7);
                options[3].setOption("Track order",8);            
            }else{
                optionsSize = 5;
                options[0].setOption("Login",2);
                options[1].setOption("Sign Up",3);
                options[2].setOption("Admin login",4);
                options[3].setOption("Admin SignUp",5);            
                options[4].setOption("View Restaurants",6);
            }
        }

        else if(type == "2"/*Login*/){
            //Login code here
        }
        
        else if(type == "6"/*View Restaurant*/){
            //get options from the files 
            //example: if you want to get restaurants available get restaurant name and id from files
            //restaurant option = 61
            
        }
    }
    public void display(){
        for(int i = 0; i<optionsSize; i++){
            System.out.println((i+1) + "- " + options[i].toString().split("\\,",-1)[0]);
        }
    }
    public void navigate(int option){
        type = options[option].toString().split("\\,",-1)[1];
        getOptions();
        display();
    }
}
