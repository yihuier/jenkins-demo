package com.example.jenkinsdemo.repository;

import com.example.jenkinsdemo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yihuier
 */
public interface TestRepository extends JpaRepository<Test, String> {
}
