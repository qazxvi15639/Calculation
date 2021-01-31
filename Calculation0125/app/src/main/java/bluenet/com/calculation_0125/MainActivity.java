package bluenet.com.calculation_0125;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAC, btnNegative, btnPercent, btnExcept, btnMultiply, btnSubtraction, btnAdd, btnEqual; //功能按鍵
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnDot; //按鈕0~9 + 小數點
    private TextView tvNumber;
    private String s1, s2, temp;
    private Integer number1, number2, total, c = -1;

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
            Button btn = (Button) findViewById(v.getId());

            switch (v.getId()) {
                // 判斷小數點前需有數字,尚未判斷整句是否只有一個小數點符號
                case R.id.btn_dot:
                    if ("".equals(temp)) {
                    } else {
                        tvNumber.setText(temp + btn.getText());
                    }
                    break;

                //判斷啟始値是否為0,如為0只顯示數字0
                case R.id.btn_zero:
                    if ("".equals(temp)||String.valueOf(total)==temp) {
                        tvNumber.setText(btn.getText());
                    } else {
                        if ("0".equals(temp) || ".".equals(temp)) {
                            tvNumber.setText("0");
                        } else {
                            tvNumber.setText(temp + btn.getText());
                        }
                    }
                    break;

                //數字1-9顯示
                case R.id.btn_one:
                case R.id.btn_two:
                case R.id.btn_three:
                case R.id.btn_four:
                case R.id.btn_five:
                case R.id.btn_six:
                case R.id.btn_seven:
                case R.id.btn_eight:
                case R.id.btn_nine:
                    if ("0".equals(temp)||String.valueOf(total)==temp) {
                        tvNumber.setText(btn.getText());
                    } else {
                        tvNumber.setText(temp + btn.getText());
                    }
                    break;

                //清除按鈕
                case R.id.btn_ac:
                    s1 = null;
                    temp = "";
                    tvNumber.setText(temp);
                    break;

                //等於符號
                case R.id.btn_equal:
                    if ("".equals(temp) || s1==null) {

                    } else {
                        Count(c);
                        tvNumber.setText(String.valueOf(s1));
                        c = -1;
                        temp="";
                    }
                    break;

                //加符號
                case R.id.btn_add:
                    if ("".equals(temp)) { //啟始無輸入值,不做動作
                        break;
                    } else if (c == -1) { //判斷是否為第一次運算符號
                        if (s1 == null) { //判斷是否為第一次數入數字
                            s1 = temp;
                            temp = "";
                            tvNumber.setText(temp);
                            c = 0;
                        } else {
                            Count(c);
                            c = 0;
                        }
                        break;
                    } else {
                        Count(c);
                        c = 0;
                    }
                    break;

                    //減符號
                case R.id.btn_subtraction:
                    if ("".equals(temp)) { //啟始無輸入值,不做動作
                        break;
                    } else if (c == -1) { //判斷是否為第一次運算符號
                        if (s1 == null) { //判斷是否為第一次數入數字
                            s1 = temp;
                            temp = "";
                            tvNumber.setText(temp);
                        } else {
                            Count(c);
                            c = 1;
                        }
                        break;
                    } else {
                        Count(c);
                        c = 1;
                    }
                    break;
            }
        }
    };


    //判斷運算符
    public void Count(int c) {
        number1 = Integer.parseInt(s1);
        number2 = Integer.parseInt(temp);
        switch (c) {
            case 0:
                total = number1 + number2;
                break;
            case 1:
                total = number1 - number2;
                break;
            case 2:
                break;
        }
        s1 = String.valueOf(total);
        temp = "";
        tvNumber.setText(s1);
    }
}