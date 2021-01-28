package bluenet.com.calculation_0125;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class MainActivity extends AppCompatActivity {

    private Button btnAC, btnNegative, btnPercent, btnExcept, btnMultiply, btnSubtraction, btnAdd, btnEqual; //功能按鍵
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnDot; //按鈕0~9 + 小數點
    private TextView tvNumber;
    private String s1, s2, temp;
    private Integer number1, number2, total,c=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //設定介面元件
        tvNumber = (TextView) findViewById(R.id.tv_number);
        btnAC = (Button) findViewById(R.id.btn_ac);
        btnNegative = (Button) findViewById(R.id.btn_negative);
        btnPercent = (Button) findViewById(R.id.btn_percent);
        btnExcept = (Button) findViewById(R.id.btn_except);
        btnMultiply = (Button) findViewById(R.id.btn_multiply);
        btnSubtraction = (Button) findViewById(R.id.btn_subtraction);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnEqual = (Button) findViewById(R.id.btn_equal);
        btnZero = (Button) findViewById(R.id.btn_zero);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnFour = (Button) findViewById(R.id.btn_four);
        btnFive = (Button) findViewById(R.id.btn_five);
        btnSix = (Button) findViewById(R.id.btn_six);
        btnSeven = (Button) findViewById(R.id.btn_seven);
        btnEight = (Button) findViewById(R.id.btn_eight);
        btnNine = (Button) findViewById(R.id.btn_nine);
        btnDot = (Button) findViewById(R.id.btn_dot);

        //設定0~9事件
        btnZero.setOnClickListener(myListner);
        btnOne.setOnClickListener(myListner);
        btnTwo.setOnClickListener(myListner);
        btnThree.setOnClickListener(myListner);
        btnFour.setOnClickListener(myListner);
        btnFive.setOnClickListener(myListner);
        btnSix.setOnClickListener(myListner);
        btnSeven.setOnClickListener(myListner);
        btnEight.setOnClickListener(myListner);
        btnNine.setOnClickListener(myListner);
        btnDot.setOnClickListener(myListner);
        btnAC.setOnClickListener(myListner);
        btnAdd.setOnClickListener(myListner);
        btnSubtraction.setOnClickListener(myListner);
        btnMultiply.setOnClickListener(myListner);
        btnExcept.setOnClickListener(myListner);
        btnEqual.setOnClickListener(myListner);
    }


    //數字0~9
    private View.OnClickListener myListner = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            temp = tvNumber.getText().toString();
            switch (v.getId()) {
                case R.id.btn_zero:
                case R.id.btn_one:
                case R.id.btn_two:
                case R.id.btn_three:
                case R.id.btn_four:
                case R.id.btn_five:
                case R.id.btn_six:
                case R.id.btn_seven:
                case R.id.btn_eight:
                case R.id.btn_nine:
                case R.id.btn_dot: // '.'
                    Button btn = (Button) findViewById(v.getId());
                    tvNumber.setText(temp + btn.getText());
                    break;

                case R.id.btn_ac:
                    if (temp.length() == 1) {
                        tvNumber.setText("");
                    } else {
                        tvNumber.setText(temp.substring(0, temp.length() - 1));
                    }
                    break;

                case R.id.btn_equal:
                    if(s1 != null && s2 == null) {
                        Count(c);
                        c=9;
                        Count(c);
                        break;
                    }

                case R.id.btn_add:
                    if (s1 == null && s2 == null) {
                        s1 = temp;
                        tvNumber.setText("");
                        c=0;
                        break;
                    }
                    if(s1 != null && s2 == null) {
                       Count(c);
                       tvNumber.setText(s1);
                       break;
                    }


                case R.id.btn_subtraction:
                    if (s1 == null && s2 == null) {
                        s1 = temp;
                        tvNumber.setText("");
                        c=1;
                        break;
                    }
                    if(s1 != null && s2 == null) {
                        Count(c);
                        c=1;
                        break;
                    }
            }
        }

        public void Count(int c) {
            switch (c) {
                case 0:
                    s2 = temp;
                    tvNumber.setText("");
                    number1 = Integer.parseInt(s1);
                    number2 = Integer.parseInt(s2);
                    total = number1 + number2;
                    s1 = String.valueOf(total);
                    s2 = null;
                    break;
                case 1:
                    s2 = temp;
                    tvNumber.setText("");
                    number1 = Integer.parseInt(s1);
                    number2 = Integer.parseInt(s2);
                    total = number1 - number2;
                    s1 = String.valueOf(total);
                    s2 = null;
                    break;
                case 2:
                case 9:
                    tvNumber.setText(String.valueOf(total));
                    break;
            }
        }
    };
}
//                case R.id.btn_equal: // '='
//                    for (int i = 0; i < tvNumber.length(); i++) {
//                        if (s1.charAt(i) == '+' || s1.charAt(i) == '-' ||
//                                s1.charAt(i) == 'x' || s1.charAt(i) == '÷') {
//                            for (int j = i - 1; j >= 0; j--) {   //儲存計算符號"前"數字
//                                A += s1.charAt(j);
//                                Log.e("數字1", A);  /*Log*/
//                            }
//                            for (int k = i + 1; k < s1.length(); k++) { //儲存計算符號"後"數字
//                                B += s1.charAt(k);
//                                Log.e("數字2", B); /*Log*/
//                            }
//                        }
//                    }