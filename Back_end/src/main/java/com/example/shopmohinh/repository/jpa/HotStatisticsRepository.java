package com.example.shopmohinh.repository.jpa;

import com.example.shopmohinh.entity.HotStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface HotStatisticsRepository extends JpaRepository<HotStatistics, Long> {
    @Transactional
    @Modifying
    int deleteByCreatedAtBefore(LocalDateTime dateTime);
}
