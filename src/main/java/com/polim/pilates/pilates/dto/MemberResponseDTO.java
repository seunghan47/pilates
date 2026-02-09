package com.polim.pilates.pilates.dto;

import lombok.Data;

import java.util.List;

@Data
public class MemberResponseDTO {
    private String fullName;
    private String email;
    private List<String> classNames;
}
