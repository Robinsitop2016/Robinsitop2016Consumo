/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Neko Karlita
 */
public class Periodo {
    private String cod_periodo;
private String nom_periodo;
public String getCod_periodo() {
	return cod_periodo;
}
public void setCod_periodo(String cod_periodo) {
	this.cod_periodo = cod_periodo;
}
public String getNom_periodo() {
	return nom_periodo;
}
public void setNom_periodo(String nom_periodo) {
	this.nom_periodo = nom_periodo;
}
@Override
public String toString() {
	return "Periodo [cod_periodo=" + cod_periodo + ", nom_periodo="
			+ nom_periodo + "]";
}

}
