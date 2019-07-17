
package hdmimatrixswing;

import java.util.ArrayList;
import java.util.HashMap;


public class MatrixHelper
{    
    public enum Output{NONE,A,B,C,D};
    public enum Input{NONE,I1,I2,I3,I4};
    public enum CommandCode{}
    
    //#### Ready to use commandbyte packages to build the complete command to be sent to the matrix #####
    static Byte[] RW_HMDIPorts = new Byte[]{(byte)0x02,(byte)0x03};
    static Byte[] init = new Byte[]{(byte)0x01,(byte)0x0A};
    static Byte[] beep = new Byte[]{(byte)0x06,(byte)0x01};
    static Byte[] status1 = new Byte[]{(byte)0x01,(byte)0x04};
    static Byte[] status2 = new Byte[]{(byte)0x01,(byte)0x05};
    static Byte[] edid = new Byte[]{(byte)0x01,(byte)0x0C};
    static Byte[] matrix_port_status = new Byte[]{(byte)0x02,(byte)0x01};
    static Byte[] firmware_update1 = new Byte[]{(byte)0x01,(byte)0x01};
    static Byte[] firmware_update2 = new Byte[]{(byte)0x01,(byte)0x02};
    static Byte[] firmware_update3 = new Byte[]{(byte)0x01,(byte)0x03};
    //################################
    
     
    
    
    /**
     * Returns the general bytes that are send to the matrix at every writing process.
     * The bytes are: A5 5B 
     * Dont ask me why.. maybe its a kind ov version number or stuff.
     * 
     * @return 
     * Returns the array of these two bytes.
     */
    private static ArrayList<Byte>  getGeneralBytes()
    {
        ArrayList<Byte> bytes= new ArrayList<Byte>();
        
        bytes.add((byte)0xA5);
        bytes.add((byte)0x5B);
        return bytes;
    }
    
    
    /**
     * Generates and adds the checksum to the bytearray :)
     * @param bytes
     * @return 
     * Returns the bytearray with the calculated checksum.
     */
    private static ArrayList<Byte> checksum(ArrayList<Byte> bytes)
    {
        int val_a=(int)bytes.get(0)+(int)bytes.get(1);
        
        int val_b=0;
        for (int i=2;i<bytes.size();i++)
        {
            val_b+=(int)bytes.get(i);
        }
        bytes.add((byte)(val_a-val_b) );
        return bytes;
    }
    
    
    /**
     * sends the init command (currently i dont know what it does, and so 
     * i dont use it, because it doesnt interrupt the normal usage).
     * Also, within this command, the matrix wont generate a reply for it.
     * 
     * SEND: A5 5B 01 0A 00 00 00 00 00 00 00 00 F5
     * 
     */
    public static boolean setChannelSeletion()
    {
        ArrayList<Byte> bytes=  getGeneralBytes();
        bytes.addAll(getArrayList(init));
        
        
        for (int a=0;a<7;a++)
        {
            bytes.add((byte)0x00);
        }
        
        ArrayList<Byte> result = RS232.send(checksum(bytes),Options.get().currentPort,false,true);
        if (result==null){return false;}
        return true;
    }
    
    public static boolean setEDIDSelection()
    {
        ArrayList<Byte> bytes=  getGeneralBytes();
        bytes.addAll(getArrayList(edid));
        
        bytes.add((byte)0x01);
        
        for (int a=0;a<7;a++)
        {
            bytes.add((byte)0x00);
        }
        
        ArrayList<Byte> result = RS232.send(checksum(bytes),Options.get().currentPort,false,true);
        if (result==null){return false;}
        return true;
    }

    
    
    /**
     * Sends the beep command and sets it on or off. 
     * Because the reply from the matrix always sends back the same string, 
     * i havent added code that will process the reply..
     * 
     * SENT ON : A5 5B 06 01 0F 00 00 00 00 00 00 00 EA
     * SENT OFF: A5 5B 06 01 F0 00 00 00 00 00 00 00 09
     * 
     * REPLY FOR BOTH COMMANDS: A5 5B 06 01 00 00 00 00 00 00 00 00 F9
     * @param on 
     */
    public static void setBeep(boolean on)
    {
        ArrayList<Byte> bytes=  getGeneralBytes();
        bytes.addAll(getArrayList(beep));
        
        if (on)
        {
            bytes.add((byte)0x0F);
        }
        else
        {
            bytes.add((byte)0xF0);
        }
        
        for (int a=0;a<7;a++)
        {
            bytes.add((byte)0x00);
        }
        
        RS232.send(checksum(bytes),Options.get().currentPort,false,false);
    }
    
    /**
     * Asks and receives the status of all outputs/inputs.
     * 
     * GENERAL SEND: A5 5B 02 01 OUTPUT 00 00 00 00 00 00 00 CRC
     * 
     * RESPONSE    : A5 5B 02 01 OUTPUT 00 INPUT 00 00 00 00 00 CRC   
     * @return 
     * Returns a map of all outputs mapped to the correcponding input.
     */
    public static HashMap<Output,Input> getIOStatus()
    {
        if (Options.get().currentPort==null){return null;}
        
        HashMap<Output,Input> resultmap= new HashMap<>();
        
        for (int i=1;i<5;i++)
        {
            ArrayList<Byte> bytes=  getGeneralBytes();
        
            bytes.addAll(getArrayList(matrix_port_status));
        
            // go trough output channels
        
            bytes.add((byte)i);
            for (int a=0;a<7;a++)
            {
                bytes.add((byte)0x00);
            }
            
            //add checksum
            bytes=checksum(bytes);
            
            
            System.out.println("send:");
            for (byte b :bytes)
            {   
                String tmpi=Integer.toHexString(Helper.getIntegerfromBytes(new byte[]{b}, 8));
                System.out.print(tmpi.length()<2?"0"+tmpi+" ":tmpi+" ");
            }
           
            // now get the status
            ArrayList<Byte> result=RS232.send(bytes, Options.get().currentPort, true,false);
            if (result==null){return null;}
            
            System.out.println("");
            System.out.println("recv:");
            
            for (byte b :result)
            {
                String tmpi=Integer.toHexString(Helper.getIntegerfromBytes(new byte[]{b}, 8));
                System.out.print(tmpi.length()<2?"0"+tmpi+" ":tmpi+" ");
            }
            System.out.println("");
            
            if (result.size()==13)
            {
                Output o = Output.A;
                switch(i)
                {
                    case 1:o=Output.A;break;
                    case 2:o=Output.B;break;
                    case 3:o=Output.C;break;
                    case 4:o=Output.D;break;
                }
                
                int inpval=Helper.getIntegerfromBytes(new byte[]{result.get(6)},8);
                switch(inpval)
                {
                    case 1:{resultmap.put(o, Input.I1); break;}
                    case 2:{resultmap.put(o, Input.I2); break;}
                    case 3:{resultmap.put(o, Input.I3); break;}
                    case 4:{resultmap.put(o, Input.I4); break;}
                }
            }
            else
            {
                return null;
            }
            
        }
        
        return resultmap;
    }
       
    /**
     * Sets the matrix ports. Or in general. sets a input to a output or INPUT=OUTPUT to the matrix.
     * 
     * A5 5B 02 03 INPUT 00 OUTPUT 00 00 00 00 00 CRC
     * 
     * Response isnt interpreted by now.. i use the getio method and just read in all ports again.. doesnt make much effort at all..
     * 
     * @param output
     * @param input
     * @param send* @param input
     * @return 
     */
    public static ArrayList<Byte> setMatrixPort(Output output,Input input,boolean send)
    {
        ArrayList<Byte> bytes= getGeneralBytes();
        bytes.addAll(getArrayList(RW_HMDIPorts));
        
        byte outputbyte=0;
        byte inputdec=0;
        switch(input)
        {
            case I1:{inputdec=(byte)0x01;  break;}
            case I2:{inputdec=(byte)0x02; break;}
            case I3:{inputdec=(byte)0x03; break;}
            case I4:{inputdec=(byte)0x04; break;}
        }
        
        
        switch(output)
        {
            case A:{outputbyte=(byte)0x01;  break;}
            case B:{outputbyte=(byte)0x02;  break;}
            case C:{outputbyte=(byte)0x03;  break;}
            case D:{outputbyte=(byte)0x04;  break;}
        }
        

        bytes.add(inputdec);
        bytes.add((byte)0x00);
        bytes.add(outputbyte);
        
        for (int i=0;i<5;i++)
        {
            bytes.add((byte)0x00);
        }
        
        if (send){
            RS232.send(checksum(bytes), Options.get().currentPort, false,false);
        }
        else
        {
            return checksum(bytes);
        }
        return bytes;
    }
       
    //################# converter methods ###################
    public static byte[] getByteArray(ArrayList<Byte> list)
    {
        byte[] result= new byte[list.size()];
        int i=0;
        for (Byte b :list)
        {
            result[i]=b;
            i++;
        }
        return result;
    }
    
    public static ArrayList<Byte> getArrayList(Byte[] bytes)
    {
        ArrayList<Byte> result= new ArrayList<>();
        for (Byte b :bytes)
        {
            result.add(b);
        }
        return result;
    }
    //##########################
}
