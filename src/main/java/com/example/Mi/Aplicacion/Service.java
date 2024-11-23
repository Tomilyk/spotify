package com.example.Mi.Aplicacion;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Service {

    public static ResponseEntity<Token> respuesta(){
        UserSpoti user = new UserSpoti();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> values = new LinkedMultiValueMap<String,String>();
        values.add("grant_type",user.getGrant_type());
        values.add("client_id", user.getClient_id());
        values.add("client_secret", user.getClient_secret());
        HttpEntity <MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(values, header);
        ResponseEntity<Token> respToken=restTemplate.postForEntity("https://accounts.spotify.com/api/token",request,Token.class);
        return respToken;
    }
    public static ResponseEntity<String> respartist(){
        /*Token token = Service.respuesta().getBody();
        String servicio= token.getAccess_token();*/
        RestTemplate restTem = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(Service.respuesta().getBody().getAccess_token());
        HttpEntity<String> request = new HttpEntity<String>(header);
        ResponseEntity<String> repArtist=restTem.exchange("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg", HttpMethod.GET, request,String.class);
        return repArtist;
    }
    public static ResponseEntity<String> respepisode(){
        RestTemplate restTem = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(Service.respuesta().getBody().getAccess_token());
        HttpEntity<String> request = new HttpEntity<String>(header);
        ResponseEntity<String> repEpisode=restTem.exchange("https://api.spotify.com/v1/episodes/1muo8xIONgPvR3P1QrG8su", HttpMethod.GET, request,String.class);
        return repEpisode;
    }
    public static ResponseEntity<String> usertokenresp(String token){
        RestTemplate restTem = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(token);
        HttpEntity<String> request = new HttpEntity<String>(header);
        ResponseEntity<String> repEpisode=restTem.exchange("https://api.spotify.com/v1/me/top/tracks", HttpMethod.GET, request,String.class);
        return repEpisode;
    }
}
