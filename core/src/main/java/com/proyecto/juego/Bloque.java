package com.proyecto.juego;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Bloque extends ObjetoJuego implements Colisionable {
    private Color colorBase;
    private boolean destruido;
    private boolean irrompible;
    private int hp;

    public Bloque(int x, int y, int ancho, int alto) {
        this(x, y, ancho, alto, 1, false);
    }

    public Bloque(int x, int y, int ancho, int alto, int hp, boolean irrompible) {
        super(x, y, ancho, alto);
        this.irrompible = irrompible;
        this.hp = Math.max(1, hp);
        this.destruido = false;

        Random r = new Random(x + y);
        this.colorBase = new Color(0.15f + (r.nextFloat() * 0.8f), r.nextFloat(), r.nextFloat(), 1.0f);
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void alChocarConBola(BolaPing bola) {
        recibirImpacto();
    }

    public void recibirImpacto() {
        if (destruido) return;
        if (irrompible) return;
        hp--;
        if (hp <= 0) destruido = true;
    }

    public boolean estaDestruido() { return destruido; }
    public boolean esIrrompible() { return irrompible; }
    public int getHp() { return hp; }

    public void destruir() {
        if (!irrompible) {
            destruido = true;
            hp = 0;
        }
    }

    @Override
    public void dibujar(ShapeRenderer sr) {
        if (destruido) return;
        if (irrompible) {
            sr.setColor(Color.DARK_GRAY);
        } else if (hp >= 2) {
            float f = Math.max(0.45f, 1.0f - 0.18f * (hp - 1));
            sr.setColor(colorBase.r * f, colorBase.g * f, colorBase.b * f, 1f);
        } else {
            sr.setColor(colorBase);
        }
        sr.rect(x, y, ancho, alto);
    }
}