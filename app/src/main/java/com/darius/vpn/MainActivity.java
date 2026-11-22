package com.darius.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    String protocole = "VMESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(25, 25, 25, 25);
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

        TextView choix = new TextView(this);
        choix.setText("CHOISIR UN PROTOCOLE");
        choix.setTextColor(Color.WHITE);
        choix.setTextSize(18);

        Button vmess = new Button(this);
        vmess.setText("VMESS");

        Button vless = new Button(this);
        vless.setText("VLESS");

        EditText lien = new EditText(this);
        lien.setHint("Coller votre lien VMess ou VLESS");
        lien.setTextColor(Color.WHITE);
        lien.setHintTextColor(Color.GRAY);

        Button connecter = new Button(this);
        connecter.setText("CONNECTER");

        vmess.setOnClickListener(v -> {
            protocole = "VMESS";
            choix.setText("PROTOCOLE : VMESS");
        });

        vless.setOnClickListener(v -> {
            protocole = "VLESS";
            choix.setText("PROTOCOLE : VLESS");
        });

        connecter.setOnClickListener(v -> {
            String config = lien.getText().toString().trim();

            if (config.isEmpty()) {
                Toast.makeText(this,
                    "Collez d'abord un lien " + protocole,
                    Toast.LENGTH_LONG).show();
            } else if (protocole.equals("VMESS") &&
                       !config.startsWith("vmess://")) {
                Toast.makeText(this,
                    "Lien VMess invalide",
                    Toast.LENGTH_LONG).show();
            } else if (protocole.equals("VLESS") &&
                       !config.startsWith("vless://")) {
                Toast.makeText(this,
                    "Lien VLESS invalide",
                    Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                    "Lien reconnu. Moteur VPN à intégrer.",
                    Toast.LENGTH_LONG).show();
            }
        });

        layout.addView(titre);
        layout.addView(statut);
        layout.addView(choix);
        layout.addView(vmess);
        layout.addView(vless);
        layout.addView(lien);
        layout.addView(connecter);

        setContentView(layout);
    }
}