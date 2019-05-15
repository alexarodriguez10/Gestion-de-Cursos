/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

abstract class Curso {
    protected String titulo;
    protected Calendar fechaInicio;
    protected Calendar fechaFinal;
    protected int numeroDias;
    protected double precio;
    protected ArrayList<Alumno> alumnos;
    protected ArrayList<Alumno> alumnosAptos;

    public Curso(String titulo, Calendar fechaInicio, Calendar fechaFinal, int numeroDias, double precio) {
        this.titulo = titulo;
        this.fechaInicio.set(fechaInicio.getTime().getYear(), fechaInicio.getTime().getMonth(), fechaInicio.getTime().getDay());
        this.fechaFinal.set(fechaFinal.getTime().getYear(), fechaFinal.getTime().getMonth(), fechaFinal.getTime().getDay());
        this.numeroDias = numeroDias;
        this.precio = precio;
        alumnos = new ArrayList<>();
        alumnosAptos = new ArrayList<>();
    }
    
    public boolean haTerminado(){
        Date fechaAhora = new Date();
        return fechaFinal.getTime().compareTo(fechaAhora) == 1 || fechaFinal.getTime().compareTo(fechaAhora) == 0;
    }
    abstract public boolean alumnoApto(Alumno alumno);
    public boolean matriculacion(Alumno alumno){
        if(alumno.getCredito() >= precio){
            alumno.decrementarCredito(precio);
            alumnos.add(alumno);
            return true;
        }else{
            return false;
        }
    }
   
    public boolean calificar(){
        if(haTerminado()){
            for(int i = 0;i<alumnos.size();i++ ){
                if(alumnoApto(alumnos.get(i))){
                    alumnosAptos.add(alumnos.get(i));
                }
            }
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Curso obj=null;
        if(!vacio()){
            try{
                obj=(Curso)super.clone();
            }catch(CloneNotSupportedException ex){
                System.out.println("No se puede duplicar");
            }
        }else{
            System.out.println("No esta vacio");
        }
        return obj;
    }
    
    abstract public boolean vacio();
}

