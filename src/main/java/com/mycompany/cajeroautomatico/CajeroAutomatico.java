/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.cajeroautomatico;

import java.util.List;
import java.util.Scanner;
import com.mycompany.cajeroautomatico.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author XMX7578
 */

public class CajeroAutomatico {

    Movimientos movimientos_registros = new Movimientos();
    public List<Movimientos> movimiento = new ArrayList<>();

    public String registo_movimientos(int no_cuenta, String fecha_registro,
            int cantida_registro, int saldo_anterior) {
        movimientos_registros.setNo_cuenta(no_cuenta);
        movimientos_registros.setFecha_registro(fecha_registro);
        movimientos_registros.setCantidad_registro(cantida_registro);
        movimientos_registros.setSaldo_anterior(saldo_anterior);
        movimiento.add(movimientos_registros);
        return "Se registro el movimiento";
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Usuario nuevoUsuario = new Usuario();
        List<Usuario> no_cuenta = new ArrayList<Usuario>();
        CajeroAutomatico cajero = new CajeroAutomatico();
        nuevoUsuario.setNo_cuenta(1);
        nuevoUsuario.setNombre("Gustavo");
        nuevoUsuario.setaPaterno("Corona");
        nuevoUsuario.setaMaterno("Guzman");
        nuevoUsuario.setNip(1235);
        nuevoUsuario.setSaldo(1000);
        no_cuenta.add(nuevoUsuario);

        int intentos = 1;
        int nip;
        String fecha_actual = dtf.format(LocalDateTime.now());
        while (true) {
            try {
                System.out.print("Ingresa tu NIP: ");
                nip = Integer.valueOf(reader.next());
                if (nip != no_cuenta.get(0).getNip()) {
                    intentos += 1;
                    System.out.println("Su NIP es incorrecto, vuelva a ingresarlo");
                    if (intentos > 3) {
                        System.out.println("Supero el numero de intentos en insertar su NIP");
                        break;
                    }
                } else {
                    while (true) {
                        System.out.println("\t\t.:MENÚ:.");
                        System.out.println("1.- Consultar saldo");
                        System.out.println("2.- Retirar saldo");
                        System.out.println("3.- Histórico de Movimientos");
                        System.out.println("4.- Salir");
                        System.out.print("\nSeleccione la opción de operación: ");
                        int opcion = Integer.valueOf(reader.next());

                        if (opcion == 1) {
                            System.out.println("Su saldo actual es de $" + no_cuenta.get(0).getSaldo());
                        } else if (opcion == 2) {
                            try {
                                System.out.print("Ingrese la cantidad de dinero a retirar: ");
                                int cantidad = Integer.valueOf(reader.next());
                                int modulo = cantidad ;
                                modulo %= 100;
                                System.out.println("CANTIDAD " + cantidad);
                                if (modulo != 0) {
                                    System.out.println("No es una cantida valida, debe ser un valor entero");
                                } else {
                                    if (cantidad > 0) {
                                        if (cantidad < no_cuenta.get(0).getSaldo()) {
                                            cajero.registo_movimientos(no_cuenta.get(0).getNo_cuenta(), 
                                                    fecha_actual, cantidad, no_cuenta.get(0).getSaldo());
                                            no_cuenta.get(0).setSaldo(no_cuenta.get(0).getSaldo() - cantidad);
                                            System.out.println("Usted ha retirado la cantidad de $" + cantidad);
                                        } else {
                                            System.out.println("Usted no cuenta con el saldo suficiente para retirar la cantidad indicada");
                                        }
                                    } else {
                                        System.out.println("Debe de ingresar una cantidad mayor a 0");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error -> Digite correctamente los valores numericos o sin decimales");
                            }
                        } else if (opcion == 3) {
                            int valores=0;
                            for (Movimientos movimientos : cajero.movimiento) {
                                if (movimientos.getNo_cuenta() == no_cuenta.get(0).getNo_cuenta()){
                                    valores +=1;
                                }
                            }
                            if (valores >0){
                                for (Movimientos movimientos : cajero.movimiento) {
                                    if (movimientos.getNo_cuenta() == no_cuenta.get(0).getNo_cuenta()){
                                        System.out.println(movimientos);
                                    }
                                }
                            }else{
                                System.out.println("No tiene movimientos realizados, gracias");
                            }
                            
                        } else if (opcion == 4) {
                            System.out.println("Gracias por utilizar el sistema de cajero automatico");
                            break;
                        } else {
                            System.out.println("Usted ingreso una opción no correcta");
                        }
                    }
                break;
                }
                
            } catch (Exception e) {
                System.out.println("Error -> Digite correctamente los valores numericos");
                intentos += 1;
                if (intentos > 3) {
                    System.out.println("Supero el numero de intentos en insertar su NIP");
                    break;
                }
            }
        }

    }
}
