package com.proyecto.juego;

import com.badlogic.gdx.math.Rectangle;

public interface Colisionable {
    Rectangle getRect();

    void alChocarConBola(BolaPing bola);
}