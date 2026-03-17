package com.cpan228.cms.repository;

import com.cpan228.cms.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE " +
           "(:department IS NULL OR c.department = :department) AND " +
           "(c.credits >= :minCredits)")
    Page<Course> findByDepartmentAndCreditsGreaterThanEqual(
        @Param("department") String department, 
        @Param("minCredits") Integer minCredits, 
        Pageable pageable
    );
}
