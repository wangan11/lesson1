package com.wangan.springcloud.event;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringCloudApplication
public class WanganSpringCloudEvent {



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
        //创建事件监听器
        context.addApplicationListener(new MyApplicationLister());
        //启动上下文
        context.refresh();
        //发布事件
        context.publishEvent(new MyApplicationEvent("hello word"));
        context.publishEvent(new MyApplicationEvent("hello word2"));
    }

    private static class MyApplicationLister implements ApplicationListener<MyApplicationEvent>{

        @Override
        public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
            System.out.println("MyApplicationLister source is: "+myApplicationEvent.getSource());

        }
    }

    private static class  MyApplicationEvent extends ApplicationEvent{
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

}
