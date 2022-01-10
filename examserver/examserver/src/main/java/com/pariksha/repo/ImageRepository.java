package com.pariksha.repo;

import com.pariksha.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ImageRepository extends JpaRepository<Image ,Long> {
    Optional<Image> findByName(String name);
}
