package commul16.github.guessmynumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class ScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
    }
    public void onTry(View v2){
        EditText er=(EditText)findViewById(R.id.editText3);
        Button  b1=(Button)findViewById(R.id.button2);
        int guess_value=Integer.parseInt(er.getText().toString());
        TextView place0=(TextView)findViewById(R.id.textView2);
        TextView place=(TextView)findViewById(R.id.textView3);
        int l,m;
        Bundle bundle=getIntent().getExtras();
        String lower=bundle.getString("u");
        String upper=bundle.getString("l");
        l=Integer.parseInt(lower);
        m=Integer.parseInt(upper);
        Random rn=new Random();
        int rno=rn.nextInt(m);
        rno+=l;
        if (rno==guess_value)
        {
            place0.setText("             Correct!");
        }
        else if (rno>guess_value)
        {
            if ((rno-guess_value)>50)
            {
                place.setText("Far Less than Expected! Guess a bit More");
            }
            else if(rno-guess_value>20)
            {
                place.setText("Close to the number! Still Guess a bit More");
            }
            else if(rno-guess_value>3)
            {
                place.setText("Almost Done!A bit more");
            }
        }
        else if (rno<guess_value)
        {
            if ((guess_value-rno)>50)
            {
                place.setText("Far More than Expected! Guess a bit Less");
            }
            else if((guess_value-rno)>20)
            {
                place.setText("Close to the number! Still Guess a bit Less");
            }
            else if((guess_value-rno)>3)
            {
                place.setText("Almost Done!A bit less");
            }
        }
    }
}
