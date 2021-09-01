/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import java.util.ArrayList;

public class Pizza
{
    String dough;
    String sauce;
    String toppings;

    public Pizza()
    {
        dough = "";
        sauce = "";
        toppings = "";
    }

    public Pizza(String d, String s, String t)
    {
        dough = d;
        sauce = s;
        toppings = t;
    }

    public String getDough()
    {
        return dough;
    }

    public String getSauce()
    {
        return sauce;
    }

    public String getToppings()
    {
        return toppings;
    }

//    public void setDough(String d){
//        dough = d;
//    }

//    public String toString()
//    {
//        int i;
//        String temp =  "Dough: " + dough + "; Sauce: " + sauce + "; Toppings: " ;
////        for (i = 0; i < toppings.size() - 2; ++i)
////        {
////            temp += toppings.get(i) + ", ";
////        }
////        temp += toppings.get(i);
//        return temp;
//    }
}
