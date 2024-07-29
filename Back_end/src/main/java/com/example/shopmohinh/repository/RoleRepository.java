package com.example.shopmohinh.repository;

import com.example.shopmohinh.dto.response.RoleResponse;
import com.example.shopmohinh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
