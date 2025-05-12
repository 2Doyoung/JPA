package com.example.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity // DB 테이블과 매핑 대상
@Table(name = "user") // user 테이블과 매핑
public class User {
    @Id // 식별자 대응
    private String email;
    private String name;
    @Column(name = "create_date") // create_date 컬럼과 매핑
    private LocalDateTime createTime;
}
