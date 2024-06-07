package com.hei;

public final class Inconnue extends Affirmation {
    public Inconnue(String texte) {
        super(texte);
    }

    @Override
    public String estVrai() {
        return "jenesaispas";
    }
}
