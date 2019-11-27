package Basic;

import Basic.ABC;

/**
 * Created by yuehu on 6/4/19.
 */
public class XYZ extends ABC {

    public void myMethod(){
        System.out.println("XYZ Overriding Method");
    }
    public static void main(String args[]){
        ABC obj = new ABC();
        obj.myMethod();
    }
}
