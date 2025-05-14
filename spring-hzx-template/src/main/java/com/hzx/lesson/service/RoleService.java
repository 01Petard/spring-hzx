package com.hzx.lesson.service;

import com.hzx.lesson.model.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色表(Role)表服务接口
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 分页查询
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Role> queryByPage(Role role, PageRequest pageRequest);

    /**
     * 新增数据
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
