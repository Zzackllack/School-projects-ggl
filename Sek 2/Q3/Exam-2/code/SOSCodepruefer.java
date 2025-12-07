
public class SOSCodepruefer { 

  private int zustand;

  private void zustandWechseln(char eingabe) {
    switch(zustand) {
      case 0: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 0; } break;
        }
      } break;
      case 1: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 2; } break;
        }
      } break;
      case 2: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 3; } break;
        }
      } break;
      case 3: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 4; } break;
        case '.': {zustand = 0; } break;
        }
      } break;  
      case 4: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 5; } break;
        case '.': {zustand = 0; } break;
        }
      } break;  
      case 5: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 6; } break;
        case '.': {zustand = 0; } break;
        }
      } break;    
      case 6: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 7; } break;
        }
      } break;    
      case 7: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 8; } break;
        }
      } break;
      case 8: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 9; } break;
        }
      } break;    
      case 9: {
        switch(eingabe) {
        case '#': {zustand = 10; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 9; } break;
        }
      } break;    
      case 11: {
        switch(eingabe) {
        case '#': {zustand = 11; } break;
        case '-': {zustand = 0; } break;
        case '.': {zustand = 1; } break;
        }
      } break;
    }
  } 
  
  public boolean wortUntersuchen(String text)
  {  
    boolean SOSistEnthalten = false;
    for (int i = 0; i < text.length(); i++) {
      zustandWechseln(text.charAt(i));
    }
    if (zustand == 10) {
      SOSistEnthalten = true; 
    }
    zustand = 0; //Anfangszustand z0
    return SOSistEnthalten;   
  }

  public static void main(String[] args) {    

    SOSCodepruefer sosp = new SOSCodepruefer();
    //Tests
    boolean erg1 = sosp.wortUntersuchen("#..---...#");      
    boolean erg2 = sosp.wortUntersuchen("#.....-----.#...---...#...---..-.---.-.-#");
    System.out.println(erg1);
    System.out.println(erg2);
  }
}


