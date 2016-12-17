package sulca.pe.consumeservice;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sulca.pe.consumeservice.entity.DoctorEntity;
import sulca.pe.consumeservice.rest.RestApiImpl;

public class MainActivity extends AppCompatActivity {

    private RestApiImpl restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restApi = new RestApiImpl(this);
        restApi.getDoctors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DoctorSubscriber());
    }

    public class DoctorSubscriber extends Subscriber<List<DoctorEntity>> {

        @Override
        public void onCompleted() {
            Log.v("Tag", "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.v("Tag", e.toString());
        }

        @Override
        public void onNext(List<DoctorEntity> doctorEntities) {
            Log.v("Tag", "onNext "+doctorEntities.size());
        }
    }
}
