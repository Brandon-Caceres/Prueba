package com.proyecto.juego.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.proyecto.juego.Main; // Asume que la clase principal del juego se llama Main

/** Lanza la aplicación de escritorio (LWJGL3). */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        // Esta línea es útil para la compatibilidad con macOS y Windows.
        if (StartupHelper.startNewJvmIfRequired()) return;
        createApplication();
    }

    /**
     * Crea y devuelve la aplicación LibGDX.
     * @return Una nueva instancia de Lwjgl3Application.
     */
    private static Lwjgl3Application createApplication() {
        // Utiliza la clase principal del juego (Main) y la configuración por defecto.
        return new Lwjgl3Application(new Main(), getDefaultConfiguration());
    }

    /**
     * Define y devuelve la configuración por defecto para la aplicación de escritorio
     * @return La configuración de la aplicación Lwjgl3.
     */
    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        
        // --- Configuración de la Ventana ---
        configuration.setTitle("BlockBreaker2024"); // Nombre del juego
        configuration.setWindowedMode(1280, 720); // Tamaño inicial de la ventana
        
        // Íconos de la ventana (se asume que los archivos están en el directorio de recursos de lwjgl3)
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");

        // --- Configuración de Renderizado y FPS ---
        
        // Vsync limita los FPS a la tasa de refresco del monitor, ayudando a eliminar el 'screen tearing'.
        configuration.useVsync(true);
        
        // Limita los FPS a la tasa de refresco del monitor activo + 1 (como salvaguarda).
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        
        // NOTA: Si se desactiva Vsync y ForegroundFPS, se obtienen FPS ilimitados.

        return configuration;
    }
}
