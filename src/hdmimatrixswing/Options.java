package hdmimatrixswing;

import com.google.gson.Gson;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class Options implements Serializable
{
    public int currentSpeed=19200;
    public int parity=0;
    public int databytes=8;
    public int stopbits=1;
    public String currentPort;
    public HashMap<String,Template> templates= new HashMap<String,Template>();
    
    public boolean applyinstantly;
    public boolean applyontemplateselect;
    String[] names;
    
    private static final File optionsFile = new File("options.json");
    
    private static Options _Options=null;
    
    private Options(){}
    
   public static Options get()
    {
        if (_Options==null)
        {
            load();
            if (_Options==null)
            {
                _Options= new Options();
                save();
            }
        }
        return _Options;
    }
   
   public static void save()
   {
        Gson g = new Gson();
        String json=g.toJson(_Options);
        Helper.saveFile(json,optionsFile.getAbsolutePath());
   }
   
    private static void load()
    {
        File f = new File("options.json");
        
        if (f.exists())
        {
            Gson g = new Gson();
            String json=Helper.readFileFast(optionsFile.getAbsolutePath());
            _Options=g.fromJson(json, Options.class);
        }
    }
}
