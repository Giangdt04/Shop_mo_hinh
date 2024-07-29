package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.Permission;
import com.example.shopmohinh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
