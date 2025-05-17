package pe.edu.utp.isi.dwi.sodi.sodi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.isi.dwi.sodi.sodi.repository.AplicacionRepository;

@Service
public class AplicacionService {
    
    @Autowired
    private AplicacionRepository aplicacionRepository;
}
