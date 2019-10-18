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
public class InvoicesInbox extends Inbox {
    public Invoice[] invoicesList = new Invoice[1];
    public Invoice getInvoice(int costumerId){
        Invoice i = new Invoice();
        return i;
    }
    
    @Override
    public String readMessages(){
        String message = "";
        for(int i = 0; i<invoicesList.length; i++){
            message += invoicesList[i].getData();
            message += '\n';
        }
        return message;
    }
}
