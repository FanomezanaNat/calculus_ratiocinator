package com.hei;

import com.hei.conjonction.Conjonction;
import org.junit.Test;

import java.util.Set;

import static com.hei.conjonction.ConjonctionType.Donc;
import static com.hei.conjonction.ConjonctionType.Et;
import static org.junit.Assert.*;

public class AffirmationTest {

    @Test
    public void véritéVrai() {
        Affirmation beau = new Véritée("Lou est beau");
        assertEquals("vrai", beau.estVrai());
    }

    @Test
    public void mensongeFaux() {
        Affirmation pauvre = new Mensonge("Lou est pauvre");
        assertEquals("faux", pauvre.estVrai());
    }

    @Test
    public void affirmationInconnu() {
        Affirmation généreux = new Inconnue("Lou est généreux");
        assertEquals("jenesaispas", généreux.estVrai());
    }


    @Test
    public void etPauvreGenereuxFaux() {
        Affirmation pauvre = new Mensonge("Lou est pauvre");
        Affirmation généreux = new Inconnue("Lou est généreux");
        Conjonction conjonction = new Conjonction(Et);
        var affirmation = Set.of(pauvre, généreux);

        var affirmations = new CompostionAffirmation(affirmation, conjonction);


        assertEquals("faux", affirmations.estVrai());

    }

    @Test
    public void doncBeauPauvreFaux() {
        Affirmation beau = new Véritée("Lou est beau");
        Affirmation pauvre = new Mensonge("Lou est pauvre");
        Conjonction conjonction = new Conjonction(Donc);
        var affirmation = Set.of(beau, pauvre);
        var affirmations = new CompostionAffirmation(affirmation, conjonction);

        assertEquals("faux", affirmations.estVrai());


    }

    @Test
    public void doncPauvreGenereuxVrai() {
        Affirmation pauvre = new Mensonge("Lou est pauvre");
        Affirmation généreux = new Inconnue("Lou est généreux");
        Conjonction conjonction = new Conjonction(Donc);
        var affirmation = Set.of(pauvre, généreux);
        var affirmations = new CompostionAffirmation(affirmation, conjonction);
        assertEquals("vrai", affirmations.estVrai());

    }

    @Test
    public void doncBeauPauvreOuGenerauxPauvreFaux() {
        Affirmation pauvre = new Mensonge("Lou est pauvre");
        Affirmation généreux = new Inconnue("Lou est généreux");
        Affirmation beau = new Véritée("Lou est beau");
        Conjonction conjonction = new Conjonction(Donc);
        var beauPauvre = Set.of(beau, pauvre);
        var affirmationBeauPauvre = new CompostionAffirmation(beauPauvre, conjonction);
        var généreuxPauvre = Set.of(généreux, pauvre);
        var affirmationGenereuxPauvre = new CompostionAffirmation(généreuxPauvre, conjonction);
        assertEquals("faux", affirmationBeauPauvre.estVraiPlusieurAffirmation(affirmationBeauPauvre.estVrai(), affirmationGenereuxPauvre.estVrai(), conjonction));


    }

}