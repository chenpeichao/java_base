package org.pcchen.javase.io;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

/**
 * 获取文件中字符串个数
 *
 * @author ceek
 * @create 2020-09-17 13:40
 **/
public class FileStringCount {
    public static void main(String[] args) throws IOException {
        String path = "E:\\abc";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        Map<String, Long> resultMap = new HashMap<String, Long>();
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

                String line = bufferedReader.readLine();
                int i = 0;
                while (StringUtils.isNotBlank(line)) {
                    String[] fields = line.split(" ");
                    String ip = fields[2];

                    if (null == resultMap.get(ip)) {
                        resultMap.put(ip, 1l);
                    } else {
                        resultMap.put(ip, resultMap.get(ip) + 1);
                    }

                    line = bufferedReader.readLine();
                }
            }
        }

        Collection<Long> values = resultMap.values();
        int sum = 0;
        for (Long count : values) {
            sum += count;
        }
        System.out.println("总访问次数：" + sum);
        List<Map.Entry<String, Long>> infoIds = new ArrayList<Map.Entry<String, Long>>(resultMap.entrySet());

        Collections.sort(infoIds, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println("ip" + "\t\t\t访问次数");
        for (int i = 0; i < 20; i++) {
            Map.Entry<String, Long> ent = infoIds.get(i);
            System.out.println(ent.getKey() + "\t\t\t" + ent.getValue());
        }
    }
}