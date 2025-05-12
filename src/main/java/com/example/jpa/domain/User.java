package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity // 이 클래스가 JPA Entity임을 나타냄 → DB 테이블로 매핑됨
@Getter // Lombok: 모든 필드의 Getter 메서드 자동 생성
@Setter
@NoArgsConstructor // Lombok: 기본 생성자 자동 생성
public class User {

    @Id // 기본 키(PK) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ID 값을 DB에서 자동 증가(AUTO_INCREMENT)로 생성
    private Long id;

    @Column(nullable = false)
    // name 컬럼은 null이 될 수 없음
    private String name;

    @Column(nullable = false, unique = true)
    // email 컬럼은 null이 될 수 없고, 중복된 값도 허용하지 않음 (UNIQUE 제약조건)
    private String email;

    @CreationTimestamp
    private Timestamp createDate;
}
