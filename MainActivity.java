/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void orderButton (View view)
    {
        Intent intent = new Intent(this, com.ppiazzapizza.Order.class);
        startActivity(intent);
    }

    public void menuButton (View view)
    {
        Intent intent = new Intent(this, com.ppiazzapizza.Menu.class); //CHANGE LATER!!!
        startActivity(intent);
    }

    public void historyButton (View view)
    {
        Intent intent = new Intent(this, com.ppiazzapizza.ViewHistory.class); //CHANGE LATER!!!
        startActivity(intent);
    }

    public void editHistoryButton (View view)
    {
        Intent intent = new Intent(this, com.ppiazzapizza.EditHistory.class); //CHANGE LATER!!!
        startActivity(intent);
    }

    public void aboutButton (View view)
    {
        Intent intent = new Intent(this, com.ppiazzapizza.About.class); //CHANGE LATER!!!
        startActivity(intent);
    }
}
