package com.example.lk.testplayvideo.data;

import com.example.lk.testplayvideo.bean.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lk on 2018/6/7.
 */

public class DataUtils {
    public static List<Video> getDataList() {
        List<Video> list = new ArrayList<>();
        list.add(new Video("一边看一边握紧了手中的保温杯……", 10000, "http://img.kaiyanapp.com/c2817fa80576406a8539a072f183cf90.jpeg?imageMogr2/quality/60/format/jpg", "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108065&resourceType=video&editionType=normal&source=aliyun"));
        list.add(new Video("教你有趣的 DIY 小技巧，体验亲自动手的无尽乐趣……", 1528292719, "http://img.kaiyanapp.com/5260e075e03b6e828d12b26b0c2c4372.jpeg?imageMogr2/quality/60/format/jpg", "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108064&resourceType=video&editionType=normal&source=aliyun"));
        list.add(new Video("原来卫生间还有这么好用的瓷砖！手感超棒", 108049, "http://img.kaiyanapp.com/27856a0c2855246c31c19f7a8fd814ce.jpeg?imageMogr2/quality/60/format/jpg", "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108049&resourceType=video&editionType=normal&source=aliyun"));
        list.add(new Video("他放弃50万年薪，归隐山林，只为这一壶酒",108049,"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108016&resourceType=video&editionType=normal&source=aliyun"));

        return list;
    }
}
