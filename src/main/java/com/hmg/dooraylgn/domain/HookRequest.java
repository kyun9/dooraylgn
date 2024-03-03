package com.hmg.dooraylgn.domain;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class HookRequest {
    private String draftMemberId;
    private String emailAddress;
    private String idProviderType;
}