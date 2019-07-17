package hdmimatrixswing;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Helper 
{
    
    public static void saveFile(String text,String filePathAndName)
    {   
        try
        {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathAndName), "utf-8"));
            writer.write(text);
            writer.close();
        }
        catch(Exception exc)
        {
           exc.printStackTrace();
        }
    }
    
    public static  String readFileFast(String filename)
    {

        try
        {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            return new String(data, "UTF-8");
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }
        return null;
    }
       
    public static void clerAndFillCombo(JComboBox box,ArrayList<StringClass> items)
    {
       box.removeAllItems();
       if (items!=null && items.size()>0)
       {
           for (StringClass item: items)
           {
               box.addItem(item);
           }
       }
    }
    public static void clerAndFillCombo(JComboBox box,String item)
    {
       box.removeAllItems();
       if (item!=null )
       {
            box.addItem(item);
       }
    }
    
  
    public static double round(double x, int scale) {
        return round(x, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static double round(double x, int scale, int roundingMethod) {
        try {
            return (new BigDecimal
                    (Double.toString(x))
                    .setScale(scale, roundingMethod))
                    .doubleValue();
        } catch (NumberFormatException ex) {
            if (Double.isInfinite(x)) {
                return x;
            } else {
                return Double.NaN;
            }
        }
    }

    /**
     * Encapules the sleep into try catch.. so we dont need
     * to write this stuff everytime
     * @param time
     */
    public static void sleep(int time)
    {
        try{Thread.sleep(time);}catch(Exception exc){}
    }

    public static byte setUnsetBit(byte inputByte, int bitPosition,boolean set)
    {
        if (set)
        {
            byte result=(byte) (inputByte | (1 << bitPosition));
            return result; //unset bit
        }
        else
        {
            byte result=(byte) (inputByte &~ (1 << bitPosition));
            String x= Helper.printByte(result);
            return result; //set bit
        }
    }

    /**
     * Check if bit is set
     * @return
     */
    public static boolean cBis(byte input,int position)
    {
        if (position==7)
        {
            if (input<0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        return ((byte) (input & (1 << position)))>0?true:false;
    }


    /**
     * Converts an integer into byte blocks.. form the given size..
     * e.g. for a 32 bit integer use a size of 4 bytes
     * @param number
     * @param byteSize
     * @return
     */
    public static byte[] getByteArrayFromInteger(int number,int byteSize)
    {
        return ByteBuffer.allocate(byteSize).putInt(number).array();
    }

    /**
     * Gets the unsigned value of the given bytes within the given bitlength.. the count will start at the MSB popsition down to LSB
     * @param bytes
     * @param bitLength
     * @return
     */
    public static int getIntegerfromBytes(byte[] bytes, int bitLength)
    {

        // this will generate the bit table for calculations..
        // e.g. when a length of 8 bits are given.. the result would look like 1 2 4 8 16 32 64 128 256
        int[] bitTable= new int[bitLength];
        for (int i=0;i<bitLength;i++)
        {
            bitTable[i]=(int)Math.pow(2D, (double)i);
            if (i==0){bitTable[i]=1;}
        }

        int result=0;
        int count=bitLength-1;
        for (int i=0;i<bytes.length;i++) // go trough the byte array
        {
            int mm=0;
            for (int a=7;a>=0;a--) // go though the single byte in this array element (count from lsb to msb)
            {
                if (a==7) // if we found the lsb
                {
                    if (bytes[i]<0)// msb of the byte is set (java have signed bytes.. so if the msb is set, then java interprets this as -127 and not 128)
                    {
                        result+=bitTable[count];
                    }
                }
                else
                {
                    if (cBis(bytes[i],a))
                    {
                        result+=bitTable[count];
                    }
                }
                count--;
                if (count==-1){return result;}
            }
        }

        return result;
    }

    public static int calcTwoComplement16Bit(byte MSB,byte LSB)
    {
        if (MSB<0)// the value is negative
        {
            LSB=(byte) (LSB-1);
            LSB=(byte) (~LSB &0xFF);

            MSB=(byte) (~MSB & 0xFF);
            MSB=(byte) (MSB &~ (1 << 7));

            return getIntegerfromBytes(new byte[]{MSB, LSB},16);
        }
        else // the value is positive
        {
            return getIntegerfromBytes(new byte[]{MSB, LSB},16);
        }
    }

    /**
     * Gets specific unsigned values from a byte and returns them as int. start from LSB and get to the MSB
     * The bis arent counted by its byte position, they are counted up to the from to count
     * if from to = 6-9 then the number will be as follows 6=1, 7=2, 8=4, 9=8; this would be 15
     * @param val
     * @param from
     * @param to
     * @return
     */
    public static int getNumberFromBits(byte val,int from, int to)
    {
        int []bitTable=new int[]{1,2,4,8,16,32,64,128};
        int result=0;
        int count=0;
        for (int i=from;i<to;i++)
        {
            if (cBis(val, i))
            {
                result+=bitTable[count];
            }
            count++;
        }

        return result;
    }

    public static byte shiftToRight(byte sourceByte, int shiftCount)
    {
        byte result=sourceByte;
        for (int a=0;a<shiftCount;a++)
        {
            for (int i=0;i<8;i++)
            {
                if (i>0 && i<7 && cBis(result,i))
                {
                    //01111000
                    result=(byte) (result | (1 << i-1));
                    result=(byte) (result &~ (1 << i));
                }
                else if (i==7 && ((int)(result & 0xff)>127) )
                {
                    result=(byte) (result | (1 << i-1));
                    int val=((int)result & 0xff)-128 ;
                    result=(byte)val;
                }
            }
        }

        return result;
    }


    /**
     * converts a byte array filled with uchar ascii symbols to a string
     * @param arr
     * @return
     */
    public static String getASCIIFromByteArray(Byte[] arr)
    {
        String str="";

        for (int i=0;i<arr.length;i++)
        {
            str+=String.valueOf((char)arr[i].byteValue());
        }

        return str;
    }

    /**
     * converts a byte array filled with uchar ascii symbols to a string
     * @param arr
     * @return
     */
    public static String getASCIIFromByteArray(byte[] arr)
    {
        String str="";

        for (int i=0;i<arr.length;i++)
        {
            str+=String.valueOf((char)arr[i]);
        }

        return str;
    }


    /**
     * Returns a textual version of a byte as a HEX value string
     * @param b
     * @return
     */
    public static String  printBytes(byte[] b)
    {
        Byte[] b2 = new Byte[b.length];
        for (int i=0;i<b.length;i++)
        {
            b2[i]=b[i];
        }

        String str="";
        for (int i=0;i<b2.length;i++)
        {
            str+=String.format("%8s",Integer.toBinaryString((b2[i] + 256) % 256)).replace(' ', '0');
        }
        return str;
    }

    /**
     * Returns a textual version of a byte as a HEX value string
     * @param b
     * @return
     */
    public static String  printBytes(Byte[] b)
    {
        String str="";
        for (int i=0;i<b.length;i++)
        {
            str+=String.format("%8s",Integer.toBinaryString((b[i] + 256) % 256)).replace(' ', '0');
        }
        return str;
    }

    /**
     * Returns a textual version of a byte as a HEX value string
     * @param b
     * @return
     */
    public static String  printByte(Byte b)
    {
        return printBytes(new Byte[]{b});
    }

    /**
     * Returns a textual version of a byte as a HEX value string
     * @param b
     * @return
     */
    public static String  printByte(byte b)
    {
        return printBytes(new Byte[]{b});
    }

    /**
     * Converts a hex string value to a byte and returns it
     * @param hexstr
     * @return
     * @throws Exception
     */
    public static byte getByteFromHexString(String hexstr) throws Exception
    {
        String hexVal=hexstr.toLowerCase();
        if (hexVal.startsWith("0x")){hexVal=hexVal.substring(2);}
        int xa= Integer.parseInt("ee", 16);

        byte hexValAsByte=(byte)xa;

        return hexValAsByte;
    }

    /**
     * Converts a hex value string to a integer and returns it
     * @param hexstr
     * @return
     * @throws Exception
     */
    public static int getIntFromHexString(String hexstr) throws Exception
    {
        String hexVal=hexstr.toLowerCase();
        if (hexVal.startsWith("0x")){hexVal=hexVal.substring(2);}
        int hexValAsInt=Integer.valueOf(hexVal,16);

        return hexValAsInt;
    }

    /**
     * Concats msb and lsb together, where lsb is a decimal place
     * @param MSB
     * @param LSB
     * @param decimals
     * @return MSB with fractional LSB
     */
    public static double convertBits(byte MSB,byte LSB,int decimals)
    {

        double msbd=(double) (MSB);
        double lsbd=(double)(LSB & 0xFF);// only 0xff here, because the fractional value is unsigned

        return msbd+(lsbd/decimals);
    }

    /**
     * Concats MSB,CSB and LSB together, where lsb is a decimal piont value and the other two values will be coverted to 16 bit int
     * @param MSB
     * @param CSB
     * @param LSB
     * @param decimals
     * @return concatinated MSB and CSB with fractional LSB
     */
    public static double convertBits(byte MSB,byte CSB,byte LSB,int decimals)
    {
        double lsbd=(double)(LSB &0xFF); // only 0xff here, because the fractional value is unsigned

        BitSet bs= BitSet.valueOf(new byte[]{MSB,CSB});
        long[] res= bs.toLongArray();
        if (res.length==0){return -1;}

        return res[0]+(lsbd/decimals);
    }

    public static String getwebData(String url) throws Exception
    {
        URL u = new URL(url);
        URLConnection spoof = u.openConnection();
        spoof.setRequestProperty("Accept-Charset", "ISO-8859-1");
        spoof.setConnectTimeout(10000);
        spoof.setReadTimeout(30000);
        spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    ioio)" );
        Charset charset = Charset.forName("ISO-8859-1");
        BufferedReader reader = new BufferedReader(new InputStreamReader(spoof.getInputStream(),charset));

        StringBuffer sb = new StringBuffer();
        String strLine = "";
        while ((strLine = reader.readLine()) != null){
            sb.append(strLine);
            sb.append('\n');
        }

        reader.close();
        return sb.toString();
    }
}
