package com.hqtrivia.dang.repo;

import com.hqtrivia.dang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo extends JpaRepository<User, Integer> { }
