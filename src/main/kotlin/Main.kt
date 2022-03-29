import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

var gson = Gson()
fun main (){

    //CREAR EL CLIENTE
    var client = OkHttpClient()

    //HACE LA LLAMADA DE LA URL QUE LE PASO
    var request = Request.Builder().url("https://pokeapi.co/api/v2/pokemon/1").build()

    //CONSTRUIR LA PETICION
    val response = client.newCall(request).execute()

    //SI FUNCIONA QUE SAQUE LOS POKEMONS, SI NO, QUE DIGA ERROR
    if (response.isSuccessful){
        //TRANSFORMAR A GSON
        // EL LET SE USA PARA VARIABLES GLOBALES, SE HACE UNA COPIA AL MOMENTO
        response.body?.string().let { responseBody ->
           var pokemon = gson.fromJson(responseBody, Pokemon::class.java)

            println(pokemon.decirNombreyTipo())

        }

    }else{
        println("Algo ha ido mal")
    }

}
