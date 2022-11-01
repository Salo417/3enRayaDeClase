package com.pmdm.a3raya

class Juego3Raya {
    companion object {
        val TABLERO = arrayOf< Array<String?> >(
            arrayOfNulls<String?>(3),
            arrayOfNulls<String?>(3),
            arrayOfNulls<String?>(3)
        )

        fun comprobarLineas(): Boolean {
            var caracterActual: String? = null
            var raya: Boolean = false
            var i: Int = 0
            var j: Int = 0
            
            while (i in TABLERO.indices  &&  !raya) {
                while (j in TABLERO[i].indices  &&  !raya) {
                    var ejeX: Int = i
                    var ejeY: Int = j
                    /*
                    var estaDentroDeRango = { a: Array< Array<String> >, eje: String, num: Int  -> {
                        if (num < 0  ||  num > a.) {

                        }
                    }}
                    */
                    caracterActual = TABLERO[ejeX][ejeY]

                    //Log.i("Information", acu?.let { acu } ?: run { "null" })

                    raya = devolverRaya(ejeX, ejeY, 3)
                    /*
                    //1º
                    if ( (ejeX - 1) >= 0  &&  (ejeY - 1) >= 0) {
                        //Ejecutar comprobacion
                        if ( caracterActual.equals(this.tablero[ejeX - 1][ejeY - 1]) ) {
                            //Comprobar otra vez en [ejeX - 2][ejeY - 2]
                        }
                    }
                    //2º
                    if ( (ejeX - 1) >= 0) {
                        //Ejecutar comprobacion
                        if ( caracterActual.equals(this.tablero[ejeX - 1][ejeY - 1]) ) {
                            //Comprobar otra vez en [ejeX - 2][ejeY - 2]
                        }
                    }
                    //3º
                    if ( (ejeX - 1) >= 0  &&  (ejeY + 1) <= (this.tablero[ejeX].size - 1) ) {
                        //Ejecutar comprobacion
                    }
                    //4º
                    if ( (ejeY - 1) >= 0) {
                        //Ejecutar comprobacion
                    }
                    //6º
                    if ( (ejeY + 1) <= (this.tablero[ejeX].size - 1) ) {
                        //Ejecutar comprobacion
                    }
                    //7º
                    if ( (ejeX + 1) <= (this.tablero.size - 1)  &&  (ejeY - 1) >= 0)  {
                        //Ejecutar comprobacion
                    }
                    //8º
                    if ( (ejeX + 1) <= (this.tablero.size - 1) )  {
                        //Ejecutar comprobacion
                    }
                    //9º
                    if ( (ejeX + 1) <= (this.tablero.size - 1)  &&  (ejeY + 1) <= (this.tablero[i].size - 1) )  {
                        //Ejecutar comprobacion
                    }
                    */
                    ++j
                }
                j = 0
                ++i
            }
            return raya
        }

        private tailrec fun devolverRaya(posX: Int, posY: Int, totalRayas: Int, numRayas: Int = 1 /*tablero: Array< Array<String?> >, caractOri: String?*/): Boolean {
            val altura:    Int     = 2                          //Representa la altura límite del array para saber en el for cuando debe parar
            val longitud:  Int     = 2//tablero[0].size         //Representa la longitud límite del array para saber en el for cuando debe parar
            val caractOri: String? = TABLERO[posX][posY]        //El caracter actual en el que estamos comprobando alrededor suya
            var reltX:     Int     = -1                         //La posición relativa con respecto a posX, empieza por -1 porque vamos a ir de arriba a abajo como suelen hacer los ejes cartesianos en informática
            var reltY:     Int     = -1                         //La posición relativa con respecto a posY, empieza por -1 porque vamos a ir de izquierda a derecha como suelen hacer los ejes cartesianos en informática
            var raya:      Boolean = false                      //La variable la cual retornaremos que indica si ha encontrado línea o no


            while (!raya  &&  (reltX != altura) ) {
                while (!raya  &&  (reltY != longitud) ) {
                    /*
                    val x:            Int =   reltX + posX      //Representa la posición absoluta en el tablero de X en la que vamos a fijarnos si coincide con el caracter que estamos comprobando
                    val y:            Int =   reltY + posY      //Representa la posición absoluta en el tablero de Y en la que vamos a fijarnos si coincide con el caracter que estamos comprobando
                    val cumpleRango:  ()  ->  Boolean = {
                        val rangoX:   IntRange  = 0 until TABLERO.size
                        val rangoY:   IntRange  = 0 until 3//tablero[x].size

                        (x in rangoX)  &&  (y in rangoY)  &&  !(x == posX  &&  y == posY)
                    }   //Función anónima/lambda en la cual cumprueba si la posición relativa con respecto a la posición que estamos comparando, no está fuera del rango del array y así evitar una excepción


                    if ( cumpleRango() ) {
                        if (TABLERO[x][y].equals(caractOri)  &&  TABLERO[x][y] != null) {
                            val numRayasAumentada: Int = numRayas + 1

                            raya =
                                if ( numRayasAumentada == totalRayas) {
                                    true
                                } else {
                                    //devolverRaya(x, y, totalRayas, posX, posY, numRayasAumentada)

                                }
                        }
                    }
                    */
                    raya = comprobarCasilla(posX, posY, reltX, reltY, 1, 3)
                    ++reltY     //Aumenta la posición Y en +1
                }

                reltY = -1      //Cuando supera la longitud de Y regresa a la posicion relativa inicial que es -1
                ++reltX         //Aumenta la posición X en +1
            }

            return raya         //Si ha encontrado 3 caracteres iguales seguidos (una línea) devolvera true, si no false
        }
        private tailrec fun devolverRaya(posX: Int, posY: Int, totalRayas: Int, exclX: Int, exclY: Int, numRayas: Int = 1): Boolean {
            val altura:    Int     = 2
            val longitud:  Int     = 2//tablero[0].size
            val caractOri: String? = TABLERO[posX][posY]        //El caracter actual en el que estamos comprobando alrededor suya
            var raya:      Boolean = false
            var reltX:     Int     = -1
            var reltY:     Int     = -1


            while (!raya  &&  (reltX != altura) ) {
                while (!raya  &&  (reltY != longitud) ) {
                    val x:            Int =   reltX + posX
                    val y:            Int =   reltY + posY
                    val cumpleRango:  ()  ->  Boolean = {
                        val rangoX:   IntRange  = 0 until TABLERO.size
                        val rangoY:   IntRange  = 0 until 3//tablero[x].size

                        //Se ha agregado las posiciones que también quieren que se excluya, esto viene bien para evitar un bucle infinito del anterior caracter que se ha comprobado
                        (x in rangoX)  &&  (y in rangoY)  &&  !(x == posX  &&  y == posY)  &&  !(x == exclX  &&  y == exclY)
                    }


                    if ( cumpleRango() ) {
                        //println("Coordenada [$posX, $posY]: Si ejecutar [$x, $y]")
                        if (TABLERO[x][y].equals(caractOri)  &&  TABLERO[x][y] != null) {
                            val numRayasAumentada: Int = numRayas + 1

                            raya =
                                if ( numRayasAumentada == totalRayas) {
                                    true
                                } else {
                                    devolverRaya(x, y, totalRayas, numRayasAumentada)
                                }
                        }
                    }

                    ++reltY
                }

                reltY = -1
                ++reltX
            }

            return raya
        }

        private tailrec fun comprobarCasilla(posX:Int, posY: Int, reltX: Int, reltY: Int, numRayas: Int, totalRayas: Int): Boolean {
            val x: Int = posX + reltX
            val y: Int = posY + reltY
            val caractOri: String? = TABLERO[posX][posY]        //El caracter actual en el que estamos comprobando alrededor suya
            var raya: Boolean = false
            val cumpleRango:  ()  ->  Boolean = {
                val rangoX:   IntRange  = 0 until TABLERO.size
                val rangoY:   IntRange  = 0 until 3//tablero[x].size

                (x in rangoX)  &&  (y in rangoY)  &&  !(x == posX  &&  y == posY)
            }

            if ( cumpleRango() ) {
                if (TABLERO[x][y].equals(caractOri)   &&  TABLERO[x][y] != null) {
                    val numRayasAumentada: Int = numRayas + 1

                    raya =
                        if ( numRayasAumentada == totalRayas) {
                            true
                        } else {
                            comprobarCasilla(posX, posY, reltX * 2, reltY * 2, numRayasAumentada, totalRayas)
                        }
                }
            }

            return raya
        }

        fun agnadirCaracter(posX: Int, posY: Int, caracter: String): Unit {
            TABLERO[posX][posY] = caracter
        }

        fun verCasilla(posX: Int, posY: Int): String? {
            return TABLERO[posX][posY]
        }

        fun resetearCasillas(): Unit {
            for (i in TABLERO.indices) {
                for (j in TABLERO[i].indices) {
                    TABLERO[i][j] = null
                }
            }
        }

        fun verTablero(): String {
            var tablero: String = "--------------------\n"

            for (i in TABLERO.indices) {
                for (j in TABLERO[i].indices)
                    tablero += "| ${verCasilla(i, j)?.let { verCasilla(i, j) } ?: " "} |"

                tablero += "\n--------------------\n"
            }

            return tablero
        }
    }
}