package com.example.Mi.Aplicacion.Controllers;

import com.example.Mi.Aplicacion.Service;
import com.example.Mi.Aplicacion.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllers {

    @GetMapping("/Spotify")
    public ResponseEntity<Token> token(){
        return Service.respuesta();
    }

    @GetMapping("/GetArt")
    public ResponseEntity<String> artist(){
        return Service.respartist();
    }

    @GetMapping("/GetEpisode")  
    public ResponseEntity<String> episode(){
        return Service.respepisode();
    }

    @GetMapping("/GetToken")
    public ResponseEntity<String> usertoken(@RequestParam String usrtkn){
        return Service.usertokenresp(usrtkn);
    }

}
