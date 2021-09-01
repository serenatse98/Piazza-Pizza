/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter
    extends ArrayAdapter<Customer>
{
    private Context mContext;
    private List<Customer> pizzaList = new ArrayList<Customer>();

    public PizzaAdapter(Context context, ArrayList<Customer> list)
    {
        super(context, 0, list);
        mContext = context;
        pizzaList = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;

        if (listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.pizza_view,parent,false);
        }


        Customer currentPizza = pizzaList.get(position);

        TextView name = (TextView)listItem.findViewById(R.id.textView_Name);
        name.setText(currentPizza.getName());

        TextView order = (TextView)listItem.findViewById(R.id.textView_Order);
        order.setText((currentPizza.toString()));

        return listItem;
    }

}
