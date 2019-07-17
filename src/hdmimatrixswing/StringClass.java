package hdmimatrixswing;

public class StringClass
{
    public String name=null;
    public String type=null;
    public MatrixHelper.Output output=MatrixHelper.Output.NONE;
    public MatrixHelper.Input input=MatrixHelper.Input.NONE;
    public StringClass(String name)
    {
        this.name=name;
    }
    public StringClass(String name,String type)
    {
        this.name=name;
        this.type=type;
    }
    
    public StringClass(String name,MatrixHelper.Output out)
    {
        this.name=name;
        this.output=out;
    }
    public StringClass(String name,MatrixHelper.Input in)
    {
        this.name=name;
        this.input=in;
    }
    public StringClass()
    {
        
    }
    
    @Override
    public String toString()
    { 
        if (output!=output.NONE)
        {
           return name+" / "+String.valueOf(this.output);
        }
        else if (input!=input.NONE)
        {
           return name+" / "+String.valueOf(this.input);
        }
        else
        {        
            return name;
        }
    } 
}
