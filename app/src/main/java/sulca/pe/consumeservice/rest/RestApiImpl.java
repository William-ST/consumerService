package sulca.pe.consumeservice.rest;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import sulca.pe.consumeservice.entity.DoctorEntity;

/**
 * Created by William_ST on 17/12/16.
 */

public class RestApiImpl implements RestApi {

    private Retrofit retrofit;

    public RestApiImpl(Context context) {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConnect.SERVICE_ENDPOINT)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }


    @Override
    public Observable<List<DoctorEntity>> getDoctors() {
        return Observable.create(new Observable.OnSubscribe<List<DoctorEntity>>() {
            @Override
            public void call(Subscriber<? super List<DoctorEntity>> subscriber) {
                try {
                    Call<List<DoctorEntity>> call = retrofit.create(ApiConnect.class).getDoctors();
                    Response<List<DoctorEntity>> response = call.execute();
                    subscriber.onNext(response.body());
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
