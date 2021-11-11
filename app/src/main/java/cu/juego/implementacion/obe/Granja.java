package cu.juego.implementacion.obe;

public class Granja {
    public static final int OBEJA = 2;
    public static final int LIBRE = 0;
    public static final int PERRO = 1;
    public static final int ARBOL = 8;
    public static final int ESTABLO = 5;
    public static final int CERCA = -1;

    public static final int DERECHA = 1;
    public static final int IZQUIERDA = -1;

    public static final int ARRIBA = -1;
    public static final int ABAJO = 1;

    public int[][] tablero;

    public int numeroObeja;

    public int columnaPerro;
    public int filaPerro;

    public Granja() {
        tablero = new int[7][7];
        numeroObeja = 3;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = LIBRE;
            }
        }
        for (int i = 0; i < 7; i++) {
            tablero[i][0] = CERCA;
            tablero[i][6] = CERCA;
            tablero[0][i] = CERCA;
            tablero[6][i] = CERCA;
        }
        // tablero[2][3] = PERRO;
        // filaPerro = 2;
        // columnaPerro = 3;
        // tablero[4][5] = OBEJA;
        // tablero[1][2] = ESTABLO;
        // tablero[3][4] = ARBOL;

        switch (Control.nivel) {

            case 0:
                tablero[4][1] = PERRO;
                filaPerro = 4;
                columnaPerro = 1;

                tablero[3][3] = ESTABLO;

                tablero[1][2] = OBEJA;
                tablero[1][5] = OBEJA;
                tablero[5][5] = OBEJA;

                tablero[1][3] = ARBOL;
                tablero[2][3] = ARBOL;
                tablero[2][5] = ARBOL;
                tablero[3][1] = ARBOL;
                tablero[5][3] = ARBOL;
                break;
            case 1:
                tablero[3][3] = PERRO;
                filaPerro = 3;
                columnaPerro = 3;

                tablero[2][2] = ESTABLO;

                tablero[1][1] = OBEJA;
                tablero[2][5] = OBEJA;
                tablero[4][2] = OBEJA;

                tablero[1][3] = ARBOL;
                tablero[2][3] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[4][5] = ARBOL;
                break;

            case 2:
                tablero[5][1] = PERRO;
                filaPerro = 5;
                columnaPerro = 1;

                tablero[1][5] = ESTABLO;

                tablero[2][1] = OBEJA;
                tablero[2][2] = OBEJA;
                tablero[3][5] = OBEJA;

                tablero[1][1] = ARBOL;
                tablero[3][1] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[3][4] = ARBOL;
                tablero[2][5] = ARBOL;
                tablero[4][2] = ARBOL;
                break;
            case 3:
                tablero[4][1] = PERRO;
                filaPerro = 4;
                columnaPerro = 1;

                tablero[4][3] = ESTABLO;

                tablero[2][1] = OBEJA;
                tablero[2][5] = OBEJA;
                tablero[5][5] = OBEJA;

                tablero[3][1] = ARBOL;
                tablero[3][3] = ARBOL;
                tablero[3][4] = ARBOL;
                tablero[3][5] = ARBOL;
                tablero[5][3] = ARBOL;
                break;

            case 4:
                tablero[5][2] = PERRO;
                filaPerro = 5;
                columnaPerro = 2;

                tablero[2][5] = ESTABLO;

                tablero[1][3] = OBEJA;
                tablero[5][5] = OBEJA;
                tablero[4][2] = OBEJA;

                tablero[1][1] = ARBOL;
                tablero[2][1] = ARBOL;
                tablero[3][1] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[1][5] = ARBOL;
                tablero[3][4] = ARBOL;
                tablero[4][4] = ARBOL;
                break;
            case 5:
                tablero[5][3] = PERRO;
                filaPerro = 5;
                columnaPerro = 3;

                tablero[2][5] = ESTABLO;

                tablero[4][2] = OBEJA;
                tablero[3][3] = OBEJA;
                tablero[3][4] = OBEJA;

                // tablero[2][2] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[4][3] = ARBOL;
                tablero[2][4] = ARBOL;
                tablero[3][5] = ARBOL;
                break;
            case 6:
                tablero[3][3] = PERRO;
                filaPerro = 3;
                columnaPerro = 3;

                tablero[2][4] = ESTABLO;

                tablero[1][5] = OBEJA;
                tablero[2][2] = OBEJA;
                tablero[5][5] = OBEJA;

                tablero[2][3] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[4][4] = ARBOL;
                tablero[4][5] = ARBOL;
                break;

            case 7:
                tablero[4][4] = PERRO;
                filaPerro = 4;
                columnaPerro = 4;

                tablero[1][2] = ESTABLO;

                tablero[2][4] = OBEJA;
                tablero[4][1] = OBEJA;
                tablero[5][4] = OBEJA;

                tablero[1][3] = ARBOL;
                tablero[3][1] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[3][3] = ARBOL;
                tablero[4][3] = ARBOL;
                break;
            case 8:
                tablero[5][4] = PERRO;
                filaPerro = 5;
                columnaPerro = 4;

                tablero[3][2] = ESTABLO;

                tablero[1][5] = OBEJA;
                tablero[4][1] = OBEJA;
                tablero[4][3] = OBEJA;

                tablero[2][3] = ARBOL;
                tablero[3][3] = ARBOL;
                tablero[3][4] = ARBOL;
                tablero[4][2] = ARBOL;
                tablero[5][5] = ARBOL;
                break;

            case 9:
                tablero[3][2] = PERRO;
                filaPerro = 3;
                columnaPerro = 2;

                tablero[3][4] = ESTABLO;

                tablero[1][1] = OBEJA;
                tablero[4][5] = OBEJA;
                tablero[5][2] = OBEJA;

                tablero[2][2] = ARBOL;
                tablero[2][3] = ARBOL;
                tablero[2][4] = ARBOL;
                tablero[3][3] = ARBOL;
                tablero[4][3] = ARBOL;
                tablero[4][4] = ARBOL;
                break;
            case 10:
                tablero[4][2] = PERRO;
                filaPerro = 4;
                columnaPerro = 2;

                tablero[3][4] = ESTABLO;

                tablero[2][2] = OBEJA;
                tablero[2][5] = OBEJA;
                tablero[3][3] = OBEJA;

                tablero[2][4] = ARBOL;
                tablero[3][2] = ARBOL;
                tablero[3][5] = ARBOL;
                tablero[4][3] = ARBOL;
                break;

            default:
                break;
        }
    }

    public boolean moverIzquierda(int fila) {
        // no se selecciono el perro
        int tmpfilperro = filaPerro;
        int tmpcolperro = columnaPerro;

        if (tablero[filaPerro][columnaPerro - 1] != CERCA
                && tablero[filaPerro][columnaPerro - 1] != ARBOL
                && tablero[filaPerro][columnaPerro - 1] != ESTABLO) {
            if (libre(fila, true, -1)) {
                moverHorizontal(-1, fila, 6);
                if (tmpfilperro != filaPerro || tmpcolperro != columnaPerro) {
                    // filaPerro = tmpfilperro;
                    // columnaPerro = tmpcolperro;
                    return true;
                }
            }
        }

        return true;
    }

    private boolean libre(int fila, boolean isfila, int direccion) {
        // TODO Auto-generated method stub
        boolean haylibre = false;
        if (isfila) {
            for (int i = columnaPerro; i < 10; i += direccion) {

                if (tablero[fila][i] == ESTABLO && tablero[fila][i - direccion] == OBEJA) {
                    haylibre = true;
                    break;
                }
                if (tablero[fila][i] == CERCA || tablero[fila][i] == ESTABLO || tablero[fila][i] == ARBOL) {
                    break;
                }
                if (tablero[fila][i] == LIBRE) {
                    haylibre = true;
                    break;
                }

            }
        } else {
            for (int i = filaPerro; i < 10; i += direccion) {

                if (tablero[i][fila] == ESTABLO && tablero[i - direccion][fila] == OBEJA) {
                    haylibre = true;
                    break;
                }
                if (tablero[i][fila] == CERCA || tablero[i][fila] == ESTABLO || tablero[i][fila] == ARBOL) {
                    break;
                }
                if (tablero[i][fila] == LIBRE) {
                    haylibre = true;
                    break;
                }
            }
        }
        return haylibre;
    }

    public boolean moverDerecha(int fila) {
        // no se selecciono el perro
        int tmpfilperro = filaPerro;
        int tmpcolperro = columnaPerro;
        if (tablero[filaPerro][columnaPerro + 1] != CERCA
                && tablero[filaPerro][columnaPerro + 1] != ARBOL
                && tablero[filaPerro][columnaPerro + 1] != ESTABLO) {
            if (libre(fila, true, 1)) {
                moverHorizontal(1, fila, 0);
                if (tmpfilperro != filaPerro || tmpcolperro != columnaPerro) {
                    // filaPerro = tmpfilperro;
                    // columnaPerro = tmpcolperro;
                    return true;
                }
            }
        }

        return true;
    }

    public boolean moverArriba(int columna) {
        // no se selecciono el perro
        int tmpfilperro = filaPerro;
        int tmpcolperro = columnaPerro;
        if (tablero[filaPerro - 1][columnaPerro] != CERCA
                && tablero[filaPerro - 1][columnaPerro] != ARBOL
                && tablero[filaPerro - 1][columnaPerro] != ESTABLO) {
            if (libre(columna, false, -1)) {
                moverVertical(-1, columna, 6);
                if (tmpfilperro != filaPerro || tmpcolperro != columnaPerro) {
                    // filaPerro = tmpfilperro;
                    // columnaPerro = tmpcolperro;
                    return true;
                }
            }
        }
        return true;
    }

    public boolean moverAbajo(int columna) {
        // no se selecciono el perro
        int tmpfilperro = filaPerro;
        int tmpcolperro = columnaPerro;
        if (tablero[filaPerro + 1][columnaPerro] != CERCA
                && tablero[filaPerro + 1][columnaPerro] != ARBOL
                && tablero[filaPerro + 1][columnaPerro] != ESTABLO) {
            if (libre(columna, false, 1)) {

                moverVertical(1, columna, 0);
                if (tmpfilperro != filaPerro || tmpcolperro != columnaPerro) {
                    // filaPerro = tmpfilperro;
                    // columnaPerro = tmpcolperro;
                    return true;
                }
            }
        }

        return true;
    }

    // /////////////////////////
    public void moverHorizontal(int direccion, int fila, int lacolumna) {
        if (lacolumna < 0 || lacolumna > 6) {
            return;
        }

        moverHorizontal(direccion, fila, lacolumna + direccion);
        if (tablero[fila][lacolumna] == ARBOL) {
            return;
        }
        if (tablero[fila][lacolumna] == CERCA) {
            return;
        }
        if (tablero[fila][lacolumna] == ESTABLO) {
            return;
        }
        // no hacer nada para objetos no vivo

        if (tablero[fila][lacolumna + direccion] == LIBRE) {
            if (tablero[fila][lacolumna] == PERRO) {
                columnaPerro += direccion;
            }
            tablero[fila][lacolumna + direccion] = tablero[fila][lacolumna];
            tablero[fila][lacolumna] = LIBRE;
        }
        if (tablero[fila][lacolumna] == OBEJA
                && tablero[fila][lacolumna + direccion] == ESTABLO) {
            numeroObeja--;
            if (Configuraciones.soundEnabled) {
                Assets.bee.play(Configuraciones.soundLevel);
            }
            if (Configuraciones.niveles[Configuraciones.numeroNivel] > numeroObeja) {
                Configuraciones.niveles[Configuraciones.numeroNivel] = numeroObeja;
                Configuraciones.guardar();
            }
            if (numeroObeja == 0) {
                Mundo.finalJuego = true;
            }
            tablero[fila][lacolumna] = LIBRE;
        }
    }

    public void moverVertical(int direccion, int columna, int lafila) {
        if (lafila < 0 || lafila > 6) {
            return;
        }

        moverVertical(direccion, columna, lafila + direccion);
        // no hacer nada para objetos no vivo
        if (tablero[lafila][columna] == ARBOL) {
            return;
        }
        if (tablero[lafila][columna] == CERCA) {
            return;
        }
        if (tablero[lafila][columna] == ESTABLO) {
            return;
        }

        if (tablero[lafila + direccion][columna] == LIBRE) {
            if (tablero[lafila][columna] == PERRO) {
                filaPerro += direccion;
            }
            tablero[lafila + direccion][columna] = tablero[lafila][columna];
            tablero[lafila][columna] = LIBRE;
        }
        if (tablero[lafila][columna] == OBEJA
                && tablero[lafila + direccion][columna] == ESTABLO) {
            numeroObeja--;
            if (Configuraciones.soundEnabled) {
                Assets.bee.play(Configuraciones.soundLevel);
            }
            if (Configuraciones.niveles[Configuraciones.numeroNivel] > numeroObeja) {
                Configuraciones.niveles[Configuraciones.numeroNivel] = numeroObeja;
                Configuraciones.guardar();
            }
            if (numeroObeja == 0) {
                Mundo.finalJuego = true;
            }
            tablero[lafila][columna] = LIBRE;
        }

    }
}
