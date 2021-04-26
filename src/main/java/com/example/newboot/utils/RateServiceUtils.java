package com.example.newboot.utils;

//import cn.com.bsfit.frms.dao.domain.data.QueryData;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: wzl
 * @Date: 2020/6/12 15:42
 */
public class RateServiceUtils {


    /**
     * list 转 map
     *
     * @param dataList
     * @param keyFiled
     * @return
     */
//    public static Map<String, QueryData> list2Map(List<QueryData> dataList, String keyFiled){
//        Map<String, QueryData> result = Maps.newHashMapWithExpectedSize(dataList.size());
//        dataList.forEach(data->{
//            String key = MapUtils.getString(data,keyFiled);
//            if(StringUtils.isNotBlank(key)){
//                result.put(key, data);
//            }
//        });
//        return result;
//    }
    public static <K, V> Map<String, V> list2Map(List<V> dataList, String keyFiled) {
        Map<String, V> result = Maps.newHashMapWithExpectedSize(dataList.size());
        dataList.forEach(data -> {
            String key = MapUtils.getString((Map) data, keyFiled);
            if (StringUtils.isNotBlank(key)) {
                result.put(key, data);
            }
        });
        return result;
    }

    /**
     * 对象转list
     *
     * @param obj
     * @return
     */
    public static List<Map<String, Object>> getListByObject(Object obj) {
        List<Map<String, Object>> subChanls = new ArrayList<>();
        if (obj != null) {
            if (obj instanceof List) {
                subChanls = (List<Map<String, Object>>) obj;
            } else {
                List<Object> templist = JSON.parseArray(obj.toString());
                if (CollectionUtils.isNotEmpty(templist)) {
                    subChanls = templist.stream().filter(Objects::nonNull).map(mapObj -> {
                        Map<String, Object> tempMap = getMapByObject(mapObj);
                        return tempMap;
                    }).collect(Collectors.toList());
                }
            }
        }
        return subChanls;
    }

    /**
     * 对象转map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> getMapByObject(Object obj) {
        Map<String, Object> result = Maps.newHashMapWithExpectedSize(6);
        if (obj != null) {
            if (obj instanceof Map) {
                result = (Map<String, Object>) obj;
            } else {
                result = JSON.parseObject(obj.toString());
            }
        }
        return result;
    }

}
