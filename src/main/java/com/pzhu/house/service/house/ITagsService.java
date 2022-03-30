package com.pzhu.house.service.house;

import com.pzhu.house.entity.house.Tags;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pzhu.house.model.house.TagModel;

import java.util.List;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-30
 */
public interface ITagsService extends IService<Tags> {

    List<TagModel> getTagList(Long id);
}
