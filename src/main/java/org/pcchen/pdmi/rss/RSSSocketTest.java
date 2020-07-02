package org.pcchen.pdmi.rss;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * rss的socket接口调用示例
 *
 * @author ceek
 * @create 2019-10-28 19:12
 **/
public class RSSSocketTest {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.currentThread().sleep(10);
//                System.out.println("调用了一次请求");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            new Thread(() -> {
//                JSONObject socketParam = new JSONObject();
//                socketParam.put("method", "content_search_item");
//
//                JSONObject socketParam2 = new JSONObject();
//                socketParam2.put("item_id", "7f586b3bc72871f27f735b891da3f4c3");
//                socketParam2.put("appkey", "UAR-000255_978");
//                socketParam.put("request_body", socketParam2);
//                String s = new RSSSocketTest().socketRequest("10.10.32.45", 17222, socketParam);
////                if(null == s || "".equals(s)) {
////                    System.out.println("调用了一次请求,返回为null");
////                }
//                System.out.println("调用了一次请求,【"+s+"】");
//            }).start();
        }
    }

    private String socketRequest(String socketIp, Integer socketPort, JSONObject socketParam) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Socket client = null;
        OutputStream out = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        try {
            client = new Socket(socketIp, socketPort);
            out = client.getOutputStream();
            // 发送请求消息
//            String sendStr = socketParam.toString() + "\n" + "exit" + "\n";
            String sendStr = socketParam.toJSONString() + "\n" + "exit" + "\n";
            out.write(sendStr.getBytes());
            out.flush();
            ir = new InputStreamReader(client.getInputStream(), "utf-8");

            br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
            String log = br.readLine();
            return log;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "1");
            resultMap.put("result", "请求失败请重试");
            return resultMap.toString();
        } finally {
            // 4.关闭资源
            if (ir != null) {
                try {
                    ir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
