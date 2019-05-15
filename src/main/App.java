/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import cursos.Alumno;
import cursos.CursoOnline;
import cursos.CursoPresencial;


/**
 *
 * @author HP
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Alumno pepe=new Alumno("Pepe", "34678904");
        Alumno andrea=new Alumno("Andrea", "17679456", 125);
        CursoPresencial cursopresencial = new CursoPresencial(20, 1, "Diseño de Bases de Datos", "5-05-2020", "5-05-2020", 1, 50);
        CursoOnline cursoonline = new CursoOnline("Administracion de Bases de Datos", "12/05/2014", "16/05/2014", "5, 25, 4", cursopresencial);
        cursopresencial.matriculacion(andrea);
        cursopresencial.matriculacion(pepe);
        cursopresencial.registroAsistencia(1, pepe);
        cursopresencial.calificar();
        if(cursopresencial.alumnoApto(pepe)){
            System.out.println("El alumno Pepe es apto.");
        }
        if(cursopresencial.alumnoApto(andrea)){
            System.out.println("La alumna Andrea es apta");
        }
        cursoonline.matriculacion(andrea);
        cursoonline.matriculacion(pepe);
    }
    
}

    
    


