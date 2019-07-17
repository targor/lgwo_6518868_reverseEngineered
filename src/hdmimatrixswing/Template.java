package hdmimatrixswing;

import hdmimatrixswing.MatrixHelper.Input;

public class Template
{
    
    // only inputs are saved, because... well inputs will be static every time.. only outputs will change
    public Input []inputs = new Input[4];
    
    // but we should save all names
    public String[] inputnames= new String[]{"Device IN 1","Device IN 2","Device IN 3","Device IN 4"};
    public String[] outputnames= new String[]{"Device OUT 1","Device OUT 2","Device OUT 3","Device OUT 4"};
    
    public String templateName="New Template";
    
    public Template(String templateName)
    {
        this.templateName=templateName;
    }
    
    @Override
    public String toString()
    {
        return templateName;
    }
}
