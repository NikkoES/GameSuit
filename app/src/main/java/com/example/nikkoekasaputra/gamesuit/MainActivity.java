package com.example.nikkoekasaputra.gamesuit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    TextView user, cpu;
    TextView status;
    ImageButton batu, kertas, gunting;
    Button adu, reset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (TextView)findViewById(R.id.user);
        cpu  = (TextView)findViewById(R.id.cpu);
        status  = (TextView)findViewById(R.id.status);

        batu = (ImageButton)findViewById(R.id.batu);
        kertas = (ImageButton)findViewById(R.id.kertas);
        gunting = (ImageButton)findViewById(R.id.gunting);
        adu  = (Button)findViewById(R.id.adu);
        reset = (Button)findViewById(R.id.reset);

        batu.setOnClickListener(this);
        kertas.setOnClickListener(this);
        gunting.setOnClickListener(this);
        adu.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.batu :
                user.setText("BATU");
                break;
            case R.id.kertas :
                user.setText("KERTAS");
                break;
            case R.id.gunting :
                user.setText("GUNTING");
                break;
            case R.id.adu :
                if(status.getText().equals("YOU WIN") || status.getText().equals("YOU LOSE") || status.getText().equals("DRAW")){
                    break;
                }
                else if(user.getText().equals(" ") && status.getText().equals(" ") && cpu.getText().equals(" ")){
                    break;
                }
                else{
                    int comp = (int)(Math.random()*3+1);

                    if(comp==1)
                        cpu.setText("BATU");
                    else if(comp==2)
                        cpu.setText("KERTAS");
                    else
                        cpu.setText("GUNTING");

                    if(user.getText().equals(cpu.getText())){
                        status.setText("DRAW");
                    }
                    else if(user.getText().equals("BATU") && cpu.getText().equals("KERTAS")){
                        status.setText("YOU LOSE");
                    }
                    else if(user.getText().equals("BATU") && cpu.getText().equals("GUNTING")){
                        status.setText("YOU WIN");
                    }
                    else if(user.getText().equals("KERTAS") && cpu.getText().equals("BATU")){
                        status.setText("YOU WIN");
                    }
                    else if(user.getText().equals("KERTAS") && cpu.getText().equals("GUNTING")){
                        status.setText("YOU LOSE");
                    }
                    else if(user.getText().equals("GUNTING") && cpu.getText().equals("BATU")){
                        status.setText("YOU LOSE");
                    }
                    else if(user.getText().equals("GUNTING") && cpu.getText().equals("KERTAS")){
                        status.setText("YOU WIN");
                    }
                }
                break;
            case R.id.reset :
                user.setText("...");
                cpu.setText("...");
                status.setText("...");
                break;
            default :
                break;
        }
    }
}