package hdmimatrixswing;

import java.util.ArrayList;
import jssc.SerialPort;

public class RS232
{   
    
    public static boolean ConnectionTest(String port)
    {
        jssc.SerialPort p = new SerialPort(port);
        try 
        {
            if (p.openPort())
            {
               p.closePort();
               if (MatrixHelper.setChannelSeletion()==true && MatrixHelper.getIOStatus()!=null)
               {
                   return true;
               }
               return false;
            }
        }
        catch (Exception ex) 
        {
           ex.printStackTrace();
        }
        return false; 
    }
    
    public static jssc.SerialPort connect ( String port )
    {
        
        jssc.SerialPort p = new SerialPort(port);
        try 
        {
            if (p.openPort())
            {
                p.setParams(Options.get().currentSpeed, Options.get().databytes ,Options.get().stopbits,Options.get().parity);
                return p;
            }
        } 
        catch (Exception ex) 
        {
           ex.printStackTrace();
        }
        return null; 
    }
    
    public static void disconnect(jssc.SerialPort port)
    {
        try{port.closePort();}catch(Exception exc){}
    }
    
    private static byte[] convertByte(Byte[] bytes)
    {
        byte[] result= new byte[bytes.length];
        for (int i=0;i<bytes.length;i++)
        {
            result[i]=bytes[i];
        }
        return result;
    }
    
    public static ArrayList<Byte> send(Byte[] text,String port,boolean receive,boolean printReceivedData)
    {
        return send(convertByte(text),port,receive,printReceivedData);
    }
    
    public static ArrayList<Byte> send(ArrayList<Byte> text,String port,boolean receive,boolean printReceivedData)
    {
        Byte[] bytes=null;
        bytes=text.toArray(new Byte[text.size()]);
        
        return send(convertByte(bytes),port,receive,printReceivedData);
    }
    

    public static ArrayList<Byte> send(byte[] text, String port,boolean receive,boolean printReceivedData)
    {
        ArrayList<Byte> arr= new ArrayList<>();
        
        jssc.SerialPort selected= connect(port);

        if (selected != null && selected.isOpened())
        {
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        selected.writeBytes(text);

                        if (receive)
                        {
                            byte[] bytes=selected.readBytes(13,2000);
                            for (byte b:bytes)
                            {
                                arr.add(b);
                            }
                        }

                        if (printReceivedData)
                        {
                            for (byte b :arr)
                            {
                                String tmpi=Integer.toHexString(Helper.getIntegerfromBytes(new byte[]{b}, 8));
                                System.out.print(tmpi.length()<2?"0"+tmpi+" ":tmpi+" ");
                            }
                            System.out.println("");
                        }

                    }catch(Exception exc)
                    {
                        System.out.println("couldnt connect or send data");
                        exc.printStackTrace();
                    }
                    finally {
                        try{selected.closePort();}catch(Exception exc){}
                    }
                    }
            });
            t.start();
            int count=0;
            while (count<2000 && t.isAlive())
            {
                Helper.sleep(1);
                count++;
            }
            
            if (t.isAlive())
            {
                t.stop();
                try{selected.closePort();}catch(Exception exc){} 
                return null;
            }
            
        }
        return arr;
    }

}
