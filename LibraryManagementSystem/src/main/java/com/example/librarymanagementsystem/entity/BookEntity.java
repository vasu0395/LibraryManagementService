package com.example.librarymanagementsystem.entity;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "subject")
    private String subject;
    @Column(name = "published_date")
    private String publishedDate;
    @Column(name = "price")
    private Integer price;
    @Builder.Default
    @Column(name = "isReserved")
    private Boolean isReserved = false;
}
