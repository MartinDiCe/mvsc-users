package com.diceprojects.msvcauthorization.persistences.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad que representa un usuario en el sistema.
 */
@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;
    private String status;
    private boolean deleted = false;
    private Date deleteDate;
    private Date createDate;
    private Date updateDate;
    private String securityToken;
    private boolean forcePasswordChange;
    private Set<String> roleIds = new HashSet<>();

    /**
     * Comprueba si la cuenta del usuario está habilitada.
     *
     * @return true si la cuenta está habilitada, false en caso contrario
     */
    public boolean isEnabled() {
        return "Active".equalsIgnoreCase(status);
    }

    /**
     * Establece el token de seguridad para el usuario.
     *
     * @param token el token de seguridad
     */
    public void setToken(String token) {
        this.securityToken = token;
    }
}