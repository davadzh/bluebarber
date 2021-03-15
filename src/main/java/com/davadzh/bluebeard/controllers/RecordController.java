package com.davadzh.bluebeard.controllers;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/test")
public class RecordController {

    private List<String> lalala = new ArrayList<>();

    @PostMapping
    public String postText(@RequestBody Map<String, String> body) {
        JSONObject jsonObject = new JSONObject(body);
        lalala.add(jsonObject.toString());
        return jsonObject.toString() + " is added";
    }

    @GetMapping StringBuilder getAll() {
        StringBuilder str = new StringBuilder();
        for (var el:
             lalala) {
            str.append(el);
        }

        return str;
    }
}
