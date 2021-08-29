package com.tanhua.domain.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User extends BasePojo {
    private Long id;
    private String mobile; //手机号
    private String password; //密码，json序列化时忽略
    private Date created;
    private Date updated;
}