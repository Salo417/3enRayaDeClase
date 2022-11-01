package com.pmdm.a3raya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmdm.a3raya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding:  ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // vinculación de vistas
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        Juego3Raya.agnadirCaracter(0, 0, "O")
        Juego3Raya.agnadirCaracter(0, 1, "O")
        Juego3Raya.agnadirCaracter(0, 2, "X")
        Juego3Raya.agnadirCaracter(1, 0, "O")
        //Juego3Raya.agnadirCaracter(1, 1, "X")
        //Juego3Raya.agnadirCaracter(1, 2, "X")
        Juego3Raya.agnadirCaracter(2, 0, "O")
        Juego3Raya.agnadirCaracter(2, 1, "O")
        Juego3Raya.agnadirCaracter(2, 2, "X")

        println( Juego3Raya.verTablero() )
        println( Juego3Raya.comprobarLineas() )
        */

        var turno: Int = 0
        val caracterJugador: (turno: Int) -> String = { if (turno == 0) { "X" } else { "O" } }
        var raya: Boolean = false

        if (!raya) {
            binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"

            binding.A.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.A.text = caracterAsignar
                Juego3Raya.agnadirCaracter(0, 0, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.B.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.B.text = caracterAsignar
                Juego3Raya.agnadirCaracter(0, 1, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.C.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.C.text = caracterAsignar
                Juego3Raya.agnadirCaracter(0, 2, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.D.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.D.text = caracterAsignar
                Juego3Raya.agnadirCaracter(1, 0, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.E.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.E.text = caracterAsignar
                Juego3Raya.agnadirCaracter(1, 1, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.F.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.F.text = caracterAsignar
                Juego3Raya.agnadirCaracter(1, 2, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.G.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.G.text = caracterAsignar
                Juego3Raya.agnadirCaracter(2, 0, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.H.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.H.text = caracterAsignar
                Juego3Raya.agnadirCaracter(2, 1, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
            binding.I.setOnClickListener {
                val caracterAsignar: String = caracterJugador(turno)

                binding.I.text = caracterAsignar
                Juego3Raya.agnadirCaracter(2, 2, caracterAsignar)
                raya = Juego3Raya.comprobarLineas()

                if (raya) {
                    binding.etqGanador.text = "Ganador: ${ if (turno == 0) {"J1"} else { "J2" } }"
                } else {
                    if (turno == 0) {
                        turno = 1
                    } else {
                        turno = 0
                    }

                    binding.etqTurno.text = "Turno: ${ if (turno == 0) { "J1" } else { "J2" } }"
                }
            }
        }
        /*
        else {
            binding.etqGanador.text = "Ganador: ${ if (turno == 1) {"J1"} else { "J2" } }"
        }
        */

        /*
        if (raya) {
            binding.etqGanador.text = "Ganador: ${ if (turno == 1) {"J1"} else { "J2" } }"
        }
        */

        binding.btnReset.setOnClickListener {
            Juego3Raya.resetearCasillas()
            binding.A.text = ""; binding.B.text = ""; binding.C.text = "";
            binding.D.text = ""; binding.E.text = ""; binding.F.text = "";
            binding.G.text = ""; binding.H.text = ""; binding.I.text = "";
            binding.etqGanador.text = "Ganador: "
            raya = false
        }
    }
}