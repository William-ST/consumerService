package sulca.pe.consumeservice.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sulca.pe.consumeservice.entity.DoctorEntity;

/**
 * Created by William_ST on 17/12/16.
 */

public interface ApiConnect {

    public static String SERVICE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<DoctorEntity>> getDoctors();


}
