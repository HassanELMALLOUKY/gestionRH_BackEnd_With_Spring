package com.YadouSoft.gestionRH.beens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth {
    private long id;
    private String img;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String token;
}
