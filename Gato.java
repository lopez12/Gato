package com.example.soporte.listadoexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URISyntaxException;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn11,btn12,btn13,btn21,btn22,btn23,btn31,btn32,btn33;
    int player = 0;
    int movementCounter = 0;
    public static final String EXTRA_MESSAGE = "com.example.soporte.listadoexample.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn11 = (Button) findViewById(R.id.boton11);
        btn12 = (Button) findViewById(R.id.boton12);
        btn13 = (Button) findViewById(R.id.boton13);
        btn21 = (Button) findViewById(R.id.boton21);
        btn22 = (Button) findViewById(R.id.boton22);
        btn23 = (Button) findViewById(R.id.boton23);
        btn31 = (Button) findViewById(R.id.boton31);
        btn32 = (Button) findViewById(R.id.boton32);
        btn33 = (Button) findViewById(R.id.boton33);

        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
    }

    public void Send_Data (String Trama)
    {
        BackgroundTask b1 = new BackgroundTask();
        b1.execute(Trama);
    }

    class BackgroundTask extends AsyncTask<String,Void,Void>
    {
        Socket IPSocket;
        PrintWriter writer;
        @Override
        protected Void doInBackground(String... params) {
            String IPAddress = "192.168.1.1";
            int PortNumber = 6000;
            try {
                String Trama = params[0];
                IPSocket = new Socket(IPAddress,PortNumber);
                writer = new PrintWriter(IPSocket.getOutputStream());
                writer.write(Trama);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton11:

                if(btn11.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn11.setText("X");
                        btn11.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn11.setText("O");
                        btn11.setTextColor(Color.BLUE);
                    }
                    Send_Data ("11X");
                    PlayerToogle();
                }
                break;
            case R.id.boton12:

                if(btn12.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn12.setText("X");
                        btn12.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn12.setText("O");
                        btn12.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton13:

                if(btn13.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn13.setText("X");
                        btn13.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn13.setText("O");
                        btn13.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton21:

                if(btn21.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn21.setText("X");
                        btn21.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn21.setText("O");
                        btn21.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton22:

                if(btn22.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn22.setText("X");
                        btn22.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn22.setText("O");
                        btn22.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton23:

                if(btn23.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn23.setText("X");
                        btn23.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn23.setText("O");
                        btn23.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton31:

                if(btn31.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn31.setText("X");
                        btn31.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn31.setText("O");
                        btn31.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton32:

                if(btn32.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn32.setText("X");
                        btn32.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn32.setText("O");
                        btn32.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
            case R.id.boton33:

                if(btn33.getText().toString().equals(""))
                {
                    if(player == 1)
                    {
                        btn33.setText("X");
                        btn33.setTextColor(Color.RED);
                    }
                    else
                    {
                        btn33.setText("O");
                        btn33.setTextColor(Color.BLUE);
                    }
                    PlayerToogle();
                }
                break;
        }
        REDWinnerCheck();
        BLUEWinnerCheck();
    }

    public void REDWinnerCheck()
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "RED PLAYER WINS";

        Toast toast = Toast.makeText(context,text, duration);

        String message = text.toString();
        Intent intent = new Intent(getBaseContext(), DisplayWinnerActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);

        if(btn11.getText() == btn12.getText() && btn11.getText() == btn13.getText() && btn11.getText().toString().equals("X")) //Linea Superior
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn21.getText() == btn22.getText() && btn21.getText() == btn23.getText() && btn21.getText().toString().equals("X")) //Linea Intermedia
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn31.getText() == btn32.getText() && btn31.getText() == btn33.getText() && btn31.getText().toString().equals("X")) //Linea Inferior
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn11.getText() == btn21.getText() && btn11.getText() == btn31.getText() && btn11.getText().toString().equals("X")) //Linea Izquierda
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn22.getText() == btn12.getText() && btn22.getText() == btn32.getText() && btn22.getText().toString().equals("X")) //Linea Intermedia
        {
            toast.show();
        }

        if(btn13.getText() == btn23.getText() && btn13.getText() == btn33.getText() && btn13.getText().toString().equals("X")) //Linea Derecha
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn11.getText() == btn22.getText() && btn11.getText() == btn33.getText() && btn11.getText().toString().equals("X")) //Linea Cruzada1
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn13.getText() == btn22.getText() && btn13.getText() == btn31.getText() && btn13.getText().toString().equals("X")) //Linea Cruzada2
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }
    }

    public void BLUEWinnerCheck()
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "BLUE PLAYER WINS";
        Toast toast = Toast.makeText(context,text, duration);

        String message = text.toString();
        Intent intent = new Intent(getBaseContext(), DisplayWinnerActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);

        if(btn11.getText() == btn12.getText() && btn11.getText() == btn13.getText() && btn11.getText().toString().equals("O")) //Linea Superior
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn21.getText() == btn22.getText() && btn21.getText() == btn23.getText() && btn21.getText().toString().equals("O")) //Linea Intermedia
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn31.getText() == btn32.getText() && btn31.getText() == btn33.getText() && btn31.getText().toString().equals("O")) //Linea Inferior
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn11.getText() == btn21.getText() && btn11.getText() == btn31.getText() && btn11.getText().toString().equals("O")) //Linea Izquierda
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn22.getText() == btn12.getText() && btn22.getText() == btn32.getText() && btn22.getText().toString().equals("O")) //Linea Intermedia
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn13.getText() == btn23.getText() && btn13.getText() == btn33.getText() && btn13.getText().toString().equals("O")) //Linea Derecha
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn11.getText() == btn22.getText() && btn11.getText() == btn33.getText() && btn11.getText().toString().equals("O")) //Linea Cruzada1
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }

        if(btn13.getText() == btn22.getText() && btn13.getText() == btn31.getText() && btn13.getText().toString().equals("O")) //Linea Cruzada2
        {
            MainActivity.this.startActivity(intent);
            toast.show();
        }
    }

    public void PlayerToogle()
    {
        String message = "Nadie GANA ):";
        Intent intent = new Intent(getBaseContext(), DisplayWinnerActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        if(player == 1) {
            player = 0;
        }
        else
        {
            player = 1;
        }
        movementCounter++;
        if(movementCounter == 9)
        {
            MainActivity.this.startActivity(intent);
        }
    }
}