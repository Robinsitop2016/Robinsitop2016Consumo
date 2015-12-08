/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Nota;
import Clases.Periodo;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Neko Karlita
 */
@ManagedBean
@ViewScoped
public class Consumirbeans {

    /**
     * Creates a new instance of Consumirbeans
     */
    
            private String cedula;
	    private String plectivo;
	    private String alunmo;
	    private String carrera;
	    private String materia;
            private List<Nota> nota;
            private List<String> string;
            private String nomper;
    public Consumirbeans() {
        string = new ArrayList<>();
        string.add(materia);
    }

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }
            
            
    

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }
            private List<Periodo> periodos;

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlectivo() {
        return plectivo;
    }

    public void setPlectivo(String plectivo) {
        this.plectivo = plectivo;
    }

    public String getAlunmo() {
        return alunmo;
    }

    public void setAlunmo(String alunmo) {
        this.alunmo = alunmo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Nota> getNota() {
        return nota;
    }

    public void setNota(List<Nota> nota) {
        this.nota = nota;
    }
	    
            
  
    
    public void Buscar(){
        Client client = ClientBuilder.newBuilder()
                .property("connection.timeout", 100)
                .register(JacksonJsonProvider.class)
                .build();

        nota = (List<Nota>) client.target("http://lisrestful.azurewebsites.net/api/notas?cod_estudiante=" + this.cedula + "&cod_lectivo=" + this.plectivo + "")
                .request().accept("application/json")
                .get(new GenericType<List<Nota>>() {
                });

        alunmo = nota.get(1).getApe_estudiante() + " " + nota.get(1).getNom_estudiante();
        carrera=nota.get(2).getNom_carrera();
        int i = 0;

        do {
            nota.get(i).getNom_materia();
            nota.get(i).getPrimer_academica();
            nota.get(i).getPrimer_promedio();
            nota.get(i).getSegundo_academica();
            nota.get(i).getSegundo_evaluacion();
            nota.get(i).getSegundo_promedio();
            nota.get(i).getPromedio();
            i++;
        } while (i < nota.size());
    }
    
    
   public void periodo() {
        Client client=ClientBuilder.newBuilder()
			    .property("connection.timeout", 100)
			    .register(JacksonJsonProvider.class)
			    .build();
			  
			   periodos=(List<Periodo>)client.target("http://lisrestful.azurewebsites.net//api/periodoLectivo")
			  .request().accept("application/json")
			  .get(new GenericType<List<Periodo>>(){});
			   
			   int i=0; 
		do {
			nomper=periodos.get(i).getNom_periodo();
			i++;
		} while (i < periodos.size());
        
        

    }
    
    
}
