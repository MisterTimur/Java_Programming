
package java_example; 

import java.lang.Exception; 


public class Java_Example { 
    public static void main(String[] args) { 
       Интерпретатор интерпретатор = new Интерпретатор ();   
       интерпретатор.Выполнить("A=1 B=2 C=3 D=4 E=A+B*C+D E"); 
    }  
}

class Интерпретатор {

    String Про; // Текст программы 
    int    Нач; // Начало слова 
    int    Кон; // Конец слова 
    float[]Пер; // Масив с переменныеми 
     
    boolean Циф(){ // Если это цифра 
    boolean Рез=false;
    if ((Про.charAt(Кон)>='0')&&
        (Про.charAt(Кон)<='9')) Рез=true;
    return Рез;
    }  
    void    ДПр(){ // ПРопускает пробелы 
    while (Про.charAt(Нач)==' ')Нач=Нач+1;
    Кон=Нач;
    }
    String  Сло(){ // Возвращает слово 
    ДПр();Кон=Нач;    
    if (Циф()) {
    while (Циф()) Кон=Кон+1;
    Кон=Кон-1;
    } 
    String Рез=Про.substring(Нач,Кон+1);    
    return Рез;
    }
    boolean Бук(){ // Если это слово буква 
    boolean Рез=false;
    if ((Сло().charAt(0)>='A')&&
        (Сло().charAt(0)<='Z')) Рез=true;
    return Рез;
    } 
    void    Сле(){ // Переход к следующщему слову 
    Нач=Кон+1;Кон=Нач; 
    }
    String  Изв(){ // Извлечение соедующего слова 
    String Рез=Сло();
    Сле();
    return Рез;
    }
    float   Ско(){ // Обрабатывает скобку  
    float  Рез=0;
        if (Сло().charAt(0)=='(') {
        Сле();
        Рез=Плю();
        Сле();
    }
    else if (Бук()) {
         int Инд=(int)Сло().charAt(0);
         Рез=Пер[Инд];
         Сле();
         if (Сло().charAt(0)=='='){
         Сле();
         Рез=Плю();
         Пер[Инд]=Рез;
         System.out.print(Сло());  
         }
    } 
    else Рез=Float.valueOf(Изв());
    return Рез; 
    }
    float   Умн(float Рез){ // Осуществляет сложения вычитания  
          
     while ((Сло().charAt(0)=='*')||(Сло().charAt(0)=='/'))
     if (Сло().charAt(0)=='*') {Сле();Рез=Рез*Ско();} else   
     if (Сло().charAt(0)=='/') {Сле();Рез=Рез/Ско();}   
            
    return Рез;        
    }    
    float   Плю(){ // Осуществляет сложения вычитания  
         
     float Рез=Умн(Ско());
     while ((Сло().charAt(0)=='+')||(Сло().charAt(0)=='-'))
     if (Сло().charAt(0)=='+') {Сле();Рез=Рез+Умн(Ско());} else   
     if (Сло().charAt(0)=='-') {Сле();Рез=Рез-Умн(Ско());}   
            
    return Рез;        
    } 
 
    public float Выполнить(String Исходник){
     float Рез=0;
     Пер=new float[255];   
     Про=Исходник+"$";
     Нач=0;
     Кон=0;
     try{
     while (Нач<Про.length()-1) {
     Рез=Плю();
     System.out.println(Рез);
     }
     } catch(Exception e){
     System.out.println("Ошибка");    
     }
     return  Рез;
    }
}           
