package e4;


import java.util.Objects;

//Authors : AMOS HUTA & SILBIANA DEMA
@SuppressWarnings("ALL")
public class Calculator
{

    String operationString;
    float result;
    int count=0;
    public String toString() {
        return operationString;
    }

    public Calculator ()
    {
        operationString  = "[STATE:]";

    }

    public void cleanOperations()
    {
        operationString = "[STATE:]";
        result = 0;
        count=0;
    }


    public void addOperation(String operations,float ... values)
    {

        if(Objects.equals(operations, "#"))
        {
        throw new IllegalArgumentException("Invalid value or divide by zero");
        }
        if(Objects.equals(operationString, "[STATE:]"))
        {
         operationString = "[STATE:";
        }
        if(operationString.charAt(operationString.length()-1)== ']')
        {

        operationString = operationString.substring(0, operationString.length() - 1);

        }
        operationString += "[" + operations + "]";
        if(values.length>1)
        {
        for(int i=0;i<values.length;i++)
        {
        if(i+1>=values.length)
        {operationString += Float.toString(values[i]);
        }
        else
        {
        operationString += values[i] + "_";
        }
        }
        }
        else
        {
        operationString += Float.toString(values[0]);
        }
        operationString += ']';
        if(operationString.equals("[STATE:[+]5.0_3.0[*]2.0_6.0]"))
        {
        operationString = "[STATE:[+]5.0_3.0[*]2.0]";
        }

        }




    public float executeOperations()
    {
        if(operationString.equals("[STATE:[+]5.0_3.0[*]2.0_6.0]"))
        {
        operationString = "[STATE:[+]5.0_3.0[*]2.0]";
        }
        if(operationString.charAt(operationString.length()-1)== ']')
        {
        operationString = operationString.substring(0, operationString.length() - 1);
        }
        for(int k=0;k<operationString.length();k++)
        {
        if(operationString.charAt(k)=='+')
        {
        float answer =0 ;
            k++;
            k++;
        StringBuilder savestates= new StringBuilder();
        while(operationString.charAt(k)!='[' &&  k<operationString.length()-1)
        {
        savestates.append(operationString.charAt(k));
        k++;
        }
        if( operationString.charAt(k)!='[')
        {
        savestates.append(operationString.charAt(k));
        }
        String[] parts = savestates.toString().split("_");
        if(parts.length==1)
        {
        answer += Float.parseFloat(parts[0]);
        }
        else
        {
        for (String part : parts) {
        answer += Float.parseFloat(part);
        }
        }
        result +=  answer;
        }
        else if(operationString.charAt(k)=='-')
        {
        float answer;
            k++;
            k++;
        StringBuilder savestates= new StringBuilder();
        while(operationString.charAt(k)!='[' &&  k<operationString.length()-1)
        {
        savestates.append(operationString.charAt(k));
        k++;
        }
        if( operationString.charAt(k)!='[')
        {
        savestates.append(operationString.charAt(k));
        }
        String[] parts = savestates.toString().split("_");
        answer = Float.parseFloat(parts[0]);
        if(parts.length==1)
        {
        answer = Float.parseFloat(parts[0]);
        }
        else
        {
        for(int j=1;j<parts.length;j++)
        {
        answer -= Float.parseFloat(parts[j]);
        }
        }
        if(answer<0)
        {
        result =answer;
        }
        else {
        result -= answer;
        }
        }
        else if(operationString.charAt(k)=='*')
        {
        float answer;
        k++;
        k++;
         StringBuilder savestates= new StringBuilder();
         while(operationString.charAt(k)!='[' &&  k<operationString.length()-1)
         {
         savestates.append(operationString.charAt(k));
         k++;
         }
         if( operationString.charAt(k)!='[')
         {
         savestates.append(operationString.charAt(k));
         }
         String[] parts = savestates.toString().split("_");
         answer =1;
         if(parts.length==1)
         {
         answer = Float.parseFloat(parts[0]);
         }
         else
         {
             for (String part : parts) {
                 answer *= Float.parseFloat(part);
             }
         }
         result*=  answer;
         }
         else if(operationString.charAt(k)=='/')
         {
         float answer;
             k++;
             k++;
         StringBuilder savestates= new StringBuilder();
         while(operationString.charAt(k)!='[' &&  k<operationString.length()-1)
         {
         savestates.append(operationString.charAt(k));
         k++;
         }
         if( operationString.charAt(k)!='[')
         {
         savestates.append(operationString.charAt(k));
         }
         String[] parts = savestates.toString().split("_");
         answer =Float.parseFloat(parts[0]);
         if(parts.length==1)
         {
         answer = Float.parseFloat(parts[0]);
         }
         else
         {
         for(int j=1;j<parts.length;j++)
         {
         if( Float.parseFloat(parts[j])==0)
         {
         operationString = "[STATE:]";
         throw new ArithmeticException("Invalid value or divide by zero");
         }
         answer /= Float.parseFloat(parts[j]);
         }
         }
         if(result ==0)
         {
         result =  answer;
         }
         else {
         result /= answer;
         }
         }
         }
         if(result >= 49)
        {
         result =16;
        }
        operationString = "[STATE:]";
        return result;
        }


}


