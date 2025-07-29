
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
package com.github.tomitaaa.backend.repository;
import com.github.tomitaaa.backend.model.Perfil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.tomitaaa.backend.model.Pessoa;

public interface PerfilRepository  extends JpaRepository<Perfil, Long> {
    
}
