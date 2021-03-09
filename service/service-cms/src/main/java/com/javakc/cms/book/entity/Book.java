package com.javakc.cms.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

    @Data
    @Entity
    @Table(name = "cms_book")
    @EntityListeners(AuditingEntityListener.class)
    public class Book {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(value = "书籍主键")
        private int id;

        @Column(name = "title")
        @ApiModelProperty(value = "书名")
        private String title;

        @Column(name = "book_author")
        @ApiModelProperty(value = "作者")
        private String bookAuthor ;

        @Column(name = "classify1_id")
        @ApiModelProperty(value = "书籍一级分类")
        private Integer classify1Id ;

        @Column(name = "classify2_id")
        @ApiModelProperty(value = "书籍二级分类")
        private Integer classify2Id ;

        @Column(name = "is_serialize")
        @ApiModelProperty(value = "是否连载")
        private Integer isSerialize ;

        @Column(name = "word_number")
        @ApiModelProperty(value = "字数")
        private Integer wordNumber ;

        @Column(name = "status")
        @ApiModelProperty(value = "状态(上线/下线)")
        private Integer status ;

        @Column(name = "is_full_charge")
        @ApiModelProperty(value = "是否全本收费")
        private Integer isFullCharge ;

        @Column(name = "started_date")
        @ApiModelProperty(value = "授权开始时间")
        private Date startedDate ;

        @Column(name = "ended_date")
        @ApiModelProperty(value = "授权结束时间")
        private Date endedDate ;

        @Column(name = "is_original")
        @ApiModelProperty(value = "是否原创")
        private Integer isOriginal ;

        @Column(name = "copyright_id")
        @ApiModelProperty(value = "版权方外键")
        private Integer copyrightId ;

        @Column(name = "list_id")
        @ApiModelProperty(value = "书单表外键")
        private Integer listId ;

        @Column(name = "brief_introduction")
        @ApiModelProperty(value = "简介")
        private String briefIntroduction ;

        @Column(name = "cover")
        @ApiModelProperty(value = "封面")
        private String cover ;

        @Column(name = "gmt_create",nullable = false,updatable =false)
        @CreatedDate
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        @ApiModelProperty(value = "创建时间", example = "2020-12-12 9:00:00")
        private Date gmtCreate;


        @Column(name = "gmt_modified",nullable = false,insertable = false)
        @LastModifiedDate
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        @ApiModelProperty(value = "更新时间", example = "2020-12-12 9:00:00")
        private Date gmtModified;


}
