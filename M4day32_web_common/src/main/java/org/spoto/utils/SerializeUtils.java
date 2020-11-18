package org.spoto.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * <p>Title : SerializeUtils</p>
 * <p>Description : 序列化工具类</p>
 * <p>DevelopTools : Eclipse_x64_v4.13.0</p>
 * <p>DevelopSystem : Windows10</p>
 * <p>Company : org.xujun</p>
 * @author : Jessica
 * @date : 2020年10月18日 下午16:04:34
 * @version : 2.0.0
 */
public class SerializeUtils {

    /**
     * 打开autotype功能
     */
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    /**
     * 将Object序列化成byte[]
     * 
     * @param object Object数据
     * @return byte[]数据
     */
    public static byte[] serializeToBytes(Object object) {
        return JSONObject.toJSONBytes(object, SerializerFeature.WriteClassName);
    }

    /**
     * 将byte[]反序列化成Object
     * 
     * @param bytes byte[]数据
     * @return Object数据
     */
    public static Object deserialize(byte[] bytes) {
        return JSONObject.parse(bytes, Feature.IgnoreNotMatch);
    }

    /**
     * 将Object序列化成String
     * 
     * @param object Object数据
     * @return String数据
     */
    public static String serializeToString(Object object) {
        return JSONObject.toJSONString(object, SerializerFeature.WriteClassName);
    }

    /**
     * 将String反序列化成Object
     * 
     * @param data String数据
     * @return Object数据
     */
    public static Object deserialize(String data) {
        return JSONObject.parse(data, Feature.IgnoreNotMatch);
    }

}