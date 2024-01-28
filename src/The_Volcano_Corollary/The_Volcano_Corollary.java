package The_Volcano_Corollary;
import java.util.Scanner;
public class The_Volcano_Corollary{
     public static final int SIZE= 10;
    public static int []Array1 =new int [SIZE];
    public static int []Array2= new int [SIZE];
    public static int maxvalue(){
 int maxint= Array1[0];
 for(int i=1; i<SIZE;i++){
     if(maxint<Array1[i])
         maxint=Array1[i];
 }
 return maxint;
}   
    public static int numberofvalue(int indexofmaxvalue){
        int count=0;
        for(int i=0; i<SIZE;i++){
            if(Array1[indexofmaxvalue]==Array1[i])
                count++;
        }
        return count;
    }
    public static int indexofvalue(int maxvalue){
        for(int i=0;i<SIZE;i++){
            if(Array1[i]==maxvalue)
                return i;
        }
        return 0;
    }
    public static int lastindexofvalue(int value){
        for(int i=SIZE-1;i>-1;i-- ){
            if(Array1[i]==value)
                return i;
             }
        return 0;
    }
    public static int [] converterarray(int beginvalueindex,int lastvalueindex){
        int a=Array1[beginvalueindex];
        int b=Array1[lastvalueindex];
        if(a>=b){
            while(lastvalueindex>beginvalueindex &&b>=Array1[lastvalueindex]){
                Array1[lastvalueindex]=b;
                lastvalueindex--;
            }
            while(beginvalueindex>lastvalueindex && b>=Array1[lastvalueindex]){
                Array1[lastvalueindex]=b;
                lastvalueindex++;
            }
            
        }else{
             while(lastvalueindex<beginvalueindex &&a>=Array1[beginvalueindex]){
                Array1[beginvalueindex]=a;
                beginvalueindex--;
            }
        }
   
        return Array1;
    }
    public static int lastofmaxvalue(int maxvalue){
        for(int i=maxvalue-1;i>0;i--){
            for(int j=0;j<SIZE;j++){
                if(Array1[j]==i)
                    return Array1[j];
            }
        }
        return 0;
    }    
    public static void result(){
        int sumfirstrock=0;
        int sumrockandlava=0;
        for(int i=0;i<SIZE;i++){
            sumrockandlava += Array1[i];
        }
        for(int i=0;i<SIZE;i++){
            sumfirstrock+=Array2[i];
        }
        System.out.println("There can be maximum observable amount of hot lava is (in cells): "+(sumrockandlava-sumfirstrock));
    }
    public static void main(String[] args){
        Scanner inp= new Scanner(System.in);
        System.out.print("Enter 10 numbers representing the rock formations in the valley: ");
    for(int i=0; i<SIZE;i++){
        Array1[i]=inp.nextInt();
        Array2[i]=Array1[i];
    }
    int a= maxvalue();
    int lastvalue=0;
    int a1=a;
    while(a1!=0){  
    int b= indexofvalue(a);
    int c= numberofvalue(b);
    int d= lastofmaxvalue(a); 
    lastvalue=indexofvalue(d);
         Array1 = converterarray(b,lastvalue);
          if(c>1){
            lastvalue= lastindexofvalue(a);
            Array1 = converterarray(b,lastvalue);
            }
    a=d;
    a1--;
    }
    result();
    }
}