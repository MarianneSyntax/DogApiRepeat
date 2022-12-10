package com.example.dogapirepeat.data.remote
import com.example.dogapirepeat.data.model.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// 3 VARIABLEN, die von jeder ApiService Instanz nutzbar sein sollen: BASE_URL, moshi, retrofit

const val BASE_URL = "https://dog.ceo/api"


// speichert in der Variable moshi einen moshi Builder, der Json (Sprache der Antwort von der Website) in Kotlin konvertiert
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// speichert in der Variable retrofit einen Converter mit unserem moshi Builder speziell für unsere Base URL
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

// hier geht das Interface los, von dem konkrete Instanzen erstellt werden können
// interfaces sind dazu da, Funktionen bereitzustellen

interface ApiService {

    //get request:
    // wir wollen von der base_url aus die Antwort von folgender Adresse als Datentyp Response speichern:
    //https://dog.ceo/api/breed/beagle/images
    // (wir tun beispielsweise so, als wollten wir konkret zur rasse beagle, aber die Funktion soll allgemein
    // für alle Rassen funktionieren
    // und setzen in Z. 29 und 34 für {dogbreed} beispielhaft beagle in die Adresse:
    @GET("breed/{dogBreed}/images")
    //https://dog.ceo/api/breed/beagle/images
    suspend fun getDogPics(@Path("dogBreed") dogBreed: String): Response
    // Aufruf wäre zB im Repository: [....].getDogPics(beagle)


    object DogApi {
        val retrofitService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}


