package com.bc.ywj.frescodemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.my_image_view)
    private SimpleDraweeView draweeView;

    private String img_url0 = "http://gb.cri.cn/mmsource/images/2014/08/22/38/10202051462353342906.jpg";
    private String img_url1 = "http://attimg.dospy.com/img/day_101024/20101024_65c4c0e9b6404e1f4b8fHlZqY0hxz3qH.jpg";
    private String img_url2 = "http://attimg.dospy.com/img/day_101024/20101024_4905897f1d9a6c8e9436gxDWWH7cJ6JX.jpg";
    private String img_url3 = "https://a-ssl.duitang.com/uploads/item/201410/03/20141003200000_cJ5fv.jpeg";
    private String img_url4 = "http://7mno4h.com2.z0.glb.qiniucdn.com/3859deb07d4647cf9183f8ea3f5aa165.jpg";//大图

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);

//        Uri uri = Uri.parse(img_url0);
//        draweeView.setImageURI(uri);
      //渐进式  requestImage();
        //多图请求
        moreImages();
    }

    private void requestImage() {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(img_url1))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }
    private void moreImages(){
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(img_url4))
                .setImageRequest(ImageRequest.fromUri(img_url3))
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }
}
