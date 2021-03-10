package com.javakc.cms.book.controller;

import com.javakc.cms.book.entity.Book;
import com.javakc.cms.book.service.BookService;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 书籍管理-表现层
 */

@Api(tags = "书籍管理 - 控制层")
@RestController
@RequestMapping("/cms/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有书籍数据
     * @return
     */
    @GetMapping
    public APICODE findBook(){
        //调用service 方法查询
        List<Book> list=bookService.findBook();
        return APICODE.OK().data("list",list);
    }

    /**
     *
     */
    @ApiOperation("带条件的分页查询 - 书籍管理信息 ")
    @PostMapping("findAll/{pageNo}/{pageSize}")
    public APICODE findAll(
            @RequestBody(required = false)
            @ApiParam(name = "bookQuery",value = "查询条件封装类",required = false) BookQuery bookQuery,
            @PathVariable("pageNo")
            @ApiParam(name = "pageNo",value = "当前页",required = true) int pageNo,
            @PathVariable("pageSize")
            @ApiParam(name = "pageSize",value = "每条最大页数",required = true) int pageSize){

        // 调用service层的方法进行查询
        Page<Book> page=bookService.findAll(bookQuery,pageNo,pageSize);
        // 当前页的数据
        List<Book> list=page.getContent();
        // 总条数
        long totalElements=page.getTotalElements();

        return APICODE.OK().data("total",totalElements).data("list",list);
    }

    @ApiOperation("添加书籍")
    @PostMapping("create")
    public APICODE create(@RequestBody @ApiParam(name = "book",value = "书籍实体",required = true) Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation("根据Id删除书籍信息")
    @DeleteMapping("deleteById/{bookId}")
    public APICODE deleteById(
            @PathVariable("bookId")
            @ApiParam(name = "bookId",value = "书籍Id",required = true) int bookId){
        bookService.removeById(bookId);
        return APICODE.OK();
    }

    @ApiOperation("根据ID获取书籍信息")
    @GetMapping("{bookId}")
    public APICODE view(
            @PathVariable("bookId")
            @ApiParam(name = "bookId",value = "书籍Id",required = true) int bookId){
        Book book=bookService.getById(bookId);
        return APICODE.OK().data("book",book);
    }

    @ApiOperation("根据ID修改书籍信息")
    @PutMapping("updateById")
    public APICODE updateById(
            @RequestBody
            @ApiParam(name = "book",value = "书籍实体",required = true) Book book){
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @ApiOperation(value = "设置书籍上下架")
    @PutMapping("upOrDownBook/{bookId}/{status}")
    public APICODE upOrDownBook(
            @PathVariable("bookId")
            @ApiParam(name = "bookId",value = "书籍ID",required = true) Integer bookId,
            @PathVariable("status")
            @ApiParam(name = "status",value = "状态",required = true) Integer status){

        Book book=bookService.getById(bookId);
        // 设置状态
        book.setStatus(status);
        bookService.saveOrUpdate(book);
        return APICODE.OK();
    }


}
