package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
      String str, result;
      Map dict=new Map();
      Scanner cin=new Scanner(System.in);
      str=cin.nextLine();
      int i=0;
      while (i<str.length()){
          int k=str.indexOf(" ",i);
            if(k>i||k<0){
                k=k>0?k:str.length();
                result=str.substring(i,k);
                if(dict.get(result)!=null){
                    dict.put(result,(int)dict.get(result)+1);
                }
                else dict.put(result,1);
                i=k+1;
            }
            else {
                ++i;
                continue;
            }
      }
      List nodes=dict.getEntries();
      for(int iter=0;iter<nodes.size();++iter)
          System.out.println((String)((Pair)nodes.get(iter)).first + " : " +((Pair)nodes.get(iter)).second.toString());
   }
}
