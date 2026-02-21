public void quickSort(Liste<Integer> liste)
{
    if (laenge(liste) < 1){
        Liste<Integer> kleinere = new Liste<Integer>();
        Liste<Integer> groessere = new Liste<Integer>();
        liste.toFirst();
        int pivot = liste.getContent();
        liste.remove();
        while (!liste.isEmpty()){
            int akt = liste.getContent();
            if (akt < pivot){
                kleinere.append(akt);
            }
            else {
                groessere.append(akt);
            }
            liste.remove();
        }
        quickSort(kleinere); quickSort(groessere);
        liste.concat(kleinere);
        liste.append(pivot);
        liste.concat(groessere);
    }
}