package debug;


import com.hengsheng.module.news.Constants;
import com.hengsheng.module.news.data.bean.StoryList;
import com.hengsheng.module.core.base.BaseApplication;
import com.hengsheng.module.core.http.DataType;
import com.hengsheng.module.core.http.HttpClient;
import com.hengsheng.module.core.http.OnResultListener;
import com.orhanobut.logger.Logger;


/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:11
 * @version V1.2.0
 * @name NewsApplication
 */
public class NewsApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }


    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
                .url("20170419")
                .bodyType(DataType.JSON_OBJECT, StoryList.class)
                .build();
        client.get(new OnResultListener<StoryList>() {

            @Override
            public void onSuccess(StoryList result) {
                Logger.e(result.toString());
            }

            @Override
            public void onError(int code, String message) {
                Logger.e(message);
            }

            @Override
            public void onFailure(String message) {
                Logger.e(message);
            }
        });
    }

}
