package com.darius.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(30, 30, 30, 30);
        layout.setBackgroundColor(Color.rgb(15, 15, 15));

        TextView titre = new TextView(this);
        titre.setText("DARIUS VPN");
        titre.setTextColor(Color.RED);
        titre.setTextSize(32);
        titre.setGravity(Gravity.CENTER);

        TextView statut = new TextView(this);
        statut.setText("VPN NON CONNECTÉ");
        statut.setTextColor(Color.WHITE);
        statut.setTextSize(18);
        statut.setGravity(Gravity.CENTER);

        Button bouton = new Button(this);
        bouton.setText("TESTER L'INTERFACE");

        bouton.setOnClickListener(v ->
            Toast.makeText(this,
                "Interface DARIUS VPN prête",
                Toast.LENGTH_LONG).show()
        );

        layout.addView(titre);
        layout.addView(statut);
        layout.addView(bouton);

        setContentView(layout);
    }
}