package com.Dark.Xmaymay.repository;

import com.Dark.Xmaymay.Entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemeRepository extends JpaRepository<Meme,Long> {
    List<Meme> findTop100ByOrderByIdDesc();

    Meme findByCaptionAndMemeurl(String caption,String memeurl);
}
