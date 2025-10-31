package com.proyecto.juego;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class ObjetoJuego {
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;

    public ObjetoJuego(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }

    public void setPos(int x, int y) { this.x = x; this.y = y; }
    public void setTam(int ancho, int alto) { this.ancho = ancho; this.alto = alto; }

    public void actualizar() {}

    public abstract void dibujar(ShapeRenderer sr);
}