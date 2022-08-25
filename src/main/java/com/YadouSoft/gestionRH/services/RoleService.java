package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Role;
import com.YadouSoft.gestionRH.repositories.ContratRepository;
import com.YadouSoft.gestionRH.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin("http://localhost:4200/")
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Role getRoleById(long id){
        return roleRepository.findById(id).get();
    }
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
    public Role getRoleByName(String name){
        return roleRepository.findByRoleName(name);
    }
}
