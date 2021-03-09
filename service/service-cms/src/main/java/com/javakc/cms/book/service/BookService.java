package com.javakc.cms.book.service;

import com.javakc.cms.book.dao.BookDao;
import com.javakc.cms.book.entity.Book;
import com.javakc.cms.book.vo.BookQuery;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecification;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍管理-逻辑层
 */
@Service
public class BookService extends BaseService<BaseDao,Book> {
    @Autowired
    private BookDao bookDao;

    /**
     * 查询所有的数据
     * @return
     */
    public List<Book> findBook(){
        //调用dao数据层，进行查询
        return bookDao.findAll();
    }

    /**
     * 带条件的分页查询
     * @param bookQuery
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> findAll(BookQuery bookQuery, int pageNo, int pageSize) {

        //设置查询条件
        /**
         * 可用操作符
         * = 等值、!= 不等值 (字符串、数字)
         * >=、<=、>、< (数字)
         * ge，le，gt，lt(字符串)
         * :表示like %v%
         * l:表示 v%
         * :l表示 %v
         * null表示 is null
         * !null表示 is not null
         */
        Specification<Book> specification=
                new SimpleSpecificationBuilder<>().and("title",":",bookQuery.getTitle()).getSpecification();

        Page page=dao.findAll(specification, PageRequest.of(pageNo-1,pageSize));
        return page;
    }
}
