package com.example.Mi.Aplicacion;

import org.springframework.web.bind.annotation.RequestParam;

public class UserSpoti {

    String grant_type;
    String client_id;
    String client_secret;

    public UserSpoti() {
        this.grant_type = "client_credentials";
        this.client_id = "a1a07fea0d9145dcb3b512352120e3cd";
        this.client_secret ="be992e05b60847cdaa4b67f8e90e76c6";
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }
}

