package it.home.base.base.web.baseWeb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@RestController
public class indexController {
    @GetMapping(value = "/api")
    public ResponseEntity<?> index() {
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body("{\"Prova\":\"call\"}");
    }

    @GetMapping(value = "/api1")
    public ResponseEntity<?> indexString() {
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN)
                .body("CSCSSCC");
    }
}
