package Oblig3DAPE1400;

import static javax.swing.JOptionPane.*;
/*
Det skal lages et program som trekker tilfeldige tall og lagrer dem i en array.
Hvor mange tall som skal trekkes er avhengig av arrayets lengde, som er parameter i klassens konstruktør.
(Hele arrayet skal fylles) Programmet skal imidlertid bare lagre de tall som ikke er trukket allerede.
Dvs. arrayet skal inneholde KUN ÈN forekomst av hvert tall. Alle tall som trekkes skal være i intervallet 100 til 999,
begge grenser inkludert.

Når alle tallene er generert og lagret i arrayet, skal programmet finne den største, minste og gjennomsnittlige
verdien av tallene i arrayet.
Til slutt skal programmet skrive ut, i en meldingsboks, tallene i arrayet, samt resultatet av beregningene
som er beskrevet over:
 */
public class Array {

    // Deklarasjon av array for lagring av tilfeldige heltall

    int[] array;

   /* Konstruktør som mottar arrayets lengde som parameter og
     oppretter arrayet.  */

    public Array(int lengde) {
        array = new int[lengde];
    }

    /* Metode som skal undersøke om et gitt tall finnes i arrayet fra før.
      Tallet det letes etter skal mottas som parameter.
      Metoden skal returnere true hvis tallet finnes i arrayet.
      Hvis ikke skal metoden returnere false. */

    public boolean sjekkTall(int tall) {
        for (int i : array) {
            if (tall == i) {
                return true;
            }
        }
        return false;
    }


    /* Metode som skal fylle arrayet med tilfeldige tall mellom 100 og 999,
      begge grenser inkludert. Metoden skal gjøre dette på en måte
      som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
      parametre og heller ikke returnere noen verdi.
      Tips bruk (int)(Math.random()*(900)+100); for å generere tallene mellom 100 og 999
    */
    public void fyllArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] += (int) (Math.random() * (900) + 100);
        }
    }

    // Metode som finner og returnerer det minste tallet i arrayet.

    public int minste() {
        int minste = array[0];
        for (int i : array) {
            if (i < minste) {
                minste = i;
            }
        } return minste;
    }
    // Metode som finner og returnerer det største tallet i arrayet.

    public int storste() {
        int storste = 0;
        for (int i : array) {
            if (i > storste) {
                storste = i;
            }
        } return storste;
    }

    /*  Metode som beregner og returnerer den gjennomstnittlige verdien
      (double-verdi) av tallene i arrayet.  */
    public double snitt() {
        double gjennomsnitt = 0;
        int sum = 0;
        for (int i : array) {
            sum += i;
            gjennomsnitt = (double) sum/array.length;
        }
        return gjennomsnitt;
    }
    /* Metode som viser tallene i arrayet i en meldngsboks.
      I tillegg skal det, i meldingsboks, skrives ut
      opplysninger om hvilket tall som er minst, hvilket som er størst, og
      hva som er gjennomsnittsverdien, jfr bildet over. Gjennomsnittverdien
      skal skrives ut med en desimal. Bruk gjerne String.format("%.2f,tall) til dette.
      Legg inn mellomrom mellom tallene og skriv ut et passende antall tall
      per linje. */
    public void ut() {

        String ut = " ";

        int teller = 0;
        for (int i : array){
            ut += i + " ";
            while (!sjekkTall(i)){
                i ++;
            }
            teller++;
            if (teller % 10 == 0) {
                ut += "\n";
            }
        }

        ut += "\n";
        ut += "Det minste tallet er : " + minste() + "\n";
        ut += "Det største tallet er : " + storste() + "\n";
        ut += "Gjennomsnittet er : " + String.format("%.2f",snitt());


        showMessageDialog(null, ut);
    }
    public static void main(String[]args){
        int lengde = Integer.parseInt(showInputDialog("Skriv lengden på arrayet"));

        Array array1 = new Array(lengde);
        array1.fyllArray();
        array1.ut();
    }
}
