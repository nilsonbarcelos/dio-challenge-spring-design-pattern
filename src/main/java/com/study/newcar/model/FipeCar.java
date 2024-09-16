package com.study.newcar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeCar {

    private Integer tipoVeiculo;
    private String valor;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String siglaCombustivel;

    @JsonProperty("TipoVeiculo")
    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    @JsonProperty("TipoVeiculo")
    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @JsonProperty("Valor")
    public String getValor() {
        return valor;
    }

    @JsonProperty("Valor")
    public void setValor(String valor) {
        this.valor = valor;
    }

    @JsonProperty("Marca")
    public String getMarca() {
        return marca;
    }

    @JsonProperty("Marca")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @JsonProperty("Modelo")
    public String getModelo() {
        return modelo;
    }

    @JsonProperty("Modelo")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @JsonProperty("AnoModelo")
    public Integer getAnoModelo() {
        return anoModelo;
    }

    @JsonProperty("AnoModelo")
    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    @JsonProperty("Combustivel")
    public String getCombustivel() {
        return combustivel;
    }

    @JsonProperty("Combustivel")
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @JsonProperty("CodigoFipe")
    public String getCodigoFipe() {
        return codigoFipe;
    }

    @JsonProperty("CodigoFipe")
    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    @JsonProperty("MesReferencia")
    public String getMesReferencia() {
        return mesReferencia;
    }

    @JsonProperty("MesReferencia")
    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    @JsonProperty("SiglaCombustivel")
    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    @JsonProperty("SiglaCombustivel")
    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }
}
