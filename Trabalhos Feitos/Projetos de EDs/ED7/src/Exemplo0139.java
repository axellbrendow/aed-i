/*

PUC Minas - Ciência da Computação     Nome: Exemplo0139

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0139
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0139.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Checa se um caractere esta num intervalo de simbolos
     * @param character caractere a analisar
     * @param lowerLimit limite inferior do intervalo
     * @param upperLimit limite superior do intervalo
     * @return valor logico da proposicao da funcao
     */
    
    public static boolean isCharacterOnInterval(char character, char lowerLimit, char upperLimit)
    {
        return character >= lowerLimit && character <= upperLimit;
    }
    
    /**
     * Percorre uma cadeia de caracteres somando a quantidade de maiusculas
     * @param input cadeia de caracteres a ser analisada
     * @param index indice de comeco
     * @return quantidade de maiusculas
     */
    
    public static int getNumberOfUpperCases(String input, int index)
    {
        int numberOfUpperCases = 0;
        
        if (index < input.length()) // sera' valido ate o ultimo caractere
        {
            if (isCharacterOnInterval(input.charAt(index), 'A', 'Z'))
            {
                numberOfUpperCases++;
                data += input.charAt(index) + " ";
            }
            
            numberOfUpperCases += getNumberOfUpperCases(input, index + 1);
        }
        
        return numberOfUpperCases;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        int numberOfUpperCases;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0139");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            input = IO.readString("Informe uma cadeia de caracteres: ");
            IO.println();
            
        } while (input.length() < 1);
        
        numberOfUpperCases = getNumberOfUpperCases(input, 0);
        
        data += "-> Numero de maiusculas: " + numberOfUpperCases;
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
