package sulca.pe.consumeservice.rest;

import java.util.List;

import rx.Observable;
import sulca.pe.consumeservice.entity.DoctorEntity;

/**
 * Created by William_ST on 17/12/16.
 */

public interface RestApi {

    Observable<List<DoctorEntity>> getDoctors();

}
