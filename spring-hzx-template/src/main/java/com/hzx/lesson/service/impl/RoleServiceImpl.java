package com.hzx.lesson.service.impl;

import com.hzx.lesson.mapper.RoleMapper;
import com.hzx.lesson.model.entity.Role;
import com.hzx.lesson.service.RoleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * 角色表(Role)表服务实现类
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
@Service("roleService")
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        long total = this.roleMapper.count(role);
        return new PageImpl<>(this.roleMapper.queryAllByLimit(role, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleMapper.insert(role);
        return role;
    }

    /**
     * 修改数据
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleMapper.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleMapper.deleteById(id) > 0;
    }
}
