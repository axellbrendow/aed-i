/*

PUC Minas - Ciência da Computação     Nome: Exemplo0151

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0151
{
    /**
     * Cuida do caso em que a funcao IO.readint() retorna 0
     * @param element retorno de IO.readint()
     * @param i numero antecessor da ordem do elemento no arranjo
     * @return 0 ou outro valor se assim o usuario desejar.
     */
    
    public static int careAbout0(int element, int i)
    {
        if (element == 0)
        {
            String option;

            do
            {
                option = IO.readString("Considerar valor informado como zero (s-n)? ");
                IO.println();
                
            } while (!option.equals("s") && !option.equals("n"));
            
            if (option.equals("n"))
            {
                element = IO.readint("Informe o " + (i + 1) + "o numero inteiro: ");
                IO.println();
                
                element = careAbout0(element, i);
            }
        }
        
        return element;
    }
    
    /**
     * Le o numero de elementos do arranjo (tamanho) e solicita esses elementos 
     * @return arranjo com os elementos
     */
    
    public static int[] readAndWriteArray()
    {
        int[] array = null;
        int numberOfElements;
        
        numberOfElements = IO.readint("Informe quantos numeros inteiros colocara' no arranjo: ");
        IO.println();
        
        if (numberOfElements < 1)
        {
            IO.println("Numero de elementos invalido");
        }
        
        else
        {
            array = new int[numberOfElements];
            int element;
            
            for (int i = 0; i < numberOfElements; i++)
            {
                element = IO.readint("Informe o " + (i + 1) + "o numero inteiro: ");
                IO.println();
                
                /*
                como nao e' possivel saber se o usuario digitou 0 ou um numero decimal
                ou um caractere que nao e' um digito, quando a funcao IO.readint()
                retornar 0, vou perguntar ao usuario se e' para considerar a entrada
                como 0 ou nao, caso nao, voltarei a perguntar o numero
                */
                element = careAbout0(element, i);
                
                array[i] = element;
            }
        }
        
        return array;
    }
    
    public static void showArraySize(int[] array)
    {
        IO.println("Numero de elementos do arranjo (tamanho): " + array.length);
    }
    
    public static void showArrayElements(int[] array)
    {
        IO.print("Arranjo: ");
        
        for (int element : array)
        {
            IO.print(element + " ");
        }
        
        IO.println();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int[] array;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0151");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        array = readAndWriteArray();
        
        if (array != null)
        {
            showArraySize(array);
            showArrayElements(array);
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
