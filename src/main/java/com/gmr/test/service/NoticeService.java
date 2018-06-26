package com.gmr.test.service;

import com.gmr.test.dao.ClassMapper;
import com.gmr.test.dao.NoticeMapper;
import com.gmr.test.model.OV.FindNoticeInfo;
import com.gmr.test.model.OV.Result;
import com.gmr.test.model.entity.Class;
import com.gmr.test.model.entity.ClassExample;
import com.gmr.test.model.entity.Notice;
import com.gmr.test.model.entity.NoticeExample;
import com.gmr.test.model.jsonrequestbody.AddNoticeJsonRequest;
import com.gmr.test.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: test
 * @description: 公告service
 * @author: ggmr
 * @create: 2018-06-26 09:46
 */
@Service
public class NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private ClassMapper classMapper;

    public Result addNotice(String teacherId, AddNoticeJsonRequest addNoticeJsonRequest) {
        String className = addNoticeJsonRequest.getClassName();
        String title = addNoticeJsonRequest.getTitle();
        String content = addNoticeJsonRequest.getContent();
        String image = addNoticeJsonRequest.getImage();
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Class> existClass = classMapper.selectByExample(classExample);
        if(existClass.isEmpty()) {
            return ResultTool.error("不存在这个班级");
        }

        if(title.isEmpty() || content.isEmpty()) {
            return ResultTool.error("标题或内容不能为空");
        }

        Notice newNotice = new Notice();
        newNotice.setClassName(className);
        newNotice.setTitle(title);
        newNotice.setTeacherId(teacherId);
        String overview;
        if(content.length() > 200) {
            overview = content.substring(0, 200);
            newNotice.setContent(content);
        } else {
            overview = content.substring(0,content.length() - 1);
        }
        newNotice.setOverview(overview);

        if(image.isEmpty() == false) {
            newNotice.setImage(image);
        }
        noticeMapper.insert(newNotice);
        return ResultTool.success();
    }


    public Result findAllNotice(String className) {
        //先查看是否存在名字为classname的班级
        ClassExample classExample = new ClassExample();
        classExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Class> existClass = classMapper.selectByExample(classExample);
        if(existClass.isEmpty()) {
            return ResultTool.error("不存在这个班级");
        }

        //查询一个班级的公告
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.createCriteria()
                .andClassNameEqualTo(className);

        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
        if(noticeList.isEmpty()) {
            return ResultTool.error("这个班级没有公告");
        }
        List<FindNoticeInfo> findNoticeInfoList = new LinkedList<>();
        for(Notice notice : noticeList) {
            FindNoticeInfo findNoticeInfo = new FindNoticeInfo();
            findNoticeInfo.setId(notice.getId());
            findNoticeInfo.setOverview(notice.getOverview());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
            String startTime = sdf.format(notice.getPublishTime());
            findNoticeInfo.setPublishTime(startTime);
            findNoticeInfo.setTitle(notice.getTitle());
            findNoticeInfo.setImage(notice.getImage());
            findNoticeInfoList.add(findNoticeInfo);
        }
        return ResultTool.success(findNoticeInfoList);
    }
}
