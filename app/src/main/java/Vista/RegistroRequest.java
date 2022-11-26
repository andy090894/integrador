package Vista;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {
    private static final String ruta="http://192.168.1.70/registro.php";
    private Map<String,String> parametros;
    public RegistroRequest(String usuario, String nombre, String apellido, String clave, int edad, Response.Listener<String> listener){
        super(Request.Method.POST,ruta,listener,null);
        parametros =new HashMap<>();
        parametros.put("usuario",usuario+"");
        parametros.put("nombre",nombre+"");
        parametros.put("apellido",apellido+"");
        parametros.put("clave",clave+"");
        parametros.put("edad",edad+"");
    }

    @Override
    protected Map<String, String> getParams(){
        return parametros;
    }
}

