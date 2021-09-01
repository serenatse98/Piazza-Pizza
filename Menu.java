/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = (ListView)findViewById(R.id.menuList);
        list.add("\n BUILD YOUR OWN PIZZA! \n\n" +
                "Step 1: Choose your dough\n" +
                "     Classic or Gluten Free" +
                "\n\nStep 2: Choose your sauce\n" +
                "     Red, White, or Basil Pesto" +
                "\n\nStep 3: CHOOSE ALL THE TOPPINGS\n" +
                "    Cheeses:\n" +
                "         Mozzarella\n" +
                "         Ovalini Mozzarella\n" +
                "         Parmeasan\n" +
                "         Ricotta\n" +
                "         Vegan\n" +
                "    Toppings:\n" +
                "         Pepperoni\n" +
                "         Sausage\n" +
                "         Grilled chicken\n" +
                "         Bacon\n" +
                "         Ham\n" +
                "         Olives\n" +
                "         Bell Peppers\n" +
                "         Onions\n" +
                "         Spinach\n" +
                "         Tomatoes\n" +
                "         Mushrooms\n" +
                "         Pineapples\n" +
                "         Basil\n" +
                "         Garlic\n" +
                "         Jalapenos\n");

        list.add("\nPREMADE PIZZAS\nChoose these toppings for your premade pizza!\n");
        list.add("\nCheese Pizza \n\nClassic Dough, Mozzarella, Red Sauce\n");
        list.add("\nPepperoni Pizza\n\nClassic Dough, Mozzarella, Red Sauce, Pepperoni\n");
        list.add("\nVeggie Pizza\n\nClassic Dough, Mozzarella, Red Sauce, Bell Pepper, Onions, Olives, Mushrooms, Spinach, Basil\n");

        adapter = new ArrayAdapter(Menu.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
