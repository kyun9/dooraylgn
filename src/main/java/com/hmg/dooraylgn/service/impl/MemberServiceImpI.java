package com.hmg.dooraylgn.service.impl;

import java.util.Map;

/**
 * firstServiceImpI
 */
public interface MemberServiceImpI {
    Map<String, Object> getFirstData();

    boolean checkIfCreateable(String email);
}