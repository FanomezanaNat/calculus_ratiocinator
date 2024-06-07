package com.hei;

public final class Mensonge extends Affirmation {
    public Mensonge(String texte) {
        super(texte);
    }

    @Override
    public String estVrai() {
        return "faux";
    }
}
