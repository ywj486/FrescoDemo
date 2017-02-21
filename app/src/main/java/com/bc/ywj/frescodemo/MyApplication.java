package com.bc.ywj.frescodemo;

import android.app.Application;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;

import org.xutils.*;
import org.xutils.BuildConfig;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       //基本使用 Fresco.initialize(this);
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        //渐进式
        ImagePipelineConfig config=ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();
        Fresco.initialize(this,config);
    }
}
