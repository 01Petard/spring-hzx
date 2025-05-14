package com.hzx.lesson.service;

import com.hzx.lesson.model.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户-角色关联表(UserRole)表服务接口
 * @author makejava
 * @since 2025-05-14 18:47:05
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    UserRole queryById(Integer id);

    /**
     * 分页查询
     * @param userRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest);

    /**
     * 新增数据
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

    /**
     * 修改数据
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
