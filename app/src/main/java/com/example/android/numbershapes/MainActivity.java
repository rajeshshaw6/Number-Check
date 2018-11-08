package com.example.android.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        private boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            return (squareRoot == Math.floor(squareRoot));

        }

        private boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;

                triangularNumber = triangularNumber + x;

            }

            return (triangularNumber == number);



        }


    }


    public void testNumber(View view) {
        String message = "";
        EditText usersNumber = findViewById(R.id.usersNumber);
        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter a number.";
        } else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both triangular and square!";
                } else {
                    message = myNumber.number + " is square but not triangular.";
                }
            } else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is triangular but not square.";
                } else {
                    message = myNumber.number + " is neither triangular nor square.";
                }

            }
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
