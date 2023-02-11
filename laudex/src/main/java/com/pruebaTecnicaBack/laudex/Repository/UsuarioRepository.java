package com.pruebaTecnicaBack.laudex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaTecnicaBack.laudex.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    public UsuarioModel findByEmail(String email);
}
