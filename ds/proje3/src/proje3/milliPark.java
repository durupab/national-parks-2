package proje3;

import java.util.ArrayList;
import java.util.List;

public class milliPark {
	String milliPark_Adi;
	String il_Adlari;
	String ilan_Yili;
	String yuz_Olcumu;
	List<String> cumleler = new ArrayList<String>();
	
	public milliPark() {
		this.milliPark_Adi = null;
		this.il_Adlari = null;
		this.ilan_Yili = null;
		this.yuz_Olcumu = null;
		this.cumleler = null;
	}
	public milliPark(String milliPark_Adi,String il_Adlari,String ilan_Yili,String yuz_Olcumu,List<String> cumleler) {
		this.milliPark_Adi = new String(milliPark_Adi);
		this.il_Adlari = new String(il_Adlari);
		this.ilan_Yili = ilan_Yili;
		this.yuz_Olcumu= yuz_Olcumu;
		this.cumleler = cumleler;
	}

	public String getMilliPark_Adi() {
		return milliPark_Adi;
	}
	public void setMilliPark_Adi(String milliPark_Adi) {
		this.milliPark_Adi = milliPark_Adi;
	}
	public String getIl_Adlari() {
		return il_Adlari;
	}
	public void setIl_Adlari(String il_Adlari) {
		this.il_Adlari = il_Adlari;
	}
	public String getIlan_Yili() {
		return ilan_Yili;
	}
	public void setIlan_Yili(String ilan_Yili) {
		this.ilan_Yili = ilan_Yili;
	}
	public String getYuz_Olcumu() {
		return yuz_Olcumu;
	}
	public void setYuz_Olcumu(String yuz_Olcumu) {
		this.yuz_Olcumu = yuz_Olcumu;
	} 
	public void setCumle(List<String> cumleler){
		this.cumleler = cumleler;
	}
	public List<String> getCumleler() {
		return cumleler;
	}
	public String toString() {
		return milliPark_Adi+"   " + il_Adlari+ "    " + yuz_Olcumu+ "    " + ilan_Yili + "  " + cumleler + "\n";
	} 

}
