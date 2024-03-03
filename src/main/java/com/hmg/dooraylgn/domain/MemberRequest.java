package com.hmg.dooraylgn.domain;

import jakarta.persistence.Entity;
import lombok.Data;

// @Entity
@Data
public class MemberRequest {
    private String emailAddress;
}