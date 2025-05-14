package com.hzx.lesson.common.utils;

import com.hzx.lesson.common.result.ListModel;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * VoConvertUtils
 * @author zexiao.huang
 * @since 2025-05-08 11:33:18
 */
public class VoConvertUtils {

    /**
     * 将实体列表转换为 VO 列表并封装成 ListModel
     *
     * @param entityList 源实体列表
     * @param voClass    目标 VO 类
     * @param <E>        实体类型
     * @param <V>        VO 类型
     * @return ListModel 包含 VO 列表
     */
    public static <E, V> ListModel<V> convertList(List<E> entityList, Class<V> voClass) {
        if (entityList == null || entityList.isEmpty()) {
            return new ListModel<>(Collections.emptyList(), 0);
        }

        List<V> voList = entityList.stream()
                .map(entity -> {
                    try {
                        V vo = voClass.getDeclaredConstructor().newInstance();
                        BeanUtils.copyProperties(entity, vo);
                        return vo;
                    } catch (Exception e) {
                        throw new RuntimeException("VO 实例化失败", e);
                    }
                })
                .collect(Collectors.toList());

        return new ListModel<>(voList, voList.size());
    }
}