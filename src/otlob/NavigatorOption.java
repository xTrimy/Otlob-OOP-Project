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
public class NavigatorOption {
    protected String option;
    protected int type;    
    protected int typeId = 0;

    public void NavigatorOption(){}
    public void setOption(String option, int type){
        this.option = option;
        this.type = type;
    }
    public void setOption(String option, int type, int typeId){
        setOption(option,type);
        this.typeId = typeId;
    }
    @Override
    public String toString(){
        return String.format("%s,%s",option,type);
    }
}
