package com.ybs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User
 *
 * @author Paulson
 * @date 2020/6/4 0:15
 */

@Data
@Builder
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
// 忽略空值
//@JsonInclude(JsonInclude.Include.NON_NULL)
// 忽略不存在的字段
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String email;

    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime created;

    @Column(columnDefinition = "datetime COMMENT '更新时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updated;

    @Column(name = "is_deleted", columnDefinition = "boolean COMMENT '逻辑删除'")
    private Boolean deleted;
}

