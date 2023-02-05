package com.onehee.flos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SliceResponseDTO {
    private List<?> content;
    private Boolean isFirst;
    private Boolean isLast;
    private Boolean hasContent;
    private Boolean hasNext;
    private Integer nextPage;
    private Integer nextSize;
    public static SliceResponseDTO toDto(Slice<?> data) {
        List<?> tempContent = new ArrayList<>();
        if (data.getContent() != null)
            tempContent = data.getContent();
        return SliceResponseDTO.builder()
                .content(tempContent)
                .isFirst(data.isFirst())
                .isLast(data.isLast())
                .hasContent(data.hasContent())
                .hasNext(data.hasNext())
                .nextPage(data.nextPageable().getPageNumber())
                .nextSize(data.nextPageable().getPageSize())
                .build();
    }
}