/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import java.util.ArrayList;

public class Customer
{
    String name;
    String number;
    String email;
    String uid;
    String dough;
    String sauce;
    String toppings;

    public Customer()
    {
        name = "";
        number = "";
        email = "";
        uid = "";
        dough = "";
        sauce = "";
        toppings = "";
    }

    public Customer(String id, String newName, String num, String e, Pizza p)
    {
//        super(p.dough,p.sauce,p.toppings);
        name = newName;
        number = num;
        email = e;
        uid = id;

        dough = p.getDough();
        sauce = p.getSauce();
        toppings = p.getToppings();
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getUid()
    {
        return uid;
    }

    public String getEmail() { return email; }

    public String toString()
    {
        return number + "\n" + email + "\n\nPIZZA ORDER:\nDough: " + dough +
                "\nSauce: " + sauce + "\nToppings: " + toppings;
    }
}

