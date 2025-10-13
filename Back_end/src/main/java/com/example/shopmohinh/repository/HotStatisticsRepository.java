package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.HotStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotStatisticsRepository extends JpaRepository<HotStatistics, Long> {
}
