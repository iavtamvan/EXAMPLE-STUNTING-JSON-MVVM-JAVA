package com.iavariav.learnjsonstunting.model;

import com.google.gson.annotations.SerializedName;

public class StuntingModel{

	@SerializedName("jenis")
	private String jenis;

	@SerializedName("gambar_1")
	private String gambar1;

	@SerializedName("gambar_2")
	private String gambar2;

	@SerializedName("judul")
	private String judul;

	@SerializedName("gambar_3")
	private String gambar3;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("gambar_4")
	private String gambar4;

	@SerializedName("isi")
	private String isi;

	@SerializedName("gambar_5")
	private String gambar5;

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	public void setGambar1(String gambar1){
		this.gambar1 = gambar1;
	}

	public String getGambar1(){
		return gambar1;
	}

	public void setGambar2(String gambar2){
		this.gambar2 = gambar2;
	}

	public String getGambar2(){
		return gambar2;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setGambar3(String gambar3){
		this.gambar3 = gambar3;
	}

	public String getGambar3(){
		return gambar3;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setGambar4(String gambar4){
		this.gambar4 = gambar4;
	}

	public String getGambar4(){
		return gambar4;
	}

	public void setIsi(String isi){
		this.isi = isi;
	}

	public String getIsi(){
		return isi;
	}

	public void setGambar5(String gambar5){
		this.gambar5 = gambar5;
	}

	public String getGambar5(){
		return gambar5;
	}
}