package com.tanhua.dubbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tanhua.domain.db.BlackList;
import com.tanhua.domain.db.UserInfo;
import org.apache.ibatis.annotations.Select;

/**
 * 黑名单持久层接口
 */

public interface BlackListMapper extends BaseMapper<BlackList> {
    @Select("select tui.* from tb_user_info tui,tb_black_list tbl\n" +
            "where tbl.user_id = #{userId} and tui.id = tbl.black_user_id")
    IPage<UserInfo> queryBlacklist(Page pageRequest, Long userId);
}
