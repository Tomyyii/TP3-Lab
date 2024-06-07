package JSON;

import CLASES.*;
import ENUMERACION.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;

public class Json {

    public JSONObject javaAJson(Indumentaria producto) {//Pasa de un obj java a obj Json

        JSONObject jsObject = null;
        try {// lanzamos exepcion

                jsObject = new JSONObject();
                jsObject.put("precio", producto.getPrecio());//cargamos una por una todas las variables de los productos
                jsObject.put("stock", producto.getStock());
                jsObject.put("disponible", producto.isDisponible());
                jsObject.put("nombre", producto.getNombre());
                jsObject.put("tipoDeTela", producto.getTipoDeTela());
                jsObject.put("color", producto.getColor());
                if (producto instanceof Media) {// verificamos que producto es cada uno
                    Media media = (Media) producto;
                    jsObject.put("media",mediaAJsonOb(media));
                } else if (producto instanceof Remera) {
                    Remera remera = (Remera) producto;
                    jsObject.put("remera",remeraAJsonOb(remera));
                } else if (producto instanceof Pantalon) {
                    Pantalon pantalon = (Pantalon) producto;
                    jsObject.put("pantalon",pantalonAJsonOb(pantalon));
                }else if (producto instanceof Buzo) {
                    Buzo buzo = (Buzo) producto;
                    jsObject.put("buzo",buzoAJsonOb(buzo));
                }


        } catch (JSONException e) {//recibimos la exepcion
            e.printStackTrace();
        }
        return jsObject;//retornamos el objeto
    }
// METODOS AUXISIALES PARA EL PASO DE PRODUCTOS JAVA A JSON
        public JSONObject mediaAJsonOb (Media media) throws JSONException {
            JSONObject jsObject = new JSONObject();

            jsObject.put("antideslizante", media.isAntideslizante());
            jsObject.put("medidaMedia", media.getMedidaMedia());

            return jsObject;

        }

    public JSONObject pantalonAJsonOb(Pantalon pantalon) throws JSONException {

        JSONObject jsObject = new JSONObject();

        jsObject.put("talle", pantalon.getTalle());
        jsObject.put("tamañoCintura", pantalon.getTamañoCintura());
        jsObject.put("modelo", pantalon.getModelo());

        return jsObject;
    }

    public JSONObject remeraAJsonOb(Remera remera) throws JSONException {

        JSONObject jsObject = new JSONObject();

        jsObject.put("talle", remera.getTalle());
        jsObject.put("cuello", remera.getCuello());
        jsObject.put("mangas", remera.getMangas());
        jsObject.put("estilo", remera.getEstilo());

        return jsObject;
    }

    public JSONObject buzoAJsonOb(Buzo buzo) throws JSONException {

        JSONObject jsObject = new JSONObject();

        jsObject.put("talle", buzo.getTalle());
        jsObject.put("capucha", buzo.isCapucha());
        jsObject.put("cierre", buzo.isCierre());
        jsObject.put("bolsillo", buzo.isBolsillo());
        jsObject.put("estilo", buzo.getEstilo());

        return jsObject;
    }
    public void jsonObAJsArray(Iterator <Producto> productoIterator){//cargamos un arreglo de json con los jsobject previamente cargados
        //recibe iterador de indumentaria
        JSONArray jsonArray= new JSONArray();
        while(productoIterator.hasNext()){
            Indumentaria indumentaria= (Indumentaria) productoIterator.next();
            JSONObject jsonObject = javaAJson(indumentaria);
            jsonArray.put(jsonObject);
        }
        JsonUtiles.grabar(jsonArray,"productos");
    }
   /* public void jsonAJava(String nombreArchivo, HashSet <Producto> productoHashSet) throws JSONException {
        // pasamos de obj json a obj java
        String jsonResponse = JsonUtiles.leer(nombreArchivo);
        JSONArray jsonArray = new JSONArray(jsonResponse);
        JSONObject jsonObject = null;

        for(int i=0;i< jsonArray.length(); i++){

            JSONObject aux = null;
            jsonObject = jsonArray.getJSONObject(i);
            Producto indumentaria= null;
           if(jsonObject.getString("nombre").equals("Media")){

                aux = jsonObject.getJSONObject("media");
               //transforma un string en una variable enum para pasarlo al constructor


           } else if (jsonObject.getString("nombre").equals("Buzo")) {

               aux = jsonObject.getJSONObject("buzo");
               T

           } else if (jsonObject.getString("nombre").equals("Pantalon")) {

               aux = jsonObject.getJSONObject("pantalon");
               ModeloPantalon auxMP =ModeloPantalon.valueOf(aux.getString("modelo"));
               NivelDeTalle auxNT2 = NivelDeTalle.valueOf(aux.getString("talle"));
               indumentaria = new Pantalon(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT2,aux.getDouble("tamañoCintura"),auxMP);

           } else if (jsonObject.getString("nombre").equals("Remera")) {

               aux = jsonObject.getJSONObject("remera");


           }
           productoHashSet.add(indumentaria);
        }


    }

    */
   public void jsonAJava(String nombreArchivo, HashSet <Producto> productoHashSet) throws JSONException
   {
       String jsResponse=JsonUtiles.leer(nombreArchivo);
       JSONArray jsonArray=new JSONArray(jsResponse);
       JSONObject jsonObject=null;

       for(int i=0;i<jsonArray.length();i++)
       {
           jsonObject=jsonArray.getJSONObject(i);
           Producto producto=null;
           
           if(jsonObject.getString("nombre").equals("Pantalon"))
           {
               producto=jsonOBJaPantalon(jsonObject);
           } 
           else if (jsonObject.getString("nombre").equals("Remera")) {
               producto=jsonOBJaRemera(jsonObject);
           }
           else if (jsonObject.getString("nombre").equals("Buzo")) {
               producto=jsonOBJaBuzo(jsonObject);
           }
           else if (jsonObject.getString("nombre").equals("Media")) {
               producto=jsonOBJaMedia(jsonObject);
           }
           productoHashSet.add(producto);
       }
   }

   //Las siguientes funciones reciben por parametro el jsonObject dentro del array con los atributos compartidos, y dentro de cada metodo se crea un jsonObject auxiliar para traer los atributos inidividuales de cada indumentaria

   public Media jsonOBJaMedia(JSONObject jsonObject) throws JSONException {

       JSONObject aux=jsonObject.getJSONObject("media");
       MedidaMedia auxMM= MedidaMedia.valueOf(aux.getString("medidaMedia"));
       return new Media(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),jsonObject.getBoolean("antideslizante"), auxMM);
   }

   public Pantalon jsonOBJaPantalon(JSONObject jsonObject) throws  JSONException
   {
       JSONObject aux=jsonObject.getJSONObject("pantalon");
       ModeloPantalon auxMP =ModeloPantalon.valueOf(aux.getString("modelo"));
       NivelDeTalle auxNT = NivelDeTalle.valueOf(aux.getString("talle"));
       return new Pantalon(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,aux.getDouble("tamañoCintura"),auxMP);
   }

   public Buzo jsonOBJaBuzo(JSONObject jsonObject)throws JSONException
   {

       JSONObject aux=jsonObject.getJSONObject("buzo");
       TipoEstiloBuzo auxTE= TipoEstiloBuzo.valueOf(aux.getString("estilo"));
       NivelDeTalle auxNT = NivelDeTalle.valueOf(aux.getString("talle"));
       return new Buzo(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,aux.getBoolean("capucha"),aux.getBoolean("cierre"),aux.getBoolean("bolsillo"),auxTE);
   }

   public Remera jsonOBJaRemera(JSONObject jsonObject) throws JSONException
   {
       JSONObject aux=jsonObject.getJSONObject("remera");
       NivelDeTalle auxNT = NivelDeTalle.valueOf(aux.getString("talle"));
       TipoEstiloRemera auxER = TipoEstiloRemera.valueOf(aux.getString("estilo"));
       return new Remera(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,aux.getString("cuello"),aux.getString("mangas"),auxER);
   }


}

