package com.hmg.dooraylgn.domain;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class MemberResponse {
    private boolean isSuccess;
    private String idProviderType;
}
