package com.example.shopmohinh.repository.jpa;

import com.example.shopmohinh.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    @Query("""
            select p from Permission p where p.deleted = true
            """)
    List<Permission> getAll();

    Optional<Permission> findByCode(String code);
}
