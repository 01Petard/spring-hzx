package com.hzx.lesson.service.impl;

import com.hzx.lesson.mapper.ResourceMapper;
import com.hzx.lesson.model.entity.Resource;
import com.hzx.lesson.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * (Resource)表服务实现类
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
@Service("resourceService")
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private final ResourceMapper resourceMapper;

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Resource queryById(Integer id) {
        return this.resourceMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param resource    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Resource> queryByPage(Resource resource, PageRequest pageRequest) {
        long total = this.resourceMapper.count(resource);
        return new PageImpl<>(this.resourceMapper.queryAllByLimit(resource, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource insert(Resource resource) {
        this.resourceMapper.insert(resource);
        return resource;
    }

    /**
     * 修改数据
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource update(Resource resource) {
        this.resourceMapper.update(resource);
        return this.queryById(resource.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.resourceMapper.deleteById(id) > 0;
    }
}
