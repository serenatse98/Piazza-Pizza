/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    String dough = "";
    String sauce = "";
    String toppings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("pizza");

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Dough);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonClassic)
                {
                    dough = "classic";
                }
                else
                {
                    dough = "gluten free";
                }
            }

        });

        RadioGroup radioGroupS = (RadioGroup) findViewById(R.id.Sauce);
        radioGroupS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonPesto)
                {
                    sauce = "pesto sauce";
                }
                else if (checkedId == R.id.radioButtonRed)
                {
                    sauce = "red sauce";
                }
                else
                {
                    sauce = "white sauce";
                }
            }

        });

//        RadioGroup radioGroupC = (RadioGroup) findViewById(R.id.Cheeses);
//        radioGroupC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.checkBoxMoz) {
//                    toppings += "mozzarella cheese, ";
//
//                }
//                else if (checkedId == R.id.checkBoxOMoz){
//                    toppings += "ovalini mozzarella cheese, ";
//
//                }
//                else if (checkedId == R.id.checkBoxParm){
//                    toppings += "parmeasan cheese, ";
//
//                }
//                else if (checkedId == R.id.checkBoxRicotta){
//                    toppings += "ricotta cheese, ";
//
//                }
//                else {
//                    toppings += "vegan cheese, ";
//
//                }
//            }
//
//        });
//
//        RadioGroup radioGroupM = (RadioGroup) findViewById(R.id.Meats);
//        radioGroupM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.checkBoxPep){
//                    toppings += "pepperoni, ";
//
//                }
//                else if (checkedId == R.id.checkBoxSausage){
//                    toppings += "sausage, ";
//
//                }
//                else if (checkedId == R.id.checkBoxChicken){
//                    toppings += "grilled chicken, ";
//
//                }
//                else if (checkedId == R.id.checkBoxBacon){
//                    toppings += "bacon, ";
//
//                }
//                else {
//                    toppings += "ham, ";
//
//                }
//            }
//
//        });
//
//
//        RadioGroup radioGroupV = (RadioGroup) findViewById(R.id.Veggies);
//        radioGroupV.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId == R.id.checkBoxOlives) {
//                    toppings += "olives, ";
//
//                }
//
//                else if (checkedId == R.id.checkBoxBP) {
//                    toppings += "bell pepper, ";
//
//                }
//
//                else if (checkedId == R.id.checkBoxOnion) {
//                    toppings += "onion, ";
//
//                }
//
//                else if (checkedId == R.id.checkBoxSpinach){
//                    toppings += "spinach, ";
//
//                }
//                else if (checkedId == R.id.checkBoxTomato){
//                    toppings += "tomatoes, ";
//
//                }
//                else if (checkedId == R.id.checkBoxMushroom){
//                    toppings += "mushrooms, ";
//
//                }
//                else if (checkedId == R.id.checkBoxPineapple){
//                    toppings += "pineapple, ";
//
//                }
//                else if (checkedId == R.id.checkBoxBasil){
//                    toppings += "basil, ";
//
//                }
//                else if (checkedId == R.id.checkBoxGarlic){
//                    toppings += "garlic, ";
//
//                }
//                else {
//                    toppings += "jalapenos, ";
//
//                }
//
//            }
//
//        });



    }



    public void addToDatabase(View view)
    {
        EditText editName = findViewById(R.id.editTextName);
        String name = editName.getText().toString();

        EditText editEmail = findViewById(R.id.editTextEmail);
        String email = editEmail.getText().toString();

        EditText editPhone = findViewById(R.id.editTextPhone);
        String phone = editPhone.getText().toString();

        CheckBox moz = findViewById(R.id.checkBoxMoz);
        CheckBox ova = findViewById(R.id.checkBoxOMoz);
        CheckBox parm = findViewById(R.id.checkBoxParm);
        CheckBox ricotta = findViewById(R.id.checkBoxRicotta);
        CheckBox vegan = findViewById(R.id.checkBoxVegan);
        CheckBox pep = findViewById(R.id.checkBoxPep);
        CheckBox sausage = findViewById(R.id.checkBoxSausage);
        CheckBox chicken = findViewById(R.id.checkBoxChicken);
        CheckBox bacon = findViewById(R.id.checkBoxBacon);
        CheckBox ham = findViewById(R.id.checkBoxHam);
        CheckBox olives = findViewById(R.id.checkBoxOlives);
        CheckBox bp = findViewById(R.id.checkBoxBP);
        CheckBox onions = findViewById(R.id.checkBoxOnion);
        CheckBox spinach = findViewById(R.id.checkBoxSpinach);
        CheckBox tomato = findViewById(R.id.checkBoxTomato);
        CheckBox mush = findViewById(R.id.checkBoxMushroom);
        CheckBox pine = findViewById(R.id.checkBoxPineapple);
        CheckBox basil = findViewById(R.id.checkBoxBasil);
        CheckBox garlic = findViewById(R.id.checkBoxGarlic);
        CheckBox jala = findViewById(R.id.checkBoxJ);

        if (moz.isChecked())
            toppings += "mozzarella, ";

        if (ova.isChecked())
            toppings += "ovalini mozzarella, ";

        if (parm.isChecked())
            toppings += "parmesan, ";

        if (ricotta.isChecked())
            toppings += "ricotta, ";

        if (vegan.isChecked())
            toppings += "vegan cheese, ";

        if (pep.isChecked())
            toppings += "pepperoni, ";

        if (sausage.isChecked())
            toppings += "sausage, ";

        if (chicken.isChecked())
            toppings += "grilled chicken, ";

        if (bacon.isChecked())
            toppings += "bacon, ";

        if (ham.isChecked())
            toppings += "ham, ";

        if (olives.isChecked())
            toppings += "olives, ";

        if (bp.isChecked())
            toppings += "bell pepper, ";

        if (onions.isChecked())
            toppings += "onions, ";

        if (spinach.isChecked())
            toppings += "spinach, ";

        if (tomato.isChecked())
            toppings += "tomatoes, ";

        if (mush.isChecked())
            toppings += "mushrooms, ";

        if (pine.isChecked())
            toppings += "pineapples, ";

        if (basil.isChecked())
            toppings += "basil, ";

        if (garlic.isChecked())
            toppings += "garlic, ";

        if (jala.isChecked())
            toppings += "jalapenos, ";




        if (name.length() > 0)
        {
            String uid = myRef.push().getKey();
            Pizza p = new Pizza(dough, sauce, toppings);

            Customer c = new Customer(uid, name, phone, email, p);

            myRef.child(uid).setValue(c);
        }

        editName.setText("");
        editEmail.setText("");
        editPhone.setText("");

        Toast.makeText(this, "Pizza Ordered!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
