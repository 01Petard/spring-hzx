package com.hzx.lesson.controller;

import com.hzx.lesson.model.entity.Resource;
import com.hzx.lesson.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * (Resource)表控制层
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
@RestController
@RequestMapping("resource")
@RequiredArgsConstructor
public class ResourceController {
    /**
     * 服务对象
     */
    private final ResourceService resourceService;

    /**
     * 分页查询
     * @param resource    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Resource>> queryByPage(Resource resource, PageRequest pageRequest) {
        return ResponseEntity.ok(this.resourceService.queryByPage(resource, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Resource> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.resourceService.queryById(id));
    }

    /**
     * 新增数据
     * @param resource 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Resource> add(Resource resource) {
        return ResponseEntity.ok(this.resourceService.insert(resource));
    }

    /**
     * 编辑数据
     * @param resource 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Resource> edit(Resource resource) {
        return ResponseEntity.ok(this.resourceService.update(resource));
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.resourceService.deleteById(id));
    }

}

