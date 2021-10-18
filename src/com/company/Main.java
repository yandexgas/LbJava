package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       System.out.print("1 - put\n2-get\n3-remove\n4-size\n 5-put val to index \n 6-set val to index \n7-contains val\n8-print all\n 0- to test Map");
       int i = 1;
        Scanner in = new Scanner(System.in);
       List l=new List();
       l.remove(0);
       while (i>0&&i<9){
        i = in.nextInt();
        switch (i) {
            case 1:
            {
                i = in.nextInt();
                l.add(i);
            }
                break;
            case 2:
            {
               i=in.nextInt();
               System.out.println(l.get(i));
            }
                break;
            case 3:
            {
                i=in.nextInt();
                System.out.println(l.remove(i));
            }
                break;
            case 4:
            {
                System.out.println(l.size());
            }
                break;
            case 5:
            {
                i=in.nextInt();
                int c = in.nextInt();
                l.add(i,c);
            }
                break;
            case 6:
            {
                i=in.nextInt();
                int c = in.nextInt();
                System.out.println(l.set(i,c));
            }
                break;
            case 7:
            {
                i=in.nextInt();
                System.out.println(l.indexOf(i));
            }
                break;
            case 8:
            {
                for(int z=0;z<l.size();z++)
                    System.out.println(l.get(z));
            }
                break;
        }
    }
        System.out.print("1 - put\n2-get\n3-get def\n4-remove\n 5-key contains \n 6-size \n7-print keys\n8-print val\n 0- end");
        Map m=new Map(3);
       i=1;
       String v="";
        while (i>0&&i<9){
            i = in.nextInt();
            switch (i) {
                case 1:
                {
                    i = in.nextInt();
                    v=in.next();
                   m.put(i,v);
                }
                break;
                case 2:
                {
                    i=in.nextInt();
                    System.out.println(m.get(i));
                }
                break;
                case 3:
                {
                    i=in.nextInt();
                    System.out.println(m.get(i,"default"));
                }
                break;
                case 4:
                {
                    i=in.nextInt();
                    System.out.println(m.remove(i));
                }
                break;
                case 5:
                {
                    i=in.nextInt();
                    System.out.println(m.keyContains(i));
                }
                break;
                case 6:
                {
                    System.out.println(m.size());
                }
                break;
                case 7:
                {
                    List li = m.getKeys();
                    for(int z=0;z<li.size();z++)
                        System.out.println(li.get(z));
                }
                break;
                case 8:
                {
                    List li = m.getValues();
                    for(int z=0;z<li.size();z++)
                        System.out.println(li.get(z));
                }
                break;
            }
            i=1;
        }
 }
}
