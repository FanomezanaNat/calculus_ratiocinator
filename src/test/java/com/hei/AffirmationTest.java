package com.hei;

import org.junit.Test;


import static org.junit.Assert.*;
public class AffirmationTest {

    @Test
    public void véritéVrai(){
        Affirmation beau= new Véritée("Lou est beau");
        assertEquals("vrai",beau.estVrai());
    }

    @Test
    public void mensongeFaux(){
        Affirmation pauvre=new Mensonge("Lou est pauvre");
        assertEquals("faux",pauvre.estVrai());
    }

    @Test
    public void affirmationInconnu(){
        Affirmation généreux= new Inconnue("Lou est généreux");
        assertEquals("jenesaispas",généreux.estVrai());
    }



  
}