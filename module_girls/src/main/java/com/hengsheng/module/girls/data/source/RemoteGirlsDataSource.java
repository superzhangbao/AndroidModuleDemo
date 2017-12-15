package com.hengsheng.module.girls.data.source;


import com.hengsheng.module.girls.Constants;
import com.hengsheng.module.girls.data.GirlsDataSource;
import com.hengsheng.module.girls.data.bean.GirlsParser;
import com.hengsheng.module.core.http.DataType;
import com.hengsheng.module.core.http.HttpClient;
import com.hengsheng.module.core.http.OnResultListener;

public class RemoteGirlsDataSource implements GirlsDataSource {

    @Override
    public void getGirls(int size, int page, final LoadGirlsCallback callback) {
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.GAN_HUO_API)
                .url("福利/" + size + "/" + page)
                .bodyType(DataType.JSON_OBJECT, GirlsParser.class)
                .build();
        client.get(new OnResultListener<GirlsParser>() {

            @Override
            public void onSuccess(GirlsParser result) {
                callback.onGirlsLoaded(result);
            }

            @Override
            public void onError(int code, String message) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(String message) {
                callback.onDataNotAvailable();
            }
        });
    }

}
