public class BinaerrechnerAnpassungCE
{
  public static void main (String[] args)
  {
    Binaerzahl bin1 = new Binaerzahl(20);
    System.out.print("bin1 = ");
    bin1.print();
    System.out.println("dezWert von bin1 = "+bin1.dezWert()+"\n");

    Binaerzahl bin2 = new Binaerzahl(10);
    System.out.print("bin2 = ");
    bin2.print();
    System.out.println("dezWert von bin2 = "+bin2.dezWert()+"\n");

    Binaerzahl binSum = binAdd(bin1, bin2); 
    System.out.print("bin1+bin2 = ");
    binSum.print();
    System.out.println("dezWert von binSum = "+binSum.dezWert()+"\n");
  }
  
  public static Binaerzahl binAdd(Binaerzahl binA, Binaerzahl binB)
  {
    int maxLength = Math.max(binA.bin.length, binB.bin.length);
    //Neue Arrays machen um ausgleich zu machen
    int[] binArrayA = new int[maxLength];
    int[] binArrayB = new int[maxLength];

    //Die eigentlichen Arrays in die neuen Arrays kopieren
    System.arraycopy(binA.bin, 0, binArrayA, maxLength - binA.bin.length, binA.bin.length);
    System.arraycopy(binB.bin, 0, binArrayB, maxLength - binB.bin.length, binB.bin.length);

    int uebertrag = 0;
    //Binaerzahl binSum
    Binaerzahl binSum = new Binaerzahl(maxLength + 1);
    
    /*if(binA.bin.length>binB.bin.length)
    {
      maxLength=binA.bin.length;
    }
    else 
    {
      maxLength=binB.bin.length;
    }*/

    //Addieren
    for(int i = maxLength - 1; i >= 0; i--)
    {
      if (binArrayA[i] + binArrayB[i] + uebertrag == 3) {
        binSum.bin[i + 1] = 1;
        uebertrag = 1;
      } else if (binArrayA[i] + binArrayB[i] + uebertrag == 2) {
        binSum.bin[i + 1] = 0;
        uebertrag = 1;
      } else {
        binSum.bin[i + 1] = binArrayA[i] + binArrayB[i] + uebertrag;
        uebertrag = 0;
      }
      //binSum.bin[0] = uebertrag;
    }
    binSum.bin[0]=uebertrag; // Setzen des Übertrags nach der Schleife
    return binSum;
  }
 } 
