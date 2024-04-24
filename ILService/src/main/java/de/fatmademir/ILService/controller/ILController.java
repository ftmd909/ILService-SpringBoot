package de.fatmademir.ILService.controller;

import de.fatmademir.ILService.model.Il;
import de.fatmademir.ILService.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class ILController {

  private final IlService ilService;

    @GetMapping           //tüm illeri çekme
    public ResponseEntity<List<Il>> getIller(){
        return new ResponseEntity<>(ilService.getIller(), HttpStatus.OK);
    }

    @GetMapping("/{id}")   //iller içerisinden istenilen id ile il'i çekme
    public ResponseEntity<Il> getIl(@PathVariable String id){
        return  new ResponseEntity<>(getIlById(id),HttpStatus.OK);

    }

    @PostMapping
    public  ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilService.createIl(newIl), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getIl(@PathVariable String id, @RequestBody Il newIl){
        ilService.updateIl(id,newIl);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilService.deleteIl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private  Il getIlById(String id){
       return ilService.getIlById(id);

    }

    @GetMapping("/name/{name}")   //iller içerisinden istenilen name ile il'i çekme
    public ResponseEntity<Il> getIlName(@PathVariable String name){
        Il il = ilService.getIlByName(name);
        return  new ResponseEntity<>(il,HttpStatus.OK);

    }
}
