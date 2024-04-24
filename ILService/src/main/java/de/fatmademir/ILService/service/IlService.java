package de.fatmademir.ILService.service;

import de.fatmademir.ILService.model.Il;
import de.fatmademir.ILService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository;

    public List<Il> getIller(){    //dbden tüm illeri getiriyor get metod
         return ilRepository.findAll();
    }

    public Il createIl(Il newIl) {     //dbye kayıt ediyor post metod
       return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {     //dbden  kayıt siliyor  delete metod
         ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {       //bir id ile il sorgulaması yapılırsa
      return ilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Il not found"));

    }
    public Il getIlByName(String name) {       //bir name ile il sorgulaması yapılırsa
        return ilRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Il not found"));
    }

    public void updateIl(String id, Il newIl) {     //dbden  kayıt siliyor  delete metod
        Il oldIl=getIlById(id);
        oldIl.setName(newIl.getName());
        ilRepository.save(oldIl);
    }
}
