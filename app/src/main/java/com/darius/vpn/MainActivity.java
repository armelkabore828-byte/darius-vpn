package com.darius.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout menu;

    void ajouterTitre(String texte) {
        TextView titre = new TextView(this);
        titre.setText(texte);
        titre.setTextColor(Color.RED);
        titre.setTextSize(18);
        titre.setPadding(12, 25, 12, 12);
        menu.addView(titre);
    }

    void ajouterBouton(String texte) {
        Button bouton = new Button(this);
        bouton.setText(texte);
        bouton.setTextColor(Color.WHITE);
        bouton.setBackgroundColor(Color.rgb(35, 35, 35));
        bouton.setOnClickListener(v ->
            Toast.makeText(this,
                texte + " : fonction à développer",
                Toast.LENGTH_SHORT).show()
        );
        menu.addView(bouton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        menu = new LinearLayout(this);
        menu.setOrientation(LinearLayout.VERTICAL);
        menu.setPadding(20, 20, 20, 20);
        menu.setBackgroundColor(Color.rgb(15, 15, 15));

        TextView nom = new TextView(this);
        nom.setText("DARIUS VPN");
        nom.setTextColor(Color.RED);
        nom.setTextSize(32);
        nom.setGravity(Gravity.CENTER);
        menu.addView(nom);

        TextView statut = new TextView(this);
        statut.setText("VPN NON CONNECTÉ");
        statut.setTextColor(Color.WHITE);
        statut.setTextSize(18);
        statut.setGravity(Gravity.CENTER);
        menu.addView(statut);

        ajouterTitre("NAVIGATION");
        ajouterBouton("Accueil");
        ajouterBouton("Profils");
        ajouterBouton("Réglages");
        ajouterBouton("Guide");

        ajouterTitre("AJOUTER MANUELLEMENT");
        ajouterBouton("V2Ray - VMess");
        ajouterBouton("V2Ray - VLESS");
        ajouterBouton("SSH");
        ajouterBouton("Hysteria2");
        ajouterBouton("UDP Custom");
        ajouterBouton("Psiphon");
        ajouterBouton("OpenVPN");

        ajouterTitre("OUTILS");
        ajouterBouton("Recherche IP");
        ajouterBouton("Consommation de données");
        ajouterBouton("Ping automatique");
        ajouterBouton("ID matériel");
        ajouterBouton("Vérificateur de réponse");
        ajouterBouton("Test de vitesse");
        ajouterBouton("Mon IP");
        ajouterBouton("Testeur de ports");
        ajouterBouton("Partager l'application");

        ajouterTitre("INFORMATIONS");
        ajouterBouton("À propos");

        scroll.addView(menu);
        setContentView(scroll);
    }
}