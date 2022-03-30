package com.pzhu.house.service.house.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pzhu.house.entity.house.Tags;
import com.pzhu.house.mapper.house.TagsMapper;
import com.pzhu.house.model.house.TagModel;
import com.pzhu.house.service.house.ITagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author WuSJ
 * @since 2022-03-30
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {

    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public List<TagModel> getTagList(Long id) {
        List<Tags> tags = tagsMapper.selectList(new QueryWrapper<Tags>().eq("house_id", id));
        ArrayList<TagModel> list = new ArrayList<>();
        for (Tags tag : tags) {
            TagModel tagModel = new TagModel();
            tagModel.setId(tag.getId());
            tagModel.setContent(tag.getContent());
            list.add(tagModel);
        }
        return list;
    }
}
