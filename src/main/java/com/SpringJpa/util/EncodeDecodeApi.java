package com.SpringJpa.util;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncodeDecodeApi {

    @PostMapping(value = "/encode/base64", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String encodedBase64(@RequestBody(required = true) OriginalStringRequest original){
        return EncodeDecodeUtil.encodeBase64(original.getText());
    }

    @GetMapping(value = "/decode/base64", produces = MediaType.TEXT_PLAIN_VALUE )
    public String decodeBase64(@RequestParam(required = true, name="encoded") String encoded){
        return EncodeDecodeUtil.decodeBase64(encoded);
    }

    @GetMapping(value = "/encode/url", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public  String encodedUrl(@RequestBody(required = true) OriginalStringRequest original) {
        return EncodeDecodeUtil.encodeUrl(original.getText());
    }

    @GetMapping(value = "/decode/url", produces = MediaType.TEXT_PLAIN_VALUE )
    public String decodeUrl(@RequestParam(required = true, name="encoded") String encoded){
        return EncodeDecodeUtil.decodeUrl(encoded);
    }
}
