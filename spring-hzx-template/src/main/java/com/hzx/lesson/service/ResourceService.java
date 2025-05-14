package com.hzx.lesson.service;

import com.hzx.lesson.model.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Resource)表服务接口
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
public interface ResourceService {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Resource queryById(Integer id);

    /**
     * 分页查询
     * @param resource    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Resource> queryByPage(Resource resource, PageRequest pageRequest);

    /**
     * 新增数据
     * @param resource 实例对象
     * @return 实例对象
     */
    Resource insert(Resource resource);

    /**
     * 修改数据
     * @param resource 实例对象
     * @return 实例对象
     */
    Resource update(Resource resource);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
