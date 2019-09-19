package com.fest.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

import static org.apache.kafka.common.requests.FetchMetadata.log;

/**
 * @Author: yesitao
 * @Date: 2019/7/8 11:01
 * @Description:
 */
@Component
public class KafkaListenerConfig {

    @KafkaListener(groupId = "${kafka.consumer.group.id}", topics = "${kafka.consumer.topic.flow}",containerFactory = "${kafka.consumer.group.factory}")
    public void listener(ConsumerRecord<byte[], byte[]> record, Acknowledgment ack) {
        log.info("接收到test消息>>>>>>>>>>>>>>>>>>>>>>>,key:{} , value:{} , partition:{}",record.key(),record.value().toString(),record.partition());
        String data = String.valueOf(record.value());
        try {
            if("123".equals(data)){
                throw new Exception("异常");
            }else{
                ack.acknowledge();
            }
        }catch (Exception ex){
            log.error("处理流程数据异常",ex);
        }
    }
//    @KafkaListener(groupId = "offset_group_id", topics = "__consumer_offsets",containerFactory = "${kafka.consumer.group.factory}")
//    public void offsetListener(ConsumerRecord<?, ?> record, Acknowledgment ack) {
//        log.info("接收到offset消息>>>>>>>>>>>>>>>>>>>>>>>,key:{} , value:{} , partition:{}",record.key(),record.value().toString(),record.partition());
//        try {
//
//        }catch (Exception ex){
//            log.error("处理流程数据异常",ex);
//        }
//    }
}
