package com.sds.todolist.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String owner;


    @Column(length = 100)
    private String content;

    @Column(length = 20)
    @Enumerated
    private Status status;

    @Nullable
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate = LocalDateTime.now();

    @Nullable
    @Column(name = "modified_date")
    @UpdateTimestamp
    private LocalDateTime modifiedDate = createdDate;

    public Task(@Nullable Long id, String owner, String content, Status status) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.status = status;
    }
}
