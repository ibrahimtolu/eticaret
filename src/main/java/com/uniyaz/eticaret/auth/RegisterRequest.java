package com.uniyaz.eticaret.auth;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String userName;
    private String userPassword;
    private String userEmail;
    private String userAge;
    private String userAdress;
}
