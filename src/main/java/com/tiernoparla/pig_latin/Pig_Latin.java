package com.tiernoparla.pig_latin;

public class Pig_Latin {

    static int cuentaPalabras(String str, char ch)
    {
        int	n_palabras = 0;
        int	flag = 0;
        int i = 0;
    
        while (i < str.length())
        {
            if (str.charAt(i) != ch && flag == 0)
            {
                flag = 1;
                n_palabras++;
            }
            else if (str.charAt(i) == ch)
                flag = 0;
            i++;
        }
        return (n_palabras);
    }

    static String[] FuckingSplit(String str, char ch)
    {
        int i = 0;
        int start = 0;
        String[] result = new String[cuentaPalabras(str, ch)]; 
        int n = 0;
        while(i < str.length())
        {
            while(str.charAt(i) == ch && i < str.length())
                i++;
            start = i;
            while(str.charAt(i) != ch && i < str.length())
            {
                i++;
                if (i == str.length())
                    break ;
            }
            result[n] = str.substring(start, i);
            n++;
        }
        return result;
    }

    static String vocales (String str)
    {
        str = str + "ay";
        return str;
    }
    static String consonantes (String str)
    {
        String inicio = "" + str.charAt(0);
        if (esConsonante(str.charAt(1)) == true  || str.charAt(1) == 'h' || str.charAt(1) == 'H')
        {
            inicio += str.charAt(1);
            str = str.substring(2) + inicio.toLowerCase() + "ay";
            return str;
        }            
        str = str.substring(1) + inicio.toLowerCase() + "ay";
        return str;
    }

    static boolean esVocal(char c)
    {
        String vocales = "aeiouhAEIOUH";
        for(int i = 0; i < vocales.length(); i++)
            if(c == vocales.charAt(i))
                return true;
        return false;
    }
    static boolean esConsonante(char c)
    {
        String vocales = "BCDFGKLMNÑPQRSTVWXYZbcdfgklmnñpqrstvwxyz";
        for(int i = 0; i < vocales.length(); i++)
            if(c == vocales.charAt(i))
                return true;
        return false;
    }

    static String traductor(String str)
    {
        int i = 0;
        String[] arrStr = FuckingSplit(str, ' ');
        int size = arrStr.length;
        String result = "";
        while (i < size)
        {
            if(esVocal(arrStr[i].charAt(0)) == true)
                arrStr[i] = vocales(arrStr[i]);
            else if (esConsonante(arrStr[i].charAt(0)) == true)
                arrStr[i] = consonantes(arrStr[i]);                
            i++;
        }
        i = 0;
        while(i < arrStr.length)
        {
            result += arrStr[i] + " ";
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(traductor("Hola Bhuenas"));
    }
}
