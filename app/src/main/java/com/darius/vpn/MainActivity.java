package com.darius.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
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

        TextView protocoles = new TextView(this);
        protocoles.setText("CHOISIR UN PROTOCOLE");
        protocoles.setTextColor(Color.WHITE);
        protocoles.setTextSize(18);

        Button vmess = new Button(this);
        vmess.setText("VMESS");

        Button vless = new Button(this);
        vless.setText("VLESS");

        EditText lien = new EditText(this);
        lien.setHint("Coller un lien VMess ou VLESS");
        lien.setTextColor(Color.WHITE);
        lien.setHintTextColor(Color.GRAY);

        Button ajouter = new Button(this);
        ajouter.setText("AJOUTER LE LIEN");

        Button fichier = new Button(this);
        fichier.setText("IMPORTER UN FICHIER");

        Button qr = new Button(this);
        qr.setText("SCANNER UN QR CODE");

        vmess.setOnClickListener(v ->
            Toast.makeText(this, "Protocole VMess choisi", Toast.LENGTH_SHORT).show()
        );

        vless.setOnClickListener(v ->
            Toast.makeText(this, "Protocole VLESS choisi", Toast.LENGTH_SHORT).show()
        );

        ajouter.setOnClickListener(v ->
            Toast.makeText(this, "Fonction à connecter prochainement", Toast.LENGTH_SHORT).show()
        );

        fichier.setOnClickListener(v ->
            Toast.makeText(this, "Importation à programmer", Toast.LENGTH_SHORT).show()
        );

        qr.setOnClickListener(v ->
            Toast.makeText(this, "Scanner QR à programmer", Toast.LENGTH_SHORT).show()
        );

        layout.addView(titre);
        layout.addView(statut);
        layout.addView(protocoles);
        layout.addView(vmess);
        layout.addView(vless);
        layout.addView(lien);
        layout.addView(ajouter);
        layout.addView(fichier);
        layout.addView(qr);

        setContentView(layout);
    }
}