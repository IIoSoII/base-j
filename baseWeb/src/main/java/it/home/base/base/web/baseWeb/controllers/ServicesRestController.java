package it.home.base.base.web.baseWeb.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import it.home.base.base.web.baseWeb.client.RestClient;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ServicesRestController {
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

    @GetMapping(value = "/blocco")
    public ResponseEntity<?> getDocs() {
        Map<String, String> headers = new HashMap<>();
        byte[] credsBytes = "admsolras:infocam2020".getBytes(StandardCharsets.UTF_8);
        byte[] base64CredsBytes = Base64.encodeBase64(credsBytes);
        String base64Creds = new String(base64CredsBytes);
        headers.put("Authorization","Basic "+base64Creds);
        String res = "";
        try{
            res = RestClient.get("http://solras20sv.intra.infocamere.it/solr/SUAP/blocco?role=suapud",headers,null, new TypeReference<>() {
            }).toString();
        }catch(Exception e){

        }

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN)
                .body(res);
    }
}
