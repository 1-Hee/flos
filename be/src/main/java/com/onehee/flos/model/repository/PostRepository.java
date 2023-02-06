package com.onehee.flos.model.repository;


import com.onehee.flos.model.dto.SliceResponseDTO;
import com.onehee.flos.model.entity.Member;
import com.onehee.flos.model.entity.Post;
import com.onehee.flos.model.entity.type.WeatherType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 날씨에 해당하는 포스트
    Slice<Post> findSliceByWeather(WeatherType weatherType, Pageable pageable);

    // 포스트 리스트
    Slice<Post> findSliceBy(Pageable pageable);

    // 작성자에 해당하는 포스트
    Slice<Post> findSliceByWriter(Member writer, Pageable pageable);

    // 게시글 댓글 많은순 검색
    @Query(value = "select p.* from post p left join (select post_id, count(*) as cnt from comment group by post_id) as pc on p.post_id = pc.post_id order by pc.cnt", nativeQuery = true)
    Slice<Post> findSliceByCountComment(Pageable pageable);

    // 태그 기준으로 검색
    @Query(value = "select p.* from post p where p.post_id in (select pt.post_id from post_tag pt where pt.tag_id in (select tag_id from tag where tag_name = ?1))", nativeQuery = true)
    Slice<Post> findSliceByTagName(String tagName, Pageable pageable);

}
