package com.fanyi.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardListInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String date;

    private String url;

//    @JoinColumn(name = "article",referencedColumnName = "id")
//    @OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
//    private Article article;
    private long article;


}
