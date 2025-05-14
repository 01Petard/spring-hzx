package com.hzx.lesson.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MyMetaObjectHandler
 * @author zexiao.huang
 * @since 2025-05-06 09:49:23
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 逻辑删除，默认未删除
        if (metaObject.hasSetter("deleted")) {
            this.strictInsertFill(metaObject, "deleted", Boolean.class, false);
        }
        // 创建人
//        if (metaObject.hasSetter("createId")) {
//            this.strictInsertFill(metaObject, "createId", Long.class, SecurityHelper.getCurrentUser().getUserId());
//        }
        // 创建时间
        if (metaObject.hasSetter("createAt")) {
            this.strictInsertFill(metaObject, "createAt", Date.class, new Date());
        }
        // 修改人（初始同创建人）
//        if (metaObject.hasSetter("updateId")) {
//            this.strictInsertFill(metaObject, "updateId", Long.class, SecurityHelper.getCurrentUser().getUserId());
//        }
        // 修改时间（初始同创建时间）
        if (metaObject.hasSetter("updateAt")) {
            this.strictInsertFill(metaObject, "updateAt", Date.class, new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 修改人
//        if (metaObject.hasSetter("updateId")) {
//            this.strictUpdateFill(metaObject, "updateId", Long.class, SecurityHelper.getCurrentUser().getUserId());
//        }
        // 修改时间
        if (metaObject.hasSetter("updateAt")) {
            this.strictUpdateFill(metaObject, "updateAt", Date.class, new Date());
        }
    }
}

