package com.hmg.dooraylgn.vo;

import lombok.Data;

@Data
public class MemberVo {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String website;
    private String company;
}
