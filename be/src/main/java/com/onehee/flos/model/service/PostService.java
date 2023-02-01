package com.onehee.flos.model.service;

import com.onehee.flos.exception.BadRequestException;
import com.onehee.flos.model.dto.request.PostCreateRequestDTO;
import com.onehee.flos.model.dto.request.PostModifyRequestDTO;
import com.onehee.flos.model.dto.response.PostResponseDTO;
import com.onehee.flos.model.entity.FileEntity;
import com.onehee.flos.model.entity.Member;
import com.onehee.flos.model.entity.Post;
import com.onehee.flos.model.entity.Tag;
import com.onehee.flos.model.entity.type.WeatherType;
import com.onehee.flos.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public interface PostService {

    // 게시글 날씨별 검색
    Slice<PostResponseDTO> getPostListByWeather(WeatherType weatherType, Pageable pageable);

    // 게시글 최신순 검색
    Slice<PostResponseDTO> getLatestPostList(Pageable pageable);

    // 게시글 사람별 검색
    Slice<PostResponseDTO> getPostListByWriter(Member writer, Pageable pageable);

    // 북마크한 게시글 검색
    Slice<PostResponseDTO> getBookmarkedListByMember(Pageable pageable);
    // 게시글 인기순 검색

    // 단일 게시글 정보 검색
    PostResponseDTO getPost(Long id) throws BadRequestException;

    // 게시글 등록
    void createPost(PostCreateRequestDTO postCreateRequestDTO) throws BadRequestException, IOException;

    // 게시글 수정
    void modifyPost(PostModifyRequestDTO postModifyRequestDTO) throws BadRequestException, IOException;

    // 게시글 삭제
    void deletePost(Long id) throws BadRequestException;

}
