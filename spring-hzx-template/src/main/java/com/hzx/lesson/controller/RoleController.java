package com.hzx.lesson.controller;

import com.hzx.lesson.model.entity.Role;
import com.hzx.lesson.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * 角色表(Role)表控制层
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    /**
     * 服务对象
     */
    private final RoleService roleService;

    /**
     * 分页查询
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Role>> queryByPage(Role role, PageRequest pageRequest) {
        return ResponseEntity.ok(this.roleService.queryByPage(role, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Role> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.roleService.queryById(id));
    }

    /**
     * 新增数据
     * @param role 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Role> add(Role role) {
        return ResponseEntity.ok(this.roleService.insert(role));
    }

    /**
     * 编辑数据
     * @param role 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Role> edit(Role role) {
        return ResponseEntity.ok(this.roleService.update(role));
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.roleService.deleteById(id));
    }

}

