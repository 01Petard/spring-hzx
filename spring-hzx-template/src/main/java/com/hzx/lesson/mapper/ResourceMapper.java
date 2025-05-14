package com.hzx.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzx.lesson.model.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Resource)表数据库访问层
 * @author makejava
 * @since 2025-05-14 18:47:04
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    Resource queryById(Integer id);

    /**
     * 查询指定行数据
     * @param resource 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Resource> queryAllByLimit(Resource resource, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     * @param resource 查询条件
     * @return 总行数
     */
    long count(Resource resource);

    /**
     * 新增数据
     * @param resource 实例对象
     * @return 影响行数
     */
    int insert(Resource resource);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<Resource> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Resource> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     * @param entities List<Resource> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Resource> entities);

    /**
     * 修改数据
     * @param resource 实例对象
     * @return 影响行数
     */
    int update(Resource resource);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

