package com.example.demo;
import java.io.*;
import java.net.Socket;
/**
 * @author ZhangChen
 * @classname SocketTest
 * @description TODO
 * @date 2021/8/20 16:07
 */

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.0.199",60020);
        //键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //包装通道内的流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while((line = br.readLine()) != null){
            if("jieshu".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        s.close();
    }
}

