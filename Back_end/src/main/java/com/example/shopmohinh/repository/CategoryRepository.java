package com.example.shopmohinh.repository;

import com.example.shopmohinh.dto.response.CategoryResponse;
import com.example.shopmohinh.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("""
            select c from Category c order by c.id desc
            """)
    List<Category> getAll();

    @Query("""
            select c from Category c order by c.id desc
            """)
    List<Category> getAllPaging(Pageable pageable);

    @Query("""
            select c from Category c order by c.id desc
            """)
    List<Category> getAllTotalPage();


    @Query(value = """
            select * from category order by category.id desc limit 1
            """,nativeQuery = true)
    Category getTop1();

    @Query("""
            select c from Category c where
            (c.name is null or c.name like %:name%) or
            (c.status is null or c.status=:status) order by c.id desc
            """)
    List<Category> findByAll(String name,Boolean status,Pageable pageable);

    @Query("""
            select c from Category c where
            (c.name is null or c.name like %:name%) or
            (c.status is null or c.status=:status)
            """)
    List<Category> findAllTotalPage(String name,Boolean status);
}
