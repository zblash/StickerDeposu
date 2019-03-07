package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
}