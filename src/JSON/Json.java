package JSON;

import CLASES.*;
import ENUMERACION.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;

public class Json {
    // Hacer los pasajes del set a jsonObjet de jsonObjet a jsonArray y de ahi a json
    //despues implementar esta clase e la clase tienda




    public JSONObject javaAJson(Indumentaria producto) {
        //Pasa de un obj java a obj Json
        JSONObject jsObject = null;
        try {

                jsObject = new JSONObject();
                jsObject.put("precio", producto.getPrecio());
                jsObject.put("stock", producto.getStock());
                jsObject.put("disponible", producto.isDisponible());
                jsObject.put("nombre", producto.getNombre());
                jsObject.put("tipoDeTela", producto.getTipoDeTela());
                jsObject.put("color", producto.getColor());
                if (producto instanceof Media) {
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


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsObject;
    }
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
    public void jsonObAJsArray(Iterator <Producto> productoIterator){
        //recibe iterador de indumentaria y pasa los ob
        JSONArray jsonArray= new JSONArray();
        while(productoIterator.hasNext()){
            Indumentaria indumentaria= (Indumentaria) productoIterator.next();
            JSONObject jsonObject = javaAJson(indumentaria);
            jsonArray.put(jsonObject);
        }
        JsonUtiles.grabar(jsonArray,"productos");
    }
    public void jsonAJava(String nombreArchivo, HashSet <Producto> productoHashSet) throws JSONException {
        // pasamos de obj json a obj java
        //JSONObject jsonObject1=new JSONObject(nombreArchivo);
        JSONArray jsonArray = new JSONArray(nombreArchivo);


       // JSONArray jsonArray = jsonObject1.getJSONArray(nombreArchivo);

        for(int i=0;i< jsonArray.length(); i++){

            JSONObject jsonObject= jsonArray.getJSONObject(i);
            NivelDeTalle auxNT= NivelDeTalle.valueOf(jsonObject.getString("talle"));
            Producto indumentaria= null;
           if(jsonObject.getString("nombre").equals("Media")){
               //transforma un string en una variable enum para pasarlo al constructor
               MedidaMedia auxMM= MedidaMedia.valueOf(jsonObject.getString("medidaMedia"));

                indumentaria =new Media(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),jsonObject.getBoolean("antideslizante"), auxMM);
           } else if (jsonObject.getString("nombre").equals("Buzo")) {
               TipoEstiloBuzo auxTE= TipoEstiloBuzo.valueOf(jsonObject.getString("estilo"));


               indumentaria =new Buzo(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,jsonObject.getBoolean("capucha"),jsonObject.getBoolean("cierre"),jsonObject.getBoolean("bolsillo"),auxTE);
           } else if (jsonObject.getString("nombre").equals("Pantalon")) {
               ModeloPantalon auxMP =ModeloPantalon.valueOf(jsonObject.getString("modelo"));

               indumentaria = new Pantalon(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,jsonObject.getDouble("tamañoCintura"),auxMP);
           } else if (jsonObject.getString("nombre").equals("Remera")) {
               TipoEstiloRemera auxER = TipoEstiloRemera.valueOf(jsonObject.getString("estilo"));
               indumentaria = new Remera(jsonObject.getDouble("precio"),jsonObject.getInt("stock"),jsonObject.getString("nombre"),jsonObject.getString("tipoDeTela"),jsonObject.getString("color"),auxNT,jsonObject.getString("cuello"),jsonObject.getString("mangas"),auxER);
           }
           productoHashSet.add(indumentaria);
        }



    }

}

