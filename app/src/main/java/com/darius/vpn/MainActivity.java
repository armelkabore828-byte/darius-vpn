package com.darius.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout racine, contenu, panneau;
    boolean menuOuvert = false;

    void boutonMenu(String nom) {
        Button b = new Button(this);
        b.setText(nom);
        b.setTextColor(Color.WHITE);
        b.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        b.setBackgroundColor(Color.rgb(35,35,35));
        b.setOnClickListener(v -> {
            Toast.makeText(this, nom + " sélectionné", Toast.LENGTH_SHORT).show();
            fermerMenu();
        });
        panneau.addView(b);
    }

    void fermerMenu() {
        racine.removeView(panneau);
        menuOuvert = false;
    }

    void ouvrirMenu() {
        if (menuOuvert) return;

        panneau = new LinearLayout(this);
        panneau.setOrientation(LinearLayout.VERTICAL);
        panneau.setPadding(12, 20, 12, 20);
        panneau.setBackgroundColor(Color.rgb(25,25,25));

        TextView titre = new TextView(this);
        titre.setText("DARIUS VPN");
        titre.setTextColor(Color.RED);
        titre.setTextSize(25);
        titre.setGravity(Gravity.CENTER);
        panneau.addView(titre);

        boutonMenu("Accueil");
        boutonMenu("Profils");
        boutonMenu("Réglages");
        boutonMenu("Guide");

        TextView protocoles = new TextView(this);
        protocoles.setText("AJOUTER MANUELLEMENT");
        protocoles.setTextColor(Color.RED);
        protocoles.setPadding(8,20,8,8);
        panneau.addView(protocoles);

        boutonMenu("V2Ray - VMess");
        boutonMenu("V2Ray - VLESS");
        boutonMenu("SSH");
        boutonMenu("Hysteria2");
        boutonMenu("UDP Custom");
        boutonMenu("Psiphon");
        boutonMenu("OpenVPN");

        TextView outils = new TextView(this);
        outils.setText("OUTILS");
        outils.setTextColor(Color.RED);
        outils.setPadding(8,20,8,8);
        panneau.addView(outils);

        boutonMenu("Recherche IP");
        boutonMenu("Consommation de données");
        boutonMenu("Ping automatique");
        boutonMenu("ID matériel");
        boutonMenu("Vérificateur de réponse");
        boutonMenu("Test de vitesse");
        boutonMenu("Mon IP");
        boutonMenu("Testeur de ports");
        boutonMenu("Partager l'application");
        boutonMenu("À propos");

        Button fermer = new Button(this);
        fermer.setText("FERMER LE MENU");
        fermer.setOnClickListener(v -> fermerMenu());
        panneau.addView(fermer);

        ScrollView scroll = new ScrollView(this);
        scroll.addView(panneau);

        racine.addView(scroll, new LinearLayout.LayoutParams(
            0, LinearLayout.LayoutParams.MATCH_PARENT, 1
        ));

        menuOuvert = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        racine = new LinearLayout(this);
        racine.setOrientation(LinearLayout.HORIZONTAL);
        racine.setBackgroundColor(Color.rgb(15,15,15));

        contenu = new LinearLayout(this);
        contenu.setOrientation(LinearLayout.VERTICAL);
        contenu.setGravity(Gravity.CENTER);
        contenu.setPadding(20,20,20,20);

        Button menu = new Button(this);
        menu.setText("☰ MENU");
        menu.setOnClickListener(v -> ouvrirMenu());

        TextView titre = new TextView(this);
        titre.setText("DARIUS VPN");
        titre.setTextColor(Color.RED);
        titre.setTextSize(32);
        titre.setGravity(Gravity.CENTER);

        TextView statut = new TextView(this);
        statut.setText("VPN NON CONNECTÉ");
        statut.setTextColor(Color.WHITE);
        statut.setTextSize(18);

        Button connecter = new Button(this);
        connecter.setText("CONNECTER");
        connecter.setOnClickListener(v ->
            Toast.makeText(this,
                "Configuration VPN nécessaire",
                Toast.LENGTH_LONG).show()
        );

        contenu.addView(menu);
        contenu.addView(titre);
        contenu.addView(statut);
        contenu.addView(connecter);

        racine.addView(contenu, new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.MATCH_PARENT
        ));

        setContentView(racine);
    }
}