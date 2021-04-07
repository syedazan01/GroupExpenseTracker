package com.example.projectgroupexpensetracker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calculater extends Fragment implements OnClickListener {
    Button zero, one, two, three, four, five, six, seven, eight, nine, sum, subtract, multiply, divied, percentage, result, clear, decimal, Allclear, rad, root, power, square, factorial, pie,Sci;
    TextView e1;
    double no1, no2, res;
    char ch;
    boolean b = false;
    int z = 0;


    public Calculater() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calculater, container, false);
        Sci = (Button) view.findViewById(R.id.Sci);
        Sci.setOnClickListener(this);




        zero = (Button) view.findViewById(R.id.num0);
        one = (Button) view.findViewById(R.id.num1);
        two = (Button) view.findViewById(R.id.num2);
        three = (Button) view.findViewById(R.id.num3);
        four = (Button) view.findViewById(R.id.num4);
        five = (Button) view.findViewById(R.id.num5);
        six = (Button) view.findViewById(R.id.num6);
        seven = (Button) view.findViewById(R.id.num7);
        eight = (Button) view.findViewById(R.id.num8);
        nine = (Button) view.findViewById(R.id.num9);
        sum = (Button) view.findViewById(R.id.sum);
        subtract = (Button) view.findViewById(R.id.sub);
        multiply = (Button) view.findViewById(R.id.mul);
        divied = (Button) view.findViewById(R.id.div);
        percentage = (Button) view.findViewById(R.id.per);
        result = (Button) view.findViewById(R.id.result);
        clear = (Button) view.findViewById(R.id.clr);
        decimal = (Button) view.findViewById(R.id.dec);
        Allclear = (Button) view.findViewById(R.id.AC);
        e1 = (TextView) view.findViewById(R.id.e1);
        rad = view.findViewById(R.id.btn_rad);
        square = view.findViewById(R.id.square);
        root = view.findViewById(R.id.root);
        power = view.findViewById(R.id.power);
        factorial = view.findViewById(R.id.factorial);
        pie = view.findViewById(R.id.pie);


        rad.setOnClickListener(this);
        square.setOnClickListener(this);
        root.setOnClickListener(this);
        power.setOnClickListener(this);
        factorial.setOnClickListener(this);
        pie.setOnClickListener(this);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        sum.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divied.setOnClickListener(this);
        percentage.setOnClickListener(this);
        result.setOnClickListener(this);
        clear.setOnClickListener(this);
        decimal.setOnClickListener(this);
        Allclear.setOnClickListener(this);

        return view;

    }

    public void onClick(View v) {









        if (v.getId() == R.id.clr) {
            String str = e1.getText().toString();
            if (str.length() == 0) {

            } else {
                int len = str.length();
                String str1 = str.substring(0, len - 1);
                e1.setText(str1);
            }
        }

        if (v.getId() == R.id.AC) {
            e1.setText("");
            b = false;
        }

        if (v.getId() == R.id.sum) {
            no1 = Double.parseDouble(e1.getText().toString());
            ch = '+';
            e1.setText(null);
            b = false;
        }

        if (v.getId() == R.id.sub) {
            no1 = Double.parseDouble(e1.getText().toString());
            ch = '-';
            e1.setText(null);
            b = false;
        }

        if (v.getId() == R.id.mul) {
            no1 = Double.parseDouble(e1.getText().toString());
            ch = '*';
            e1.setText(null);
            b = false;
        }

        if (v.getId() == R.id.div) {
            no1 = Double.parseDouble(e1.getText().toString());
            ch = '/';
            e1.setText(null);
            b = false;
        }

        if (v.getId() == R.id.dec) {
            String str = e1.getText().toString();
            if (str.indexOf('.') == -1) {
                e1.setText(e1.getText() + ".");
                b = true;
            }
            if (b) {

            } else {
                e1.setText(e1.getText() + ".");
                b = true;
            }
        }

        if (v.getId() == R.id.result) {
            no2 = Double.parseDouble(e1.getText().toString());
            switch (ch) {
                case '+':
                    res = no1 + no2;
                    break;
                case '-':
                    res = no1 - no2;
                    break;
                case '*':
                    res = no1 * no2;
                    break;
                case '/':
                    res = no1 / no2;
                    break;

            }
            e1.setText("" + res);
            z = 1;
            b = false;
        }
        if (v.getId() == R.id.num0) {
            String str = e1.getText().toString();
            int len = str.length();
            if (len == 0) {

            } else {
                if (z == 0) {
                    e1.setText(e1.getText() + "0");
                    z = 0;
                }
            }
        }
        if (v.getId() == R.id.num1) {
            if (z == 0) {
                e1.setText(e1.getText() + "1");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "1");
                z = 0;
            }
        }
        if (v.getId() == R.id.num2) {
            if (z == 0) {
                e1.setText(e1.getText() + "2");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "2");
                z = 0;
            }
        }
        if (v.getId() == R.id.num3) {
            if (z == 0) {
                e1.setText(e1.getText() + "3");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "3");
                z = 0;
            }
        }
        if (v.getId() == R.id.num4) {
            if (z == 0) {
                e1.setText(e1.getText() + "4");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "4");
                z = 0;
            }

        }
        if (v.getId() == R.id.num5) {
            if (z == 0) {
                e1.setText(e1.getText() + "5");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "5");
                z = 0;
            }
        }
        if (v.getId() == R.id.num6) {
            if (z == 0) {
                e1.setText(e1.getText() + "6");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "6");
                z = 0;
            }
        }
        if (v.getId() == R.id.num7) {
            if (z == 0) {
                e1.setText(e1.getText() + "7");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "7");
                z = 0;
            }
        }
        if (v.getId() == R.id.num8) {
            if (z == 0) {
                e1.setText(e1.getText() + "8");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "8");
                z = 0;
            }
        }
        if (v.getId() == R.id.num9) {
            if (z == 0) {
                e1.setText(e1.getText() + "9");
            }
            if (z == 1) {
                e1.setText(null);
                e1.setText(e1.getText() + "9");
                z = 0;
            }
        }
        if (v.getId() == R.id.square) {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;

            e1.setText("" + res);
        }
        if (v.getId() == R.id.btn_rad) {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;
            res = Math.toRadians(no1);
            e1.setText("" + res);
        }
        if (v.getId() == R.id.root) {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;
            res = Math.sqrt(no1);
            e1.setText("" + res);
        }
        if (v.getId() == R.id.power) {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;
            res = Math.pow(no1, no2);
            e1.setText("" + res);
        }
        /*if (v.getId()==R.id.factorial)
        {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;
            res = Math.

        }
        if (v.getId()==R.id.pie)
        {
            no1 = Double.parseDouble(e1.getText().toString());
            e1.setText(null);
            b = false;
            res = Math.
            e1.setText(""+res);
        }
*/


    }
}



