package freeriders.password_keeper;


import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;


public class add extends MainActivity {
    String[] unkwons ={"+","-","!","@","#","$","%","&","*",".","?","=","_","0","1","2","3","4","5","6","7","8","9","A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    TextView random_pw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);






        final EditText account=findViewById(R.id.account);

        final EditText password=findViewById(R.id.password);
        final EditText webname=findViewById(R.id.webname);

        Button save=findViewById(R.id.save);
        Button getter=findViewById(R.id.getter);

        Bundle bundle = getIntent().getExtras();
        String website = bundle.getString("website" );
        webname.setText(website);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveFile(webname.getText().toString()+"&"+account.getText().toString()+"#"+password.getText().toString(),webname.getText().toString());

            }
        });
        getter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ac=new String(readFile(webname.getText().toString()));
                ac=ac.substring(ac.indexOf("&")+1,ac.indexOf("#"));
                String pw=new String(readFile(webname.getText().toString()));
                pw=pw.substring(pw.indexOf("#")+1);
                account.setText(ac);
                password.setText(pw);
            }
        });
    }

    public void generate(View view){
        int length = 10;
        String Ran_password="";
       Random rand = new Random();


        while (length>=1){
            int choice = rand.nextInt(71);

           Ran_password = Ran_password + unkwons[choice];

            length=length-1;
        }
        random_pw=(TextView)findViewById(R.id.password);
        random_pw.setText(Ran_password);
        random_pw.setEnabled(true);
    }



}
