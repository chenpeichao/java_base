package org.pcchen.pdmi.caiyun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 爬虫规则解析
 *
 * @author ceek
 * @create 2020-09-28 15:51
 **/
public class CrawlerRuleParse {
    public static void main(String[] args) {
        String parseJson = "{\"media_1\":{\"dir\":[],\"media_column\":[{\"media\":68,\"column\":[3,6]},{\"media\":86,\"column\":[1,2,4,5]},{\"media\":6,\"column\":[1,3,80,81,263,345,347,353,357,360]},{\"media\":63}],\"root\":1},\"media_2\":{\"dir\":[],\"media_column\":[{\"media\":1199,\"column\":[2,3,29,30,31,32,33,34,35]},{\"media\":1206,\"column\":[1]},{\"media\":1242,\"column\":[1,2]},{\"media\":66,\"column\":[1,2,4,5]},{\"media\":1203,\"column\":[1]},{\"media\":832,\"column\":[1,15]},{\"media\":1243,\"column\":[1]},{\"media\":1209,\"column\":[3]},{\"media\":1398,\"column\":[1]},{\"media\":1276,\"column\":[1,2]},{\"media\":1426,\"column\":[1,2,3]},{\"media\":1298},{\"media\":1260,\"column\":[1]},{\"media\":1248,\"column\":[10]},{\"media\":1261},{\"media\":1371,\"column\":[2,7]},{\"media\":1473,\"column\":[1]},{\"media\":1231,\"column\":[1]},{\"media\":1777},{\"media\":700,\"column\":[10]},{\"media\":1240,\"column\":[1]},{\"media\":1413,\"column\":[7,8]},{\"media\":764,\"column\":[8]},{\"media\":1300,\"column\":[16,17]},{\"media\":1211,\"column\":[1,11]},{\"media\":1627,\"column\":[5,6]},{\"media\":1207,\"column\":[3]},{\"media\":1262,\"column\":[3]},{\"media\":1284,\"column\":[1]},{\"media\":732,\"column\":[11]},{\"media\":820,\"column\":[13]},{\"media\":942,\"column\":[8]},{\"media\":1813},{\"media\":1812},{\"media\":21},{\"media\":1732,\"column\":[1,2]},{\"media\":1840,\"column\":[1,6]},{\"media\":111},{\"media\":1218,\"column\":[1]},{\"media\":1302},{\"media\":1831},{\"media\":1306},{\"media\":1668},{\"media\":1841},{\"media\":1833},{\"media\":89},{\"media\":1844},{\"media\":1810},{\"media\":1877,\"column\":[1]},{\"media\":1347},{\"media\":1860},{\"media\":1876},{\"media\":1011},{\"media\":969},{\"media\":1576},{\"media\":1632},{\"media\":1247},{\"media\":962},{\"media\":1346},{\"media\":1249},{\"media\":1380},{\"media\":1906,\"column\":[1]},{\"media\":1907},{\"media\":1401},{\"media\":1403},{\"media\":1233},{\"media\":1892},{\"media\":1917},{\"media\":1513},{\"media\":1898},{\"media\":1933},{\"media\":1956},{\"media\":1919},{\"media\":1957},{\"media\":1958},{\"media\":1655},{\"media\":1642},{\"media\":1258},{\"media\":1969},{\"media\":1942},{\"media\":1643},{\"media\":1631},{\"media\":1975},{\"media\":1976},{\"media\":1977},{\"media\":1993},{\"media\":1996},{\"media\":1997},{\"media\":1984},{\"media\":1511},{\"media\":1994},{\"media\":1458},{\"media\":2025},{\"media\":2049,\"column\":[1]},{\"media\":1816},{\"media\":3766},{\"media\":1434},{\"media\":1205},{\"media\":1479},{\"media\":3947},{\"media\":4022},{\"media\":1355,\"column\":[1]},{\"media\":4041},{\"media\":4075},{\"media\":1835},{\"media\":1995},{\"media\":4299},{\"media\":2054}],\"root\":2},\"tags\":[],\"is_original\":1,\"only_image\":0}";

        JSONObject jsonObject = JSONObject.parseObject(parseJson);

        JSONObject media_1JSONObject = jsonObject.getJSONObject("media_1");
        JSONObject media_2JSONObject = jsonObject.getJSONObject("media_2");

        JSONArray media_1Andmedia_columnJSONArray = media_1JSONObject.getJSONArray("media_column");
        JSONArray media_2Andmedia_columnJSONArray = media_2JSONObject.getJSONArray("media_column");


        Map<String, String> resultMap = new HashMap<String, String>();

        for (int i = 0; i < media_1Andmedia_columnJSONArray.size(); i++) {
            String mediaId = media_1Andmedia_columnJSONArray.getJSONObject(i).getString("media");
            String column = "";
            if (null != media_1Andmedia_columnJSONArray.getJSONObject(i).get("column")) {
                column = media_1Andmedia_columnJSONArray.getJSONObject(i).getString("column");
            }
            if (StringUtils.isNotBlank(column)) {
                resultMap.put(mediaId, column.substring(1, column.length() - 1));
            } else {
                resultMap.put(mediaId, "-1");
            }
        }

        for (int i = 0; i < media_2Andmedia_columnJSONArray.size(); i++) {
            String mediaId = media_2Andmedia_columnJSONArray.getJSONObject(i).getString("media");
            String column = "";
            if (null != media_2Andmedia_columnJSONArray.getJSONObject(i).get("column")) {
                column = media_2Andmedia_columnJSONArray.getJSONObject(i).getString("column");
            }
            if (StringUtils.isNotBlank(column)) {
                resultMap.put(mediaId, column.substring(1, column.length() - 1));
            } else {
                resultMap.put(mediaId, "-1");
            }
        }

        Set<String> mediaIdSet = resultMap.keySet();

        StringBuffer mediaIdAll = new StringBuffer();
        for (String mediaId : mediaIdSet) {
            if ("-1".equals(resultMap.get(mediaId))) {
//                mediaIdAll.append(mediaId + ",");
            } else {
                System.out.println(mediaId + "\t" + resultMap.get(mediaId));
            }
        }
        System.out.println(mediaIdAll.toString());
    }
}
