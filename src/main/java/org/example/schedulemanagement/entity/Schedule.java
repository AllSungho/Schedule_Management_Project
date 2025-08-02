package org.example.schedulemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long userId;
    // 작성자명과 비밀번호는 유저 엔티티에 존재

    public Schedule(String title, String content, Long userId) {

        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public void updateTitle(String title) {

        this.title = title;
    }
    public void updateContent(String content) {

        this.content = content;
    }
}
