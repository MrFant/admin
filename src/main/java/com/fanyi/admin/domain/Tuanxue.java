/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fanyi.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tuanxue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "hit")
    private Integer hit;
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "publish_time")
    @Temporal(TemporalType.DATE)
    private Date publishTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
     @JoinColumn(name = "publisher", referencedColumnName = "id")
     @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User publisher;
    @JoinColumn(name = "update_user", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User updateUser;   
    
}
