package com.mauro.project.helpdesk.dtos;

public class CredenciaisDto {

    private String email;
    private String senha;


    public CredenciaisDto(){

    }
    public CredenciaisDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
