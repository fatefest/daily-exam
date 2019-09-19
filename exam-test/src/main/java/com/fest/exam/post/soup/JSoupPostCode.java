package com.fest.exam.post.soup;

import com.yunche.inparts.common.util.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * @Author: yesitao
 * @Date: 2019/8/27 16:00
 * @Description:
 */
public class JSoupPostCode {
    private static final String BASE_URL = "http://www.yb21.cn";
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(BASE_URL).get();
            Elements elements = document.getElementsByClass("citysearch");
            for(Element e:elements){
                if("北京市".equals(e.child(0).html())){
                    Elements elements1 = e.getElementsByTag("ul");
                    for(Element e2:elements1){
                        Elements es2 = e2.getElementsByTag("a");
                        for(Element eee:es2){
                            getAllPostCodeHref(eee.attr("href"),eee.child(0).html());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getAllPostCodeHref(String url,String cityName){
        try{
            System.out.println(">>>>>>>>>>>"+cityName+"<<<<<<<<<<<<<");
            Document document = Jsoup.connect(BASE_URL+url).get();
            Elements elements = document.getElementsByTag("table");
            Element realTable = elements.get(3);
            Elements trs = realTable.getElementsByAttributeValue("align","center");
            for(Element tr:trs){
                Elements tds = tr.getElementsByTag("td");
                for(Element td:tds){
                    Elements ass = td.getElementsByTag("a");
                    if(ListUtils.isNotEmpty(ass)) {
                        getAreaNames(ass.attr("href"),cityName,ass.html());
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void getAreaNames(String url,String cityName,String code){
        try{
            System.out.println(">>>>>>>>>>>"+code+"<<<<<<<<<<<<<");
            String areaUrl = BASE_URL+url;
            Document document = Jsoup.parse(new URL(areaUrl).openStream(),"GBK",areaUrl);
            Elements line2s = document.getElementsByClass("line2");
            for(int i=1;i<line2s.size()-1;i++) {
                Element e = line2s.get(i);
                System.out.println(cityName + "-" + e.html().replace("&nbsp;", "") + "-" + code);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}