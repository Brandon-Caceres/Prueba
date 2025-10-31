package com.proyecto.juego;

import com.badlogic.gdx.math.Rectangle;


// Para las colisiones
public interface Colisionable {
    Rectangle getRect();

    void alChocarConBola(BolaPing bola);
}