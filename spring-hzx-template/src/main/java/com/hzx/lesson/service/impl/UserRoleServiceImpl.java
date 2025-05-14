package com.hzx.lesson.service.impl;

import com.hzx.lesson.mapper.UserRoleMapper;
import com.hzx.lesson.model.entity.UserRole;
import com.hzx.lesson.service.UserRoleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * 用户-角色关联表(UserRole)表服务实现类
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
@Service("userRoleService")
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleMapper userRoleMapper;

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Integer id) {
        return this.userRoleMapper.queryById(id);
    }

    /**
     * 分页查询
     * @param userRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest) {
        long total = this.userRoleMapper.count(userRole);
        return new PageImpl<>(this.userRoleMapper.queryAllByLimit(userRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleMapper.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleMapper.update(userRole);
        return this.queryById(userRole.getId());
    }

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userRoleMapper.deleteById(id) > 0;
    }
}
