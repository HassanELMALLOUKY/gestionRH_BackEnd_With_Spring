package com.YadouSoft.gestionRH.Auth;

import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private SalarieService salarieService;

    public UserDetailsServiceImpl(SalarieService salarieService) {
        this.salarieService = salarieService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Salarie salarie=salarieService.loadUserByUsername(username);
        if(salarie==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        salarie.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
        return new User(salarie.getUsername(),salarie.getPassword(),authorities);
    }
}
