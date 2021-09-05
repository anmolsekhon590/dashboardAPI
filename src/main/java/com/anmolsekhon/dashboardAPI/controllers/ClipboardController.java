package com.anmolsekhon.dashboardAPI.controllers;

import com.anmolsekhon.dashboardAPI.beans.Clipboard;
import com.anmolsekhon.dashboardAPI.database.DatabaseAccess;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ClipboardController {

    @Autowired
    protected DatabaseAccess da;

    @GetMapping("/clipboard")
    public String getData() {
        Clipboard clipboard = da.getClipboard();
        Gson gson = new Gson();

        return gson.toJson(clipboard);
    }

    @PutMapping("/clipboard")
    public String updateClipboard(@RequestBody Clipboard clipboard) {
        da.updateClipboard(clipboard);

        return "updated";
    }
}
